package /*{*/edu.odu.cs.zeil.AlgAE.Demos.Sort./*}*/DataStructures;

/*{*/ // /*}*/import /*{*/edu.odu.cs.zeil.AlgAE.Demos.Sort./*}*/Supporting.*;
import /*{*/edu.odu.cs.zeil.AlgAE.Demos.Sort./*}*/Supporting.Comparable;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Sort.HeapTree;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Sort.IntegerPair;
/*{*/
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.Alias;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.AliasArray;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.ShadowArray;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.VisibleInteger;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.VisibleVector;
/*{*/import edu.odu.cs.zeil.AlgAE.Demos.Utils.WhiteBox;
/*{*/import edu.odu.cs.zeil.AlgAE.Server.algae;
/*{*/import edu.odu.cs.zeil.AlgAE.Server.Visible;
/*{*/import java.awt.Color;

/**
 * A class that contains several sorting routines,
 * implemented as static methods.
 * Arrays are rearranged with smallest item first,
 * using compares.
 * @author Mark Allen Weiss
 */
public final class Sort
{
    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    public static void insertionSort( Comparable [ ] a /*{*/, AliasArray aa/*}*/)
    {
/*{*/     WhiteBox wb = new WhiteBox (false);
/*{*/     wb.getRendering().show();
/*{*/     VisibleInteger vj = new VisibleInteger(99, Color.yellow); 
/*{*/     vj.getRendering().setName("j");
/*{*/     vj.indexes(aa); 
/*{*/     wb.add (vj);
/*{*/     VisibleInteger vp = new VisibleInteger(99, Color.yellow); 
/*{*/     vp.getRendering().setName("p");
/*{*/     vp.indexes(aa); 
/*{*/     wb.add (vp);
        for( int p = 1; p < a.length; p++ )
	  {
/*{*/         vp.setInt(p);
            Comparable tmp = a[ p ];
/*{*/           Alias vtmp = new Alias(tmp, Color.green); 
/*{*/           vtmp.getRendering().setName("tmp");
/*{*/           wb.add (vtmp);
/*{*/         algae.FRAME("Where to place p'th object?"); 
            int j = p;
/*{*/         vj.setInt (j);
/*{*/         algae.FRAME("Start looking here."); 
            for( ; j > 0 && tmp.lessThan( a[ j - 1 ] ); j-- )
/*{*/        {
/*{*/            vj.setInt(j); 
/*{*/            algae.FRAME("Move j-1 element up."); 
                a[ j ] = a[ j - 1 ];
/*{*/        }
/*{*/         vj.setInt(j); algae.FRAME("Found where to put tmp."); 
            a[ j ] = tmp;
/*{*/         wb.remove (vtmp);
        }
/*{*/     wb.getRendering().hide();
/*{*/     algae.FRAME("Done."); 
    }

