import java.util.ArrayList;

public class birincigun {

	public static void main(String[] args) {

		System.out.println(isPolindrom("kayak"));
		System.out.println(tersCevir("deneme"));
		int[] dizi = { 1, 8, 7, 20, 13, 53 };
		System.out.println(minGap(dizi)); // dizideki sıralı eleman ikilisinden en küçük farklıyı yazdırma
		System.out.println(CollatzCalculate(15)); // 
		System.out.println(maxGap(dizi));
		System.out.println(asalSayi(dizi)); // asal sayıları yazdırma
		System.out.println(asalSayi(dizi).size()); // kaç tane olduğunu yazdırma

		// yıldız yazdırma

		for (int satir = 1; satir <= 9; satir++) {
			for (int sutun = 1; sutun <= 9; sutun++) {
				if (satir == 1 || satir <= sutun) {
					System.out.print("*");
					System.out.print(" ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();

		}

		String string = "ıi";
		System.out.println(romanToInt(string));

		int i = 50;
		int j = 0;
		while (i >= 1) {
			j += i;
			i = i - 2;
		}
		System.out.println("toplam: " + j);

		int k = 0;
		for (int l = 50; l >= 1; l = l - 2) {
			k += i;
		}
		System.out.println("toplam: " + j);
	}
	
	// aranan harf kaç tane
	public static int SayiBul(String metin) {
		char aranan = 'e';
		int toplam = 0;
		for (int i = 0; i < metin.length(); i++) {
			char gecici = metin.charAt(i); // dizi[i]
			if (gecici == aranan) {
				toplam += 1;
			}
		}
		return toplam;
	}

	// kelimeyi ters çevirme
	public static String tersCevir(String metin) {
		String kelime = "";
		for (int i = (metin.length() - 1); i >= 0; i--) {// deneme
			char gecici = metin.charAt(i);
			kelime += gecici;// diziler --> dizi[i] string --> kelime.charAt(i)
		}
		return kelime;
	}

	// kelimenin tersten yazılışı ve normal yazılışı aynı mı 
	public static boolean isPolindrom(String kelime) {
		int baslangic = 0;
		int bitis = kelime.length() - 1;
		while (baslangic < bitis) {
			if (kelime.charAt(baslangic) != kelime.charAt(bitis)) {
				return false;
			}
			baslangic++;
			bitis--;
		}
		return true;
	}

	// dizideki sıralı eleman ikilisinden en küçük farklıyı yazdırma
	public static int minGap(int[] dizi) {
		if (dizi.length < 2) {
			return 0;
		}
		int enKucuk = dizi[1] - dizi[0];
		for (int i = 0; i < dizi.length - 2; i++) {
			int fark = dizi[i + 1] - dizi[i];
			if (fark < enKucuk) {
				enKucuk = fark;
			}
		}
		return enKucuk;
	}

	// verilen sayıyı bir olana kadar işlem uygulamam
	public static ArrayList<Integer> CollatzCalculate(int sayi) {
		ArrayList<Integer> cıktıDizisi = new ArrayList<>();
		while (sayi != 1) {
			if (sayi % 2 == 0) {
				sayi = sayi / 2;
				cıktıDizisi.add(sayi);
			} else {
				sayi = 3 * sayi + 1;
				cıktıDizisi.add(sayi);
			}
		}
		return cıktıDizisi;
	}

	// dizideki sıralı eleman ikilisinden en büyük farklıyı yazdırma
	public static int maxGap(int[] dizi) {

		int enBuyuk = dizi[1] - dizi[0];
		for (int sayac = 0; sayac < dizi.length - 2; sayac++) {
			if (dizi[sayac + 1] - dizi[sayac] > enBuyuk) {
				enBuyuk = dizi[sayac + 1] - dizi[sayac];
			}
		}

		return enBuyuk;

	}

	// listedeki asalları döndürme
	public static ArrayList<Integer> asalSayi(int[] dizi) {
		ArrayList<Integer> asallar = new ArrayList<Integer>();

		for (int sayac = 0; sayac < dizi.length; sayac++) {
			boolean asalMi = true;
			for (int sayi = 2; sayi < dizi[sayac]; sayi++) {
				if (dizi[sayac] % sayi == 0) {
					asalMi = false;
					break;
				}
			}
			if (asalMi) {
				asallar.add(dizi[sayac]);
			}

		}
		return asallar;
	}

	// roman rakamlarıyla olan ifadeyi sayı olarak yazma ( birkaç eksik olabilir. mesela küçük harfleri büyük yapamıyorum. )
	public static int romanToInt(String s) {
		int result = 0;
		s.toUpperCase();
		// "MCMXCIV"
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'I') {
				if (i != s.length() - 1) {
					if (s.charAt(i + 1) == 'V') {
						result += 4;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
				}
				if (i != s.length() - 1) {
					if (s.charAt(i + 1) == 'X') {
						result += 9;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
				}

				result += 1;
			} else if (s.charAt(i) == 'V') {
				result += 5;
			} else if (s.charAt(i) == 'X') {
				if (i != s.length() - 1) {
					if (s.charAt(i + 1) == 'L') {
						result += 40;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
					if (s.charAt(i + 1) == 'C') {
						result += 90;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
				}

				result += 10;
			} else if (s.charAt(i) == 'L') {
				result += 50;
			} else if (s.charAt(i) == 'C') {
				if (i != s.length() - 1) {
					if (s.charAt(i + 1) == 'D') {
						result += 400;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
					if (s.charAt(i + 1) == 'M') {
						result += 900;
						if (i != s.length() - 1) {
							i++;
							continue;
						}

					}
				}

				result += 100;
			} else if (s.charAt(i) == 'D') {

				result += 500;
			} else if (s.charAt(i) == 'M') {
				result += 1000;
			}
		}
		return result;

	}
}
