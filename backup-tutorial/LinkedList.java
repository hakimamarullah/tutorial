
public class LinkedList<T>{
	Node<T> header;
	Node<T> last;
	int size;
	public static void main(String[] args){
		LinkedList<Double> ll= new LinkedList<Double>();
		ll.addLast(11.2);
		ll.addLast(12.3);
		ll.addLast(5.0);
		ll.clear();
		ll.addLast(3.0);
		ll.print();
		System.out.println(ll.size());
	}

	public LinkedList(){
		header = new Node<T>(null);
		last = header;
	}

	private void addLast(T data){
		Node<T> tmp = new Node<T>(data);
		if(header == last){
			header.next = tmp;
			last = tmp;
		}
		else{
			last.next = tmp;
			last = tmp;
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

	 	if(current != null && current.data.equals(data)){
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

	Node(T data){
		this.data = data;
	}

	Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
}