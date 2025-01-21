package assignment1;

public class Main {
    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    public static double meterToFoot(double meter) {
        return meter * 3.279;
    }
    
    public static void main(String[] args) {
        System.out.printf("Feet%10s%20s%10s", "Meters", "Feet", "Meters");
        System.out.println();
        System.out.println("--------------------------------------------");
        double meterConverting = 20.0;
        for (double i = 1.0; i <= 10.0; ++i) {
            double meterConverted = footToMeter(i);
            double feetConverted = meterToFoot(meterConverting);
            System.out.printf("\s%-8.1f%-11.3f%15.1f%9.3f", i, meterConverted, meterConverting, feetConverted);
            System.out.println();
            meterConverting += 5.0;
        }

    }
}

