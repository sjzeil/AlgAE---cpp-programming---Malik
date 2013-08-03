package edu.odu.cs.cs333.animations;//!

import java.awt.Color;//!
import java.util.LinkedList;//!
import java.util.List;//!

import static edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation.activate;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.ActivationRecord;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Component;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Connection;//!
import edu.odu.cs.AlgAE.Server.Rendering.CanBeRendered;//!
import edu.odu.cs.AlgAE.Server.Rendering.Renderer;//!

//!

public class BinaryTrees {//!

//!template <class T>	
	public class BinaryTreeNode implements CanBeRendered<BinaryTreeNode>, Renderer<BinaryTreeNode> //!struct BinaryTreeNode 
{
   String data;//!   T data;
   BinaryTreeNode left;//!   BinaryTreeNode* left;
   BinaryTreeNode right;//!   BinaryTreeNode* right;
   
   public BinaryTreeNode(String datav, BinaryTreeNode leftc, BinaryTreeNode rightc) {//!
	   data = datav;//!
	   left = leftc;//!
	   right = rightc;//!
   }//!
@Override//!
public Renderer<BinaryTreeNode> getRenderer() {//!
	return this;//!
}//!
@Override//!
public Color getColor(BinaryTreeNode obj) {//!
	return Color.green;//!
}//!
@Override//!
public List<Component> getComponents(BinaryTreeNode obj) {//!
	List<Component> results = new LinkedList<Component>();//!
	return results;//!
}//!
@Override//!
public List<Connection> getConnections(BinaryTreeNode obj) {//!
	LinkedList<Connection> results = new LinkedList<Connection>();//!
	Connection leftChild = new Connection(left, 215, 215);//!
	Connection rightChild = new Connection(right, 145, 145);//!
	results.add (leftChild);//!
	results.add (rightChild);//!
	return results;//!
}//!
@Override//!
public int getMaxComponentsPerRow(BinaryTreeNode obj) {//!
	return 0;//!
}//!
@Override//!
public String getValue(BinaryTreeNode obj) {//!
	return data;//!
}//!
}//!};
	
public void preOrder (BinaryTreeNode t)//!void preOrder (BinaryTreeNode* t)
{
   ActivationRecord arec = activate(getClass());//!
   if (t != null) arec.highlight(t);//!
   arec.refParam("t", t).breakHere("entered preOrder()");//!
   if (t != null)//!  if (t != 0)
    {
	  arec.out().print(t.data + " ");//!      cout << t->data << " ";
	  arec.breakHere("printed - now go left");//!
      preOrder(t.left);//!      preOrder(t->left);
	  arec.breakHere("Returned from the left - now go right");//!
      preOrder(t.right);//!      preOrder(t->right);
    }
	arec.breakHere("All done here");//!
}

	
public void postOrder (BinaryTreeNode t)//!void postOrder (BinaryTreeNode* t)
{
	   ActivationRecord arec = activate(getClass());//!
	   if (t != null) arec.highlight(t);//!
	   arec.refParam("t", t).breakHere("entered postOrder()");//!
  if (t != null)//!  if (t != 0)
    {
	  arec.breakHere("First go left");//!
      postOrder(t.left);//!      postOrder(t->left);
	  arec.breakHere("Back from the left - now go right");//!
      postOrder(t.right);//!      postOrder(t->right);
	  arec.breakHere("Back from the right - print");//!
      arec.out().print(t.data + " ");//!      cout << t->data << " ";
    }
	arec.breakHere("All done here");//!
}

	
public void inOrder (BinaryTreeNode t)//!void inOrder (BinaryTreeNode* t)
{
	   ActivationRecord arec = activate(getClass()	);//!
	   if (t != null) arec.highlight(t);//!
	   arec.refParam("t", t).breakHere("entered inOrder()");//!
  if (t != null)//!  if (t != 0)
    {
	  arec.breakHere("First go left");//!
      inOrder(t.left);//!      inOrder(t->left);
	  arec.breakHere("Back from the left - print");//!
      arec.out().print(t.data + " ");//!      cout << t->data << " ";
	  arec.breakHere("printed - now go right");//!
      inOrder(t.right);//!      inOrder(t->right);
    }
	arec.breakHere("All done here");//!
}


public BinaryTreeNode createSampleTree1()//!
{
	BinaryTreeNode c13 = new BinaryTreeNode("13", null, null);//!
	BinaryTreeNode a = new BinaryTreeNode("a", null, null);//!
	BinaryTreeNode x = new BinaryTreeNode("X", null, null);//!
	BinaryTreeNode c1 = new BinaryTreeNode("1", null, null);//!
	BinaryTreeNode oplus = new BinaryTreeNode("+", c13, a);//!
	BinaryTreeNode ominus = new BinaryTreeNode("-", x, c1);//!
	BinaryTreeNode otimes = new BinaryTreeNode("*", oplus, ominus);//!
	return otimes;
}
			
}
