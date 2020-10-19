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
 * This interface exposes the functionality of the HelpDesk class for CS300's P10 assignment.
 * In addition to public methods, there are also comments describing protected methods that
 * must be defined within any implementation of this interface.  The only fields that may be
 * defined in such implementations include: a SupportTicket[] array, and an int size.
 * 
 * @author CS300 Course Staff
 */
public interface HelpDeskInterface {

  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * @param message names the client and describes their need for support.
   * @throws NullPointerException when the String message argument is null.
   */
  public void createNewTicket(String message);

  /**
   * Returns the message within this HelpDesk that has the highest priority.
   * This method does not change the state of this HelpDesk.
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  public String checkNextTicket();  

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  public String closeNextTicket();

//   Your HelpDesk implementation must also include definitions for the following methods:
//   (These methods must work when meaningful indexes are provided.  Their behavior is
//   undefined for invalid index values: this means that they could return a wrong/meaningless
//   value, or they could throw an unchecked exception in response to bad input.)

  //protected static int parentOf(int index);
  // Given an index into the heap array, this method returns that index's parent index.

  //protected static int leftChildOf(int index);
  // Given an index into the heap array, this method returns that index's left child index.

  //protected static int rightChildOf(int index);  
  // Given an index into the heap array, this method returns that index's right child index.

  //protected void swap(int indexA, int indexB);
  // Given two indexes into the heap array, this method swaps the SupportTickets at those indexes.

  //protected void propagateUp(int index);
  // Given an index into the heap array, this method recursively swaps any SupportTickets 
  // necessary to enforce the heap's order property between this index and the heap's root.

  //==protected void propagateDown(int index);
  // Given an index into the heap array, this method recursively swaps any SupportTickets 
  // necessary to enforce the heap's order property between this index and it's children.

}
