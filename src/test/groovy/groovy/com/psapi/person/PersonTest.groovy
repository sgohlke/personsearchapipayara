package groovy.com.psapi.person

import com.psapi.person.Person

import spock.lang.Specification

/**
 * @author Stefan Gohlke
 */
class PersonTest extends Specification {
	def "test setId and getId"() {
		given:
		Person person = new Person()

		when:
		person.setId("abc123")

		then:
		person.getId().equals("abc123")
	}

	def "test getFirstName and setFirstName"() {
		given:
		Person person = new Person()

		when:
		person.setFirstName("abc123")

		then:
		person.getFirstName().equals("abc123")
	}

	def "test getLastName and getLastName"() {
		given:
		Person person = new Person()

		when:
		person.setLastName("abc123")

		then:
		person.getLastName().equals("abc123")
	}

	def "test getEmail and setEmail"() {
		given:
		Person person = new Person()

		when:
		person.setEmail("abc123")

		then:
		person.getEmail().equals("abc123")
	}

	def "test getTags and setTags"() {
		given:
		Person person = new Person()
		String[] tags = new String[2]
		tags[0] = "old"
		tags[1] = "young"

		when:
		person.setTags(tags)

		then:
		person.getTags().equals(tags)
	}

	def "test getRegistered and setRegistered"() {
		given:
		Person person = new Person()

		when:
		person.setRegistered("123")

		then:
		person.getRegistered().equals("123")
	}

	def "test getAbout and setAbout"() {
		given:
		Person person = new Person()

		when:
		person.setAbout("abc123")

		then:
		person.getAbout().equals("abc123")
	}

	def "test  and setAbout"() {
		given:
		Person person = new Person()

		when:
		person.setFruit("abc123")

		then:
		person.getFruit().equals("abc123")
	}

	def "test fitsPersonSearch"() {
		given:
		Person person = new Person()

		when:
		person.setFirstName("Hans")
		person.setLastName("Meier")

		then:
		person.fitsPersonSearch("ans")
		!person.fitsPersonSearch("rei")
	}
}
