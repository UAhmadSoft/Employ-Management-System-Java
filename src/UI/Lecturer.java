package UI;

//package employManagementSystem;

import java.util.Scanner;

public class Lecturer extends Academic{
	
	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int totalCourses;
	

	public Lecturer(int id,String name,int age,float salary,int tCourses,float cRate)
	{
		super(id,name,age,salary,cRate);
		this.totalCourses=tCourses;
		
	}


	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	
	public void createNewEmploy()
	{
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter TotalCourses");
		this.totalCourses=s.nextInt();
		
	}
	
	public String toString() {
		
		
		System.out.println("Lecturer");
		String str;
		str="\n\nEmploy's ID   \t" +getId()+"\nEmploy's Name \t"+getName()+"\nEmploy's Age  \t  "+getAge()+"\nEmploy's Basic Salary \t"+getBasicSalary()+"\nEmploy's Course Rate  \t "+getCourseRate()+"\nEmploy's Total Courses \t"+getTotalCourses();
		//
		return str;
			
	}
	
	public boolean equals(Employ obj) {
		if(super.equals(obj) == true && this.isLecturer() == obj.isLecturer()) 	
			return true;
		return false;
	}
	
	public String dataForFile(){
		String str;
		
		str="Lecturer "+getName()+" "+getId()+" "+getAge()+" "+getBasicSalary()+" "+getCourseRate()+" "+getTotalCourses()+"\n";
		
		
		
		return str;
	}
	
	public float computeSalary(){
		
		return (getBasicSalary() + getCourseRate() ) * totalCourses ;
		
	}
	
	public boolean isLecturer() {
		
		return true;
	}
	
}
