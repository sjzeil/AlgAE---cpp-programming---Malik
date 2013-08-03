package edu.odu.cs.cs333.animations;//!

import java.awt.Color;//!
import java.util.LinkedList;//!
import java.util.List;//!
import java.util.Scanner;//!

import static edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation.activate;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.ActivationRecord;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Component;//!
import edu.odu.cs.AlgAE.Server.MemoryModel.Connection;//!
import edu.odu.cs.AlgAE.Server.Rendering.CanBeRendered;//!
import edu.odu.cs.AlgAE.Server.Rendering.Renderer;//!

//!

public class Calculator {//!

//!#include <cassert>
//!#include <cstdlib>
//!#include <iostream>
//!#include <string>

//!#include "sllistUtils.h"

//!using namespace std;

//!typedef LListNode<string>* NodePtr;
	public class NodePtr implements CanBeRendered<NodePtr>, Renderer<NodePtr> {//!
		String data;//!
		NodePtr next;//!
		@Override//!
		public Renderer<NodePtr> getRenderer() {//!
			return this;//!
		}//!
		@Override//!
		public Color getColor(NodePtr obj) {//!
			return Color.cyan;//!
		}//!
		@Override//!
		public List<Component> getComponents(NodePtr obj) {//!
			List<Component> results = new LinkedList<Component>();//!
			return results;//!
		}//!
		@Override//!
		public List<Connection> getConnections(NodePtr obj) {//!
			LinkedList<Connection> conn = new LinkedList<Connection>();//!
			Connection nxt = new Connection(next, 90, 90);//!
			conn.add(nxt);//!
			return conn;//!
		}//!
		@Override//!
		public int getMaxComponentsPerRow(NodePtr obj) {//!
			return 1;//!
		}//!
		@Override//!
		public String getValue(NodePtr obj) {//!
			return data;//!
		}//!
	}//!
	
	class RootPtr {//!
		NodePtr p;//!
		public RootPtr (NodePtr p) {this.p = p;}//!
	}//!

//!double expression (NodePtr& input);
//!double product (NodePtr& input);
//!double term (NodePtr& input);

double expression (RootPtr input)//!double expression (NodePtr& input)
{
  ActivationRecord arec = activate(getClass());//!
  arec.refParam("input", input.p).breakHere("entered expression()");//!
  double sum = product(input);
  arec.var("sum", sum);//!
  arec.breakHere("sum of 1st product");//!
  while (input.p != null && (input.p.data.equals("+") || input.p.data.equals("-")))//!  while (input != 0 && (input->data == "+" || input->data == "-"))
    {
	  arec.pushScope();//!
      String op = input.p.data;//!      string op = input->data;
      arec.var("op", op).breakHere("save the operator");//!
      input.p = input.p.next;//!      input = input->next;
      arec.breakHere("advanced the input");//!
      assert (input != null);//!      assert (input != 0);
      double value = product(input);
      arec.var("value",value).breakHere("evaluated another product");//!
      if (op.equals("+"))//!      if (op == "+")
	    sum += value;
      else
	    sum -= value;
      arec.var("sum", sum);//!
      arec.breakHere("modified the sum");//!
      arec.popScope();//!
    }
  arec.breakHere("return this sum");//!
  return sum;
}


double product (RootPtr input)//!double product (NodePtr& input)
{
  ActivationRecord arec = activate(getClass());//!
  arec.refParam("input", input.p).breakHere("entered product()");//!
  double result = term(input);
  arec.var("result", result).breakHere("product of 1st term");//!
  while (input.p != null && (input.p.data.equals("*") || input.p.data.equals("/")))//!  while (input != 0 && (input->data == "*" || input->data == "/"))
    {
	  arec.pushScope();//!
      String op = input.p.data;//!      string op = input->data;
      arec.var("op", op).breakHere("save the operator");//!
      input.p = input.p.next;//!      input = input->next;
      arec.breakHere("advanced the input");//!
      assert (input != null);//!      assert (input != 0);
      double value = term(input);
      arec.var("value",value).breakHere("evaluated another term");//!
      if (op.equals("*"))//!      if (op == "*")
	    result *= value;
      else
	    result /= value;
      arec.var("result", result).breakHere("modified the result");//!
      arec.popScope();//!
    }
  arec.breakHere("return this product");//!
  return result;
}


double term (RootPtr input)//!double term (NodePtr& input)
{
  ActivationRecord arec = activate(getClass());//!
  arec.refParam("input", input.p).breakHere("entered term()");//!
  if (input.p.data.equals("("))//!  if (input->data == "(")
    {
      input.p = input.p.next;//!      input = input->next;
      arec.breakHere("advanced the input");//!
      assert (input != null);//!      assert (input != 0);
      double result = expression(input);
      arec.var("result", result).breakHere("evaluated parenthesized expression");//!
      assert (input.p.data.equals(")"));//!      assert (input->data == ")");
      input.p = input.p.next;//!      input = input->next;
      arec.breakHere("advanced the input and ready to return");//!
      return result;
    }
  else
    {
      double result = Double.parseDouble(input.p.data);//!      double result = atof(input->data.c_str());
      arec.var("result", result).breakHere("converted string to double");//!
      input.p = input.p.next;//!      input = input->next;
      arec.breakHere("advanced the input and ready to return");//!
      return result;
    }
}




double evaluate (NodePtr tokens)//!double evaluate (LListHeader<string>& tokens)
{
  ActivationRecord arec = activate(getClass());//!
  NodePtr input = tokens;//!  LListNode<string>* input = tokens.first;
  arec.refParam("tokens", tokens).breakHere("start by calling expression");//!
  return (expression(new RootPtr(input)));//!  return (expression(tokens));
}



void calculator(String line)
{
	ActivationRecord arec = activate(getClass());//!
//!  LListHeader<string> tokens;
//!  string token;
//!  while (cin >> token)
//!    tokens.addToEnd (token);
	NodePtr first = null;
	NodePtr last = null;
	Scanner scan = new Scanner(line);
	while (scan.hasNext()) {
		String token = scan.next();
		NodePtr np = new NodePtr();
		np.data = token;
		np.next = null;
		if (last == null)
		{
			last = first = np;
		} else {
			last.next = np;
			last = np;
		}
	}
//!  
	arec.refVar("tokens", first).breakHere("starting calculator");//!
	double result = 0.0;
	try {
	   result = evaluate (first);//!
	} catch (Exception e) {}
	arec.out().println ("" + result);//!
//!  cout << evaluate (tokens) << endl;
//!  
}
	
			
}
