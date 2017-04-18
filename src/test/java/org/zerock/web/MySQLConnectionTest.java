package org.zerock.web;



import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConnectionTest {

	public static void main(String[] args) throws Exception {
		
		//mysql driver 5.x "com.mysql.jdbc.Driver"
		//mysql driver 6.x "com.mysql.cj.jdbc.Driver"	
		
		String className="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/sample_db?useSSL=false"; //나는 ssl에는 안해도 되 ssl이 보안관련되는거라 
		String user="bit92";
		String password="bit92";
		
		Class.forName(className);
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println(con);
		con.close();
		
		
	}
	
}
