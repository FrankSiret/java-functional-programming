package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {

	public static void main(String []args) {
		Customer customer = new Customer(
			"Alice",
			"alice@gmail.com",
			"+0616816125",
			LocalDate.of(2000, 1, 1)
		);
		
		CustomerValidatorService validatorService = new CustomerValidatorService();
		System.out.println(validatorService.isValid(customer));
		
		// Using combinator pattern
		ValidationResult result = CustomerRegistrationValidator.isEmailValid()
			.and(CustomerRegistrationValidator.isPhoneNumberValid())
			.and(CustomerRegistrationValidator.isAdult())
			.apply(customer);
		
		System.out.println(result);
		
		if(result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
	}
}
