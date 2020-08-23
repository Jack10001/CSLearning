#pragma once
#ifndef EXC_MEAN_H_
#define EXC_MEAN_H_

#include<iostream>
#include<exception>
class Bad_hmean:public std::exception
{
private:
	double v1, v2;
public:
	Bad_hmean(double a=0.0,double b=0.0):v1(a),v2(b){}
	//void mesg();
	const char * what() { return "bad hmean arguement!\n"; }
};
class Bad_gmean:public std::exception
{
public:
	double v1, v2;
	Bad_gmean(double a=0.0,double b=0.0):v1(a),v2(b){}
	//const char* mesg();
	const char * what() { return "bad gmean arguement!\n"; }
};

class Demo
{
private:
	std::string word;
public:
	Demo(std::string s) 
	{
		word = s;
		std::cout <<"demo "<<word << " created!\n";
	}
	~Demo()
	{
		std::cout << "demo " << word << " destoryed!\n";
	}
	void show()
	{
		std::cout << "demo " << word << " lives!\n";
	}
};
/*
inline void Bad_hmean::mesg()
{
	std::cout << "hmean(" << v1 << "," << v2 << ") invalid arguement a=-b\n";
}
inline const char * Bad_gmean::mesg()
{
	return "gmean() arguement should be >=0\n";
}*/
#endif // !EXC_MEAN_H_
