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
	static int num_strings;//��̬�����������κζ������ж�����һ����̬����
	char *str;//new �п������캯���͸�ֵ���������Ԫ������
	const static int CINLIM = 80;
public:
	/*���캯�����������캯������ֵ��������Ƚϣ������������,�±������*/
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
