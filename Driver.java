import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        double[] coeffs1 = {-1,1};
        int[] exp1 = {0,1};

        double[] coeffs2 = {1,1};
        int[] exp2 = {1,0};

        Polynomial poly1 = new Polynomial(coeffs1, exp1);
        Polynomial poly2 = new Polynomial(coeffs2, exp2);

        Polynomial sum = poly1.add(poly2);
        Polynomial product = poly1.multiply(poly2);
        System.out.println("Poly1: " + poly1);
        System.out.println("Poly2: " + poly2);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Evaluate Poly1 at x=-1: " + poly1.evaluate(-0.99));
        System.out.println("Evaluate Poly2 at x=2: " + poly2.evaluate(2));

        double rootValue = 1.5;
        System.out.println("Poly1 has root at x=" + rootValue + ": " + poly1.hasRoot(rootValue));


        


        double[] coeffs = {1.0, -2.0, 3.0,99};
        int[] exps = {0, 1, 2,80};
    
        Polynomial polynomial = new Polynomial(coeffs, exps);

        polynomial.saveToFile("polynomial1.txt");
        System.out.println("saved to polynomial1.txt");

        File inputFile = new File("polynomial.txt");
        Polynomial polyFromFile = new Polynomial(inputFile);
		System.out.println("Polynomial from file: " + polyFromFile);

    }
}
