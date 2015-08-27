/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author dav
 */
/** Simulation of Duck, Duck, Goose with an Array. */
public class SimpleDDGSim {
    
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
                //long startTime = System.currentTimeMillis();
                Random r         = new Random();
                int numRound     = 5; // number of iterations of the game
                String[] names   = {"Bob", "Susy", "Jake", "Greg", "Bianca", "Danny"}; 
                Player[] players = new Player[names.length - 1];
                Player it         = null; // the player who is "it"
                Player goose; // the goose
                int rand;

                //add children to array
                for(int i = 0; i < players.length; i++){
                        do{
                                rand = r.nextInt(names.length);
                        }while(SimpleDDGSim.contains(players, names[rand]));

                        players[i] = new Player(names[rand], i + 1);
                }
                //test
                System.out.println(Arrays.toString(players));
                //
                //check which child is 'it'
                for(String name : names){
                        if(!SimpleDDGSim.contains(players, name)){
                                it = new Player(name, names.length);
                                //test
                                System.out.println(it.toString());
                                //
                        }
                }

                //play
                for(int i = 0; i < numRound; i++){ // play Duck, Duck, Goose numRound times
                        System.out.println("ROUND: " + (i + 1));
                        Player pointer = null;
                        int count     = 0;
                        boolean check1, check2;

                        do{ // march around circle (Array)
                                check1 = r.nextBoolean();
                                check2 = r.nextBoolean();
                                if(count == players.length)
                                        count = 0; // reset i if it reaches end of array
                                pointer = players[count];
                                if(check1 || check2)
                                        System.out.println(pointer.getName() + " is a duck...");
                                count++;
                        }while(check1 || check2);

                        //test
                        //System.out.println("Count: " + count);
                        //
                        goose = pointer;
                        System.out.println(goose.getName() + " is the GOOSE");

                        if(r.nextBoolean()){ // if Goose wins
                                System.out.println("The GOOSE won!");
                                //test
                                System.out.println(Arrays.toString(players));
                                //
                        } else {
                                System.out.println("The GOOSE lost...");
                                players[count - 1] = it; // current 'it' takes goose' place
                                it                  = goose; // goose becomes new 'it' 
                                //test
                                System.out.println(Arrays.toString(players) + "\n" + "It: " + it.getName());
                                //
                        }
                }
                System.out.println("GAME OVER!");
                /*long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                System.out.println("\n" + "Duration: " + duration);*/
        }

        //method to check if children array contains a child
        public static boolean contains(Player[] array, String string){
                for (Player array1 : array) {
                        if (array1 != null && array1.getName().equals(string)) {
                                return true;
                        }
                }
                return false;
        }
    
}
