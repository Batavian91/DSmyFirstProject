public class Node<Type>
{
    private Type content;
    private Node<Type> previous, next;

    public Node(Type content)
    {
        this.content = content;
        this.previous = null;
        this.next = null;
    }

    public Type getContent() { return content; }
    public Node<Type> getPrevious() { return previous; }
    public Node<Type> getNext() { return next; }

    //public void setContent(Type content) { this.content = content; } //this method is never used
    public void setPrevious(Node<Type> previous) { this.previous = previous; }
    public void setNext(Node<Type> next) { this.next = next; }

    public boolean equals(Node<Type> node) { return this == node; }

    public String toStr()
    {
        return "Node { " + "content = " + (getContent() == null ? "null " : getContent().toString()) + " " +
                " previous = " + (getPrevious() == null ? "null" : getPrevious().toString()) + " " +
                " next = " + (getNext() == null ? "null" : getNext().toString()) + " } ";
    }
}