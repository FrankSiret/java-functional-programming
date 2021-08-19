package fp;

import static fp.Main.Gender.FEMALE;
import static fp.Main.Gender.MALE;
import static fp.Main.Gender.OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
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
			new Person("Taylor", FEMALE),
			new Person("Sandy", OTHER)
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
		Predicate<Person> isFemale = person -> FEMALE.equals(person.gender);
		people.stream()
			.filter(isFemale)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("// Map");
		people.stream()
			.map(person -> person.name)
			.collect(Collectors.toSet()) // remove duplicate
			.forEach(System.out::println);
		
		System.out.println("// MapToInt");
		Function<Person, String> personName = person -> person.name;
		ToIntFunction<String> length = String::length;
		IntConsumer println = System.out::println;
		people.stream()
			.map(personName)
			.mapToInt(length)
			.forEach(println);
		
		System.out.println("// All Match");
		Predicate<Person> malePersonPredicate = person -> MALE.equals(person.gender);
		boolean constainsOnlyMale = people.stream()
			.allMatch(malePersonPredicate);
		System.out.println(constainsOnlyMale);
		
		System.out.println("// Any Match");
		boolean constainsAnyMale = people.stream()
			.anyMatch(malePersonPredicate);
		System.out.println(constainsAnyMale);
		
		System.out.println("// None Match");
		System.out.println(people.stream()
			.noneMatch(malePersonPredicate));

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
		MALE, FEMALE, OTHER
	}
}
