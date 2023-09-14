package cache;

public class DoublyLinkedListNode<Key, Value> {

  Key key;
  Value value;
  DoublyLinkedListNode<Key, Value> prev;
  DoublyLinkedListNode<Key, Value> next;

  public DoublyLinkedListNode(Key key, Value value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}
