package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private MyBeanWithProperties myBeanWithProperties; //uso de propiedades

	private MyOwnBeanWithDependency myOwnBeanWithDependency; //RETO

	private MyBeanWithDependency myBeanWithDependency; //dependencia dentro de otra dependencia

	private MyBean myBean; //inyectar dependencia

	private ComponentDependency componentDependency; //inyectar la interfaz

	//inyeccion de componentes en constructor
	//cuando hay dos clases usando la interfaz ComponentDependency hay un error
	//se solucuiona con Qualifier -> **la primerera letra en minuscula
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyOwnBeanWithDependency myOwnBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties
								  ){
		this.componentDependency = componentDependency;
		this.myBean = myBean; //inyeccion dependencia
		this.myBeanWithDependency = myBeanWithDependency;  //dependencia dentro de otra dependencia
		this.myOwnBeanWithDependency = myOwnBeanWithDependency; //RETO
		this.myBeanWithProperties = myBeanWithProperties; //uso de propiedades
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejecutar en applicacion
		componentDependency.saludar();

		//inyect dependencia
		myBean.print();

		// dependencia dentro de otra dependencia
		myBeanWithDependency.printWithDependency();


		///RETO
		myOwnBeanWithDependency.displayElements();

		//Uso de propiedades
		System.out.println(myBeanWithProperties.function());
		
	}
}
