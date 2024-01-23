package fr.estiam.jeupokemon.models;

import java.util.List;
import java.util.ArrayList;

public class Pokemon {

    String nomPokemon;
    protected Integer prix;
    String typePokemon;
    protected Integer HP;
    protected Integer niveau;
    protected Integer attaquePokemon;
    protected Integer attaqueSpePokemon;
    protected Integer defensePokemon;
    protected Integer defenseSpePokemon;
    protected Integer vitessePokemon;

    List<Attaque> attaques;


    Pokemon(String nomPokemon, int prixPokemon, String typePokemon, int niveauPokemon, int HP, Integer attaquePokemon, int attaqueSpePokemon, int defensePokemon, int defenseSpePokemon, int vitessePokemon) {
        this.nomPokemon = nomPokemon;
        this.prix = prixPokemon;
        this.typePokemon = typePokemon;
        this.niveau = niveauPokemon;
        this.HP = HP;
        this.attaquePokemon = attaquePokemon;
        this.attaqueSpePokemon = attaqueSpePokemon;
        this.defensePokemon = defensePokemon;
        this.defenseSpePokemon = defenseSpePokemon;
        this.vitessePokemon = vitessePokemon;
        this.attaques = new ArrayList<>();

    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public String getTypePokemon() {
        return typePokemon;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public Integer getPrix() {
        return prix;
    }

    public void ajouterAttaque(Attaque nouvelleAttaque) {
        attaques.add(nouvelleAttaque);
    }

    public boolean estKo(Pokemon pokemon) {
        return pokemon.HP != 0;
    }

    public void attaquer(){

        System.out.println();
    }
}



