

### Runnable
A Runnable is basically a type of class (Runnable is an Interface)
that can be put into a thread, describing what the thread is supposed to do.
This interface is designed to provide a common protocol for objects that wish to execute code while they are active.
 
 For example, Runnable is implemented by class Thread.
 Being active simply means that a thread has been started and has not yet been stopped.

In addition, Runnable provides the means for a class to be active while not subclassing Thread.
 A class that implements Runnable can run without subclassing
 Thread by instantiating a Thread instance and passing itself in as the target.
 
 In most cases, the Runnable interface should be used if you are only planning to override the run() method and no other Thread methods.
 This is important because classes should not be subclassed unless the programmer
 intends on modifying or enhancing the fundamental behavior of the class.

The Runnable Interface requires of the class to implement the method run() like so:
```java
public class MyRunnableTask implements Runnable {
     public void run() {
         // do stuff here
     }
}

```

Either you can implement Runnable or extend the thread class both spin up 
a new thread.
It is preffered to use Runnable though since Java doens't support multiple inheritance
so classes inhertied by thread class can't inherit anything else and it is basically
an overkill to provide all functions that a thread provides to a new sub class that doesn't need it

#### Join
Join tells main thread to wait for all the threads to complete their execution.

#### Volatile

The volatile keyword is used when two threads need to access a common section
of memory i.e. RAM. 

The usage is usually all instance variables are stored in CPU core cache since it is closer to CPU core.
However if two threads on two seperate cores need to maintain state then we use volatile keyword
to make store the variable store in RAM which is accessible by both cores.

There is a performance hit and causes instruction reordering while using the volatile keyword


### Thread.start() vs Thread.run()

The way to create a new thread is by calling the start method and when we directly call
the run() method it doesn't create a new thread. It just invokes it with the current thread.

Thread.run() does not spawn a new thread whereas Thread.start()
does, i.e Thread.run actually runs on the same thread
as that of the caller whereas Thread.start() creates
a new thread on which the task is run.
   
### Interrupts (Thread.interrupt())
Thread.interrupt() sets the interrupted status/flag of the target thread. Then code running in that target 
thread MAY poll the interrupted status and handle it appropriately. Some methods that block such as
Object.wait() may consume the interrupted status immediately and throw an appropriate exception
(usually InterruptedException)

Interruption in Java is not pre-emptive. Put another way both threads have to cooperate in order to process
the interrupt properly. If the target thread does not poll the interrupted status the interrupt is effectively ignored.

Polling occurs via the Thread.interrupted() method which returns the current thread's interrupted status AND
clears that interrupt flag. Usually the thread might then do something such as throw InterruptedException.


##### What is interrupt ?

An interrupt is an indication to a thread that it should stop what it is doing 
and do something else. It's up to the programmer 
to decide exactly how a thread responds to an interrupt,
 but it is very common for the thread to terminate.

##### How is it implemented ?

The interrupt mechanism is implemented using an internal flag known as the
interrupt status. Invoking Thread.interrupt sets this flag. When a thread
checks for an interrupt by invoking the static method Thread.interrupted,
interrupt status is cleared. The non-static Thread.isInterrupted(), which 
is used by one thread to query the interrupt status of another, does not 
change the interrupt status flag.

### Joins / Thread.Join()

java.lang.Thread class provides the join() method which allows one thread to wait until another thread completes its execution. If t is a Thread object whose thread is currently executing, then t.join(); it causes the current thread to pause its execution until thread it join completes its execution.
If there are multiple threads calling the join() methods that means overloading on join allows the programmer to specify a waiting period. However, as with sleep, join is dependent on the OS for timing, so you should not assume that join will wait exactly as long as you specify.
There are three overloaded join functions.

##### join(): 

It will put the current thread on wait until the thread on which it is called is dead.
 
 If thread is interrupted then it will throw InterruptedException.

```text
public final void join()
```

##### join(long millis) 
It will put the current thread on wait until the thread on which it is called is dead or wait for specified time (milliseconds).
```text

public final synchronized void join(long millis)
```

##### join(long millis, int nanos)

It will put the current thread on wait until the thread on which it is called is dead or wait for specified time (milliseconds + nanos).
```text
public final synchronized void join(long millis, int nanos)
```


