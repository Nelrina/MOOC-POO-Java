/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class Piece {
    private String nom;
    
    public Piece(String n) {
        this.nom = n;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public String toString() {
        return this.nom;
    }
}

class Composant {
    private Piece piece;
    private int quantite;
    
    public Composant(Piece p, int q) {
        this.piece = p;
        this.quantite = q;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public int getQuantite() {
        return quantite;
    }
}

class Simple extends Piece {
    private String orientation;
    
    public Simple(String n, String o) {
        super(n);
        this.orientation = o;
    }
    
    public Simple(String n) {
        super(n);
        this.orientation = "aucune";
    }
    
    public String getOrientation() {
        return this.orientation;
    }
    
    public String toString() {
        if(this.orientation == "aucune") return getNom();
        // else return getNom() + " [" + this.orientation + "]";
        else return getNom() + " " + this.orientation;
    }
}

class Composee extends Piece {
    private ArrayList<Piece> pieces;
    private int maxPieces;
    
    public Composee(String n, int max) {
        super(n);
        this.maxPieces = max;
        this.pieces = new ArrayList<Piece>();
    }
    
    public int taille() {
        return this.pieces.size();
    }
    
    public int tailleMax() {
        return this.maxPieces;
    }
    
    public void construire(Piece p) {
        if(taille() >= this.maxPieces)
            System.out.println("Construction impossible");
        else this.pieces.add(p);
    }
    
    public String toString() {
        String description = "";
        for(int i = 0; i < taille(); i++)
        {
            description += this.pieces.get(i); // toString() ?
            if(i != taille()-1) description += ",";
        }        
        return getNom() + " (" + description + ")";
    }
}

class Construction {
    private int nbPiecesMax;
    private ArrayList<Composant> composants;
    
    public Construction(int nb) {
        this.nbPiecesMax = nb;
        this.composants = new ArrayList<Composant>();
    }
    
    public int taille() {
        return this.composants.size();
    }
    
    public int tailleMax() {
        return this.nbPiecesMax;
    }
    
    public void ajouterComposant(Piece pi, int nb) {
        Composant comp = new Composant(pi, nb);
        if(taille() >= this.nbPiecesMax)
            System.out.println("Ajout de composant impossible");
        else this.composants.add(comp);
    }
    
    public String toString() {
        String construction = "";
        for(int i = 0; i < taille(); i++)
        {
            construction += this.composants.get(i).getPiece() + " (quantite " + this.composants.get(i).getQuantite() + ")";
            if(i != taille()-1) construction += "\n";
        }        
        return construction;
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

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
