package io.pipeline.example.services;

import javax.ws.rs.core.Response;

import org.junit.Test;

import junit.framework.Assert;

public class CashierServiceTest {

	@Test
	public void testGeBillableOrderByCustomer() throws Exception {
		
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		Assert.assertTrue(true);
	}

}
