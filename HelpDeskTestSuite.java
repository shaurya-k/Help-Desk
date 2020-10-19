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
 * This class tests certain algorithms and checks if they are doing their intended purpose
 * 
 * @author Shaurya
 *
 */
public class HelpDeskTestSuite extends HelpDesk {
  public HelpDeskTestSuite(int capacity) {
    super(capacity);
  }

  /**
   * main method which runs all the methods
   * 
   * @param args
   */

  public static void main(String[] args) {
    // call all the methods
    createNewTicketTest();
    closeNextTicketTest();
    sizeLimitTest();
    capitalStringTest();
    emptyTicketTest();
    sizeResetTest();
    compareToTest();
    numericalValueTest();
    swapTest();
    emptyHelpDeskTest();
  }

  /**
   * this method checks if the tickets are set in order when added to queue
   * @return true if in order
   */
  public static boolean createNewTicketTest() {
    HelpDesk Q = new HelpDesk(6); // create new priority queue
    String a = "";
    String error = "";
    // create new tickets
    try {
      Q.createNewTicket("kethireddy1");
      Q.createNewTicket("kethireddy12");
      Q.createNewTicket("kethireddy123");
      Q.createNewTicket("kethireddy1234");
      Q.createNewTicket("kethireddy12345");
      // assigns string with top of priority
      a = Q.checkNextTicket();
    } catch (Exception e) {
      error = "exception";
    }
    if (a.equals("kethireddy12345") && error.equals("")) { // checks if top of priority is correct
                                                           // item
      System.out.println("createNewTicketTest passed");
      return true; // pass
    }
    System.out.println("createNewTicketTest failed");
    return false; // fail

  }

  /**
   * this method checks if ticket with highest priority are closed first
   * @return true if test passed
   */
  public static boolean closeNextTicketTest() {
    String error = "";
    String a = "";
    String b = "";
    HelpDesk Q = new HelpDesk(6); // create new priority queue
    // create new tickets

    try {
      Q.createNewTicket("kethireddy1");
      Q.createNewTicket("kethireddy12");
      Q.createNewTicket("kethireddy123");
      Q.createNewTicket("kethireddy1234");
      Q.createNewTicket("kethireddy12345");
      a = Q.closeNextTicket(); // assigns with what returns when closing
      // close two more tickets
      Q.closeNextTicket();
      Q.closeNextTicket();
      b = Q.closeNextTicket(); // assigns with what returns when closing
    } catch (Exception e) {
      error = "exception";
    }
    if (a.equals("kethireddy12345") && error.equals("")) { // checks if returned string is correct
                                                           // string
      if (b.equals("kethireddy12")) {
        System.out.println("closeNextTicketTest passed");
        return true; // pass
      }
    }

    System.out.println("closeNextTicketTest failed");
    return false; // fail

  }

  /**
   * this method checks if possible to add tickets past the capacity
   * @return true if createNewTicket is able to throw exception
   */
  public static boolean sizeLimitTest() {
    HelpDesk a = new HelpDesk(3); // create new priority queue

    // create new tickets
    a.createNewTicket("hi");
    a.createNewTicket("hey");
    a.createNewTicket("hello");
    // assign string variables to compare for if condition
    String error = "Error is caught";
    String temp = "";
    // try to create new ticket past the capacity limit
    try {
      a.createNewTicket("heyyy");
    } catch (Exception e) {
      temp = "Error is caught";
    }
    if (error.equals(temp)) { // checks if catch block is accessed and exception thrown
      System.out.println("sizeLimitTest passed");
      return true; // pass
    }

    System.out.println("sizeLimitTest failed");
    return false;// fail

  }

  /**
   * checks if new tickets are set in order if same length but different cases
   * @return true if in correct order of priority
   */
  public static boolean capitalStringTest() {
    HelpDesk a = new HelpDesk(3); // create new priority queue
    String error = "";
    String firstClose = "";
    String secondClose = "";
    // create new tickets of same length but different cases
    try {
      a.createNewTicket("hi");
      a.createNewTicket("Hi");
      a.createNewTicket("HI");
      firstClose = a.closeNextTicket(); // assigns variable with return string of first close
      secondClose = a.closeNextTicket(); // assigns variable with return string of second
                                         // close
    } catch (Exception e) {
      error = "exception";
    }
    if (firstClose.equals("hi") && error.equals("")) { // checks if return string is correct
      if (secondClose.equals("Hi")) {
        System.out.println("capitalStringTest passed");
        return true; // pass
      }
    }
    System.out.println("capitalStringTest failed");
    return false; // fail
  }

