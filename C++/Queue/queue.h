#ifndef _QUEUE_H_
#define _QUEUE_H_

class Queue {
  public:
    Queue(): first(NULL), last(NULL), size_(0) {}
    void push(int);
    int front(void);
    void pop(void);
    bool is_empty(void) { return (first == last); }
    int size(void) { return size_; }
  private:
    class Node {
      public:
        Node(int item_): item(item_), next(NULL) {}
      private:
        int item;
        Node* next;
    };
  private:
    Node* first;
    Node* last;
    int size_;
};

#endif