    /**
     * Shellsort, using a sequence suggested by Gonnet.
     * @param a an array of Comparable items.
     */
    public static void shellsort( Comparable [ ] a /*{*/, AliasArray aa/*}*/)
    {
/*{*/     WhiteBox wb = new WhiteBox (false);
/*{*/     wb.getRendering().show();
/*{*/     VisibleInteger vgap = new VisibleInteger(99, Color.cyan); 
/*{*/     vgap.getRendering().setName("gap");
/*{*/     wb.add (vgap);
/*{*/     VisibleInteger vj = new VisibleInteger(99, Color.yellow); 
/*{*/     vj.getRendering().setName("j");
/*{*/     vj.indexes(aa); 
/*{*/     wb.add (vj);
/*{*/     VisibleInteger vi = new VisibleInteger(99, Color.yellow); 
/*{*/     vi.getRendering().setName("i");
/*{*/     vi.indexes(aa); 
/*{*/     wb.add (vi);
        for( int gap = a.length / 2; gap > 0;
                     gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
/*{*/         { vgap.setInt(gap);
            for( int i = gap; i < a.length; i++ )
            {
/*{*/           vi.setInt(i);
                Comparable tmp = a[ i ];
/*{*/           Alias vtmp = new Alias(tmp, Color.green); 
/*{*/           vtmp.getRendering().setName("tmp");
/*{*/           wb.add (vtmp);

/*{*/           aa.highlight(i % gap, i+1, gap);
/*{*/		   
/*{*/           algae.FRAME("Shell: Where to place i'th object?"); 
                int j = i;
/*{*/           vj.setInt(j);

/*{*/           algae.FRAME("Shell: Start looking at a[j]."); 
                for( ; j >= gap && tmp.lessThan( a[ j - gap ] ); j -= gap )
/*{*/        {
/*{*/            vj.setInt(j); 
/*{*/            algae.FRAME("Shell: Move j-gap element up."); 
                    a[ j ] = a[ j - gap ];
/*{*/        }
/*{*/         vj.setInt(j); algae.FRAME("Shell: Found where to put tmp."); 
                a[ j ] = tmp;
/*{*/         algae.unHighlightAll(); algae.FRAME("Shell: Done with this element."); 
/*{*/           wb.remove (vtmp);
            }
/*{*/    algae.FRAME("Shell: Now decrease the gap."); }
/*{*/    wb.getRendering().hide(); algae.FRAME("Shell: Done."); 
    }
     
/*{*/private static void highlightSubtreeRecursion 
/*{*/   (AliasArray aa, HeapTree t, int i, Color c)
/*{*/{
/*{*/  Visible v = t.elementAt(i);
/*{*/  if (v != null)
/*{*/    {
/*{*/      v.getRendering().highlight(c);
/*{*/      aa.aliasAt(i).getRendering().highlight(c);
/*{*/      highlightSubtreeRecursion (aa, t, 2*i+1, c);
/*{*/      highlightSubtreeRecursion (aa, t, 2*i+2, c);
/*{*/    }
/*{*/}
/*{*/
/*{*/private static void highlightSubtree (AliasArray aa, HeapTree t, int i, Color c)
/*{*/{
/*{*/  algae.unHighlightAll();
/*{*/  highlightSubtreeRecursion (aa, t, i, c);
/*{*/}
 
  
    

    /**
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public static void heapsort( Comparable [ ] a /*{*/, AliasArray aa/*}*/)
    {
/*{*/  HeapTree tree = new HeapTree (a, Color.cyan);
/*{*/  tree.setSize (a.length); tree.show();
/*{*/  algae.FRAME ("Start to build heap from array"); 
/*{*/  VisibleInteger vi = new VisibleInteger (99, Color.yellow);
/*{*/  vi.indexes (aa); vi.getRendering().setName("i"); vi.getRendering().show();
        for( int i = a.length / 2; i >= 0; i-- )  /* buildHeap */ 
/*{*/     { vi.setInt (i);
/*{*/       highlightSubtree (aa, tree, i, Color.magenta);
/*{*/       algae.FRAME ("percolate down from here");
            percDown( a, i, a.length  /*{*/, tree, aa/*}*/);
/*{*/     } algae.FRAME("Start deleting elements");
        for( int i = a.length - 1; i > 0; i-- )
        {
/*{*/       vi.setInt (i);
/*{*/       tree.setSize (i+1);
/*{*/       algae.FRAME ("deleteMax: swap max element to end");
            swapReferences( a, 0, i );            /* deleteMax */
/*{*/       tree.setSize (i);
/*{*/       algae.FRAME ("deleteMax: restore heap by percolating down");
            percDown( a, 0, i  /*{*/, tree, aa/*}*/);
        }
/*{*/  tree.hide(); vi.getRendering().hide();
/*{*/  algae.FRAME ("heap sort: done");
    }

    /**
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in
     * deleteMax and buildHeap.
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static void percDown( Comparable [ ] a, int i, int n /*{*/, HeapTree tree, AliasArray aa/*}*/)
    {
        int child;
        Comparable tmp;

/*{*/   highlightSubtree (aa, tree, i, Color.magenta);
/*{*/   algae.FRAME ("percDown percolate down from here");
/*{*/     WhiteBox wb = new WhiteBox (false);
/*{*/     wb.getRendering().show();
/*{*/     VisibleInteger vi = new VisibleInteger(99, Color.magenta); 
/*{*/     vi.getRendering().setName("i");
/*{*/     vi.indexes(aa); 
/*{*/     wb.add (vi);
/*{*/     VisibleInteger vchild = new VisibleInteger(99, Color.magenta); 
/*{*/     vchild.getRendering().setName("child");
/*{*/     vchild.indexes(aa); 
/*{*/     wb.add (vchild);
/*{*/           Alias vtmp = new Alias(vchild, Color.green); 
/*{*/           vtmp.getRendering().setName("tmp");
/*{*/           wb.add (vtmp);
        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
/*{*/           vtmp.setAliased (tmp);
/*{*/           vi.setInt (i);
/*{*/           vchild.setInt (child);
/*{*/       highlightSubtree (aa, tree, i, Color.magenta);
/*{*/         algae.FRAME("Move down?"); 
            if( child != n - 1 && a[ child ].lessThan( a[ child + 1 ] ) )
/*{*/   {        algae.FRAME("Right child is larger"); 
                child++;
/*{*/   }   vchild.setInt (child); algae.FRAME("Swap with larger child?"); 
            if( tmp.lessThan( a[ child ] ) )
/*{*/   {        algae.FRAME("Yes, swap with larger child."); 
                a[ i ] = a[ child ];
/*{*/   }
            else
                break;
        }
