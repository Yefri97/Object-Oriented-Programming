#include <iostream>
#include "queue.h"

void Queue::push(int x) {
  Node* node = new Node(x);
  if (is_empty())
    first_ = last_ = node;
  else {
    last_->next_ = node;
    last_ = node;
  }
  size_++;
}

int Queue::front(void) {
  if (is_empty()) return -1;
  return first_->item_;
}

void Queue::pop(void) {
  if (first_ == last_)
    first_ = last_ = NULL;
  else 
    first_ = first_->next_;
  size_--;
}