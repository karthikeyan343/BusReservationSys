package busReserve;
import java.sql.*;
import java.util.Date;
public class BookingDAO {

	public int getBookedCount(int busNo, Date date) throws Exception {
		
		String Query ="select count(passenger_name) from Booking where bus_no=? and travel_date=?"; 
		Connection con = DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(Query);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2,sqlDate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public void addBooking(Booking booking)throws Exception {
		String query="Insert into Booking values(?,?,?);";
		Connection con = DbConnection.getConnection();
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, booking.PassengerName);
		pst.setInt(2,booking.BusNo);
		pst.setDate(3, sqlDate);
		
		pst.executeUpdate();
	}
 
}
