package work;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 4/24/2017.
 */
public final class First {

    /**
     *
     * @param args - program parameters
     */
    private static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int q = 1; q < n; q++) {
            if ((n % (q * q) == 0) && (n % (q * q * q) > 0)) {
                result.add(q);
            }
        }

        System.out.println(result);

    }
}
