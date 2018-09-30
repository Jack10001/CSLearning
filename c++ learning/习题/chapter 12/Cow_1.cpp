//
//  Cow_1.cpp
//  Created by Jack on 2018/09/28
//  Copyright (c) 2016年 FableGame. All rights reserved.
//
#include <iostream>
#include <string>
#include <cstring>

class Cow
{
  private:
    char name[20];
    char *hobby;
    double weight;

  public:
    Cow();
    Cow(const char *nm, const char *ho, double wt);
    Cow(const Cow &c);
    ~Cow();
    Cow &operator=(const Cow &c);
    void showCow() const;
};

//赋值运算符，复制构造函数，析构函数

Cow::Cow()
{
    std::cout<<"the object has been created!\n";
    name[0] = '\0';
    weight = 0.0;
    hobby = new char[1];
    hobby[0]='\0';
}

Cow::Cow(const char *nm, const char *ho, double wt)
{
    std::strcpy(name, nm);
    int len = std::strlen(ho);
    hobby = new char[len + 1];
    if (!hobby)
    {
        std::cout << "can't get memory!\n";
        exit(0);
    }
    std::strcpy(hobby, ho);
    weight = wt;
}
Cow::~Cow()
{
    delete[] hobby;
    std::cout<<"the object has been deleted!\n";
}

Cow::Cow(const Cow &c)
{
    std::strcpy(name, c.name);
    int len = std::strlen(c.hobby);
    hobby = new char[len + 1];
    std::strcpy(hobby, c.hobby);
    weight = c.weight;
}
Cow &Cow::operator=(const Cow &c)
{
    if (this == &c)
        return *this;
    delete[] hobby;

    std::strcpy(name, c.name);
    int len = std::strlen(c.hobby);
    hobby = new char[len + 1];
    std::strcpy(hobby, c.hobby);
    weight = c.weight;
}
//类方法访问类的私有成员以及方法
void Cow::showCow() const
{
    std::cout << "name : " << name << " ,hobby : " << hobby << " ,weight : " << weight << std::endl;
}

int main()
{
    using namespace std;

    Cow a;
    Cow b("Mengniu", "niunai", 500);
    Cow c = b;
    {
    a.showCow();
    b.showCow();
    c.showCow();
    }
    return 0;
}
