#include<iostream>
#include"Sting.h"
#include<ctime>
#include<cstdlib>
/*
c++ ���Կ�����const�����峣����Ҳ������ #define�����峣��������ǰ�߱Ⱥ����и�����ŵ㣺
��1��   const�������������ͣ����곣��û���������͡����������Զ�ǰ�߽������Ͱ�ȫ��顣
       ���Ժ���ֻ�����ַ��滻��û�����Ͱ�ȫ��飬�������ַ��滻���ܻ�������ϲ����Ĵ��󣨱߼�ЧӦ����
��2��   ��Щ���ɻ��ĵ��Թ��߿��Զ�const�������е��ԣ����ǲ��ܶԺ곣�����е��ԡ�
*/
const int ArSize = 5;
const int Maxlen = 81;
int main()
{
	using namespace std;
	String name;
	cout << "enter you name:\n";
	cin >> name;// >>����
	cout << name << "  please enter up to " << ArSize << "short sayings \n";
	String sayings[ArSize];
	char temp[Maxlen];
	int i;
	for (i = 0; i < ArSize; i++) {
		cout << i + 1 << ":";
		cin.get(temp, Maxlen);
		while (cin && cin.get() != '\n')
			continue;
		if (!cin && temp[0] != '\n')
			break;
		else
			sayings[i] = temp;//��ֵ���������
	}
	int total = i;
	if (total > 0) {
		cout << endl<<endl<<"here are your sayings:\n";
		for (int i = 0; i < total; i++) {
			cout << sayings[i]<<endl;

		}
		cout << endl;
		String *shortest = &sayings[0];
		String *first = &sayings[0];
		for (i = 1; i < total; i++) {
			if (sayings[i].length() < shortest->length()) {
				shortest = &sayings[i];
			}
			if (sayings[i] < *first)
				first = &sayings[i];
		}
		cout << "shoterst sayings: " << *shortest << endl;
		cout << "first :" << *first << endl;

		srand(time(0));
		int choice = rand() % total;
		String *favorite = new String(sayings[choice]);
		cout << "my favorite: " << *favorite << endl;
		delete favorite;
	}
	else
		cout << "bye" << endl;
	system("pause");
}