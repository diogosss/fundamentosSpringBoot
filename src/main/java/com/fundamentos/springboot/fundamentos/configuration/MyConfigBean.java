package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnBeanWithDependency;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnBeanWithDependencyImplement;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnOperation;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnOperationImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigBean {

    ///public Interfaz nombre

    @Bean
    public MyBean beanOperation(){
       // return new MyBeanImplement(); // implementacion 1
        return new MyBean2Implement(); //llamara otra implementacion 2
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

        //inyeccion dependencia dentro de otra dependencia
    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation) {  //le pasamos la interfaz
        return new MyBeanWithDependencyImplement(myOperation); //le pasamos la interfaz
    }

    ///********************************/////
    //Configuracion del Reto
    @Bean
    public MyOwnOperation beanOperationMyOwn() {
        return new MyOwnOperationImplement();
    }

    @Bean
    public MyOwnBeanWithDependency beanOperationMyOwnWithDependency(MyOwnOperation myOwnOperation){
        return new MyOwnBeanWithDependencyImplement(myOwnOperation);
    }
}
