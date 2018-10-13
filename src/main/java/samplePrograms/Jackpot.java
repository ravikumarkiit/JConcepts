package samplePrograms;

public class Jackpot {

	public static long getJackpot(String jackpot_String, String input_String) throws Exception {
		//Valid if equal length of inputs (modify getPrizeMoney() to handle higher length)

		if(jackpot_String.length() != input_String.length())
			throw new Exception("Invalid Input");

		if(jackpot_String.equals(input_String))
			return getPrizeMoney(-1);

		char[] charList = input_String.toCharArray();
		int matchCount = 0;
		for(int i=0;i<charList.length;i++) {
			if(jackpot_String.contains(String.valueOf(charList[i]))) {
				jackpot_String = jackpot_String.replaceFirst(String.valueOf(charList[i]), "x");
				matchCount++;
			}
		}
		//return getPrizeMoney(jackpot_String.length() - jackpot_String.replace("x", "").length());
		return getPrizeMoney(matchCount);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(Jackpot.getJackpot("132", "132") == 1000);
		System.out.println(Jackpot.getJackpot("933", "321") == 400);
		System.out.println(Jackpot.getJackpot("111", "117") == 600);
		System.out.println(Jackpot.getJackpot("773", "733") == 600);
		System.out.println(Jackpot.getJackpot("112", "121") == 800);
		System.out.println(Jackpot.getJackpot("134", "257") == 0);
		System.out.println(Jackpot.getJackpot("000", "000") == 1000);
		System.out.println(Jackpot.getJackpot("000", "010") == 600);
		System.out.println(Jackpot.getJackpot("100", "000") == 600);

		System.out.println(Jackpot.getJackpot("1321", "1321") == 1000);
		System.out.println(Jackpot.getJackpot("1231", "1321") == 900);
		System.out.println(Jackpot.getJackpot("9334", "4321") == 600);	

		System.out.println(Jackpot.getJackpot("23", "23") == 1000);
		System.out.println(Jackpot.getJackpot("32", "23") == 600);

		System.out.println(Jackpot.getJackpot("1", "1") == 1000);
		System.out.println(Jackpot.getJackpot("0", "0") == 1000);
	}

	public static long getPrizeMoney(long matchCount) {
		if(matchCount == -1) {
			return 1000;//jackpot
		} else if (matchCount ==4) {
			return 900;
		} else if (matchCount ==3) {
			return 800;
		} else if (matchCount ==2) {
			return 600;
		}else if (matchCount ==1) {
			return 400;
		}else {
			return 0;
		}
	}
	
	/*public static long getJackpot(String jackpot_String, String input_String) throws Exception {
		Valid if equal length of inputs (modify getPrizeMoney() to handle higher length)
		if(jackpot_String.length() != input_String.length()) {
			throw new Exception("Invalid Input");
		}
		
		int adder = Integer.parseInt(Integer.toBinaryString(2<<(jackpot_String.length()-1)));
		int jackpot_int = Integer.parseInt(jackpot_String)+ adder;
		int inputCompare = 0;
		List<Character> charListRemaining = new ArrayList<>();

		if(jackpot_String.equals(input_String)) {
			return getPrizeMoney(-1);
		}
		int dd = 0;
		List<Character> charList = input_String.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		for(Character ch : charList) {
			if(jackpot_String.contains(ch.toString())) {
				int index = jackpot_String.length() -1- jackpot_String.indexOf(ch);
				jackpot_String = jackpot_String.replaceFirst(ch.toString(), "x");
				int multiplier = Integer.parseInt(Integer.toBinaryString(2<<(index-1)));
				inputCompare =  inputCompare + (multiplier > 0 ? multiplier : 1 )* Integer.parseInt(ch.toString());
				++dd;
			} else {
				charListRemaining.add(ch);
			}
		}
		String inputCompareString = String.valueOf(inputCompare + adder);
		for(char ch : charListRemaining) {
			inputCompareString = inputCompareString.replaceFirst(String.valueOf(inputCompareString.charAt(inputCompareString.indexOf("0"))), String.valueOf(ch));
		}
		int input_int = Integer.parseInt(inputCompareString);
		int result = jackpot_int > input_int ? jackpot_int+adder - input_int : input_int+adder - jackpot_int;
		long matchCount = String.valueOf(result).chars().filter(ch -> ch == '0').count();
		System.out.println("Match Count= "+ matchCount +" "+dd);
		return getPrizeMoney(matchCount);
	}*/

}
