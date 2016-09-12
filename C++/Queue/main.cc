#include <iostream>
#include "queue.h"

using namespace std;

int main() {
  Queue q;
  q.push(3);
  q.push(5);
  cout << "Front: " << q.front() << ", Size: " << q.size() << endl;
  q.pop();
  cout << "Front: " << q.front() << ", Size: " << q.size() << endl;
  q.pop();
  cout << "Front: " << q.front() << ", Size: " << q.size() << endl;
  q.push(1);
  cout << "Front: " << q.front() << ", Size: " << q.size() << endl;
  q.push(2);
  cout << "Front: " << q.front() << ", Size: " << q.size() << endl;
  return 0;
}