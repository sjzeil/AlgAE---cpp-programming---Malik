package edu.odu.cs.cs333.animations;//!

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.odu.cs.zeil.AlgAE.ActivationRecord;
import edu.odu.cs.zeil.AlgAE.Animation;
import edu.odu.cs.zeil.AlgAE.Snapshot.Component;
import edu.odu.cs.zeil.AlgAE.Snapshot.Connection;
import edu.odu.cs.zeil.AlgAE.Snapshot.Rendering.CanBeRendered;
import edu.odu.cs.zeil.AlgAE.Snapshot.Rendering.Renderer;
import edu.odu.cs.zeil.AlgAE.Utilities.DiscreteInteger;
import edu.odu.cs.zeil.AlgAE.Utilities.SimpleReference;

public class SinglyLinkedLists {//!


//
//  Based on Malik, "C++ Programming"
//      Chapter 18
//
class nodeType implements CanBeRendered<nodeType>, Renderer<nodeType> //!	struct nodeType
{
    DiscreteInteger info;//!    int info;
    nodeType link;//!    nodeType *link;
    SimpleReference vislink;//!
    public nodeType()//!
    {//!
    	info = new DiscreteInteger(-999);//!
    	link = null;//!
    	vislink = new SimpleReference(null, 90.0, 90.0);
    }//!
//!
	public Renderer<nodeType> getRenderer() {//!
		return this;//!
	}//!
	public Color getColor(nodeType obj) {//!
		return Color.green.darker();//!
	}//!
	public List<Component> getComponents(nodeType obj) {
		LinkedList<Component> data = new LinkedList<Component>();//!
		data.add (new Component(info, "info"));//!
		vislink.set(link);//!
		data.add (new Component(vislink, "link"));
		return data;//!
	}//!
	public List<Connection> getConnections(nodeType obj) {//!
		LinkedList<Connection> links = new LinkedList<Connection>();//!
		return links;//!
	}//!
	public int getMaxComponentsPerRow(nodeType obj) {//!
		return 100;//!
	}//!
	public String getValue(nodeType obj) {//!
		return "";//!
	}//!
}//!};
nodeType NULL = null;//!

nodeType head = NULL;//!nodeType* head = NULL;


public void addToFront (int k)
{
   nodeType newNode = new nodeType();
   newNode.link = head;
   newNode.info.set(k);//!   newNode.info = k;
   head = newNode;
}

public void setUp ()
{
	head = NULL;
	addToFront(45);
	addToFront(63);
	addToFront(92);
	addToFront(17);
}


public void traverse ()//!
//!void traverse ()
//
// Traverse a linked list from beginning to end
// 
{
	ActivationRecord arec = Animation.activate(getClass());//!
	arec.refVar("head", head).breakHere("starting traversal");//!
	nodeType current = head;//!    nodeType* current = head;
	arec.refVar("current", current).breakHere("start at the head");//!
	
	while (current != NULL)
	{
		// Process the current node
		arec.breakHere("inside the loop");//!
		arec.out().print(current.info + " ");//!        cout << current->info << " ";
		arec.breakHere("processed current node");//!
		current = current.link;//!        current = current->link;
		arec.refVar("current", current).breakHere("moved current forward one step");//!
	}
	arec.breakHere("Exited loop after reaching end of list");//!
	arec.out().println();//!    cout << endl;
}


public void insert (nodeType p, int value)//!
//!void insert (nodeType *p, int value)
//
// Insert value after node p
//
{
	ActivationRecord arec = Animation.activate(getClass());//!
	arec.refParam("p", p).param("value", value).refVar("head", head).breakHere("starting insertion");//!
	nodeType newNode = new nodeType();//!    nodeType *newNode = new nodeType;
	arec.refVar("newNode", newNode).breakHere("allocated new node");//!
	newNode.info.set(value);//!    newNode->info = value;
	arec.breakHere("inserted data into new node");//!
	newNode.link = p.link;//!    newNode->link = p->link;
	arec.breakHere("make new node point to p's successor");//!
	p.link = newNode;//!    p->link = newNode;
	arec.breakHere("make p point to the new node");//!
	arec.breakHere("Insertion has been completed");//!
	arec.breakHere("Trace the next links and see for yourself that the new node was inserted right after p.");//!
	arec.breakHere("Trace the next links and see for yourself that the new node was inserted right after p.");//!
}

public void remove (nodeType p)//!
//!void remove (nodeType *p)
//
//Remove value after node p
//
{
	ActivationRecord arec = Animation.activate(getClass());//!
	arec.refParam("p", p).refVar("head", head).breakHere("starting deletion");//!
	nodeType q = p.link;//!    nodeType *q = p->link;
	arec.refVar("q", q).breakHere("q is the node that will be removed");//!
	p.link = q.link;//!    p->link = q->link;
	arec.breakHere("Changed p's link to 'bypass' q");//!
	q = null;//!    delete q;
	arec.breakHere("reclaimed the memory used by node q");//!
	arec.breakHere("Removal is now completed");//!
	arec.breakHere("Removal is now completed");//!
}
        
        
}//!
