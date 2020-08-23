#include<iostream>
#include"dma.h"

int main()
{
	using std::cout;
	using std::endl;
	BaseDMA shirt("Portabelly", 4);
	LackDMA balloon("red", "Blimpo", 5);
	HasDMA map("Mercator", "Buffalo keys", 5);
	cout << "displaying BaseDMA object\n";
	cout << shirt<<endl;
	cout << "displaying LackDMA\n";
	cout << balloon << endl;
	cout << "displaying HasDMA\n";
	cout << map << endl;

	LackDMA balloon2(balloon);
	cout << "result of LACKDMA copy\n";
	cout << balloon2 << endl;
	HasDMA map2;
	map2 = map;
	cout << "result of HasDMA assignment\n";
	cout << map2 << endl;
	system("pause");


}