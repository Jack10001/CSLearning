#include<string>
#include<iostream>
#include"accabc.h"

using std::cout;
using std::ios_base;
using std::endl;
using std::string;

// base class AccAbc
AccAbc::Formatting AccAbc::SetFormat() const
{
	Formatting f;
	f.flag = cout.setf(ios_base::fixed,ios_base::floatfield);
	f.pr = cout.precision(2);
	return f;
}
void AccAbc::Restore(Formatting & f) const
{
	cout.setf(f.flag, ios_base::floatfield);
	cout.precision(f.pr);
}
AccAbc::AccAbc(const std::string & s , long an , double bal )
{ 
	fullname = s;
	balance = an;
	acctNum = an;
}
void AccAbc::Deposit(double amt)
{
	if (amt < 0)
		cout << "negative deposit, deposit cancelled\n";
	else
		balance += amt;
}
void AccAbc::Withdraw(double amt) //pure virtual function
{
	balance -= amt;
}

//Brass Account class
void Brass::Withdraw(double amt)
{
	if (amt < 0)
		cout << "withdraw must be positive, withdraw cancelled\n";
	else if (amt <= Balance())
		AccAbc::Withdraw(amt);
	else
		cout << "withdraw amount of $ " << amt << " exceeds your balance\n";
}
void Brass::Viewacct() const
{
	Formatting f = SetFormat();
	cout << "Brass client: " << FullName() << endl;
	cout << "Account Number : " << AcctNum() << endl;
	cout << "Balance : $" << Balance() << endl;
	Restore(f);

}
//Brass plus Account class
Brassplus::Brassplus(const std::string& s , long an , double bal , double ml , double r ):AccAbc(s,an,bal)
{
	Maxloan = ml;
	rate = r;
	owesBank = 0.0;
}
Brassplus::Brassplus(const AccAbc &ba, double ml , double r ):AccAbc(ba)
{
	Maxloan = ml;
	rate = r;
	owesBank = 0.0;
}
void Brassplus::Withdraw(double amt)
{
	Formatting f = SetFormat();
	double bal = Balance();
	if (amt < bal)
		AccAbc::Withdraw(amt);
	else if (amt <= bal + Maxloan - owesBank) {
		double advance = amt - bal;
		owesBank += advance * (1.0 + rate);
		cout << "Bank advance: $" << advance << endl;
		cout << "Finance charge : $" << advance * rate << endl;
		Deposit(advance);
		AccAbc::Withdraw(amt);
	}
	else
		cout << "credit limit exceeded\n";
	Restore(f);

}
void Brassplus::Viewacct() const
{
	Formatting f = SetFormat();
	cout << "Brass client: " << FullName() << endl;
	cout << "Account Number : " << AcctNum() << endl;
	cout << "Balance : $" << Balance() << endl;
	cout << "maxinum loan :$ " << Maxloan << endl;
	cout << "Owed to bank :$" << owesBank << endl;
	cout.precision(3);
	cout << "Loan rate : " << 100 * rate << "%\n";
	Restore(f);

}
