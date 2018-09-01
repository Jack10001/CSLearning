#include<string>
#include<algorithm>
#include<iostream>

int main()
{
	using namespace std;
	string letters;
	cout<<"enter letters and quit to quit:\n";
	while(cin>>letters && letters!="quit")
	{
		cout<<"you entered: "<<letters<<endl;
		sort(letters.begin(),letters.end());
		cout<<letters<<endl;
		while(next_permutation(letters.begin(),letters.end()))
		{
			cout<<letters<<endl;
		}
		
		cout<<"enter next letters:\n";
	}
	return 0;
}
