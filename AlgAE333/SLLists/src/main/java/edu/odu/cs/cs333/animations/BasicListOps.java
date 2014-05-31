package edu.odu.cs.cs333.animations;

import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;



public class BasicListOps extends LocalJavaAnimation {

	public BasicListOps() {
		super("Linked List: Removing Nodes");
	}

	@Override
	public String about() {
		return "Demonstration of Linked Lists Algorithms,\n" +
				"prepared for CS 333, Programming and Problem\n" +
				"Solving in C++, Old Dominion University\n" +
				"Fall 2010";
	}

	SinglyLinkedLists sll = new SinglyLinkedLists();


	
	
	@Override
	public void buildMenu() {
		
		
		register("Insert", new MenuFunction() {

			@Override
			public void selected() {
				generateLL();					
				sll.insert(sll.head.link, 50);

			}

		});

		register("Delete", new MenuFunction() {

			@Override
			public void selected() {
				generateLL();					
				sll.remove(sll.head.link);
			}
			
		});
		
		register ("Traverse", new MenuFunction() {

			@Override
			public void selected() {
				generateLL();
				sll.traverse();
			}
			
		});

		
		
	}
	
	public void generateLL()
	{
		sll.head = null;
		sll.addToFront(76);
		sll.addToFront(34);
		sll.addToFront(65);
		sll.addToFront(45);
	}


	
	
	
	public static void main (String[] args) {
		BasicListOps demo = new BasicListOps();
		demo.runAsMain();
	}

}
