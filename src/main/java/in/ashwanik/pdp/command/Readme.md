# Command

**Command** is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. 
This transformation lets us parametrize methods with different requests, delay or queue a request’s execution, and support undoable operations.

![Command](/docs/images/command.svg)


## Examples from Java core libraries

- [java.lang.Runnable](http://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
- [javax.swing.Action](http://docs.oracle.com/javase/8/docs/api/javax/swing/Action.html)
