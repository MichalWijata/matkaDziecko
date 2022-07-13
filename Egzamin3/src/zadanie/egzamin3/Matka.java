package zadanie.egzamin3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matka {
	private int identyfikator;
	private String imie;
	private int wiek;
	private List<Dziecko> dzieci = new ArrayList<>();
	

	public Matka(int identyfikator, String imie, int wiek)throws IllegalAccessException {
	  System.out.println(identyfikator);
	  System.out.println(dzieci);
		this.identyfikator = identyfikator;
		this.imie = imie;
		this.wiek = wiek;
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

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public List<Dziecko> getDzieci() {
		return dzieci;
	}

	public void setDzieci(List<Dziecko> dzieci) {
		this.dzieci = dzieci;
	}

	@Override
	public String toString() {
		return getIdentyfikator() + " " + getImie() + " ";
	}

	//		W pliku noworodki.txt zapisane s� informacje o narodzinach bli�ni�t. Bli�ni�ta mo�na rozpozna� po tej samej dacie urodzenia 
	//		i tym samym identyfikatorze matki. Pami�taj, �e przyk�adowo Jacek i Agatka oraz Agatka i Jacek to ta sama para. Mo�esz za�o�y�, 
	//		�e w danych nie ma �adnych trojaczk�w, czworaczk�w, itd. Podaj daty, w kt�rych urodzi�y si� bli�ni�ta.

	//	public static List<LocalDate> datyUrBlizniakow(List<Matka>lista){
	//		List<LocalDate> blizniaki = new ArrayList<>();
	//
	//		for(Matka m:lista) {
	//		 
	//		}
	//		 
	// 
	//		return null;
	//	}

	//Podaj imiona kobiet w wieku poni�ej 25 lat, kt�re urodzi�y dzieci o wadze powy�ej 4000 g.

	//		public static String matkiOdXXwieku(List<Matka> lista, int wiekMatki, List<Dziecko> lista2, int wagaDziecka) {
	//			String imionaMatek = "";
	//			for (Matka m : lista) {
	//				for (Dziecko dz : lista2) {
	//					if (m.getWiek() < wiekMatki && m.getIdentyfikator() == dz.getIdentyfikatorMatki()
	//							&& dz.getWaga() > wagaDziecka) {
	//						imionaMatek += m.getImie() + "\n";
	//					}
	//				}
	//			}
	//			return imionaMatek;
	//		}

	//	//	Podaj imiona i daty urodzenia dziewczynek, kt�re odziedziczy�y imi� po matce.	
	//	public static String imieOrazDataUrDziewczynekKtoreMajaImieJakMatka(List<Matka> lista, List<Dziecko> lista2) {
	//		String imieOrazData = "";
	//
	//		for (Matka m : lista) {
	//			for (Dziecko dz : lista2) {
	//				if (dz.getPlec().equals("c") && m.getImie().equals(dz.getImie())
	//						&& m.getIdentyfikator() == dz.getIdentyfikatorMatki()) {
	//					//					System.out.println(dz.getImie() + " " + dz.getDataUrodzenia());
	//					imieOrazData += dz.getImie() + " " + dz.getDataUrodzenia() + "\n";
	//				}
	//			}
	//		}
	//		return imieOrazData;
	//	}

}
