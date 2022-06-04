package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    //iny4ectar la dependencia deasde el bean en cofiguracion
    private MyOperation myOperation; //interfaz

    public MyBeanWithDependencyImplement(MyOperation myOperation) {  //interfaz

        this.myOperation = myOperation; //inyecion de dependencia
    }

    //implementacion de la dependencia
    @Override
    public void printWithDependency() {
        int num = 3;
        System.out.println(myOperation.sum(num));
        System.out.println("Implementacion desde un bean con dependencia");
    }
}
