import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

public class Chapter1 {
    //1.1
    public static boolean isUnique(String s) {
        Map<Character, Integer> hs = new HashMap<>();
        for (char a : s.toCharArray()) {
            hs.compute(a, (key, val) -> (val == null) ? 1 : val + 1);
        }
        for (Map.Entry<Character, Integer> entry : hs.entrySet()) {
            if(entry.getValue() == 1){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    //1.3
    public static String URLify(String str, int length){
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(ch[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    //1.4 Palindrome
    public static boolean isPalinPer(String str){
        Map<Character, Integer> hs = new HashMap<>();
        int length = str.length();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ') {
                length--;
                continue;
            }
            char c = Character.toLowerCase(str.charAt(i));
            hs.compute(c, (key, val) -> (val == null) ? 1 : val+1);
        }
        boolean appeared = false;
        System.out.println(hs);
        for(Map.Entry<Character, Integer> entry: hs.entrySet()){
            int val = entry.getValue();
            if(val >= 3)    return false;
            if (length % 2 ==0 && val == 1) {
                return false;
            }else if(length % 2 == 1 && val == 1 && appeared == true){
                return false;
            }
            if(val == 1) appeared = true;
        }
        return true;
    }

    public static boolean oneAway(String a, String b){
        if(a.equals(b)) return true;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        //int length = (a.length() >= b.length()) ? b.length() : a.length();
        boolean modified = false;
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(charA[i] == charB[j]){
                i++; j++;
            }
            if(charA[i] != charB[j]){ 
                if(modified)    return false;
                else{
                    modified = true;
                    if(charA[i+1] == charB[j]){
                        i++;
                    }else if(charA[i] == charB[j+1]){
                        j++;
                    }
                }
            }
        }
        return true;
    }

    public static String compression(String str){
        Stack<Character> st = new Stack<>();        //stack is not even necessary here
        StringBuilder sb = new StringBuilder();
        st.push(str.charAt(0)); sb.append(str.charAt(0));

        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(st.peek() == str.charAt(i)){
                count++;
            }else{
                sb.append(count);
                st.push(str.charAt(i));
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        String newStr = sb.toString();
        return (newStr.length() < str.length()) ? newStr : str;
    }

     public static int[][] rotate(int[][]matrix){
        //int[][] rotateM = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length / 2; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        for(int m = 0; m < matrix.length; m++){
            for(int n = m+1; n < matrix.length; n++){
                int temp = matrix[m][n];
                matrix[m][n] = matrix[n][m];
                matrix[n][m] = temp;
            }
        }
        return matrix;
     }
    public static void main(String[] args) {
        int[][]matrix = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(rotate(matrix));
    }
}