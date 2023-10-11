DROP DATABASE IF EXISTS citytechpokemon;
CREATE DATABASE citytechpokemon;
USE citytechpokemon;

CREATE TABLE pokemon(
PokeName VARCHAR(50),
PokeSpecies VARCHAR(50),
PokeType ENUM('FIRE','WATER'),
PokeValue INT,
MaxHealth INT,
CurrentHealth INT,
BaseAttackValue INT,
BaseDefenseValue INT,
CONSTRAINT PK_poke PRIMARY KEY(PokeName)
);

CREATE TABLE pokemon_record(
PokeName VARCHAR(50),
Wins INT,
Losses INT,
Draws INT,
CONSTRAINT PK_record PRIMARY KEY(PokeName),
CONSTRAINT FK_record FOREIGN KEY(PokeName) REFERENCES pokemon(PokeName)
);

CREATE TABLE pokemon_battles(
BattleID VARCHAR(50),
WinnerName VARCHAR(50),
LoserName VARCHAR(50),
WinnerSpecies VARCHAR(50),
LoserSpecies VARCHAR(50),
CONSTRAINT PK_battle PRIMARY KEY(BattleID),
CONSTRAINT FK_battle1 FOREIGN KEY(WinnerName) REFERENCES pokemon(PokeName),
CONSTRAINT FK_battle2 FOREIGN KEY(LoserName) REFERENCES pokemon(PokeName)
);

