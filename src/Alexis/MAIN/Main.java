
package Alexis.MAIN;


import FACTORY.PokemonFactory;
import java.sql.SQLException;
import Alexis.BATTLE.Combat;

public class Main {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
//        Pokemon_Fire charmy = new Pokemon_Fire("Charmy","Charmander",100,12,4,4); 
//        Pokemon_Water squirty = new Pokemon_Water("Squirty","Squirtle",100,10,2,2);
//        Combat.battlePokemon(charmy, squirty);
            for(int id = 0; id < 500;id++)
            {
                var PokemonA =  PokemonFactory.createPokemon();
                var PokemonB = PokemonFactory.createPokemon();
                Combat.battlePokemon(PokemonA,PokemonB);

            }
    }        
}
