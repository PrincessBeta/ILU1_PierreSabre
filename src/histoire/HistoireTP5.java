package histoire;
import personnages.*;

public class HistoireTP5 {
	
	public static void main(String[] args) {
		
	Commercant marco = new Commercant("Marco", 20);
	Commercant chonin = new Commercant("Chonin", 40);
	Commercant kumi = new Commercant("Kumi", 10);
	Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
	Ronin roro = new Ronin("Roro", "shochu", 60);

	marco.faireConnaissanceAvec(roro);
	marco.faireConnaissanceAvec(yaku);
	marco.faireConnaissanceAvec(chonin);
	marco.faireConnaissanceAvec(kumi);
	marco.listerConnaissance();
	roro.listerConnaissance();
	yaku.listerConnaissance();
	
	Samourai akiki = new Samourai("Miyamoto", "Akimoto", "saké", 80);
	akiki.faireConnaissanceAvec(marco);
	akiki.listerConnaissance();
	akiki.boire("thé");
	
	Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
	masako.faireLeGentil();
	masako.ranconner(kumi);
	masako.ranconner(chonin);
	masako.ranconner(marco);
	akiki.faireConnaissanceAvec(masako);
	masako.ranconner(kumi);
	masako.faireConnaissanceAvec(yaku);
	masako.faireLeGentil();
	masako.faireConnaissanceAvec(roro);
	
	}
}















