package teema1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Salvesta kasutajalt 10 numbrit ja sorteeri suuruse järgi. (int[])
 * 2. Salvesta kasutajalt 10 sõne ja sorteeri tähestikulises järjekorras. (String[])
 * 3. Salvesta kasutajalt x arv numbreid, lõpeta küsimine kui number on 0
 *    ja sorteeri tulemus suuruse järgi. (ArrayList)
 *
 * main() meetodi saad lühendiga psvm.
 */
public class Harjutus4_massiivid {

    static int[] numbrid = new int[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int counter = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("Sisesta number " + counter + ":");
            numbrid[i] = sc.nextInt();
            counter ++;
        }

        System.out.println(Arrays.toString(numbrid));

        Arrays.sort(numbrid);

        System.out.println(Arrays.toString(numbrid));

    }
}
