package jdbcDemo;
import java.sql.*;
public class JdbcConn {

	public static void main(String[] args) throws Exception {
		//ReadQuery();
        //insertQuery();
		//insertUsingPrepareStament();
		//insertvar();
		sp();
	}
	
	public static void ReadQuery() throws Exception {
		String url="jdbc:mysql://localhost:3306/jdbcDemo";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * From student");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString(2));
			System.out.println();
		}
		
		con.close();
		st.close();
		rs.close();
	}
	
	public static void insertQuery() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","1234");
		String query = "Insert into student values(4,'Nattu')";
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected:"+ rows);
		con.close();
		st.close();
	}
	
	public static void insertvar() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","1234");
		int id = 5;
		String name = "Keerthi";
		String query = "Insert into student values("+ id +",'"+ name +"');";
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected:"+ rows);
		con.close();
		st.close();
	}
	
	public static void insertUsingPrepareStament() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","1234");
		int id = 6;
		String name = "Keerthinath";
		String query = "Insert into student values(?,?); ";
		PreparedStatement Pst = con.prepareStatement(query);
		Pst.setInt(1,id);
		Pst.setString(2, name);
		int rows = Pst.executeUpdate();
		System.out.println("Number of rows affected:"+ rows);
		con.close();
		Pst.close();
	}
	
	public static void sp() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","1234");
		CallableStatement cst = con.prepareCall("{call getStudent()}");
		ResultSet rs=cst.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		
		con.close();
		cst.close();
		rs.close();
	}

}
