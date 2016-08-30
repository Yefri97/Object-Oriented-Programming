#include <iostream>
#include "queue.h"

void Queue::push(int x) {
  Node* new_node(x);
  if (is_empty())
    first = last = new_node;
  else {
    last->next = new_node;
    last = new_node;
  }
}

int Queue::front(void) {
  if (is_empty()) return -1;
  return first->item;
}

void Queue::pop(void) {
  if (is_empty()) return;
  first = first->next;
}