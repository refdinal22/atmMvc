/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmvc;

import atm.controller.MainController;
import atm.model.Account;
import atm.model.BankDatabase;
import atm.view.*;


/**
 *
 * @author Gita
 */
public class ATM {
    private Keypad keypad;
    private BankDatabase bankdatabase;
    private MainController maincontroller;
    private DepositSlot depositslot;
    private Screen screen;
    private CashDispenser cashDispenser;
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Account currentAccount;
    
    //menu
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    
    public ATM(){
        userAuthenticated = false;
        keypad = new Keypad();
        screen = new Screen();
        bankdatabase = new BankDatabase();
        depositslot = new DepositSlot();
        maincontroller = new MainController(bankdatabase);
        cashDispenser = new CashDispenser();
    }
    
    void run(){
        // welcome and authenticate user; perform transactions
      while (true) {
         // loop while user is not yet authenticated
         while (!userAuthenticated) {       
            View userauth = new AuthenticateUserView(keypad, maincontroller); // authenticate user
            userauth.show();
            userAuthenticated = maincontroller.getUserAuthenticated();
            currentAccount = maincontroller.getAccount();
         }
         
         performTransactions(); // user is now authenticated
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session
         System.out.println("\nThank you! Goodbye!");
      }
    }
    
    private void performTransactions() {
      // local variable to store transaction currently being processed
      View currentView = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         View userauth = new displayMainMenu(keypad, maincontroller);
         userauth.show();
         
         int mainMenuSelection = maincontroller.getMenu();
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:         

               // initialize as new object of chosen type
               currentView = new BalanceInquiry(bankdatabase, keypad, currentAccount);                  
               currentView.show(); // execute transaction
               break; 
               
            case WITHDRAWAL:
                currentView = new Withdrawal(keypad, cashDispenser, screen, bankdatabase, maincontroller, currentAccount);
                currentView.show();
                break;
               
            case EXIT: // user chose to terminate session
               userExited = true; // this ATM session should end
               break;
        }
      }
//
//         // decide how to proceed based on user's menu selection
//         switch (mainMenuSelection) {
//            // user chose to perform one of three transaction types
//            case BALANCE_INQUIRY:         
//
//               // initialize as new object of chosen type
//               currentTransaction = 
//                  createTransaction(mainMenuSelection);
//
//               currentTransaction.execute(); // execute transaction
//               break; 
//            case WITHDRAWAL:         
//
//               // initialize as new object of chosen type
//               currentTransaction = 
//                  createTransaction(mainMenuSelection);
//
//               currentTransaction.execute(); // execute transaction
//               break; 
//               
//            case DEPOSIT:         
//
//               // initialize as new object of chosen type
//               currentTransaction = 
//                  createTransaction(mainMenuSelection);
//
//               currentTransaction.execute(); // execute transaction
//               break; 
//               
//            case EXIT: // user chose to terminate session
//               screen.displayMessageLine("\nExiting the system...");
//               userExited = true; // this ATM session should end
//               break;
//            default: // 
//               screen.displayMessageLine(
//                  "\nYou did not enter a valid selection. Try again.");
//               break;
//         }
//      } 
   }
}
