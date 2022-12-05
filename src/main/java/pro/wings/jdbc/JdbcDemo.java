package pro.wings.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
public static void main(String[] args) throws SQLException,ClassNotFoundException {
	
	//LOAD THE DRIVER
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String url="jdbc:mysql://localhost:3306/travelagency";
		 String user="root";
		String pass="root";
		Connection con=DriverManager.getConnection(url,user,pass);
		String q="select * from busdetails";
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(q);
		
		while(set.next())
		{
			int id=set.getInt(1);
			String name=set.getString(2);
			String type=set.getString(3);
			String no=set.getString(4);
			
			System.out.println("Bus_id\t"+id +"Bus_name\t"+name +"Bus_type\t"+type +"Bus_no\t"+no);
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
