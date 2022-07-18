package com.acmeFresh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeFresh.dao.OrdersDao;
import com.acmeFresh.dao.ProductDao;
import com.acmeFresh.dao.UserDetailsDao;
import com.acmeFresh.entity.Orders;
import com.acmeFresh.entity.Product;
import com.acmeFresh.entity.Transactions;
import com.acmeFresh.entity.UserDetails;
import com.acmeFresh.globalExceptionHandler.AnyException;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerServiceIntr {
	
	@Autowired
	private UserDetailsDao userDao;
	@Autowired
	private ProductDao product;
	@Autowired
	private TransactionImpl transI;
	@Autowired
	private OrdersDao orderD;
	
	@Override
	public String userRagister(UserDetails user) {
		//convert into hashcode from normal password form.
		Integer pass= user.getPassword().hashCode();
		//bind the hashcode value to the object and save in database.
		user.setPassword(String.valueOf(pass));
		userDao.save(user);
		return "user ragistration sucessfully";
	}
	@Override
	public Orders buyItem(List<Integer> id,UserDetails userD) throws AnyException {	
		List<Product> products=product.findAllById(id);
		if(products.size()==0) {
			throw new AnyException("Please choose right product id");
		}
		Double price=0.0;
		for(Product p:products) {
			price+=p.getPrice()-p.getPrice()*p.getDiscount()/100;
		}
		String tranId=RandomString.make(8);
		Transactions transactions=transI.getTransaction(price, tranId);
		
		Orders orders=new Orders();
		orders.setCustomerId(userD);
		orders.setProduct(products);
		orders.setTrasactionId(tranId);
		orders.setTransaction(transactions);
		return orderD.save(orders);
	}

}
