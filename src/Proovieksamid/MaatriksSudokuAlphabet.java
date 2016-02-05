
import java.util.Arrays;

/**
 * Prindi konsooli 27x27 maatriks, kus on täidetud eesti tähestiku sudoku.
 * https://et.wikipedia.org/wiki/Eesti_t%C3%A4hestik
 */
public class MaatriksSudokuAlphabet {

    static String[][] sudoku = new String[27][27];

    static String[] alphabet = new String[]{"A", "B", "D ","E", "F", "G","H", "I", "J","K", "L", "M","N", "O", "P","R", "S", "Ð","Z", "Þ", "T","U","V", "Õ", "Ä","Ö","Ü"};

    public static void main(String[] args) {

        int edasinihe = 0;

        for (int i = 0; i < 27; i++) {
            for (int j = edasinihe; j < 27; j++) {
                sudoku[i][j] = alphabet[j-edasinihe];
            }
            edasinihe += 1;
        }

        int tagasinihe = 0;

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < tagasinihe; j++) {
                sudoku[i][j] = alphabet[27-tagasinihe + j];
            }
            tagasinihe += 1;
        }

        for (String[] ss : sudoku) {
            System.out.println(Arrays.toString(ss));
        }

    }
}
