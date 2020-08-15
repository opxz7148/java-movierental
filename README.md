## Movie Rental Refactoring Example

This [refactoring example][refactoring_ch1] is from Chapter 1 of
_Refactoring: Improving the Design of Existing Code_ by Martin Fowler.  

There are two branches in this repository:

* `java` contains Java source code, updated to use current Java features
* `python` contains Python source, translated from the Java code

The Java code has been updated to use features such as a List with type
parameter instead of Vector and type casts, and the for-each loop. 
I also removed the leading underscore on attribute names (`name` instead of `_name`),
which is more typical of current coding conventions.

The runnable Main class (or Python `main.py`) creates a customer and prints 
a statement.

The [PDF from Chapter 1][refactoring_ch1] explains the 
motivation for each refactoring and how to do it.

To summarize, the refactorings are:

1. *Extract Method*.  In Customer.statement() extract the code that
 calculates the price of each rental.
2. *Move Method*. After extracting a method to calculate the price of a rental,
Fowler observe that the method uses information about the rental but not 
about the customer.  Hence, the method should be in the `Rental` class instead
of `Customer` class. Moving the method to a different class requires changing how 
it is referenced in the original code. It changes from:
    ```java
    // Customer class:
    public double amountFor(Rental rental) { ... }
    
    charge = amountFor(rental);
    ```
    to:
    ```java
    // Rental class:
    public double getCharge() { ... }
    // Customer class:
    charge = rental.getCharge();
    ```
3. *Replace Temp Variable with a Query*.  Instead of using `charge = rental.getCharge()` (assign to a temp variable) and using `charge` in the code, he directly invokes `rental.getCharge()` wherever the value is needed. 
This removes the local variable but results to multiple method calls for the same thing.
4. *Extract Method*. Refactor summation of frequent renter points to a separate method.
5. *Replace Conditional Logic with Polymorphism*. He replaces the "switch" statement for movie price codes
with polymorphism, in two steps.  The first step is to make the Movie class compute its own frequent renter points,
and then have it delegate that task to a Strategy object.
    * This is a long refactoring because he first uses inheritance and then explains why that's a poor solution.
    * This is summarized by the principle "*Prefer composition over inheritance*".
    * Fowler uses strategy classes named RegularPrice, ChildrensPrice, NewReleasePrice that
      contain methods for calculating rental charge and frequent renter points for each price code. 
      Instead of a constant for price code he uses objects from those classes.

6. *The Missing Refactoring*.  In the final code the Customer class still needs a *Move Method* refactoring to remove
some unrelated behavior, in my opinion.  What do you think?

[refactoring_ch1]: https://github.com/jbrucker/movierental/blob/master/refactoring-movierental.pdf
[refactoring_pdf]: https://github.com/jbrucker/movierental/raw/master/refactoring-movierental.pdf

## Resources

* [Refactoring, First Example][refactoring_pdf] extract from Martin Fowler's book. [View PDF online][refactoring_ch1].
* [Refactoring slides from U. Colorado](https://www.cs.colorado.edu/~kena/classes/6448/s05/lectures/lecture19.pdf) step-by-step instructions for Java version of this example, including UML class diagram of progress.
