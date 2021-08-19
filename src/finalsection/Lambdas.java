package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
	
	public static void main(String[] args) {
		Function<String, String> upperCaseName = name -> {
			// logic
			if(name.isBlank()) throw new IllegalArgumentException("");
			return name.toUpperCase(); 
		};
		
		BiFunction<String, Integer, String> concatNameAge = (name, age) -> {
			// logic
			if(name.isBlank()) throw new IllegalArgumentException("name not provided");
			if(age == null) throw new IllegalArgumentException("invalid age");
			return name + " " + age; 
		};
		
		System.out.println(concatNameAge.apply("Frank", 25));
	}
	
	
}
