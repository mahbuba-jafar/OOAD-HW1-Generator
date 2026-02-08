
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Generator {

private Random random = new Random();

public ArrayList<Double> populate(int n, int randNumGen){
 ArrayList<Double> m = new ArrayList<>();

    if(randNumGen == 1){
        for (int i = 0; i < n; i++) {
            m.add(random.nextDouble());
        }
    }
    if(randNumGen == 2){
        for (int i = 0; i < n; i++) {
            m.add(Math.random());
        }
    }
    if(randNumGen == 3){
        for (int i = 0; i < n; i++) {
            m.add(ThreadLocalRandom.current().nextDouble());
        }
    }
    return m;
}


public static double mean(ArrayList<Double> m) {
    double sum = 0.0;
    for (int i = 0; i < m.size(); i++) {
        sum += m.get(i);
    }
    return sum / m.size();
}

public static double stddev(ArrayList<Double> m) {
    double avg = mean(m);
    double sum = 0.0;

    for (int i = 0; i < m.size(); i++) {
        sum += Math.pow(m.get(i) - avg, 2);
    }

    return Math.sqrt(sum / (m.size() - 1));
}

public ArrayList<Double> statistics(ArrayList<Double> randomValues){

    ArrayList<Double> results = new ArrayList<>();

    int n = randomValues.size();

    double meanValue = mean(randomValues);
    double stddevValue = stddev(randomValues);
    double minValue = Collections.min(randomValues);
    double maxValue =Collections.max(randomValues);
    
    results.add((double)n);
    results.add(meanValue);
    results.add(stddevValue);
    results.add(minValue);
    results.add(maxValue);

    return results;


}

    public static void main(String[] args) {
        Generator g = new Generator();
        int n = 10;
        ArrayList<Double> m = g.populate(n, 1);
        
        ArrayList<Double> t = g.statistics(m);
        // System.out.println(statistic.t);
        System.out.println(m);
        System.out.println(t);
    }
}
