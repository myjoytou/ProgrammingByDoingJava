import java.util.Scanner;

/**
 * Created by vivek kumar on 17/8/16.
 * BMI Calculator
 */
public class BmiCalculator {
//    private double height;
//    private double weight;
//
//    public BmiCalculator(double height, double weight) {
//        this.height = height;
//        this.weight = weight;
//    }

    private double getBMI(double weight, double height) {
        return (weight / (Math.pow(height, 2)));
    }

    public static void main(String [] args) {
        double height;
        double weight;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your height in meters");
        height = in.nextDouble();
        System.out.println("Enter you weight in kilograms");
        weight = in.nextDouble();
        BmiCalculator bc = new BmiCalculator();
        System.out.println("Your BMI is " + bc.getBMI(weight, height));
    }
}
