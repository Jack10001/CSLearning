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
	//�����ڴ棬�����ڵ�
	Node* makeNode();
	//��ӽڵ㵽����β
	bool push(int data);
	//�����������һ���ڵ㣬������ֵ
	int pop();
	//ͨ��index�����������е�Ԫ��
	int objectAt(int index);
	//����Ԫ�ص�ָ��λ�õ�ǰ��
	bool insert(int index, int data);
	//��ӡ���������Ԫ��
	void display();
};


