package Journey;

import Sprites.Player;
import java.util.Scanner;

public class Pathways {
    Player player = new Player("tempname",100,"Spork");
    Scanner in = new Scanner(System.in);
    public void startGame(){
        introToGame();
    }//end of start game class

    /**
     * Game Introduction
     */
    public void introToGame(){
        String text = "Hey..wake up..it's time for your journey..what's your name?\n";
        for(int i=0; i<text.length();i++){

            System.out.print(text.charAt(i));
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Enter Name:");
        String characterName = in.nextLine();
        player.setName(characterName);

        System.out.printf("Hi %s, nice to meet you..well..we'll meet soon anyway,\nI'll be waiting at the door for you!", player.getName());
        next();
    }//End of intro class


    /**
     * This method to move onto the next line of text
     */
    public void next(){
        System.out.println("\nPress any key to continue.");
        in.nextLine();
    }

    //Create Road section

    //Create Grassy Section

    //Keep on Road section



}//End of Journey Class
