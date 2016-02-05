import java.util.Arrays;

/**
 * Prindi konsooli 9x9 maatriks selliselt, et
 * joonistub suur X üle laua, nagu bingo diagonaalid.
 *
 * Näide:
 *
 * x       x
 *  x     x
 *   x   x
 *    x x
 *     x
 *    x x
 *   x   x
 *  x     x
 * x       x
 *
 * Kasuta mis iganes tähiseid soovid ülesande lahendamiseks.
 */
public class MaatriksBingo {

    public static void main(String[] args) {
        int[][] bingo = new int[9][9];

        int samm = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j == samm){
                    bingo[i][j] = 5;
                }
            }
            samm ++;
        }

        int samm2 = 8;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j == samm2){
                    bingo[i][j] = 5;
                }
            }
            samm2--;
        }


        for (int[] arr : bingo) {
            System.out.println(Arrays.toString(arr));
        }


    }
}

