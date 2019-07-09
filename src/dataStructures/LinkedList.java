package dataStructures;
import java.util.*;

public class LinkedList {
	static Node head;
	
	public static void main (String[] args) {
		System.out.println("Enter the size of Linked List");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		addValue(size);
		selectOptions();
		sc.close();
	}
	
	public static void selectOptions() {
		System.out.println("Select the options from below to perform your task");
		System.out.println(	"1. To print the Linked List"+'\n'+
							"2. To add a new element to the Linked List"+'\n'+
							"3. To delete an element from the Linked List");
		System.out.println();
		Scanner sc1 = new Scanner(System.in);
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
				System.out.println(value+" "+position);
				//addNewElement(value,position);
				break;
			case 3:
				System.out.print("Enter the position from where the value is to be deleted : ");
				position = sc1.nextInt();
				System.out.println();
				//deleteElement(position);
				break;
			default:
				System.out.println("Please Enter the correct option as mentioned above");
				break;
		}
		sc1.close();
	}
	
	public static void addValue(int size) {
		LinkedList llist = new LinkedList();
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
}
