/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Patient {
    // Caractéristiques du Patient : poids et taille
    private double masse;
    private double hauteur;
    
    public void init (double m, double h) {
        // On vérifie que la taille et le poids sont tous 2 positifs
        if(m >= 0.0 && h >= 0.0) {
            masse = m;
            hauteur = h;
        }
        // Dans le cas contraire on les initialise tous 2 à 0
        else {
            masse = 0.0;
            hauteur = 0.0;
        }
    }
    
    public double poids() {
        return masse;
    }
    
    public double taille() {
        return hauteur;
    }
    
    public double imc() {
        if(hauteur != 0.0) {
            return masse / (hauteur * hauteur);
        }
        else return 0.0;
    }
    
    public void afficher() {
        System.out.printf("Patient : %.1f Kg pour %.1f m\n", masse, hauteur);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
