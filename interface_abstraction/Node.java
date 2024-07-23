package interface_abstraction;

import java.util.Iterator;


public class Node implements Iterable<Node> {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }

    public static class NodeIterator implements Iterator<Node> {

        Node node;

        public NodeIterator(Node node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Node next() {
            Node temp = node;
            node = node.next;
            return temp;
        }
    }

}



