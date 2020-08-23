
#include<iostream>
#include<string>
#include<cstdio>
#include<ctype.h>
#include"Stack.h"
using namespace std;

int main()
{
	Stack<std::string> ct;
	std::string po;
	char ch;
	cout << "Please enter A to add a purchase order,\n"
		<< "P to process a PO or Q to quit\n";
	while (cin >> ch && toupper(ch) != 'Q') {
		while (cin.get() != '\n')
			continue;
		if (!isalpha(ch)) {
			cout << "\a" << endl;
			continue;
		}
		switch (ch)
		{
		case 'a':
		case 'A':
			cout << "enter a PO string to add" << endl;
			cin >> po;
			while (cin.get() != '\n')
				continue;
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
	cout << endl;
	cout << "BYE" << endl;
	system("pause");
}