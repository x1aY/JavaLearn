package leetcode.CodeCaprice.AA_array.B_doublePointer;

public class D_stringsBackspacesCompare_844 {

    public static boolean backspaceCompare(String s, String t) {
        return strClear(s).equals(strClear(t));
    }

    public static String strClear(String str) {
        char backspace = '#';
        StringBuilder strSB = new StringBuilder();
        for (char chari : str.toCharArray()) {
            if(chari!=backspace)
                strSB.append(chari);
            else if(strSB.length()!=0)
                strSB.deleteCharAt(strSB.length()-1);
        }
        return strSB.toString();
    }


    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }
}
