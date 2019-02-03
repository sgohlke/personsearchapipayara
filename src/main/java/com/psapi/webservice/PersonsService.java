package com.psapi.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/persons")
public class PersonsService extends DatabaseService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMsg() {
		return getAllPersons();
	}
}