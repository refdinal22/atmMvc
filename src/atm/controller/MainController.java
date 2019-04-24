/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.controller;

import atm.model.BankDatabase;

/**
 *
 * @author Gita
 */
public class MainController {
    BankDatabase bankdatabase;
    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber;
    private int menu;
   
    public MainController(BankDatabase bankdatabase){
        this.bankdatabase = bankdatabase;
        userAuthenticated = false;
        currentAccountNumber = 0;
        menu = 0;
    }
    
    //autentikasi user
    public void authenticate(int accountNumber, int pin){
        userAuthenticated = bankdatabase.authenticateUser(accountNumber, pin);
        if(userAuthenticated){
            currentAccountNumber = accountNumber;
        }
    }
    //menu
    public void chooseMenu(int menu){
        this.menu = menu;
    }
    
    public void debit(int userAccountNumber, double amount) {
      bankdatabase.debit(userAccountNumber, amount);
    } 
    
    public void credit(int userAccountNumber, double amount) {
      bankdatabase.credit(userAccountNumber, amount);
    } 
    
    //getter
    public boolean getUserAuthenticated(){
        return userAuthenticated;
    }
    
    public int getAccountNumber(){
        return currentAccountNumber;
    }
    
    public int getMenu(){
        return menu;
    }
}
