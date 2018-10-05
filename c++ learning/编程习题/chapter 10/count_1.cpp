#include<iostream>
#include<string>
#include<cstring>
static const int LIM=20;
class Account
{
  private:
    char name[LIM];
    std::string account_num;
    double money;
  public:
    Account(const char *name=NULL,const std::string &account_num=0,double money=0);
    ~Account(){}
    void show_account() const;
    void account_in(double Money);
    void account_out(double Money);
};
Account::Account(const char *name,const std::string &account_num,double money)
{
   std::strcpy(this->name,name);
   this->account_num=account_num;
   this->money=money;
}
void Account::show_account() const
{
  std::cout<<"account message:\n";
  std::cout<<"name : ";
  for(int i=0;name[i]!='\0';i++)
    std::cout<<name[i];
  std::cout<<std::endl<<"account number : "<<account_num<<std::endl;
  std::cout<<"the rest : "<<money<<std::endl;
}

void Account::account_in(double Money)
{
    money=Money+money;
    std::cout<<"money in success!\n";
}
void Account::account_out(double Money)
{
   if(money-Money<0)
     std::cout<<"can't draw money, not sufficient funds!\n";
   else
    money=money-Money;
    std::cout<<"draw money success!\n";
}

int main()
{
    Account one("Lisi","1245666",1200.12);
    one.show_account();
    one.account_in(1000);
    one.show_account();
    one.account_out(1500);
    one.show_account();
    return 0;
}