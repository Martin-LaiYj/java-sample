package com.martin.mysample.designpattern;

import com.martin.mysample.pattern.structural.adapter.adapter.Adaptee;
import com.martin.mysample.pattern.structural.adapter.adapter.Adapter;
import com.martin.mysample.pattern.structural.adapter.target.Target;
import com.martin.mysample.pattern.structural.decorator.component.Component;
import com.martin.mysample.pattern.structural.decorator.component.ConcreteComponent;
import com.martin.mysample.pattern.structural.decorator.decorator.ConcreteDecoratorA;
import com.martin.mysample.pattern.structural.decorator.decorator.ConcreteDecoratorB;
import com.martin.mysample.pattern.structural.decorator.decorator.Decorator;
import com.martin.mysample.pattern.behavioral.observer.observer.ConcreteObserver;
import com.martin.mysample.pattern.behavioral.observer.observer.Observer;
import com.martin.mysample.pattern.behavioral.observer.subject.ConcreteSubject;
import com.martin.mysample.pattern.structural.proxy.subject.Subject;
import com.martin.mysample.pattern.creational.factory.factory.AbstractFactory;
import com.martin.mysample.pattern.creational.factory.factory.ConcreteAbstractFactoryA;
import com.martin.mysample.pattern.creational.factory.factory.ConcreteAbstractFactoryB;
import com.martin.mysample.pattern.structural.proxy.proxy.Proxy;
import com.martin.mysample.pattern.creational.singleton.EnumSingle;
import com.martin.mysample.pattern.creational.singleton.HungrySingle;
import com.martin.mysample.pattern.creational.singleton.LazySingle;
import com.martin.mysample.pattern.creational.singleton.Singleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;

/**
 * DesignPatternTest
 *
 * @author Martin
 * @since 2023-11-01 22:01
 **/

@SpringBootTest
public class DesignPatternTest {

    // @Autowired
    // AbstractFactory factory;

    // @Test
    // public void testSimpleFactory(){
    //     AbstractFactory factory1 = new AbstractFactory();
    //
    //     factory1.test();
    //
    //     AbstractProductA productA = factory.createProductA();
    //     AbstractProductA productB = factory.createProductB();
    //
    //     System.out.println("productA = " + JsonUtils.toJSONString(productA));
    //     System.out.println("productB = " + JsonUtils.toJSONString(productB));
    // }

    // @Test
    // public void testConcreteFactory() {
    //     Factory afA = new ConcreteFactoryA();
    //     Factory afB = new ConcreteFactoryB();
    //
    //     afA.createProduct();
    //     afB.createProduct();
    // }

    @Test
    public void testAbstractFactory() {
        AbstractFactory afA = new ConcreteAbstractFactoryA();
        AbstractFactory afB = new ConcreteAbstractFactoryB();

        afA.createProductA();
        afA.createProductB();
        afB.createProductA();
        afB.createProductB();
    }

    @Test
    public void testHungrySingle() throws Exception {
        // 获取正常初始化的LazySingleA对象
        HungrySingle hungrySingle = HungrySingle.getInstance();
        System.out.println("hungrySingle = " + hungrySingle);

        // 通过构造器反射获取构造器后新建一个LazySingleA对象
        Constructor<HungrySingle> declaredConstructor = HungrySingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        HungrySingle hungrySingle1 = declaredConstructor.newInstance();
        System.out.println("hungrySingle1 = " + hungrySingle1);
    }

    @Test
    public void testLazySingle() {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + LazySingle.getInstance());
            }).start();

        }
    }

    @Test
    public void testLazySingle1() {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + LazySingle.getInstance1());
            }).start();

        }
    }

    @Test
    public void testLazySingle3() {
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + LazySingle.getInstance3());
            }).start();
        }
    }

    @Test
    public void testStaticInnerClass() {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("instance = " + instance);
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
    }

    @Test
    public void testEnumSingle() {
        System.out.println("EnumSingle.INSTANCE = " + EnumSingle.INSTANCE);

    }

    @Test
    public void testAdapter() {
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }

    @Test
    public void testProxy() {
        Subject proxy = new Proxy("测试信息");
        proxy.request();
    }

    @Test
    public void testObserver() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver(subject, "Observer1");
        Observer observer2 = new ConcreteObserver(subject, "Observer2");
        subject.attach(observer1);
        subject.attach(observer2);

        subject.updateState("running!");

        subject.detach(observer1);
        subject.updateState("stop!");

    }

    @Test
    public void testDecorator() {
        Component component = new ConcreteComponent();
        Decorator concreteDecoratorA = new ConcreteDecoratorA(component, "concreteDecoratorA");
        Decorator concreteDecoratorB = new ConcreteDecoratorB(component, "concreteDecoratorB");

        concreteDecoratorA.operate();
        concreteDecoratorB.operate();
    }

    @Test
    public void testChain() {
        String name = "martin";
        switch (name) {
            case "jack":
                System.out.println("No no, that's not the people I know...");
                break;
            case "martin":
                System.out.println("Yeah, Here you are!");
                break;
            default:
                System.out.println("Alright, I can't find him...");
        }
    }


}
