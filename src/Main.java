package fr.estiam.jeupokemon.models;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quels est votre nom J1 ?");
        String nomJ1 = sc.nextLine();
        Joueur j1 = new Joueur(nomJ1, 0, 500);
        j1.choisirPokemon();
    }
}
