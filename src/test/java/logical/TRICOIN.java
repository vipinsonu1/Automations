
package logical;

import java.util.*;

public class TRICOIN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if ((T >= 1) && (T <= 100)) {
            for (int i = 1; i <= T; i++) {
                long n = sc.nextLong();
                long r = 0, c = 1;
                while (n > 0) {
                    n = n - c;
                    if (n >= 0) {
                        r++;
                        c++;
                    }
                }
                System.out.println(r);
            }
        }
    }
}
