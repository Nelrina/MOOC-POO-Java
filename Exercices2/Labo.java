class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie;
    private Boolean clonee;
    
    public Souris(int p, String c, int a, int ev) {
		this.poids = p;
		this.couleur = c;
        this.age = a;
        this.esperanceVie = ev;
        this.clonee = false;
        System.out.println("Une nouvelle souris !");
	}
    
    public Souris(int p, String c, int a) {
		this(p, c, a, ESPERANCE_VIE_DEFAUT);
	}
    
    public Souris(int p, String c) {
		this(p, c, 0, ESPERANCE_VIE_DEFAUT);
	}
    
    public Souris(Souris s) {
        this.poids = s.getPoids();
		this.couleur = s.getCouleur();
        this.age = s.getAge();
        this.esperanceVie = s.getEsperanceVie() * 4 / 5;
        this.clonee = true;
        System.out.println("Clonage d'une souris !");
	}
    
    public String toString() {
        String clone = this.clonee ? ", clonee, " : " ";
        return "Une souris " + this.couleur + clone + "de " + this.age + " mois et pesant " + this.poids + " grammes";
    }
    
    void vieillir() {
        this.age++;
        if (clonee && this.age > this.esperanceVie/2) this.couleur = "verte";
    }
    
    void evolue() {
        for(int i=this.age ; i<this.esperanceVie ; i++)
            vieillir();
    }
    
    public int getPoids() {
        return poids;
    }
    
    public String getCouleur() {
        return couleur;
    }
    
    public int getAge() {
        return age;
    }
    
    public int getEsperanceVie() {
        return esperanceVie;
    }
    
    public Boolean getClonee() {
        return clonee;
    }
}



/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
