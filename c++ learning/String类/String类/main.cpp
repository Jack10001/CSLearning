#include<iostream>
#include"Sting.h"
#include<ctime>
#include<cstdlib>
/*
c++ 语言可以用const来定义常量，也可以用 #define来定义常量。但是前者比后者有更多的优点：
（1）   const常量有数据类型，而宏常量没有数据类型。编译器可以对前者进行类型安全检查。
       而对后者只进行字符替换，没有类型安全检查，并且在字符替换可能会产生意料不到的错误（边际效应）。
（2）   有些集成化的调试工具可以对const常量进行调试，但是不能对宏常量进行调试。
*/
const int ArSize = 5;
const int Maxlen = 81;
int main()
{
	using namespace std;
	String name;
	cout << "enter you name:\n";
	cin >> name;// >>重载
	cout << name << "  please enter up to " << ArSize << "short sayings \n";
	String sayings[ArSize];
	char temp[Maxlen];
	int i;
	for (i = 0; i < ArSize; i++) {
		cout << i + 1 << ":";
		cin.get(temp, Maxlen);
		while (cin && cin.get() != '\n')
			continue;
		if (!cin && temp[0] != '\n')
			break;
		else
			sayings[i] = temp;//赋值运算符重载
	}
	int total = i;
	if (total > 0) {
		cout << endl<<endl<<"here are your sayings:\n";
		for (int i = 0; i < total; i++) {
			cout << sayings[i]<<endl;

		}
		cout << endl;
		String *shortest = &sayings[0];
		String *first = &sayings[0];
		for (i = 1; i < total; i++) {
			if (sayings[i].length() < shortest->length()) {
				shortest = &sayings[i];
			}
			if (sayings[i] < *first)
				first = &sayings[i];
		}
		cout << "shoterst sayings: " << *shortest << endl;
		cout << "first :" << *first << endl;

		srand(time(0));
		int choice = rand() % total;
		String *favorite = new String(sayings[choice]);
		cout << "my favorite: " << *favorite << endl;
		delete favorite;
	}
	else
		cout << "bye" << endl;
	system("pause");
}