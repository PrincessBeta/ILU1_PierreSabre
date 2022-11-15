package personnages;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;
	
	public int getReputation() {
		return reputation;
	}
	
	public Yakuza(String nom, String boissonPreferee,int argent, String clan) {
		super(nom,boissonPreferee,argent);
		this.clan = clan;
	}
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J’ai piqué les " + gain + " pesos de" + victime.getNom() + ", ce qui me fait " +
		getArgent() + " pesos dans ma poche. Hi ! Hi !");
	}
	public int perdre() {
		int argent = getArgent();
		perdreArgent(argent);
		parler("J’ai perdu mon duel et mes " + argent + " sous, snif... J'ai déshonoré le clan de " + clan);
		reputation -= 1;
		return argent;
	}
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan +
			"? Je l'ai dépouillé de ses " + gain + " sous");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de "+clan);
	}
	
}


















