/* .........................................................................
..............................................................................

OASIS INFOBYTE  
JAVA DEVELOPEMENT INTERNSHIP
FAIYAZ KHAN
TASK #3

...............................................................................
............................................................................... */

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//.................................................................................
 class ATMmachine {
    private double balance;
    private double deposit_Amount;
    private double withdraw_Amount;

    //...........................................................................
    public ATMmachine(){

    }

    //...........................................................................
    public double getBalance() {
        return balance;
    }
    //...........................................................................
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //...........................................................................
    public double getDepositAmount() {
        return deposit_Amount;
    }
    //...........................................................................
    public void setDepositAmount(double deposit_Amount) {
        this.deposit_Amount = deposit_Amount;
    }
    //...........................................................................
    public double getWithdrawAmount() {
        return withdraw_Amount;
    }
    //...........................................................................
    public void setWithdrawAmount(double withdraw_Amount) {
        this.withdraw_Amount = withdraw_Amount;
    }
}
//.................................................................................
 interface AtmOperationInterf {
    public void viewBalance();
    public void withdraw_Amount(double withdraw_Amount);
    public void deposit_Amount(double deposit_Amount );
    public  void viewMiniStatement();
}
//..................................................................................

 class AtmOperationImpl implements AtmOperationInterf{
    ATMmachine atm=new ATMmachine();
    Map<Double,String> ministmt=new HashMap<>();
    //..............................................................................
    @Override
    public void viewBalance() {
        System.out.println("\t\t\t\t _____________________________________");
        System.out.println("\t\t\t\t| Current Balance : "+atm.getBalance()+"|");
        System.out.println("\t\t\t\t ---------------------------------------");

    }

    //...........................................................................
    @Override
    public void withdraw_Amount(double withdraw_Amount) {
        if(withdraw_Amount%500==0) {
            if (withdraw_Amount <= atm.getBalance()) {
                ministmt.put(withdraw_Amount, "\t\t\t\t Amount Withdrawn");
                System.out.println("\t\t\t\t Collect the Cash " + withdraw_Amount);
                System.out.println("\t\t\t\t|===================================|");
                System.out.println("\t\t\t\t|===================================|");
                atm.setBalance(atm.getBalance() - withdraw_Amount);
                viewBalance();
            } else {
                System.out.println("\t\t\t\t Insufficient Balance !!");
            }
        }
        else {
            System.out.println("\t\t\t\t Please enter the amount in multipal of 500 !!");
        }

    }

    //...........................................................................
    @Override
    public void deposit_Amount(double deposit_Amount) {
        ministmt.put(deposit_Amount,"\t\t\t\t Amount Deposited !!");
        System.out.println("\t\t\t\t"+deposit_Amount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+deposit_Amount);
        viewBalance();

    }

    //...........................................................................
    @Override
    public void viewMiniStatement() {
        System.out.println("\t\t\t\t MINI STATEMENT ");
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println("\t\t\t\t "+m.getKey()+""+m.getValue());
        }

    }
}
//................................................................................
public class ATM_Interface {
    public static void main(String[] args) {
        AtmOperationInterf op=new AtmOperationImpl();
        int atmnumber=3698;
        int atmpin=2301;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\n\n\t\t\t\tWelcome to ATM Machine Of Branch Oasis Infobyte!!!");
            System.out.print("\t\t\t\tEnter Last Four Digits Of The ATM Card : ");
            int atmNumber=in.nextInt();
            System.out.print("\t\t\t\tEnter Your Pin: ");
            int pin=in.nextInt();
            //...........................................................................
            if((atmnumber==atmNumber)&&(atmpin==pin)){
                while(true){
                    System.out.println("\n\t\t\t\t ________________________________________________");
                    System.out.println("\t\t\t\t| 1.Current Balance\t\t2.Withdraw       |\n\t\t\t\t| 3.Deposit \t\t\t4.Ministatement  |\n\t\t\t\t| 5.Exit\t\t\t                 |");
                    System.out.println("\t\t\t\t|________________________________________________|");
                    System.out.print("\t\t\t\tEnter Choice : ");
                    int ch=in.nextInt();
                    if(ch==1){
                        op.viewBalance();

                    }
                    else if(ch==2){
                        System.out.print("\t\t\t\t Enter amount to withdraw :");
                        double withdrawAmount=in.nextDouble();
                        op.withdraw_Amount(withdrawAmount);

                    }
                    else if(ch==3){
                        System.out.print("\t\t\t\t Enter Amount to Deposit :");
                        double depositAmount=in.nextDouble();
                        op.deposit_Amount(depositAmount);


                    }
                    else if(ch==4){
                        op.viewMiniStatement();

                    }
                    else if(ch==5){
                        System.out.println("\t\t\t\t Collect your ATM Card\n \t\t\t\t Thank you for using ATM Machine!!");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.print("\t\t\t\t Please enter correct choice!!");
                    }
                }
            }
            else{
                System.out.println("\t\t\t\t Incorrect Atm Number or pin!!");
                System.exit(0);
            }
        }


    }
}
//......................................................................................