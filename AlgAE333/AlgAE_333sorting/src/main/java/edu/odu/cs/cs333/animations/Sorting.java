package edu.odu.cs.cs333.animations;//!

import edu.odu.cs.zeil.AlgAE.ActivationRecord;//!
import edu.odu.cs.zeil.AlgAE.Animation;//!
import edu.odu.cs.zeil.AlgAE.Utilities.Index;//!

public class Sorting {//!


//
//  Based on Malik, "C++ Programming [From Problem Analysis to Program Design]"
//      chapter 10
//

public static//!
	void bubbleSort(int list[], int length)
	{
    ActivationRecord arec = Animation.activate(Sorting.class);//!
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
    ActivationRecord arec = Animation.activate(Sorting.class);//!
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
	    ActivationRecord arec = Animation.activate(Sorting.class);//!
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
	
        
        
}//!
