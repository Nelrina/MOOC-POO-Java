/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class OptionVoyage {
    private String nom;
    private double prixForfait;
    
    public OptionVoyage(String n, double pf) {
        this.nom = n;
        this.prixForfait = pf;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public double prix() {
        return this.prixForfait;
    }
    
    public String toString() {
        return this.nom + " -> " + this.prix() + " CHF";
    }
}

class Sejour extends OptionVoyage {
    private int nbNuits;
    private double prixNuit;
    
    public Sejour(String n, double pf, int nb, double pn) {
        super(n, pf);
        this.nbNuits = nb;
        this.prixNuit = pn;
    }
    
    // Prix Sejour = (nbNuits * prixNuit) + prixForfait
    public double prix() {
        return (this.nbNuits * this.prixNuit) + super.prix();
    }
}

class Transport extends OptionVoyage {
    public static final double TARIF_LONG = 1500.0;
    public static final double TARIF_BASE = 200.0;
    
    private Boolean trajetLong;
    
    public Transport(String n, double pf, Boolean tl) {
        super(n, pf);
        this.trajetLong = tl;
    }
    
    public Transport(String n, double pf) {
        this(n, pf, false);
    }
    
    // Prix Transport = tarif + prixForfait
    public double prix() {
        //double pt = trajetLong?1500.0:200.0;
        return (trajetLong?1500.0:200.0) + super.prix();
    }
}

class KitVoyage {
    private ArrayList<OptionVoyage> options;
    private String depart;
    private String destination;
    
    public KitVoyage(String dp, String ds) {
        this.depart = dp;
        this.destination = ds;
        this.options = new ArrayList<OptionVoyage>();
    }
    
    public double prix() {
        double prixTotal = 0.0;
        for(int i = 0; i < getNbOptions(); i++)
        {
            prixTotal += this.options.get(i).prix();
        }
        return prixTotal;
    }
    
    public String toString() {
        String voyage = "Voyage de " + this.depart + " à " + this.destination + ", avec pour options :\n";
        for(int i = 0; i < getNbOptions(); i++)
        {
            voyage += "- " + this.options.get(i) + "\n";
        }
        voyage += "Prix total : " + this.prix() + " CHF";
        return voyage;
    }
    
    public void ajouterOption(OptionVoyage ov) {
        if(ov != null) {
            this.options.add(ov);
        }
    }
    
    public void annuler() {
        this.options.clear();
    }
    
    public int getNbOptions() {
        return this.options.size();
    }
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}

