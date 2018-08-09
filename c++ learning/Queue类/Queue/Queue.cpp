#include<iostream>
#include"Queue.h"
#include<cstdlib>
#include<ctime>
 void Customer::set(long when)
{
	srand(time(0));
	arrival = when;
	processingtime = rand() % 3 + 1;
}


 Queue::Queue(int qs ):qsize(qs)
 {
	 front = rear = nullptr;
	 items = 0;
 }

 Queue::~Queue()
 {
	 struct node *temp;
	 while (front != NULL) {
		 temp = front;
		 front = front->next;
		 delete temp;
		 temp = nullptr;
	 }
 }
 bool Queue::isempty() const
 {
	 return items == 0;
 }
 bool Queue::isfull() const
 {
	 return items == qsize;
 }
 int Queue::queuecount() const
 {
	 return items;
 }
 bool Queue::enqueue(const Item &item_)
 {
	 if (isfull())
		 return false;
	 struct node *temp=new struct node;
	 temp->item_ = item_;
	 temp->next = NULL;
	 items++;
	 if (front == NULL)
		 front = temp;
	 else {
		 rear->next = temp;
		 rear = temp;
	 }
	 return true;
 }
 bool Queue::dequeue(Item & item_)
 {
	 if (front == NULL)
		 return false;
	 item_ = front->item_;
	 items--;
	 struct node *temp = front;
	 front = front->next;
	 delete temp;
	 if (items == 0)
		 rear = NULL;
	 return true;
 }
