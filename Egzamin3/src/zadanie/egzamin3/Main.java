package zadanie.egzamin3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, IllegalAccessException {
		//		Pliki noworodki.txt oraz mamy.txt zawieraj¹ dane o dzieciach i ich matkach.
		//		W pliku noworodki.txt ka¿dy wiersz zawiera nastêpuj¹ce informacje o jednym dziecku, 
		//		rozdzielone znakami odstêpu: identyfikator, p³eæ (c – córka, s – syn), imiê, data urodzenia, waga [g], wzrost [cm] oraz identyfikator matki.
		//		Przyk³ad:
		//		1 c Agnieszka 20-lis-1999 2450 48 33
		//		W pliku mamy.txt ka¿dy wiersz zawiera informacje o jednej kobiecie, rozdzielone znakami odstêpu: identyfikator matki, imiê, wiek.
		//		Przyk³ad:
		//		1 Agata 25
		//		Identyfikator matki z pliku noworodki.txt odpowiada identyfikatorowi w pliku mamy.txt.
		//		Wykorzystuj¹c dane zawarte w plikach mamy.txt i noworodki.txt oraz dostêpne narzêdzia informatyczne, wykonaj poni¿sze polecenia.
		//		Podaj imiê i wzrost najwy¿szego ch³opca oraz imiê i wzrost najwy¿szej dziewczynki.
		//		Uwaga: Jest tylko jeden taki ch³opiec i tylko jedna taka dziewczynka.
		//		W którym dniu urodzi³o siê najwiêcej dzieci? Podaj datê i liczbê dzieci.
		//		Uwaga: Jest tylko jeden taki dzieñ.
		//		Podaj imiona kobiet w wieku poni¿ej 25 lat, które urodzi³y dzieci o wadze powy¿ej 4000 g.
		//		Podaj imiona i daty urodzenia dziewczynek, które odziedziczy³y imiê po matce.
		//		W pliku noworodki.txt zapisane s¹ informacje o narodzinach bliŸni¹t. BliŸniêta mo¿na rozpoznaæ po tej samej dacie urodzenia 
		//		i tym samym identyfikatorze matki. Pamiêtaj, ¿e przyk³adowo Jacek i Agatka oraz Agatka i Jacek to ta sama para. Mo¿esz za³o¿yæ, 
		//		¿e w danych nie ma ¿adnych trojaczków, czworaczków, itd. Podaj daty, w których urodzi³y siê bliŸniêta.

		List<Matka> listaMatekZodczytanegoPliku = odczytajMatkiZPliku("mamy.txt");
		List<Dziecko> listaMatekZDziecmiZZOdczytanegoPliku = odczytajDzieciZPliku("noworodki.txt", listaMatekZodczytanegoPliku);
		System.out.println("Najwyzsze Dzieci");
//		System.out.print(Dziecko.imieNajwyzszejOsobyDanejPlci(listaMatekZDziecmiZZOdczytanegoPliku, "s").getImie());
//		System.out.println(Dziecko.imieNajwyzszejOsobyDanejPlci(listaMatekZDziecmiZZOdczytanegoPliku, "s").getWzrost());
//		System.out.print(Dziecko.imieNajwyzszejOsobyDanejPlci(listaMatekZDziecmiZZOdczytanegoPliku, "c").getImie());
//		System.out.println(Dziecko.imieNajwyzszejOsobyDanejPlci(listaMatekZDziecmiZZOdczytanegoPliku, "c").getWzrost());
		System.out.println("--------------------------------");
//		System.out.println(Dziecko.najwiecejUrodzonychDzieciDataOrazIlosc(listaMatekZDziecmiZZOdczytanegoPliku));
		System.out.println("--------------------------------");
		System.out.println();

	}

	public static List<Matka> odczytajMatkiZPliku(String plikOdczytaj) throws FileNotFoundException, IllegalAccessException {
		File f2 = new File(plikOdczytaj);
		Scanner s = new Scanner(f2);

		List<Matka> listaMatki = new ArrayList<Matka>();

		while (s.hasNextLine()) {
			String linia = s.nextLine();
			String[] separator = linia.split("\\ ");

			int identyfikator = Integer.parseInt(separator[0]);
			String imie = separator[1];
			int wiek = Integer.parseInt(separator[2]);

			Matka nowaMatka = new Matka(identyfikator, imie, wiek);
			listaMatki.add(nowaMatka);
		}
		return listaMatki;
	}

	public static List<Dziecko> odczytajDzieciZPliku(String plikOdczytaj, List<Matka> lista)
			throws FileNotFoundException, IllegalAccessException {
		File f1 = new File(plikOdczytaj);
		Scanner s = new Scanner(f1);

		List<Dziecko> listaDzieci = new ArrayList<Dziecko>();

		while (s.hasNextLine()) {
			String linia = s.nextLine();
			String[] separator = linia.split("\\ ");

			Matka matka = null;
			int identyfikator = Integer.parseInt(separator[0]);
			String plec = separator[1];
			String imie = separator[2];
			LocalDate dataUrodzenia = LocalDate.parse(separator[3]);
			int waga = Integer.parseInt(separator[4]);
			int wzrost = Integer.parseInt(separator[5]);
			int identyfikatorMatki = Integer.parseInt(separator[6]);

			for (Matka m : lista) {
				if (identyfikatorMatki == m.getIdentyfikator()) {
					matka = m;
				}

			}
			Dziecko noweDziecko = new Dziecko(identyfikator, imie, plec, dataUrodzenia, waga, wzrost, matka);
			listaDzieci.add(noweDziecko);

		}

		return listaDzieci;
	}
}
