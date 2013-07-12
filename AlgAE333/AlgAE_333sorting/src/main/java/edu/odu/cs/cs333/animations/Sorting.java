package edu.odu.cs.cs333.animations;//!

import static edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation.activate;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.ActivationRecord;//!
import edu.odu.cs.AlgAE.Server.Utilities.Index;//!


public class Sorting {//!


//
//  Based on Malik, "C++ Programming [From Problem Analysis to Program Design]"
//      chapter 10
//

public static//!
	void bubbleSort(int list[], int length)
	{
    ActivationRecord arec = activate(Sorting.class);//!
    arec.refParam("list", null).param("length", length);//!
    arec.breakHere("starting bubble sort");//!
	    int temp;
	    int iteration;
	    int index;

        arec.pushScope();//!
	    for (iteration = 1; iteration < length; iteration++)
	    {
	        arec.var("iteration", iteration);//!
	        arec.breakHere("start a pass over the array");//!
	        arec.pushScope();//!
	        for (index = 0; index < length - iteration; index++)
	        {//!
		        arec.var("index", new Index(index, list));//!
		        arec.breakHere("compare list[index] to list[index+1]");//!
	            if (list[index] > list[index + 1]) 
	            {
			        arec.breakHere("list[index] and list[index+1] are out of order - swap them");//!
	                temp = list[index];
	                list[index] = list[index + 1];
	                list[index + 1] = temp;
			        arec.breakHere("Swapped");//!
	            }
	        }//!
	        arec.popScope();//!
	        arec.breakHere("completed this pass over the array");//!

	    }
	    arec.popScope();//!
	    arec.breakHere("compeleted bubble sort");//!
	}

	
public static//!
	void selectionSort(int list[], int length)
	{
    ActivationRecord arec = activate(Sorting.class);//!
    arec.refParam("list", null).param("length", length);//!
    arec.breakHere("starting selection sort");//!
	    int index;
	    int smallestIndex = -99;//!	    int smallestIndex;
	    int location;
	    int temp;

	    arec.pushScope();//!
	    for (index = 0; index < length - 1; index++)
	    {
	    	arec.var("index", new Index(index, list)).var("smallestIndex", new Index(smallestIndex, list));//!
	    	arec.breakHere("smallestIndex holds location of smallest remaining value found so far");//!
	            //Step a
	        smallestIndex = index; 
	    	arec.var("smallestIndex", new Index(smallestIndex, list));//!
	    	arec.breakHere("smallestIndex holds location of smallest remaining value found so far");//!

		    arec.pushScope();//!
	        for (location = index + 1; location < length; location++)
	        {//!
		    	arec.var("location", new Index(location, list));//!
		    	arec.breakHere("see if location holds a smaller value");//!

	        	if (list[location] < list[smallestIndex])
	        	{//!
			    	arec.breakHere("Yes, it does.");//!
	                smallestIndex = location;
	    	    	arec.var("smallestIndex", new Index(smallestIndex, list));//!
			    	arec.breakHere("New value for smallestIndex.");//!
	        	}//!
	        }//!
	        arec.popScope();//!
	            //Step b
	    	arec.breakHere("Swap the values in smallestLocation and index");//!
	        temp = list[smallestIndex];
	        list[smallestIndex] = list[index];
	        list[index] = temp;
	    	arec.breakHere("Ready to move to the next index position");//!
	    }
	    arec.popScope();//!
	    arec.breakHere("completed selection sort");//!
	}

	
public static//!
	void insertionSort (int list[], int listLength)
	{
	    ActivationRecord arec = activate(Sorting.class);//!
	    arec.refParam("list", null).param("listLength", listLength);//!
	    arec.breakHere("starting insertion sort");//!
		int firstOutOfOrder, location;
		int temp;
		
		arec.pushScope();//!
		for (firstOutOfOrder = 1; firstOutOfOrder < listLength;
		                          firstOutOfOrder++)
		{//!
			arec.var("firstOutOfOrder", new Index(firstOutOfOrder, list));//!
			arec.breakHere("move list[firstOutOfOrder] into place");//!
	        if (list[firstOutOfOrder] < list[firstOutOfOrder-1])
			{
				temp = list[firstOutOfOrder];
				location = firstOutOfOrder;
				arec.var("temp",temp).var("location", new Index(location, list));//!
				arec.breakHere("temp holds the value we want to insert");//!
				
				do
				{
					arec.breakHere("shift an element up to make room");//!
					list[location] = list[location - 1];
					arec.breakHere("then move to the next lower element");//!
					location--;
					arec.var("location", new Index(location, list));//!
				}
				while (location > 0 && list[location - 1] > temp);
				
				arec.breakHere("Now we know where to insert temp");//!
				list[location] = temp;
			}
			arec.breakHere("Move to the next unordered element");//!
		}//!
        arec.popScope();
		arec.breakHere("Completed insertion sort");//!
	}
	
    public static//!
    int binarySearch(int list[], int listLength, int searchItem)
	{
    	ActivationRecord arec = activate(Sorting.class);//!
	    arec.refParam("list", null).param("listLength", listLength).param("searchItem", searchItem);//!
	    arec.breakHere("starting binary search");//!
		
	    int first = 0;
	    int last = listLength - 1;
	    int mid;

	    boolean found = false;mid = 0;//!	    bool found = false;
	    Index firstIndex = new Index(first, list);//!
	    Index lastIndex = new Index(last, list);//!
	    Index midIndex = new Index(0, list);//!
	    arec.var("first", firstIndex).var("last", lastIndex).var("mid",midIndex).var("found",found);//!
	    arec.breakHere("about to enter loop");//!
	    while (first <= last && !found)
	    {
	        mid = (first + last) / 2;
	        midIndex.set(mid);//!
	        arec.breakHere("computed midpoint");//!
		    
	        if (list[mid] == searchItem)
	        {//!
	        	arec.breakHere("Found it!");//!
	            found = true;
	        }//!
	        else 
	        {arec.breakHere("Are we high or low?");//!
	            if (list[mid] > searchItem)
	            {arec.breakHere("Too high. Look lower.");//!
	                last = mid - 1;
	                lastIndex.set(last);
	            }//!
	            else
	            {arec.breakHere("Too low. Look higher.");//!
	                first = mid + 1;
	                firstIndex.set(first);//!
	            }//!
	            arec.breakHere("Ready to try again."); //!
	        }//!
	    }
	    
	    arec.breakHere("Exited the loop. Did we find it?");//!
	    if (found) 
	    {arec.out().println ("binarySearch returned " + mid);//!
	        return mid;
	    }//!
	    else
	    {arec.out().println ("binarySearch returned -1");//!
	        return -1;
	    }//!
	}

        
        
}//!
