package training;

public class Customers {
	
	String id;
	String name;
	
	public void saveCustomer(String id, String name) {
	      System.out.println("Customer has been saved successfully");
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
