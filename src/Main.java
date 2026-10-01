import java.util.Scanner;

/**
 * Main class which holds the source code for this program. It will prompt the user for a string of numbers with spaces
 * to denote separate numbers and process the string by adding all the even numbers to a queue and all the odd numbers
 * to a stack. It will then go through both the stack and queue, displaying all the numbers in each data structure as
 * well as each one's respective sum.
 */
public class Main {
    private static final Queue evenQueue = new Queue();
    private static final Stack oddStack = new Stack();
    private static final String DELIMETER = " ";
    private static final String NUMBER_SEPARATOR = ", ";
    private static final int LAST_ELEMENT = 1;

    /**
     * processInput takes a string of numbers, creates an array separating these numbers by space and adding the number
     * to a stack or queue depending on whether it is even or odd. Validation checking is done to ensure that the
     * String argument passed is not empty or null. Validation is also done with the validateString method (see method
     * for more details).
     *
     * @param input String containing all the numbers the user inputted separated by a space
     */
    public static void processInput(String input){
        if(input == null || input.isEmpty()){
            System.out.println("String is empty or null");
        } else{
            String[] separated = input.strip().split(DELIMETER);
            for(String str : separated ){
                Integer strToInt = validateNumber(str);
                if(strToInt != null){ // The string is skipped if it fails validation
                    if(strToInt % 2 == 0){ // Determines if the number is even or odd
                        evenQueue.enqueue(strToInt); // Adds to queue if number is even
                    } else{
                        oddStack.push(strToInt); // Adds to stack if number is odd
                    }
                }
            }
        }
    }

    /**
     * validateNumber checks to ensure that the string provided is a valid Integer.
     *
     * @param str representing the String to be checked
     * @return Integer version of the String if the conversion is successful and null if the String is not a number
     */
    public static Integer validateNumber(String str) {
        try{
            return Integer.parseInt(str);
        } catch(NumberFormatException e){
            System.out.println(str + " is not a number");
            return null;
        }
    }

    /**
     * printNumber prints the number provided. If number to be printed it the last element in the stack or array, it
     * is printed without the extra comma.
     *
     * @param size represents the size of the queue or stack
     * @param number the Integer number to be printed
     */
    public static void printNumber(int size, Integer number){
        if(size == LAST_ELEMENT){
            System.out.print(number);
        } else{
            System.out.print(number + NUMBER_SEPARATOR);
        }
    }

    /**
     * main will prompt the user for a list of numbers, process the numbers by sorting even numbers to a queue and odd
     * numbers to a stack. It will then print all the numbers in the queue in the order they were entered as well as the
     * sum of the numbers in the queue. It will then print all the numbers in the stack in the opposite order they were
     * entered as well as the sum of the numbers in the stack.
     *
     * @param args String list of arguments passed in the terminal before executing this program
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int evenSum = 0;
        int oddSum = 0;

        System.out.print("Enter a number or list of numbers separated by a space: ");
        String numbers = input.nextLine();

        processInput(numbers);

        System.out.println("\nQueue results (FIFO):");
        while(!evenQueue.isEmpty()){
            int evenQueueSize = evenQueue.getSize();
            int dequeueNumber = evenQueue.dequeue();
            evenSum += dequeueNumber;
            printNumber(evenQueueSize, dequeueNumber);
        }
        System.out.println("\nQueue sum: " + evenSum);

        System.out.println("\nStack results (LIFO):");
        while(!oddStack.isEmpty()){
            int oddStackSize = oddStack.getSize();
            int popNumber = oddStack.pop();
            oddSum += popNumber;
            printNumber(oddStackSize, popNumber);
        }
        System.out.println("\nStack sum: " + oddSum);
    }
}
