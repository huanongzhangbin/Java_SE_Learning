import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaMain {

    /**
     * 函数式接口：只有一个抽象方法
     * @FunctionalInterface和@Override一样，只是辅助编译器检查，如果不符和函数式接口的条件会在开发工具提示我们，其实不加该注解，编译器也能识别函数式接口
     */


    /**
     * 函数型 Function接口，传入参数T,返回参数R
     */
    public  static void  funtionTest(){
        /**
         * 函数接口，只有一个参数传入，没有返回值。
         */
        Function<Integer,Integer> function1=(Integer t)->{//lambda表达式
            return t=t+1;//普通写法
        };
        Function<Integer,Integer> function2=(t)->t*=2;//一行表达式时,可不写return

        /**
         * 配置前置处理
         */
        Function<Integer,Integer> function3=function2.compose(function1);//把1放在2之前

        /**
         * 配置后置处理，返回的时一个新的funtion接口
         */
        Function<Integer,Integer> function4=function1.andThen(function2);//把2放在1之后

        //给实例传入具体参数
        System.out.println(function3.apply(1));
        System.out.println(function4.apply(1));

    }

    public static  void  sayHello(String name){
        System.out.println("hello:"+name);
    }

    /**
     * 消费型接口，Consumer,传入参数T,没有返回值
     */
    public static void   consumeTest(){
        Consumer<String> consumer1=(String t)->{//正常写法,
            System.out.println("hello"+t);
        };

        Consumer<String> consumer2= System.out::println;//方法引用写法。

        Consumer<String > consumer3=LambdaMain::sayHello;//自己写的方法，用lambda表达式嵌入在此

        consumer1.accept("jack");
        consumer2.accept("jack");
        consumer3.accept("jack");

    }

    /**
     * 供给型接口,返回参数R，相当于是工厂
     */
    public static void  supplierTest(){
        Supplier<Integer> supplier=()->{
            return (Integer) new Double(Math.random()*10000).intValue();
        };

        System.out.println("生成一个随机数"+supplier.get());

        /**
         * 构造器引用
         */
        Supplier<User> userSupplier=User::new;
        System.out.println("生成一个user对象"+userSupplier.get().toString());
    }


    public static void predictTest(){
        Predicate<Integer> predicate1=num->num>18;
        Predicate<Integer> predicate2=num->num%2==0;
        Predicate<Integer> predicate=predicate1.and(predicate2);
        System.out.println("年龄大于18&&年龄是偶数:"+predicate.test(22));

    }
    public static void main(String[] args) {
       // funtionTest();
       // consumeTest();
        supplierTest();
      //  predictTest();
    }
}
class User{

}