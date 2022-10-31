package Ex3;


public class Student {
		private String ID, Name, ClassID;
		private Boolean Gender;
		private double Mark;
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
		
		public Boolean getGender() {
			return Gender;
		}
		public void setGender(Boolean gender) {
			Gender = gender;
		}
		public double getMark() {
			return Mark;
		}
		public void setMark(double mark) {
			Mark = mark;
		}
		
		
		public Student(String iD, String name, String classID, Boolean gender, double mark) {
			super();
			ID = iD;
			Name = name;
			ClassID = classID;
			Gender = gender;
			Mark = mark;
		}
		public Student() {
			super();
		}
		
		public String Rank() {
			String r = "";
			if(Mark >=9 )
				r = "Xuat sac";
			else
				if(Mark >= 8)
					r="Gioi";
				else
					r="Kha";
			
			return r;
		}
	
		
		
	}
	

