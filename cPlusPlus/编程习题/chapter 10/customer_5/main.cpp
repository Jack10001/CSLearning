#include"stack.h"
#include<iostream>
#include<string>
#include<cstdio>
#include<ctype.h>
using namespace std;

int main()
{
	Stack ct;
	Item po;
	char ch;
	double total_payment = 0.0;
	cout << "Please enter A to add a purchase order,"
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
			//cout << "enter a PO number to add" << endl;
			cout << "enter customer's name:\n";
			//cin >> po;
			cin.getline(po.fullname, 35);
			cout << "enter customer's payment:\n";
			cin >> po.payment;
			if (ct.isfull())
				cout << "stack is already full";
			else
			{
				total_payment = total_payment + po.payment;
				ct.push(po);
			}
			break;
		case 'p':
		case'P':
			if (ct.isempty())
				cout << "stack is empty" << endl;
			else {
				ct.pop(po);
				cout << "po #" << po.fullname << " popped\n";
			}
			break;


		}
		cout << "Please enter A to add a purchase order,"
			<< "P to process a PO or Q to quit\n";
	}
	cout << endl;
	cout << "total payment : " <<total_payment<< endl;
	system("pause");
}