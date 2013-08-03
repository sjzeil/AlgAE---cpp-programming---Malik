package edu.odu.cs.cs333.animations;//!

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import static edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation.activate;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.ActivationRecord;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Component;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Connection;//!
import edu.odu.cs.AlgAE.Server.Rendering.CanBeRendered;//!
import edu.odu.cs.AlgAE.Server.Rendering.Renderer;//!
import edu.odu.cs.AlgAE.Server.Utilities.SimpleReference;//!


//!

public class BinarySearchTree implements CanBeRendered<BinarySearchTree>, Renderer<BinarySearchTree> {//!



//!template <class T>
//!class node 
//!{
//!public:
	public //!
   BinarySearchTree () {
//!    : root(0), 
		root = null;//!
	}

//!   node<T>* find (const T& element) const;
//!   void insert (const T& element);
//!   void clear();
	
//!private:
  private//!
  node root;	//!  node<T>* root;
//!};

  
  
//!template <class T> 
public node find (int element)//!node<T>* BinarySearchTree<T>::find (const T& element) const
{ 
	  ActivationRecord arec = activate(this);//!
	  arec.param("element",element).breakHere("search");//!
	  if (root != null) {//!   if (root != 0)
		  arec.breakHere("search non-empty tree");//!
		  node result = root.find(element);//!
		  arec.refVar("return value", result).breakHere("search result is");//!
		  return result; }//!      return root->find(element);
	  else
		  { arec.breakHere("tree is empty");//!
		  return null; }//!      return 0; 
}


//!template <class T> 
public void insert (int element)//!void BinarySearchTree<T>::insert (const T& element)
{ 
	  ActivationRecord arec = activate(this);//!
	  arec.param("element",element).breakHere("insert");//!
	  if (root != null) {//!   if (root != 0)
		  arec.breakHere("insert into non-empty tree");//!
		  root.insert(element);//!      root->insert (element);
		  arec.breakHere("insert completed"); }//!
	  else
		  { arec.breakHere("insert into empty tree");//!
		  root = new node(element);
		  arec.breakHere("insert completed"); }//!
}



//!template <class T> 
public void clear ()//!void BinarySearchTree::clear ()
{ 
	//!   delete root;
	root = null;//!      root = 0;
}

@Override
public Renderer<BinarySearchTree> getRenderer() {
	return this;
}

@Override
public Color getColor(BinarySearchTree obj) {
	return Color.magenta;
}

@Override
public List<Component> getComponents(BinarySearchTree obj) {
	List<Component> components = new LinkedList<Component>();
	components.add (new Component(new SimpleReference(root, 180, 180), "root"));
	return components;
}
@Override
public List<Connection> getConnections(BinarySearchTree obj) {
	LinkedList<Connection> results = new LinkedList<Connection>();
	return results;
}
@Override
public int getMaxComponentsPerRow(BinarySearchTree obj) {
	return 1;
}
@Override
public String getValue(BinarySearchTree obj) {
	return "";
}
	

public void quickInsert (int element)
{ 
	if (root != null)
		root.quickInsert(element);
	else
		root = new node(element);
}

}
