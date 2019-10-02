# Template

**Template** is a behavioral design pattern that defines the skeleton of an algorithm in the superclass 
but lets subclasses override specific steps of the algorithm without changing its structure.

![Template](/docs/images/template.svg)


### Examples from Java core libraries

- All non-abstract methods of [java.io.InputStream](http://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), [java.io.OutputStream](http://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html), [java.io.Reader](http://docs.oracle.com/javase/8/docs/api/java/io/Reader.html) and [java.io.Writer](http://docs.oracle.com/javase/8/docs/api/java/io/Writer.html).
- All non-abstract methods of [java.util.AbstractList](http://docs.oracle.com/javase/8/docs/api/java/util/AbstractList.html), [java.util.AbstractSet](http://docs.oracle.com/javase/8/docs/api/java/util/AbstractSet.html) and [java.util.AbstractMap](http://docs.oracle.com/javase/8/docs/api/java/util/AbstractMap.html).