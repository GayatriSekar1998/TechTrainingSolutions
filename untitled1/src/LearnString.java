import java.io.*;
import java.util.*;

public class LearnString {
        // main function
        public static void main(String[] args) {
            String s = "LearnString stored inside string pool";//string literal
            String str = new String();//new keyword.
            str="Values are stored in heap memory";
            String input1,input2;
            System.out.println("String value s = " + s );
            System.out.println("String value str = " + str );

            System.out.println();


            s= "hello";

            System.out.println("String length = " + s.length());//5




            System.out.println("Character at 4th position = "
                    + s.charAt(3));//l


            System.out.println("Substring " + s.substring(3));//lo
            //s= hello
            // Returns the substring from i to j-1 index.
            System.out.println("Substring  = " + s.substring(2, 5));//llo

            String s1 = "Learn";
            String s2 ;
            s2 = s1.concat("String");

            System.out.println("String s1  = " +
                    s1);
            System.out.println("String s2 = " + s2) ;



            String s4 = "Learn Share Learn";
            System.out.println("Index of Learn " +
                    s4.indexOf("Learn"));//6

            // Returns the index within the string of the
            // first occurrence of the specified string,
            // starting at the specified index.
            System.out.println("Index of a  = " +
                    s4.indexOf('a', 3));

            // Checking equality of Strings
            Boolean out = "Hello".equals("hello");
            System.out.println("Checking Equality  " + out);
            out = "Hello".equals("Hello");
            System.out.println("Checking Equality  " + out);

            out = "Hello".equalsIgnoreCase("HeLLo");
            System.out.println("Checking Equality " + out);

            // If ASCII difference is zero then the two strings are similar
            int out1 = s1.compareTo(s2);// s1= a, s2 = A==> 97 -65 =>+ve >0
            System.out.println("the difference between ASCII value is=" + out1);
            // Converting cases
            String word1 = "Hello";
            System.out.println("Changing to lower Case " +
                    word1.toLowerCase());//hello

            // Converting cases
            String word2 = "Hello";
            System.out.println("Changing to UPPER Case " +
                    word2.toUpperCase());//HELLO

            // Trimming the word
            String word4 = " Learn Share Learn ";
            System.out.println("Before Trim {"+ word4+"}");
            System.out.println("Trim the word {"+ word4.trim()+"}");

            // Replacing characters
            String str1 = "Hello";
            System.out.println("Original String " + str1);
            String str2 = "Hello".replace('l', 'i');
            System.out.println("Replaced l with i -> " + str2);
        }
}