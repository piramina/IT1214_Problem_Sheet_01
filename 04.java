import java.util.*;

class Ticket{
	int ticketNumber;
	String customerName;
	int seatNumber;
	
	Ticket(int ticketNumber,String customerName,int seatNumber){
		this.ticketNumber=ticketNumber;
		this.customerName=customerName;
		this.seatNumber=seatNumber;
	}
}
		

class BookingSystem{
	Ticket[] movie=new Ticket[10];
	int count=0;
	
	void bookTicket(Ticket t){
		if(count>=movie.length){
			System.out.println("All seats are booked.");
		}else{
			movie[count++]=t;
		}
	}
	
	public void cancelTicket(int ticketNumber){
		boolean found=false;
		for(int i=0; i<count; i++){
			if(movie[i].ticketNumber==ticketNumber){
				for(int j=i; j<count-1; j++){
					movie[j]=movie[j+1];
				}
				movie[--count]=null;
				found=true;
				System.out.println("Ticket Number "+ticketNumber+" is Cancelled.");
				break;
			}
		}
		if(!found){
				System.out.println("Ticket Number "+ticketNumber+" not found.");
			}
	}
	
	public void displayDetails(){
		for(int i=0; i<count; i++){
		System.out.println("Ticket Number: "+movie[i].ticketNumber);
		System.out.println("Customer Name: "+movie[i].customerName);
		System.out.println("Seat Number: "+movie[i].seatNumber);
		}
	}
}


class Main{
	public static void main(String[] args){
		BookingSystem bs=new BookingSystem();
		
		bs.bookTicket(new Ticket(1,"John",1));
		bs.bookTicket(new Ticket(2,"Boe",2));
		bs.bookTicket(new Ticket(3,"John",3));
		
		bs.cancelTicket(2);
		bs.displayDetails();
		
	}
}