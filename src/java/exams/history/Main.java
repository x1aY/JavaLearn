package exams.history;
import java.util.*;
// import java.lang.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            /**
             * while(sc.hasNext()) String str = sc.next();
             * while(sc.hasNextInt()) String str = sc.nextInt();
             * while(sc.hasNextDouble()) String str = sc.nextDouble();
             */
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");

                int a = Integer.parseInt(line[0]),
                        b = Integer.parseInt(line[1]);
                int ans = solution(a, b);

                System.out.println(ans);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int solution(int a, int b) {
        return a + b;
    }

}
