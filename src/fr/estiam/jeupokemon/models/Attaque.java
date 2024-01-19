package fr.estiam.jeupokemon.models;

public class Attaque {
        String nomAttaque;
        String typeAttaque;
        String categorieAttaque;
        double precision; // en pourcent
        int puissance; // puissance de l'attaque
        int pp; //nb de fois ou l'attaque peut etre utiliser

        Attaque(String nomAttaque, String typeAttaque, String categorieAttaque, double precision, int puissance, int pp){
                this.nomAttaque = nomAttaque;
                this.typeAttaque = typeAttaque;
                this.categorieAttaque = categorieAttaque;
                this.precision = precision;
                this.puissance = puissance;
                this.pp = pp;
        }

       public double calculerDegats(Pokemon pokemonA, Pokemon pokemonD){
                double stab = 1;
                double degats = 0;
                double pre = this.precision;
                int pui = this.puissance;
                int att = pokemonA.attaquePokemon;
                int def = pokemonD.defensePokemon;


                if(typeAttaque.equals(pokemonA.typePokemon)){
                        stab = 1.5;
                }

                if(categorieAttaque.equals("Spéciale")){
                        att = pokemonA.attaqueSpePokemon;
                        def = pokemonD.defenseSpePokemon;
               }
                degats = (((pokemonA.niveau*0.4+2)*att*pui)/(def*50)+2)*stab*pre;
                return degats;
       }
}