# Java functional programming

See the [Main file here](https://github.com/FrankSiret/java-functional-programming/blob/master/src/fp/Main.java) 

### 1. Java util function package

Functional interface provide target types for lambda expressions and method references.

```java
// Assignment context
Predicate<String> p = String::isEmpty;

// method invocation context
stream.filter(e -> e.getSize() > 10)...

// Cast context
stream.map((ToIntFunction) e -> e.getSize())...
```

### 2. Predicate<T>

Represent a predicate (boolean-valued function) of on argument.

```java
Predicate<Person> isFemale = person -> FEMALE.equals(person.gender);
...
isFemale.test(person);
...
// isPhoneNumberValidPredicate && containsNumber3
isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003")); 
```

### 3. Function<T,R>

Represents a function that accepts one argument and produces a result.

```java
static Function<Integer, Integer> incrementByOne = number -> number + 1;
...
int increment = incrementByOne.apply(1);
```

### 4. Chaining functions

```java
int addMultiply = incrementByOne.andThen(multiplyBy10).apply(1); // (n + 1) * 10
```

### 5. BiFunction<T,U,R>

Represent a function that accepts two arguments and produce a result.

```java
static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (number, multiplyBy) -> (number + 1) * multiplyBy;
```

### 6. Consumer<T>

Represent an operation that accepts a single input argument and returns no result.

```java
Consumer<Customer> greetCustomerConsumer = customer -> System.out::println;
```

### 7. BiConsumer<T,U>

Represent an operation that accepts two input arguments and returns no result.

```java
Consumer<Customer,Boolean> greetCustomerConsumerV2 = (customer, show) -> System.out::println;
```

### 8. BiPredicate<T,U> 

### 9. Supplier<T>

Return a value

```java
static Supplier<List<String>> getDBConnectionUrls = () -> List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
...
getDBConnectionUrls.get();
```

### 10. Java Optionals

A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.

Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).

This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.

See at [java optionals here](https://github.com/FrankSiret/java-functional-programming/blob/master/src/optionals/Main.java) 

### 11. Combinator Pattern

See at [Combinator Pattern project here](https://github.com/FrankSiret/java-functional-programming/tree/master/src/combinatorpattern)

### 12. Callbacks and Lambdas

### 13. Conclusions

Pure functional programming has a set of rules to follow

- No state
- Pure Functions
- No Side Effects
- Higher Orden Functions
	> The function takes one or more funtions as parameters. <br>
	> The function returns another function as result.