#include<iostream>
#include"TV_remote.h"

int main()
{
	using std::cout;
	Tv s42;
	cout << "initial settings for 42:\n";
	s42.settings();
	s42.onoff();
	s42.chanup();
	cout << "\nadjusted settings for 42:\n";
	s42.settings();
	Remote grey;
	grey.set_chan(s42, 36);
	grey.voldown(s42);
	grey.chanup(s42);
	grey.set_mode(s42);


	s42.set_input();
	grey.set_input(s42);



	cout << "\nafter friend class adjusted:\n ";
	s42.settings();
	cout << std::endl;
	s42.onoff();
	s42.settings();
	system("pause");
}