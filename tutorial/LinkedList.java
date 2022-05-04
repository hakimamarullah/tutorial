import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class TP2 {
    private static InputReader in;
    public static OutputStream outputStream = System.out;
    public static PrintWriter out = new PrintWriter(outputStream);
    public static BinaryTree pulau;
    public static LinkedList<Paket> paket = new LinkedList<Paket>();

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);

        int P = in.nextInt();
        pulau = new BinaryTree(P);
        for(int i=1; i<P+1; i++){
            int left = in.nextInt();
            int right = in.nextInt();
            pulau.insertLR(left,right,i);
        }

        int Q = in.nextInt();
        while(Q-- >0){
            int cmd = in.nextInt();
            if(cmd == 1){
                String nama = in.next();
                int kodePrioritas = in.nextInt();
                int pulauTujuan = in.nextInt();
                paket.add(new Paket(nama,kodePrioritas,pulauTujuan));

            }
        }

        paket.forEach(item-> System.out.println(item.getNama()));

    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

}
class Paket implements Comparable<Paket>{
    String nama;
    int kodePrioritas;
    int pulauTujuan;
    int distance;


    public Paket(String nama, int kodePrioritas, int pulauTujuan){
        this.nama = nama;
        this.kodePrioritas = kodePrioritas;
        this.pulauTujuan = pulauTujuan;
    }
    @Override
    public int compareTo(Paket o) {
        if(this.kodePrioritas > o.kodePrioritas)
            return 1;
        if(this.kodePrioritas < o.kodePrioritas)
            return -1;
        else if(this.distance > o.distance)
            return 1;
        else if(this.distance < o.distance)
            return -1;
        return 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKodePrioritas() {
        return kodePrioritas;
    }

    public void setKodePrioritas(int kodePrioritas) {
        this.kodePrioritas = kodePrioritas;
    }

    public int getPulauTujuan() {
        return pulauTujuan;
    }

    public void setPulauTujuan(int pulauTujuan) {
        this.pulauTujuan = pulauTujuan;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
class BinaryTree {
    private Node root;
    private Node[] pulau;
    private int[] distance;

    public BinaryTree(int size) {
        root = new Node(1);
        pulau = new Node[size+1];
        distance = new int[size+1];
        for(int i=1; i<size+1; i++) {
            pulau[i] = null;
            distance[i] = 0;
        }
        pulau[0] = new Node(0);
        pulau[1] = root;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    public int[] getDistance(){
        return this.distance;
    }

    public Node insert(int data, Node current) {
        if (current == null)
            current = new Node(data);
        if (data < current.getData())
            current.setLeft(insert(data, current.getLeft()));
        if (data > current.getData())
            current.setRight(insert(data, current.getRight()));
        else if (data == current.getData())
            return current;
        return current;

    }

    public Node insertNonRec(int data) {
        Node current = root;
        if (root == null) {
            root = new Node(data);
            return root;
        }

        Node parent = root;
        while (current != null) {
            parent = current;
            if (data == current.getData())
                return current;
            current = data > current.getData() ? current.getRight() : current.getLeft();
        }

        Node toInsert = new Node(data);
        if (data > current.getData())
            parent.setRight(toInsert);
        else
            parent.setLeft(toInsert);
        return toInsert;
    }

    public void insertLR(int left, int right, int parentNumber) {
        Node parent = search(parentNumber);
        Node newLeft = new Node(left);
        Node newRight = new Node(right);
        if (left != 0) {
            newLeft.parent = parent;
            pulau[left] = newLeft;
            setDistance(newLeft);
            parent.setLeft(newLeft);
        }
        if (right != 0){
            newRight.parent = parent;
            pulau[right] = newRight;
            setDistance(newRight);
            parent.setRight(newRight);
        }


    }

    int height() {
        return height(root);
    }

    int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.getLeft()) + 1, height(node.getRight()) + 1);
    }


    public Node removeMin() {
        return removeMin(root);
    }

    private Node removeMin(Node current) {
        if (current == null) {
            return null;
        } else if (current.getLeft() != null) {
            current.setLeft(removeMin(current.getLeft()));
            return current;
        } else
            return current.getRight();
    }

    public Node search(int data) {
        Node current = null;

        for(int i=1; i< pulau.length; i++){
            if(pulau[i] != null && pulau[i].getData() == data){
                current = pulau[i];
            }

        }
        return current;
    }

    public void setDistance(Node node){
        Node tmp = node.parent;
        int dist = 0;
        while(tmp != null){
            tmp = tmp.parent;
            dist++;
        }

        distance[node.getData()] = dist;
    }

    public void printInOrder() {
        if (root != null)
            root.printInOrder();
        System.out.println("");
    }


    public Node getRoot() {
        return root;
    }


}


class Node{
    Node left, right, parent;
    private int data;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public Node(int data) {
        this.data = data;
    }

