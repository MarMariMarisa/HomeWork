package unit11.pi;

import org.apfloat.Apfloat;

public interface PiTermCalculator {
    /**
     * Calculates a single term in the series
     * @param n Term number to calculate
     * @return Calculated value for the nth term
     */
    Apfloat calculateTerm (long n);

    /**
     * Any final adjustments that need to happen to the series 
     * sum in order to calculate pi.
     * @param sum Sum of all terms in the series
     * @return Final pi calculation
     */
    Apfloat finalAdjustment (Apfloat sum);

    long getPrecision ();
}
