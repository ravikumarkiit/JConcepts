package samplePrograms;

import java.util.stream.IntStream;

public class Palindrome {
	
	public static boolean isPalindromeUsingJava8(String S) {
    	/*S = S.replaceAll("\\s",	"");
        String reversedStr = new StringBuilder(S).reverse().toString();
        return S.equals(reversedStr) ? "true" : "false";*/
		
		
        String cleanString = S.toLowerCase().replaceAll("\\s",	"");
        
        /** noneMatch() will run till predicate is FALSE, when exhausted returns TRUE */
        return IntStream.range(0, cleanString.length()/2).noneMatch(i -> cleanString.charAt(i)!=cleanString.charAt(cleanString.length()-1-i));
        
        /*return IntStream.range(0, cleanString.length()/2).noneMatch(i -> 
        {
        	System.out.println(i);
        	return cleanString.charAt(i)!=cleanString.charAt(cleanString.length()-1-i);
        });*/
    }
	
    public static boolean isPalindrome(String word) {
    	boolean flag = true;
    	word = word.toLowerCase();
        int length = word.length();
        String s1 = word.substring(0, length/2);
        String s2 = word.substring(length/2, length);
        System.out.println(s1 + " " + s2);
        int lastIndex = s2.length() -1;
        
        for (int i = 0; i < s1.length(); i++) {
        	if(s1.charAt(i) != s2.charAt(lastIndex)) {
        		flag = false;
        	}
        	if(flag) {
        		--lastIndex;
        	}else {
        		break;
        	}
        	
        }
        return flag;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Delevveled"));
        System.out.println(Palindrome.isPalindromeUsingJava8("Delevveled"));
        System.out.println(Palindrome.isPalindromeUsingJava8("Delev12veled"));
    }
}
