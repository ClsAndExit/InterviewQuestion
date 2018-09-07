package test1;

/**
 * @author Mr.Zhang
 * @create 2018-09-07 18:41
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(0.09+0.01);
    }

    /*
    因为使用Java的时候涉及到double类型的精度问题
    转载两个由C++编写的代码


    double sqrtBinary(double A)
    {
//   二分法实现开方
//	 需要注意的是：
//	 1.初始上界是A+0.25，而不是A
//	 2.double型的精度DBL_EPSILON，不能随意指定


    double a = 0.0, b = A + 0.25, m;  // b = A 是错误的上届
    // while(b - a > 2*DBL_EPSILON){  //sometimes dead cycle when m == a or m == b.
	for (;;)
    {
        m = (b + a) / 2;
        if (m - a < DBL_EPSILON || b - m < DBL_EPSILON) break;
        if ((m*m - A) * (a*a - A) < 0) b = m;
        else a = m;
    }
	return m;
}

DBL_EPSILON的用法请参考：http://blog.csdn.net/x356982611/article/details/19922453


2、牛顿迭代法

double sqrtND(double A)  //牛顿迭代法
{
	double x0 = A + 0.25, x1, xx = x0;
	for (;;)
	{
		x1 = (x0*x0 + A) / (2 * x0);
		if (fabs(x1 - x0) <= DBL_EPSILON) break;
		if (xx == x1) break;  //to break two value cycle.
		xx = x0;
		x0 = x1;
	}
	return x1;
}
     */
}
