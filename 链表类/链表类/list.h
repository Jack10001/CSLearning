#pragma once

typedef struct Node {
	int data;
	Node* next;
	Node* pre;
}Node;

class LinkList {
private:
	Node *head;
	Node *tail;
	int length;
public:
	LinkList();
	//分配内存，构建节点
	Node* makeNode();
	//添加节点到链表尾
	bool push(int data);
	//弹出链表最后一个节点，并返回值
	int pop();
	//通过index来查找链表中的元素
	int objectAt(int index);
	//插入元素到指定位置的前方
	bool insert(int index, int data);
	//打印链表的所有元素
	void display();
};


