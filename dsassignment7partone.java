// Name: Chidera Anamege
// Class: CS 3305
// Term:Spring 2024
//	Instructor:  Carla McManus
//	Assignment:  7-Part-1-Sorting
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list

    public Node(int data) {
        this.data = data; // Set data for the node
        this.next = null; // Initially, there's no next node
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int newData) {
        Node newNode = new Node(newData); // Create a new node with given data
        if (head == null) {
            head = newNode; // If list is empty, make new node as head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Method to display all elements in the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " "); // Print data of current node
            current = current.next;
        }
        System.out.println();
    }

    // Method to perform merge sort on the list
    public Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node middle = getMiddle(head); // Find the middle node
        Node nextOfMiddle = middle.next; // Next of middle node
        middle.next = null;

        Node left = mergeSort(head); // Recursively sort the left half
        Node right = mergeSort(nextOfMiddle); // Recursively sort the right half

        return merge(left, right); // Merge the sorted halves
    }

    // Method to merge two sorted lists
    public Node merge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b; // If first list is empty, return the second list
        if (b == null)
            return a; // If second list is empty, return the first list

        if (a.data <= b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result; // Return the merged list
    }

    // Method to find the middle node of the list
    public Node getMiddle(Node head) {
        if (head == null)
            return head; // If list is empty, return null

        Node fastPointer = head.next;
        Node slowPointer = head;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next; // Move fast pointer two steps at a time
            }
        }
        return slowPointer; // Return the middle node
    }
}

public class dsassignment7partone {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Given elements hard-coded
        linkedList.insert(1009);
        linkedList.insert(21);
        linkedList.insert(3);
        linkedList.insert(55);
        linkedList.insert(2022);
        linkedList.insert(24);
        linkedList.insert(99);
        linkedList.insert(501);
        linkedList.insert(105);
        linkedList.insert(98);
        linkedList.insert(178);
        linkedList.insert(245);
        linkedList.insert(0);
        linkedList.insert(3305);
        linkedList.insert(990);
        linkedList.insert(76);
        linkedList.insert(373);
        linkedList.insert(1010);
        linkedList.insert(642);
        linkedList.insert(777);

        System.out.println("Original list:");
        linkedList.display(); // Display original list

        linkedList.head = linkedList.mergeSort(linkedList.head); // Perform merge sort

        System.out.println("\nSorted list:");
        linkedList.display(); // Display sorted list
    }
}
