package edu.odu.cs.cs333.animations;


import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;
//!
//!
//!
//!
//!
//!

public class RecursiveCalculator extends LocalJavaAnimation {

	public RecursiveCalculator() {
		super("Recursive Calculator");
	}

	@Override
	public String about() {
		return "Demonstration of Recursion,\n" +
				"prepared for CS 333, Programming and Problem\n" +
				"Solving in C++, Old Dominion University\n" +
				"Fall 2010";
	}


	
	
	@Override
	public void buildMenu() {
		
		
		
		register("calculator", 
				new MenuFunction() {

			@Override
			public void selected() {
				Calculator calculator = new Calculator();
				String line = promptForInput("Enter an expression to evaluate:");
				calculator.calculator(line);
			}
			
		});
		
		
	}
	

	
	
	
	public static void main (String[] args) {
		RecursiveCalculator demo = new RecursiveCalculator();
		demo.runAsMain();
	}

}
