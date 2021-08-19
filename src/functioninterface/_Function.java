package functioninterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String []args) {
		int increment = increment(1);
		// Imperative
		System.out.println(increment);
		
		// Declarative
		int increment2 = incrementByOne.apply(1);
		System.out.println(increment2);
		
		int multiply = multiplyBy10.apply(increment2);
		System.out.println(multiply);
		
		int addMultiply = incrementByOne.andThen(multiplyBy10).apply(1);
		System.out.println(addMultiply);
		
		System.out.println(incrementByOneAndMultiply.apply(4,100));
	}
	
	static Function<Integer, Integer> incrementByOne = number -> number + 1;
	
	static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
	
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (number, multiplyBy) -> (number+1) * multiplyBy;
	
	static int increment(int number) {
		return number + 1;
	}
}
