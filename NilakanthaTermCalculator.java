package unit11.pi;

import org.apfloat.Apfloat;

/**
 * The Nilkantha series for calculating Pi
 * π = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8) - ...
 */
public class NilakanthaTermCalculator implements PiTermCalculator{
    // Constant example
    private final Apfloat three;
    private final long precision;


    public NilakanthaTermCalculator (long precision) {
        this.precision = precision;
        three = new Apfloat (3, precision);
    }

    @Override
    public Apfloat calculateTerm (long n) {
        if (n == 0) {
            return three;
        }
        double s = n * 2;
        Apfloat num = new Apfloat (4 * Math.pow (-1, (n + 1) % 2), precision);
        Apfloat denom = new Apfloat (s * (s + 1) * (s + 2), precision);
        return num.divide (denom);
    } 

    @Override
    public Apfloat finalAdjustment(Apfloat sum) {
        // Nothing extra to do for this series, the sum
        // is the solution
        return sum;
    }

    @Override
    public long getPrecision() {
        return precision;
    }
}
