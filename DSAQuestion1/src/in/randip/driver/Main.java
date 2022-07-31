package in.randip.driver;

import java.util.Scanner;
import in.randip.service.ConstructFloor;

// Driver class
public class Main {

	public static void main(String[] args) {

		int totalNoOfFloors;
		boolean status;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the total no of floors in the building");
		totalNoOfFloors=scan.nextInt();

		if(totalNoOfFloors > 1) {
			ConstructFloor obj = new ConstructFloor(totalNoOfFloors);

			status=obj.processDayWiseFloorSize();	// get day wise floor size from user and process them
			if(status==true) {
				obj.printOrderOfConstruction(); // print the day wise construction plan
			}			
		}
		else {
			System.out.println("ERROR=> Invalid input for total no of floors in the building: Rerun the program and give valid input");
		}		

		scan.close();

	}

}
