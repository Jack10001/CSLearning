#pragma once
class Stonewt
{
private:
	enum {Lbs_per_stn=14};//1Ó¢Ê¯=14Ó¢°õ
	double pounds;
	double pds_left;
	int stone;
public:
	Stonewt(double lbs);
	Stonewt(int stn, double lbs);
	Stonewt();
	~Stonewt(){}
	void show_lbs() const;
	void show_stn() const;
	//conversion function
	explicit operator int() const;
//	explicit operator int() const;
	operator double() const;
	//explicit operator double() const;
};