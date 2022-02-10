
public class DoublyLinkedList<T>{
	Node<T> header;
	Node<T> last;
	int size;
	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll= new DoublyLinkedList<Integer>();
		for(int i=0; i<10; i++){
			ll.addLast(i);
		}
		ll.printReverse();
		System.out.println(ll.size());
	}

	public DoublyLinkedList(){
		header = new Node<T>(null);
		last = header;
	}

	private void addLast(T data){
		Node<T> tmp = new Node<T>(data);
		if(header.next == null){
			header.next = tmp;
			tmp.prev = header;
			last = tmp;
		}
		else{
			last.next = tmp;
			tmp.prev = last;
			last = tmp;
		}
		size++;
	}

	public boolean remove(T data){
		Node current = header.next;
		while(current != null){
			if(current.data == data){
				if(current == last){
					last = last.prev;
					last.next = null;
					
				}
				else if(current != last){

					Node tmp = current.prev;
					tmp.next = current.next;
					tmp.next.prev = tmp;
					current = null;
					
				}
				size--;
				return true;
				
			}
			else if(current == last)
				return false;
			current = current.next;
		}
		return false;
	}

	public int size(){
		return this.size;
	}

	public void printReverse(){
		Node current = last;
		while(current != null && current != header){
			System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println();
	}

}

class Node<T>{
	Node next;
	Node prev;
	T data;

	Node(T data){
		this.data = data;
	}

	Node(T data, Node next, Node prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}