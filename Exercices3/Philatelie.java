import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    protected String code;
    protected int annee;
    protected String pays;
    protected double valeur;
    
    public Timbre(String c, int a, String p, double v) {
		this.code = c;
		this.annee = a; // Traiter le cas où l'on met une année supérieure à l'année courante ?
        this.pays = p;
        this.valeur = v;
	}
    
    public Timbre(String c, int a, String p) {
		this(c, a, p, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre(String c, int a) {
		this(c, a, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre(String c) {
		this(c, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public Timbre() {
		this(CODE_DEFAUT, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
	}
    
    public double vente() {
        if(age() < 5) return valeur;
        else return valeur * (double) age() * 2.5;
    }
    
    public String toString() {
        return "Timbre de code " + this.code + 
            " datant de  " + this.annee + 
            " (provenance " + this.pays + 
            ") ayant pour valeur faciale " + this.valeur + 
            " francs";
    }
    
    public int age() {
        return ANNEE_COURANTE-annee;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public int getAnnee() {
        return this.annee;
    }
    
    public String getPays() {
        return this.pays;
    }
    
    public double getValeurFaciale() {
        return this.valeur;
    }
}

class Rare extends Timbre {
    private int nbExemplaires;
    
    public Rare(String c, int a, String p, double v, int nb) {
		super(c, a, p, v);
        this.nbExemplaires = nb;
	}
    
    public Rare(String c, int a, String p, int nb) {
		super(c, a, p);
        this.nbExemplaires = nb;
	}
    
    public Rare(String c, int a, int nb) {
		super(c, a);
        this.nbExemplaires = nb;
	}
    
    public Rare(String c, int nb) {
		super(c);
        this.nbExemplaires = nb;
	}
    
    public Rare(int nb) {
        super();
        this.nbExemplaires = nb;
	}
    
    public int getExemplaires() {
        return this.nbExemplaires;
    }
    
    public String toString() {
        return "Timbre de code " + this.code + 
               " datant de " + this.annee + 
               " (provenance " + this.pays + 
               ") ayant pour valeur faciale " + this.valeur + 
               " francs\nNombre d’exemplaires -> " + nbExemplaires;
    }
    
    public double vente() {
        double val =  ((double) age() / 10.0);
        if(this.nbExemplaires < BASE_1_EXEMPLAIRES)
            return PRIX_BASE_1 * val;
        else if(this.nbExemplaires > BASE_1_EXEMPLAIRES && this.nbExemplaires < BASE_2_EXEMPLAIRES)
            return PRIX_BASE_2 * val;
        else return PRIX_BASE_3 * val;
    }
}

class Commemoratif extends Timbre {
    public Commemoratif(String c, int a, String p, double v) {
		super(c, a, p, v);
	}
    
    public Commemoratif(String c, int a, String p) {
		super(c, a, p);
	}
    
    public Commemoratif(String c, int a) {
		super(c, a);
	}
    
    public Commemoratif(String c) {
		super(c);
	}
    
    public Commemoratif() {
        super();
	}
    
    public String toString() {
        return "Timbre de code " + this.code + 
               " datant de " + this.annee + 
               " (provenance " + this.pays + 
               ") ayant pour valeur faciale " + this.valeur + 
               " francs\nTimbre celebrant un evenement";
    }
    
    public double vente() {
        return super.vente() * 2;
    }
}
	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

