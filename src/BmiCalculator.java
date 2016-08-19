import java.util.Scanner;

/**
 * Created by vivek kumar on 17/8/16.
 * BMI Calculator
 */
public class BmiCalculator {
    private double height;
    private double weight;
    private static final double INCH_TO_METER = 39.3701;
    private static final double POUND_TO_KILO = 2.2046;

    Scanner in = new Scanner(System.in);

    private double convertInchesToMeter(double height) {
        return height / INCH_TO_METER;
    }

    private double convertPoundsToKilos(double weight) {
        return weight / POUND_TO_KILO;
    }

    private double getBMI() {
        return (weight / (Math.pow(height, 2)));
    }

    private void printStringMessage(String entity, String entityUnit) {
        System.out.println("Your " + entity + " in " + entityUnit);
    }

    private void setDataInMetersAndKilos() {
        printStringMessage("height", "meters");
        this.height = in.nextDouble();
        printStringMessage("weight", "kilos");
        this.weight = in.nextDouble();
    }

    private void setDataInInchesAndPounds() {
        printStringMessage("height", "inches");
        this.height = convertInchesToMeter(in.nextDouble());
        printStringMessage("weight", "pounds");
        this.weight = convertPoundsToKilos(in.nextDouble());
    }

    private void setDataInFeetInchesAndPound() {
        printStringMessage("height", "feet");
        int heightInFeet = in.nextInt();
        printStringMessage("height", "inches");
        double heightInInches = in.nextDouble();
        this.height = convertInchesToMeter(heightInFeet * 12 + heightInInches);
        printStringMessage("weight", "pound");
        this.weight = convertPoundsToKilos(in.nextDouble());
    }

    public static void main(String [] args) {
        BmiCalculator bmiCal = new BmiCalculator();
        System.out.println("Enter 1 for entering data in meters and kilograms");
        System.out.println("Enter 2 for entering data in inches and pounds");
        System.out.println("Enter 3 for entering data in feet, inches and pounds");
        Scanner in = new Scanner(System.in);
        int category = in.nextInt();
        switch (category) {
            case 1: bmiCal.setDataInMetersAndKilos();
                break;
            case 2: bmiCal.setDataInInchesAndPounds();
                break;
            case 3: bmiCal.setDataInFeetInchesAndPound();
        }
        System.out.println(String.format("%.6f", bmiCal.getBMI()));
    }



}
