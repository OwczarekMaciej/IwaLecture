package pl.dmcs.iwalecture.model;


public class Fibonacci {

    private int result;
    public void setNumber(int n) {

        int f[] = new int[n + 2];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        this.result = f[n];
    }

    public int getNumber() { return result; }
}
