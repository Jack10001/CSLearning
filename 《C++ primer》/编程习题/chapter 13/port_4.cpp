#include <iostream>
#include <cstring>
#include <cstdlib>
#include <string>
using namespace std;

class Port
{
private:
  char *brand;
  char style[20];
  int bottles;

public:
  Port();
  Port(const char *br, const char *st, int b);
  Port(const Port &p); //copy constructor
  virtual ~Port() { delete[] brand; }
  Port &operator=(const Port &p); //relaod assign operator
  Port &operator+=(int b);
  Port &operator-=(int b);
  int BottleCount() const { return bottles; }
  virtual void show() const;
  friend ostream &operator<<(ostream &os, const Port &p);
};

class VintagePort : public Port
{
private:
  char *nickname;
  int year;

public:
  VintagePort();
  VintagePort(const char *br, const char *st, int b, const char *nn, int y);
  VintagePort(const VintagePort &vp);
  ~VintagePort() { delete[] nickname; }
  VintagePort &operator=(const VintagePort &vp);
  virtual void show() const;
  friend ostream &operator<<(ostream &os, const VintagePort &vp);
};

/*class port methods*/
Port::Port()
{
  brand = new char[1];
  brand[0] = '\0';
  style[0] = '\0';
  bottles = 0;
}

Port::Port(const char *br, const char *st, int b)
{
  brand = new char[strlen(br) + 1];
  //st=new char [strlen(st)+1];
  strcpy(brand, br);
  strcpy(style, st);
  bottles = b;
}
Port::Port(const Port &p) //copy constructor
{
  brand = new char[strlen(p.brand) + 1];
  strcpy(brand, p.brand);
  strcpy(style, p.style);
  bottles = p.bottles;
}

Port &Port::operator=(const Port &p) //relaod assign operator
{
  if (&p == this)
    return *this;
  delete[] brand;
  strcpy(brand, p.brand);
  strcpy(style, p.style);
  bottles = p.bottles;
}
Port &Port::operator+=(int b)
{
  this->bottles = this->bottles + b;
  return *this;
}
Port &Port::operator-=(int b)
{
  if (this->bottles > b)
    this->bottles = this->bottles - b;
  else
  {
    cout << "bottles < b!" << endl;
    exit(0);
  }
  return *this;
}

void Port::show() const
{
  cout << "Brand: " << this->brand << endl;
  cout << "Kind: " << this->style << endl;
  cout << "Bottles: " << this->bottles << endl;
}

ostream &operator<<(ostream &os, const Port &p)
{
  os << p.brand << ", " << p.style << ", " << p.bottles << endl;
  return os;
}

/*class Vintage methods*/
VintagePort::VintagePort() : Port()
{
  nickname = new char[1];
  nickname[0] = '\0';
  year = 0;
}

VintagePort::VintagePort(const char *br, const char *st, int b, const char *nn, int y) : Port(br, st, b)
{
  nickname = new char[strlen(nn) + 1];
  strcpy(nickname, nn);
  year = y;
}
VintagePort::VintagePort(const VintagePort &vp) : Port(vp)
{
  nickname = new char[strlen(vp.nickname) + 1];
  strcpy(nickname, vp.nickname);
  year = vp.year;
}
VintagePort &VintagePort::operator=(const VintagePort &vp)
{
  if (&vp == this)
    return *this;
  Port::operator=(vp);
  delete[] nickname;
  strcpy(nickname, vp.nickname);
  year = vp.year;
}
void VintagePort::show() const
{
  Port::show();
  cout << "Nickname: " << nickname << endl;
  cout << "Year: " << year;
}
ostream &operator<<(ostream &os, const VintagePort &vp)
{
  os << (const Port &)vp;
  os << ", " << vp.nickname << ", " << vp.year << endl;
}

int main()
{
  Port *P_ptr[4];
  char brand[30];
  char style[20];
  int bottles = 0;
  char nickname[30];
  int year = 0;
  char kind = 0;
  for (int i = 0; i < 4; i++)
  {
    cout << "enter brand: ";
    cin.get(brand, 30);
    fflush(stdin);
    cout << "enter style: ";
    cin.get(style, 20);
    fflush(stdin);
    cout << "enter bottles: ";
    cin >> bottles;

    cout << "1 for class Port, 2 for class VintagePort:\n";
    while(cin >> kind&&(kind!='1')&&(kind!='2'))
      cout<<"enter either 1 or 2!\n";
    if (kind == 1)
    {
      P_ptr[i] = new Port(brand, style, bottles);
    }
    else
    {
      cout << "enter nickname:";
      getline(cin, nicknamexc);
      cout << "enter year:";
      cin >> year;
      P_ptr[i] = new VintagePort(brand, style, bottles, nickname, year);
    }
  }
  while(cin.get()!='\n')
    continue;

  for (int i = 0; i < 4; i++)
  {
    P_ptr[i]->show();
  }
  for (int i = 0; i < 4; i++)
  {
    delete P_ptr[i];
  }
}