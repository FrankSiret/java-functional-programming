package functioninterface;

import java.util.function.Predicate;

public class _Predicate {
	public static void main(String []args) {
		System.out.println("Without predicate");
		System.out.println(isPhoneNumberValid("07000000000"));
		System.out.println(isPhoneNumberValid("0900000000"));
		
		System.out.println("With predicate");
		System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
		System.out.println(isPhoneNumberValidPredicate.test("0900000000"));
		
		System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003"));
		
		System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("0700000033"));
		
	}
	
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	}
	
	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
			phoneNumber.startsWith("07") && phoneNumber.length() == 11;
			
	static Predicate<String> containsNumber3 = phoneNumber -> 
			phoneNumber.contains("3");
}
