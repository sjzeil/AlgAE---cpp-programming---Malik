package edu.odu.cs.cs333.animations;//!

import edu.odu.cs.zeil.AlgAE.ActivationRecord;//!
import edu.odu.cs.zeil.AlgAE.Animation;//!
import edu.odu.cs.zeil.AlgAE.Utilities.DiscreteInteger;//!
import edu.odu.cs.zeil.AlgAE.Utilities.Index;//!

public class ArrayOperations {//!


//!# include <iostream>
//!# include <string>
	
//!using namespace std;

	
	
//!void addToEnd (std::string* array, int& size, std::string value)
public void addToEnd (String[] array, DiscreteInteger size, String value)//!
{
   ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
   arec.refParam("array", array).refParam("size", size).param("value", value).breakHere("starting addToEnd");//!
//!   array[size] = value;
   if (size.get() >= array.length) {//!
	   arec.breakHere("array is already full - program may crash");//!
	   return;//!
   }//!
   array[size.get()] = value;//!
   arec.breakHere("element added");//!
//!   ++size;
   size.set(size.get() + 1);//!
   arec.breakHere("size increased");//!
}

//!void addElement (std::string* array, int& size,
//!	    int index, std::string value)
public void addElement (String[] array, DiscreteInteger size,//!
	    Index index, String value)//!
{
   ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
   arec.refParam("array", array).refParam("size", size).param("index", index).param("value", value).breakHere("starting addElement");//!
  // Make room for the insertion
//!  int toBeMoved = size - 1;
  Index toBeMoved = new Index(size.get() - 1, array);//!
  arec.var("toBeMoved", toBeMoved).breakHere("set toBeMoved");//!
//!  while (toBeMoved >= index) {
  while (toBeMoved.get() >= index.get()) { //!
	arec.breakHere("in loop: ready to move an element up");//!
//!    array[toBeMoved+1] = array[toBeMoved];
	   if (toBeMoved.get()+1 >= array.length) {//!
		   arec.breakHere("array is already full - program may crash");//!
		   return;//!
	   }//!
    array[toBeMoved.get()+1] = array[toBeMoved.get()];//!
	arec.breakHere("in loop: Moved the element");//!
//!    --toBeMoved;
    toBeMoved.set (toBeMoved.get() - 1);//!
	arec.breakHere("in loop: decremented");//!
  }
  // Insert the new value
  arec.breakHere("Done moving elements");//!
//!  array[index] = value;
  array[index.get()] = value;//!
  arec.breakHere("Inserted new value");//!
//!  ++size;
  size.set(size.get() + 1);//!
}


//!int addInOrder1 (std::string* array, int& size,
//!		    std::string value)
public Index addInOrder1 (String[] array, DiscreteInteger size, String value)//!
{
   ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
   arec.refParam("array", array).refParam("size", size).param("value", value).breakHere("starting addInOrder");//!
  // Find where to insert
//!  int pos = 0;
  Index pos = new Index(0, array);//!
  arec.var("pos", pos).breakHere("pos starts at 0");//!
//!  while (pos < size && value > array[pos])
  while (pos.get() < size.get() && value.compareTo(array[pos.get()]) > 0) {//!
	  arec.breakHere("Keep searching...");//!
//!    ++pos;
    pos.set(pos.get() + 1);//!
  }//!
  arec.breakHere("Found where we want to insert");//!
  addElement (array, size, pos, value);
  arec.breakHere("Done");//!
  return pos;
}

	
//!int addInOrder2 ((std::string* array, int& size,
//!		    std::string value)
public Index addInOrder2 (String[] array, DiscreteInteger size, String value)//!
{
   ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
   arec.refParam("array", array).refParam("size", size).param("value", value).breakHere("starting addInOrder");//!
  // Make room for the insertion
//!  int toBeMoved = size - 1;
  Index toBeMoved = new Index(size.get() - 1, array);//!
  arec.var("toBeMoved", toBeMoved).breakHere("start at high end of the data");//!
//!  while (toBeMoved >= 0 && value > array[toBeMoved]) {
  while (toBeMoved.get() >= 0 && value.compareTo(array[toBeMoved.get()]) < 0) {//!
		arec.breakHere("in loop: ready to move an element up");//!
//!    array[toBeMoved+1] = array[toBeMoved];
	   if (toBeMoved.get()+1 >= array.length) {//!
		   arec.breakHere("array is already full - program may crash");//!
		   return toBeMoved;//!
	   }//!
    array[toBeMoved.get()+1] = array[toBeMoved.get()];//!
	arec.breakHere("in loop: Moved the element");//!
//!    --toBeMoved;
    toBeMoved.set (toBeMoved.get() - 1);//!
	arec.breakHere("in loop: decremented");//!
  }
  // Insert the new value
  arec.breakHere("exited loop: insert the new value");//!
//!  array[toBeMoved+1] = value;
  array[toBeMoved.get()+1] = value;//!
  arec.breakHere("Inserted new value");//!
//!  ++size;
  size.set(size.get() + 1);//!
  arec.breakHere("Incremented size");//!
//!  return toBeMoved+1;
  return new Index(toBeMoved.get()+1, array);
}
	

//!int seqSearch(const std::string list[], int listLength, std::string searchItem)
public Index seqSearch(String list[], int listLength, String searchItem)//!
{
	ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
	arec.refParam("list", list).param("listLength", listLength).param("searchItem", searchItem).breakHere("starting seqSearch");//!
//!    int loc;
    Index loc = new Index(-1, list);//!

//!    for (loc = 0; loc < listLength; loc++)
    for (loc.set(0); loc.get() < listLength; loc.set(loc.get()+1)) {//!
    	arec.var("loc", loc).breakHere("in loop: see if we have found it");//!
//!        if (list[loc] == searchItem)
        if (list[loc.get()].equals(searchItem)) { //!
        	arec.breakHere("Found it! Return " + loc.get());//!
            return loc;
        }//!
    }//!
	arec.breakHere("Couldn't find it. Return -1");//!
//!    return -1;
    return new Index(-1, list);//!
}


//!int seqOrderedSearch(const std::string list[], int listLength, std::string searchItem)
public Index seqOrderedSearch(String list[], int listLength, String searchItem)//!
{
	ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
	arec.refParam("list", list).param("listLength", listLength).param("searchItem", searchItem).breakHere("starting seqOrderedSearch");//!
//!    int loc = 0;
    Index loc = new Index(0, list);//!

	arec.var("loc", loc).breakHere("start searching from the beginning");//!
//!    while (loc < listLength && list[loc] < searchItem)
    while (loc.get() < listLength && list[loc.get()].compareTo(searchItem) < 0)//!
      {
    	arec.breakHere("move forward");//!
//!       ++loc;
       loc.set (loc.get()+1);//!
      }
	arec.breakHere("Out of the loop: did we find it?");//!
//!    if (loc < listLength && list[loc] == searchItem)
    if (loc.get() < listLength && list[loc.get()].equals(searchItem)) { //!
    	arec.breakHere("Found It! Return " + loc.get());//!
       return loc;
    }//!
    else
    {//!
    	arec.breakHere("Could not find it. Return -1");//!
//!       return -1;
       return new Index(-1, list);
    }//!
}

//!void removeElement (std::string* array, int& size, int index)
public void removeElement (String[] array, DiscreteInteger size, Index index)//!
{
   ActivationRecord arec = Animation.activate(ArrayOperations.class);//!
   arec.refParam("array", array).refParam("size", size).param("index", index).breakHere("starting removeElement");//!
   if (index.get() < 0 || index.get() >= array.length) { //!
	   arec.breakHere("index is out of bounds - program may crash");//!
	   return; //!
   } //!
//!   int toBeMoved = index + 1;
   Index toBeMoved = new Index(index.get() + 1, array); //!
   arec.var("toBeMoved",toBeMoved).breakHere("start above index");//!
//!   while (toBeMoved < size) {
   while (toBeMoved.get() < size.get()) {//!
	 arec.breakHere("move an element down");//!
//!     array[toBeMoved-1] = array[toBeMoved];
     array[toBeMoved.get()-1] = array[toBeMoved.get()]; //!
	 arec.breakHere("moved");//!
//!     ++toBeMoved;
     toBeMoved.set(toBeMoved.get()+1);//!
   }
	 arec.breakHere("Done moving elements");//!
//!  --size;
  size.set(size.get()-1);//!
}


        
}//!
