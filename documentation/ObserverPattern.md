<h1 align="center">
  The observer Pattern
</h1>

### 🙌 Utilities of this pattern

The observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. In this scenario, I used the observer pattern with a mouse listener on a button.

The way it works is very simple, when we click the button, the observable object sends a notification to the components and they update they data. After the components have updated their data, the observable sends a notification to the display components
and they grab the data from the components (previously updated).


### ❓ Prerequesites to understand the observer pattern:

- Polymorphism

- Abstraction (interfaces and abstract classes)

- Knowing how the ArrayList object works can be very handy with this pattern (although I programmed my implementation with arrays)


### 📝 Class diagram (isn't really an UML):
    
![](https://2.bp.blogspot.com/-xgiuTvAD4EI/Wy4qkZJDHmI/AAAAAAAACj4/xVrxGOVR2V452XUKain8m-UOTlxxGuJBgCLcBGAs/w1200-h630-p-k-no-nu/observer-generic-class-diagram.PNG)


### 🌐 Usefull sources to learn it from:

* Chapter 2 of the book: "Head First Design Patterns: A Brain-Friendly Guide"
* [Explanatory video (English)](https://www.youtube.com/watch?v=_BpmfnqjgzQ&t=2255s) 

