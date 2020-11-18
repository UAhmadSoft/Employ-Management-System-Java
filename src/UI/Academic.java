package UI;

////package employManagementSystem;

import java.util.Scanner;

public class Academic extends Employ{

public Academic() {
		super();
		// TODO Auto-generated constructor stub
	}

private float courseRate;

public Academic(int id, String name, int age, float salary, float cRate)
{
	super(id,name,age,salary);
	this.courseRate=cRate;
}

public float getCourseRate() {
	
	
	return courseRate;
}

public void setCourseRate(float courseRate) {
	this.courseRate = courseRate;
}

public float computeSalary()
{
	
	return 0;	
}
public void createNewEmploy()
{
	
	Scanner s=new Scanner(System.in);
	System.out.println("Enter course");
	this.courseRate=s.nextFloat();
	
}

public boolean equals(Employ obj) {
	if(super.equals(obj) == true ) 	
		return true;
	return false;
}

}
