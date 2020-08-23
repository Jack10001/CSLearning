#include<cstring>
#include"dma.h"
using std::cin;
using std::cout;
using std::endl;
using std::strcpy;
// class BaseDMA
BaseDMA::BaseDMA(const BaseDMA & b)
{
	int len = std::strlen(b.label);
	label = new char[len + 1];
	strcpy(label, b.label);
	rating = b.rating;
}
BaseDMA::BaseDMA(const char * l, int r )
{
	int len = strlen(l);
	label = new char[len + 1];
	strcpy(label, l);
	rating = r;
}
BaseDMA:: ~BaseDMA()
{
	delete[] label;
}
BaseDMA & BaseDMA::operator=(const BaseDMA & b)
{
	if (this == &b)
		return *this;
	delete[] label;
	label = new char[std::strlen(b.label) + 1];
	strcpy(label, b.label);
	rating = b.rating;
	return *this;
}
ostream & operator<<(ostream & os, const BaseDMA & b)
{
	os << "label : " << b.label << " ,rating : " << b.rating<<endl;
	return os;
}

// LackDMA methods
LackDMA::LackDMA(const char *c, const char *l , int r) 
	    :BaseDMA(l, r)
{
	strncpy(color, c, 39);
	color[39] = '\0';
}
LackDMA::LackDMA(const char *c, const BaseDMA & b)
	:BaseDMA(b)
{
	strncpy(color, c, 39);
	color[39] = '\0';
}
ostream & operator<<(ostream & os, const LackDMA & l)
{
	os << (BaseDMA &)l << endl;//强制类型转换
	os << "color : " << l.color << endl;
	return os;
}
//HasDMA methods
HasDMA::HasDMA(const char *s, const char *l, int r):BaseDMA(l,r)
{
	style = new char[strlen(s) + 1];
	strcpy(style,s);
}
HasDMA::HasDMA(const char *s, const BaseDMA &b) : BaseDMA(b)
{
	style = new char[strlen(s) + 1];
	strcpy(style, s);
}
HasDMA::HasDMA(const HasDMA & h):BaseDMA(h)
{
	style = new char[strlen(h.style) + 1];
	strcpy(style, h.style);
}
HasDMA::~HasDMA()
{
	delete [] style;
}
HasDMA & HasDMA::operator =(const HasDMA & h)
{
	if (this == &h)
		return *this;
	delete[] style;
	BaseDMA::operator=(h);
	style = new char[strlen(h.style) + 1];
	strcpy(style, h.style);
	return *this;
}
ostream &operator<<(ostream &os, const HasDMA &h)
{
	os << (BaseDMA&)h << endl;
	os << " style :  " << h.style << endl;
	return os;
}