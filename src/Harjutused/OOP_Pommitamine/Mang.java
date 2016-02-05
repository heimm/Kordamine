package OOP_Pommitamine;

/**
 * Mere ja laevastiku genereerimine.
 * Mängu loogika. Kuni laevu on elus, siis küsi koordinaate, pommita merd, anna tagasisidet, kui mäng läbi.
 */
public class Mang {
    public Mang() {
        System.out.println("START MÄNG");
        Meri meri = new Meri(10);
        Mangija mangija = new Mangija();

        while (meri.kasOnLaevuElus()) {
            meri.kuvaSeis();
            System.out.println("NEXT ROUND");
            int[] lask = mangija.kysiLasuKoordinaadid();
            boolean pihtas = meri.kasKeegiSaiPihta(lask);
            if (pihtas) {
                mangija.pihtas();
            } else {
                mangija.moodas();
            }
        }
        mangija.gameOver();
    }
}
