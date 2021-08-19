package fp;

import static fp.Main.Gender.FEMALE;
import static fp.Main.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		List<Person> people = List.of(
			new Person("John", MALE),
			new Person("Alex", MALE),
			new Person("Maria", FEMALE),
			new Person("Will", MALE),
			new Person("Alice", FEMALE),
			new Person("Frank", MALE),
			new Person("Taylor", FEMALE)
		);
		
		System.out.println("// Imperative approach");
		List<Person> females = new ArrayList<>();
		for(Person person: people) {
			if(FEMALE.equals(person.gender)) 
				females.add(person);
		}
		for(Person female: females) {
			System.out.println(female);
		}
		
		System.out.println("// Declarative approach");
		people.stream()
			.filter(person -> FEMALE.equals(person.gender))
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
	
	static class Person {
		private final String name;
		private final Gender gender;
		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}
	
	enum Gender {
		MALE, FEMALE
	}
}