  /**
   * this method checks if there's an exception being thrown when new ticket is null
   * @return true if exception is thrown
   */
  public static boolean emptyTicketTest() {
    HelpDesk a = new HelpDesk(2); // create new priority queue
    a.createNewTicket("empty"); // create new ticket
    String error = "can't have empty"; // assigns error string with message
    String temp = ""; // intialize temp variable
    try {
      a.createNewTicket(null); // try to create ticket with null message
    } catch (Exception e) {
      temp = "can't have empty"; // catch and assign variable with error message
    }
    if (error.equals(temp)) { // check if the catch block was accessed and exception thrown
      System.out.println("emptyTicketTest passed");
      return true; // pass
    }
    System.out.println("emptyTicketTest failed");
    return false; // fail

  }

  /**
   * checks if the size variable gets updated correctly when creating and 
   * @return true if size was correctly update
   */
  public static boolean sizeResetTest() {
    HelpDesk Q = new HelpDesk(3); // create new priority queue
    int c = 0;
    int a = 0;
    int b = 0;
    String error = "";
    try {
      // create new tickets
      Q.createNewTicket("kethireddy1");
      Q.createNewTicket("kethireddy12");
      Q.createNewTicket("kethireddy123");
      c = Q.size; // assign with current size
      // close all tickets
      Q.closeNextTicket();
      Q.closeNextTicket();
      Q.closeNextTicket();
      a = Q.size; // assign with current size
      // create new tickets
      Q.createNewTicket("1");
      Q.createNewTicket("2");
      b = Q.size; // assign with current size
    } catch (Exception e) {
      error = "exception";
    }
    if ((b + a + c) == 5 && error.equals("")) { // add the sizes and checks if it's correct
      System.out.println("sizeResetTest passed");
      return true; // pass
    }
    System.out.println("sizeResetTest failed");
    return false; // fail

  }

  /**
   * checks if the compareTo method recognizes difference between length and ASCII and return 
   * properly
   * @return true if values returned by method are correct
   */
  public static boolean compareToTest() {
    int diffLength = 0;
    int diffASCII = 0;
    String error = "";
    try {
      // create two support tickets with different length
      SupportTicket a = new SupportTicket("hello");
      SupportTicket b = new SupportTicket("hi");
      diffLength = a.compareTo(b); // assign with length difference
      // create two support tickets with same length but different cases
      SupportTicket c = new SupportTicket("shaurya");
      SupportTicket d = new SupportTicket("Shaurya");
      diffASCII = c.compareTo(d); // assign with ASCII difference
    } catch (Exception e) {
      error = "exception";
    }

    if (diffLength == 3 && diffASCII == 32 && error.equals("")) { // check if the difference in both
                                                                  // types of tickets are correct

      System.out.println("compareToTest passed");
      return true; // pass
    }
    System.out.println("compareToTest failed");
    return false; // fail

  }

  /**
   * checks if the priority queue is able to implement numbers according to correct priority rules
   * @return true if correctly prioritized
   */
  public static boolean numericalValueTest() {
    HelpDesk X = new HelpDesk(3); // create new priority queue
    String priority = "";
    String secondPriority = "";
    String error = "";
    try {
      // create three tickets of different numbers
      X.createNewTicket("8");
      X.createNewTicket("18");
      X.createNewTicket("88");
      priority = X.closeNextTicket(); // assigns variable with highest priority message
      secondPriority = X.closeNextTicket(); // assigns variable with second priority message
    } catch (Exception e) {
      error = "exception";
    }
    if (priority.equals("88") && error.equals("")) { // checks if algorithm is able to prioritize
                                                     // correctly and return
      if (secondPriority.equals("18")) {
        if (X.checkNextTicket().equals("8")) {
          System.out.println("numericalValueTest passed");
          return true; // pass
        }
      }
    }
    System.out.println("numericalValueTest failed");
    return false; // fail

  }

  /**
   * this method checks if the swap function properly
   * @return true if swap function works correctly
   */
  public static boolean swapTest() {
    HelpDesk X = new HelpDesk(3);
    String a = "";
    String b = "";
    String error = "";
    try {
      // create three new tickets
      X.createNewTicket("hi");
      X.createNewTicket("i'm");
      X.createNewTicket("shaurya");
      X.swap(0, 2); // calls the swap function
      a = X.array[0].toString(); // assign with return from array
      b = X.array[2].toString(); // assign with return from array
    } catch (Exception e) {
      error = "exception"; // assigns the exception
    }
    if (a.equals("i'm") && b.equals("shaurya") && error.equals("")) { // checks the conditions
      System.out.println("swapTest passed");
      return true; // pass
    }
    System.out.println("swapTest failed");
    return false; // fail


  }

  /**
   * this method checks if the program recognizes that the helpdesk is empty and catches the error
   * @return true if function able to recognize that help desk is empty
   */
  public static boolean emptyHelpDeskTest() {
    HelpDesk X = new HelpDesk(3);
    String error = "no error";
    try {
      X.createNewTicket("woah");
      X.closeNextTicket();
      X.checkNextTicket();
    } catch (Exception e) {
      error = "error is caught";
    }
    if (error.equals("error is caught")) {
      System.out.println("emptyHelpDeskTest passed");
      return true;
    }
    System.out.println("emptyHelpDeskTest failed");
    return false;
  }
}
