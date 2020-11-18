package UI;

//package employManagementSystem;

public class NonAcademic extends Employ {
	
	public NonAcademic() {
		super();
		// TODO Auto-generated constructor stub
	}


	private float hourlyRate;

	
	public NonAcademic(int id, String name, int age, float salary, float hRate)
	{
		super(id,name,age,salary);
		this.hourlyRate=hRate;
	}
	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	

	public boolean equals(Employ obj) {
		if(super.equals(obj) == true ) 	
			return true;
		return false;
	}
	

}
