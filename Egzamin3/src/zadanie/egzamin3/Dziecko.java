package zadanie.egzamin3;
	
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Dziecko {

	private Matka matka;
	private int identyfikator;
	private String imie;
	private String plec;
	private LocalDate dataUrodzenia;
	private int waga;
	private int wzrost;

	public Dziecko(int identyfikator, String imie, String plec, LocalDate dataUrodzenia, int waga, int wzrost,
			Matka matka) throws IllegalAccessException {
		System.out.println(matka);
		if (matka == null) {
			throw new IllegalAccessException("dziecko musi miec matke");
		}
		 
	
		this.identyfikator = identyfikator;
		this.imie = imie;
		this.plec = plec;
		this.dataUrodzenia = dataUrodzenia;
		this.waga = waga;
		this.wzrost = wzrost;
		this.matka = matka;

		matka.getDzieci().add(this);
	}

	public static Dziecko imieNajwyzszejOsobyDanejPlci(List<Dziecko> lista, String plec) {
		if (lista == null) {
			throw new IllegalArgumentException("lista nie moze byc pusta");
		}

		Dziecko najwyzszeDziecko = null;

		for (Dziecko dziecko : lista) {
			if (dziecko.getPlec().equals(plec)) {
				najwyzszeDziecko = dziecko;
			}
		}

		for (Dziecko dziecko : lista) {
			if (dziecko.getPlec().equals(plec)) {
				if (dziecko.getWzrost() > najwyzszeDziecko.getWzrost()) {
					najwyzszeDziecko = dziecko;
				}
			}
		}

		return najwyzszeDziecko;
	}

	// W którym dniu urodzi³o siê najwiêcej dzieci? Podaj datê i liczbê dzieci.
	public static String najwiecejUrodzonychDzieciDataOrazIlosc(List<Dziecko> lista) {
		int max = 0;
		String dataNajczesciejWystepujaca = "";
		for (Dziecko dz : lista) {
			int temp = 0;
			for (Dziecko dz1 : lista) {
				if (dz.getDataUrodzenia().equals(dz1.getDataUrodzenia())) {
					temp++;
				}
			}
			if (max < temp) {
				dataNajczesciejWystepujaca += dz.getDataUrodzenia();
				max = temp;
			}
		}
		return dataNajczesciejWystepujaca + " urodzilo sie " + max + " dzieci";

	}

	//		public static List<LocalDate> blizniakiDatyUrodzenia(List<Dziecko> lista, List<Matka> lista2) {
	//			List<Matka> matkiMajaceWiecejNizJednoDziecko = new ArrayList<>();
	//			List<LocalDate> datyUrBlizniakow = new ArrayList<>();
	//			for (Matka m : lista2) {
	//				int temp = 0;
	//				for (Dziecko dz : lista) {
	//					if (m.getIdentyfikator() == dz.matka.getIdentyfikator()) {
	//						temp++; //sprawdzam ile matek mialo wiecej niz jedno dziecko
	//					}
	//				}
	//				if (temp > 1) {
	//					matkiMajaceWiecejNizJednoDziecko.add(m);//dodaje je do listy
	//				}
	//			}
	//			for (Dziecko dz : lista) {
	//				for (Matka m : matkiMajaceWiecejNizJednoDziecko) { //sprawdzam ktore dzieci pasuja do matek ktore mialy wiecejniz jedno dziecko
	//					if (dz.matka.getIdentyfikator() == m.getIdentyfikator()) {
	//						datyUrBlizniakow.add(dz.getDataUrodzenia()); //dodaje daty do zmiennej ktora potem usunie dublikaty
	//					}
	//				}
	//			}
	//			List<LocalDate> datyUrbezDubli = new ArrayList<>(new HashSet<>(datyUrBlizniakow));
	//			return datyUrbezDubli;
	//		}
	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public LocalDate getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public int getWaga() {
		return waga;
	}

	public void setWaga(int waga) {
		this.waga = waga;
	}

	public int getWzrost() {
		return wzrost;
	}

	public void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	public Matka getMatka() {
		return matka;
	}

	public void setMatka(Matka matka) {
		this.matka = matka;
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
		return   identyfikator + " " + imie + " " + plec + " "
				+ dataUrodzenia + " " + waga + " " + wzrost + " " + matka + "";
	}
	

	
}
