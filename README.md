# java-functional-programming

See the [Main file here](https://github.com/FrankSiret/java-functional-programming/blob/master/src/fp/Main.java) 

1. Java util function package

Functional interface provide target types for lambda expressions and method references.

```java
// Assignment context
Predicate<String> p = String::isEmpty;

// method invocation context
stream.filter(e -> e.getSize() > 10)...

// Cast context
stream.map((ToIntFunction) e -> e.getSize())...
```

2. Predicate<T>

Represent a predicate (boolean-valued function) of on argument.

```java
Predicate<Person> isFemale = person -> FEMALE.equals(person.gender);
```

3. Function<T,R>

Represents a function that accepts one argument and produces a result.

```java
static Function<Integer, Integer> incrementByOne = number -> number + 1;
...
int increment = incrementByOne.apply(1);
```

4. Chaining functions

```java
int addMultiply = incrementByOne.andThen(multiplyBy10).apply(1); // (n + 1) * 10
```

5. BiFunction<T,U,R>

Represent a function that accepts two arguments and produce a result.

```java
static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (number, multiplyBy) -> (number + 1) * multiplyBy;
```

6. Consumer<T>

Represent an operation that accepts a single input argument and returns no result.

```java

```