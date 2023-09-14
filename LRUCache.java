package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<Key, Value> {
  // get value
  // put value

  private final Integer capacity;
  private Integer size;

  private Map<Key, DoublyLinkedListNode<Key, Value>> storage;

  private DoublyLinkedList<Key, Value> doublyLinkedList;

  public LRUCache(Integer capacity) {
    this.capacity = capacity;
    this.storage = new HashMap<>();
    this.doublyLinkedList = new DoublyLinkedList<>();
    this.size = 0;
  }

  public void add(Key key, Value value) {
    // add value
    // if cache is not full
    // else evict then add
    // move to front

    if (storage.containsKey(key)) {
      DoublyLinkedListNode<Key, Value> node = storage.get(key);
      node.value = value;
      doublyLinkedList.detachNode(node);
      doublyLinkedList.addNodeAtRear(node);
      storage.put(key, node);
    } else {
      if (size == capacity) {
        DoublyLinkedListNode<Key, Value> evictNode = doublyLinkedList.getFrontNode();
        if (evictNode == null) {
          return;
        }

        doublyLinkedList.detachNode(evictNode);
        storage.remove(evictNode.key);
        size--;
        System.out.println("Evicting! Making Space! " + evictNode.key + " " + evictNode.value);
      }

      DoublyLinkedListNode<Key, Value> newNode = new DoublyLinkedListNode<>(key, value);
      doublyLinkedList.addNodeAtRear(newNode);
      storage.put(key, newNode);
      size++;
    }
  }

  public Value get(Key key) {
    DoublyLinkedListNode<Key, Value> node = storage.get(key);
    if (node == null) {
      return null; // can throw BadRequestException
    }

    doublyLinkedList.detachNode(node);
    doublyLinkedList.addNodeAtRear(node);
    return node.value;
  }

  public void print() {
    doublyLinkedList.print();
  }
}
