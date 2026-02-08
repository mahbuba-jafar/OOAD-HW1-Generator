
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        ArrayList<Float> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            m.add(random.nextFloat());
                    // System.out.println(random.nextFloat());

        }
        // ArrayList<Float> m = new ArrayList<>();
        System.out.println(m);
    }
}
