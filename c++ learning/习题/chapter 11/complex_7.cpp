#include <iostream>
#include <cmath>

using namespace std;

class Complex
{
private:
  double real;
  double vir;

public:
  //reload + - * / ~ <<'
  Complex(double a = 0.0, double b = 0.0) : real(a), vir(b) {}
  ~Complex() {}

  //friend function
  Complex operator*(const Complex &ex1)const;
  Complex operator+(const Complex &ex1)const;
  Complex operator-(const Complex &ex1)const;
  Complex operator~()const;

  friend std::ostream &operator<<(std::ostream &os, const Complex &ex);
  friend std::istream &operator>>(std::istream &in, const Complex &ex);
  friend Complex operator*(int n, Complex &ex);
  friend Complex operator*(Complex &ex, int n);
};

Complex Complex::operator*(const Complex &ex1) const
{
  //this->real = this->real * ex1.real - this->vir * ex1.vir;
  //this->vir = this->real * ex1.vir + this->vir * ex1.real;
  //return *this;
  return Complex(real*ex1.real-vir*ex1.vir,real*ex1.vir+vir*ex1.real);
}
Complex Complex::operator~() const
{
  //this->real = this->real;
  //this->vir = 0 - this->vir;
  //return *this;
   return Complex(real,-vir);
}

Complex Complex::operator+(const Complex &ex1) const
{
  //this->vir = this->vir + ex1.vir;
  //this->real = this->real + ex1.real;
  //return *this;
   return Complex(real+ex1.real,vir+ex1.vir);
}

Complex Complex::operator-(const Complex &ex1) const
{
  //real = real - ex1.real;
   //vir =vir - ex1.vir;
  //return *this;
  return Complex(real-ex1.real,vir-ex1.vir);
}

std::ostream &operator<<(std::ostream &os, const Complex &ex)
{
  os << "(" << ex.real << "," << ex.vir << "i)" << std::endl;
  return os;
}

Complex operator*(int n, Complex &ex)
{
  Complex ex1;
  ex1.vir = n * ex.vir;
  ex1.real = n * ex.real;
  return ex1;
}
Complex operator*(Complex &ex, int n)
{
  Complex ex1;
  ex1.vir = n * ex.vir;
  ex1.real = n * ex.real;
  return ex1;
}

std::istream &operator>>(std::istream &in, const Complex &ex)
{

  in >> ex.real >> ex.vir;
  return in;
}
int main()
{
  using namespace std;
  Complex a(3.0, 4.0); // initialize to (3, 4i)
  Complex b(7,8);
  Complex c;
  cout << "a is " << a << '\n';
  //cout << "Enter a complex number (q to quit):\n";
  //cin>>c;
  //operator>>(cin, c);
  c=a+b;
  cout << "c is " << c << '\n';
  cout << "complex conjugate is " << ~c << '\n';
  cout << "a is " << a << '\n';
  cout << "a + c is " << a + c << '\n';
  cout << "a - c is " << a - c << '\n';
  cout << "a * c is " << a * c << '\n';
  cout << "2 * c is " << 2 * c << '\n';
  /*  while (cin >> c)
  {
    cout << "c is " << c << '\n';
    cout << "complex conjugate is " << ~c << '\n';
    cout << "a is " << a << '\n';
    cout << "a + c is " << a + c << '\n';
    cout << "a - c is " << a - c << '\n';
    cout << "a * c is " << a * c << '\n';
    cout << "2 * c is " << 2 * c << '\n';
    cout << "Enter a complex number (q to quit):\n";
  }*/
  cout << "Done!\n";
  return 0;
}
