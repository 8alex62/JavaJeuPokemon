package fr.estiam.jeupokemon.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Joueur {
    String nom;
    int mancheGagne;
    int argent;
    List<Pokemon> pokemons;

    Scanner sc = new Scanner(System.in);

     public Joueur (String nom, int mancheGagne, int argent){
        this.nom = nom;
        this.mancheGagne = mancheGagne;
        this.argent = argent;
        this.pokemons = new ArrayList<>();
    }



    public void choisirPokemon(){

        List<Pokemon> listePokemon = new ArrayList<>();
        int monnaie = argent;

        Pokemon tarpaud = new Pokemon("Trapaud", 200,"eau",15,384,249, 249, 299, 279, 239);
        hydrocanon(tarpaud);
        laserGlace(tarpaud);
        ballMeteo(tarpaud);
        aquaBreche(tarpaud);
        listePokemon.add(tarpaud);


        Pokemon magby = new Pokemon("Magby",150,"feu",5, 278, 292,310, 189,220,310);
        chantCanon(magby);
        surchauffe(magby);
        deflagration(magby);
        abri(magby);
        listePokemon.add(magby);

        Pokemon joliflore = new Pokemon("Joliflore", 150,"plante",10,318,272,282,278,294,268);
        ecoSphere(joliflore);
        noeudHerbe(joliflore);
        abri(joliflore);
        chantCanon(joliflore);
        listePokemon.add(joliflore);
        

        Pokemon kraboss = new Pokemon("Kraboss", 150, "eau",5,254,349,220,220,292,272);
        hydrocanon(kraboss);
        laserGlace(kraboss);
        ballMeteo(kraboss);
        aquaBreche(kraboss);
        listePokemon.add(kraboss);

        Pokemon caninos = new Pokemon("Caninos", 200,"feu",15,282,320,324,180,210,270);
        chantCanon(caninos);
        surchauffe(caninos);
        deflagration(caninos);
        abri(caninos);
        listePokemon.add(caninos);

        Pokemon saquedeneu = new Pokemon("Saquedneu",150,"plante",10,285,259,324,184,329,260);
        ecoSphere(saquedeneu);
        noeudHerbe(saquedeneu);
        abri(saquedeneu);
        chantCanon(saquedeneu);
        listePokemon.add(saquedeneu);



        for(int j = 0; j < 3; j++){
            System.out.println("Votre solde : "+ monnaie);
            System.out.println("Liste Pokemon : ");
            for(int y = 0; y < listePokemon.size(); ++y) {
                Pokemon pokemon = listePokemon.get(y);
                System.out.printf("%d. nom : %s, type : %s, lvl : %s, il coûte: %s $ \n", y + 1, pokemon.getNomPokemon(),pokemon.getTypePokemon(), pokemon.getNiveau(),pokemon.getPrix());
            }
            System.out.println("Quels pokémon choisissez vous ?");
            int choix = Integer.parseInt(sc.next());
            Pokemon pokemon =  listePokemon.get(choix - 1);
            ajouterPokemon(pokemon);
            monnaie -= pokemon.getPrix();
            listePokemon.remove(pokemon);
        }
    }

    public void ajouterPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public Attaque choisirAttaque(Pokemon pokemon){
        List<Attaque> listeAttaques = pokemon.attaques;
        System.out.println("Choisisez une attaque : (1/2/3/4)");
        for(int i = 0 ; i < listeAttaques.size(); i++){
            Attaque attaque = listeAttaques.get(i);
            System.out.printf("%d. %s type: %s, cat: %s, pui: %d, PP: %d \n",i+1, attaque.getNomAttaque(), attaque.getTypeAttaque(), attaque.getCategorieAttaque(), attaque.getPuissance(), attaque.getPp());
        }
        int choixAttaque = Integer.parseInt(sc.next());
        return listeAttaques.get(choixAttaque - 1);
    }

    public Pokemon recupererPokemon(int pokemon){
        return pokemons.get(pokemon);
    }

    public void afficher(Joueur joueur){
        List<Pokemon> listePokemon = joueur.pokemons;
        System.out.println("Dresseur : "+joueur.nom);
        System.out.println("Manches gagnée : "+joueur.mancheGagne);
        System.out.println("Argent : "+joueur.argent);
        for (Pokemon pokemon : listePokemon) {
            System.out.printf("Pokemons : %s \n", pokemon.getNomPokemon());
        }
    }

    //Création des attaques
    public void hydrocanon(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Hydrocanon","eau","spe",80,110, 5));
    }

    public void laserGlace(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Laser glace","glace","spe",100,90, 10));
    }

    public void ballMeteo(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Ball'météo","normal","spe",100,50, 10));
    }

    public void aquaBreche(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Aqua-Brèche","eau","phy",100,85, 10));
    }

    public void chantCanon(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Chant Canon","normal","spe",100,60, 15));
    }

    public void surchauffe(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Surchauffe","feu","spe",90,130, 5));
    }

    public void deflagration(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Déflagration","feu","spe",85,110, 5));
    }

    public void abri(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Abri","normal","phy",0,0, 10));
    }

    public void ecoSphere(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Eco-Sphère","plante","spe",100,90, 10));
    }

    public void noeudHerbe(Pokemon pokemon) {
        pokemon.ajouterAttaque(new Attaque("Noeud Herbe","plante","spe",100,1, 20));
    }
}