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
	Type item[MAX];
	int top;
public:
	Stack();
	~Stack() {};
	bool isfull() const;
	bool isempty() const;
	bool push(const Type& item_);
	bool pop(Type &item_);


};

template<class Type>
Stack<Type>::Stack()
{
	top = 0;
}

template<class Type>
bool Stack<Type>::isfull() const
{
	return top == MAX;

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
#endif