#include <cassert>
#include <cstdlib>
#include <iostream>
#include <string>

#include "sllistUtils.h"

using namespace std;

typedef LListNode<string>* NodePtr;

double expression (NodePtr& input);
double product (NodePtr& input);
double term (NodePtr& input);


double expression (NodePtr& input)
{
  double sum = product(input);
  while (input != 0 && (input->data == "+" || input->data == "-"))
    {
      string op = input->data;
      input = input->next;
      assert (input != 0);
      double value = product(input);
      if (op == "+")
	sum += value;
      else
	sum -= value;
    }
  return sum;
}


double product (NodePtr& input)
{
  double result = term(input);
  while (input != 0 && (input->data == "*" || input->data == "/"))
    {
      string op = input->data;
      input = input->next;
      assert (input != 0);
      double value = term(input);
      if (op == "*")
	result *= value;
      else
	result /= value;
    }
  return result;
}


double term (NodePtr& input)
{
  if (input->data == "(")
    {
      input = input->next;
      assert (input != 0);
      double result = expression(input);
      assert (input->data == ")");
      input = input->next;
      return result;
    }
  else
    {
      double result = atof(input->data.c_str());
      input = input->next;
      return result;
    }
}




double evaluate (LListHeader<string>& tokens)
{
  LListNode<string>* input = tokens.first;
  return (expression(input));
}



int main(int argc, char** argv)
{
  LListHeader<string> tokens;
  string token;
  while (cin >> token)
    tokens.addToEnd (token);
  
  cout << evaluate (tokens) << endl;
  
  return 0;
}