/*{*/   algae.FRAME("Fill tmp into 'hole' at i");
        a[ i ] = tmp;
/*{*/   wb.getRendering().hide();
    }

    /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
    public static void mergeSort( Comparable [ ] a /*{*/, AliasArray aa/*}*/)
    {
        Comparable [ ] tmpArray = new Comparable[ a.length ];

/*{*/   VisibleVector stack = new VisibleVector(Color.red, true);      
/*{*/   AliasArray visibletmp = new AliasArray (tmpArray, Color.black, false, Color.cyan, true);
/*{*/   visibletmp.getRendering().setName ("tmpArray");  visibletmp.getRendering().show();

/*{*/   algae.FRAME("Set up for recursive merge sort"); stack.getRendering().show();
        mergeSort( a, tmpArray, 0, a.length - 1 /*{*/, stack, visibletmp, aa /*}*/);
/*{*/   algae.FRAME("Completed recursive merge sort"); stack.getRendering().hide(); visibletmp.getRendering().hide();
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static void mergeSort( Comparable [ ] a, Comparable [ ] tmpArray,
               int left, int right /*{*/, VisibleVector stack, AliasArray vtmpArray, AliasArray aa /*}*/)
    {
/*{*/stack.push (new IntegerPair (left, right, Color.pink, Color.red));
/*{*/algae.unHighlightAll();  aa.highlight (left, right+1, 1);
/*{*/algae.FRAME("New call to mergeSort");
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center /*{*/, stack, vtmpArray, aa /*}*/);
/*{*/algae.FRAME("mergeSort: returned from 1st recursive call");
            mergeSort( a, tmpArray, center + 1, right /*{*/, stack, vtmpArray, aa /*}*/);
/*{*/algae.unHighlightAll();
/*{*/Color c = a[0].getRendering().color(); 
/*{*/aa.setColor (left, center+1, 1, Color.green); 
/*{*/aa.setColor (center+1, right+1, 1, Color.magenta); 
/*{*/vtmpArray.setColor (left, right+1, 1, Color.lightGray); 
/*{*/algae.FRAME("mergeSort: returned from 2nd recursive call");
            merge( a, tmpArray, left, center + 1, right /*{*/, vtmpArray, aa /*}*/);
/*{*/algae.FRAME("mergeSort: merge completed");
/*{*/aa.setColor (left, right+1, 1, c); 
/*{*/vtmpArray.setColor (left, right+1, 1, c); 
        }
/*{*/stack.pop ();
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static void merge( Comparable [ ] a, Comparable [ ] tmpArray,
           int leftPos, int rightPos, int rightEnd /*{*/, AliasArray vtmp, AliasArray aa/*}*/)
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
/*{*/     WhiteBox wb = new WhiteBox (false);
/*{*/     wb.getRendering().show();
/*{*/     VisibleInteger vleftPos = new VisibleInteger(leftPos, Color.yellow); 
/*{*/     vleftPos.getRendering().setName("leftPos");
/*{*/     wb.add (vleftPos);
/*{*/     VisibleInteger vrightPos = new VisibleInteger(rightPos, Color.yellow); 
/*{*/     vrightPos.getRendering().setName("rightPos");
/*{*/     wb.add (vrightPos);
/*{*/     VisibleInteger vtmpPos = new VisibleInteger(tmpPos, Color.orange); 
/*{*/     vtmpPos.getRendering().setName("tmpPos");
/*{*/     wb.add (vtmpPos);

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd ) /*{*/{
/*{*/algae.unHighlightAll(); 
/*{*/aa.aliasAt(leftPos).getRendering().highlight(Color.yellow);
/*{*/aa.aliasAt(rightPos).getRendering().highlight(Color.yellow);
/*{*/vleftPos.setInt (leftPos); vrightPos.setInt (rightPos); 
/*{*/vtmpPos.setInt (tmpPos); 
/*{*/vtmp.aliasAt(tmpPos).getRendering().highlight(Color.orange);
/*{*/algae.FRAME ("Main merge loop: copy smaller element");
            if( a[ leftPos ].lessThan( a[ rightPos ] ) )
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = a[ rightPos++ ]; /*{*/}

