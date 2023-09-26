public class Polynomial {
    double[] coff;
    public Polynomial() {
        coff = new double[]{0};
    }

    public Polynomial(double[] coefficients) {
        this.coff = coefficients.clone();
    }

    public Polynomial add(Polynomial p1) {
        int smm;
    	double largest [];
    	
    	
    	if((p1.coff).length < coff.length) {
    		smm = (p1.coff).length;
    		largest = coff;
    	} else {
    		smm = coff.length;
    		largest = (p1.coff);
    	}

    	Polynomial newCoefficients = new Polynomial();
    	newCoefficients.coff = new double[largest.length];
    	    	
    	for (int i = 0; i < largest.length; i++) {
    		if(i >= smm) {
    			newCoefficients.coff[i] = largest[i];
    		} else {
    			newCoefficients.coff[i] = coff[i] + (p1.coff)[i];
    		}
    	}
    	return newCoefficients;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coff.length; i++) {
            result += coff[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }




}