#include<iostream>
#include"Sting.h"
#include<cstring>
using namespace std;
int String::num_strings = 0;
int String::Howmany()
{
	return num_strings;
}

String::String(const String & str_)
/*拷贝构造函数，深拷贝，初始化对象*/
{
	len = str_.len;
	str = new char[len + 1];
	strcpy(str, str_.str);
	num_strings++;

}


String::String(const char *str_)
{
	len = strlen(str_);
	str = new char[len + 1];
	strcpy(str, str_);
	num_strings++;
}
String::String()
/*default consductor*/
{
	len = 4;
	str = new char[1];
	str = nullptr;
	num_strings++;
}
String::~String()
{
	delete[] str;
	num_strings--;
}


String& String::operator=(const String&t)
/*赋值运算符*/
{
	if (&t == this)
		return *this;
	delete[] str;
	len = t.len;
	str = new char[len + 1];
	strcpy(str, t.str);
	return *this;
}
String & String::operator=(const char * t)
{
	delete[] str;
	len = strlen(t);
	str = new char[len + 1];
	strcpy(str, t);
	return *this;
}
char & String::operator[](int i)
{
	return str[i];
}
const char & String::operator[](int i) const
{
	return str[i];
}

bool operator > (const String &t1, const String& t2)
{
	return strcmp(t1.str, t2.str) > 0;
}
bool operator < (const String &t1, const String& t2)
{
	return t2 > t1;
}
bool operator == (const String &t1, const String& t2)
{
	return strcmp(t1.str, t2.str) == 0;
 }
ostream & operator <<(ostream& os, const String &t)
{
	os << t.str;
	return os;
 }
istream & operator >>(istream& is, String & t)
{
	char temp[String::CINLIM];
	is.get(temp, String::CINLIM);
	if (is)
		t = temp;
	while (is&&is.get() != '\n')//为了将本次流中的数据提取完,以保证下面的流提取数据正确
		continue;
	return is;
}