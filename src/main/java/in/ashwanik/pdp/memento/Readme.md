# Memento


**Memento** is a behavioral design pattern that lets us save and restore the previous state of an object without revealing the details of its implementation.

![Memento](/docs/images/memento.svg)


### Examples from Java core libraries

- All [java.io.Serializable](http://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) implementations can simulate the Memento.
- All [javax.faces.component.StateHolder](http://docs.oracle.com/javaee/7/api/javax/faces/component/StateHolder.html) implementations.
