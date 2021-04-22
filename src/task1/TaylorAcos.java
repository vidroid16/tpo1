package task1;

import java.math.BigInteger;
public class TaylorAcos {
    public static double getAcos(double x) {
        if(Math.abs(x)>1){
            return Double.NaN;
        }
        double xn = 0, prevSum = 1.0, sum = 0.0;
        final double EPS = 1e-10, INF = 1.0e8;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        BigInteger big_coef = BigInteger.ONE;
        double coef1 = 1;
        double coef2 = 1;
        double coef = 1;


        for (int n = 0; Math.abs(sum - prevSum) > EPS; n++) {
            prevSum = sum;
            a = factorial(2*n);
            b = BigInteger.valueOf((long) Math.pow(2,n)).multiply(factorial(n));
            b = b.multiply(b);
            c = BigInteger.valueOf(2*n+1);
            big_coef = b.multiply(c);
            coef2 = big_coef.doubleValue();
            coef1 = a.doubleValue();
            coef = coef1/coef2;
            //System.out.println(coef);
            xn = coef* Math.pow(x, (2*n)+1);
            sum += xn;
        }

        if (Math.abs(sum) >INF){
            return INF;
        }else{
            return (Math.PI / 2) - sum;
        }
    }

    static BigInteger factorial(int N)
    {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));
        return f;
    }
}
