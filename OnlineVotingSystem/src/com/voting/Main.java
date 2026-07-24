package com.voting;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        VotingSystem system = new VotingSystem();

		        while (true) {

		            System.out.println("\n===== Online Voting System =====");
		            System.out.println("1. Register");
		            System.out.println("2. Login and Vote");
		            System.out.println("3. Show Result");
		            System.out.println("4. Exit");

		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();

		            switch (choice) {

		                case 1:
		                    system.register();
		                    break;

		                case 2:
		                    User user = system.login();

		                    if (user != null) {
		                        system.vote(user);
		                    }
		                    break;

		                case 3:
		                    system.showResult();
		                    break;

		                case 4:
		                    System.out.println("Thank You!");
		                    sc.close();
		                    System.exit(0);

		                default:
		                    System.out.println("Invalid Choice.");
		            }
		        }

	}

}
