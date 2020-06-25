package java8.ex01;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_01_Test {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Optional_01_Test.class);

	class NotPresentException extends RuntimeException {

	}

	@Test
	public void test_optional_ifPresent() throws Exception {

		List<Person> persons = Data.buildPersonList(100);

		// TODO rechercher dans la liste ci-dessus la 1ère personne ayant 18 ans
		// TODO utiliser la méthode "findFirst"
		Optional<Person> optPerson = persons.stream().filter(p -> p.getAge() == 18).findFirst();
		assertThat(optPerson.isPresent(), is(true));

		// TODO afficher la personne en question si l'optional contient une personne
		optPerson.ifPresent(p->LOG.info(""+p));
	}

	@Test(expected = NotPresentException.class)
	public void test_optional_notPresent() throws Exception {
		List<Person> persons = Data.buildPersonList(50);

		// TODO rechercher dans la liste ci-dessus la 1ère personne ayant 75 ans
		// TODO utiliser la méthode "findFirst"
		Optional<Person> optPerson = persons.stream().filter(p -> p.getAge() == 75).findFirst();
		assertThat(optPerson.isPresent(), is(false));

		// TODO si la personne n'existe pas, jeter une exception NotPresentException
		// TODO utiliser la méthode "orElseThrow"
		optPerson.orElseThrow(() -> new NotPresentException());

	}
}
