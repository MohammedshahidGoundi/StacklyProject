package com.movie;
import java.util.Scanner;

public class Theatre {

	    String theatreName;
	    String movieName;

	    boolean[][] seats = new boolean[5][5];

	    int ticketPrice = 200;
	    int bookedSeats = 0;

	    String[] bookedTicketSeats = new String[5];

	    Scanner sc = new Scanner(System.in);

	    public Theatre(String theatreName, String movieName)
	    {
	        this.theatreName = theatreName;
	        this.movieName = movieName;
	    }
	    
	    // Show Seats
	    
	    public void showSeats()
	    {
	        System.out.println("\n\t\tSCREEN");
	        System.out.println("================================");

	        System.out.print("    ");

	        for(int i=1;i<=5;i++)
	        {
	            System.out.print(i+" ");
	        }

	        System.out.println();

	        for(int i=0;i<5;i++)
	        {
	            char row = (char)('A'+i);

	            System.out.print(row+"   ");

	            for(int j=0;j<5;j++)
	            {
	                if(seats[i][j]==false)
	                {
	                    System.out.print("O ");
	                }
	                else
	                {
	                    System.out.print("X ");
	                }
	            }

	            System.out.println();
	        }

	        System.out.println("================================");
	    }
	    
	    //Book Ticket
	    
	    public void bookTicket()
	    {
	        System.out.print("Enter Number of Tickets : ");
	        int tickets = sc.nextInt();

	        if(tickets<=0)
	        {
	            System.out.println("Invalid Number of Tickets.");
	            return;
	        }

	        if(tickets>5)
	        {
	            System.out.println("Maximum 5 Tickets Allowed.");
	            return;
	        }

	        for(int i=0;i<tickets;i++)
	        {
	        	System.out.print("Enter Seat " + (i + 1) + " (Example A1) : ");
	        	String seat = sc.next().toUpperCase();

	        	if(seat.length() != 2)
	        	{
	        	    System.out.println("Invalid Seat Format.");
	        	    i--;
	        	    continue;
	        	}

	        	char row = seat.charAt(0);
	        	int col = Character.getNumericValue(seat.charAt(1));

	            int rowIndex = row - 'A';
	            int colIndex = col - 1;

	            if(rowIndex<0 || rowIndex>=5 || colIndex<0 || colIndex>=5)
	            {
	                System.out.println("Invalid Seat.");
	                i--;
	                continue;
	            }

	            if(seats[rowIndex][colIndex])
	            {
	                System.out.println("Seat Already Booked.");
	                i--;
	                continue;
	            }

	            seats[rowIndex][colIndex] = true;
	            bookedSeats++;

	            bookedTicketSeats[i] = seat;
	        }

	        int total = tickets * ticketPrice;

	        System.out.println("\n==============================");
	        System.out.println("       MOVIE TICKET");
	        System.out.println("==============================");

	        System.out.println("Theatre : " + theatreName);
	        System.out.println("Movie    : " + movieName);

	        System.out.print("Seats    : ");

	        for(int i=0;i<tickets;i++)
	        {
	            System.out.print(bookedTicketSeats[i]+" ");
	        }

	        System.out.println();

	        System.out.println("Tickets  : " + tickets);
	        System.out.println("Price    : ₹" + ticketPrice);
	        System.out.println("Total    : ₹" + total);

	        System.out.println("Enjoy Your Movie!");
	        System.out.println("==============================");
	    }
	    
	    // Cancel Ticket
	    
	    public void cancelTicket()
	    {
	        System.out.print("Enter Number of Tickets to Cancel : ");
	        int tickets = sc.nextInt();

	        if(tickets<=0)
	        {
	            System.out.println("Invalid Number of Tickets.");
	            return;
	        }

	        for(int i=0;i<tickets;i++)
	        {
	            System.out.print("Enter Seat " + (i+1) + " (Example A1) : ");
	            String seat = sc.next().toUpperCase();

	            if(seat.length()!=2)
	            {
	                System.out.println("Invalid Seat Format.");
	                i--;
	                continue;
	            }

	            char row = seat.charAt(0);
	            int col = Character.getNumericValue(seat.charAt(1));

	            int rowIndex = row - 'A';
	            int colIndex = col - 1;

	            if(rowIndex<0 || rowIndex>=5 || colIndex<0 || colIndex>=5)
	            {
	                System.out.println("Invalid Seat.");
	                i--;
	                continue;
	            }

	            if(!seats[rowIndex][colIndex])
	            {
	                System.out.println("Seat is Not Booked.");
	                i--;
	                continue;
	            }

	            seats[rowIndex][colIndex] = false;
	            bookedSeats--;
	        }

	        int refund = tickets * ticketPrice;

	        System.out.println("Tickets Cancelled Successfully.");
	        System.out.println("Refund Amount : ₹" + refund);
	    }
	    
	    // Booking Summary
	    
	    public void bookingSummary()
	    {
	        int availableSeats = 25 - bookedSeats;

	        System.out.println("\n==============================");
	        System.out.println("      BOOKING SUMMARY");
	        System.out.println("==============================");

	        System.out.println("Theatre : " + theatreName);
	        System.out.println("Movie    : " + movieName);

	        System.out.println("Total Seats     : 25");
	        System.out.println("Booked Seats    : " + bookedSeats);
	        System.out.println("Available Seats : " + availableSeats);

	        System.out.println("Ticket Price    : ₹" + ticketPrice);

	        System.out.println("==============================");
	    }

}

