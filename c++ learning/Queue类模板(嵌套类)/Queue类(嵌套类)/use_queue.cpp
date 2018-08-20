#include<iostream>
#include"Queue.h"

int main()
{
	using std::cout;
	using std::cin;
	using std::endl;
	Queue<std::string> q(5);
    std::string temp;
	cout << "enter strings:\n";
	while (!q.isfull()) {
		getline(cin,temp);
	//	cin >> temp;
		if (q.enqueue(temp))
			continue;
		else {
			cout << "error!!!\n";
		}

	}
	cout << "\n\nstrings are as follows:\n";
	while (!q.isempty()) {
		
		q.dequeue(temp);
		cout << temp << endl;
	}
	system("pause");
}