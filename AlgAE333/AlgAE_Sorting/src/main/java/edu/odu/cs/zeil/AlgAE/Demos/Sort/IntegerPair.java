package edu.odu.cs.zeil.AlgAE.Demos.Sort;

import edu.odu.cs.zeil.AlgAE.Direction;
import edu.odu.cs.zeil.AlgAE.Server.Rendering;
import edu.odu.cs.zeil.AlgAE.Server.Visible;
import edu.odu.cs.zeil.AlgAE.Server.VisibleRendering;

import edu.odu.cs.zeil.AlgAE.Demos.Utils.VisibleInteger;

import java.awt.Color;


/**
 * Pairs of integers (used in portraying recursion stacks)
 *
 * @author Steven Zeil
 */
public class IntegerPair implements Visible
{
  private VisibleRendering vr;
  private VisibleInteger v1;
  private VisibleInteger v2;
  
  private static Color defaultInnerColor = Color.cyan;
  private static Color defaultOuterColor = Color.blue;
  

  public IntegerPair (int i1, int i2, Color inner, Color outer)
  {
    v1 = new VisibleInteger (i1, inner);
    v2 = new VisibleInteger (i2, inner);
    vr = new VisibleRendering (this, outer, false);
  }
  

  public void setInt1 (int v)  {v1.setInt (v);}
  public void setInt2 (int v)  {v2.setInt (v);}


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
    vr.touch (v1);
    vr.touch (v2);
  }
  
}

