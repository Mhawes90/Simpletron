import java.util.Scanner;

// ignore this test

public class TestHex {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int [] hexNums = {0xFF, 0x1010, 0x64};
		
		System.out.println(hexNums[1]);
		
		// stringTest();
		testHex();
	}
	
	public static void stringTest(){
		System.out.println("Enter string");
		String text = input.next();
		int number = input.nextInt();
		
		System.out.println(number);
		System.out.println(text);
		
		for(int i = 0; i < text.length(); i++){
			int letterValue = Character.getNumericValue(text.charAt(i));
			if (letterValue != 18 && letterValue != 14)
				System.out.println(letterValue);
		}
	}
	
	public static void testHex(){
		System.out.println("Enter hexadecimal");
		
		// take in hex, and converts to useable int
		int temp = Integer.decode(input.next());
		
		System.out.println(temp);
		
	}

}
