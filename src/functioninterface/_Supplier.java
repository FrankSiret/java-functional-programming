package functioninterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
	public static void main(String []args) {
		System.out.println(getDBConnectionUrls.get());		
	}
	
	static Supplier<List<String>> getDBConnectionUrls = () -> List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
}
