public class Node<Type>
{
    private Type content;
    private Node<Type> previous, next;

    /**
     * Constructor of a node that contains
     * a generic type as content and
     * references at the previous & next node.
     * */
    public Node(Type content)
    {
        this.content = content;
        this.previous = null;
        this.next = null;
    }

    public Type getContent() { return content; }
    public Node<Type> getPrevious() { return previous; }
    public Node<Type> getNext() { return next; }

    //public void setContent(Type content) { this.content = content; }
    public void setPrevious(Node<Type> previous) { this.previous = previous; }
    public void setNext(Node<Type> next) { this.next = next; }

    public boolean equals(Node<Type> node) { return this == node; }

    /**
     * Auxiliary method for the student and the examiner.
     * Created to test the correct implementation of the Double Ended Queue.
     * Returns a node-object's position as well as it's data (content)
     * and previous/next node's position (or null if not any).
     * */
    public String toStr()
    {
        return  this + " { " + "content = " + (getContent() == null ? "null " : getContent().toString()) + " "
                + " previous = " + (getPrevious() == null ? "null" : getPrevious().toString()) + " "
                + " next = " + (getNext() == null ? "null" : getNext().toString()) + " } ";
    }
}