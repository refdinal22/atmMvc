/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.controller.MainController;
import atm.model.Account;
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
    Account account;
    
    public BalanceInquiry(BankDatabase database, Keypad keypad, Account account){
        
        this.database = database;
        this.keypad = keypad;
        this.account = account;
    }
    
    @Override
    public void show() {
        
    double availableBalance = 
         account.getAvailableBalance();

    double totalBalance = 
         account.getTotalBalance();
    
      System.out.println("\nBalance Information:");
      System.out.println(" - Available balance: "); 
      System.out.println(availableBalance);
      System.out.println("\n - Total balance:     ");
      System.out.println(totalBalance);
    }

    @Override
    public void askCommand() {
        
    }
    
}
