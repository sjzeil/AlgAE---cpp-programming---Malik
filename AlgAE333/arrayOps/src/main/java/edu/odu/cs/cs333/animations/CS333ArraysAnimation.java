package edu.odu.cs.cs333.animations;



import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;
import edu.odu.cs.AlgAE.Server.Utilities.DiscreteInteger;
import edu.odu.cs.AlgAE.Server.Utilities.Index;

public class CS333ArraysAnimation extends LocalJavaAnimation {

	public CS333ArraysAnimation() {
		super("Array Operations");
	}

	@Override
	public String about() {
		return "Demonstration of Array Manipulation Algorithms,\n" +
		"prepared for CS 333, Programming and Problem\n" +
		"Solving in C++, Old Dominion University\n" +
		"Spring 2011";
	}

	private String[] array = new String[8];
	private DiscreteInteger size = new DiscreteInteger(0);

	
	
	@Override
	public void buildMenu() {
		
		registerStartingAction(new MenuFunction() {

			@Override
			public void selected() {
				array[0] = "Adams";
				array[1] = "Baker";
				array[2] = "Clarke";
				for (int i = 3; i < array.length; ++i)
					array[i] = "";
				size.set(3);
				globalVar("array", array);
				globalVar("size", size);
			}
			
		});
		
		
		register ("reset array", new MenuFunction() {
			@Override
			public void selected() {
				array[0] = "Adams";
				array[1] = "Baker";
				array[2] = "Clarke";
				for (int i = 3; i < array.length; ++i)
					array[i] = "";
				size.set(3);
			}
		});

		register ("add to end", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to add:", ".+");
				new ArrayOperations().addToEnd(array, size, value);
			}
		});

		register ("add Element", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to add:", ".+");
				String indexStr = promptForInput("Position in which to add it (0.." + size.get() + "):", "\\d+");
				int indexVal = Integer.parseInt(indexStr);
				Index index = new Index(indexVal, array);
				new ArrayOperations().addElement(array, size, index, value);
			}
		});
		
		register ("add in order (version 1)", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to add:", ".+");
				new ArrayOperations().addInOrder1 (array, size, value);
			}
		});

		register ("add in order (version 2)", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to add:", ".+");
				new ArrayOperations().addInOrder2 (array, size, value);
			}
		});

		register ("sequential search", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to search for:", ".+");
				new ArrayOperations().seqSearch(array, size.get(), value);
			}
		});

		register ("sequential ordered search", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to search for:", ".+");
				new ArrayOperations().seqOrderedSearch(array, size.get(), value);
			}
		});
		
		register ("remove Element", new MenuFunction() {
			@Override
			public void selected() {
				String indexStr = promptForInput("Position from which to remove (0.." + (size.get()-1) + "):", "\\d+");
				int indexVal = Integer.parseInt(indexStr);
				Index index = new Index(indexVal, array);
				new ArrayOperations().removeElement(array, size, index);
			}
		});
	}

	
	
	
	public static void main (String[] args) {
		CS333ArraysAnimation demo = new CS333ArraysAnimation();
		demo.runAsMain();
	}

}
