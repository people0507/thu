package KT;

public class Phone extends Product {
	private double Price;
	private int Amount , Year;
	private String Company;
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Phone(String iD, String name, double price, int amount, int year, String company) {
		super(iD, name);
		Price = price;
		Amount = amount;
		Year = year;
		Company = company;
	}
	public Phone(String iD, String name) {
		super(iD, name);
	}
	
	public double total() {
		return Amount*Price;
	}
	
}
