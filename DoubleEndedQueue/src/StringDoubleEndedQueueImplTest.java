public class StringDoubleEndedQueueImplTest
{
    public static void main(String[] args)
    {
        StringDoubleEndedQueueImpl<Node> dll = new StringDoubleEndedQueueImpl<>();
        Node<Integer> node = new Node<>(1);
        dll.addFirst(node);
        //dll.removeFirst();//dll.removeLast();
        System.out.println(dll.getFirst());// "" + dll.head);
        System.out.println(dll.getLast());
        System.out.println(dll.getSize());
        System.out.println(dll.getClass());
    }
}