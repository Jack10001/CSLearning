#include <iostream>
#include <ctime>
#include <string>
#include <cstdlib>
const int MIN_PER_HR = 60; //每小时的分钟数
bool newcustomer(double x);
using namespace std;

class Customer
{
  private:
    long arrive;     //到达的时间
    int processtime; //处理业务的时间
  public:
    Customer() { arrive = processtime = 0; }
    void set(long when);
    long when() const { return arrive; }
    int ptime() const { return processtime; }
};

typedef Customer Item;
class Queue
{
  private:
    struct Node
    {
        Item item;
        struct Node *next;
    };
    enum
    {
        Q_SIZE = 10
    };
    Node *front;
    Node *rear;
    int items;
    const int qsize;
    Queue(const Queue &q) : qsize(0) {}
    Queue &operator=(const Queue &q) { return *this; }

  public:
    Queue(int qs = Q_SIZE);
    ~Queue();
    bool isempty() const;
    bool isfull() const;
    int queuecount() const;
    bool enqueue(const Item &item);
    bool dequeue(Item &item);
};

Queue::Queue(int qs) : qsize(qs)
{
    front = rear = NULL;
    items = 0;
}
Queue::~Queue()
{
    Node *temp;
    while (front != NULL)
    {
        temp = front;
        front = front->next;
        delete temp;
    }
}
bool Queue::isempty() const { return items == 0; }
bool Queue::isfull() const { return items == qsize; }
int Queue::queuecount() const { return items; }
bool Queue::enqueue(const Item &item)
{
    if (isfull())
    {
        return false;
    }
    Node *add = new Node;
    add->item = item;
    add->next = NULL;
    items++;
    if (front == NULL)
    {
        front = add;
    }
    else
    {
        rear->next = add;
    }
    rear = add;
    return true;
}
bool Queue::dequeue(Item &item)
{
    if (front == NULL)
    {
        return false;
    }
    item = front->item;
    items--;
    Node *temp = front;
    front = front->next;
    delete temp;
    if (items == 0)
    {
        rear = NULL;
    }
    return true;
}
void Customer::set(long when)
{
    processtime = std::rand() % 3 + 1;
    arrive = when;
}

/*
int main(int argc, const char *argv[])
{
    srand(time(0)); //随机数种子
    cout << "Case Study: Bank of Heather Automatic Teller\n";
    cout << "Enter maximum size of queue: ";
    int qs; //队列最大长度
    cin >> qs;
    Queue line(qs);
    cout << "Enter the number of simulation hours: ";
    int hours; //模拟的小时数
    cin >> hours;
    int cyclelimit = MIN_PER_HR * hours; //总分钟数限制
    cout << "Enter the average number of customers per hour: ";
    double perhour; //每小时接收的客人
    cin >> perhour;
    double min_per_cust = MIN_PER_HR / perhour;
    Item temp;
    int turnaways = 0; //来了没处理就离开的人
    int customers = 0; //客户数
    int served = 0;    //已经服务过的客户数
    int sum_line = 0;  //队列总长度
    int wait_time = 0; //正在处理业务时间
    int line_wait = 0; //总的等待时间
    for (int cycle = 0; cycle < cyclelimit; ++cycle)
    {
        if (newcustomer(min_per_cust))
        { //有客户来了
            if (line.isfull())
            {
                turnaways++; //队伍满了，离开
            }
            else
            {
                customers++; //增加客户
                temp.set(cycle);
                line.enqueue(temp); //加入队列
            }
        }
        if (wait_time <= 0 && !line.isempty())
        {
            line.dequeue(temp); //处理客户
            wait_time = temp.ptime();
            line_wait += (cycle - temp.when()); ////首先用当前分钟数减去客户到达时分钟数，得到等待分钟数，并累加。
            served++;                         //服务的客户加1
        }
        if (wait_time > 0)
        {
            wait_time--; //每分钟减1
        }
        sum_line += line.queuecount(); //这分钟正在等待的人数
    }
    if (customers > 0)
    {
        cout << "customers accepted: " << customers << endl;
        cout << "customers served: " << served << endl;
        cout << "turnsways: " << turnaways << endl;
        cout << "average queue size: ";
        cout.precision(2);
        cout.setf(ios_base::fixed, ios_base::floatfield);
        cout << (double)sum_line / cyclelimit << endl;
        cout << "average wait time: " << (double)line_wait / served << " minutes\n";
    }
    else
    {
        cout << "No customers!\n";
    }
    cout << "Done!\n";
    return 0;
}*/
int main(int argc, const char *argv[])
{
    srand(time(0)); //随机数种子
    cout << "Case Study: Bank of Heather Automatic Teller\n";
    cout << "Enter maximum size of queue: ";
    int qs; //队列最大长度
    cin >> qs;
    cout << "Enter the number of simulation hours: ";
    int hours; //模拟的小时数
    cin >> hours;
    int cyclelimit = MIN_PER_HR * hours; //总分钟数限制
    Item temp;
    int lastturnaways = 0; //来了没处理就离开的人
    int lastcustomers = 0; //客户数
    int lastserved = 0;    //已经服务过的客户数
    int lastsum_line = 0;  //队列总长度
    int lastline_wait = 0; //总的等待时间
    double perhour = 1;    //每小时接收的客人
    while (true)
    {
        Queue line(qs); //队列应该放这里...
        double min_per_cust = MIN_PER_HR / perhour;
        int turnaways = 0; //来了没处理就离开的人
        int customers = 0; //客户数
        int served = 0;    //已经服务过的客户数
        int sum_line = 0;  //队列总长度
        int line_wait = 0; //总的等待时间
        int wait_time = 0; //正在处理业务时间
        for (int cycle = 0; cycle < cyclelimit; ++cycle)
        {
            if (newcustomer(min_per_cust))
            { //有客户来了
                if (line.isfull())
                {
                    turnaways++; //队伍满了，离开
                }
                else
                {
                    customers++; //增加客户
                    temp.set(cycle);
                    line.enqueue(temp); //加入队列
                }
            }
            if (wait_time <= 0 && !line.isempty())
            {
                line.dequeue(temp); //处理客户
                wait_time = temp.ptime();
                line_wait += cycle - temp.when(); //等待时间
                served++;                         //服务的客户加1
            }
            if (wait_time > 0)
            {
                wait_time--; //每分钟减1
            }
            sum_line += line.queuecount(); //这分钟正在等待的人数
        }
        if ((double)line_wait / served > 1)
        {
            break;
        }
        else
        {
            lastturnaways = turnaways;
            lastcustomers = customers;
            lastserved = served;
            lastsum_line = sum_line;
            lastline_wait = line_wait;
            perhour++;
        }
    }
    if (lastcustomers > 0)
    {
        cout << "customers per hour: " << perhour << endl;
        cout << "customers accepted: " << lastcustomers << endl;
        cout << "customers served: " << lastserved << endl;
        cout << "turnsways: " << lastturnaways << endl;
        cout << "average queue size: ";
        cout.precision(2);
        cout.setf(ios_base::fixed, ios_base::floatfield);
        cout << (double)lastsum_line / cyclelimit << endl;
        cout << "average wait time: " << (double)lastline_wait / lastserved << " minutes\n";
    }
    else
    {
        cout << "No customers!\n";
    }
    cout << "Done!\n";
    return 0;
}

//判断客户是否到来
bool newcustomer(double x) { return (rand() * x / RAND_MAX < 1); }
