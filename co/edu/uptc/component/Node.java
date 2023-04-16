package co.edu.uptc.component;

public class Node<T> {

    private T information;
    private Node<T> next;

    public Node(T information, Node<T> next) {
        this.information = information;
        this.next = next;
    }
    public T getInformation() {
        return information;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T>  next) {
        this.next = next;
    }
    
}
