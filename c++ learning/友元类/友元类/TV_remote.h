#pragma once

#ifndef TV_REMOTE_H_
#define TV_REMOTE_H_
#include<iostream>
#include<string>

//class Tv;//forward devlaration

class Tv
{
public:
	friend class Remote;
	//friend void Remote::set_chan(Tv&  t, int c);
	enum state{on,off};
	enum{MinVal,MaxVal=20};
	enum{Antenna,Cable};
	enum{TV,DVD};
	Tv(int s=off,int mc=125):state(s),volume(5),maxchannels(mc),cur_channel(2),mode(Cable),input(TV){}
	void onoff() { state = (state == on) ? off : on; }
	bool ison() const { return state == on; }
	bool volup();
	bool voldown();
	void chanup();
	void chandown();
	void set_mode() { mode = (mode == Antenna) ? Cable : Antenna; }
	void set_input() { input = (input == TV) ? DVD : TV; }
	void settings()const;
private:
	int state;//on or off
	int maxchannels;
	int volume;
	int cur_channel;
	int mode;//Antenna or cable
	int input;//tv or dvd
};

class Remote
{
private:
	int mode;
public:
	Remote(int m = Tv::TV) :mode(m) {}
	bool volup(Tv& t) { return t.volup(); }
	bool voldown(Tv& t) { return t.voldown(); }
	void chanup(Tv&t) { t.chanup(); }
	void chandown(Tv &t) { t.chandown(); }
	void set_chan(Tv &t, int c) { t.cur_channel = c; }
	void set_mode(Tv &t) { t.set_mode(); }
	void set_input(Tv&t) { t.set_input(); }
};


#endif