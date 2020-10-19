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
 * This class implements the Comparable<SupportTicket> interface. This class should contain a
 * constructor that takes a String message in as input, and stores that string within an instance
 * field
 * 
 * @author shaurya
 *
 */

public class SupportTicket implements Comparable<SupportTicket> {
  private String message;

  /**
   * constructor method that takes a String message in as input, and stores that string within an
   * instance field
   * 
   * @param message - input of what each support ticket should say
   */
  public SupportTicket(String message) {
    if (message == (null)) { // checks if the param is null
      throw new NullPointerException("argument can't be null");
    }
    this.message = message; // assigns param to local variable
  }

  /**
   * natural ordering of support tickets corresponds to the length of the message inside them: 
   * longer messages should be considered later in this natural ordering (aka larger).  Whenever the
   *  two messages being compared have the same length, their lexographical (alphabetical) order 
   *  should be used to attempt to break such ties.
   *  @param o - support ticket message that is compared to local ticket message
   *  @return the difference of local variable string to param string
   */
  @Override
  public int compareTo(SupportTicket o) {
    if (o == (null)) { // checks if object is null
      throw new NullPointerException("Specified object is null");
    }

    int difference = this.message.length() - o.message.length(); // stores value of local variable
                                                                 // length minus param length
    if (difference != 0) {
      return difference;
    }
    return this.message.compareTo(o.toString()); //compare ASCII
  }

  /**
   * returns a string representation of the message that is stored in a certain support ticket
   */
  @Override
  public String toString() {
    return message;
  }

}
