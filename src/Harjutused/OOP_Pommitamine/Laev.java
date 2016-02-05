package OOP_Pommitamine;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mjaager on 21.11.15.
 */
public class Laev {
    private int[] koordinaadid;
    private boolean elus = true;

    public Laev(int mereServaPikkus) { //see küsib mereservapikkuse igakord, kui selle meetodi callid!
        System.out.println("START LAEV");
        genereeriKoordinaadid(mereServaPikkus);
    }

    private void genereeriKoordinaadid(int mereServaPikkus) {
        Random rand = new Random();
        int x = rand.nextInt(mereServaPikkus);
        int y = rand.nextInt(mereServaPikkus);
        koordinaadid = new int[]{x, y};
        System.out.println(Arrays.toString(koordinaadid));
    }

    public boolean kasOledElus() {
        return elus;
    }

    public boolean kasSaidPihta(int[] lask) {
        if (Arrays.equals(lask, koordinaadid) && elus) {
            elus = false;
            return true;
        }
        return false;
    }

    public int[] annaKoordinaadid() {
        return koordinaadid;
    }
}
