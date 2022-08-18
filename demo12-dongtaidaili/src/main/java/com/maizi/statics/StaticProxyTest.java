package com.maizi.statics;

//接口定义要代理的事情
interface ClothFactory {
    void produceCloth();//帮忙加工材料
}

//被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }//自己组装
}

//被代理类
class AdidasClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Adidas工厂生产一批运动服");
    }//自己组装
}

class ProxyClothFactory implements ClothFactory {

    private final ClothFactory clothFactory;
    public ProxyClothFactory(ClothFactory factory) {
        this.clothFactory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();//自己组装
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

/**
 * 动态代理的举例
 *
 * @version 1.0
 * @author: MaiZi
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        final NikeClothFactory nike = new NikeClothFactory();
        final AdidasClothFactory adidas = new AdidasClothFactory();
        ClothFactory factory = new ProxyClothFactory(adidas);
        factory.produceCloth();
    }
}
