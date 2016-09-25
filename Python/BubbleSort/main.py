from linkedList import*

if __name__ == '__main__':
  l = LinkedList()
  for i in range(0, 10):
    l.add(i)
  print l
  l.bubbleSort()
  print l
  print "\n---------------------\n"
  l = LinkedList()
  for i in range(0, 10):
    l.add((i * 3 + 2) % 10)
  print l
  l.bubbleSort()
  print l

  