package com.psapi.webservice;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.psapi.person.Person;

/**
 * @author Stefan Gohlke
 */
public class DatabaseService {

	private List<Person> persons = new ArrayList<>();
	private Gson gson = new Gson();

	@Context
	ServletContext servletContext;

	private InputStream getDatabaseFile() {
		return servletContext.getResourceAsStream("/WEB-INF/classes/database.json");
	}

	public String getAllPersons() {
		return getAllPersons(null);
	}

	public String getAllPersons(InputStream dbinput) {
		initDB(dbinput);
		return gson.toJson(this.persons);
	}

	public String getAllPersonsWithName(String name) {
		return getAllPersonsWithName(null, name);
	}

	public String getAllPersonsWithName(InputStream dbinput, String name) {
		initDB(dbinput);
		List<Person> resultList = this.persons.stream().filter(person -> person.fitsPersonSearch(name))
				.collect(Collectors.toList());
		return resultList.isEmpty() ? "" : gson.toJson(resultList);
	}

	public String getAllFruitsWithName(String name) {
		return getAllFruitsWithName(null, name);
	}

	public String getAllFruitsWithName(InputStream dbinput, String name) {
		initDB(dbinput);
		List<String> resultList = this.persons.stream().filter(person -> person.fitsPersonSearch(name))
				.map(person -> person.getFruit()).collect(Collectors.toList());
		return resultList.isEmpty() ? "" : gson.toJson(resultList);
	}

	public void initDB(InputStream dbinput) {
		if (this.persons.isEmpty()) {
			Type type = new TypeToken<List<Person>>() {
			}.getType();
			this.persons = gson.fromJson(
					new InputStreamReader(dbinput != null ? dbinput : getDatabaseFile(), StandardCharsets.UTF_8), type);
		}
	}

	public List<Person> getPersons() {
		return this.persons;
	}

}
