/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author dav
 */
public class Player {
        private String name;
        private int identity;

        public Player(String n, int i){
                name     = n;
                identity = i;
        }

        public String getName(){
                return name;
        }

        public int getIdentity(){
                return identity;
        }

        @Override
        public String toString(){
                return identity + ": " + name; 
        }
}
