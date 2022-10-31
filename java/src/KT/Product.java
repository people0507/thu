package KT;

public abstract class Product {
 private String ID, Name;
 public abstract double total();

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

public Product(String iD, String name) {
	super();
	ID = iD;
	Name = name;
}

public Product() {
	super();
}
 
 
}
