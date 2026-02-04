public class SinglyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() {}

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }
    public void addFirst(E value) {
        Node<E> node = new Node<>(value, null);
        if (isEmpty()){
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head = node;
        }
        size++;
    }
    public void addLast(E value) {
        Node<E> node = new Node<>(value, null);
        if (isEmpty())
            head = node;
        else
            tail.next = node;
        tail = node;
        size++;
    }
    public E removeFirst() {
        if (isEmpty())
            return null;
        else {
            Node<E> current = head;
            head = current.next;
            if (head == null) {
                tail = null;
            } // in case the node is both head and tail
            size--;
            return current.element;
        }

    }
    public void findNode(E value) {
        Node<E> current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            if (current.getElement().equals(value)) {
                System.out.println("found the value \"" + current.getElement()
                + "\" at node " + counter);
                return;
            }
            current = current.next;
        }
        System.out.println("did not find node");
    }


    static void main() {
        SinglyLinkedList list = new SinglyLinkedList<>();

        list.addLast("IAU");
        list.addLast("PMU");
        list.addLast("KFUPM");
        list.addLast("KFU");
        list.findNode("KFU");
    }

}


