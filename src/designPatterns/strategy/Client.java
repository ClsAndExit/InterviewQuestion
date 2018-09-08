package designPatterns.strategy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:43
 * 使用策略模式可以让客户端代码在不同的打折策略之间切换，
 * 但也有一个小小的遗憾：客户端代码需要和不同的策略耦合。为了弥补这个不足，
 * 我们可以考虑使用配置文件来指定DiscountContext使用哪种打折策略
 * 这就彻底分离客户端代码和具体打折策略类。
 */
public class Client {
    public static void main(String[] args) {
        //客户端没有选择打折策略类
        DiscountContext dc = new DiscountContext(null);
        double price1 = 79;
        //使用默认的打折策略
        System.out.println("79元的书默认打折后的价格是："
                +dc.getDiscountPrice(price1));

        //客户端选择合适的的VIP打折策略
        dc.setDiscount(new VipDiscount());
        double price2 = 89;
        //使用VIP打折得到打着价格
        System.out.println("89元的书对VIP用户的价格是："
                +dc.getDiscountPrice(price2));
    }
}
