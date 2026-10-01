/**
 * Queue class to hold a varying number of Integer objects. A linked list is used with a head and tail variable for
 * quick access to the front of the list (for dequeueing) and the end of the list (for enqueueing) respectively.
 * The class is capable of adding numbers to the queue (enqueue), removing numbers from the queue (dequeue),
 * returning the number of numbers in the queue, and returning whether the queue is empty or not.
 *
 * @author Venzah Hamilton
 * @version 2.0
 */
public class Queue {
    private static Node head = null;
    private static Node tail = null;
    private static int size = 0;

    /**
     * enqueue adds a number to the queue. Since queues follow first in, first out, the head of the linked list
     * (which represents the front of the queue) will always be the earliest number added to the queue. Before adding to
     * the queue, validation testing is done to ensure the Integer object being added is not null.
     *
     * @param value Integer object representing the number to be added to the queue
     * @throws IllegalArgumentException exception is thrown if the argument passed is null or is not a number
     */
    public static void enqueue(Integer value) throws IllegalArgumentException {
        if(value == null){ // Validates that the Integer is not null
            throw new IllegalArgumentException("The integer is null");
        } else{
            if(isEmpty()){
                head = new Node(value);
                tail = head;
            } else{
                Node newFront = new Node(value);
                tail.setNext(newFront);
                tail = newFront;
            }
            size++;
        }
    }

    /**
     * dequeue removes the first value in the queue. Since it is a queue, dequeueing follows first in first out
     *
     * @return int of the first number in the queue
     * @throws IndexOutOfBoundsException exception thrown if there are no numbers in the queue to dequeue
     */
    public static int dequeue() throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        } else{
            Node temp = head;
            head = head.getNext();
            size--;
            temp.setNext(null);
            return temp.getValue();
        }
    }

    /**
     * getSize returns the number of items that is currently in the queue.
     *
     * @return int representing the number of items in the queue
     */
    public static int getSize(){
        return size;
    }

    /**
     * isEmpty returns a boolean value indicating whether the queue is currently empty.
     *
     * @return boolean representing if the queue is empty (true) or not empty (false).
     */
    public static boolean isEmpty(){
        if(head == null){
            return true;
        } else{
            return false;
        }
    }
}
