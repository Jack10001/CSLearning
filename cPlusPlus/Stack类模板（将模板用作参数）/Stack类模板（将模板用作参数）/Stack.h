#pragma once
#ifndef STACK_H_
#define STACK_H_
#include<iostream>
#include<string>
template<class Type>
class Stack
{
private:
	enum { MAX = 10 };
	//static const MAX = 10;
	Type* item;
	int stacksize;
	int top;
public:
	explicit Stack(int ss = MAX);
	Stack(const Stack &s);
	Stack & operator=(const Stack & s);
	~Stack() { delete[] item; }
	bool isfull() const;
	bool isempty() const;
	bool push(const Type& item_);
	bool pop(Type &item_);


};

template<class Type>
Stack<Type>::Stack(int ss) :stacksize(ss), top(0)
{
	item = new Type[stacksize];
}

template<class Type>
bool Stack<Type>::isfull() const
{
	return top == stacksize;

}
template<class Type>
bool Stack<Type>::isempty() const
{
	return top == 0;
}

template<class Type>
bool Stack<Type>::pop(Type &item_)
{
	if (top > 0) {
		item_ = item[--top];
		return true;
	}
	else
		return false;
}

template<class Type>
bool Stack<Type>::push(const Type& item_)
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
template<class Type>
Stack<Type> & Stack<Type>::operator =(const Stack &s)
{
	if (this == &s)
		return *this;
	delete[] item;
	stacksize = s.stacksize;
	item = new Type[s.stacksize];
	top = s.top;
	for (int i = 0; i < stacksize; i++)
		item[i] = s.item[i];
}
template<class Type>
Stack<Type>::Stack(const Stack &s)
{
	stacksize = s.stacksize;
	item = new Type[s.stacksize];
	top = s.top;
	for (int i = 0; i < stacksize; i++)
		item[i] = s.item[i];
}
#endif
#pragma once
