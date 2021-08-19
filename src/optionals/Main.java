package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
	public static void main(String [] args) {
		Object value1 = Optional.ofNullable(null)
			.orElseGet(() -> "default value");
		System.out.println(value1);
		
		Object value2 = Optional.ofNullable("Hello")
				.orElseGet(() -> "default value");
		System.out.println(value2);
		
		Supplier<IllegalStateException> exception = () 
				-> new IllegalStateException("exception");
		Object value3 = Optional.ofNullable("World")
				.orElseThrow(exception);
		System.out.println(value3);
		
		Optional.ofNullable("frank.siret@gmail.com")
				.ifPresent(value -> {
					// stuff here
					System.out.println("My email is: " + value);
				});
		
		Optional.ofNullable(null)
				.ifPresentOrElse(
						value -> {
							// stuff here
							System.out.println("My email is: " + value);
						}, 
						() -> System.out.println("Email not provide"));
	}
}
