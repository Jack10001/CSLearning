#include <iostream>
#include <ctime>
#include <cstdlib>
#include <string>
#include <cstring>
#include <cctype>
using namespace std;
const int ArSize = 5;
const int Maxlen = 81;

class String
{
  private:
	int len;
	static int num_strings; //all objects share one static member
	char *str;
	const static int CINLIM = 80;

  public:
	String(const String &str_);
	String(const char *str_);
	String();
	~String();
	int length() const { return len; }

	String &operator=(const String &t);
	String &operator=(const char *t);
	char &operator[](int i);
	const char &operator[](int i) const;

	friend bool operator>(const String &t1, const String &t2);
	friend bool operator<(const String &t1, const String &t2);
	friend bool operator==(const String &t1, const String &t2);
	friend ostream &operator<<(ostream &os, const String &t);
	friend istream &operator>>(istream &is, String &t);

	static int Howmany();

	//add some functions
	friend String operator+(String &t1, const String &t2); //strcat
	friend String operator+(String &t,const char *s);
	friend String operator+(const char *s,String&t);
	void Stringlow();							   //cctype
	void Stringup();
	int count_char(const char ch);
};

int String::num_strings = 0;
int String::Howmany()
{
	return num_strings;
}

String::String(const String &str_)
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
	str = NULL;
	num_strings++;
}
String::~String()
{
	delete[] str;
	num_strings--;
}

String &String::operator=(const String &t)
/*????????*/
{
	if (&t == this)
		return *this;
	delete[] str;
	len = t.len;
	str = new char[len + 1];
	strcpy(str, t.str);
	return *this;
}
String &String::operator=(const char *t)
{
	delete[] str;
	len = strlen(t);
	str = new char[len + 1];
	strcpy(str, t);
	return *this;
}
char &String::operator[](int i)
{
	return str[i];
}
const char &String::operator[](int i) const
{
	return str[i];
}

bool operator>(const String &t1, const String &t2)
{
	return strcmp(t1.str, t2.str) > 0;
}
bool operator<(const String &t1, const String &t2)
{
	return t2 > t1;
}
bool operator==(const String &t1, const String &t2)
{
	return strcmp(t1.str, t2.str) == 0;
}
ostream &operator<<(ostream &os, const String &t)
{
	os << t.str;
	return os;
}
istream &operator>>(istream &is, String &t)
{
	char temp[String::CINLIM];
	is.get(temp, String::CINLIM);
	if (is)
		t = temp;
	while (is && is.get() != '\n')
		continue;
	return is;
}

String operator+(String &t1, const String &t2) //strcat
{
	strcat(t1.str, t2.str);
	t1.len = strlen(t1.str);
	return t1;
}
String operator+(String &t,const char *s)
{
	strcat(t.str,s);
	t.len=strlen(t.str);
	return t;
	
}
	
String operator+(const char *s,String&t)
{
	return operator+(t,s);
}
void String::Stringlow() //cctype
{
	for(int i=0;str[i];i++) 
	  str[i]=tolower(str[i]);
}
void String::Stringup()
{
	for(int i=0;str[i];i++)
	  str[i]=toupper(str[i]);
}
int String::count_char(const char ch)
{
	int count = 0;
	for (int i = 0; str[i]; i++)
	{
		if (str[i] == ch)
			count++;
	}
	return count;
}
int main()
{
	String s1(" and I am a C++ student.");
	String s2 = "Please enter your name: ";
	String s3;
	cout << s2;
	cin >> s3;
//	s2 = s3;
    s2 = "My name is " +s3;
	cout << s2 << ".\n";
	s2 = s2 + s1;
	s2.Stringup();
	cout << "The string\n"
		 << s2 << "\ncontains " << s2.count_char('A') << " 'A' characters in it.\n";
	s1 = "red";
	String rgb[3] = {String(s1), String("grean"), String("blue")};
	cout << "Enter the name of a primary color for mixing light: ";
	String ans;
	bool success = false;
	while (cin >> ans)
	{
		ans.Stringlow();
		for (int i = 0; i < 3; i++)
		{
			if (ans == rgb[i])
			{
				cout << "That's right!\n";
				success = true;
				break;
			}
		}
		if (success)
		{
			break;
		}
		else
		{
			cout << "Try again!\n";
		}
	}
	cout << "Bye\n";
	return 0;
}
