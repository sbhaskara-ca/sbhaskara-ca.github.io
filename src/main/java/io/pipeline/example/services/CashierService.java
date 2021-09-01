package io.pipeline.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/cashier/")
public class CashierService {
	
	
	@GET
	@Path("/customer/{customerid}/orders/summary")
	public Response getOrderSummaryByCustomer(@PathParam("customerid") String customerId) {
		System.out.println(System.getenv("CONNECTALL_HOME"));
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/customer/{customerid}/orders/final")
	public Response geBillableOrderByCustomer(@PathParam("customerid") String customerId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(System.getenv("NEW HOTSPOT"));

		return Response.ok().build();
		
	}
	
	
	@GET
	@Path("/zone/{zoneid}/orders/summary")
	public Response getOrderSummaryByZone(@PathParam("zoneid") String zoneId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/zone/{zoneId}/orders/final")
	public Response geBillableOrderByZone(@PathParam("zoneid") String zoneId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		return Response.ok().build();
	}
	
	@GET
	@Path("/zone/{zoneId}/orders/badcode")
	public Response badcodemethod(@PathParam("zoneid") String zoneId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println(System.getenv("HOT HOT HOT"));
		
		System.out.println(System.getenv("Hello world."));
		
		return Response.ok().build();
	}
	
	@GET
	@Path("/zone/{zoneId}/orders/coffee")
	public Response getcoffee(@PathParam("zoneid") String zoneId) {
		try {
			System.out.println(System.getenv("CONNECTALL_HOME"));
			throw new IllegalArgumentException("Wrong argument");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println(System.getenv("Start the coffee maker!"));
		
		return Response.ok().build();
	}

}
