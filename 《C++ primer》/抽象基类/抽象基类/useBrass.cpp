#include<iostream>
#include<string>
#include"accabc.h"
const int CLIENTS = 4;
int main()
{
	using std::cin;
	using std::cout;
	using std::endl;

	AccAbc *p_clients[CLIENTS];//基类的指针或引用可以指向派生类
	std::string temp;
	long tempnum;
	double tempbal;
	char kind;
	for (int i = 0; i < CLIENTS; i++) {
		cout << "enter client's name\n";
		getline(cin, temp);
		
		cout << "enter account number\n";
		cin >> tempnum;
		cout << "enter opening balance\n";
		cin >> tempbal;
		cout << "enter 1 for brass account,enter 2 for brassplus account\n";
		while (cin >> kind && (kind != '1' && kind != '2'))
			cout << "enter 1 or 2\n";
		if (kind == '1')
			p_clients[i] = new Brass(temp, tempnum, tempbal);
		else {
			double tmax, trate;
			cout << "enter the overdraft limit: $";
			cin >> tmax;
			cout << "enter the interest rate\n";
			cin >> trate;
			p_clients[i] = new Brassplus(temp, tempnum, tempbal, tmax, trate);
		}
		while (cin.get() != '\n')
			continue;
	}
	cout << endl;
	for (int i = 0; i < CLIENTS; i++) {
		p_clients[i]->Viewacct();
		cout << endl;
	}
	for (int i = 0; i < CLIENTS; i++) {
		delete p_clients[i];
	}
	system("pause");
}