package cache;

import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    LRUCache<String, Integer> cache = new LRUCache<>(3);
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    do {
      System.out.println("1. Put");
      System.out.println("2. Get");
      System.out.println("3. Print");
      System.out.println("4. Exit");

      System.out.println("Enter Choice");
      choice = scanner.nextInt();

      switch (choice) {
        case 1: {
          System.out.println("Enter key");
          scanner.nextLine();
          String key = scanner.nextLine();
          System.out.println("Enter Value");
          Integer val = scanner.nextInt();

          cache.add(key, val);
          break;
        }
        case 2: {
          System.out.println("Enter key");
          scanner.nextLine();
          String key = scanner.nextLine();

          System.out.println(cache.get(key));
          break;
        }
        case 3: {
          cache.print();
          break;
        }
        case 4:
        default: {
          System.out.println("Closing...");
          break;
        }
      }
    } while (choice > 0 && choice < 5);
  }
}
