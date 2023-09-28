import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Polynomial {
    double[] coff;
    int[] degree;
    public Polynomial(){
        coff=new double[] {0};
        degree=new int[]{0};
    }

    public Polynomial(double[] cof, int[] deg){
        this.coff=cof.clone();
        this.degree=deg.clone();
    }
    public Polynomial add(Polynomial p1){
        Polynomial ress=new Polynomial(this.coff.clone(),this.degree.clone());
        List<Double> cof= new ArrayList<>();
        List<Integer> exp = new ArrayList<>();
        int a=0;
        int b=0;
        while (b<p1.degree.length) {
            int oo=0;
            for (int i = 0; i < ress.degree.length; i++) {

                if (p1.degree[b]==ress.degree[i]) {
                    oo=1;
                    ress.coff[i]+=p1.coff[b];
                    if (ress.coff[i]!=0) {
                        cof.add(ress.coff[i]);
                        exp.add(ress.degree[i]);
                    }
                }
            }
            if(oo==0){
            cof.add(p1.coff[b]);
            exp.add(p1.degree[b]);
            }
            b++;
        }
        while (a<ress.degree.length) {
            int k=0;
            for (int i = 0; i < exp.size(); i++) {

                if (ress.degree[a]==exp.get(i)) {
                    k=1;
                }
            }
            if (k==0) {
                    exp.add(ress.degree[a]);
                    cof.add(ress.coff[a]);
                }
            a++;
            
        }
        double[] resultCoefficients=cof.stream().mapToDouble(Double::doubleValue).toArray();
        int[] resultExponents = exp.stream().mapToInt(Integer::intValue).toArray();
        return new Polynomial(resultCoefficients, resultExponents);

    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coff.length; i++) {
            result += coff[i] * Math.pow(x, degree[i]);
        }
        return result;
    }
    

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }

    public Polynomial multiply(Polynomial p1){
        Polynomial res=new Polynomial();
        for (int i = 0; i < this.coff.length; i++) {
            for (int j = 0; j < p1.coff.length; j++) {
                double[] cof=new double[1];

                double ppp=(this.coff[i])*(p1.coff[j]);
                cof[0]=ppp;
                int[] deg=new int[1]; 
                deg[0]=this.degree[i]+p1.degree[j];
                Polynomial neww=new Polynomial(cof, deg);
                res=res.add(neww);
            }
        }
        return res;
    }


    public Polynomial(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNext()) {
                String polynomialString = scanner.nextLine();
                parsePolynomial(polynomialString);
            } else {
                coff = new double[]{0};
                degree = new int[]{0};
            }
        }
    }

    private void parsePolynomial(String polynomialString) {
        String[] termStrings = polynomialString.split("(?=[+-])");
    
        List<Double> coefficientList = new ArrayList<>();
        List<Integer> exponentList = new ArrayList<>();
    
        for (String term : termStrings) {
            String[] parts = term.split("x");
    
            if (parts.length == 1) {

                    coefficientList.add(Double.parseDouble(parts[0]));
                    exponentList.add(0);
            } else {
                coefficientList.add(Double.parseDouble(parts[0]));
                exponentList.add(Integer.parseInt(parts[1]));
            }
        }
        coff = coefficientList.stream().mapToDouble(Double::doubleValue).toArray();
        degree = exponentList.stream().mapToInt(Integer::intValue).toArray();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean f = true;
    
        for (int i = 0; i < coff.length; i++) {
            if (coff[i] != 0) {
                if (!f) {
                    if (coff[i]>0) {
                        builder.append("+");
                    } else {
                        builder.append("-");
                    }
                } else {
                    f = false;
                }
                double absCoefficient = Math.abs(coff[i]);
                builder.append(absCoefficient);
                if (degree[i] != 0) {
                    builder.append("x");
                        builder.append(degree[i]);
                }
            }
        }
        return builder.toString().replace(" ", "");
    }

    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(this.toString());
            writer.close();
        }
    }
}
