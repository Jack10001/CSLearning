#include"stack.h"
#include<iostream>
#include<string>
#include<cstdio>
using namespace std;

Stack::Stack()
{
	top = 0;
}

bool Stack::isfull() const
{
	return top == MAX;

}
bool Stack::isempty() const 
{
	return top == 0;
}

bool Stack::pop(Item &item_)
{
	if (top > 0) {
		 item_=item[--top];
		 return true;
	}
	else
		return false;
}
bool Stack::push(const Item& item_)
{
	if (top < MAX) {
		//item[top++] = item_;
		item[top] = item_;
		top++;
		return true;
	}
	else
		return false;

}


