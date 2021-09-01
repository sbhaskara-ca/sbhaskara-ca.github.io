package io.pipeline.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class CutomerService {

	
	@GET
	@Path("/customer/{customerid}/orders/summary")
	public Response getOrderSummaryByCustomer(@PathParam("customerid") String customerId) {
		System.out.println(System.getenv("CONNECTALL_HOME"));
		System.out.println(System.getenv("CONNECTALL1_HOME"));
		return Response.ok().build();
		
	}
	
	
	@GET
	@Path("/customer/{customerid}/orders/final")
	public Response geBillableOrderByCustomer(@PathParam("customerid") String customerId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return Response.ok().build();
	}
	
	
	
}
