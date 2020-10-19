//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Help Desk)
// Files: (SupportTicket.java, HelpDeskInterface.java, HelpDesk.java, HelpDeskTestSuite.java)
// Course: (CS 300, Spring, and 2019)
//
// Author: (Shaurya Kethireddy)
// Email: (skethireddy@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class implements HelpDeskInterface and also creates a priority queue which uses a max heap
 * and contains other functions to go along with it
 * 
 * @author shaurya
 *
 */
public class HelpDesk implements HelpDeskInterface {
  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size; // variable to keep track of how many support tickets are present

  /**
   * constructor method to create a priority queue
   * 
   * @param capacity - sets the array to a certain capacity
   */
  public HelpDesk(int capacity) {
    size = 0; // clear to zero
    array = new SupportTicket[capacity]; // creates array with the specified capacity
  }

  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * @param message names the client and describes their need for support.
   * @throws NullPointerException when the String message argument is null.
   */
  @Override
  public void createNewTicket(String message) {
    if (message == (null)) { // checks if message is null
      throw new NullPointerException("String message argument is null");
    }
    if (size == array.length) { // checks if queue is full
      throw new IndexOutOfBoundsException("Help Desk queue is full");

    }
    array[size] = new SupportTicket(message); // assigns new ticket to first available element

    propagateUp(size); // swaps elements to make sure theyre in order
    size++; // increment size

  }

  /**
   * Returns the message within this HelpDesk that has the highest priority.
   * This method does not change the state of this HelpDesk.
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String checkNextTicket() {
    if (size == 0) { // checks if queue is empty
      throw new IllegalStateException("Help Desk is currently empty");
    }
    return array[0].toString(); // returns the string message from highest priority element
  }

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String closeNextTicket() {
    if (size == 0) { // checks if queue is empty
      throw new IllegalStateException("Help Desk is currently empty");
    }
    String result = array[0].toString(); // assigns string variable with high priority string
    swap(0, size - 1);// swaps the first and last
    array[size - 1] = null;// assigns to null
    size--;// decrement
    propagateDown(0);
    return result;
  }

  /**
   * Given an index into the heap array, this method returns that index's parent index.
   * @param index - param to find the parent of
   * @return index's parent index
   */
  protected static int parentOf(int index) {
    return (index - 1) / 2; // subtracts one and divide by 2
  }

  /**
   * Given an index into the heap array, this method returns that index's left child index.
   * @param index - param to find the left child of
   * @return index's left child index
   */
  protected static int leftChildOf(int index) {
    return ((2 * index) + 1);// multiply by 2 and add 1
  }

  /**
   * Given an index into the heap array, this method returns that index's right child index.
   * @param index - param to find the right index of
   * @return index's right child index
   */
  protected static int rightChildOf(int index) {
    return ((2 * index) + 2); // multiply by 2 and add 2
  }

  /**
   * Given two indexes into the heap array, this method swaps the SupportTickets at those indexes.
   * @param index1 - first index to swap
   * @param index2 - second index to swap
   */
  protected void swap(int index1, int index2) {
    SupportTicket temp = array[index1]; // assigns temp with ticket from first param
    array[index1] = array[index2];// assigns the first param with the second param
    array[index2] = temp; // assigns the second param with the temp from first param
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets 
   * necessary to enforce the heap's order property between this index and the heap's root.
   * @param index - to swap any needed elements from param to root
   */
  protected void propagateUp(int index) {
    int parent = parentOf(index); // finds the parent index of param
    if (array[index].compareTo(array[parent]) > 0 && index > 0) { // checks if param is greater than
                                                                  // parent
      swap(parent, index); // swaps the two
      propagateUp((parent)); // recursive method
    }
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets 
   * necessary to enforce the heap's order property between this index and it's children
   * @param index - to swap any needed elements from param to its children
   */
  protected void propagateDown(int index) {
    int left = leftChildOf(index); // finds the left child
    int right = rightChildOf(index); // finds the right child
    int difference = 0; // initialize an int
    if (size > left && array[index].compareTo(array[left]) < 0) {
      // checks if the param element isn't null and if param is less than its left child
      difference = left; // assigns with left index
    }

    if (size > right && array[difference].compareTo(array[right]) < 0) {
      // checks if the param element isn't null and if param is less than its right child

      difference = right; // assigns with right index
    }
    if (difference != index) {
      swap(index, difference); // swaps the two
      propagateDown(index); // recursive method
    }
  }

}
