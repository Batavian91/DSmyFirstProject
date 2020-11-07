public class Node<Type>
{
    private Type content;
    Node previous, next;

    public Node()
    {
        this.previous = null;
        this.next = null;
    }

    public Node(Type content)
    {
        this.content = content;
        this.previous = null;
        this.next = null;
    }

    public Type getContent() { return content; }
    public Node getPrevious() { return previous; }
    public Node getNext() { return next; }

    public void setContent(Type content) { this.content = content; }
    public void setPrevious(Node previous) { this.previous = previous; }
    public void setNext(Node next) { this.next = next; }

    public boolean equals(Node node)
    {
        if (this == node) return true;
        else return false;
    }

    @Override
    public String toString()
    {
        return "Node {" + " content= " + content + ", previous=" + previous + ", next=" + next + " }";
    }
}