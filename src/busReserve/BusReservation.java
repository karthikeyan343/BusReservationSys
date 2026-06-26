package busReserve;
import java.util.*;
public class BusReservation {

	public static void main(String[] args)throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int userOpt=1;
			BusDAO busdao = new BusDAO();
			busdao.displayBusInfo();
			
			while(userOpt==1) {
				System.out.print("Continue to Booking enter 1 or Press 2 to Exit: ");
				userOpt=sc.nextInt();
				if(userOpt==1) {
					System.out.println("Continue Booking");
					Booking booking = new Booking();
					if(booking.isAvailable()) {
					  BookingDAO bookingdao = new BookingDAO();
					  bookingdao.addBooking(booking);
					  System.out.println("Booking Sucessful");
					}else System.out.println("Try another bus or it with date");
				}
				else {
					return;
				}
				
			}
			
sc.close();
		}
	}

}
