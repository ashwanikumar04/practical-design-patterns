# NULL OBJECT

In **NULL OBJECT pattern**, instead of using a null reference to convey absence of an object (for instance, a non-existent customer), one uses an object which implements the expected interface, but whose method body is empty. The advantage of this approach over a working default implementation is that a null object is very predictable and has no side effects: it does nothing. 


![Null Object](/docs/images/null_object.svg)


