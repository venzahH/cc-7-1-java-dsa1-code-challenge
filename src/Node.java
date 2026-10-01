/**
 * Node class which is used for the linked list implementation of the Stack and Queue classes. This class holds the
 * number and the next node that comes after the current node.
 *
 * @author Venzah Hamilton
 * @version 1.0
 */
public class Node {
    private Integer value;
    private Node next;
    public Node(Integer value){
        this.value = value;
        this.next = null;
    }

    /**
     *Sets the next node that comes after the current node. Next can be null
     *
     * @param next Node object of the next node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns the next node object in the linked list
     *
     * @return Node object of the next node in the list
     */
    public Node getNext(){
        return this.next;
    }

    /**
     * Returns the value stored in the node
     *
     * @return Integer object of the number stored in the node
     */
    public Integer getValue(){
        return this.value;
    }
}
