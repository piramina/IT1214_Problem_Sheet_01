import java.util.*;

class Vehicle{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	Vehicle(String licensePlate,String ownerName,int hoursParked){
		this.licensePlate=licensePlate;
		this.ownerName=ownerName;
		this.hoursParked=hoursParked;
	}
	
	String getLicensePlate(){
		return licensePlate;
	}
	void setLicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	
	String getOwnerName(){
		return ownerName;
	}
	void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	
	int getHoursParked(){
		return hoursParked;
	}
	void setHoursParked(int hoursParked){
		this.hoursParked=hoursParked;
	}
}

class ParkingLot{
	Vehicle[] vehicle=new Vehicle[5];
	int count=0;
	

void addVehicle(Vehicle v){
	if(count<vehicle.length){
		vehicle[count++]=v;
	}
	else{
		System.out.println("Parking lot is full");
	}
}

void removeVehicle(String licensePlate){
	boolean found=false;
	for(int i=0; i<count; i++){
		if(vehicle[i].getLicensePlate()==licensePlate){
			for(int j=i; j<count-1; j++){
				vehicle[j]=vehicle[j+1];
			}
			vehicle[--count]=null;
			found=true;
			System.out.println("Vehicle with license plate " + licensePlate + " removed.");
			break;
		}
	}
	if(!found){
		System.out.println("Vehicle with license plate " + licensePlate + " not found.");
	}
}

void displayVehicle(){
	if(count==0){
		System.out.println("No vehicles parked.");
	}
	for(int i=0; i<count; i++){
		System.out.println("Vehicle licensePlate is "+vehicle[i].getLicensePlate());
		System.out.println("Owner name is "+vehicle[i].getOwnerName());
		System.out.println("Parked Hour "+vehicle[i].getHoursParked());
	}
}
}



class Main{
	public static void main(String[] args){
		ParkingLot pl=new ParkingLot();
		pl.addVehicle(new Vehicle("ABC123","John Doe",2));
		pl.addVehicle(new Vehicle("XYZ789","Jane Smith",24));
		pl.addVehicle(new Vehicle("LMN456","Bob Brown",1));
		
		pl.removeVehicle("XYZ789");
		
		pl.displayVehicle();
	}
}
