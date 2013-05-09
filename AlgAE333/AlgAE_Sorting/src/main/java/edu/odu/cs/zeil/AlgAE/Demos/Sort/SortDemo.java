package edu.odu.cs.zeil.AlgAE.Demos.Sort;

import edu.odu.cs.zeil.AlgAE.Server.Animation;
import edu.odu.cs.zeil.AlgAE.Server.MenuFunction;
import edu.odu.cs.zeil.AlgAE.Server.algae;

import edu.odu.cs.zeil.AlgAE.Demos.Utils.AliasArray;
import edu.odu.cs.zeil.AlgAE.Demos.Utils.VisibleInteger;


import edu.odu.cs.zeil.AlgAE.Demos.Sort.Supporting.Comparable;
import edu.odu.cs.zeil.AlgAE.Demos.Sort.DataStructures.Sort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


class CompVisibleInteger 
  extends VisibleInteger 
  implements Comparable
{
  CompVisibleInteger (String s, Color c) 
  {
    super(s, c);
  }
  
  CompVisibleInteger (int i, Color c)
  {
    super (i, c);
  }
  
  public int compares( Comparable rhs )
  {
    int v1 = intValue();
    CompVisibleInteger r = (CompVisibleInteger)rhs;
    int v2 = r.intValue();
    if (v1 < v2)
      return -1;
    else if (v1 == v2)
      return 0;
    else
      return 1;
  }

  public boolean lessThan( Comparable rhs )
  {
    return compares(rhs) < 0;
  }
}
  

/**
 *  Main driver for demo of sorting algorithms from
 *  Weiss' Algorithms, Data Structures and Problem Solving with Java
 *
 *  This driver can be executed either as an applet or as a standalone
 *  application.
 *
 *  @author Steven J. Zeil
 **/
public class SortDemo extends Animation
{
  CompVisibleInteger[] arrayToSort;
  AliasArray visibleArray;
  Random rand;

  /**
   * Constructor for SortDemo applets
   */
  public SortDemo ()
  {
    super ("Sorting");
    arrayToSort = null;
    visibleArray = null;
    rand = new Random();
  }
  

  /**
   * Constructor for SortDemo standalones
   */
  public SortDemo (String[] args)
  {
    super ("Sorting", args);
    arrayToSort = null;
    visibleArray = null;
    rand = new Random();
  }

  /**
   *  Documentation string for Help..About box.
   */
  public String about()
  {
    return
      "Sort code from\n" +
      "  Mark Allen Weiss: Data Structures and Problem Solving Using Java\n" +
      "  1998, Addison Wesley\n\n" +
      "converted to AlgAE demo by\n" +
      "  Steven Zeil, Old Dominion Univ.";
  }


  public void createArray()
  {
    String prompt = "Number of elements?";
    int n = -1;
    while (n < 0)
      {
	String reply = algae.promptForInput(prompt);
	try
	  {
	    Integer k = new Integer(reply);
	    n = k.intValue();
	  }
	catch (NumberFormatException e) {
	  prompt = "Please answer with an integer\nNumber of elements?";
	}
      }
    createArray(n);
  }
  

  public void createArray(int n)
  {
    arrayToSort = new CompVisibleInteger[n];
    if (visibleArray != null)
      visibleArray.getRendering().hide();
    visibleArray = new AliasArray (arrayToSort, Color.blue, false,
				   Color.cyan, false);
    visibleArray.getRendering().show();

    for (int i = 0; i < n; ++i)
      arrayToSort[i] = new CompVisibleInteger
	(Math.abs(rand.nextInt() % (2*n)),
	 Color.cyan);
  }
  

  /**
   *  Algorithm menu items
   */
  public void buildMenu (JMenu algorithmMenu)
  {
	  JMenuItem item = new JMenuItem ("generate random array");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  createArray();
			  for (int i = 0; i < arrayToSort.length; ++i)
				  arrayToSort[i] = new CompVisibleInteger(i, Color.cyan);
		  }
	  });
	  algorithmMenu.add(item);

	  item = new JMenuItem ("generate reversed array");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  createArray();
			  int n = arrayToSort.length;
			  for (int i = 0; i < n; ++i)
				  arrayToSort[i] = new CompVisibleInteger(n-i, Color.cyan);
		  }
	  });
	  algorithmMenu.add(item);
	  
	  item = new JMenuItem ("-");
	  algorithmMenu.add(item);

	  item = new JMenuItem ("insertion sort");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  if (arrayToSort == null)
				  createArray(8);

			  Sort.insertionSort (arrayToSort, visibleArray);
			  algae.unHighlightAll();
		  }
	  });
	  algorithmMenu.add(item);
	  
	  item = new JMenuItem ("Shell sort");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  if (arrayToSort == null)
				  createArray(8);

			  Sort.shellsort (arrayToSort, visibleArray);
			  algae.unHighlightAll();
		  }
	  });
	  algorithmMenu.add(item);
	  
	  item = new JMenuItem ("Merge sort");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  if (arrayToSort == null)
				  createArray(8);

			  Sort.mergeSort (arrayToSort, visibleArray);
			  algae.unHighlightAll();
		  }
	  });
	  algorithmMenu.add(item);
	  
	  item = new JMenuItem ("Quick sort");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  if (arrayToSort == null)
				  createArray(8);

			  Sort.quicksort (arrayToSort, visibleArray);
			  algae.unHighlightAll();
		  }
	  });
	  algorithmMenu.add(item);
	  
	  item = new JMenuItem ("heap sort");
	  item.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  if (arrayToSort == null)
				  createArray(8);

			  Sort.heapsort (arrayToSort, visibleArray);
			  algae.unHighlightAll();
		  }
	  });
	  algorithmMenu.add(item);

    
  }


  public static void main(String[] args)
  {
    SortDemo demo = new SortDemo(args);
  }
  
  
}

  





