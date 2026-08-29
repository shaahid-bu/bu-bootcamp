import java.util.Arrays;

public class datatypes {
    public static void main(String[] args) {
        int myNum = 5;
        float myFloatNum = 5.99f;
        long myLongNum = 15000000L;
        double myDoubleNum = 19.99d;
        char myChar = 'D';
        boolean status = true;
        byte myByte = 100;
        // Non Primitive Data Types
        String myText = "Hello";
        var threshold = 0.75;
        System.out.println(((Object)threshold).getClass().getSimpleName());
        int a = 7; 
        int b = 2; 
        double result = a / b;
        double correct =  a / (double) b; 
        System.out.println(correct);
        double readings[] = new double[3];
        int rollnumbers[] = new int[3];
        System.out.println(Arrays.toString(rollnumbers));
    }
    
}