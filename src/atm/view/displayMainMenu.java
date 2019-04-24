/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.controller.MainController;
import atmmvc.Keypad;

/**
 *
 * @author Gita
 */
public class displayMainMenu implements View{
    Keypad keypad;
    MainController controller;
    int menu;
    
    public displayMainMenu(Keypad keypad, MainController controller){
        this.keypad = keypad;
        this.controller = controller;
    }
    
    @Override
    public void show() {
      System.out.println("\nMain menu:");
      System.out.println("1 - View my balance");
      System.out.println("2 - Withdraw cash");
      System.out.println("3 - Deposit funds");
      System.out.println("4 - Exit\n");
      System.out.println("Enter a choice: ");
      menu = keypad.getInput();
      
      askCommand();
    }

    @Override
    public void askCommand() {
        controller.chooseMenu(menu);
    }
    
}
