/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm.view;

import atm.controller.MainController;
import atmmvc.AtmMvc;
import atmmvc.Keypad;

/**
 *
 * @author Gita
 */
public class AuthenticateUserView implements View{
       
       Keypad keypad;
       MainController controller;
       
       public AuthenticateUserView(){
          
       }
       public AuthenticateUserView(Keypad keypad, MainController controller){
          this.keypad = keypad;
          this.controller = controller;
       }
       
       public void askCommand(){
           
       }

    @Override
    public void show() {
        System.out.println("\nWelcome!");
        System.out.println("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput(); // input account number
        System.out.println("\nEnter your PIN: "); // prompt for PIN
        int pin = keypad.getInput(); // input PIN
        controller.authenticate(accountNumber, pin);     
    }
    
}
