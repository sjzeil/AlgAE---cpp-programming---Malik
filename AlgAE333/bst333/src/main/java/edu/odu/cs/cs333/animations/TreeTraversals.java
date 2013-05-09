package edu.odu.cs.cs333.animations;


import edu.odu.cs.zeil.AlgAE.Animation;
import edu.odu.cs.zeil.AlgAE.Server.MenuFunction;

public class TreeTraversals extends Animation {

	public TreeTraversals() {
		super("Tree Traversals", true);
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
		
		register("post-order traversal", new MenuFunction() {

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
