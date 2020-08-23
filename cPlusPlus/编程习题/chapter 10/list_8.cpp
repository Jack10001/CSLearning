#include <iostream>
#include <cstring>
#include <string>
using namespace std;
typedef int Item;
class List
{
  private:
    enum
    {
        MAX = 5
    };
    Item items[MAX];
    int top = 0;

  public:
    List();
    bool isempty() const;
    bool isfull() const;
    bool add(const Item &item);
    void visit(void (*pf)(Item &item));
    void showitem() const;
};
void plus100(Item &item);

List::List()
{
    top = 0;
}
bool List::isempty() const
{
    return top == 0;
}
bool List::isfull() const
{
    return top == MAX;
}
bool List::add(const Item &item)
{
    if (top < MAX)
    {
        items[top++] = item;
        return true;
    }
    else
        return false;
}

void List::visit(void (*pf)(Item &item))
{
    for (int i = 0; i < top; i++)
    {
        pf(items[i]);
    }
}

void List::showitem() const
{
    for (int i = 0; i < top; i++)
    {
        std::cout << "#" << i + 1 << ": " << items[i] << std::endl;
    }
}
void plus100(Item &item) { item += 100; }

int main()
{
    cout << "Please enter C to add item to your list, P to process the list, S to show the items, Q to quit:\n";
    char ch;
    List l;
    int data;
    while (cin >> ch && toupper(ch) != 'Q')
    {
        while (cin.get() != '\n')
            continue;
        if (!isalpha(ch))
        {
            cout << "\a";
            continue;
        }
        switch (ch)
        {
        case 'C':
        case 'c':
            if (l.isfull())
                cout << "The list already full.\n";
            else
            {
                cout << "Enter the data: ";
                cin >> data;
                l.add(data);
            }
            break;

        case 'P':
        case 'p':
            if (l.isempty())
                cout << "The list already empty.\n";
            else
            {
                l.visit(plus100);
                cout << "Every data has plused 100.\n";
            }
            break;
        case 'S':
        case 's':
            l.showitem();
            break;
        }
        cout << "Please enter C to add item to your list, P to process the list, Q to quit:\n";
    }
    l.showitem();
    cout << "Bye!\n";
    return 0;
}
