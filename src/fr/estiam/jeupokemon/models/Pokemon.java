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


    public Pokemon(String nomPokemon, int prixPokemon, String typePokemon, int niveauPokemon, int HP, Integer attaquePokemon, int attaqueSpePokemon, int defensePokemon, int defenseSpePokemon, int vitessePokemon) {
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

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public Integer getHP() {
        return HP;
    }

    public Integer getPrix() {
        return prix;
    }

    public void ajouterAttaque(Attaque nouvelleAttaque) {
        attaques.add(nouvelleAttaque);
    }

    public boolean estKo(Pokemon pokemon) {
        return pokemon.getHP() > 0;
    }

    public void attaquer(Pokemon pokemonDefenseur, Attaque attaque){
        Pokemon pokemonAttaquant = this;
        int i = attaque.getPp();
        if(i > 0 && estKo(pokemonDefenseur)) {
            int atk = attaque.calculerDegats(pokemonAttaquant, pokemonDefenseur);
            int hpDef = pokemonDefenseur.getHP();
            hpDef -= atk;
            pokemonDefenseur.setHP(hpDef);

            attaque.setPp(i-1);

            if (estKo(pokemonDefenseur)) {
                System.out.println(pokemonDefenseur.getNomPokemon() + " a maintenant " + hpDef + " points de vie.");
            } else {
                System.out.println(pokemonDefenseur.getNomPokemon() + " est KO !");
            }
        }
    }
}



