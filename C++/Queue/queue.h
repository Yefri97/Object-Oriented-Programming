#ifndef _QUEUE_H_
#define _QUEUE_H_

class Queue {
  public:
    Queue(): first_(NULL), last_(NULL), size_(0) {}
    void push(int);
    int front(void);
    void pop(void);
    bool is_empty(void) { return (first_ == NULL); }
    int size(void) { return size_; }
  private:
    class Node {
      public:
        Node(int item): item_(item), next_(NULL) {}
        int item_;
        Node* next_;
    };
  private:
    Node* first_;
    Node* last_;
    int size_;
};

#endif