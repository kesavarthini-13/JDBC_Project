package connectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmanager
{
     Connection con=null;
     public Connection establishConnection() throws ClassNotFoundException, SQLException 
     {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
 		return con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","1234");
    	 
     }
     
	public void closeConnection() throws SQLException
	{
		con.close();
	}

}
