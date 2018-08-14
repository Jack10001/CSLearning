#pragma once
#ifndef ACCBC_H_H
#define ACCABC_H_H

#include<iostream>
#include<cstring>

class AccAbc
{
private:
	std::string fullname;
	double balance;
	long acctNum;
protected:
	struct Formatting {
		std::ios_base::fmtflags flag;
		std::streamsize  pr;
	};
	const std::string & FullName() const { return fullname; }
	long AcctNum() const { return acctNum; }
	Formatting SetFormat() const;
	void Restore(Formatting & f) const;
public:
	AccAbc(const std::string & s = "Nullbody", long an = -1, double bal = 0.0);
	void Deposit(double amt);
	virtual void Withdraw(double amt) = 0;//pure virtual function
	double Balance() const { return balance; }
	virtual void Viewacct()const = 0;
	virtual ~AccAbc() {}
};
//Brass Account class
class Brass :public AccAbc
{
public:
	Brass(const std::string& s = "nullbody", long an = -1, double bal = 0.0):AccAbc(s,an,bal){}
	virtual void Withdraw(double amt);
	virtual void Viewacct() const;
	virtual ~Brass() {}

};
//Brass plus Account class
class Brassplus :public AccAbc
{
private:
	double Maxloan;
	double rate;
	double owesBank;
public:
	Brassplus(const std::string& s = "nullbody", long an = -1, double bal = 0.0, double ml = 500, double r = 0.10);
	Brassplus(const AccAbc &ba, double ml = 500, double r = 0.10);
	virtual void Withdraw(double amt);
	virtual void Viewacct() const;
	void ResetMax(double ml) { Maxloan = ml; }
	void ResetRate(double r) { rate = r; }
	void ResetOwes() { owesBank = 0; }
};
#endif