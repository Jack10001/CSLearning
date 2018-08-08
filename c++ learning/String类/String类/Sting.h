#pragma once
#ifndef STRING_H_
#define STRING_H_
#include<iostream>
#include<ostream>
//using namespace std;
using std::ostream;
using std::istream;
class String
{
private:
	int len;
	static int num_strings;//静态变量不属于任何对象，所有对象公用一个静态变量
	char *str;//new 有拷贝构造函数和赋值运算符（友元函数）
	const static int CINLIM = 80;
public:
	/*构造函数，拷贝构造函数，赋值运算符，比较，输入输出重载,下标运算符*/
	String(const String & str_);
	String(const char *str_);
	String();
	~String();
	int length() const { return len; }
    
	String& operator=(const String&t);
	String &operator=(const char *t);
	char &operator[](int i);
	const char &operator[](int i) const;

	friend bool operator > (const String &t1, const String& t2);
	friend bool operator < (const String &t1, const String& t2);
	friend bool operator == (const String &t1, const String& t2);
	friend ostream & operator <<(ostream& os, const String &t);
	friend istream & operator >>(istream& is, String & t);

	static int Howmany();
};
#endif // !1
