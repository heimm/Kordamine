package OOP_Pommitamine;

import java.util.Scanner;

/**
 * Created by mjaager on 21.11.15.
 */
public class Mangija {
    private Scanner sc = new Scanner(System.in);

    public int[] kysiLasuKoordinaadid() {
            System.out.println("Palun sisesta lasu koordinaadid fomraadis xxx-yyy");
            String[] sisestus = sc.nextLine().split("-");
            int x = Integer.parseInt(sisestus[0]);
            int y = Integer.parseInt(sisestus[1]);
            return new int[] {x, y};
    }

    public void pihtas() {
        System.out.println("PIHTAS, lol");
    }

    public void moodas() {
        System.out.println("Möödas, lol");
    }

    public void gameOver() {
        System.out.println("LÄBI");
    }
}



