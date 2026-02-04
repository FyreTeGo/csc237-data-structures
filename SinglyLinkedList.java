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

    public SinglyLinkedList() {
    }

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
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
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

    public void addNode(E value, int index) {
        if (index < 0 || index > getSize()) {
            System.out.println("error, cannot add a node at this" +
                    "position");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == getSize()) {
            addLast(value);
        } else {
            Node<E> node = new Node<>(value, null);
            Node<E> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public void removeNode(E value) {
        Node<E> current = head;
        Node<E> previous = head;
        while (!current.getElement().equals(value)) {
            if (current.next == null) {
                System.out.println("value does not exist");
                return;
            }
            else {
                previous = current;
                current = current.next;
            }
        } // I got help from internet for while loop condition
        if (current == head) {
            removeFirst();
        }
        else {
            previous.next = current.next;
            size--;
        }
        if (current == tail) {
            tail = previous;
        }
    }

    public void display() {
        Node<E> current;
        current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            System.out.println("Linked List ( " + counter + " ): " + current.getElement());
            current = current.next;
        }
    }

    static void main() {
        Person p1 = new Person("Abdullah", "Dammam");
        Person p2 = new Person("Mohammed", "Saihat");

        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(p1);
        list.addLast(p2);
        list.display();
    }
}


