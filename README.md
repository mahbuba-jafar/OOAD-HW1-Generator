# Assignment 1 – Random Number Generator Analysis

## Project Description

This project implements a Java program that generates random numbers using three different built-in Java random number generators and analyzes the generated data using descriptive statistics.

The program compares the behavior of different random number generators as the sample size increases.

---

## Random Number Generators Used
The `randNumGen` parameter selects which generator is used:
- `1` → `java.util.Random`
- `2` → `Math.random()`
- `3` → `java.util.concurrent.ThreadLocalRandom`

## Sample Sizes (n values)
The program runs the experiment for these sample sizes:
- `n = 10`
- `n = 1000`
- `n = 10000`

---

## Statistics Computed

For each generator and sample size, the following descriptive statistics are calculated:

* **n** (number of elements)
* **Mean**
* **Sample Standard Deviation**
* **Minimum**
* **Maximum**

As the sample size increases:

* The mean approaches **0.5**
* The standard deviation approaches **~0.29**
* The minimum approaches **0**
* The maximum approaches **1**

---

##  Program Structure

The program consists of a single Java class:

### `Generator`

**Main methods:**

* `populate(int n, int randNumGen)`
  Generates random values using the selected generator.
* `statistics(ArrayList<Double> randomValues)`
  Computes descriptive statistics.
* `display(ArrayList<Double> results, boolean headerOn)`
  Displays results in a formatted table.
* `execute()`
  Runs all combinations of sample sizes and generators.

The `main` method creates an instance of `Generator` and calls `execute()`.

---

## How to Compile and Run

### Compile

```
javac Generator.java
```

### Run

```
java Generator
```

---

## Sample Output (Example)

```
n        mean       stddev     min        max
10       0.5123     0.3012     0.0412     0.9876
1000     0.4987     0.2894     0.0004     0.9998
10000    0.5001     0.2889     0.0001     0.9999
```

---

## Technologies Used

* Java
* `ArrayList`
* `java.util.Random`
* `Math.random()`
* `ThreadLocalRandom`

---

## Notes

* The program follows object-oriented principles.
* All required methods, accessibility examples, and documentation are included.
* No external libraries were used.
* Although not explicitly required by the assignment specification, the display() and execute() methods were declared public to improve consistency, clarity, and potential reusability.

## Possible Improvements

- The current output displays statistical results for each combination of
  sample size and random number generator.  
- For improved readability, the output could be extended to explicitly label
  which random number generator (Random, Math.random, ThreadLocalRandom)
  produced each row.
- This was not implemented in the current version in order to strictly follow
  the required method signature of `display(ArrayList<Double>, boolean)` as
  specified in the assignment.
