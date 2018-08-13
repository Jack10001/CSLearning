#pragma once
#ifndef DMA_H_
#define DMA_H_
#include<iostream>
using std::ostream;
class BaseDMA
{
private:
	char * label;
	int rating;
public:
	BaseDMA(const BaseDMA & b);
	BaseDMA(const char * l = "null", int r = 0);
	virtual ~BaseDMA();
	BaseDMA & operator=(const BaseDMA & b);
	friend ostream & operator<<(ostream & os, const BaseDMA & b);

};

class LackDMA :public BaseDMA
{
private:
	enum {COL_LEN=40};
	char color[COL_LEN];
public:
	LackDMA(const char *c = "blank", const char *l = "null", int r = 0);
	LackDMA(const char *c, const BaseDMA & b);
	friend ostream & operator<<(ostream & os, const LackDMA & l);
};

class HasDMA :public BaseDMA
{
private:
	char *style;
public:
	HasDMA(const char *s = "none", const char *l = "null", int r = 0);
	HasDMA(const char *s, const BaseDMA &b);
	HasDMA(const HasDMA & h);
	~HasDMA();
	HasDMA & operator =(const HasDMA & h);
	friend ostream &operator<<(ostream &os, const HasDMA &h);
};
#endif