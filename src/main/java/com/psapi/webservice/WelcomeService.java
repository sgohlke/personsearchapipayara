package com.psapi.webservice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WelcomeService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getWelcomeMessage() {
		JsonObject json = Json.createObjectBuilder().add("message", "Welcome to Person Search API Payara Version")
				.add("time", DateTimeFormatter.ISO_INSTANT.format(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
				.build();
		return json.toString();
	}
}