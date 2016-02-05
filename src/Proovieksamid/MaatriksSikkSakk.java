import java.util.Arrays;

/**
 * Prindi konsooli 10x100 maatriks, kus läheb joon sikk-sakk ülevalt alla.
 *
 * Näide:
 * x
 *  x
 *   x
 *    x
 *     x
 *      x
 *       x
 *        x
 *         x
 *          x
 *         x
 *        x
 *       x
 *      x
 *     x
 *    x
 *   x
 *  x
 * x
 *  x
 *   x
 *    x
 *     x
 *      jne.
 *
 * Kasuta mis iganes tähiseid soovid ülesande lahendamiseks.
 */
public class MaatriksSikkSakk {

    static int currentrida = 0;
    static int currentaste = 0;
    static int[][] sikksakk = new int[100][10];

    public static void main(String[] args) {

        int kordaja = 0;
        while (kordaja < 5){
            paremaleSakk();
            currentrida +=9;
            vasakuleSakk();
            currentrida +=9;
            kordaja += 1;
            System.out.println(currentrida);
        }

        paremaleSakk2();

        for (int[] arr : sikksakk) {
            System.out.println(Arrays.toString(arr));
        }

    }

    private static void paremaleSakk2() {
        int lykats1 = 0;

        for (int i = currentrida; i < currentrida + 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == lykats1){
                    sikksakk[i][j] = 5;
                }
            }
            lykats1 +=1;
        }
    }

    public static void paremaleSakk(){
        int lykats1 = 0;

        for (int i = currentrida; i < currentrida + 9; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == lykats1){
                    sikksakk[i][j] = 5;
                }
            }
            lykats1 +=1;
        }
    }

    public static void vasakuleSakk(){
        int lykats = 9;

        for (int i = currentrida; i < currentrida + 9; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == lykats){
                    sikksakk[i][j] = 5;
                }
            }
            lykats -=1;
        }


    }


}

