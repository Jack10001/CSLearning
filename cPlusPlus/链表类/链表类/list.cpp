#include "list.h"
#include <iostream>
#include <malloc.h>

using namespace std;

LinkList::LinkList() {
	head = makeNode();
	tail = head;
	length = 0;
}

Node * LinkList::makeNode() {
	Node* node = (Node*)malloc(sizeof(Node));
	return node;
}

bool LinkList::push(int data) {
	Node *node = makeNode();
	if (!node) {
		return false;
	}
	node->data = data;
	node->pre = tail;
	tail->next = node;
	tail = node;
	length++;
	return true;
}

int LinkList::pop() {
	int data = 0;
	Node* node = head->next;
	while (node->next) {
		node = node->next;
	}
	data = node->data;
	tail = node->pre;
	tail->next = node->next;
	length--;
	free(node);
	node = NULL;
	return data;
}

int LinkList::objectAt(int index) {
	if (index<1 || index > length) {
		return 0;
	}
	int data = 0;
	Node* q = head;
	for (int i = 0; i < index; i++) {
		q = q->next;
	}
	data = q->data;
	return data;
}

bool LinkList::insert(int index, int data) {
	if (index<1 || index> length) {
		return false;
	}
	Node *p = makeNode();
	p->data = data;
	Node *q = head;
	for (int i = 0; i < index; i++) {
		q = q->next;
	}
	p->pre = q->pre;
	p->next = q;
	q->pre->next = p;
	q->pre = p;
	length++;
	return true;
}

void LinkList::display() {
	Node *n = head->next;
	cout << "data:";
	while (n) {
		cout << n->data << " ";
		n = n->next;
	}
	cout << endl;
}
int main()
{
	LinkList list1;
	list1.makeNode();
	system("pause");
}