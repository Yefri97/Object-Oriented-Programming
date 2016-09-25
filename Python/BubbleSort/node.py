class Node(object):

  def __init__(self, item, next):
    self.item = item
    self.next = next

  def __repr__(self):
    return self.item

  def __lt__(self, other):
    if other is None: return False
    if not isinstance(other, self.__class__): return False
    return self.item < other.item

  def __eq__(self, other):
    if other is None: return False
    if not isinstance(other, self.__class__): return False
    return self.item == other.item
