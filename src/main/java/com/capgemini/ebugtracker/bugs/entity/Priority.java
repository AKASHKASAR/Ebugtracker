/**
 * 
 */
package com.capgemini.ebugtracker.bugs.entity;

/**
 * @author v62
 *
 */
public enum Priority {
	 
    LOW(4),NORMAL(3), HIGH(2), SEVERE(1);

    Priority(int priorityNumber) {

       this.priorityNumber = priorityNumber;
   }

   private int priorityNumber;

   public int getPriorityNumber() {

       return this.priorityNumber;
   }
}
