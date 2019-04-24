package atm.view;

import atm.controller.MainController;
import atm.model.Account;
import atm.model.BankDatabase;
import atmmvc.CashDispenser;
import atmmvc.Keypad;
import atmmvc.Screen;


public class Withdrawal implements View{  
   private int amount;   // amount to withdraw  
   private Keypad keypad; // references to keypad  
   private CashDispenser cashDispenser;  // references to cash dispenser  
   private Screen screen;
   private BankDatabase bankDatabase;   
   private MainController controller; 
   private int accountNumber;
   private Account account;
   
   private final static int CANCELED = 6;  

    public Withdrawal(Keypad keypad, CashDispenser cashDispenser, Screen screen, BankDatabase bankDatabase, MainController controller, Account account) {
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
        this.controller = controller;
        this.account = account;
    }
        
      
   public void show(){  
     boolean cashDispensed = false;
     double availableBalance;          
       amount = displayMenuOfAmounts();                
       if(amount != CANCELED){  
         availableBalance = account.getAvailableBalance();
         if(amount <= availableBalance){  
           if(cashDispenser.isSufficientCashAvailable(amount)){  
             askCommand();
             screen.displayMessageLine("\nYour cash has been dispensed. Please take your cash now.");  
           }
           else{               
             screen.displayMessageLine("\nInsufficient cash available in the ATM.");  
             screen.displayMessageLine("\nPlease choose a smaller amount.");  
           }
         }
         else{  
           screen.displayMessageLine("\nInsufficient funds in your account.");  
           screen.displayMessageLine("\nPlease choose a smaller amount.");  
         }
       }
       else{  
         screen.displayMessageLine("\nCancelling transactions...");           
       }     
   }
   
   private int displayMenuOfAmounts(){  
     int userChoice = 0;     
     int[] amounts = {0, 20, 40, 60, 100, 200};       
     while(userChoice == 0){         
       screen.displayMessageLine("\nWithdrawal Menu : ");  
       screen.displayMessageLine("1 - $20");  
       screen.displayMessageLine("2 - $40");  
       screen.displayMessageLine("3 - $60");  
       screen.displayMessageLine("4 - $100");  
       screen.displayMessageLine("5 - $200");  
       screen.displayMessageLine("6 - Cancel Transaction");  
       screen.displayMessage("\nChoose a withdrawal amount : ");  
       int input = keypad.getInput();
       switch(input){  
         case 1 :  
         case 2 :  
         case 3 :  
         case 4 :  
         case 5 :  
           userChoice = amounts[input];
           break;  
         case CANCELED :             
           userChoice = CANCELED;
           break;  
         default :             
           screen.displayMessageLine("\nInvalid selection.");  
           screen.displayMessageLine("Try again.");  
       }
     }
     return userChoice;
   }

    @Override
    public void askCommand() {
        controller.debit(accountNumber, amount);
    }
   }