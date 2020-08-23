#include<iostream>
#include<fstream>

using namespace std;

int main(int argc,char *argv[])
{
	int count=0;
	int sum=0;
	char ch;
	long total=0;
	ifstream infile;
	for(int i=1;i<argc;i++)
	{
		if(argc==1)
		{
			cout<<"error"<<endl;
			exit(0);
		 } 
		count=0;
		infile.open(argv[i]);
		if(!infile.is_open())
		{
			cout<<"the file can't be opened"<<endl;
			exit(0);
		}
		while(infile>>ch)
		{
			count++;
		}
		total+=count;
		cout<<argv[i]<<" has "<<count<<" chars "<<endl;
		infile.clear();
		infile.close();
	}
	cout<<" total chars : "<<total<<endl;
	return 0;
 } 
