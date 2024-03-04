package pl.dmcs.iwalecture.model;

import java.math.BigInteger;

public class Fibonacci {

    private String result;
    private int nthNumber;
    public void setNumber(int n) {

        nthNumber = n;
        BigInteger fibPrev = BigInteger.ZERO;
        BigInteger fibCur = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger temp = fibCur;
            fibCur = fibCur.add(fibPrev);
            fibPrev = temp;
        }

        result = fibCur.toString();
    }

    public String getNumber() { return result; }

    public String getNthNumber() { return String.valueOf(nthNumber); }
}
