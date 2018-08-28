#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
struct Books {
	int ratings;
	std::string title;
};

bool FullReview(Books & rr);
void showBooks(const Books & rr);
int main()
{
	using namespace std;
	using std::vector;
	vector<Books> books;
	vector<Books>::iterator pd;
 	Books temp;
	while (FullReview(temp))
		books.push_back(temp);
	int nums = books.size();
	//show input data
	cout << "ratings  title\n";
	//use for_each , random_shuffle(), sort()
 /*	for (pd = books.begin(); pd != books.end(); pd++)
		showBooks(*pd);*/

	for_each(books.begin(), books.end(), showBooks);
	//use size(),end(),begin(),push_back(),erase(),insert()

	if (nums > 0)
	{
		//delete 2 items, use erase()
		books.erase(books.begin() + 1, books.begin() + 3);
		cout << "\nafter delete 2 item:\n";
		cout << "ratings  title\n";
		for (pd = books.begin(); pd != books.end(); pd++)
			showBooks(*pd);
	}
	if (nums > 3)
	{
		//insetr 1 item, use insert(新插入的位置，第二个第三个迭代器参数定义了被插入的区间，该区间通常是另一个容器对象的一部分)
		vector<Books> new_insert;
		vector<Books>::iterator n_pd;
		//while (FullReview(temp))
		cout << "enter data you want to insetr:\n";
		cout << "title:";
		cin >> temp.title;
		cout << "ratings:";
		cin >> temp.ratings;
		while (cin.get() != '\n')
			continue;
		new_insert.push_back(temp);
		books.insert(books.begin(), new_insert.begin(), new_insert.end());
		cout << "\nafter insert 1 item:\n";
		cout << "ratings  title\n";
		for (pd = books.begin(); pd != books.end(); pd++)
			showBooks(*pd);
	}
	system("pause");
}

bool FullReview(Books & rr)
{
	std::cout << "enter books' title:(quit to quit)\n";
	std::cin >> rr.title;
	if (rr.title == "quit")
		return false;
	std::cout << "enter books' ratings:\n";
	std::cin >> rr.ratings;
	if (!std::cin)
		return false;
	while (std::cin.get() != '\n')
		continue;
	return true;
}

void showBooks(const Books & rr)
{
	std::cout << rr.ratings << "          " << rr.title << std::endl;
}