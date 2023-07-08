package dao;

import model.Login;


import java.sql.*;

import connectionmanager.Connectionmanager;

public class LoginDAO {

	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username=login.getUsername();
		String password=login.getPassword();
		
		Connectionmanager conm= new Connectionmanager();
		Connection con=conm.establishConnection();	
		
		// Statement class
		Statement st=con.createStatement();
		//ResultSet class
		ResultSet rt=st.executeQuery("select * from login");
		while(rt.next())
		{
		
		  if(username.equals(rt.getString("username") )&& password.equals(rt.getString("password")))
		    {
			conm.closeConnection();
			return true;
		    }
	    }
		     conm.closeConnection();
			 return false;
	}
}
