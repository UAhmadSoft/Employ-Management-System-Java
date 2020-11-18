package UI;

//package employManagementSystem;

public class SecurityGuard extends NonAcademic{
		
		private int totalHours;
		
		
		
		
		public SecurityGuard(int id, String name, int age, float salary, int tHours, float hRate)
		{
			super(id,name,age,salary,hRate);
			this.totalHours=tHours;
		}
		
		
		
		public SecurityGuard() {
			super();
			// TODO Auto-generated constructor stub
		}



		public int getTotalHours() {
			return totalHours;
		}
	
		public void setTotalHours(int totalHours) {
			this.totalHours = totalHours;
		}
		
	public String toString() {
			
			
			System.out.println("Security Guard.");
			String str;
			
			str="\nEmploy's ID   :\t " +getId()+"\nEmploy's Name :\t"+getName()+"\nEmploy's Age :\t"+getAge()+"\nEmploy's Basic Salary :\t"+getBasicSalary()+"\nEmploy's Course Rate :\t"+getHourlyRate()+"\nEmploy's Total Courses :\t"+getTotalHours();
			
			
			return str;		
		}
	
	public float computeSalary(){
		
		return (getBasicSalary() + getHourlyRate() )* totalHours ;
		
	}
	
	public String dataForFile(){
		String str;
		
		str="securityGuard "+getName()+" "+getId()+" "+getAge()+" "+getBasicSalary()+" "+getHourlyRate()+" "+getTotalHours()+"\n";
		
		
		
		return str;
	}
	
	public boolean isLecturer() {
		
		return false;
	}

	
	public boolean equals(Employ obj) {
		if(super.equals(obj) == true && this.isLecturer() == obj.isLecturer()) 	
			return true;
		return false;
	}

}
