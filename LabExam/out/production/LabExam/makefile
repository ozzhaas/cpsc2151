default: cpsc2150/sets/ArraySet.java cpsc2150/sets/ListSet.java cpsc2150/sets/SetAbs.java cpsc2150/sets/ISet.java cpsc2150/sets/SetApp.java cpsc2150/sets/IntegerSetApp.java
	cpsc2150/sets/ArraySet.java cpsc2150/sets/ListSet.java cpsc2150/sets/SetAbs.java cpsc2150/sets/ISet.java cpsc2150/sets/SetApp.java cpsc2150/sets/IntegerSetApp.java

runDouble: cpsc2150/sets/ArraySet.class cpsc2150/sets/ListSet.class cpsc2150/sets/SetAbs.class cpsc2150/sets/ISet.class cpsc2150/sets/SetApp.class cpsc2150/sets/IntegerSetApp.class


runDouble: cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/AbsQueue.class cpsc2150/MyQueue/DoubleQueueApp.class
	java cpsc2150/MyQueue/DoubleQueueApp

test: cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/DoubleQueueApp.java cpsc2150/MyQueue/TestArrayQueue.java cpsc2150/MyQueue/TestListQueue.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/DoubleQueueApp.java cpsc2150/MyQueue/TestArrayQueue.java cpsc2150/MyQueue/TestListQueue.java

testArr: cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/DoubleQueueApp.java cpsc2150/MyQueue/TestArrayQueue.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150/MyQueue/TestArrayQueue

testList: cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/DoubleQueueApp.java cpsc2150/MyQueue/TestListQueue.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150/MyQueue/TestListQueue

clean:
	rm cpsc2150/MyQueue/*.class