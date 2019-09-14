# Proxy

**Proxy** is a structural design pattern that provides an object that acts as a substitute for a real service object used by a client. 
A proxy receives client requests, does some work (access control, caching, etc.) and then passes the request to a service object.

![Prototype](/docs/images/proxy.svg)

### Examples from Java core libraries
- [java.lang.reflect.Proxy](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html)
- [javax.persistence.PersistenceContext](http://docs.oracle.com/javaee/7/api/javax/persistence/PersistenceContext.html)