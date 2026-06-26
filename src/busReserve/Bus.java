package busReserve;
public class Bus {
 private int Bus_no;
 private boolean AC;
 private int capacity;
 
 Bus(int busNo,boolean ac,int capacity){
	 this.Bus_no=busNo;
	 this.setAC(ac);
	 this.setCapacity(capacity);
 }

 public int getCapacity() {
	return capacity;
 }

 public void setCapacity(int capacity) {
	this.capacity = capacity;
 }

 public boolean isAC() {
	return AC;
 }

 public void setAC(boolean aC) {
	AC = aC;
 }

 public int getBus_no() {
	return Bus_no;
 }
  
}
