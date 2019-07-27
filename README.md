# PIPE GAME

Here we created complex client server pipe game project:

#### Server side:
* Work concurent for 10 users
* Solver Engien: 
We are able to solve difficult stages using search gragh algorithems such as BFS, DFS, A* 

#### Client side:
* JAVA-FX project
* Full comunication to server 

# Explanation:
We created class named as PipePriorityMultiClientServer that implement server class with architecture that support 10 clients concurrent (the number of clients could be configured).
the implementation that we used was based on ThreadPool That uses BlockingQueue that receive runnable and comperable object(PipePriorityRunnable) and execute the logic with lambda expression after checking the relevant size.

Server excution command:
java -jar MultiServer.jar
