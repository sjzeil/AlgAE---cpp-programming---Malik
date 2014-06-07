package edu.odu.cs.cs333.animations;

import edu.odu.cs.AlgAE.Client.Client;
import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;



public class SLLAddDemo extends LocalJavaAnimation {

	public SLLAddDemo() {
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
		
		registerStartingAction( new MenuFunction() {

			@Override
			public void selected() {
				Client client = (Client)getClient();
				client.getAnimator().setSpeed(25);
				for (int i = 0; i < 100; ++i) {
					generateLL();					
					sll.insert(sll.head.link, 50);
				}
			}

		});
		
		register("Restart", new MenuFunction() {

			@Override
			public void selected() {
				Client client = (Client)getClient();
				client.getAnimator().setSpeed(25);
				for (int i = 0; i < 100; ++i) {
					generateLL();					
					sll.insert(sll.head.link, 50);
				}
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
		SLLAddDemo demo = new SLLAddDemo();
		demo.runAsMain();
	}

}
