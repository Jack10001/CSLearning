
#include <iostream>
#include <cmath>
#include <fstream>
#include <cstdlib>
#include <ctime>

using namespace std;
namespace VECTOR
{
class Vector
{

  public:
    enum Mode
    {
        RECT,
        POL
    };

  private:
    double x;

    double y;

    double mag;

    double ang;

    Mode mode;

    void set_mag();

    void set_ang();

    void set_x();

    void set_y();

  public:
    Vector();

    Vector(double n1, double n2, Mode form = RECT);

    void reset(double n1, double n2, Mode form = RECT);

    ~Vector();

    double xval() const { return x; }

    double yval() const { return y; }

    double magval() const { return mag; }

    double angval() const { return ang; }

    void polar_mode();

    void rect_mode();

    Vector operator-(const Vector &b) const;

    Vector operator+(const Vector &b) const;

    Vector operator-() const;

    Vector operator*(double n) const;

    friend Vector operator*(double n, const Vector &a);

    friend std::ostream &operator<<(std::ostream &os, const Vector &v);
};

} // namespace VECTOR






namespace VECTOR

{

const double Rad_to_deg = 45.0 / atan(1.0);

void Vector::set_mag()

{

    mag = sqrt(x * x + y * y);
}

void Vector::set_ang()

{

    if (x == 0.0 && y == 0.0)

        ang = 0.0;

    else

        ang = atan2(y, x);
}

void Vector::set_x()

{

    x = mag * cos(ang);
}

void Vector::set_y()

{

    y = mag * sin(ang);
}

Vector::Vector()

{

    x = y = mag = ang = 0.0;

    mode = RECT;
}

Vector::Vector(double n1, double n2, Mode form)

{

    mode = form;

    if (form == RECT)

    {

        x = n1;

        y = n2;

        set_mag();

        set_ang();
    }

    else if (form == POL)

    {

        mag = n1;

        ang = n2 / Rad_to_deg;

        set_x();

        set_y();
    }

    else

    {

        cout << "Incorrect 3rd argument to Vector() -- ";

        cout << "vector set to 0\n";

        x = y = mag = ang = 0.0;

        mode = RECT;
    }
}

void Vector::reset(double n1, double n2, Mode form)

{

    mode = form;

    if (form == RECT)

    {

        x = n1;

        y = n2;

        set_mag();

        set_ang();
    }

    else if (form == POL)

    {

        mag = n1;

        ang = n2 / Rad_to_deg;

        set_x();

        set_y();
    }

    else

    {

        cout << "Incorrect 3rd argument to Vector() -- ";

        cout << "vector set to 0\n";

        x = y = mag = ang = 0.0;

        mode = RECT;
    }
}

Vector::~Vector() {}

void Vector::polar_mode()

{

    mode = POL;
}

void Vector::rect_mode()

{

    mode = RECT;
}

Vector Vector::operator+(const Vector &b) const

{

    return Vector(x + b.x, y + b.y);
}

Vector Vector::operator-(const Vector &b) const

{

    return Vector(x - b.x, y - b.y);
}

Vector Vector::operator-() const

{

    return Vector(-x, -y);
}

Vector Vector::operator*(double n) const

{

    return Vector(n * x, n * y);
}

Vector operator*(double n, const Vector &a)

{

    return a * n;
}

std::ostream &operator<<(std::ostream &os, const Vector &v)

{

    if (v.mode == Vector::RECT)

        os << "(x, y) = (" << v.x << ", " << v.y << ")";

    else if (v.mode == Vector::POL)

        os << "(m, a) = " << v.mag << ", " << v.ang * Rad_to_deg << ")";

    else

        os << "Vector object mode is invalid";

    return os;
}
}
int main()
{
    fstream f;
    f.open("result.txt",ios::out);
    srand(time(0));
    double direction;
    VECTOR::Vector step;
    VECTOR::Vector result(0.0, 0.0);
    unsigned long steps = 0;
    double target; 

    double dstep;
    std::cout << "Enter target distance (q to quit): ";

    while (std::cin >> target)

    {

        std::cout << "Enter step length: ";

        if (!(std::cin >> dstep))

            break;

        f << "Target Distance: " << target << "Step Size: " << dstep << "\r\n";

        while (result.magval() < target)

        {

            direction = rand() % 360;

            step.reset(dstep, direction, VECTOR::Vector::POL);

            result = result + step;

            f << steps << ": (x, y) = (" << step.xval() << ", " << step.yval() << ")\r\n";

            steps++;
        }

        f << "After " << steps << " steps, the subject has the following location:\r\n"
          << result << "\r\n";

        result.polar_mode();

        f << " or\r\n"
          << "Average outward distance per step = " << result.magval() / steps << "\r\n";

        steps = 0;

        std::cout << "Enter target distance (q to quit): ";
    }

    f.close();

    std::cout << "Bye!" << std::endl;

    std::cin.clear();

    while (std::cin.get() != '\n')

        continue;

    return 0;
}
