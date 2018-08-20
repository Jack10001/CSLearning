#pragma once
#ifndef QUEUE_H_
#define QUEUE_H_
#include<iostream>
#include<string>
#include<ctime>
using namespace std;
/*
class Customer
{
private:
	int  processingtime;
	long arrival;
public:
	Customer() { arrival = processingtime = 0; }
	~Customer() {}
	void set(long when);
	long when() const { return arrival; }
	int ptime() const { return processingtime; }
};
*/
//typedef Customer Item;
template<class Type>
class Queue
{
private:
	enum { QSIZE = 10 };

    class Node {
	public:
		Type item_;
		Node *next;
		Node(const Type & N) :item_(N), next(nullptr) {}
	};

	Node *front;
	Node *rear;
	int items;
	const int qsize;
	/*伪私有方法：复制构造函数，赋值运算符*/
	Queue(const Queue & q) :qsize(0) {}
	Queue & operator = (const Queue & q) { return *this; }
public:
	Queue(int qs = QSIZE);
	~Queue();
	bool isempty() const;
	bool isfull() const;
	int queuecount() const;
	bool enqueue(const Type &item_);
	bool dequeue(Type & item_);

};
/*
void Customer::set(long when)
{
	srand(time(0));
	arrival = when;
	processingtime = rand() % 3 + 1;
}
*/
template<class Type>
Queue<Type>::Queue(int qs) :qsize(qs)
{
	front = rear = nullptr;
	items = 0;
}

template<class Type>
Queue<Type>::~Queue()
{
	Node *temp;
	while (front != nullptr) {
		temp = front;
		front = front->next;
		delete temp;
		temp = nullptr;
	}
}
template<class Type>
bool Queue<Type>::isempty() const
{
	return items == 0;
}

template<class Type>
bool Queue<Type>::isfull() const
{
	return items == qsize;
}

template<class Type>
int Queue<Type>::queuecount() const
{
	return items;
}

template<class Type>
bool Queue<Type>::enqueue(const Type &item_)
{
	if (isfull())
		return false;
	Node *temp = new Node(item_);
	items++;
	if (front == nullptr)
		front = temp;
	else 
		rear->next = temp;
	rear = temp;
	return true;
}


template<class Type>
bool Queue<Type>::dequeue(Type & item_)
{
	if (front == nullptr)
		return false;
	item_ = front->item_;
	items--;
	Node *temp = front;
	front = front->next;
	delete temp;
	if (items == 0)
		rear = nullptr;
	return true;
}

#endif
