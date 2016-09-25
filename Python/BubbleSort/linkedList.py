from node import*

class LinkedListIter(object):
  def __init__(self, lst):
    self.current = lst.first

  def __iter__(self):
    return self

  def next(self):
    if self.current is None: raise StopIteration
    item = self.current.item
    self.current = self.current.next;
    return item


class LinkedList(object):

  def __init__(self):
    self.first = None
    self.N = 0

  def __iter__(self):
    return LinkedListIter(self)

  def __repr__(self):
    s = '['
    for item in self:
      s += '{},'.format(item)
    return s[:-1] + ']'

  def size(self):
    return self.N

  def is_empty(self):
    return self.first is None

  def add(self, item):
    self.first = Node(item, self.first)
    self.N += 1
  
  def bubbleSort(self):
    while True:
      prv, cur, nxt = None, self.first, self.first.next
      done = False
      while nxt is not None:
        if cur > nxt:
          done = True
          if prv is None:
            self.first = nxt
          else:
            prv.next = nxt
          cur.next = nxt.next
          nxt.next = cur
          prv = nxt
          nxt = cur.next
        else:
          prv = cur
          cur = nxt
          nxt = nxt.next
      if not done: break