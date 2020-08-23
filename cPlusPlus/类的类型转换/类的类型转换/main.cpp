#include<iostream>
#include"stonewt.h"
int main()
{
	using namespace std;
	Stonewt poppins(9, 2.8);
	double pw = poppins;
	cout << "convert to double=> "<<pw;
	cout << endl;
	cout << "convert to int=> " << int(poppins) << endl << endl<<endl;
	poppins.show_lbs();
	cout << endl;
	poppins.show_stn();
	cout << endl << endl << endl;
	cout << "/*------------------------------------------------------------------------------*/";
	Stonewt a(9, 12.8);
	cout << endl;
	a.show_lbs();
	cout << endl;
	a.show_stn();
	cout << endl;
	Stonewt b(12.8);
	b.show_lbs();
	cout << endl;
	b.show_stn();
	cout << endl;
	system("pause");

}