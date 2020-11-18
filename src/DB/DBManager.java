package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import UI.Employ;
import UI.Lecturer;
import UI.SecurityGuard;

public class DBManager {
	
	public static  ArrayList<Employ> viewAuthor(){
		
		ArrayList<Employ> myList = new ArrayList<Employ>();
		
		DBConnect dbconnect = new DBConnect();
		dbconnect.getConnection("record.accdb");
		Statement statement = dbconnect.getStatement();		
		
		String query1 = "SELECT * from lecturer";
		String query2 = "SELECT * from sguard";
		
		int col1,col3,col6;
		String col2;
		float col4,col5;
		boolean col7;
		
		try {
			ResultSet resultset1=statement.executeQuery(query1);

			while(resultset1.next()) {
				col1 = resultset1.getInt("id");
				col2 = resultset1.getString("Namee");
				col3 = resultset1.getInt("age");
				col4 = resultset1.getFloat("bsalary");
				col5 = resultset1.getFloat("rate");
				col6 = resultset1.getInt("courses");
				
				myList.add(new Lecturer(col1,col2,col3,col4,col6,col5));
				/*System.out.println(col1);System.out.println(col2);System.out.println(col3);System.out.println(col4);System.out.println(col5);System.out.println(col6);System.out.println(col7);*/
				
			}
			
			ResultSet resultset2=statement.executeQuery(query2);
			
			while(resultset2.next()) {
				col1 = resultset2.getInt("id");
				col2 = resultset2.getString("Namee");
				col3 = resultset2.getInt("age");
				col4 = resultset2.getFloat("bsalary");
				col5 = resultset2.getFloat("rate");
				col6 = resultset2.getInt("hrs");
				
				myList.add(new SecurityGuard(col1,col2,col3,col4,col6,col5));	
				/*System.out.println(col1);System.out.println(col2);System.out.println(col3);System.out.println(col4);System.out.println(col5);System.out.println(col6);System.out.println(col7);*/
				
			}
			
			//System.out.println(col1 +"  ." + col2);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnect.disconnect();
		}
		for (int j = 0; j < myList.size(); j++) {
			System.out.println(myList.get(j).toString());
		}
		
		
		return myList;
			
			
		
		
	}
	
	public static boolean writeAuthor(ArrayList<Employ> mylist){
		
		DBConnect dbconnect = new DBConnect();
		
		for (int i = 0; i < mylist.size(); i++) {
			
			dbconnect.getConnection("record.accdb");
			Statement statement = dbconnect.getStatement();		
			int cc=1;
		
			int col1,col3,col6;
			float col4,col5;
			String col2;
			
			col1 = mylist.get(i).getId();
			col3 = mylist.get(i).getAge();
			col2 = mylist.get(i).getName();
			col4 = mylist.get(i).getBasicSalary();
			
			String query;
			
			if(mylist.get(i).isLecturer()==false){	// s guard
				col5 = mylist.get(i).getHourlyRate();
				col6=mylist.get(i).getTotalHours();
				query = "INSERT INTO sguard (id,Namee,age,bsalary,rate,hrs) VALUES ('"+col1 + "', '" + col2  + "', '"+col3 + "', '" + col4 + "', '" + col5 + "', '" +col6 +"');";
				
			}
			else {	//lecturer
				col5 = mylist.get(i).getCourseRate();
				col6=mylist.get(i).getTotalCourses();
				query = "INSERT INTO lecturer (id,Namee,age,bsalary,rate,courses) VALUES ('"+col1 + "', '" + col2  + "', '"+col3 + "', '" + col4 + "', '" + col5 + "', '" +col6 +"');";
				
			}
			
			//System.out.println("executing query on\n" + mylist.get(i).toString()+"\n");
			
			
			try {
				System.out.println("before cc is"+cc);
				cc++;
				
				
				System.out.println(statement.executeUpdate(query));
				
				System.out.println("after cc is"+cc);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				DBConnect.disconnect();
			}
		}
		
		return false;
	}
	
	
	
}
