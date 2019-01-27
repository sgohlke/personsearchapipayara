package com.psapi.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/persons")
public class PersonsService {

	@Context
	ServletContext servletContext;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMsg() {
		JsonObject json;
		InputStream dbIS = servletContext.getResourceAsStream("/WEB-INF/classes/database.json");

		try (JsonReader jsonReader = Json.createReader(dbIS);) {
			JsonArray jsonArray = jsonReader.readArray();
			return jsonArray.toString();
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String sStackTrace = sw.toString(); // stack trace as a string
			try {
				sw.close();
			} catch (IOException e1) {
				// Ignore
			}

			json = Json.createObjectBuilder().add("message", "Error while reading DB")
					.add("errorMessage", e.getMessage()).add("stackTrace", sStackTrace)
					.add("time", DateTimeFormatter.ISO_INSTANT.format(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
					.build();
			return json.toString();
		}
	}
}