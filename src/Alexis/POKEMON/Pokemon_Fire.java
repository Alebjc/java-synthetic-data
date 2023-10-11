
package Alexis.POKEMON;

import java.sql.SQLException;
import java.util.Random;
import Alexis.ENUMERATIONS.PokemonType;



public class Pokemon_Fire extends Pokemon {

    public Pokemon_Fire() {
        
    }

    public Pokemon_Fire(String name, String pokeSpecies,int pokeValue, int maxHealth, 
            int attackValue, int defenseValue) throws SQLException, ClassNotFoundException {
        super(name, pokeSpecies, PokemonType.FIRE, pokeValue, maxHealth, attackValue, defenseValue);
    }
    
    @Override
    public int attack(Pokemon p){
       Random R = new Random();
       
       double rnd = R.nextDouble();
       int attackPower = 0;
       if(rnd < 0.5){            
            attackPower = (int)(this.fireStream(p) + (R.nextDouble() * this.getBaseAttackValue()));
       }
       else{           
            attackPower = (int)(this.flameBlast(p) + (R.nextDouble() * this.getBaseAttackValue()));
       }
       System.out.println(this.getName() + " attacks " + p.getName() + " with " + attackPower + " power");       
       return attackPower;      
    }
    
    @Override
    public int defend(Pokemon p){
       Random R = new Random();
       double rnd = R.nextDouble();
       int defensePower = 0;
       if(rnd < 0.5){
            defensePower = (int)(this.evaporate(p) + (R.nextDouble() * this.getBaseDefenseValue()));
       }
       else{
            defensePower = (int)(this.steamify(p) + (R.nextDouble() * this.getBaseDefenseValue()));
       }
       System.out.println(this.getName() + " defends " + p.getName() + " with " + defensePower + " power");        
       return defensePower;      
    }
    
    
    
}
