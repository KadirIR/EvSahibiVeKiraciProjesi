import java.util.ArrayList;
import java.util.List;

//alt sınıfların kendi ihtiyaçlarına göre uygulaması için abstract metodunu kullandım
abstract class Konut {
    private String adres;

    public Konut(String adres) {
        this.adres = adres;
    }

    public void displayInfo() {
        System.out.println("Adres: " + adres);
    }
}
// Daire sınıfı, Konut sınıfından türetildi(extends edildi) ve Comparable arayüzünü uyguladı
class Daire extends Konut implements Comparable<Daire> {
    private String daireAdi;
    private int daireNo;
    private int apartmanNo;
    private Kiraci kiraci;

    public Daire(String daireAdi, int daireNo, int apartmanNo) {
        super("Cumhuriyet mahallesi sokak:1865 Kırklareli Merkez");
        this.daireAdi = daireAdi;
        this.daireNo = daireNo;
        this.apartmanNo = apartmanNo;
    }

    public void setKiraci(Kiraci kiraci) {
        this.kiraci = kiraci;
    }

    public void displayInfo() {
        System.out.println("Daire Adı: " + daireAdi + ",  Daire No: " + daireNo + ", Apartman No: " + apartmanNo);
        if (kiraci != null) {
            System.out.println("Kiracı: " + kiraci.getIsim() + " " + kiraci.getSoyisim());
        } else {
            System.out.println("Kiracı: Belirtilmemiş");
        }
    }
    @Override //üst sınıftaki metodu geçersiz kıldı
    public int compareTo(Daire other) {// DaireNo'ya göre küçükten büyüğe doğru sıralama yapar.
        return Integer.compare(this.daireNo, other.daireNo);
    }
}

class EvSahibi {
    private String isim;
    private String soyisim;
    private List<Daire> daireler;

    public EvSahibi(String isim, String soyisim) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.daireler = new ArrayList<>();
    }

    public void displayInfo() {
        System.out.println("Ev Sahibi: " + isim + " " + soyisim);
        daireler.sort(null);
        for (Daire daire : daireler) {
            daire.displayInfo();
        }
    }

    public void addApartment(Daire daire) {
        daireler.add(daire);
    }
    public void addDaire(Daire daire) {
        daireler.add(daire);
    }
}

class Kiraci {

    private String isim;
    private String soyisim;

    public Kiraci(String isim, String soyisim) {
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public void displayInfo() {
        System.out.println("Kiracı: " + isim + " " + soyisim);
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }
}
// Bina sınıfı, Konut sınıfından extends edildi
class Bina extends Konut {
    private int numberOfFloors;

    public Bina(int numberOfFloors, String adres) {
        super(adres);
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Kat Sayısı: " + numberOfFloors);
    }
}

public class Main {
    public static void main(String[] args) {

        Daire daire1 = new Daire("Özaydin", 1, 1);
        Daire daire2 = new Daire("Çiçek", 2, 1);
        Daire daire3 = new Daire("Atatürk", 3, 1);
        Daire daire4 = new Daire("Özcelik", 4, 1);
        Daire daire5 = new Daire("Güzelce", 5, 1);

        EvSahibi evSahibi1 = new EvSahibi("Didem ", "Gümüş");
        evSahibi1.addApartment(daire1);
        evSahibi1.addApartment(daire2);
        evSahibi1.addApartment(daire3);
        evSahibi1.addApartment(daire4);
        evSahibi1.addApartment(daire5);

        Kiraci kiraci1 = new Kiraci("Semra", "ır");
        Kiraci kiraci2 = new Kiraci("Merve", "ır");
        Kiraci kiraci3 = new Kiraci("Canset", "artis");
        Kiraci kiraci4 = new Kiraci("Gizem", "Gumus");
        Kiraci kiraci5 = new Kiraci("Sami", "Yakışıklı");

        daire1.setKiraci(kiraci1);
        daire2.setKiraci(kiraci2);
        daire3.setKiraci(kiraci3);
        daire4.setKiraci(kiraci4);
        daire5.setKiraci(kiraci5);

        System.out.println("### 1.Ev sahibinin bilgileri ###");
        evSahibi1.displayInfo();
        System.out.println();





        EvSahibi evSahibi2 = new EvSahibi("Kadir", "Ir");
        Daire daire6 = new Daire("Fırın", 6, 1);
        Daire daire7 = new Daire("Tepsi", 7, 1);
        Daire daire8 = new Daire("Tuzluk", 8, 1);

        evSahibi2.addDaire(daire6);
        evSahibi2.addDaire(daire7);
        evSahibi2.addDaire(daire8);

        Kiraci kiraci6 = new Kiraci("Zeycan", "Güzelkızdoğuran");
        Kiraci kiraci7 = new Kiraci("Elif", "Karakaş");
        Kiraci kiraci8 = new Kiraci("Alper", "Kaslı");

        daire6.setKiraci(kiraci6);
        daire7.setKiraci(kiraci7);
        daire8.setKiraci(kiraci8);

        System.out.println("### 2.Ev sahibinin bilgileri ###");
        evSahibi2.displayInfo();

        System.out.println();
        Bina bina = new Bina(8,"Cumhuriyet mahallesi sokak:1865 Kırklareli Merkez");
        System.out.println("### Bina Bilgileri ###");
        bina.displayInfo();
        System.out.println();

    }
}