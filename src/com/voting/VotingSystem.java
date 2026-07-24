package com.voting;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VotingSystem {

    private HashMap<String, User> users = new HashMap<>();
    private HashMap<Integer, Candidate> candidates = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    public VotingSystem() {

        candidates.put(1, new Candidate("Shahid"));
        candidates.put(2, new Candidate("Raj"));
        candidates.put(3, new Candidate("Om"));
    }
    
    public void register() {

        System.out.print("Enter Username: ");
        String username = sc.next();

        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.next();

        users.put(username, new User(username, password));

        System.out.println("Registration Successful.");
    }
    
    public User login() {

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        if (!users.containsKey(username)) {
            System.out.println("User not found.");
            return null;
        }

        User user = users.get(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect Password.");
            return null;
        }

        System.out.println("Login Successful.");

        return user;

}
    
    public void vote(User user) {

        if (user.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }

        System.out.println("\nCandidate List");
        System.out.println("1. Shahid");
        System.out.println("2. Raj");
        System.out.println("3. Om");

        System.out.print("Enter Candidate Number: ");
        int choice = sc.nextInt();

        if (candidates.containsKey(choice)) {

            Candidate candidate = candidates.get(choice);
            candidate.addVote();

            user.setVoted(true);

            System.out.println("Vote Cast Successfully.");

        } else {
            System.out.println("Invalid Candidate.");
        }
    }
        
        public void showResult() {

            Candidate winner = null;

            System.out.println("\n===== Election Result =====");

            for (Candidate candidate : candidates.values()) {

                System.out.println(candidate.getName() + " : " + candidate.getVotes());

                if (winner == null || candidate.getVotes() > winner.getVotes()) {
                    winner = candidate;
                }
            }

            if (winner != null) {
                System.out.println("Winner : " + winner.getName());
            }
       
    }
}
