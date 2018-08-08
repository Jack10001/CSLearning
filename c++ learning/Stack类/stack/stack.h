#pragma once
#include<iostream>
#include<string>
typedef unsigned long Item;
class Stack
{
private:
	enum { MAX=10 };
	//static const MAX = 10;
	Item item[MAX];
	int top;
public:
	Stack();
	~Stack() {};
	bool isfull() const;
	bool isempty() const;
	bool push(const Item& item_);
	bool pop(Item &item_);


};