
package Alexis.INTERFACES;

import java.util.Random;
import Alexis.POKEMON.Pokemon;


public interface Attackable {
    
    public default int flameBlast(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(3);
        return power;
    }
    
    public default int fireStream(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(2);
        return power;        
    }
    
    public default int waterSpray(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(3);
        return power;
    }
    
    public default int hydroFlood(Pokemon p){
        Random R = new Random();
        int power = R.nextInt(2);
        return power;
    }
    
}
