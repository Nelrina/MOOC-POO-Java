/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class Vehicule {
    private String nom;
    private double vitesseMax;
    private int poids;
    private int nivCarburant;
    
    public Vehicule(String n, double vm, int p, int nc) {
        this.nom = n;
        this.vitesseMax = vm;
        this.poids = p;
        this.nivCarburant = nc;
    }
    
    public Vehicule() {
        this("Anonyme", 130.0, 1000, 0);
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public double getVitesseMax() {
        return this.vitesseMax;
    }
    
    public int getPoids() {
        return this.poids;
    }
    
    public int getCarburant() {
        return this.nivCarburant;
    }
    
    public String toString() {
        return this.getNom() + " -> vitesse max = " + this.getVitesseMax() + " km/h, poids = " + this.getPoids() + " kg";
    }
    
    public boolean meilleur(Vehicule autreVehicule) {
        return this.performance() > autreVehicule.performance();
    }
    
    private double performance() {
        return this.vitesseMax/this.poids;
    }
    
    public boolean estDeuxRoues() {
        return false;
    }
}

class Voiture extends Vehicule {
    private String categorie;
    
    public Voiture(String n, double vm, int p, int nc, String c) {
        super(n, vm, p, nc);
        this.categorie = c;
    }
    
    public String getCategorie() {
        return this.categorie;
    }
    
    public String toString() {
        return super.toString() + ", Voiture de " + getCategorie();
    }

}

class Moto extends Vehicule {
    private boolean sidecar;
    
    public Moto(String n, double vm, int p, int nc, boolean s) {
        super(n, vm, p, nc);
        this.sidecar = s;
    }
    
    public Moto(String n, double vm, int p, int nc) {
        this(n, vm, p, nc, false);
    }
    
    public String toString() {
        return super.toString() + ", Moto" + (sidecar?", avec sidecar":"");
    }
    
    public boolean estDeuxRoues() {
        return !sidecar;
    }
}

abstract class Rallye {
    public abstract boolean check();
}

class GrandPrix extends Rallye {
    private ArrayList<Vehicule> vehicules;
    
    public GrandPrix() {
        this.vehicules = new ArrayList<Vehicule>();
    }
    
    public void ajouter(Vehicule v) {
        this.vehicules.add(v);
    }
    
    public boolean check() {
        int deuxRoues = 0;
        int autres = 0;
        
        for(int i = 0; i < this.vehicules.size(); i++)
        {
            if (this.vehicules.get(i).estDeuxRoues()) deuxRoues++;
            else autres++;
        }
        
        if(deuxRoues == 0) return true;
        else if(autres == 0) return true;
        else return false;
    }
    
    public void run(int tours) {
        if(!this.check()) {
            System.out.println("Pas de Grand Prix");
            return;
        }
        else {
            ArrayList<Vehicule> ligneArrivee = new ArrayList<Vehicule>();
            int meilleur = 0;
            
            for(int i = 0; i < this.vehicules.size(); i++)
            {
                if ((this.vehicules.get(i).getCarburant() - tours) > 0) ligneArrivee.add(this.vehicules.get(i));
            }
            
            if(ligneArrivee.size() != 0) {
                // Parcourt des vehicules qui passent la ligne d'arrivee pour determiner le gagnant
                for(int i = 1; i < ligneArrivee.size(); i++)
                {
                    if ((this.vehicules.get(i).meilleur(this.vehicules.get(meilleur)))) meilleur = i;
                }
                
                System.out.println("Le gagnant du grand prix est :");
                System.out.println(this.vehicules.get(meilleur));
            }
            else System.out.println("Elimination de tous les vehicules");
        }
    }
}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
