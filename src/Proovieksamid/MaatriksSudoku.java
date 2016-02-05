import java.util.Arrays;

/**
 * Prindi konsooli 9x9 maatriks sudoku numbritega.
 */
public class MaatriksSudoku {



    public static void main(String[] args) {

        int[][] laud = new int[9][9];

        int edasi = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = edasi; j < 9; j++) {
                laud[i][j] = 1 + j-edasi;
            }
            edasi += 1;
        }

        int piiraja = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < piiraja; j++) {
                laud[i][j] = 10 - piiraja +j;
            }
            piiraja += 1;
        }


        for (int[] arr : laud) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
