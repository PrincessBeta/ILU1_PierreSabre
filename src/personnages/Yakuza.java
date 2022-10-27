package personnages;

public class Yakuza extends Humain {
	private String clan;
	
	public Yakuza(String nom, String boissonPreferee,int argent, String clan) {
		super(nom,boissonPreferee,argent);
		this.clan = clan;
	}
	public void extorquer(Commercant victime) {
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J’ai piqué les" + gain + "pesos de" + victime.getNom() + ", ce qui me fait" +
		getArgent() + " pesos dans ma poche. Hi ! Hi !");
	}

}
