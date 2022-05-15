package Journey;

import Sprites.Monsters.SmallMonster;
import Sprites.Player;
import java.util.Scanner;

public class Pathways {
    Player player = new Player("tempname",100,"Spork");
    Scanner in = new Scanner(System.in);
    public void startGame(){
        introToGame();

        //Create Road section
        player.fightMonster(new SmallMonster("Rat",35));
        //Create Grassy Section

        //Keep on Road section

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

        System.out.printf("Hi %s, nice to meet you..well..we haven't met yet but we might soon,\nI'll be waiting at the door for you..just follow the path!\n", player.getName());
        next();



    }//End of intro class


    /**
     * This method to move onto the next line of text
     */
    public void next(){
        System.out.println("\nPress enter to continue.");
        in.nextLine();

    }




}//End of Journey Class
