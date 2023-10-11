
package Alexis.INTERFACES;

import java.util.Random;
import Alexis.POKEMON.Pokemon;


public interface Defendable {
    
    public default int evaporate(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(2);
        return power;
    }
    
    public default int steamify(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(3);
        return power;        
    }
    
    public default int soak(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(2);
        return power;
    }
    
    public default int extinguish(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(3);
        return power;
    }   
    
}
