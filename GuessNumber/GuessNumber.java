//======================================================================================================================================================

/*
..............................................................................

OASIS INFOBYTE  
JAVA DEVELOPEMENT INTERNSHIP
FAIYAZ KHAN 
TASK #1

................................................................................      
 */
//======================================================================================================================================================
import java.util.Random;
import java.util.Scanner;
//======================================================================================================================================================

class game {
    int flag=0;
    Random rand = new Random();
    private int compno, inp;
    private int noOf = 10;
    //------------------------------------------------------------------------------------------------------------------------------------------
    public game() {
        compno = rand.nextInt(100);
        //compno = 22; //for testing purpose only
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void takeUserInput(int inpu) {
        this.inp = inpu;
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public String iscorrectnumber() {
        flag = 1;
        return "\t\t\t\t**Congratulations!!**  You Guess Right Number !!";
        
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void noOfguesses() {

        if (inp == compno) {
            System.out.println(iscorrectnumber());
            System.out.printf("\t\t\t\tYour Score is:%d", noOf);
            
        } else if (inp > compno) {
            System.out.println("\t\t\t\t**oops Sorry!! Your Guessed Number is Greater than Actual Number");
            
        } else {
            System.out.println("\t\t\t\t**oops Sorry!! Your Guessed Number is Less than Actual Number");
            
        }

    }
    public void summary(int attempt){
        if (flag == 1 ||  attempt == 10){
            System.out.println("\t\t\t\tCongratulations......!! Your were Succeeded ");
            System.out.println("\t\t\t\tWe Wish you will play it again Thank you");
            System.exit(0);


        }
        else if(flag ==0 && attempt == 10){
            System.out.println("\t\t\t\tOOPs......!! Your were Done With 10 Attempts ");
            System.out.println("\t\t\t\tWe Wish you will play it again \n\t\t\t \t \tThank you");
        }
    }

}
//======================================================================================================================================================

public class GuessNumber {
    public static void main(String[] args) {
        System.out.println("\t\t\t\t  ________                            .__                 ________                       \r\n"
				+ "\t\t\t\t /  _____/ __ __   ____   ______ _____|__| ____    ____  /  _____/_____    _____   ____  \r\n"
				+ "\t\t\t\t/   \\  ___|  |  \\_/ __ \\ /  ___//  ___/  |/    \\  / ___\\/   \\  ___\\__  \\  /     \\_/ __ \\ \r\n"
				+ "\t\t\t\t\\    \\_\\  \\  |  /\\  ___/ \\___ \\ \\___ \\|  |   |  \\/ /_/  >    \\_\\  \\/ __ \\|  Y Y  \\  ___/ \r\n"
				+ "\t\t\t\t \\______  /____/  \\___  >____  >____  >__|___|  /\\___  / \\______  (____  /__|_|  /\\___  >\r\n"
				+ "\t\t\t\t        \\/            \\/     \\/     \\/        \\//_____/         \\/     \\/      \\/     \\/ ");

        try (Scanner sc = new Scanner(System.in)) {
            game g = new game();
            
            System.out.println("\n\t\t\t\t\t**********************************************************************");
            
            System.out.println("\t\t\t\t\t\tNote:   > You will get 10 chances to guess the number ");
            System.out.println("\t\t\t\t\t\t> You will get 10 chances to guess the number ");
            System.out.printf("\t\t\t\t\t\t> Guess Number in between 1-100 ");
            for (int i = 0; i < 10; i++) {
                System.out.print("\n\t\t\t\tEnter Your Guess: ");
                
                int choice = sc.nextInt();
                g.takeUserInput(choice);
                g.noOfguesses();
                System.out.printf("\n\n\t\t\t\t Chances Attempted:%d \n", i+1 );
                g.summary(i+1);

            }
        }
    }

}
//======================================================================================================================================================
