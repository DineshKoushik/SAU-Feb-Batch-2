package com.au.Rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class Controller {
	
	@Path("/")
	public String function() {
		
		return "Welcome to Rest Web Service";
		
	}
	
	
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	@Path("/{name}")
	public String function(@Context HttpHeaders header, @PathParam("name") String name) {
		
		return "Hello" + name;
		
	}

}