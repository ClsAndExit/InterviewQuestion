package designPatterns.strategy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:39
 */

//DiscountStrategy 接口的实现，提供VIP打折算法
public class VipDiscount implements DiscountStrategy {
    //重写getDiscount方法，提供VIP打折算法
    @Override
    public double getDiscount(double originPrice) {
        System.out.println("使用VIP折扣...");
        return originPrice*0.5;
    }
}
