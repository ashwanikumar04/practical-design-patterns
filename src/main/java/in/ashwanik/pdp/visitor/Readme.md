# Visitor

**Visitor** is a behavioral design pattern that lets us separate algorithms from the objects on which they operate.

![Visitor](/docs/images/visitor.svg)


### Examples from Java core libraries

- [javax.lang.model.element.AnnotationValue](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValue.html) and [AnnotationValueVisitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValueVisitor.html)
- [javax.lang.model.element.Element](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/Element.html) and [ElementVisitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ElementVisitor.html)
- [javax.lang.model.type.TypeMirror](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/type/TypeMirror.html) and [TypeVisitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/type/TypeVisitor.html)
- [java.nio.file.FileVisitor](http://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html) and [SimpleFileVisitor](http://docs.oracle.com/javase/8/docs/api/java/nio/file/SimpleFileVisitor.html)
- [javax.faces.component.visit.VisitContext](http://docs.oracle.com/javaee/7/api/javax/faces/component/visit/VisitContext.html) and [VisitCallback](http://docs.oracle.com/javaee/7/api/javax/faces/component/visit/VisitCallback.html)




### Reference

[Visitor](https://manski.net/2013/05/the-visitor-pattern-explained/)