package personnages;

public class Humain {
	static int tailleMemoire = 3;
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected Humain[] memoire = new Humain[tailleMemoire];
	protected int nbConnaissance = 0;
	

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;	
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	protected void parler(String texte) {
		System.out.println("["+nom+"] : " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite);
	}
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	public void acheter(String bien,int prix) {
		if (prix<=argent) {
			perdreArgent(prix);
			parler("J'ai "+ argent + " en poche, je vais pouvoir m'acheter un " + bien + " à " + prix +" pesos philippins" );
		} else {
			parler("Je n'ai plus que " + argent + " pesos en poche. Je ne peux même pas m'offrir un kimono à " + prix + " pesos.");
		}
	}
	
	protected void gagnerArgent(int gain) {
		argent+=gain;
	}
	protected void perdreArgent(int perte) {
		argent-=perte;
	}
	
	private void repondre(Humain hum1) {
		direBonjour();
		memoriser(hum1);
	}
	
	private void memoriser(Humain hum1) {
		boolean connu = false;
		for(int i = 0; i<nbConnaissance && !connu;i++) {
			connu = hum1 == memoire[i];
		}
		if (!connu) {
			if (nbConnaissance == tailleMemoire) {
				for (int i = 0; i < nbConnaissance-1; i++) {
					memoire[i] = memoire[i+1];				
					}
				memoire[nbConnaissance-1] = hum1;
			}
			else {
				memoire[nbConnaissance] = hum1;
				nbConnaissance++;
			}
		}
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		String connaissances = memoire[0].getNom();
		for(int i = 1; i<nbConnaissance;i++) {
			connaissances += ","+memoire[i].getNom();
		}
	parler("Je connais beaucoup de monde dont : " + connaissances);
	}
}


















