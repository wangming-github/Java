package java1;

import org.junit.Test;

import java.util.Random;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/18 05:45
 */
public class NewInstanceTest {


    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        /**
         * newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
         * <p>
         * 要想此方法正常的创建运行时类的对象，要求：
         * 1.运行时类必须提供空参的构造器
         * 2.空参的构造器的访问权限得够。通常，设置为public。
         * <p>
         * 在javabean中要求提供一个public的空参构造器。原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        final Class<Person> personClass = Person.class; //指定泛型，则不需要强制类型转换
        final Person person = personClass.newInstance();
        System.out.println(person); //Person{name='null', age=0}
    }

    /**
     * 创建一个指定类的对象。
     * classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.maizi.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
