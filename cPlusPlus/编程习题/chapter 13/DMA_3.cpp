#include <iostream>
#include <string>
#include <cstring>

using namespace std;
const int ARR_SIZE = 3;

class ABC
{
  private:
    char *label;
    int rating;

  public:
    ABC();
    ABC(const char *l, int r );
    ABC(const ABC & rs);
    virtual ~ABC();
    ABC & operator=(const ABC &rs);

    friend std::ostream &operator<<(std::ostream &os, const ABC &rs);

    virtual void view()= 0;//pure virtual function

    char *getLabel() { return label; }
    int getRating() { return rating; }
};


class baseDMA:public ABC
{
  private:

  public:
    baseDMA();
    baseDMA(const char *l = "null", int r = 0);
    baseDMA(const baseDMA &rs);
    ~baseDMA();
    virtual void view(); 
    baseDMA &operator=(const baseDMA &rs);
    friend std::ostream &operator<<(std::ostream &os, const baseDMA &rs);
};

class lackDMA : public ABC
{
  private:
    enum { COL_LEN = 40};
    char color[COL_LEN];

  public:
    lackDMA();
    lackDMA(const char *c = "blank", const char *l = "null", int r = 0);
    lackDMA(const char *c, const ABC &ls);
    virtual void view();
    friend std::ostream &operator<<(std::ostream &os, const lackDMA &ls);
};

class hasDMA : public ABC
{
  private:
    char *style;

  public:
    hasDMA();
    hasDMA(const char *s = "none", const char *l = "null", int r = 0);
    hasDMA(const char *s, const ABC &hs);
    hasDMA(const hasDMA &hs);
    ~hasDMA();
    hasDMA &operator=(const hasDMA &hs);
    virtual void view() ;
    friend std::ostream &operator<<(std::ostream &os, const hasDMA &hs);
};


/*class ABC methods*/
ABC::ABC()
{
    label=new char[1];
    label[0]='\0';
    rating=0;
}

ABC::ABC(const char *l, int r)
{
    int len=std::strlen(l);
    label=new char[len+1];
    std::strcpy(this->label,l);
    rating=r;

}
ABC::ABC(const ABC & rs)
{
    int len=std::strlen(rs.label);
    label=new char[len+1];
    std::strcpy(this->label,rs.label);
    rating=rs.rating;
}

ABC::~ABC()
{
    delete [] label;
}

ABC & ABC::operator=(const ABC &rs)
{
    if(this==&rs)
      return *this;
    delete [] label;

    std::strcpy(this->label,rs.label);
    rating=rs.rating;

    return *this;

}

std::ostream &operator<<(std::ostream &os, const ABC &rs)
{
    os<<"label: "<<rs.label<<"   ,rating: "<<rs.rating<<std::endl;
    return os;
}
void ABC::view()
{
    std::cout<<"label: "<<label<<",rating:  "<<rating<<endl;
}


/*class baseDMA methods*/
baseDMA::baseDMA():ABC() {}

baseDMA::baseDMA(const char *l, int r):ABC(l,r){}

baseDMA::baseDMA(const baseDMA &rs):ABC(rs){}

baseDMA::~baseDMA() {}

baseDMA &baseDMA::operator=(const baseDMA &rs)
{
    if (this == &rs)
    {
        return *this;
    }
    ABC::operator=(rs);
    return *this;
}
std::ostream &operator<<(std::ostream &os, const baseDMA &rs)
{
    os<<(const ABC &)rs;
    return os;
}
void baseDMA::view()
{
    ABC::view();
}

/*class lackDMA methods*/
lackDMA::lackDMA():ABC(){}

lackDMA::lackDMA(const char *c, const char *l, int r) :ABC(l, r)
{
    //int len=std::strlen(c);
    std::strcpy(color, c);
    //color[0] = '\0';
}
lackDMA::lackDMA(const char *c, const ABC &rs) : ABC(rs)
{
    std::strcpy(color, c);

}
std::ostream &operator<<(std::ostream &os, const lackDMA &ls)
{
    os << (const ABC &)ls;
    os << "color: " << ls.color << endl;
    return os;
}

void lackDMA::view()
{
    ABC::view();
    std::cout<<"color: "<<color<<endl;

}

/*class hasDMA methods*/
hasDMA::hasDMA():ABC()
{
    style=new char[1];
    style[0]='\0';
}

hasDMA::hasDMA(const char *s, const char *l, int r) : ABC(l, r)
{
    style = new char[std::strlen(s) + 1];
    std::strcpy(style,s);
}
hasDMA::hasDMA(const char *s, const ABC &rs) : ABC(rs)
{
    style = new char[std::strlen(s) + 1];
    std::strcpy(style,s);
}
hasDMA::hasDMA(const hasDMA &hs) : ABC(hs)
{
    style = new char[std::strlen(hs.style) + 1];
    std::strcpy(style,hs.style);
}
hasDMA::~hasDMA() { delete[] style; }

hasDMA &hasDMA::operator=(const hasDMA &hs)
{
    if (this == &hs)
    {
        return *this;
    }
    ABC::operator=(hs);
    delete[] style;
    style = new char[strlen(hs.style) + 1];
    std::strcpy(style,hs.style);
    return *this;
}
std::ostream &operator<<(std::ostream &os, const hasDMA &hs)
{
    os << (const ABC &)hs;
    os << "Style: " << hs.style << endl;
    return os;
}

void hasDMA::view()
{
    ABC::view();
    std::cout<<"style: "<<style<<endl;
}


/*main methods*/
int main(int argc, const char *argv[])
{
    ABC *p_ABC[ARR_SIZE];
    char temp[40];
    int tempnum;
    int kind;
    for (int i = 0; i < ARR_SIZE; i++)
    {
        cout << "Enter label: ";
        cin.getline(temp, 40);
        cout << "Enter Rating: ";
        cin >> tempnum;
        cout << "Enter 1 for baseDMA or 2 for lacksDMA or 3 for hasDMA: ";
        while (cin >> kind && (kind != 1 && kind != 2 && kind != 3))
        {
            cout << "Enter either 1 or 2 or 3: ";
        }
        cin.get();
        if (kind == 1)
        {
            p_ABC[i] = new baseDMA(temp, tempnum);
        }
        else if (kind == 2)
        {
            char color[40];
            cout << "Enter the color: ";
            cin.getline(color, 40);
            p_ABC[i] = new lackDMA(color, temp, tempnum);
        }
        else if (kind == 3)
        {
            char style[40];
            cout << "Enter the style: ";
            cin.getline(style, 40);
            p_ABC[i] = new hasDMA(style, temp, tempnum);
        }
    }
    cout << endl;
    for (int i = 0; i < ARR_SIZE; i++)
    {
        p_ABC[i]->view();
        cout << endl;
    }
    for (int i = 0; i < ARR_SIZE; i++)
    {
        delete p_ABC[i];
    }
    cout << "Done." << endl;
    return 0;
}