    public void printInOrder() {
        if (left != null)
            left.printInOrder();

        System.out.print(data + " ");

        if (right != null)
            right.printInOrder();
    }

    public void preOrder() {
        System.out.print(data + " ");
        if (left != null)
            left.preOrder();

        if (right != null)
            right.preOrder();
    }

    public void postOrder() {
        if (left != null)
            left.postOrder();

        if (right != null)
            right.postOrder();
        System.out.print(data + " ");
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

}


class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private NodeLL<T> base, last;
    private int size;

    public LinkedList() {
        this.base = new NodeLL<T>(null);
        last = base;
        size = 0;

    }

    public T getByIndex(int index) throws IndexOutOfBoundsException {
        int counter = 0;
        NodeLL<T> current = base.getNext();

        if (index >= size) {
            throw new IndexOutOfBoundsException(String
                    .format("Index out of bound, Index: %d, Size: %d", index, size));
        }

        while (counter < size && counter != index && current != null) {
            current = current.getNext();
            counter++;
        }

        return current != null ? current.getData() : null;
    }

    public void add(T data){
        NodeLL<T> tmp = new NodeLL<>(data);
        NodeLL<T> curr = base.next;
        while(curr.next != null && data.compareTo(curr.data) < 0)
            curr = curr.next;
        tmp.next = curr.next;
        curr.next = tmp;
        size++;
    }


    public boolean remove(T data){
        NodeLL<T> current = base.next;
        NodeLL<T> prev = null;

        if(current != null && current.data.equals(data)){
            base.next = current.next;
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

    public NodeLL<T> get(T data) {
        int counter = 0;
        NodeLL<T> current = base.getNext();

        while (counter < size && current != null && !current.getData().equals(data)) {
            current = current.getNext();
            counter++;
        }

        return current;
    }



    public void clear() {
        base.setNext(null);
        last = base;
        size = 0;
    }



    private void increaseSize() {
        this.size++;
    }

    private void decreaseSize() {
        this.size--;
    }

    public NodeLL<T> getBase() {
        return base;
    }


    public NodeLL<T> getLast() {
        return last;
    }


    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public NodeLL<T> getFirst() {
        return base.getNext();
    }
}


class NodeLL<T> {
    NodeLL<T> next;
    T data;

    public NodeLL(T data) {
        this.data = data;
    }



    public NodeLL<T> getNext() {
        return next;
    }

    public void setNext(NodeLL<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeLL<T> next() {
        return this.next;
    }


}

class LinkedListIterator<T extends Comparable<T>> implements Iterator<T> {
    NodeLL<T> current;
    LinkedList<T> dll;

    public LinkedListIterator(LinkedList<T> dll) {
        this.dll = dll;
        current = dll.getBase();
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            return false;
        } else if (current.getNext() == null && current != dll.getLast()) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        if (current == dll.getBase()) {
            if (current.getNext() != null)
                current = current.getNext();
        }
        T data = current.getData();
        current = current.getNext();

        return data;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}






