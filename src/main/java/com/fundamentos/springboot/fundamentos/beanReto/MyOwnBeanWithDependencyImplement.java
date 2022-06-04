package com.fundamentos.springboot.fundamentos.beanReto;

import java.util.List;

public class MyOwnBeanWithDependencyImplement implements MyOwnBeanWithDependency {

    //inyeccion dependencia del Beam
    private MyOwnOperation myOwnOperation;

    public MyOwnBeanWithDependencyImplement(MyOwnOperation myOwnOperation) {
        this.myOwnOperation = myOwnOperation; //inyeccion de dependencia
    }

    @Override
    public void displayElements() {

        System.out.println("****Llamamos a MyOwnOperationImplement para generar lista aleatoria");
        List<Integer> randNums = this.myOwnOperation.generateRandomElements(500, 10);
        randNums.forEach(System.out::println);
        System.out.println("Implementacion de un bean con dependencia using Streams y Listas");

    }
}