/*{*/algae.unHighlightAll(); 
/*{*/aa.highlight (leftPos, leftEnd+1, 1, Color.yellow);
/*{*/if (tmpPos < a.length) vtmp.aliasAt(tmpPos).getRendering().highlight(Color.orange);
/*{*/vleftPos.setInt (leftPos); vrightPos.setInt (rightPos); 
/*{*/vtmpPos.setInt (tmpPos); 
/*{*/algae.FRAME ("Copy rest of first half");
        while( leftPos <= leftEnd )    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];

/*{*/algae.unHighlightAll(); 
/*{*/aa.highlight (rightPos, rightEnd+1, 1, Color.yellow);
/*{*/if (tmpPos < a.length) vtmp.aliasAt(tmpPos).getRendering().highlight(Color.orange);
/*{*/vleftPos.setInt (leftPos); vrightPos.setInt (rightPos); 
/*{*/vtmpPos.setInt (tmpPos); 
/*{*/algae.FRAME ("Copy rest of right half");
        while( rightPos <= rightEnd )  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        // Copy TmpArray back
/*{*/algae.unHighlightAll(); 
/*{*/vleftPos.setInt (leftPos); vrightPos.setInt (rightPos); 
/*{*/vtmpPos.setInt (tmpPos); 
/*{*/algae.FRAME ("Copy TmpArray back");
        for( int i = 0; i < numElements; i++, rightEnd-- )
            a[ rightEnd ] = tmpArray[ rightEnd ];
