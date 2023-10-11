
package Alexis.POKEMON;


import java.sql.SQLException;
import Alexis.DATABASE.DBSupport;
import Alexis.ENUMERATIONS.PokemonType;
import Alexis.INTERFACES.Attackable;
import Alexis.INTERFACES.Defendable;

public abstract class Pokemon implements Attackable,Defendable {
    
private String name;
private String pokeSpecies;
private PokemonType pokeType;
private int pokeValue;

private int maxHealth;
private int currentHealth;

private int baseAttackValue;
private int baseDefenseValue;

private int wins;
private int losses;
private int draws;

public Pokemon(){
    
}

public Pokemon(String name, String pokeSpecies, PokemonType pokeType, int pokeValue, int maxHealth, 
        int baseAttackValue, int baseDefenseValue) throws SQLException, ClassNotFoundException {
        this.name = name;
        this.pokeSpecies = pokeSpecies;
        this.pokeType = pokeType;
        this.pokeValue = pokeValue;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.baseAttackValue = baseAttackValue;
        this.baseDefenseValue = baseDefenseValue;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.toSQL();
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPokeSpecies() {
        return pokeSpecies;
    }

    public void setPokeSpecies(String pokeSpecies) {
        this.pokeSpecies = pokeSpecies;
    }

    public PokemonType getPokeType() {
        return pokeType;
    }

    public void setPokeType(PokemonType pokeType) {
        this.pokeType = pokeType;
    }

    public int getPokeValue() {
        return pokeValue;
    }

    public void setPokeValue(int pokeValue) {
        this.pokeValue = pokeValue;
    }   

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getBaseAttackValue() {
        return baseAttackValue;
    }

    public void setBaseAttackValue(int baseAttackValue) {
        this.baseAttackValue = baseAttackValue;
    }

    public int getBaseDefenseValue() {
        return baseDefenseValue;
    }

    public void setBaseDefenseValue(int baseDefenseValue) {
        this.baseDefenseValue = baseDefenseValue;
    }    

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    @Override
    public String toString() {
        return "Name: " + name 
                + "\nType: " + pokeType.name()
                + "\nSpecies: " + pokeSpecies
                + "\nValue: " + pokeValue 
                + "\nMax Health: " + maxHealth 
                + "\nCurrent Health: " + currentHealth
                + "\nBase Attack Value: " + baseAttackValue   
                + "\nBase Defense Value: " + baseDefenseValue   
                + "\nWINS: " + wins + " " + "LOSSES: " + losses + " DRAWS: " + draws;
    }    
    

public void displayPokemon(){
    System.out.println(this.toString());
}

public abstract int attack(Pokemon p);

public abstract int defend(Pokemon p);

public void toSQL() throws SQLException, ClassNotFoundException{
    String q = "INSERT INTO pokemon VALUES('" + name + "','" + pokeSpecies + "','" 
            + pokeType.name() + "'," + pokeValue + "," + maxHealth + "," + currentHealth 
            + "," + baseAttackValue + "," + baseDefenseValue + ");";    
    DBSupport.executeQuery(q);
    String q2 = "INSERT INTO pokemon_record VALUES('" + name + "'," + wins + "," + losses + "," + draws + ");";
    DBSupport.executeQuery(q2);    
}







    
}
