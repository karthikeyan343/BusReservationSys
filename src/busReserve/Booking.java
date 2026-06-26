package busReserve;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
 String PassengerName;
 int BusNo;
 Date date;
 
 Booking(){
	 Scanner sc = new Scanner(System.in);
	 System.out.print("Enter Passanger Name: ");
	 PassengerName=sc.next();
	 System.out.print("Enter a Bus NO: ");
	 BusNo=sc.nextInt();
	 System.out.print("Enter date dd-MM-yyyy in this Format: ");
	 String dateInput=sc.next();
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 try {
		date = sdf.parse(dateInput);
	} catch (ParseException e) {
		e.printStackTrace();
	}
 }
	 public boolean isAvailable() throws Exception {
		 
		  BusDAO busdao = new BusDAO();
		  BookingDAO bookingdao = new BookingDAO();
		  int capacity= busdao.getCapacity(BusNo);
		  
		  int booked=bookingdao.getBookedCount(BusNo,date);
          
		  return booked<capacity? true:false;
	 
 }
}
