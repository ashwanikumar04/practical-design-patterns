# Chain of responsibility

**Chain of Responsibility** is a behavioral design pattern which passes through a pipeline of handlers. When the request passes through the pipeline, each of the handlers decides whether to process the request and pass it down to the other handlers in the pipeline. The handlers can also decide to stop the request from moving ahead in the pipeline.

![Chain of responsibility](/docs/images/cor.svg)


## Examples from Java core libraries

- [javax.servlet.Filter#doFilter()](https://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-)
    
