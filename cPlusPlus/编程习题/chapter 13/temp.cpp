#include<iostream>
#include<string>
#include<cstring>
using namespace std;

class Base
{
    private:
     char *name;
    public:
     Base(char *N=NULL);
     Base(const Base & b);
    virtual void show()const;
     virtual ~Base();
};

class Ba:public Base
{
  private:
    char *school;
  public:
     Ba(char *N=NULL,char *s=NULL);
     Ba(const Base& b,char * s=NULL);
     virtual void show()const;
     ~Ba();
};

Base::Base(char *N)
{
    int len=std::strlen(N);
    name=new char[len +1];
    std::strcpy(name,N);
    std::cout<<"the Base object has created!\n";
}
Base::Base(const Base &b)
{
    int len=std::strlen(b.name);
    name=new char [len+1];
    std::strcpy(name,b.name);
}
Base::~Base()
{
    delete [] name;
    std::cout<<"the Base object has been deleted!\n";
}

void Base::show() const
{
    std::cout<<"the name is :"<<name<<std::endl;
}


Ba::Ba(char *N,char *s):Base(N)
{
    int len=std::strlen(s);
    school=new char [len +1];
    std::strcpy(school,s);
    std::cout<<"the Ba created!\n";

}
Ba::Ba(const Base & b,char *s):Base(b)
{
    int len=std::strlen(s);
    school=new char [len+1];
    std::strcpy(school,s);
    std::cout<<"the Ba(copy) crated!\n";
}
void Ba::show() const
{
    Base::show();
    std::cout<<" the school : "<<school<<endl;
}
Ba::~Ba()
{
    delete [] school;
    std::cout<<"the Ba object has been deleted!\n";
}
int main()
{
   // Ba b("Jack","BUPT");
    //b.show();
    Base *p[4];
    char  Name[20];
    char school[20];
    char kind;
    for(int i=0;i<4;i++)
    {
        cout<<"enter name:\n";
        cin.get(Name,20);
        while(cin.get()!='\n')
            continue;
        cout<<"1 for Base, 2 for Ba:\n";
        cin>>kind;
        if(kind == '1')
        {
            p[i]=new Base(Name);
        }
        if(kind == '2')
        {
            cout<<"enter school:\n";
            cin.get(school,20);
            while(cin.get()!='\n')
                continue;
            p[i]=new Ba(Name,school);
        }
        else{
            cout<<"wrong , enter again!\n";
            i--;
        }
    }
    for(int i=0;i<4;i++)
      p[i]->show();

    for(int i=0;i<4;i++)
        delete p[i];
    return 0;
}
//使用一个数组表示多种类型的对象，这就是多态性
// 包含虚函数的类才会有虚函数表， 同属于一个类的对象共享虚函数表， 但是有各自的_vptr.
//    虚函数表实质是一个指针数组，里面存的是虚函数的函数指针。
//虚函数的工作原理：当类中存在虚函数时，编译器默认会给对象添加一个隐藏成员。该成员为一个指向虚函数表(virtual function table,vtbl)的指针。//
//虚函数表是一个保存了虚函数地址的数组。编译器会检查类中所有的虚函数，依次将每个虚函数的地址，存入虚函数表。

//父类和子类有独立的虚函数表，且虚函数表中虚函数指针也指向各自的虚函数地址，
//若子类没有覆盖父类中的show方法，则虚函数指针show_ptr指向的虚函数show()的地址是一样的，均指向父类show()函数地址。虚函数表的存在和动态联编，就是多态的原理。