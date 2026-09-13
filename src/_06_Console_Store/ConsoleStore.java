package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _02_Generics_Store.Cart;
import _02_Generics_Store.Cereal;
import _02_Generics_Store.Food;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */
	

    public static void main(String[] args) {
    	ArrayList<Food> foodCart = new ArrayList<>();
    	Scanner scan = new Scanner(System.in);
    	int money = 100;
    	
    	
    	System.out.println("Welcome to the online shop?");
    	System.out.println("You can view cart, add an item, remove an item, or check out");
    	String input = scan.nextLine();
    	input = input.equals("view cart") ? foodCart.toString() : (input.equals("add item") ? "redirecting to market" : null) : input.equals("remove item") ? ;
    	System.out.println("Current items in market: Candy 2$, Cereal 8$, Clothing 15$, Toys 10$");

    }


}
