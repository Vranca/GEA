/***********************************************************************
 * Module:  Subject.java
 * Author:  User
 * Purpose: Defines the Interface Subject
 ***********************************************************************/

package models;

import views.Subscriber;

public interface Subject {
   void subscribe(Subscriber subscriber);
   void unsubscribe(Subscriber subscriber);
   void notifySubscribers();

}