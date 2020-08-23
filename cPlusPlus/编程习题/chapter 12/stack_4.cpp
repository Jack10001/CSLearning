#include<iostream>
#include<string>
#include<cstdio>
#include<ctype.h>

using namespace std;

typedef unsigned long Item;

class Stack
{
private:
	enum { MAX=10 };
	//static const MAX = 10;
	Item *pitem;
	int top;
public:
	Stack(int n=MAX);
    Stack(const Stack & s);
	~Stack();
    //重载赋值运算符
    Stack & operator=(const Stack &s);
	bool isfull() const;
	bool isempty() const;
	bool push(const Item& item_);
	bool pop(Item &item_);
};


Stack::Stack(int ns)
{
	pitem=new Item [MAX];
	pitem[0]=0;
	top = 0;
}
Stack::~Stack()
{
	delete [] pitem;
	std::cout<<"\nobject has been deleted!\n";
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
		 //item_=item[--top];
         item_=pitem[--top];
		 return true;
	}
	else
		return false;
}
bool Stack::push(const Item& item_)
{
	if (top < MAX) {
		//item[top++] = item_;
		//item[top] = item_;
        pitem[top]=item_;
		top++;
		return true;
	}
	else
		return false;

}

Stack::Stack(const Stack &s)
{
    pitem=new Item [s.top+1];
    for(int i=0;i<s.top;i++)
	  pitem[i]=s.pitem[i];
    top=s.top;
}

Stack & Stack::operator =(const Stack & s)
{
    if(this==&s)
      return *this;
    delete [] pitem;
    top=s.top;
    for(int i=0;i<s.top;i++)
	  pitem[i]=s.pitem[i];
    return *this;
}


int main()
{
	Stack ct;
	unsigned long po;
	char ch;
	cout << "Please enter A to add a purchase order,\n"
		<< "P to process a PO or Q to quit\n";
	while (cin >> ch && toupper(ch)!='Q') {
		while (cin.get()!= '\n')
			continue;
		if (!isalpha(ch)) {
			cout << "\a" << endl;
			continue;
		}
		switch (ch)
		{
		case 'a':
		case 'A':
			cout << "enter a PO number to add" << endl;
			cin >> po;
			if (ct.isfull())
				cout << "stack is already full";
			else
				ct.push(po);
			break;
		case 'p':
		case'P':
			if (ct.isempty())
				cout << "stack is empty" << endl;
			else {
				ct.pop(po);
				cout << "po #" << po << " popped\n";
			}
			break;


		}
		cout << "Please enter A to add a purchase order,\n"
			<< "P to process a PO or Q to quit\n";
	}


	Stack a=ct;
	while(!a.isempty())
	{
    a.pop(po);
	cout << "po #" << po << " popped\n";
	}
	cout << endl;
	cout << "BYE" << endl;
	system("pause");
}