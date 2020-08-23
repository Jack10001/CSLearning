#include<iostream>
#include"Stack.h"
using namespace std;

template<template<class T> class Things>//将类模板用作参数
class Grap
{
private:
	Things<int> s1;
	Things<double> s2;
public:
	Grap(){}
	bool push(int a, double x) { return s1.push(a) && s2.push(x); }
	bool pop(int &a, double &x) { return s1.pop(a) && s2.pop(x); }
};

int main()
{
	Grap<Stack> nebula;
	int ni;
	double dl;
	cout << "enter int && double\n";
	while (cin >> ni >> dl && ni > 0 && dl > 0) {
		if (!nebula.push(ni, dl))
			break;
	}
	while (nebula.pop(ni, dl))
		cout << ni << " , " << dl << endl;
	cout << endl;
	system("pause");
}