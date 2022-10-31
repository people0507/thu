package Ex2;

public abstract class  Person {
	private String ID, Name, ClassID;
	public abstract String Rank();

	public Person() {
		super();
	}
	

	public Person(String iD, String name, String classID) {
		super();
		ID = iD;
		Name = name;
		ClassID = classID;
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

	public String getClassID() {
		return ClassID;
	}

	public void setClassID(String classID) {
		ClassID = classID;
	}
	
	
}
