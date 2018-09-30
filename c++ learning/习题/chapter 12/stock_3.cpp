/*
---stock_3.cpp
---created by Jack on 2018/09/29
---function: To use C++ class 
*/
#include <string>
#include <iostream>
#include <cstring>
using namespace std;

const int STKS = 4;

class Stock
{
  private:
    //std::string company;
    char *company;
    int shares;
    double share_val;
    double total_val;
    void set_tot() { total_val = shares * share_val; }

  public:
    Stock();
    Stock(const char *co=NULL, int n = 0, double pr = 0.0);
    ~Stock();
    void buy(long num, double price);
    void sell(long num, double price);
    void update(double price);
    //void show() const;
    const Stock & topval(const Stock &s) const;
    //重载赋值运算符，复制构造函数
    Stock & operator=(const Stock & s);//init or temp object
    Stock(const Stock & s);
    friend std::ostream & operator<<(std::ostream & os,const Stock &s);

};


Stock::Stock()
{
    company = NULL;
    shares = 0;
    share_val = 0.0;
    total_val = 0.0;
}
Stock::Stock(const char *co, int n, double pr)
{
   // company = co;
   int len=std::strlen(co);
   company=new char [len +1];
   std::strcpy(company,co);
    if (n < 0)
    {
        std::cout << "Number of shares can't be negative; " << company << " shares set to 0.\n";
        shares = 0;
    }
    else
    {
        shares = n;
    }
    share_val = pr;
    set_tot();
}
Stock::~Stock() 
{
    delete [] company;
    std::cout<<"\nthe object has been deleted!\n";
}

void Stock::buy(long num, double price)
{
    if (num < 0)
    {
        std::cout << "Number of shares purchased can't be negative. Transaction is aborted.\n";
    }
    else
    {
        shares += num;
        share_val = price;
        set_tot();
    }
}

void Stock::sell(long num, double price)
{
    if (num < 0)
    {
        cout << "Number of shares sold can't be negative. Transaction is aborted.\n";
    }
    else if (num > shares)
    {
        cout << "You can't sell more than you have! Transaction is aborted.\n";
    }
    else
    {
        shares -= num;
        share_val = price;
        set_tot();
    }
}
/*
void Stock::show() const
{
    ios_base::fmtflags orig = cout.setf(ios_base::fixed, ios_base::floatfield);
    std::streamsize prec = cout.precision(3);
    cout << "Company: " << company << " shares: " << shares << endl;
    cout << "  Share Price: $ " << share_val << "  Total Worth: $" << total_val << endl;
    cout.setf(orig, ios_base::floatfield);
    cout.precision(prec);
}*/

const Stock &Stock::topval(const Stock &s) const
{
    if (s.total_val > total_val)
    {
        return s;
    }
    else
    {
        return *this;
    }
}

std::ostream & operator<<(std::ostream & os,const Stock &s)
{
    ios_base::fmtflags orig = os.setf(ios_base::fixed, ios_base::floatfield);
    std::streamsize prec = os.precision(3);
    os << "Company: " << s.company << " shares: " << s.shares << endl;
    os << "  Share Price: $ " << s.share_val << "  Total Worth: $" << s.total_val << endl;
    os.setf(orig, ios_base::floatfield);
    os.precision(prec);
    return os;
}
 Stock & Stock::operator=(const Stock & s)//init or temp object
 {
     if(this==&s)
       return *this;
     delete [] company;
     std::strcpy(company,s.company);
     shares=s.shares;
     share_val=s.share_val;
     set_tot();
     return *this;
 }

Stock::Stock(const Stock & s)
{
   int len=std::strlen(s.company);
   company=new char [len+1];
   std::strcpy(company,s.company);
   share_val=s.share_val;
   shares=s.shares;
   set_tot();
}

int main()
{

    Stock stocks[STKS] = {Stock("NanoSmart", 12, 20.0),
                          Stock("Boffo Objects", 200, 2.0),
                          Stock("Monolithic Obelisks", 130, 3.25),
                          Stock("Fleep Enterprises", 60, 6.5)};
    cout << "Stock holdings:\n";
    int st;
    for (st = 0; st < STKS; st++)
    {
        cout<<stocks[st];
    }
    const Stock *top = &stocks[0];
    for (st = 1; st < STKS; ++st)
    {
        top = &top->topval(stocks[st]);
    }
    cout << "\nMost valuable holding:\n";
    //top->show();
    cout<<*top;
    return 0;
}
