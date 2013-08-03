package edu.odu.cs.cs333.animations;


import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;


public class TreeTraversals extends LocalJavaAnimation {

	public TreeTraversals() {
		super("Tree Traversals");
	}

	@Override
	public String about() {
		return "Demonstration of tree traversals,\n" +
				"prepared for CS 333, Programming and Problem\n" +
				"Solving in C++, Old Dominion University\n" +
				"Fall 2010";
	}


	BinaryTrees bt = new BinaryTrees();
	BinaryTrees.BinaryTreeNode root = null;
	
	@Override
	public void buildMenu() {
		
		registerStartingAction(new MenuFunction() {

			@Override
			public void selected() {
				root = bt.createSampleTree1();
				globalRefVar("root", root);
			}
			
		});
		
		
		register("pre-order traversal", new MenuFunction() {

			@Override
			public void selected() {
				bt.preOrder(root);
				out.println("");
			}
			
		});
		
		register("post-order traversal", 
		  new MenuFunction() {

			@Override
			public void selected() {
				bt.postOrder(root);
				out.println("");
			}
			
		});
		
		register("in-order traversal", new MenuFunction() {

			@Override
			public void selected() {
				bt.inOrder(root);
				out.println("");
			}
			
		});

	}
	

	
	
	
	public static void main (String[] args) {
		TreeTraversals demo = new TreeTraversals();
		demo.runAsMain();
	}

}
