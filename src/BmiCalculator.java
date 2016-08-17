import java.util.Scanner;

/**
 * Created by vivek kumar on 17/8/16.
 * BMI Calculator
 */
public class BmiCalculator {
    private double height;
    private double weight;
    private double inchToMeterConversionRatio = 39.3701;
    private double poundToKiloConversionRatio = 2.2046;

    private BmiCalculator(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    private void convertToMetricFromImperial(double height, double weight) {
        this.height = height / inchToMeterConversionRatio;
        this.weight = weight / poundToKiloConversionRatio;
    }

    private void convertToMetricFromImperial(int feet, int inch, double weight) {
        this.height = (feet * 12 + inch) / inchToMeterConversionRatio;
        this.weight = weight / poundToKiloConversionRatio;
    }

    private double getBMI() {
        return (weight / (Math.pow(height, 2)));
    }

    private void getDataFromUser(String heightUnit, String weightUnit) {
        int feet;
        int inches;
        double height;
        double weight;
        String info = String.format("Enter you height in %s", heightUnit);
        System.out.println(info);

    }

    public static void main(String [] args) {
        double height;
        double weight;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your height in meters");
        height = in.nextDouble();
        System.out.println("Enter you weight in kilograms");
        weight = in.nextDouble();
        BmiCalculator bc = new BmiCalculator(weight, height);
        System.out.println("Your BMI is " + bc.getBMI());
    }
}
