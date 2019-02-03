package com.psapi.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonService extends DatabaseService {

	@GET
	@Path("search/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersonWithName(@PathParam("name") String name) {
		return getAllPersonsWithName(name);
	}

	@GET
	@Path("fruit/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFruitWithName(@PathParam("name") String name) {
		return getAllFruitsWithName(name);
	}

}