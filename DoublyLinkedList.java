package cache;

public class DoublyLinkedList<Key, Value> {

  DoublyLinkedListNode<Key, Value> front;

  DoublyLinkedListNode<Key, Value> rear;

  public DoublyLinkedList() {
    this.front = new DoublyLinkedListNode<>(null, null);
    this.rear = new DoublyLinkedListNode<>(null, null);

    this.front.next = this.rear;
    this.rear.prev = this.front;
  }

  public void detachNode(DoublyLinkedListNode<Key, Value> node) {
    // insert nodes in between front and rear nodes
    if (node != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }

  public void addNodeAtRear(DoublyLinkedListNode<Key, Value> node) {
    if (node != null) {
      rear.prev.next = node;
      node.prev = rear.prev;
      node.next = rear;
      rear.prev = node;
    }
  }


  public DoublyLinkedListNode<Key, Value> getFrontNode() {
    if (front.next == rear && rear.prev == front) {
      return null;
    }

    return front.next;
  }

  public void print() {
    DoublyLinkedListNode<Key, Value> temp = front;

    System.out.println("Key->Value");
    while (temp.next != rear) {
      System.out.print(temp.next.key + "->" + temp.next.value + ", ");
      temp = temp.next;
    }

    System.out.println();
  }
}
