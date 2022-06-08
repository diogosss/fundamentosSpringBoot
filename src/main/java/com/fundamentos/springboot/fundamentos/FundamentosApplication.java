package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.beanReto.MyOwnBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserResository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private UserResository userResository;//iyectar dependencia del repositorio

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);//Logs

	private UserPojo userPojo; //user propiedades

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
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserResository userResository
								  ){
		this.componentDependency = componentDependency;
		this.myBean = myBean; //inyeccion dependencia
		this.myBeanWithDependency = myBeanWithDependency;  //dependencia dentro de otra dependencia
		this.myOwnBeanWithDependency = myOwnBeanWithDependency; //RETO
		this.myBeanWithProperties = myBeanWithProperties; //uso de propiedades
		this.userPojo = userPojo; //user propiedades
		this.userResository = userResository; //user respository
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejercicios de clases anteriores
		//clasesAnteriores();

		//database wite y show sql
		saveUsersInDataBase(); //insert base de datos en memoria


	}

	private void saveUsersInDataBase(){
		User user1=new User("Diogo","ds@gmil.cs", LocalDate.of(1980,03,20));
		User user2=new User("Jose","js@gmil.cs", LocalDate.of(1990,05,14));
		User user3=new User("Maria","mr@gmil.cs", LocalDate.of(1991,12,23));
		User user4=new User("Pepe","pp@gmil.cs", LocalDate.of(1992,07,15));
		User user5=new User("Andres","an@gmil.cs", LocalDate.of(1990,01,17));
		User user6=new User("Luis","ls@gmil.cs", LocalDate.of(1994,06,18));
		User user7=new User("Lzeth","lz@gmil.cs", LocalDate.of(1998,8,25));
		User user8=new User("Paola","po@gmil.cs", LocalDate.of(1986,9,13));
		User user9=new User("Valeria","va@gmil.cs", LocalDate.of(1989,2,10));
		User user10=new User("Darlyn","da@gmil.cs", LocalDate.of(1993,9,19));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		//usar el repositorio
		list.stream().forEach(userResository::save);
	}

	private void clasesAnteriores(){
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

		//Uso de Pojo
		System.out.println(userPojo.getEmail()+"----"+userPojo.getPassword()+"--"+userPojo.getAge());

		LOGGER.error("Esto es un error del appl"); //imprimir un log de error

		try{
			int value = 10/0;
			LOGGER.debug("Mi valor " + value);
		}catch (Exception e){
			LOGGER.error("Es es un error division por cero" + e.getMessage());
		}
	}
}
