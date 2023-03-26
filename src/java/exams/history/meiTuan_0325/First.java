package exams.history.meiTuan_0325;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int groups = sc.nextInt();
            for (int i = 0; i < groups; i++) {
                int tLen = sc.nextInt();
                int[] inList = new int[tLen], outList = new int[tLen];
                for (int j = 0; j < tLen; j++)
                    inList[j] = sc.nextInt();
                for (int j = 0; j < tLen; j++)
                    outList[j] = sc.nextInt();
                boolean vaild = isVaild(tLen, inList, outList);
                System.out.println(vaild ? "Yes" : "No");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isVaild(int tLen, int[] inList, int[] outList) {
        if (tLen < 2)
            return true;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0, j = 0; i < tLen; i++) {
            int inT = inList[i], outT = outList[j];
            if (st.isEmpty()) {
                st.push(inList[i]);
            } else {
                while (st.peek() == outT){
                    st.pop();
                    outT = outList[j++];
                }
                st.push(inT);
            }
        }
        return st.isEmpty();
    }

}
