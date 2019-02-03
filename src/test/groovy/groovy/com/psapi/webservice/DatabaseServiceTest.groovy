package groovy.com.psapi.webservice

import com.psapi.person.Person
import com.psapi.webservice.DatabaseService

import spock.lang.Specification

/**
 * @author Stefan Gohlke
 */
class DatabaseServiceTest extends Specification {
	def "test initDB"() {
		given:
		DatabaseService dbservice = new DatabaseService()
		InputStream is = new FileInputStream("src/main/resources/database.json")

		when:
		dbservice.initDB(is)

		then:
		notThrown(Exception.class)
	}

	def "test getPersons"() {
		given:
		DatabaseService dbservice = new DatabaseService()
		InputStream is = new FileInputStream("src/main/resources/database.json")
		List<Person> persons

		when:
		persons = dbservice.getPersons()

		then:
		notThrown(Exception.class)
		persons.isEmpty()

		when:
		dbservice.initDB(is)
		persons = dbservice.getPersons()

		then:
		notThrown(Exception.class)
		!persons.isEmpty()

		for (Person person in persons) {
			person.getId() != null && !person.getId().isEmpty()
		}
	}

	def "test getAllPersons"() {
		given:
		DatabaseService dbservice = new DatabaseService()
		InputStream is = new FileInputStream("src/main/resources/database.json")

		when:
		String personsJson = dbservice.getAllPersons(is)

		then:
		notThrown(Exception.class)
		personsJson != null && !personsJson.isEmpty()
	}

	def "test getAllPersonsWithName"() {
		given:
		DatabaseService dbservice = new DatabaseService()
		InputStream is = new FileInputStream("src/main/resources/database.json")
		String personsJson

		when:
		personsJson = dbservice.getAllPersonsWithName(is, "arm")

		then:
		notThrown(Exception.class)
		!personsJson.isEmpty()

		when:
		personsJson = dbservice.getAllPersonsWithName(is, "atesta")

		then:
		notThrown(Exception.class)
		personsJson.isEmpty()
	}

	def "test getAllFruitsWithName"() {
		given:
		DatabaseService dbservice = new DatabaseService()
		InputStream is = new FileInputStream("src/main/resources/database.json")
		String fruitJson

		when:
		fruitJson = dbservice.getAllFruitsWithName(is, "arm")

		then:
		notThrown(Exception.class)
		!fruitJson.isEmpty()

		when:
		fruitJson = dbservice.getAllFruitsWithName(is, "atesta")

		then:
		notThrown(Exception.class)
		fruitJson.isEmpty()
	}
}
