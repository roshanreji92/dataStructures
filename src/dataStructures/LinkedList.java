package dataStructures;
import java.util.*;

public class LinkedList {
	static Node head;
	static Node tail;
	static int size;
	public static void main (String[] args) {
		System.out.println("Enter the size of Linked List");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		addValue(size);
		selectOptions();
		sc.close();
	}
	
	public static void selectOptions() {
		Scanner sc1 = new Scanner(System.in);
		while (true) {
			System.out.println ("Do you wish to continue?");
			System.out.println("Press y or n : ");
			char yesno = sc1.next().charAt(0);
			
			if(yesno == 'n' || yesno == 'N') {
				System.out.println("Exiting...");
				break;
			}
			else if (yesno == 'y' || yesno == 'Y') {
				System.out.println("Select the options from below to perform your task");
				System.out.println(	"1. To print the Linked List"+'\n'+
									"2. To add a new element to the Linked List"+'\n'+
									"3. To delete an element from the Linked List");
				System.out.println();
				int option = sc1.nextInt();
				int position,value;
				switch (option){
					case 1:
						traverseLinkedList();
						break;
					case 2:
						System.out.println("Enter the value and the position where the new entry is to be inserted");
						System.out.print("Value : ");
						value = sc1.nextInt();
						System.out.println();
						System.out.print("Position : ");
						position = sc1.nextInt();
						System.out.println();
						System.out.println("Linked List before inserting the element");
						traverseLinkedList();
						insertValue(value,position);
						System.out.println("Linked List after inserting the element");
						traverseLinkedList();
						break;
					case 3:
						System.out.print("Enter the position from where the value is to be deleted : ");
						position = sc1.nextInt();
						System.out.println("Linked List before deleting the element");
						traverseLinkedList();
						deleteValue(position);
						System.out.println("Linked List after deleting the element");
						traverseLinkedList();
						break;
					default:
						System.out.println("Please Enter the correct option as mentioned above");
						break;
				}
			}
			else {
				System.out.println("Invalid Entry");
				break;
			}
		}
		//sc1.close();
	}
	
	public static void addValue(int size) {
		//LinkedList llist = new LinkedList();
		System.out.println("Enter the head of the Linked List");
		Scanner sc2 = new Scanner (System.in);
		int hd = sc2.nextInt();
		LinkedList.head = new Node(hd);
		
		Node current = head; 
		System.out.println("Enter the Values of Linked List");
		for(int i =1 ; i<size; i++) {
			if (i == (size-1)) {
				System.out.println ("Last Entry of the Linked List");
			}
			int val = sc2.nextInt();
			Node temp = new Node(val);
			current.next = temp;
			current = temp;
		}
		tail = current;
		//sc2.close();
	}
	
	public static void traverseLinkedList() {
		Node current = head;
		System.out.println("The Elements of Linked List:");
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void insertValue(int value, int position) {
		Node current = head;
		if (position==(size+1)) {
			current = tail;
			Node temp = new Node(value);
			current.next = temp;
			tail = temp;
		}
		
		else if (position == 1) {
			Node temp = new Node(value);
			head = temp;
			head.next = current;
		}
		else {
			int counter = 1;
			while (counter<position) {
				if(counter == (position-1)) {
					Node temp = current.next;
					Node newValue = new Node(value);
					current.next = newValue;
					newValue.next = temp;
				}
				current = current.next;
				counter++;
			}
		}
	}
	
	public static void deleteValue(int position) {
		Node current = head;
		if(position == 1) {
			head = current.next;
		}
		else {
			int counter = 1;
			while(counter<position) {
				if(counter == position-1) {
					current.next = current.next.next;
					if(counter == size - 1) {
						tail = current;
					}
				}
				current = current.next;
				counter++;
			}
			
		}
	}
}
