package teema2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Loo laevade pommitamine, kus on vaid 1x1 laevad ja kasutaja saab arvuti laevasid pommitada 9x9 maatriksil.
 */
public class Kordamine1_laevad_maatriksil {
    static int[][] laud;
    static int  lauaLaius = 4;
    static int lauaKorgus = 4;



    public static void main(String[] args) {
        genereeriLaud();
        laevaGenereerimine();
        int[] xy = kysiPommitamiseAsukohta();
        kontrolliTabamust(xy);
        // kasOnVeelAllesLaevu();
        // gameOver();
    }

    private static void kontrolliTabamust(int[] xy) {
        int x = xy[0];
        int y = xy[1];
        int sihtpunkt = laud[y][x];
        if (sihtpunkt == 1){
            System.out.println("PIHTAS!");
            laud[y][x] = 2;
        }else if (sihtpunkt == 0){
            System.out.println("Mööda!");
        }
    }

    private static int[] kysiPommitamiseAsukohta() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ütle rea number: ");
            int x = sc.nextInt() - 1;
            System.out.println("Ütle veeru number: ");
            int y = sc.nextInt() - 1;
            int[] xy = {x, y};
            return xy;

        } catch (Exception e) {
            System.out.println("Kirjuta ikka number!");
        }
        return kysiPommitamiseAsukohta();


    }

    private static void laevaGenereerimine() {
        for (int i = 0; i < lauaKorgus; i++) {
            for (int j = 0; j < lauaLaius; j++) {
                laud[i][j] = (int) (Math.random() * 2);

            }
            System.out.println(Arrays.toString(laud[i]));
        }
    }

    private static void genereeriLaud() {

        laud = new int[lauaKorgus][lauaLaius];
    }
}
