package personnages;
import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise = 0;
	private Random random = new Random();


	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : "+ Integer.toString(niveauTraitrise)
		+". Chut !");
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = argentCommercant * 2/10;
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer !"
					+ "Donne-moi"+ Integer.toString(argentRanconne) +"sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom());
			niveauTraitrise++;
		}
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne. Snif.");
		}
		else {
			Humain connaissance = memoire[random.nextInt(nbConnaissance-1)];
			String nomAmi = connaissance.getNom();
			int don = getArgent()/20;
			parler(" Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi);
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant"+ Integer.toString(don) +"sous.");
			connaissance.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			connaissance.parler("Merci "+ nom +". Vous êtes quelqu'un de bien.");
			
		}
	}
}















