package fr.estiam.jeupokemon.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Jeu {

    List<Joueur> joueurs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void jouer() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("Joueur " + i + ", veuillez saisir votre nom : ");
            String nomJoueur = sc.nextLine();
            Joueur joueur = new Joueur(nomJoueur, 0, 500);
            joueur.choisirPokemon();
            joueurs.add(joueur);
        }
        Joueur j1 = joueurs.get(0);
        Joueur j2 = joueurs.get(1);

        int mancheJ1 = j1.mancheGagne;
        int mancheJ2 = j2.mancheGagne;

        int round = 1;
        while (round <= 3 && mancheJ1 != 2 && mancheJ2 != 2) {

            Pokemon pokemonJ1 = j1.recupererPokemon(round - 1);
            Pokemon pokemonJ2 = j2.recupererPokemon(round - 1);
            System.out.println("Round : " + round);

            if (pokemonJ1.vitessePokemon > pokemonJ2.vitessePokemon) {
                while (pokemonJ1.estKo(pokemonJ2) && pokemonJ2.estKo(pokemonJ1)){

                    System.out.printf("Dresseur 1, pokemon : %s affronte %s \n", pokemonJ1.getNomPokemon(), pokemonJ2.getNomPokemon());
                    Attaque attaquej1 = j1.choisirAttaque(pokemonJ1);
                    pokemonJ1.attaquer(pokemonJ2, attaquej1);

                    if (!pokemonJ1.estKo(pokemonJ2)) { //On test si le pokemon adverse est Ko ou non pour savoir si le combat continus entre les 2 pokemons ou si on passe au suivant
                        mancheJ1 += 1;
                        round++;
                        break;
                    }

                    System.out.printf("Dresseur 2, pokemon : %s affronte %s\n", pokemonJ2.getNomPokemon(), pokemonJ1.getNomPokemon());
                    Attaque attaquej2 = j2.choisirAttaque(pokemonJ2);
                    pokemonJ2.attaquer(pokemonJ1, attaquej2);

                    if (!pokemonJ2.estKo(pokemonJ1)) {
                        mancheJ2 += 1;
                        round++;
                        break;
                    }
                }
            } else {
                while (pokemonJ1.estKo(pokemonJ2) && pokemonJ2.estKo(pokemonJ1)){
                    System.out.printf("Dresseur 2, pokemon : %s affronte %s \n", pokemonJ2.getNomPokemon(), pokemonJ1.getNomPokemon());
                    Attaque attaquej2 = j2.choisirAttaque(pokemonJ2);
                    pokemonJ2.attaquer(pokemonJ1, attaquej2);

                    if (!pokemonJ2.estKo(pokemonJ1)) {
                        mancheJ2 += 1;
                        round++;
                        break;
                    }

                    System.out.printf("Dresseur 1, pokemon : %s affronte %s \n", pokemonJ1.getNomPokemon(),pokemonJ2.getNomPokemon());
                    Attaque attaquej1 = j1.choisirAttaque(pokemonJ1);
                    pokemonJ1.attaquer(pokemonJ2, attaquej1);

                    if (!pokemonJ1.estKo(pokemonJ2)) {
                        mancheJ1 += 1;
                        round++;
                        break;
                    }
                }
            }

        }

        if(mancheJ1 == 2) {
            System.out.println("Le dresseur : " + j1.nom + " est vainqueur !");
        } else {
            System.out.println("Le dresseur : " + j2.nom + " est vainqueur !");
        }

        System.out.println("Voulez-vous rejouer ? (o/n)");
        String rejouer = sc.nextLine();
        if (rejouer.equals("o")) {
            jouer();
        } else {
            System.out.println("Merci d'avoir joué !");
        }
    }
}

