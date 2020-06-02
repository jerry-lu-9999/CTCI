import java.util.HashMap;
import java.util.Map;
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
        
    }

    public static void main(String[] args) {
        System.out.print(URLify("Mr John Smith    ", 13));
    }
}