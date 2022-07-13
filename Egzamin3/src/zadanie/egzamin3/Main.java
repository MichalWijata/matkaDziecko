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
		//		Pliki noworodki.txt oraz mamy.txt zawieraj� dane o dzieciach i ich matkach.
		//		W pliku noworodki.txt ka�dy wiersz zawiera nast�puj�ce informacje o jednym dziecku, 
		//		rozdzielone znakami odst�pu: identyfikator, p�e� (c � c�rka, s � syn), imi�, data urodzenia, waga [g], wzrost [cm] oraz identyfikator matki.
		//		Przyk�ad:
		//		1 c Agnieszka 20-lis-1999 2450 48 33
		//		W pliku mamy.txt ka�dy wiersz zawiera informacje o jednej kobiecie, rozdzielone znakami odst�pu: identyfikator matki, imi�, wiek.
		//		Przyk�ad:
		//		1 Agata 25
		//		Identyfikator matki z pliku noworodki.txt odpowiada identyfikatorowi w pliku mamy.txt.
		//		Wykorzystuj�c dane zawarte w plikach mamy.txt i noworodki.txt oraz dost�pne narz�dzia informatyczne, wykonaj poni�sze polecenia.
		//		Podaj imi� i wzrost najwy�szego ch�opca oraz imi� i wzrost najwy�szej dziewczynki.
		//		Uwaga: Jest tylko jeden taki ch�opiec i tylko jedna taka dziewczynka.
		//		W kt�rym dniu urodzi�o si� najwi�cej dzieci? Podaj dat� i liczb� dzieci.
		//		Uwaga: Jest tylko jeden taki dzie�.
		//		Podaj imiona kobiet w wieku poni�ej 25 lat, kt�re urodzi�y dzieci o wadze powy�ej 4000 g.
		//		Podaj imiona i daty urodzenia dziewczynek, kt�re odziedziczy�y imi� po matce.
		//		W pliku noworodki.txt zapisane s� informacje o narodzinach bli�ni�t. Bli�ni�ta mo�na rozpozna� po tej samej dacie urodzenia 
		//		i tym samym identyfikatorze matki. Pami�taj, �e przyk�adowo Jacek i Agatka oraz Agatka i Jacek to ta sama para. Mo�esz za�o�y�, 
		//		�e w danych nie ma �adnych trojaczk�w, czworaczk�w, itd. Podaj daty, w kt�rych urodzi�y si� bli�ni�ta.

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
