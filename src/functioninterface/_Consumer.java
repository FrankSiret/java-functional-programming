package functioninterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
	public static void main(String []args) {
		// Normal java function
		Customer juan = new Customer("Juan", "99999");
		greetCustomer(juan);
		
		// Consumer Functional interface
		greetCustomerConsumer.accept(juan);
		
		greetCustomerConsumerV2.accept(juan, false);
	}
	
	static Consumer<Customer> greetCustomerConsumer = customer -> 
			System.out.println("Hello " + customer.customerName 
					+ ", thanks for registing phone number " 
					+ customer.customerPhoneNumber); 
			
	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showNumber) -> 
			System.out.println("Hello " + customer.customerName 
					+ ", thanks for registing phone number " 
					+ (showNumber ? customer.customerPhoneNumber : "***")); 
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName 
				+ ", thanks for registing phone number " 
				+ customer.customerPhoneNumber);
	}
	
	static class Customer {
		private final String customerName;
		private final String customerPhoneNumber;
		public Customer(String customerName, String customerPhoneNumber) {
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}		
	}
}
