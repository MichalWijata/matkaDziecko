package zadanie.egzamin3;

import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {

	private int identyfikator;
	private String imie;
	private static List<Osoba> ekstensja = new ArrayList<>();
	 

	public Osoba(int identyfikator, String imie) {
		this.identyfikator = identyfikator;
		this.imie = imie;
		ekstensja.add(this);
 
	}

	public static List<Osoba> getEkstensja() {
		return ekstensja;
	}

	public static void setEkstensja(List<Osoba> ekstensja) {
		Osoba.ekstensja = ekstensja;
	}

	public int getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(int identyfikator) {
		this.identyfikator = identyfikator;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

  
	@Override
	public String toString() {
		return identyfikator + " " + imie + " ";
	}
}
