==Also checkout UsefulSnippets.java for more things that tripped me up==
==TODO: explore default behaviour of .copy()==
==TODO: Explore the **building data types** bit of the slides==
## Problems To Revisit 
**I got this one wrong (practice paper 2021-2022):**
```
Write a method that takes a parameter of type int, with a value greater than zero, and returns an int[] containing the digits that make up the parameter value. For example, if called with 345 the method will return the array of length 3 containing 3,4,5. The returned array must be exactly the right length to hold the result.
```
Where I basically got the reverse order instead of the forward order (`[5, 4, 3] instead of [3, 4, 5]`. Also, I didn't cast the size to an integer since Math.floor for some reason returns a double. The corrected version (made more concise with a for loop) is this:
```java
public int[] getDigits(int n) {  
    int[] digits = new int[(int) Math.floor(Math.log10(n)) + 1];  
    for (int j = digits.length - 1; j >= 0; j--) {  
        digits[j] = n % 10;  
        n /= 10;  
    }  
    return digits;  
}
```

**I also got this wrong (practice paper 2021-2022, question 2):**
The `Sequence`'s `.contains(int n)` method should have accounted for the increments, not just if the `n` is within bounds. The correct version would be this:
```java
public boolean contains(int n) {  
    int upperBound = start + increment * (count - 1);  
    boolean withinRange = n >= start && n <= upperBound;  
    boolean isMultiple = (n - start) % increment == 0;  
    return withinRange && isMultiple;  
}
```

**In Question 1 2021-2022 practice paper**, I often forget to use the public getter methods and instead try to read the instance variable directly 
- In `Depot` class I accessed the vehicle's registration direction instead of `vehicle.getRegistration()`
- In `Company` I accessed the `Depot`'s name directly instead of `depot.getName()`

**I got particularly tripped up in Question 2a and 2b in the 2021-2022 main exam paper:**
1. Compare C pointers to Java references.
	My current best answer is:
		**C pointers can directly access and manipulate specific memory addresses, and allow for operations like pointer arithmetic. In contrast, Java references do not provide direct memory access and do not support pointer arithmetic, focusing instead on referencing objects managed by the Java Virtual Machine (JVM).**
	But I was originally tripped up and wasn't very sure of the actual differences (the above answer is based on subsequent research.
2. Explain the meanings of weak, strong, static and dynamic typing.
	 I answered static vs dynamic typing correctly, but I had no clue what weak and strong typing meant (the prof DID NOT explain it in any lecture as far as I remember). Here's my best answer after research (perhaps should be simplified since it's 4 marks only):
	1. **Weak Typing**: In weakly typed languages, types can be automatically converted to another type without explicit consent from the programmer. This can lead to situations where operations on mismatched types are permitted, which can sometimes lead to unexpected behaviour or runtime errors.
	2. **Strong Typing**: Strongly typed languages require explicit declarations or conversions between different types, reducing the chances of type errors. In these languages, attempting to perform operations on incompatible types leads to type errors either at compile time or runtime.
	3. **Static Typing**: In statically typed languages, the type of every variable and expression is known at compile time. Errors related to type mismatches are caught early, during compilation, enhancing the predictability and reliability of the code.
	4. **Dynamic Typing**: Dynamic typing means that types are determined at runtime rather than at compile time. This allows for more flexibility in coding but can lead to runtime type errors that would be caught at compile time in statically typed languages.

**In 2c in the 2021-2022 main exam paper**, I had to list the advantages and disadvantages of recursion in relation to Java specifically. **I failed to mention Java's lack of tail-call optimization**.

**In 4i in the 2021-2022 main exam paper**, apparently the general structure of an exception class should have two constructors, one with a default message and one with the message as an argument. My original answer had only one constructor with a default message.

