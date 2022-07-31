package in.randip.service;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ConstructFloor {

	int noOfFloors;
	//ArrayList<Integer>[] arrayDayWise = new ArrayList[noOfFloors];
	ArrayList<Integer>[] arrayDayWise;

	// Constructor
	public ConstructFloor(int noOfFloors) {
		super();
		this.noOfFloors = noOfFloors;
		arrayDayWise = new ArrayList[noOfFloors];
	}

	// collect floor size for each day from user and process it and store the order on  arrayDayWise ArrayList for each day.
	public boolean processDayWiseFloorSize() {
		int maxCurrentFloorSize;
		int floorSizeEachDay;
		int temp;

		maxCurrentFloorSize=noOfFloors;

		Scanner input = new Scanner(System.in);

		Queue<Integer> queue=new PriorityQueue<Integer>(new MyComparator());

		for(int i=0;i<noOfFloors;i++) {
			System.out.println("Enter the floor size given on day : " + (i+1));

			floorSizeEachDay = input.nextInt();
			if(floorSizeEachDay<1) {
				System.out.println("ERROR=> Invalid input size of floor. Rerun the program and give valid input");
				return false;
			}

			queue.add(floorSizeEachDay);

			arrayDayWise[i] = new ArrayList<>();

			// check if current maximum floor size allowed is present in the head of priority queue (entered by user), 
			// if yes then add them in arrayDayWise[day]
			while(!queue.isEmpty() && queue.peek()==maxCurrentFloorSize) {   

				temp=queue.poll();

				arrayDayWise[i].add(temp);
				// System.out.print(temp + " ");  // for debug purpose

				maxCurrentFloorSize--; // Decrease the current maximum floor size once its added into the arrayDayWise[day]

			}

			System.out.println();

		}

		input.close();

		return true;

	}

	// Print Day wise floor size that will be constructed as per input provided by end user
	public void printOrderOfConstruction() {
		System.out.println("The order of construction is as follows\n");
		for(int i=0;i<noOfFloors;i++) {
			System.out.println("Day: " + (i+1));

			// Check and print if in a particular day (stored in arrayDayWise[]) we have floor(s) size that can be constructed 
			if(!arrayDayWise[i].isEmpty()) {

				for(int a : arrayDayWise[i]) {  // fetch all the floor size that is identified for i'th day and print them
					System.out.print(a + " ");
				}
				System.out.print(" (Floor size will be assembled)\n");
			}

			System.out.println();
		}
	}



}
