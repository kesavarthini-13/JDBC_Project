package dao;
import java.sql.*;

import connectionmanager.Connectionmanager;
import model.Product;
public class ProductDAO
{
   public void addProduct(Product product) throws ClassNotFoundException, SQLException
   {
	  //1.java and  JDBC connect
	   Connectionmanager conm= new Connectionmanager();
	   Connection con=conm.establishConnection();
	   
	   String sql_query="insert into product(productId,productName,minSellQuantity,price,quantity) values (?,?,?,?,?)";
	   PreparedStatement ps=con.prepareStatement(sql_query);
	   
	   ps.setInt(1,product.getProductId());
	   ps.setString(2,product.getProductName());
	   ps.setInt(3,product.getMinSellQuantity());
	   ps.setInt(4,product.getPrice());
	   ps.setInt(5,product.getQuantity());
	   
	   ps.executeUpdate();

		 
   }
   public void display() throws ClassNotFoundException, SQLException
   {
	   Connectionmanager conm= new Connectionmanager();
	   Connection con=conm.establishConnection();
	// Statement class
			Statement st=con.createStatement();
			//ResultSet class
			ResultSet rt=st.executeQuery("select * from product");
			while(rt.next())
			{
			 System.out.println(rt.getInt("productId")+" |"+rt.getString("productName")+" |"+rt.getInt("minSellQuantity")+" |"+rt.getInt("price")+" |"+rt.getInt("quantity")+" |");
			  
		    }
		   
		   conm.closeConnection(); 
   }
    
}
