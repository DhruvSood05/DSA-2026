
public class Power {
    public double myPow(double x, int n) {

        long num = n;
        // your code goes here
        if (num == 0)
            return 1.0;

        if (num == 1)
            return x;

        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        if (num % 2 == 1) {
            return x * myPow(x, (int) (num - 1));
        } else {
            return myPow(x * x, (int) (num / 2.0));
        }
    }
}
