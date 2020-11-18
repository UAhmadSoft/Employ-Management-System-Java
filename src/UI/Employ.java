
package UI;

import java.io.Serializable;
import java.util.Iterator;

public class Employ implements Serializable{
	
	private int id;
	private String name;
	private int age;
	private float basicSalary;
	
	
	public Employ(int id2, String name2, int age2, float salary) {
		
		this.id=id2;
		this.name=name2;
		this.age=age2;
		this.basicSalary=salary;
	}

	
	
	
	public int getId() {
		
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	

	

	public boolean isLecturer() {
		return false;
	}




	public String dataForFile() {
		// TODO Auto-generated method stub
		return null;
	}




	public float getCourseRate() {
		// TODO Auto-generated method stub
		return 0;
	}




	public int getTotalCourses() {
		// TODO Auto-generated method stub
		return 0;
	}




	public void setTotalCourses(int totalCourses) {
		// TODO Auto-generated method stub
		
	}




	public int getTotalHours() {
		// TODO Auto-generated method stub
		return 0;
	}




	public float getHourlyRate() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean equals(Employ obj) {
		if(this.name == obj.name ) 	
			return true;
		return false;
	}




	@Override
	public String toString() {
		return "Employ [id=" + id + ", name=" + name + ", age=" + age + ", basicSalary=" + basicSalary + "]";
	}




	public Employ() {
		super();
	}




	public float computeSalary() {
		// TODO Auto-generated method stub
		return 0;
	}


}
