import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
    private String nom;
    private boolean prix;
    
    public Auteur(String n, boolean p) {
        this.nom = n;
        this.prix = p;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public boolean getPrix() {
        return this.prix;
    }
}

class Oeuvre {
 	// Completer la classe Oeuvre ici
    private String titre;
    private Auteur auteur;
    private String langue;
    
    public Oeuvre(String t, Auteur a, String l) {
        this.titre = t;
        this.auteur = a;
        this.langue = l;
    }
    
    public Oeuvre(String t, Auteur a) {
        this(t, a, "francais");
    }
    
    public String getTitre() {
        return this.titre;
    }
    
    public Auteur getAuteur() {
        return this.auteur;
    }
    
    public String getLangue() {
        return this.langue;
    }
    
    public void afficher() {
        //return this.titre + ", " + this.auteur.getNom() + ", en " + this.langue;
        System.out.println(this.titre + ", " + this.auteur.getNom() + ", en " + this.langue);
    }
}

// completer les autres classes ici
class Exemplaire {
    private Oeuvre oeuvre;
    
    public Exemplaire(Oeuvre o) {
        this.oeuvre = o;
        //System.out.println("Nouvel exemplaire -> " + this.oeuvre.afficher());
        System.out.print("Nouvel exemplaire -> "); this.oeuvre.afficher();
    }
    
    public Exemplaire(Exemplaire e) {
        this.oeuvre = e.getOeuvre();
        //System.out.println("Copie d'un exemplaire de -> " + this.oeuvre.afficher());
        System.out.print("Copie d'un exemplaire de -> "); this.oeuvre.afficher();
    }
    
    public Oeuvre getOeuvre() {
        return oeuvre;
    }
    
    public void afficher() {
        //System.out.println("Un exemplaire de " + this.oeuvre.afficher());
        System.out.print("Un exemplaire de "); this.oeuvre.afficher();
    }
}

class Bibliotheque {
    private String nom;
    private ArrayList<Exemplaire> exemplaires;
    
    public Bibliotheque(String n) {
        this.nom = n;
        exemplaires = new ArrayList<Exemplaire>();
        System.out.println("La bibliothèque " + this.nom + " est ouverte !");
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public int getNbExemplaires() {
        return exemplaires.size();
    }
    
    public void stocker(Oeuvre o, int nb) {
        Exemplaire e = new Exemplaire(o);
        for(int i = 0; i < nb; i++) this.exemplaires.add(e);
    }
    
    public void stocker(Oeuvre o) {
        Exemplaire e = new Exemplaire(o);
        this.exemplaires.add(e);
    }
    
    public ArrayList<Exemplaire> listerExemplaires(String lang) {
        ArrayList<Exemplaire> liste = new ArrayList<Exemplaire>();
        for(int i = 0; i < this.exemplaires.size(); i++)
        {
            if(this.exemplaires.get(i).getOeuvre().getLangue() == lang)
                liste.add(this.exemplaires.get(i));
        }
        return liste;
    }
    
    public ArrayList<Exemplaire> listerExemplaires() {
        return this.exemplaires;
    }
    
    public int compterExemplaires(Oeuvre o) {
        int nb = 0;
        for(int i = 0; i < this.exemplaires.size(); i++)
        {
            if(this.exemplaires.get(i).getOeuvre() == o)
                nb++;
        }
        return nb;
    }
    
    public void afficherAuteur(boolean p) {
        for(int i = 0; i < this.exemplaires.size(); i++)
        {
            if(this.exemplaires.get(i).getOeuvre().getAuteur().getPrix() == p)
                System.out.println(this.exemplaires.get(i).getOeuvre().getAuteur().getNom());
        }
    }
    
    public void afficherAuteur() {
        afficherAuteur(true);
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

