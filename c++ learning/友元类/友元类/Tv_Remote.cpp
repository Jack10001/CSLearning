#include<iostream>
#include"TV_remote.h"

bool Tv::volup()
{
	if (volume < MaxVal) {
		volume++;
		return true;
	}
	else
		return false;
}
bool Tv::voldown()
{
	if (volume > MinVal) {
		volume--;
		return true;
	}
	else
		return false;
}
void Tv::chanup()
{
	if (cur_channel == maxchannels) {
		cur_channel = 1;
	}
	if (cur_channel < maxchannels)
		cur_channel++;
}
void Tv::chandown()
{
	if (cur_channel == 1)
		cur_channel = maxchannels;
	else
		cur_channel--;
}
void Tv::settings()const
{
	using std::cout;
	using std::cin;
	using std::endl;
	cout << "TV is " << (state == off ? "off" : "on") << endl;
	if (state == on)
	{
		cout << "volume settings: " << volume << endl;
		cout << "channel settings: " << cur_channel << endl;
		cout << "mode = " << (mode == Antenna ? "antenna" : "cable") << endl;
		cout << "input = " << (input == TV ? "TV" : "DVD") << endl;
	}
}