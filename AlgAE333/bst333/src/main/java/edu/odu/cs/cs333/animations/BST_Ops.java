package edu.odu.cs.cs333.animations;


import java.util.Random;

import edu.odu.cs.zeil.AlgAE.Animation;
import edu.odu.cs.zeil.AlgAE.Server.MenuFunction;

public class BST_Ops extends Animation {

	public BST_Ops() {
		super("Binary Search Trees", true);
	}

	@Override
	public String about() {
		return "Demonstration of binary search trees,\n" +
				"prepared for CS 333, Programming and Problem\n" +
				"Solving in C++, Old Dominion University\n" +
				"Fall 2010";
	}


	
	BinarySearchTree bst = new BinarySearchTree();
	Random rand = new Random();
	
	@Override
	public void buildMenu() {
		
		
		register("create a random tree", new MenuFunction() {

			@Override
			public void selected() {
				bst.clear();
				String nNodesS = promptForInput("How many nodes?", "[0-9]+");
				int nNodes = Integer.parseInt(nNodesS);
				int[] v = new int[nNodes];
				int k = 0;
				for (int i = 0; i < nNodes; ++i) {
					k += 1 + rand.nextInt(3);
					v[i] = k;
				}
				for (int i = 1; i < nNodes; ++i) {
					int j = rand.nextInt(i+1);
					int temp = v[i];
					v[i] = v[j];
					v[j] = temp;
				}
				for (int i = 0; i < nNodes; ++i) {
					bst.quickInsert (v[i]);
				}
			}
		});
		
		
		register("insert a value", new MenuFunction() {

			@Override
			public void selected() {
				String xs = promptForInput("Integer value to insert?", "[0-9]+");
				int x = Integer.parseInt(xs);
				bst.insert(x);
			}
			
		});
		
		register("search", new MenuFunction() {

			@Override
			public void selected() {
				String xs = promptForInput("Integer value to search for?", "[0-9]+");
				int x = Integer.parseInt(xs);
				bst.find(x);
			}
			
		});
		

	}
	

	
	
	
	public static void main (String[] args) {
		BST_Ops demo = new BST_Ops();
		demo.globalVar("bst", demo.bst);
		demo.runAsMain();
	}

}
