package java3;

import com.maizi.java2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 属性测试
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/18 06:27
 */
public class FieldTest {


    @Test
    public void test1() {
        final Class<Person> personClass = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        final Field[] fields = personClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);
        //public int com.maizi.java2.Person.id
        //public double com.maizi.java2.Creature.weight

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        final Field[] declaredFields = personClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
        //private java.lang.String com.maizi.java2.Person.name
        //int com.maizi.java2.Person.age
        //public int com.maizi.java2.Person.id
    }

    //权限修饰符  数据类型 变量名
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");
            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
            System.out.println();
        }
        /*
         * private	java.lang.String	name
         * 	        int	age
         * public	int	id
         */
    }
}
