package busReserve;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class BusDAO {
     public void displayBusInfo() throws Exception {
    	   Connection con =  DbConnection.getConnection();
    	   Statement st = con.createStatement();
    	   ResultSet rs=st.executeQuery("Select * from Bus;");
    	   
    	   while(rs.next()) {
    		   System.out.println("Bus_No:"+ rs.getInt(1));
    		   if(rs.getInt(2)==1) System.out.println("AC:Yes");
    		   else System.out.println("AC:No");
    		   System.out.println("Capacity:"+rs.getInt(3));
    	   }
     }

	   public int getCapacity(int id) throws Exception{
		   String query = "select capacity from Bus where id="+id;
		   Connection con = DbConnection.getConnection();
		   Statement st = con.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   rs.next();
		   return rs.getInt(1);
	   }
	 }

