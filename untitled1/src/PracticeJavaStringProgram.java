import java.util.*;

public class PracticeJavaStringProgram {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.next();//hello

        //logic to reverse a string

        String revereStr="";
        char c;
        for(int i=0; i<str.length(); i++) {
            c= str.charAt(i);
            revereStr=c+revereStr;
        }
        System.out.print(revereStr);


    }
}