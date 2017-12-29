package in.javahome.customer.service;

import java.util.HashMap;
import java.util.Map;
public class CustomerService {
	private static Map<Integer, String> customers = new HashMap<>();
	static {
		customers.put(1, "Citi Bank");
		customers.put(2, "JPMorgan");
		customers.put(3, "Morgan stanly");
	}
	public static String getCustomer(int custId) {
		if(!customers.containsKey(custId)) {
			return "Customer with "+custId+" not found";
		}
		return customers.get(custId);
	}
}