**In 4b.ii of 2022-2023 main exam paper**, I completely forgot how to do IO in Java (I've always just looked it up when I had to). Turns out I need to memorize the basic way to do file IO in Java. The most basic and easy to remember way it's done is as follows (*Perhaps look into the NIO way of doing it?*).
**Writing to a file:**
```java
try {  
    File file = new File("test.txt");  
    FileWriter writer = new FileWriter(file);  
    BufferedWriter bufferedWriter = new BufferedWriter(writer);  
    bufferedWriter.write("Hello, World!");
    bufferedWriter.close();  
} catch (IOException e) {  
    // handle exception if needed  
}
```
**Reading from a file:**
```java
try {  
    File file = new File("test.txt");  
    FileReader reader = new FileReader(file);  
    BufferedReader bufferedReader = new BufferedReader(reader);  
    String line;  
    while ((line = bufferedReader.readLine()) != null) {  
        System.out.println(line);  
    }
	bufferedReader.close()
} catch (IOException e) {  
    // handle exception if needed  
}
```
**General Notes on IO**
- Remember the IOException, it's the basic Exception in IO
- Make sure to always close the writer/reader at the end with `.close()`
- Can use a Scanner to turn BufferedReader into essentially a stream of ints or a stream of doubles, etc, etc. Takes care of the parsing.
- For editing existing files, potentially use `RandomAccessFile` and call `.seek()` followed by `.writeBytes()`
- Another way of reading files using NIO is to call `Files.lines(Paths.get("test.txt"))`, which returns a stream of the lines and then I can `.forEach` to loop through it. Very convenient if I remember how to work with streams.
- When handling resources, use try potentially without a catch if error is propagated to the function. More elegant than manually closing the stream/buffer. 
```java
// example from 4b.ii in main exam paper 2022-2023 (my own answer, not from an official answer sheet)
public void readFile(Path filePath) throws IOException {  
    try (Stream<String> lines = Files.lines(filePath)) { // <- automatic resource management
        lines.forEach(line -> {  
            try {  
                integers.add(Integer.parseInt(line));  
            } catch (Exception e) {  
                // line will simply be skipped as intended  
            }  
        });  
    }  
}
```
`lines` can also be looped like this, potentially easier to debug:
```java
for (String line : (Iterable<String>) lines::iterator) {
    try {
        numbers.add(Integer.parseInt(line));
    } catch (NumberFormatException e) {
        // handle exception if needed
    }
}
```

==TODO: I'm still not FULLY comfortable with all the slides content on IO, like the whole record writing and reading with seek and the NIO channels and stuff==. *(but that's likely unimportant stuff, worth a check if have time)*

**My answer to "Explain the idea of ‘Programming to an Interface’." wasn't sufficient. (1e main exam paper 2022-2023)** A better answer is the following:
	"Programming to an interface" means focusing your design on **what** the code is doing, not **how** it does it. This is a vital distinction that pushes your design towards correctness and flexibility. (Add some java specific waffle (not waffle) here)
**1f main exam paper 2022-2023**: I realized interface methods are implicitly public, so no need to declare them as such.

## Interesting Concepts
**Some definitions to remember**
**Binding** 
The term used for the process of mapping a method call to a method body that can be evaluated.

**Dynamic binding** 
Means that the method body is determined at runtime by looking at the class of the object the method is called for at runtime.
- Instance methods are always dynamically bound

**Static binding**
- Static methods are statically bound.
- This means the method body to be called is always uniquely determined.
- And can be determined when the program is compiled

**Polymorphism**
- **Parametric Polymorphism**: Allows a single piece of code to be given a "generic" type, using variables in place of actual types, and then instantiated with particular types as needed `ArrayList<String>` vs `ArrayList<Integer>`.
- **Ad Hoc Polymorphism**: Method Overloading.
- **Subtyping Polymorphism**: Method Overriding (Still not sure about how it's conceptually different from Ad Hoc though).
- Main difference between parametric and ad hoc polymorphism is that parametric polymorphic methods acts uniformly, whereas ad hoc polymorphic methods can have very distinct implementations.
- Benefits of polymorphism is it localizes changes.

Example of blurring of what type of polymorphism (maybe ask a question about it) is this:
```java
public <T extends Comparable<T>> T max(T t1, T t2) {  
    return t1.compareTo(t2) > 0 ? t1 : t2;  
}
/* 
Notice also here the constraint that both parameters need to be of the same type.
*/
```
==REVISIT THIS ADVANCED TYPE SHINANIGANS==
Here `max` is polymorphic over generic type variable `T`, but also `T` itself is polymorphic over `Comparable` meaning the extra constraint that `T` must implement `Comparable` is added (Ad hoc or subtyping?). 

- `<T extends V>`: indicates a generic type that either implements interface `V` or extends class `V`.
- `<? super T>`: indicates a wild-card type that is either T or a superclass there of. (==maybe come back to understand this more==)
- `<T, V extends T>` constraints `V` to implement the interface `T` or extend the class `T`.

**Type Erasure**: when the compiler replaces `E` (the generic type variable) for `Object` . No recompiling of new class is done for the specific type (like what rust does for non-dynamic generic type).
In a sense, type erasure erases the fact that I have an array of strings in `ArrayList<String>`, but the compiler makes it so that when I do want to get a value from ArrayList the value will be cast back to the specific type.
==Maybe explore this more==

**Packages**
Although names are nested, the package themselves aren't! For example, doing:
```java
import java.*
```
won't import all packages like `java.lang` and `java.util`.

Their nesting is so that they follow an EXACT one-to-one correspondence with the nested directory structure of project source files.

A class that is not declared as `public` is by default usable within the package, but not externally. 

**Jar**
A .jar file is essentially a zip file of the .class files in their correct package directory structure.
A .jar file can be used as an executable file when you include a manifest (meta data about the jar contents) that tells us where the main method (entry point) is.

**Charset**
A named mapping between sequences of sixteen-bit Unicode code units and sequences of bytes.

