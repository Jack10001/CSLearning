#include<iostream>
#include<cmath>
#include<string>
#include"exc_mean.h"

double means(double a, double b);
double hmean(double a, double b);
double gmean(double a, double b);
int main()
{
	using std::cout;
	using std::cin;
	using std::endl;
	double x, y, z;
	{
		Demo d1("found in main()");
		while (cin >> x >> y) {
			try {
				z = means(x, y);
			}
			//catch(Bad_hmean & bh){
				//bh.mesg();
			catch(Bad_hmean  & e){
				cout<<e.what();
				cout << "try again:\n";
				continue;
			}
			catch (Bad_gmean & e) {
			//	cout << bg.mesg();
		//	catch(std::exception & e){
				cout<<e.what();
				cout << e.v1 << " , " << e.v2 << endl;
				break;
			}
			cout << "a and b after means():\n" << z << endl;
			cout << "enter anthoer a and b:\n";
		}
		d1.show();
	}
	cin.get();
	system("pause");

}

double hmean(double a, double b)
{
	if (a == -b)
		throw Bad_hmean(a,b);
	return 2.0*a*b / (a + b);
}
double gmean(double a, double b)
{
	if (a < 0 || b < 0)
		throw Bad_gmean(a, b);
	return sqrt(a*b);
}

double means(double a, double b)
{
	double am, hm, gm;
	Demo d2("found in means()");
	am = (a + b) / 2.0;
	try {
		hm = hmean(a, b);
		gm = gmean(a, b);
	}
	//catch(Bad_hmean & bh){
	catch(Bad_hmean & e){
		//bh.mesg();
		std::cout<<e.what();
		std::cout << "caught in means()\n";
		throw;
	}
	d2.show();
	return (am + gm + hm) / 3.0;
}