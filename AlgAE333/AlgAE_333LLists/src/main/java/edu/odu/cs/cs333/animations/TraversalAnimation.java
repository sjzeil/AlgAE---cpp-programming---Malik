package edu.odu.cs.cs333.animations;


import edu.odu.cs.zeil.AlgAE.ActivationRecord;
import edu.odu.cs.zeil.AlgAE.Animation;
import edu.odu.cs.zeil.AlgAE.Server.MenuFunction;

public class TraversalAnimation extends Animation {

	public TraversalAnimation() {
		super("Linked List Traversal", true);
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
		
		
		
		registerStartingAction(new MenuFunction() {

			@Override
			public void selected() {
				getAnimator().setSpeed(30);
				generateLL();
				for (int k = 0; k < 1000; ++k) {
					sll.traverse();
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
			
		});
		
		
		register ("Set up a list", new MenuFunction() {
			@Override
			public void selected() {
				generateLL();
			}
		});

		register ("traverse a linked list", new MenuFunction() {
			@Override
			public void selected() {
				sll.traverse();
			}
		});
		
	}
	
	public void generateLL()
	{
		sll.setUp();
		ActivationRecord arec = Animation.activate(getClass());//!
		arec.refVar("head", sll.head).breakHere("generated");//!
	}


	
	
	
	public static void main (String[] args) {
		TraversalAnimation demo = new TraversalAnimation();
		demo.runAsMain();
	}

}
