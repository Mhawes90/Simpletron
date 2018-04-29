/*
 * Version 2.1  - can now take in decimal or hexadecimal!
 */

public class Test {
	static Simpletron program = new Simpletron();
	
	// I understand my tests are not super fantastic, but everything appears to be working well
	public static void main(String[] args) {
		// program.run();
		  testOne();
		// testTwo();
		// testThree();
	}
	
	// adds ten numbers and displays
	public static void testOne(){
		// test declaration
		int test [] ={10099, 10098, 10097, 10096, 10095, 10094, 10093, 10092, 10091, 10090, 
				20099, 30098, 30097, 30096, 30095, 30094, 30093, 30092, 30091, 30090, 
				21088, 11088, 43000, -999999};
		
		// set already made program into memory and run Simpletron
		program.setMemory(test);
		program.runTest();
	}
	
	// adds two numbers and then divides by the third, displays final and remainder
	// no idea why it keeps messing up....
	public static void testTwo(){
		// test declaration
		int test [] ={10099, 10098, 10097, 20099, 30098, 21096, 32097, 21095, 2096, 34097,
				21094, 11095, 11094, 43000, -999999};
		
		// set already made program into memory and run Simpletron
		program.setMemory(test);
		program.runTest();
	}
	
	public static void testThree(){
		// test declaration
		int test [] ={10099, 10098, 20099, 33098, 21097, 11097, 43000, -999999};
		
		// set already made program into memory and run Simpletron
		program.setMemory(test);
		program.runTest();
	}

}
