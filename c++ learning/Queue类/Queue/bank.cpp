#include<iostream>
#include<ctime>
#include<cstdlib>
#include"Queue.h"
const int MIN_PER_HR = 60;
bool newcustomer(double x);
int main()
{
	using namespace std;
	srand(time(0));
	cout << "\t\t------Bank Teller-------\n";
	cout << "enter max szie of queue\n ";
	int qs;
	cin >> qs;
	Queue line(qs);

	cout << "enter the number of simulation hours\n";
	int hours;
	cin >> hours;
	long cyclelimit = MIN_PER_HR * hours;
	cout << "enter the average number of customer per hours\n";
	double perhours;
	cin >> perhours;
	double min_per_cust;
	min_per_cust = MIN_PER_HR / perhours;

	Item temp;
	long turnaway = 0;
	long customers = 0;
	long served = 0;
	long sum_line = 0;
	int wait_time = 0;
	long line_wait = 0;
	for (int cycle = 0; cycle < cyclelimit; cycle++)
	{
		if (newcustomer(min_per_cust))
		{
			if (line.isfull())
				turnaway++;
			else
			{
				customers++;
				temp.set(cycle);
				line.enqueue(temp);
			}
		}
		if (wait_time <= 0 && !line.isempty())
		{
			line.dequeue(temp);
			wait_time = temp.ptime();
			line_wait += cycle - temp.when();
			served++;
		}
		if (wait_time > 0)
			wait_time--;
		sum_line += line.queuecount();
	}
	if (customers > 0)
	{
		cout << "customers accepted : " << customers << endl;
		cout << "customters served: " << served << endl;
		cout << "turnaway: " << turnaway << endl;
		cout << "average queue size: ";
		cout.precision(2);
		cout.setf(ios_base::fixed, ios_base::floatfield);
		cout << (double)sum_line / cyclelimit << endl ;
		cout << "average wait time: " << (double)line_wait / served << " minutes\n";
	}
	else
		cout << "no cutomers\n";
	system("pause");
}
bool newcustomer(double x)
{
	return (rand() * x / RAND_MAX < 1);
}