
public class Prompts {

	// moved all prompts into it's own class for better organization
	// I didn't like how large Simpletron was getting
	protected void welcomeMessage() {
        System.out.println("***            Welcome to Simpletron!           ***");
        System.out.println("*** Please enter your program, one instruction  ***");
        System.out.println("*** (or data word) at a time. I will display    ***");
        System.out.println("*** the location number and a question mark (?) ***");
        System.out.println("*** You then type the number for that location.   ***");
        System.out.println("*** Type -999999 to stop entering your program.  ***");
        System.out.println();
    }
	
	protected void inputTerminatePrompt(){
		System.out.println("*** Program loading completed ***");
		System.out.println("*** Program execution begins ***");
		System.out.println();
	}
	
	protected void inputPrompt(int memoryNumber){
		// displays the Simpletron input prompt
		System.out.printf("%02d ? ", memoryNumber);
	}
	
	protected void dumpDisplayText(int accumulator, int instructionCounter, 
			int instructionRegister, int operationCode, int operand){
		System.out.printf("Registers:%n");
		System.out.printf("accumulator %12s %5d %n", "", accumulator);
		System.out.printf("instructionCounter %5s %5d %n", "", instructionCounter);
		System.out.printf("instructionRegister %4s %5d %n", "", instructionRegister);
		System.out.printf("operationCode %10s %5d %n", "", operationCode);
		System.out.printf("operand %16s %5d %n", "", operand);
		//blank line
		System.out.println();
		System.out.println("MEMORY: ");
	}
}
