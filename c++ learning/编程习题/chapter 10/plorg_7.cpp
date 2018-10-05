#include<iostream>
#include<string>
#include<cstring>
//#define LIM 19
static const int LIM=20; 

class Plorg
{
    private:    
        char pname[LIM];    
        int CI;
    public:    
        Plorg();    
        void showplorg() const;    
        void newplorg(const char * name);    
        void setCI(int x);
};

Plorg::Plorg()
{    
    strcpy_s(pname, "Plorga");    
    CI = 0;
} 
void Plorg::showplorg() const
{    
    std::cout << "The plorg name is " << pname << ", and the CI is " << CI << std::endl;
} 
void Plorg::newplorg(const char * name)
{    
    strcpy_s(pname, name);    
    CI = 50;
} 
void Plorg::setCI(int x){   CI = x;}

int main()
{    
    using namespace std;
    Plorg p;    
    cout << "The default plorg is:\n";    
    p.showplorg();    
    Plorg np;    
    cout << "Please enter a new plorg:\n";    
    cout << "Name: ";    
    char name[LIM];    
    cin.getline(name, LIM);    
    np.newplorg(name);    
    np.showplorg();    
    cout << "You can change the CI from the default 50:\n";    
    int x;    
    cin >> x;    
    cin.ignore();    
    np.setCI(x);    
    np.showplorg();    
    cout << "Bye!\n";     
    return 0;
}
