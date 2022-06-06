package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    String nombre;
    String apellido;
    String random;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    @Override
    public String function() {
        return nombre +"--"+apellido;
    }
}
