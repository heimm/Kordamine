package teema2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Martin on 29.01.2016.
 */
public class Pommitamine {

    static int ridu = 4;
    static int veerge = 4;
    static Scanner kysiridu = new Scanner(System.in);
    static Scanner kysiveerge = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] laud = new int[ridu][veerge];


        for (int i = 0; i < ridu; i++) {
            for (int j = 0; j < veerge; j++) {
                laud[i][j] = (int)(Math.random()*2);
            }
        }

        for (int[] arr : laud) {
            System.out.println(Arrays.toString(arr));
        }

        while (!kasonlaevu(laud)){
            System.out.println("Rida:");
            int riduvastus = kysiridu.nextInt() - 1;
            System.out.println("Tulp:");
            int veergevastus = kysiveerge.nextInt() - 1;

            if (laud[riduvastus][veergevastus] == 1){
                System.out.println("Pihtas!");
                laud[riduvastus][veergevastus] = 2;
            }else if(laud[riduvastus][veergevastus] == 0){
                System.out.println("M66das!");
                laud[riduvastus][veergevastus] = 2;
            }else if(laud[riduvastus][veergevastus] == 2){
                System.out.println("Juba lasid siia!");
            }
        }
        System.out.println("game oveeer!");
    }

    public static boolean kasonlaevu(int[][] x){

        for (int i = 0; i < ridu; i++) {
            for (int j = 0; j < veerge; j++) {
                if (x[i][j] == 1){
                    return false;
                }

            }
        }

        return true;
    }

}
