// package employManagementSystem

package UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//import java.io.*;
import DB.*;


@SuppressWarnings("unused")
public class Client {
	
	public static void main(String []args)
	{
		DBManager aManager = new DBManager();
		ArrayList<Employ> elist = new ArrayList<Employ>();
		Iterator<Employ> iter;
		Iterator<Lecturer> iter1;
		Iterator<SecurityGuard> iter2;
		
		boolean kk=true;
		while(kk==true) {
			System.out.println("------Enter your choice-------");
			System.out.println("0. Exit.");
			System.out.println("1. Enter New Employ Data.");
			System.out.println("2. Display All Records.");
			System.out.println("3. Sort by Employ Id and Display all records.");
			System.out.println("4. Search Employ By Id and Display Results.");
			System.out.println("5. Compute total salaries to be paid.");
			System.out.println("6. Compute Salaries For Specific Type Of Employ.");
			System.out.println("7. Write All Data To File.");
			System.out.println("8. Read Data To File.");
			System.out.println("R. Read Data From Database.");
			System.out.println("W. Write Data to Database.");
			
			Scanner s =new Scanner(System.in);
			char choice =s.nextLine().charAt(0);
			
			switch(choice)
			{
			case '1':
				System.out.println("Enter your choice for Employ e for Lecturer and s for Security Gaurd");
				
				
				char cc = s.next().charAt(0);
				
				
				if(cc=='e' || cc=='E') {
					//Lecturer
					s.nextLine();
					System.out.println("Enter Lecturer's Name");
					String name = s.nextLine();
					
					
					System.out.println("Enter Lecturer's id");
					int id = s.nextInt();
					
					//Checking Whether id already exists
					
					boolean k = true;
					while(k==true){
						k=false;
						//System.out.println("into while");
						for (int i=0;i<elist.size();i++) {
							if(elist.get(i).getId()==id){
								System.out.println("The ID you entered already Exists bro !!!\nEnter a New One :\n");
								id = s.nextInt();
								k=true;
								break;
							}
							else{
								k=false;
							}								
						}
					
					}
					
					System.out.println("Enter Lecturer's Age");
					int age = s.nextInt();
					
					System.out.println("Enter Lecturer's Basic Salary");
					float salary = s.nextFloat();
					
					System.out.println("Enter Lecturer's Total Courses");
					int tCourses = s.nextInt();
					
					System.out.println("Enter Lecturer's Course Rate");
					float cRate = s.nextFloat();
				
					elist.add(new Lecturer(id,name,age,salary,tCourses,cRate));
				
				}
				else if(cc=='s' || cc=='S'){
					//Security guard
						
					s.nextLine();	
					
					System.out.println("Enter Security guard's Name");	
					String name = s.nextLine();
					
			
					System.out.println("Enter Security guard's id");
					int id = s.nextInt();
					
					//Checking Whether id already exists					
					boolean k = true;
					while(k==true){
						if (elist.size()==0) {
							break;
						}
						for (int i=0;i<elist.size();i++) {
							if(elist.get(i).getId()==id){
								System.out.println("The ID you entered already Exists bro !!!\nEnter a New One :\n");
								id = s.nextInt();
								break;
							}
							else{
								k=false;
							}								
						}						
					}
					
					System.out.println("Enter Security guard's Age");
					int age = s.nextInt();
					
					System.out.println("Enter Security guard's Basic Salary");
					float salary = s.nextFloat();
					
					System.out.println("Enter Security guard's Total Hours");
					int tHours = s.nextInt();
					
					System.out.println("Enter Security guard's Hours Rate");
					float hRate = s.nextFloat();
					
					elist.add(new SecurityGuard(id,name,age,salary,tHours,hRate));
					
					break;
				}
				
					break;
			case '2':
				
				System.out.println("Displaying Records\nTotal Employees are :");
				System.out.println(elist.size());	
				
				/*
				for (int i=0;i<elist.size();i++) {			
					System.out.println(elist.get(i).toString());
				}*/
				
				iter = elist.iterator();
				while(iter.hasNext()) {
					Employ temp = new Employ();
					temp = iter.next();
					
					System.out.println(temp.toString());
					
				}
				
				
				break;
				
				
			case '3':
				//	Sort by Employ id and Display Results				
				Collections.sort(elist, new Comparator<Employ>() {
					  public int compare(Employ u1, Employ u2) {
						  
						  Integer price1 = u1.getId();
						  Integer price2 = u2.getId();
						  return price1.compareTo(price2);
					  }
					});
				
				//	Now Displaying Array

				System.out.println("Displaying Records\nTotal Employees are :");
				System.out.println(elist.size());
				
				iter = elist.iterator();
				while(iter.hasNext()) {
					Employ temp = new Employ();
					temp = iter.next();					
					System.out.println(temp.toString());					
				}
				/*
				System.out.println(elist.size());				
				for (int i=0;i<elist.size();i++) {			
					System.out.println(elist.get(i).toString());
				}*/
			break;	
			case '4':
				//Search Employ by id and Display Results
				System.out.println("Enter Employ's id whom you wanna search");
				int id1 = s.nextInt();
				
				//Checking Whether id already exists							
				iter = elist.iterator();				
				boolean found = false;
				
				while(iter.hasNext()) {
					Employ temp = new Employ();
					temp = iter.next();
					int id2 = temp.getId();
					
					if (id1==id2) {
						System.out.println(temp.toString());
						found=true;						
					}				
					System.out.println(temp.getId());
				}
				
				
				if(found==false){
					System.out.println("Record NOT found !!! \n\n\n");
				}
				
				break;
			
			case '5':
				//	Compute Total Salaries to be paid1
				int totalSalaries=0;
				
				for (Employ em : elist) {
					totalSalaries += em.computeSalary(); 
				}
				
				/*
				for(int i=0;i<elist.size();i++){
					totalSalaries += elist.get(i).computeSalary(); 
				}
				*/
				System.out.println("\n\nTotalSalaries to be paid is :\tRs "+totalSalaries+" /-");
				break;
				
			case '6':
				//Compute Salaries of Specific Type
				float totalSalaries1=0;
				char cho;;
				
				System.out.println("\n\nYou wanna Compute Salaries of Lecturer or Security Guard \n(Enter 0 for Lecturer and 1 for Security Guard)");
				cho = s.next().charAt(0);
				boolean ll = true;
				
				while (ll==true){
					if(cho != '0' && cho != '1'){
						System.out.println("Yaar sahih choice likho Chawalainn na maro . . . \n");
						cho = s.next().charAt(0);
					}
					else{
						ll=false;
						totalSalaries=0;
						float totalSalaries2;
						
						for (Employ em : elist) {
							if (em.isLecturer()==true && cho == '0') {
								 totalSalaries1 += em.computeSalary();
							}
							else if ((em.isLecturer()==false && cho == '1')) {
								 totalSalaries1 = em.computeSalary();
							}
							
						}
						
					}
				}
			
				
				System.out.println("\n\n\nTotal Salaries of you choice are :\tRs"+totalSalaries1+" /-\n\n");
				
				break;
			
			case '7':
				//	Write to File
				
				
				
				Employ e1 = new Employ(12, "ali", 11, (float) 3.4);
				
				try {
					//FileOutputStream f= new FileOutputStream(new File("D:\\Software Engineers Folder\\Eclipse Projects\\Assignment 3.1.1\\myfile"));
					//FileOutputStream f= new FileOutputStream(new File("myfile"));
					ObjectOutputStream o = new ObjectOutputStream(f);
					
					//	Write Objects to File
					
					o.writeObject(elist);
					
					f.close();
					o.close();
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
				System.out.println(e1.toString());
				
				break;
			 
			case '8':
				//	Retrieve from File
				
				
				
				try {
					
					//FileInputStream f2 = new FileInputStream(new File("D:\\Software Engineers Folder\\Eclipse Projects\\Assignment 3.1.1\\myfile"));
					//FileInputStream f2 = new FileInputStream(new File("myfile"));
					ObjectInputStream o2=new ObjectInputStream(f2);
					
					
					//	Write Objects to File
					for (int i = 0; i < elist.size(); i++) {
						elist=  (ArrayList<Employ>) o2.readObject();
					}
					
					//System.out.println(e);
					
					//	Displaying Arraylist Now
					for (int i = 0; i < elist.size(); i++) {
						System.out.println(elist.get(i).toString());
					}
					
					
					f2.close();
					o2.close();
					//Employ e2 = (Employ) o2.readObject();  
				//	System.out.println("ssd");
				///	System.out.println(e2.toString());
					
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				break;
			
				
				
			case '0':
				System.exit(12);
				

			case 'r':
			case 'R':
					
				
				elist =	aManager.viewAuthor();
				
				break;
				
			case 'w':
			case 'W':
				
				
				 if (aManager.writeAuthor(elist) == true ){
					 System.out.println("good");
				 }
				 else{
					 System.out.println("bad");
				 }
				 
				 break;
				
			default :
					System.out.println("Sahih Choice Likho Yaar Chussain na maro !!!");
				
			}//Switch Ended
	}
		
	}
	
}
