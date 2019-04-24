/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.controller.MainController;
import atm.model.BankDatabase;
import atmmvc.Keypad;

/**
 *
 * @author Gita
 */
public class BalanceInquiry implements View{
    BankDatabase database;
    Keypad keypad;
    MainController controller; 
    int accountNumber;
    
    public BalanceInquiry(BankDatabase database, Keypad keypad, int accountNumber){
        
        this.database = database;
        this.keypad = keypad;
        this.accountNumber = accountNumber;
    }
    
    @Override
    public void show() {
        
    double availableBalance = 
         database.getAvailableBalance(accountNumber);

    double totalBalance = 
         database.getTotalBalance(accountNumber);
    
      System.out.println("\nBalance Information:");
      System.out.println(" - Available balance: "); 
      System.out.println(availableBalance);
      System.out.println("\n - Total balance:     ");
      System.out.println(totalBalance);
//      screen.displayMessageLine("");
    }

    @Override
    public void askCommand() {
        
    }
    
}
