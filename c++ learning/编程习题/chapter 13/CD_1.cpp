#include <iostream>
#include <string>
#include <cstring>
#include<cstdlib>
class Cd
{
private:
  char performers[50];
  char label[20];
  int selections;
  double playtime;

public:
  Cd();
  Cd(const char *s1, const char *s2, int n, double x);
  Cd(const Cd &d);
  Cd &operator=(const Cd &d);
  ~Cd() {}
  virtual void Report() const;
};

class Classic : public Cd
{
private:
  char *mainWorks;

public:
  Classic();
  Classic(const char *works, const char *s1,const  char *s2, int n, double x);
  Classic(const char *works, const Cd &c);

  Classic(const Classic &cl);
  Classic &operator=(const Classic &cl);
  virtual void Report() const;
  ~Classic();
};

Cd::Cd()
{
  performers[0]='\0';
  label[0]='\0';
  selections=0;
  playtime=0.0;
}

Cd::Cd(const char *s1,const  char *s2, int n, double x)
{
  std::strcpy(performers, s1);
  std::strcpy(label, s2);
  selections = n;
  playtime = x;
}
Cd::Cd(const Cd &d)
{
  std::strcpy(this->performers, d.performers);
  std::strcpy(this->label, d.label);
  this->selections = d.selections;
  this->playtime = d.playtime;
}
Cd &Cd::operator=(const Cd & d)
{
  if (&d == this)
    return *this;

  std::strcpy(this->performers, d.performers);
  std::strcpy(this->label, d.label);
  this->selections = d.selections;
  this->playtime = d.playtime;

  return *this;
}

void Cd::Report() const
{
  std::cout << " the performers : " << performers << std::endl;
  std::cout << " the label : " << label << std::endl;
  std::cout << " the selection : " << selections << std::endl;
  std::cout << " the playtime : " << playtime << std::endl;
}

Classic::Classic():Cd()
{
  mainWorks=new char [1];
  mainWorks[0]='\0';
}
Classic::Classic(const char *works,const char *s1,const char *s2, int n, double x) : Cd(s1, s2, n, x)
{
  int len = std::strlen(works);
  mainWorks = new char[len + 1];
  if (!mainWorks)
  {
    std::cout << "the memory can't get!\n";
    exit(0);
  }
  std::strcpy(mainWorks, works);
}

Classic::Classic(const char *works, const Cd &c) : Cd(c)
{
  int len = std::strlen(works);
  mainWorks = new char[len + 1];
  if (!mainWorks)
  {
    std::cout << "the memory can't get!\n";
    exit(0);
  }
  std::strcpy(mainWorks, works);
}

Classic::Classic(const Classic &cl)
    : Cd(cl)
{
  int len = std::strlen(cl.mainWorks);
  mainWorks = new char[len + 1];
  std::strcpy(mainWorks, cl.mainWorks);
}
Classic & Classic::operator = (const Classic &cl)
{
  if (&cl == this)
    return *this;
  Cd::operator=(cl);
  delete[] mainWorks;
  //Cd::operator=(cl);
  int len = std::strlen(cl.mainWorks);
  mainWorks = new char[len + 1];
  std::strcpy(mainWorks, cl.mainWorks);
  return *this;
}

void Classic::Report() const
{
 Cd::Report();
  std::cout << "the mainworks : " << mainWorks << std::endl;
}
Classic::~Classic()
{
  delete[] mainWorks;
}

void Bravo(const Cd &disk);

int main()
{
  using namespace std;
  Cd c1("Beatles", "Capitol", 14, 35.5);
  Classic c2("Piano Sonata in B flat, Fantasia in C", "Alfred Brendel", "Philips", 2, 57.17);
  Cd *pcd = &c1;
  cout << "Using object directly:\n";
  c1.Report();
  c2.Report();
  cout << "Using type cd * pointer to Objects:\n";
  pcd->Report();
  pcd = &c2;//基类的指针在不进行转换的情况下可以指向派生类
  pcd->Report();
  cout << "Calling a function with a Cd reference argument:\n";
  Bravo(c1);
  Bravo(c2);
  cout << "Testing assignment:\n ";
  Classic copy;
  copy = c2;
  copy.Report();
  return 0;
}

void Bravo(const Cd &disk)
{
  disk.Report();
}
