package fr.estiam.jeupokemon.models;

public class Attaque {
        String nomAttaque;
        String typeAttaque;
        String categorieAttaque;
        double precision; // en pourcent
        int puissance; // puissance de l'attaque
        int pp; //nb de fois ou l'attaque peut etre utiliser

        public Attaque(String nomAttaque, String typeAttaque, String categorieAttaque, double precision, int puissance, int pp){
                this.nomAttaque = nomAttaque;
                this.typeAttaque = typeAttaque;
                this.categorieAttaque = categorieAttaque;
                this.precision = precision;
                this.puissance = puissance;
                this.pp = pp;
        }

    public String getNomAttaque() {
        return nomAttaque;
    }

    public int setPp(int pp) {
        this.pp = pp;
        return pp;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getTypeAttaque() {
        return typeAttaque;
    }

    public int getPp() {
        return pp;
    }

    public String getCategorieAttaque() {
        return categorieAttaque;
    }

    public int calculerDegats(Pokemon pokemonA, Pokemon pokemonD){
                double stab = 1;

                double pre = this.precision;
                int pui = this.puissance;
                int att = pokemonA.attaquePokemon;
                int def = pokemonD.defensePokemon;


                if(typeAttaque.equals(pokemonA.typePokemon)){
                        stab = 1.5;
                }

                if(categorieAttaque.equals("spe")){
                        att = pokemonA.attaqueSpePokemon;
                        def = pokemonD.defenseSpePokemon;
               }
        return (int) ((((pokemonA.niveau*0.4+2)*att*pui)/(def*50)+2)*stab*pre);
       }
}