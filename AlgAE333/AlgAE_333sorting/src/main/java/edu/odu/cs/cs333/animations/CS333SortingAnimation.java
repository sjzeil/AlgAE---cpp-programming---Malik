package edu.odu.cs.cs333.animations;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;
import edu.odu.cs.AlgAE.Server.MemoryModel.Component;
import edu.odu.cs.AlgAE.Server.MemoryModel.Connection;
import edu.odu.cs.AlgAE.Server.Rendering.CanBeRendered;
import edu.odu.cs.AlgAE.Server.Rendering.Renderer;


public class CS333SortingAnimation extends LocalJavaAnimation {

	public CS333SortingAnimation() {
		super("Sorting Algorithms");
	}

	@Override
	public String about() {
		return "Demonstration of Sorting Algorithms,\n" +
				"prepared for CS 361, Advanced Data Strcutures\n" +
				"and Algorithms, Old Dominion University\n" +
				"Summer 2011";
	}

	
	private int[] array = new int[0];
	
	private class ArrayContainer implements CanBeRendered<ArrayContainer>, Renderer<ArrayContainer> {

		@Override
		public Renderer<ArrayContainer> getRenderer() {
			return this;
		}

		@Override
		public Color getColor(ArrayContainer obj) {
			return Color.white;
		}

		@Override
		public List<Component> getComponents(ArrayContainer obj) {
			ArrayList<Component> c = new ArrayList<Component>();
			c.add (new Component(array));
			return c;
		}

		@Override
		public List<Connection> getConnections(ArrayContainer obj) {
			return new ArrayList<Connection>();
		}

		@Override
		public int getMaxComponentsPerRow(ArrayContainer obj) {
			return 1;
		}

		@Override
		public String getValue(ArrayContainer obj) {
			return "";
		}
		
	}


	
	
	@Override
	public void buildMenu() {
		
		
		registerStartingAction(new MenuFunction() {
			
			@Override
			public void selected() {
				generateRandomArray(8);
				globalVar("list", new ArrayContainer());
			}
		});
		
		register ("Generate a random array", new MenuFunction() {
			@Override
			public void selected() {
				randomArrayGenerated();
			}
		});

		register ("Generate an ordered array", new MenuFunction() {
			@Override
			public void selected() {
				orderedArrayGenerated();
			}
		});

		register ("Generate a reversed array", new MenuFunction() {
			@Override
			public void selected() {
				reverseArrayGenerated();
			}
		});
		
		register ("Bubble Sort", new MenuFunction() {
			@Override
			public void selected() {
				Sorting.bubbleSort (array, array.length);
			}
		});

		register ("Selection Sort", new MenuFunction() {
			@Override
			public void selected() {
				Sorting.selectionSort (array, array.length);
			}
		});

		register ("Insertion Sort", new MenuFunction() {
			@Override
			public void selected() {
				Sorting.insertionSort (array, array.length);
			}
		});
		
		register ("Binary Search", new MenuFunction() {
			@Override
			public void selected() {
				String value = promptForInput("Value to search for?", "\\d+");
				int v = Integer.parseInt(value);
				int pos = Sorting.binarySearch (array, array.length, v);
			}
		});

	}
	
	public void randomArrayGenerated()
	{
		String value = promptForInput("How many elements?", "\\d+");
		int n = Integer.parseInt(value);
		generateRandomArray(n);
	}

	public void generateRandomArray(int n)
	{
		if (n != array.length) {
			array = new int[n];
		}
		for (int i = 0; i < n; ++i) {
			array[i] = (int)((double)(2*n) * Math.random());
		}
		
	}

	
	public void reverseArrayGenerated()
	{
		String value = promptForInput("How many elements?", "\\d+");
		int n = Integer.parseInt(value);
		generateReverseArray(n);
	}

	public void generateReverseArray(int n)
	{
		if (n != array.length) {
			array = new int[n];
		}
		array[n-1] = (int)(3.0 * Math.random());  
		for (int i = n-2; i >= 0; --i) {
			array[i] = array[i+1] + (int)(3.0 * Math.random());
		}
		
	}

	public void orderedArrayGenerated()
	{
		String value = promptForInput("How many elements?", "\\d+");
		int n = Integer.parseInt(value);
		generateOrderedArray(n);
	}

	public void generateOrderedArray(int n)
	{
		if (n != array.length) {
			array = new int[n];
		}
		array[0] = (int)(3.0 * Math.random());  
		for (int i = 1; i < n; ++i) {
			array[i] = array[i-1] + (int)(5.0 * Math.random());
		}
		
	}
	
	
	
	public static void main (String[] args) {
		CS333SortingAnimation demo = new CS333SortingAnimation();
		demo.runAsMain();
	}

}
