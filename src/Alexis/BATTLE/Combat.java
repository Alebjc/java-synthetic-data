
package Alexis.BATTLE;

import java.sql.SQLException;
import Alexis.DATABASE.DBSupport;
import Alexis.POKEMON.Pokemon;

public class Combat {
    
    public static int battleCount = 1;
    
    public static void battlePokemon(Pokemon p1, Pokemon p2) throws SQLException, ClassNotFoundException{
       String winner = ""; String loser = "";
       for(int i = 1; i < 5; i++){
           System.out.println("ROUND: " + i);
            if (i % 2 == 0){
                fightRound(p1,p2); 
            }       
            else{
                fightRound(p2,p1);
            }
       }
       if(p1.getCurrentHealth() > p2.getCurrentHealth()){
            System.out.println("***" + p1.getName() + " WINS***");
            p1.setWins(p1.getWins() + 1);
            p2.setLosses(p2.getLosses() + 1);
            String q1 = "UPDATE pokemon_record SET wins = " + p1.getWins() + " WHERE pokeName = " + "'" + p1.getName() + "';";
            System.out.println(q1);
            DBSupport.executeQuery(q1);
            String q2 = "UPDATE pokemon_record SET losses = " + p2.getLosses() + " WHERE pokeName = " + "'" + p2.getName() + "';";
            DBSupport.executeQuery(q2);
            winner = p1.getName(); loser = p2.getName();
            String q3 = "INSERT INTO pokemon_battles VALUES('B" + battleCount + "','" + p1.getName() + "','" + p2.getName() + "','" +
                    p1.getPokeSpecies() + "','" + p2.getPokeSpecies() + "');";
            DBSupport.executeQuery(q3);
        }
       
       
       if(p1.getCurrentHealth() < p2.getCurrentHealth()){
            System.out.println("***" + p2.getName() + " WINS***");
            p2.setWins(p2.getWins() + 1);
            p1.setLosses(p1.getLosses() + 1);
            String q1 = "UPDATE pokemon_record SET wins = " + p2.getWins() + " WHERE pokeName = " + "'" + p2.getName() + "';";
            DBSupport.executeQuery(q1);
            String q2 = "UPDATE pokemon_record SET losses = " + p1.getLosses() + " WHERE pokeName = " + "'" + p1.getName() + "';";
            DBSupport.executeQuery(q2);
            winner = p2.getName(); loser = p1.getName();
            String q3 = "INSERT INTO pokemon_battles VALUES('B" + battleCount + "','" + p2.getName() + "','" + p1.getName() + "','" +
                    p2.getPokeSpecies() + "','" + p1.getPokeSpecies() + "');";
            DBSupport.executeQuery(q3);
        }
       
       
       if(p1.getCurrentHealth() == p2.getCurrentHealth()){
            System.out.println("***DRAW***");
            p1.setDraws(p1.getDraws() + 1);
            p2.setDraws(p2.getDraws() + 1);
            String q1 = "UPDATE pokemon_record SET draws = " + p1.getDraws() + " WHERE pokeName = " + "'" + p1.getName() + "';";
            DBSupport.executeQuery(q1);
            String q2 = "UPDATE pokemon_record SET draws = " + p2.getDraws() + " WHERE pokeName = " + "'" + p2.getName() + "';";
            DBSupport.executeQuery(q2);
        }   
    
       System.out.println(); 
       p1.displayPokemon();
       System.out.println();
       p2.displayPokemon();
       battleCount++;
       
    }
    
    public static void fightRound(Pokemon p1, Pokemon p2){
        int attack = p1.attack(p2);
        int defense = p2.defend(p1);
        int damage = attack - defense;
        if(damage < 0){
            damage = 0;
        }
        p2.setCurrentHealth(p2.getCurrentHealth() - damage);
        System.out.println("\t" + p2.getName() + " suffers " + damage + " points of damage");
    }
    
}
