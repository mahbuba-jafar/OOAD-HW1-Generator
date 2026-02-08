
import java.util.ArrayList;
import java.util.Random;
public class Generator {

private Random random = new Random();

public ArrayList<Double> populate(int n, int randomNumGen){
 ArrayList<Double> m = new ArrayList<>();

if(randomNumGen == 1){
        for (int i = 0; i < n; i++) {
            m.add(random.nextDouble());
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

    public static void main(String[] args) {
        Generator g = new Generator();
        int n = 10;
        ArrayList<Double> m = g.populate(n, 1);
        
        System.out.println(m);
        System.out.println(mean(m));
        System.out.println(stddev(m));
    }
}
