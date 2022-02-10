public class LinkedList<T>{
	Node<T> header;
	Node<T> last;
	int size;

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(2);
		ll.add(4);
		ll.add(3);
		
		ll.print();
	}
	public LinkedList(){
		this.header = new Node<T>(null);
		last = header;
	}

	public void add(T data){
		Node<T> tmp = new Node<T>(data);

		if(header.next == null){
			header.next = tmp;
			last = tmp;
		}
		else{
			last.next = tmp;
			//last = tmp;
		}
		size++;

	}

	public int size(){
		return this.size;
	}

	public void clear(){
		header.next = null;
		last = header;
	}

	public boolean isEmpty(){
		return header.next == null;
	}

	public boolean remove(T data){
		Node<T> current = header.next;
		Node<T> prev = null;

		if(current.data.equals(data)){
			header.next = current.next;
			size--;
			return true;
		}

		while(current != null && !current.data.equals(data)){
			prev = current;
			current = current.next;
		}

		if(current == null){
			return false;
		}

		if(current.equals(last)){
			prev.next = null;
			last = prev;
		}
		else{
			prev.next = current.next;

		}
		size--;
		return true;
	}

	public void print(){
		Node<T> current = header.next;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();

	}
}

class Node<T>{
	Node<T> next;
	T data;

	public Node(T data){
		this.data = data;
	}

	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}

}
