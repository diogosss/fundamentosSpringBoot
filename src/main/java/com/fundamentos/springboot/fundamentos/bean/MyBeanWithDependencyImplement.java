package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);//Logs

    //iny4ectar la dependencia deasde el bean en cofiguracion
    private MyOperation myOperation; //interfaz

    public MyBeanWithDependencyImplement(MyOperation myOperation) {  //interfaz

        this.myOperation = myOperation; //inyecion de dependencia
    }

    //implementacion de la dependencia
    @Override
    public void printWithDependency() {
        LOGGER.info("Info de MyBeanWithDependencyImplement");
        int num = 3;
        LOGGER.debug("El numero enviado comop parametro a la depedenciaes: " + num);
        System.out.println(myOperation.sum(num));
        System.out.println("Implementacion desde un bean con dependencia");
    }
}
