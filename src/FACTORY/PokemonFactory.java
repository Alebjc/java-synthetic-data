
package FACTORY;

import java.sql.SQLException;
import java.util.Random;
import Alexis.POKEMON.Pokemon;
import Alexis.POKEMON.Pokemon_Fire;
import Alexis.POKEMON.Pokemon_Water;

public class PokemonFactory {
   
    private static int pCount = 0;
    
    public static  Pokemon createPokemon() throws SQLException, ClassNotFoundException {
        Random R = new Random();
        
        int randomChoice = R.nextInt(2);
        int inA = R.nextInt(Builder.name.length);
        int inB = R.nextInt(Builder.species.length);
        String pokeName = Builder.name[inA];
        String pokeSpecies = Builder.species[inB];
        int healthValue =  (int) (Math.random() * 14 + 4);
        int attackValue = (int) (Math.random() * 6 + 2);
        int defenseValue = (int) (Math.random() * 6 + 2);

        
        if(randomChoice ==  0){
            pCount++;
            System.out.println("Creating Fire Pokemon: " + pokeName +  pCount);
            return new Pokemon_Fire(pokeName + pCount ,pokeSpecies, 100,healthValue,attackValue,defenseValue);
        }
        else {
                    pCount++;
                    System.out.println("Creating Water Pokemon: " + pokeName + pCount);
                    return new Pokemon_Water(pokeName + pCount ,pokeSpecies,100,healthValue,attackValue,defenseValue);
                    }
        }
      
    }
    

