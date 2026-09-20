package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _02_Generics_Store.Candy;
import _02_Generics_Store.Cart;
import _02_Generics_Store.Cereal;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Food;
import _02_Generics_Store.NonFood;
import _02_Generics_Store.Toy;

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
	Scanner scan = new Scanner(System.in);
   	ArrayList<Food> foodCart = new ArrayList<>();
   	ArrayList<NonFood> nonFoodCart = new ArrayList<>();
	int money = 100;
	String remove;

	ConsoleStore(){
    	
        	System.out.println("Welcome to the online shop?");
        	while(0<1) {
            	System.out.println("You can view cart, add an item, remove an item, or check out");
            	String input = scan.nextLine();
            	if(input.equalsIgnoreCase("View Cart")) {
            		System.out.println("You currently have: " + foodCart.toString() + " " + nonFoodCart.toString() + " in your cart.");
            	}
            	else if(input.equalsIgnoreCase("Add Item")) {
            		addItem();
            	}
            	else if(input.equalsIgnoreCase("Remove Item")) {
            		removeItem();
            	}
        	}

    	}

	
	    public static void main(String[] args) {
	    	new ConsoleStore();
	    	
	    }
    public void addItem() {
    	String choice = "";
    	System.out.println("Current items in market: Candy 2$, Cereal 8$, Clothing 15$, Toys 10$");
    	choice = scan.nextLine();
    	if(choice.equalsIgnoreCase("candy")) {
    		foodCart.add(new Candy());
    		money-=foodCart.get(foodCart.size()-1).price();
    	}
    	else if(choice.equalsIgnoreCase("Cereal")) {
    		foodCart.add(new Cereal());
    		money-=foodCart.get(foodCart.size()-1).price();

    	}
    	else if(choice.equalsIgnoreCase("Clothing")) {
    		nonFoodCart.add(new Clothing());
    		money-=nonFoodCart.get(nonFoodCart.size()-1).price();

    	}
    	else if(choice.equalsIgnoreCase("Toys")) {
    		nonFoodCart.add(new Toy());
    		money-=nonFoodCart.get(nonFoodCart.size()-1).price();

    	}
    	
    	
    	
    }
    public void removeItem() {
    	remove = "";
		System.out.println("You currently have: " + foodCart.toString() + " " + nonFoodCart.toString() + " in your cart.");
		remove= scan.nextLine();
		for(int i = 0; i<foodCart.size(); i++) {
			if(foodCart.get(i).toString().equalsIgnoreCase(remove)) {
				foodCart.remove(i);
			}
		}
		for(int i = 0; i<nonFoodCart.size(); i++) {
			if(nonFoodCart.get(i).toString().equalsIgnoreCase(remove)) {
				nonFoodCart.remove(i);
			}
		}
    	
    }


}