/*{*/algae.FRAME ("Done with this merge"); wb.getRendering().hide();
    }

    /**
     * Quicksort algorithm.
     * @param a an array of Comparable items.
     */
    public static void quicksort( Comparable [ ] a /*{*/, AliasArray aa/*}*/)
    {
/*{*/   VisibleVector stack = new VisibleVector(Color.red, true);      
/*{*/   algae.FRAME("Set up for recursive quicksort"); stack.getRendering().show();
       quicksort( a, 0, a.length - 1 /*{*/, stack, aa /*}*/);
/*{*/   algae.FRAME("Completed recursive quicksort"); stack.getRendering().hide();
    }

  private static final int CUTOFF = 3; // more realistically, = 10;

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static void swapReferences( Object [ ] a, int index1, int index2 )
    {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private static void quicksort( Comparable [ ] a, int low, int high /*{*/, VisibleVector stack, AliasArray aa/*}*/)
     {/*{*/stack.push (new IntegerPair (low, high, Color.pink, Color.red));
/*{*/ aa.highlight (low, high+1, 1, Color.magenta);
      if( low + CUTOFF > high ) /*{*/ {
	/*{*/algae.FRAME("Cutting off quicksort");/*}*/insertionSort( a, low, high ); /*{*/ }
        else
        {
                // Sort low, middle, high
            int middle = ( low + high ) / 2;
/*{*/     WhiteBox wb = new WhiteBox (false);
/*{*/     wb.getRendering().show();
/*{*/     VisibleInteger vlow = new VisibleInteger(low, Color.yellow); 
/*{*/     vlow.getRendering().setName("low");
/*{*/     vlow.indexes(aa); 
/*{*/     wb.add (vlow);
/*{*/     VisibleInteger vmiddle = new VisibleInteger(middle, Color.yellow); 
/*{*/     vmiddle.getRendering().setName("middle");
/*{*/     vmiddle.indexes(aa); 
/*{*/     wb.add (vmiddle);
/*{*/     VisibleInteger vhigh = new VisibleInteger(high, Color.yellow); 
/*{*/     vhigh.getRendering().setName("high");
/*{*/     vhigh.indexes(aa); 
/*{*/     wb.add (vhigh);
/*{*/     algae.FRAME ("Sort low, middle, high");
            if( a[ middle ].lessThan( a[ low ] ) )
                swapReferences( a, low, middle );
            if( a[ high ].lessThan( a[ low ] ) )
                swapReferences( a, low, high );
            if( a[ high ].lessThan( a[ middle ] ) )
                swapReferences( a, middle, high );

                // Place pivot at position high - 1
/*{*/     algae.FRAME ("Place pivot at position high - 1");
            swapReferences( a, middle, high - 1 );
            Comparable pivot = a[ high - 1 ];

                // Begin partitioning
/*{*/           Alias vpivot = new Alias(pivot, Color.green); 
/*{*/           vpivot.getRendering().setName("pivot");
/*{*/           wb.add (vpivot);
/*{*/     algae.FRAME ("Begin partitioning");
            int i, j;
/*{*/     VisibleInteger vi = new VisibleInteger(-1, Color.yellow); 
/*{*/     vi.getRendering().setName("i");
/*{*/     vi.indexes(aa); 
/*{*/     wb.add (vi);
/*{*/     VisibleInteger vj = new VisibleInteger(-1, Color.yellow); 
/*{*/     vj.getRendering().setName("j");
/*{*/     vj.indexes(aa); 
/*{*/     wb.add (vj);
/*{*/     AliasArray nulla = null;
/*{*/     vlow.indexes (nulla);
/*{*/     vmiddle.indexes (nulla);
/*{*/     vhigh.indexes (nulla);
            for( i = low, j = high - 1; ; )
            {
/*{*/        vi.setInt(i); vj.setInt(j);
/*{*/        algae.FRAME("Increase i till a[i] >= pivot");
                while( a[ ++i ].lessThan( pivot ) )
		    /*{*/{vi.setInt(i); algae.FRAME("Increasing i");}/*}*/;
/*{*/        vi.setInt(i);
/*{*/        algae.FRAME("Decrease j till a[j] <= pivot");
                while( pivot.lessThan( a[ --j ] ) )
		    /*{*/{vj.setInt(j); algae.FRAME("Decreasing j");}/*}*/;
/*{*/        vj.setInt(j);
		    if( i < j ) /*{*/{
/*{*/               algae.FRAME("Exchange a[i] and a[j]");
                    swapReferences( a, i, j );/*{*/}
                else
                    break;
/*{*/        algae.FRAME("Exchanged");
            }

                // Restore pivot
/*{*/        algae.FRAME("Restore pivot");
            swapReferences( a, i, high - 1 );

/*{*/        aa.aliasAt(i).getRendering().setColor(Color.lightGray);
/*{*/        algae.FRAME("Recursive calls"); wb.getRendering().hide(); aa.unHighlight (low, high+1, 1);
            quicksort( a, low, i - 1 /*{*/, stack, aa /*}*/);    // Sort small elements
/*{*/        aa.highlight (low, high+1, 1, Color.magenta); algae.FRAME("Return from 1st recursive call"); aa.unHighlight (low, high+1, 1);
            quicksort( a, i + 1, high /*{*/, stack, aa /*}*/);   // Sort large elements
/*{*/        aa.highlight (low, high+1, 1, Color.magenta); algae.FRAME("Return from 2nd recursive call"); 
        }
/*{*/  stack.pop(); aa.unHighlight (low, high+1, 1);
    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param n the number of items to sort.
     */
    private static void insertionSort( Comparable [ ] a, int low, int high )
    {
        for( int p = low + 1; p <= high; p++ )
        {
            Comparable tmp = a[ p ];
            int j;

            for( j = p; j > low && tmp.lessThan( a[ j - 1 ] ); j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    /**
     * Quick selection algorithm.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param k the desired rank (1 is minimum) in the entire array.
     */     
    public static void quickSelect( Comparable [ ] a, int k )
    {
        quickSelect( a, 0, a.length - 1, k );
    }

    /**
     * Internal selection method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * Places the kth smallest item in a[k-1].
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     * @param k the desired rank (1 is minimum) in the entire array.
     */
    private static void quickSelect( Comparable [ ] a, int low, int high, int k )
    {
        if( low + CUTOFF > high )
            insertionSort( a, low, high );
        else
        {
                // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if( a[ middle ].lessThan( a[ low ] ) )
                swapReferences( a, low, middle );
            if( a[ high ].lessThan( a[ low ] ) )
                swapReferences( a, low, high );
            if( a[ high ].lessThan( a[ middle ] ) )
                swapReferences( a, middle, high );

                // Place pivot at position high - 1
            swapReferences( a, middle, high - 1 );
            Comparable pivot = a[ high - 1 ];

                // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; )
            {
                while( a[ ++i ].lessThan( pivot ) )
                    ;
                while( pivot.lessThan( a[ --j ] ) )
                    ;
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

                // Restore pivot
            swapReferences( a, i, high - 1 );

                // Recurse; only this part changes
            if( k <= i )
                quickSelect( a, low, i - 1, k );
            else if( k > i + 1 )
                quickSelect( a, i + 1, high, k );
        }
    }
}
