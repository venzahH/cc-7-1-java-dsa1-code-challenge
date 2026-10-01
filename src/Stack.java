

/**
 * Stack class to hold a varying number of Integer objects. A linked list is used with a head variable for quick access
 * to the top of the stack for pushing and popping. The class is capable of adding numbers to the stack (push),
 * removing numbers from the stack (pop), returning the number of numbers in the stack, and returning whether the stack
 * is empty or not.
 *
 * @author Venzah Hamilton
 * @version 2.0
 */
public class Stack {
    private static Node head = null;
    private static int size = 0;

    /**
     * push adds a number to the top of the stack. Since stacks follow last in, first out, the head of the linked list
     * (which represents the top of the stack) will always be the latest number added to the stack. Before adding to the
     * queue, validation testing is done to ensure the Integer object being added is not null.
     *
     * @param value Integer object representing the number to be added to the queue
     * @throws IllegalArgumentException exception is thrown if the argument passed is null or is not a number
     */
    public void push(Integer value) throws IllegalArgumentException {
        if(value == null){ // Validates that the Integer is not null
            throw new IllegalArgumentException("The integer is null");
        } else{
            if(isEmpty()){
                head = new Node(value);
            } else{
                Node newFront = new Node(value);
                newFront.setNext(head);
                head = newFront;
            }
            size++;
        }
    }

    /**
     * pop removes the value at the top of the stack. Since it is a stack, popping follows last in first out
     *
     * @return int of the number at the top of the stack
     * @throws IndexOutOfBoundsException exception thrown if there are no numbers in the stack to pop
     */
    public int pop() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty");
        } else{
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
            size--;
            return temp.getValue();
        }
    }

    /**
     * getSize returns the number of items that is currently in the stack.
     *
     * @return int representing the number of items in the stack
     */
    public int getSize(){
        return size;
    }

    /**
     * isEmpty returns a boolean value indicating whether the stack is currently empty.
     *
     * @return boolean representing if the stack is empty (true) or not empty (false).
     */
    public boolean isEmpty(){
        if(head == null){
            return true;
        } else{
            return false;
        }
    }
}
