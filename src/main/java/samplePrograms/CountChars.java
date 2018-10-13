package samplePrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountChars {

	public void countChars(String s) {
		s= s.toLowerCase();

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for(int i = 0 ; i < s.length(); i++){
			char ch = s.charAt(i);

			if(charMap.containsKey(ch) /*charMap.get(ch) != null*/){
				charMap.put(ch, ((int)(charMap.get(ch)))+1);
			}else{
				charMap.put(ch, 1);
			}
		}

		for(Entry entry : charMap.entrySet()){
			System.out.println("Character is: "+ entry.getKey()+ " Count is : "+ entry.getValue());
		}

	}

	public static void main(String args[]){
		String s = "Paypal";

		new CountChars().countChars(s);
		
		System.out.println(Math.pow(-6,2));
	}
	
}
