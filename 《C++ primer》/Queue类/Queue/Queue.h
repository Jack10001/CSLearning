#pragma once
#ifndef QUEUE_H_
#define QUEUE_H_
#include<iostream>

class Customer
{
private:
	int  processingtime;
	long arrival;
public:
	Customer() { arrival = processingtime = 0; }
	~Customer(){}
	void set(long when);
	long when() const { return arrival; }
	int ptime() const { return processingtime; }
};

typedef Customer Item;

class Queue
{
private:
	enum {QSIZE=10};
	struct node {
		Item item_;
		struct node *next;
	};
	struct node *front;
	struct node *rear;
	int items;
	const int qsize;
	/*α˽�з��������ƹ��캯������ֵ�����*/
	Queue(const Queue & q):qsize(0) {}
	Queue & operator = (const Queue & q) { return *this; }
public:
	Queue(int qs = QSIZE);
	~Queue();
	bool isempty() const;
	bool isfull() const;
	int queuecount() const;
	bool enqueue(const Item &item_);
	bool dequeue(Item & item_);

};
#endif
