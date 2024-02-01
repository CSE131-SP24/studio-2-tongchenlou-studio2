package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start amount?");
		int startAmount = in.nextInt();
		System.out.println("Win chance?");
		double winChance = in.nextDouble();
		System.out.println("Win limit?");
		int winLimit = in.nextInt();
		System.out.println("Total days?");
		int totalSimulations = in.nextInt();
		int counter2 = 0;
		for(int days = 1; days <= totalSimulations; days++) {
			int counter = 0;
			int money = startAmount;
			while(money>0&&money<winLimit) {
				double roll = Math.random();
				if(roll<winChance) {
					money++;
					counter++;
				}
				else {
					money--;
					counter++;
				}
			}
			if(money==0) {
				System.out.println("Simulation " + days + ": " + counter + " LOSS");
				counter2++;
			}
			else {
				System.out.println("Simulation " + days + ": " + counter + " WIN");
			}
		}
		double ruinrate = (double)counter2/totalSimulations;
		System.out.println("Losses: " + counter2 + " Similations: " + totalSimulations);
		double expectedRuin = 0;
		if (winChance == 0.5) {
			expectedRuin = 1 - ((double)startAmount/winLimit);
			
		}
		else {
			double alpha = (1-winChance)/winChance;
			expectedRuin = (Math.pow(alpha,startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + ruinrate + " Expected Ruin Rate: " + expectedRuin);


	}

}
