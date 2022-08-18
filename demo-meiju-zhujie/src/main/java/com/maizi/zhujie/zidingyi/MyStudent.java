package com.maizi.zhujie.zidingyi;


@Maizi(value = "A")
@Maizi(value = "B")
class MyStudent extends MyPerson implements MyInfo {

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {

    }
}
