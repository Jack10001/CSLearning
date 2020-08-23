#include<iostream>
#include<set>
#include<map>
#include<vector>
#include<cctype>
#include<string>
#include<iterator>
#include<algorithm>
using namespace std;

char ToLower(char ch)
{
	return tolower(ch);
}

string & toLower(string & s)
{
	transform(s.begin(), s.end(), s.begin(), ToLower);
	return s;
}

void show(const string& s)
{
	std::cout << s << endl;
}

int main()
{
	string input;
	vector<string> init_data;
	map<const string,int> third_store;
	set<string> second_store;
	cout << "enter your words(quit to quit):\n";
	while (cin >> input && input != "quit")
	{
		init_data.push_back(input);
	}
	cout << "\ninit data as follows:\n\n";
	for_each(init_data.begin(), init_data.end(), show);

	transform(init_data.begin(), init_data.end(), insert_iterator<set<string>>(second_store,second_store.begin()), toLower);
	cout << "\nafter simple sorted:\n\n";
	for_each(second_store.begin(), second_store.end(), show);

	set<string>::iterator si;
	for (si = second_store.begin(); si != second_store.end(); si++)
		third_store[*si] = count(init_data.begin(), init_data.end(), *si);
	cout << "\nword frequency:\n\n";
	for( si= second_store.begin(); si != second_store.end(); si++)
		cout << *si << ":" << third_store[*si] << endl;
	cout << endl;
	system("pause");
}