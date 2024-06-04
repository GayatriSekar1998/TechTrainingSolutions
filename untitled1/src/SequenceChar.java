public class SequenceChar {
    public static void main(String[] args) {
        String str = "aabbbccca";
        int count;
        char[] arrStr = str.toCharArray();
        String outputArr ="";
        for(int i=0;i<arrStr.length;) {
            outputArr = outputArr + arrStr[i];
            count = 1;
            for(int j=i+1;j<arrStr.length;j++) {
                if(arrStr[i] == arrStr[j]) {
                    count++;
                } else {
                    break;
                }
            }
            outputArr = outputArr + count;
            i = i+count;
        }

        System.out.print("outputArr: "+outputArr);
    }
}