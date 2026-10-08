import java.util.*;

public class Veri {

    public static Map<Integer, List<Urun>> masaSiparisleri = new HashMap<>();

    public static class Urun {
        String ad;
        int fiyat,adet;
        

        public Urun(String ad, int fiyat, int adet) {
            this.ad = ad;
            this.fiyat = fiyat;
            this.adet = adet;
        }
    }

    public static void main(String[] args) {
    }
}
