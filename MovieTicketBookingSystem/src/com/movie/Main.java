package com.movie;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String theatres[] = {
		        "PVR Cinemas",
		        "Srinivas Theatre",
		        "Cinepolis"
		};

		String movies[][] = {
		        {"Superman","Jurassic World","Toxic"},
		        {"King","Coolie","Spiderman"},
		        {"War 2","Avengers","The Conjuring"}
		};
		
		while(true)
		{
		    System.out.println("\n==============================");
		    System.out.println("MOVIE TICKET BOOKING SYSTEM");
		    System.out.println("==============================");

		    System.out.println("1. PVR Cinemas");
		    System.out.println("2. Srinivas Theatre");
		    System.out.println("3. Cinepolis");
		    System.out.println("4. Exit");

		    System.out.print("Enter Your Choice : ");
		    int theatreChoice = sc.nextInt();

		    if(theatreChoice==4)
		    {
		        System.out.println("Thank You!");
		        break;
		    }

		    if(theatreChoice<1 || theatreChoice>3)
		    {
		        System.out.println("Invalid Choice");
		        continue;
		    }

		    int theatreIndex = theatreChoice-1;
		    
		    System.out.println("\nSelect Movie");

		    for(int i=0;i<3;i++)
		    {
		        System.out.println((i+1)+". "+movies[theatreIndex][i]);
		    }

		    System.out.println("4. Back");

		    System.out.print("Enter Your Choice : ");
		    int movieChoice = sc.nextInt();

		    if(movieChoice==4)
		    {
		        continue;
		    }

		    if(movieChoice<1 || movieChoice>3)
		    {
		        System.out.println("Invalid Choice");
		        continue;
		    }

		    Theatre theatre = new Theatre(
		            theatres[theatreIndex],
		            movies[theatreIndex][movieChoice-1]
		    );
		    
		    while(true)
		    {
		        System.out.println("\n==============================");
		        System.out.println("1. Show Seats");
		        System.out.println("2. Book Ticket");
		        System.out.println("3. Cancel Ticket");
		        System.out.println("4. Booking Summary");
		        System.out.println("5. Change Movie");
		        System.out.println("6. Change Theatre");
		        System.out.println("7. Exit");
		        System.out.println("==============================");

		        System.out.print("Enter Your Choice : ");
		        int ch = sc.nextInt();

		        switch(ch)
		        {
		            case 1:
		                theatre.showSeats();
		                break;

		            case 2:
		                theatre.bookTicket();
		                break;

		            case 3:
		                theatre.cancelTicket();
		                break;

		            case 4:
		                theatre.bookingSummary();
		                break;

		            case 5:
		                break;

		            case 6:
		                break;

		            case 7:
		                System.out.println("Thank You!");
		                System.exit(0);

		            default:
		                System.out.println("Invalid Choice");
		        }

		        if(ch==5)
		        {
		            break;
		        }

		        if(ch==6)
		        {
		            break;
		        }
		    }

	}

	}
}
