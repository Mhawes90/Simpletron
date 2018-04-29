import java.util.Scanner;

public class Simpletron extends OperationCodes{
	private final int maxMemory = 0x3E8; // 0x3E8 = 1000 in hex
	private int memory [] = new int [maxMemory]; 
	private int accumulator;
	private int instructionCounter;
	private int instructionRegister;
	private int operationCode;
	private int operand;
	private boolean run = true;
	private Prompts prompt = new Prompts();
	private Scanner input = new Scanner(System.in);
	
	protected void run(){
		// runs full program
		prompt.welcomeMessage();
		enterProgram();
		prompt.inputTerminatePrompt();
		performProgram();
		input.close();
	}
	
	protected void runTest(){
		// runs full program
		prompt.welcomeMessage();
		// no need to enter program because we the memory already set by setMemory method
		prompt.inputTerminatePrompt();
		performProgram();
	}
	
	protected void setMemory(int [] setMemory){
		int i = 0;
		
		for(int tempMemory: setMemory){
			if(tempMemory == -999999)
				memory[i] = 0;
			else
				memory[i] = tempMemory;
			i++;
		}
	}
	
	protected void enterProgram(){
		int instruction = 0;
		int memoryLoc = 0;
		
		do{
			prompt.inputPrompt(memoryLoc);
			// found this can take in decimal and hex numbers! woot!
			instruction = Integer.decode(input.next());
			if (instruction == -999999)
				memory[memoryLoc] = 0;
			else if (instruction > 99999){
				System.out.println("*** Invalid instruction input ***");
				System.out.println("*** Simpletron exectution abnormally terminated ***");
				System.exit(-1);
			}
			else
				memory[memoryLoc] = instruction;
			memoryLoc++;
		}while(instruction != -999999);
	}
	
	protected void convertToCommand(String stringInstruction){
		// turn input work into a number (to store) then into corresponding command
		int length = stringInstruction.length();
		
		for(int i = 1; i < length; i++){
			
		}
	}
	
	public void performProgram(){
		while(run){
			convertToOperation();
			performOperation(operationCode, operand);
		}
	}
	
	protected void performOperation(int operationCode, int operand){
		
		// determintes what to do based on opCode number
		// only using integers for input for simplicity-sake
		switch(operationCode){
		case READ:
			System.out.println("Enter an integer");
			memory[operand] = input.nextInt(); break;
			
		case WRITE:
			System.out.println(memory[operand]); break;
		
		case LINE:
			System.out.println(); break;
			
		case LOAD:
			accumulator = memory[operand]; break;
			
		case STORE:
			memory[operand] = accumulator; break;
			
		case ADD:
			accumulator += memory[operand]; break;
			
		case SUBTRACT:
			accumulator -= memory[operand]; break;
			
		case DIVIDE:
			if(memory[operand] == 0){
				System.out.println("*** Can't divide by zero ***");
				System.out.println("*** Simpletron exectution abnormally terminated ***");
				run = false;
			}
			else
				accumulator /= memory[operand]; 
			break;
				
		case MULTIPLY:
			accumulator *= memory[operand]; break;
			
		case REMAINDER: 
			accumulator %= memory[operand]; break;
			
		case BRANCH:
			instructionCounter = operand--; break;
			
		case BRANCHNEG:
			if (accumulator < 0)
				instructionCounter = operand--;
			break;
			
		case BRANCHZERO:
			if (accumulator == 0)
				instructionCounter = operand--;
			break;
			
		case HALT:	// end program
			System.out.println();
			System.out.println("*** Simpletron execution terminated ***"); 
			System.out.println();
			dump(); 
			run = false; break;
		}
		
		// added a minus one to all branches to avoid using a boolean for branching
		// or other probably more complicated solutions
		instructionCounter++;
	}
	
	// converts memory into operator/operand
	protected void convertToOperation(){
		if (instructionCounter < maxMemory)
			instructionRegister = memory[instructionCounter];
		
		operationCode = instructionRegister / maxMemory;
		operand = instructionRegister % maxMemory; // remainder op. gets us the right 2 numbers
	}
	
	// displays dump text
	protected void dump(){
		prompt.dumpDisplayText(accumulator, instructionCounter, instructionRegister,
				operationCode, operand);
		memoryTableDisplay();
	}
	
	// didn't move to prompts because I wasn't quite sure how best to do so
	protected void memoryTableDisplay(){
		int row, col;
		
		// row of display numbers (top of table)
		System.out.printf("%3s", ""); // extra 3 initial spaces for alignment
		for(col = 0; col < 10; col++)
			System.out.printf("%6s%d", "", col);
		System.out.println();
		
		// uses maximum memory for rows for easier expansion
		for(row = 0; row < maxMemory; row += 10){
			// display row
			System.out.printf("%03d%2s", row, "");
			for(col = 0; col < 10; col++){
				System.out.printf("%05d%2s", memory[row + col], "");
			}
			System.out.println();
		}
	}
}
