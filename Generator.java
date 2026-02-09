/*
Name: Mahbuba Jafarzada
Course: Object Oriented Analysis and Design
Project:Assignment 1 - Generator
Date: 09.02.2026
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Class definition (explicit):
 * The Generator class is responsible for generating random numbers
 * using different Java random number generators, computing descriptive
 * statistics, and displaying the results.
 */

public class Generator {
// Accessibility examples in this file:
// - private attribute: random
// - public methods: populate(), statistics()
// - static methods: mean(), stddev()


// Class attribute(explicit): This class has a class attribute with PRIVATE accessibilit
private Random random = new Random();

/**
 * Method definition(explicit): This method creates and returns n random doubles in [0,1) 
 * using the selected generator.
 * @param n number of values to generate
 * @param randNumGen 1=Random, 2=Math.random, 3=ThreadLocalRandom
 * @return ArrayList of generated values
 * Accessibility: public
 */

public ArrayList<Double> populate(int n, int randNumGen){
 ArrayList<Double> m = new ArrayList<>();

    if(randNumGen == 1){
        for (int i = 0; i < n; i++) {
            m.add(random.nextDouble());
        }
    }
    else if(randNumGen == 2){
        for (int i = 0; i < n; i++) {
            m.add(Math.random());
        }
    }
    else if(randNumGen == 3){
        for (int i = 0; i < n; i++) {
            m.add(ThreadLocalRandom.current().nextDouble());
        }
    }
    return m;
}

/** 
     * Method definition (explicit):
     * Calculates the mean (average) of the given list of values.
     * @param m list of double values
     * @return mean of the values
*/

public static double mean(ArrayList<Double> m) {
    double sum = 0.0;
    for (int i = 0; i < m.size(); i++) {
        sum += m.get(i);
    }
    return sum / m.size();
}
/**
     * Method definition (explicit):
     * Calculates the sample standard deviation of the given list of values.
     * @param m list of double values
     * @return sample standard deviation
 */
public static double stddev(ArrayList<Double> m) {
    double avg = mean(m);
    double sum = 0.0;

    for (int i = 0; i < m.size(); i++) {
        sum += Math.pow(m.get(i) - avg, 2);
    }

    return Math.sqrt(sum / (m.size() - 1));
}

 /**
     * Method definition (explicit):
     * Computes descriptive statistics for a list of random values.
     * The returned list contains values in the following order:
     * [n, mean, stddev, min, max]
     *
     * @param randomValues list of generated random values
     * @return ArrayList<Double> containing statistics
*/
    
public ArrayList<Double> statistics(ArrayList<Double> randomValues){

    ArrayList<Double> results = new ArrayList<>();

    int n = randomValues.size();

     // Safety check: handle empty list
    if (n == 0) {
        results.add(0.0); // n
        results.add(0.0); // mean
        results.add(0.0); // stddev
        results.add(0.0); // min
        results.add(0.0); // max
        return results;
    }

    double meanValue = mean(randomValues);
    double stddevValue = (n < 2) ? 0.0 : stddev(randomValues);
    double minValue = Collections.min(randomValues);
    double maxValue =Collections.max(randomValues);
    
    results.add((double)n);
    results.add(meanValue);
    results.add(stddevValue);
    results.add(minValue);
    results.add(maxValue);

    return results;


}

 /**
     * Method definition (explicit):
     * Displays the statistics in a formatted table.
     * @param results list containing [n, mean, stddev, min, max]
     * @param headerOn true to print the table header, false otherwise
*/

public void display(ArrayList<Double> results, boolean headerOn){
    if (headerOn) {
        System.out.printf(
            "%-8s %-10s %-10s %-10s %-10s%n",
            "n", "mean", "stddev", "min", "max"
        );
    }

    System.out.printf(
        "%-8.0f %-10.4f %-10.4f %-10.4f %-10.4f%n",
        results.get(0),
        results.get(1), 
        results.get(2),
        results.get(3),
        results.get(4)
    );
}
 /**
     * Method definition (explicit):
     * Executes by running all combinations
     * of sample sizes and random number generators.
     */
public void execute(){
    int[] n = {10,1000,10000};

boolean headerOn = true;

    for (int i = 0; i < n.length; i++) {
        for (int j = 1; j <=3 ; j++) {
            ArrayList<Double> values = populate(n[i], j);
            ArrayList<Double> stats = statistics(values);
            display(stats, headerOn);
            headerOn = false;
        }
    }
}
    /**
     * Object instantiation (explicit): 
     * Main method (program entry point).
     * Creates a Generator object and starts execution.
     *
     * Object instantiation:
     * Generator g = new Generator();
     */
    public static void main(String[] args) {
        Generator g = new Generator();
        g.execute();

    }
}