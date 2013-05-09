package edu.odu.cs.zeil.AlgAE.Demos.Sort;

import edu.odu.cs.zeil.AlgAE.Direction;

import edu.odu.cs.zeil.AlgAE.Server.Rendering;
import edu.odu.cs.zeil.AlgAE.Server.Visible;
import edu.odu.cs.zeil.AlgAE.Server.VisibleRendering;

import edu.odu.cs.zeil.AlgAE.Demos.Utils.Alias;

import java.awt.Color;
import java.util.Vector;


/**
 * Portrays a heap stored in a conventional array as a tree-like structure.
 *
 * @author Steven Zeil
 */
public class HeapTree
{
  private Color elementColor;
  private Visible[] theArray;
  private boolean showing;
  
  class HeapElement implements Visible
  {
    private int index;
    private VisibleRendering vr;

    HeapElement (int positionInArray)
    {
      vr = new VisibleRendering (this, elementColor);
      index = positionInArray;
    }

    /**
     * This function returns the VisibleRendering data member
     *
     * @return  the rendering information for this object.
     **/
    public Rendering getRendering()
    {
      return vr;
    }
  
    

    /**
     * Produce the text string to be displayed in the picture of the object.
     *
     * @return the text string to be displayed
     **/
    public String getAlgAEText()
    {
      Visible v = theArray[index];
      if (v != null)
	return v.getAlgAEText();
      else
	return "";
    }
  

    /**
     * If an object <CODE>s</CODE> is to be portrayed as having 
     * pointers/references/arrows to other Visible objects, then when
     * <CODE>s.touchAllPointers()</CODE> is called, 
     * the body of <CODE>touchAllPointers</CODE> should call, for each arrow
     * from <CODE>s</CODE> to another Visible object <CODE>p</CODE>,
     * <CODE>s.getRendering().touch(p, dir)</CODE> or
     * <CODE>s.getRendering().touch(p, dir, label)</CODE>.
     * <P>
     * <CODE>dir</CODE> is the "exit" direction from which the AlgAE system
     * will draw the arrow from <CODE>s</CODE> to <CODE>p</CODE>.
     **/
    public void touchAllPointers()
    {
      int nHeap = elements.size();
      int i = index + 1;
      if (2*i <= nHeap)
	{
	  vr.touch ((HeapElement)elements.elementAt(2*i-1), Direction.SSW);
	  if (2*i + 1 <= nHeap)
	    vr.touch ((HeapElement)elements.elementAt(2*i), Direction.SSE);
	}
    }
  

    /**
     * If an object <CODE>s</CODE> is to be portrayed as a compound structure
     * containing other Visible objects, then when
     * <CODE>s.touchAllComponents()</CODE> is called, 
     * the body of <CODE>touchAllComponents</CODE> should call, for each
     * contained Visible component <CODE>p</CODE>,
     * <CODE>s.getRendering().touch(p)</CODE>.
     * <P>
     * Note that the the distinction between a "Pointer" and a "Component"
     * is a logical distinction, as they are both typically implemented as
     * simple data members of the Visible class.  It is up to the designer
     * of the algorithm animation to decide what to portray as references and
     * what to portray as contained components.
     **/
    public void touchAllComponents()
    { 
    }
  }
  

  private Vector elements;
  
  
  public HeapTree (Visible[] array, Color color)
  {
    theArray = array;
    elementColor = color;
    elements = new Vector();
    showing = false;
  }


  public void setSize(int heapSize)
  {
    int oldSize = elements.size();

    if (showing)
      {
	if (oldSize > 0 && heapSize <= 0)
	  {
	    Visible v = (Visible)elements.firstElement();
	    v.getRendering().hide();
	  }
      }


    while (heapSize < elements.size())
      elements.removeElementAt (elements.size()-1);
    while (heapSize > elements.size())
      elements.addElement (new HeapElement (elements.size()));

    if (showing)
      {
	if (oldSize <= 0 && heapSize > 0)
	  {
	    Visible v = (Visible)elements.firstElement();
	    v.getRendering().show();
	  }
      }
  }


  
  /**
   *  Returns the element at position i
   **/
  public Visible elementAt(int i)
  {
    if (i >= 0 && i < elements.size())
      return (Visible)elements.elementAt(i);
    else
      return null;
  }


  /**
   * Show this heap in the animation.
   */
  public void show()
  {
    if (!showing)
      {
	showing = true;
	if (elements.size() > 0)
	  {
	    Visible v = (Visible)elements.firstElement();
	    v.getRendering().show();
	  }
      }
  }


  /**
   * Hide this heap in the animation.
   */
  public void hide()
  {
    if (showing)
      {
	showing = false;
	if (elements.size() > 0)
	  {
	    Visible v = (Visible)elements.firstElement();
	    v.getRendering().hide();
	  }
      }
  }

}
