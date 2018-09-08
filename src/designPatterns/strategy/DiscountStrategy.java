package designPatterns.strategy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:38
 */
public interface DiscountStrategy {
    //定义一个用于计算打折价的方法
    double getDiscount(double originPrice);
}
