public class LinkedList<T> implements List<T>{
	public class Node {
		T data; //data type to store
		Node next; //Node object to point to the next Node

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public void setNode(Node node) {
			this.next = node; //pointing to another node
		}
	}

	/*These are private global variables*/
	private Node head;
	private int size;

	/*This is the constructor*/
	public LinkedList() {
		this.head = null; //refers to the classes global variables
		this.size = 0;
	}

	/*
	 * The function adds an item to the last node in the linked list.
	 *
	 * @param item. Item that will be added to the end of the linked list
	 *  */
	public void add(T item) {
		Node current = this.head;
		Node newNode = new Node(item);

		//Checks if the linked list is empty. If it is, the new node added will be the head.
		if (current == null) {
			this.head = newNode;
			this.size++;
			return;
		}

		//Iterate through the linked list until it reaches null
		while (current.next != null) {
			current = current.next;
		}

		//Adds node at the end of the linked list
		current.setNode(newNode);
		this.size++;
	}

	/*
	 * The function adds an node to the linked list at a specific position.
	 *
	 * @param pos. The specific location that the item will be added to in the linked list
	 * @param item. The item that will be added to the linked list.
	 * */
	public void add(int pos, T item) {
		//if statement checks if the position exists in the array
		 if(this.size < pos || pos < 0){
		 	return;
		 }

		Node newNode = new Node(item);

		if (pos == 0) {
			newNode.next = this.head;
			this.head = newNode;
			this.size++;

			return;
		}

		Node current = this.head.next;
		Node previous = this.head;

		for (int i = 1; i <= this.size; i++) { //goes through the LinkedList
			if (i == pos) {
				previous.next = newNode;
				newNode.next = current;
				this.size++;

				return;
			}

			previous = current;
			current = current.next; //moves to the next Node

		}
	}

	/*
	 * The function returns the data that was stored in that position in the linked list.
	 *
	 * @param pos. The position's value that will be returned.
	 * */
	public T get(int pos) {
		/*The big boy stuff*/
		Node current = this.head;

		for (int i = 0; i < this.size; i++) { //goes through the LinkedList
			if (i == pos) {
				return current.data;
			}

			current = current.next; //moves to the next Node

		}

		return (T) "Position not found in LinkedList"; //error checking in case things didnt go as plan
	}


	/*
	 * The function removes a position in the linked list. The linked list then decrements in size and
	 * every item from the right of that position shifts to the left by one.
	 *
	 * @param pos. The position that will get removed
	 * */
	public T remove(int pos) {
		if (pos == 0) {
			Node current = this.head;//current.next;
			this.head = this.head.next;
			this.size--;

			return current.data;
		}

		/*The big boy stuff*/
		Node current = this.head.next;
		Node previous = this.head;

		for (int i = 1; i <= pos; i++) { //goes through the LinkedList
			if (i == pos) {
				previous.next = current.next;
				this.size--;
				return current.data;
			}
				previous = current;
				current = current.next; //moves to the next Node

		}
			return (T) "Position not found in LinkedList";

	}

	/*
	 * The function returns the size of the linked list
	 * */
	public int size() {
		return this.size;
	}
}