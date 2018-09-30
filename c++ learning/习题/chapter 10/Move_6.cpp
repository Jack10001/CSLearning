#include<iostream>
#include<string>
#include<cstring>
class Move
{
  private:    
    double x;    
    double y;
  public:    
    Move(double a = 0, double b = 0);    
    void showmove() const;    
    Move  add(const Move & m);     
    void reset(double a = 0, double b = 0);
};

Move::Move(double a,double b)
{
    x=a;
    y=b;
}
void Move::showmove() const
{
    std::cout<<"(x : "<<x<<" , y : "<<y<<")"<<std::endl;
}
Move  Move::add(const Move & m) 
{
  this->x=this->x+m.x;
  this->y=this->y+m.y;
  return *this;
}
void Move::reset(double a,double b)
{
    x=a;
    y=b;
}



int main()
{
using namespace std;
  Move st(55,30);
  Move ct;
  std::cout<<"st :";
  st.showmove();
  cout<<"ct : " ;
   ct.showmove();
  ct=ct.add(st);
  cout<<"now ct : ";
  ct.showmove();
  st.reset(41,24);
  cout<<"now st : ";
  st.showmove();
  return 0;
}
