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

//!

public class node implements CanBeRendered<node>, Renderer<node> {//!



//!template <class T>
//!class node 
//!{
//!   static const node<T>* null = 0;
//!public:
//!  node (const T & v)
	public node (int v) //!
	{
		value = v;
		left = null;
		right = null;
	}//!
//!  
//!private:
  private int value;	//!  T value;
  private node left;//!  node<T> * left;
  private node right;//!  node<T> * right;
//!};


  
  
//!template <class T> 
public node find (int element)//!node<T>* node::find (const T& element)
{ 
	ActivationRecord arec = Animation.activate(this);//!
	arec.highlight(this);//!
	arec.param("element",element).breakHere("find here or somewhere below");//!
	if (element < value)
	  {arec.breakHere("look down to the left");//!
	  return (left != null) ? left.find(element) : null;}//!      return (left != null) ? left->find(element) : null;
	else if (value < element)
	  {arec.breakHere("look down to the right");//!
	  return (right != null) ? right.find(element) : null;}//!      return (right != null) ? right->find(element) : null;}
	else  // t->value == element
	{arec.breakHere("Found It!!");//!
	return this;
	}//!
}


//!template <class T> 
public void insert (int element)//!void node<T>::insert (const T& element)
{ 
	  ActivationRecord arec = Animation.activate(this);//!
	  arec.highlight(this);//!
	  arec.param("element",element).breakHere("insert somewhere here or below");//!
	  if (element < value) 
	  {
		  arec.breakHere("look at the left child");//!
		  if (left != null)
		  {
			  arec.breakHere("move down to the left");//!
			  left.insert (element);//!			  left->insert (element);
			  arec.breakHere("returning from the left");//!
		  }
		  else
		  {
			  arec.breakHere("insert a new node on the left");//!
			  left = new node(element);//!			  left = new node<T>(element);//!
			  arec.breakHere("inserted new node");//!  
		  }
	  } 
	  else if (value < element)
	  {
		  arec.breakHere("look at the right child");//!
		  if (right != null)
		  {
			  arec.breakHere("move down to the right");//!
			  right.insert (element);//!			  right->insert (element);
			  arec.breakHere("returning from the right");//!
		  }
		  else
		  {
			  arec.breakHere("insert a new node on the right");//!
			  right = new node(element);//!			  right = new node<T>(element);
			  arec.breakHere("inserted new node");//!  
		  }
	  } 
	  else  // value == element
		  return; // If we want no duplicates
	  // right->insert (element); // If we permit duplicates
}

@Override
public Renderer<node> getRenderer() {
	return this;
}

@Override
public Color getColor(node obj) {
	return Color.cyan;
}

@Override
public List<Component> getComponents(node obj) {
	List<Component> results = new LinkedList<Component>();
	return results;
}
@Override
public List<Connection> getConnections(node obj) {
	LinkedList<Connection> results = new LinkedList<Connection>();
	Connection leftC = new Connection(left, 215, 215);
	Connection rightC = new Connection(right, 145, 145);
	results.add (leftC);
	results.add (rightC);
	return results;
}
@Override
public int getMaxComponentsPerRow(node obj) {
	return 0;
}
@Override
public String getValue(node obj) {
	return "" + value;
}
	

public void quickInsert (int element)
{ 
	  if (element < value) 
	  {
		  if (left != null)
		  {
			  left.quickInsert (element);
		  }
		  else
		  {
			  left = new node(element);
		  }
	  } 
	  else if (value < element)
	  {
		  if (right != null)
		  {
			  right.quickInsert (element);
		  }
		  else
		  {
			  right = new node(element);
		  }
	  } 
	  else  // value == element
		  return; // If we want no duplicates
	  // right->insert (element); // If we permit duplicates
}

}
