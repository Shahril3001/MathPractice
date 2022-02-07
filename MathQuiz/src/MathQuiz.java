import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import java.lang.reflect.Array;

//Declare Player Array 
class Player  
{  
    public int playerNo;  
    public String playerName;  
    public String practiceType; 
    public String practiceLevel;
    public int playerScore;
    public Array myAnswer;
    Player(int playerNo, String playerName, String practiceType, String practiceLevel, int playerScore, Array myAnswer)  
    {  
        this.playerNo = playerNo;  
        this.playerName = playerName;
        this.practiceType = practiceType; 
        this.practiceLevel = practiceLevel; 
        this.playerScore = playerScore; 
        this.myAnswer = myAnswer; 
    }  
}  

//Declare myAnswer 
class myAnswer  
{  
    public int answerNo;  
    public int questionNo;  
    public String questionDesc; 
    public String correctAns;
    public String playerAns;
    myAnswer(int answerNo, int questionNo, String questionDesc, String correctAns, String playerAns)  
    {  
        this.answerNo = answerNo;  
        this.questionNo = questionNo;
        this.questionDesc = questionDesc;
        this.correctAns = correctAns;
        this.playerAns = playerAns;
    }  
}



public class MathQuiz {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//Declare Menu 
		String menuLevel = "mainmenu";
		
		String userOption = "";
		boolean stop = false;
		
		int practiceRound = 1, playerRightAns = 0, playerWrongAns = 0;
		
		Player[] arr; 
		arr = new Player[5];  
		
		while(stop==false) {
			switch(menuLevel){
			
			case "mainmenu":
				//Math Practice system menu ---------------------------------------------------
				System.out.println("Welcome to Math Practice.");
				System.out.println("1. Addition");
				System.out.println("2. Subtraction");
				System.out.println("3. Multiplication");
				System.out.println("4. Division");
				System.out.println("5. Exit");
				System.out.println("Type option number:-");
				
				userOption = keyboard.nextLine();
				//Select the Math Practice
				try {
					byte option = Byte.parseByte(userOption);
					if(option == 1){
						menuLevel = "addition";
					} else if(option == 2){
						menuLevel = "subtraction";
					}
					else if(option == 3){
						menuLevel = "multiplication";
					}
					else if(option == 4){
						menuLevel = "division";
					}
					else if(option == 5){
						menuLevel = "exit";
					}else {
						System.out.println("\n-----------------------------------");
						System.out.println("Invalid Number");
						System.out.println("Only choose given number");
						pressEnterKeyToContinue();
					}
					
				} catch(Exception e){
					System.out.println("\n-----------------------------------");
					System.out.println("Invalid input");
					System.out.println("Only input number");
					pressEnterKeyToContinue();
				}
				break;
			//Math Practice system menu ---------------------------------------------------
			
			
			//Addition Menu ---------------------------------------------------
			case "addition":
			System.out.println("\n");
			System.out.println("Addition Practice Level");
			System.out.println("1. Level 1");
			System.out.println("2. Level 2");
			System.out.println("3. Previous");
			System.out.println("Type option number:-");
			
			userOption = keyboard.nextLine();
			//Select the Addition Practice Level
			try {
				byte option = Byte.parseByte(userOption);
				if(option == 1){
					menuLevel = "addlevel1";
				} else if(option == 2) {
					menuLevel = "addlevel2";
				} else if(option == 3) {
					menuLevel = "mainmenu";
				} else {
					System.out.println("Invalid Number");
					System.out.println("Only choose given number");
					System.out.println("\n");
				}
			} catch(Exception e){
				System.out.println("Invalid input");
				System.out.println("Only input number");
				System.out.println("\n");
			}
			break;
			//Addition Menu ---------------------------------------------------
			
			
			
			//Addition Level 1 ------------------------------------------------	
			case "addlevel1":
				while(true) {
					if(practiceRound == 11) continue;{
					// Generate Random Number For Addition Practice Level 1
					int maxNum = 9;
					int minNum = 0;
					int diff = maxNum - minNum;
					
					// Random 1st Number
					Random randomNum1 = new Random();
					int qusAddInt1 = randomNum1.nextInt(diff + 1);
					qusAddInt1 += minNum;
					
					// Random 2nd Number
					Random randomNum2 = new Random();
					int qusAddInt2 = randomNum2.nextInt(diff + 1);
					qusAddInt2 += minNum;
					
					int realAns = qusAddInt1 + qusAddInt2;
					System.out.println("\n");
					System.out.println("Addition Practice Level 1");
					System.out.println("Round: " + practiceRound + "          "
							+ "Score: " + playerRightAns + " points"
							+ "          "
							+ "Correct Answer: "+playerRightAns
							+ "   Wrong Aswer: "+ playerWrongAns);
					System.out.print("Question: "+qusAddInt1 +" + "+ qusAddInt2 +" = ??? \n");
					
					
					try {
						double playerAns = keyboard.nextDouble();
						if(playerAns == realAns){
							System.out.println("Your answer is correct.");
							playerRightAns = playerRightAns + 1;
							pressEnterKeyToContinue();
						} else {
							System.out.println("Your answer is wrong. \n"
										+ "The right answer is " + realAns+".");
							playerWrongAns = playerWrongAns + 1;
							pressEnterKeyToContinue();
						}
					} catch(Exception e){
						System.out.println("Invalid input");
						System.out.println("Only input number");
						pressEnterKeyToContinue();
					}
					++practiceRound;
					}
				}
			//Addition Level 1 ------------------------------------------------
			
			
				
			//Terminate application -------------------------------------------
			case "exit":
			System.out.println("Program is terminate.");
			stop = true;
			break;
			default:
			break;
			//Terminate application -------------------------------------------
			}	
		}
	}
	
	
	// Press enter to continue
	public static void pressEnterKeyToContinue()
	{ 
	        System.out.println("Press enter to continue...");
	        Scanner s = new Scanner(System.in);
	        s.nextLine();
	}
	
	
	// Clear console
	public final static void clearConsole()
	{
		try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else {
	            System.out.print("\033\143");
	        }
	    } catch (IOException | InterruptedException ex) {}
	}
}
