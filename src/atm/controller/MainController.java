/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.controller;

import atm.model.Account;
import atm.model.BankDatabase;

/**
 *
 * @author Gita
 */
public class MainController {
    private BankDatabase bankdatabase;
    private boolean userAuthenticated; // whether user is authenticated
//    private int currentAccountNumber;
    private Account currentAccount;
    private int menu;
   
    public MainController(BankDatabase bankdatabase){
        this.bankdatabase = bankdatabase;
        userAuthenticated = false;
        currentAccount = null;
        menu = 0;
    }
    
    //autentikasi user
    public void authenticate(int accountNumber, int pin){
        userAuthenticated = bankdatabase.authenticateUser(accountNumber, pin);
        if(userAuthenticated){
            currentAccount = bankdatabase.getAccount(accountNumber);
        }
    }
    //menu
    public void chooseMenu(int menu){
        this.menu = menu;
    }
    
    public void debit(int userAccountNumber, double amount) {
      currentAccount.debit(amount);
    } 
    
    public void credit(int userAccountNumber, double amount) {
      currentAccount.credit(amount);
    } 
    
    //getter
    public boolean getUserAuthenticated(){
        return userAuthenticated;
    }
    
    public Account getAccount(){
        return currentAccount;
    }
    
    public int getMenu(){
        return menu;
    }
}
