import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl<Type> implements StringDoubleEndedQueue<Type>
{
    private int size = 0;
    private Node<Type> head;
    private Node<Type> tail;

    /**
     * @return true if the queue is empty
     */
    public boolean isEmpty() { return head == null; }

    /**
     * insert an item at the front of the queue
     *
     * @param item can be of any type
     */
    public void addFirst(Type item)
    {
        Node<Type> temp = new Node<>(item);
        if (isEmpty())
        {
            head = tail = temp;
        }
        else
        {
            temp.setNext(head); //new node points at first node
            head.setPrevious(temp); //first node points at new node
            head = temp; //new node is now first node
        }
        size++;
    }

    /**
     * remove and return the item at the front of the queue
     *
     * @return the item from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Type removeFirst() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException("The list is already empty!");

        Node<Type> temp = new Node<>(head.getContent()); //create temp node to store first node's content

        if (head.equals(tail))
        {
            head = tail = null;
        }
        else
        {
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        size--;
        return temp.getContent();
    }

    /**
     * insert an item at the end of the queue
     *
     * @param item can be of any type
     */
    public void addLast(Type item)
    {
        Node<Type> temp = new Node<>(item);
        if (isEmpty())
        {
            head = tail = temp;
        }
        else
        {
            temp.setPrevious(tail); //new node points at last node
            tail.setNext(temp); //last node points at new node
            tail = temp; //new node is now last node
        }
        size++;
    }

    /**
     * remove and return the item at the end of the queue
     *
     * @return the item from the end of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Type removeLast() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty!");

        Node<Type> temp = new Node<>(tail.getContent()); //create temp node to store last node's content

        if (head.equals(tail))
        {
            head = tail = null;
        }
        else
        {
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
        }
        size--;
        return temp.getContent();
    }

    /**
     * return without removing the item at the front of the queue
     *
     * @return the item from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Type getFirst() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty!");
        return head.getContent();
    }

    /**
     * return without removing the item at the end of the queue
     *
     * @return the item from the end of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Type getLast() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty!");
        return tail.getContent();
    }

    /**
     * print the items of the queue, starting from the front,
     * to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printQueue(System.out);
     *
     * @param stream stream output
     */
    @Override
    public void printQueue(PrintStream stream)
    {
        try
        {
            if (isEmpty())
                stream.print("The queue is empty!");
            else
            {
                stream.print("Queue:  ");
                Node<Type> current = head;
                do
                {
                    stream.print(current.getContent() + "  ");
                    current = current.getNext();
                }
                while (current!=null);
            }
            stream.println();
            //stream.close();  //if used with System.out, console is closed
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * return the size of the queue, 0 if empty
     *
     * @return number of elements in the queue
     */
    public int getSize() { return size; }
}