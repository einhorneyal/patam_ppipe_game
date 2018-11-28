We created class named as PipePriorityMultiClientServer that implement server class with architecture that support 10 clients concurrent (the number of clients could be configured).
the implementation that we used was based on ThreadPool That uses BlockingQueue that receive runnable and comperable object(PipePriorityRunnable) and execute the logic with lambda expression after checking the relevant size.

Server excution command:
java -jar MultiServer.jar



 
