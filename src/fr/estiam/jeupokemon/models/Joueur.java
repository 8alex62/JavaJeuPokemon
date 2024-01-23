package fr.estiam.jeupokemon.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Joueur {
    String nom;
    int mancheGagne;
    int argent;
    List<Pokemon> pokemons;

    Joueur (String nom, int mancheGagne, int argent){
        this.nom = nom;
        this.mancheGagne = mancheGagne;
        this.argent = argent;
        this.pokemons = new ArrayList<>();
    }



    public void choisirPokemon(){
        Scanner sc = new Scanner(System.in);
        List<Pokemon> listePokemon = new ArrayList<>();
        int monnaie = argent;

        Pokemon Tarpaud = new Pokemon("Trapaud", 200,"eau",45,384,249, 249, 299, 279, 239);
        Tarpaud.ajouterAttaque(new Attaque("Hydrocanon","eau","spe",0,85, 5));
        Pokemon Magby = new Pokemon("Magby",150,"feu",50, 278, 292,310, 189,220,310);
        Pokemon Joliflore = new Pokemon("Joliflore", 150,"plante",48,318,272,282,278,294,268);
        Pokemon Kraboss = new Pokemon("Kraboss", 150, "eau",47,254,349,220,220,292,272);
        Pokemon Caninos = new Pokemon("Caninos", 200,"feu",49,282,320,324,180,210,270);
        Pokemon Saquedeneu = new Pokemon("Saquedneu",150,"plante",46,285,259,324,184,329,260);




        listePokemon.add(Tarpaud);
        listePokemon.add(Magby);
        listePokemon.add(Joliflore);
        listePokemon.add(Kraboss);
        listePokemon.add(Caninos);
        listePokemon.add(Saquedeneu);



        for(int j = 0; j < 3; j++){
            System.out.println("Votre solde : "+ monnaie);
            System.out.println("Liste Pokemon : ");
            for(int y = 0; y < listePokemon.size(); ++y) {
                Pokemon pokemon = listePokemon.get(y);
                System.out.printf("%d. nom : %s, type : %s, lvl : %s, il coûte: %s $ %n", y + 1, pokemon.getNomPokemon(),pokemon.getTypePokemon(), pokemon.getNiveau(),pokemon.getPrix());
            }
            System.out.println("Quels pokémon choisissez vous ?");
            int choix = Integer.parseInt(sc.next());
            Pokemon pokemon =  listePokemon.get(choix - 1);
            pokemons.add(pokemon);
            monnaie -= pokemon.getPrix();
            listePokemon.remove(pokemon);
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
