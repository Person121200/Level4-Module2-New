package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
   	ArrayList<String> total = new ArrayList<>();
	int money = 50;
	String remove;
	String name = "";
	boolean checkedOut = false;

	ConsoleStore(){
		
        	System.out.println("Welcome to the online shop!");
        	System.out.println("What is your full name?");
        	name = scan.nextLine();
        	while(checkedOut == false) {
            	System.out.println(name + ", you can view cart, add an item, remove an item, or check out" + " ;your balance is " + money);
            	String input = scan.nextLine();
            	if(input.equalsIgnoreCase("View Cart")) {
            		toName();
            		System.out.println(name + ", you currently have: " + total + " in your cart.");
            		total.clear();
            	}
            	else if(input.equalsIgnoreCase("Add Item")) {
            		addItem();
            	}
            	else if(input.equalsIgnoreCase("Remove Item")) {
            		removeItem();
            	}
            	else if(input.equalsIgnoreCase("Check Out")) {
            		CheckOut();
            	}
        	}

    	}

	
	    public static void main(String[] args) {
	    	new ConsoleStore();
	    	
	    }
	    
	    public void toName() {
	    	for(int i = 0; i<foodCart.size(); i++) {
	    		
	    		total.add(foodCart.get(i).name());
	    	}
	    	for(int i = 0; i<nonFoodCart.size(); i++) {
	    		total.add(nonFoodCart.get(i).name());
	    	}
	    	
	    }
	public void CheckOut() {
		toName();
		String check = "";
		System.out.println("Checking Out...");
		System.out.println("You have a total of " + total.size() + " items in your cart.");
		System.out.println("Current Items In Cart: " + total);
		int temp = 50-money;
		System.out.println("Your balance is: " + money+ "$" + "and you spent " + temp + "$");
		System.out.println("Would you like to check out? (y/n)");
		check = scan.nextLine();
		if(check.equalsIgnoreCase("y")) {
			if(money>=0) {
				checkedOut = true;
				PrintReceipt();
				ShowCart();
			}
			else {
				System.out.println("You have insufficient funds. Please remove some items");
				total.clear();
				removeItem();
			}
		}
		else if(check.equals("n")){
			System.out.println("returning to homescreen");
		}
		
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
    	toName();
    	remove = "";
		System.out.println("You currently have: " + total + " in your cart. What would you like to remove? (type anything to leave)");
		remove= scan.nextLine();
		for(int i = 0; i<total.size(); i++) {
			if(total.get(i).equalsIgnoreCase(remove)) {
				for(int j = 0; j<foodCart.size(); j++) {
					if(foodCart.get(j).name().equalsIgnoreCase(remove)){
						money+=foodCart.get(j).price();
						foodCart.remove(j);
					}
				}
				for(int j = 0; j<nonFoodCart.size(); j++) {
					if(nonFoodCart.get(j).name().equalsIgnoreCase(remove)) {
						money+=nonFoodCart.get(j).price();
						nonFoodCart.remove(j);

					}
				}
			}
		}

		total.clear();
    	
    }
    public void ShowCart() {
    	JFrame frame = new JFrame("Cart");
    	JPanel panel = new JPanel();
    	frame.add(panel);
    	frame.setVisible(true);
    	for(int i = 0; i<foodCart.size(); i++) {
    		panel.add(foodCart.get(i).getFood());
    	}
    	for(int i =0; i<nonFoodCart.size(); i++) {
    		panel.add(nonFoodCart.get(i).getNonFood());
    	}
		frame.pack();

    	
    }
    public void PrintReceipt() {
    	String temp = "";
    	toName();
    	for(int i = 0; i<8; i++) {
    		System.out.println(" ... ");
    	}
    	System.out.println("Receipt for Online Shop");
    	System.out.println("Billed to " + name);
    	for(int i = 0; i<total.size(); i++) {
    		temp += total.get(i);
    	}
    	System.out.println("List of all purchased items: " + temp);
    	System.out.println("");
    	System.out.println("Food Items:");
    	System.out.println(" ");
    	for(int i = 0; i<foodCart.size(); i++) {
    		System.out.println(foodCart.get(i).name() + "          " + foodCart.get(i).price() + " $");
    	}
    	System.out.println(" ");

    	System.out.println("Non Food Items:");
    	System.out.println(" ");

    	for(int i = 0; i<nonFoodCart.size(); i++) {
    		System.out.println(nonFoodCart.get(i).name() + "          " + nonFoodCart.get(i).price() + " $");
    	}
    	
    }


}
