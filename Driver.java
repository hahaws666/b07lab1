import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        double[] coeffs1 = {1,2,3};
        int[] exp1 = {1,2,4};

        double[] coeffs2 = {-1,5,6,7,9};
        int[] exp2 = {2,3,5,6,7};

        Polynomial poly1 = new Polynomial(coeffs1, exp1);
        Polynomial poly2 = new Polynomial(coeffs2, exp2);

        Polynomial sum = poly1.add(poly2);
        Polynomial product = poly1.multiply(poly2);
        System.out.println("Poly1: " + poly1);
        System.out.println("Poly2: " + poly2);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Poly1 at x=-1:" + poly1.evaluate(-0.99));
        System.out.println("Poly2 at x=2: " + poly2.evaluate(2));

        double rootValue = 1.5;
        System.out.println("Poly1 has root at x=" + rootValue + ": " + poly1.hasRoot(rootValue));


        


        double[] coeffs = {-11.0, -2.0, 3.0,99};
        int[] exps = {0, 1, 2,80};
    
        Polynomial polynomial = new Polynomial(coeffs, exps);

        polynomial.saveToFile("polynomial1.txt");
        System.out.println("saved");

        File inputFile = new File("polynomial1.txt");
        Polynomial polyFromFile = new Polynomial(inputFile);
		System.out.println("Polynomial from file: " + polyFromFile.toString());

    }
}
