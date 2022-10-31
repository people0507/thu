package Test;

public class Phone {
	public String ID, Name, Company;
	public double Price;
	public double Amount;
	public Phone(String iD, String name, String company, double price, double amount) {
		super();
		ID = iD;
		Name = name;
		Company = company;
		Price = price;
		Amount = amount;
	}
	public Phone() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	
}
