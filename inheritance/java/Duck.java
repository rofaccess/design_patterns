/* La idea de los siguientes ejemplos es demostrar los límites de la herencia */

public class Duck{
	/* Primer comportamiento agregado, todos los patos dicen quack */
	public void quack(){
		System.out.println("quack");
	}

	/* Segundo comportamiento agregado, todos los patos vuelan */
	public void fly(){
		System.out.println("I'm fly!!!");
	}
}

public class WildDuck extends Duck{
	/*
	La clase WildDuck (PatoSalvaje) hereda el comportamiento quack de Duck, en teoría los ducks dicen quack pero cada duck
	puede tener un acento diferente, en este caso WildDuck tendrá un tono más aspero.
	Es factible sobreescribir el comportamiento quack para darle el acento salvaje, pero el cambio corresponderá
	únicamente al acento, no podemos sobreescribir quack para que diga miau porque estaríamos modificando gravemente
	el comportamiento base implementado en Duck, miau no es lo mismo que quack y definitivamente cambia el comportamiento
*/
	public void quack(){
		System.out.println("Quackrrrr");
	}

	/*
		No hace falta sobreescribir el comportamiento porque este pato vuela igual que su padre
		public void fly(){}
	*/
}

public class MontainDuck extends Duck{
	/*
	El pato de montaña, dice quack igual que su pariente pato salvaje, pero ambos patos son hijos de Quack,
	y tienen la misma forma de decir quack pero es un quack diferente al de su padre, entonces ambos patos
	sobreescriben quack y duplican el comportamiento. El código duplicado es mala práctica por varios motivos según Wikipedia,
	pero la que más resalta son las siguientes:
	- Si descubrimos que ambos patos dicen Quatro en vez de Quackrrrr, entonces se debe actualizar dos pedazos de cóodigo
	- Podriamos olvidarnos de actualizar uno de los codigos por lo cual ocurriría inconsistencias en nuestros patos.
	- Al tener código duplicado aumenta la cantidad de código y dificulta el mantenimiento

	Uno podría pensar que la solución a esto es otra clase que herede de Quack, que se el nuevo padre de ambos patos y que implemente
	quack para que diga Quatro, ahora supongamos que Duck implementa el comportamiento comer, y que el pato de montaña come de una manera
	y el pato salvaje come de otra manera, ahora supongamos que pato de granja como igual que el pato salvaje, entonces podriamos
	querer crear una clase padre para pato de granja y pato salvaje, con el objetivo de que coman igual, entonces estaremos necesitando
	herencia multiple, pero se dice que la solucion a problemas de herencia NO es agregar más herencia, además con la herencia múltiple
	se tienen problemas potenciales como ser: Problema del diamante, Herencia repetida . Java no permite la herencia múltiple porque acarrea más problemas
	que soluciones, pero en teoría admite herencia multiple a través de interfaces.
*/
	public void quack(){
		System.out.println("Quackrrrr");
	}

	/*
		No hace falta sobreescribir el comportamiento porque este pato vuela igual que su padre
		public void fly(){}
	*/
}


public class FarmDuck extends Duck{
	/*
		La clase FarmDuck (PatoDeGranja) tiene un acento más suave que su pariente WildDuck, recordemos que ambos heredan
		de Duck por eso son parientes.
		Sobreescribimos quack para suavizar el acento, sin cambiar demasiado el acento original implementado en Duck.
	*/
	public void quack(){
		System.out.println("Queck");
	}

	/*
		Todos los patos pueden valor, tristemente a los patos de granja se les cortan las alas para que no salgan volando de sus corrales,
		entonces uno puede pensar que sobreescribir el comportamiento es correcto pero esto rompería el comportamiento heredado,
		porque no puede ser que un pato herede la capacidad de volar pero no pueda hacerlo, además se estaría violando el principio Abierto/Cerrado
		que dice que una clase debe estar abierta a extensión pero no a la modificación, si cambiamos el compotamiento heredado, violamos el principio
		También se profana el principio de Sustitución de Liskov que dice que las clases hijas deben reemplazar sin problemas a la clase padre
		Sabemos que Duck vuela pero su descendiente FarmDuck no vuela, si ponemos a Duck en un corral para patos, este saldrá volando cuando venga el Mykure,
		pero su descendiente FarmDuck no podrá salir del corral volando porque no puede hacerlo y se convertirá en un víctima el Mykure
		(de hecho no queremos que salga del corral, por eso le cortamos las alas, pero haciendo esto ultrajamos la herencia y los principios Open/Closed y Substitución de Liskov).
		Solo a modo de aclaración, si la implementación de Corral permite que los patos puedan salir volando o sean presa fácil  del Mykure,
		tal vez haya que reimplementarlo, pero eso es otra historia.
	*/
		public void fly(){
			System.out.println("Karay, me cortaron las alas, así que no puedo volar :(");
		}
}

public class RubberDuck extends Duck{
	/*
	La clase RubberDuck (PatoDeGoma) tambien dice quack pero lo dice en un tono dificil de describir y que nos hace pensar
	que no es un pato de verdad, a efectos prácticos vamos a sobreescribir lo mejor posible el comportamiento quack
*/
	public void quack(){
		System.out.println("Quackthatfuck");
	}

	/*
		Ya era un code smell cuando nuestro pato decía quack de una manera artificial, pero ahora definitivamente notamos que
		nuestro pato de goma no pertenece acá poque no vuela, uno puede pensar que es correcto sobreescribir el comportamiento lanzando una excepción
		para indicar que el pato no vuela pero estaremos violando el principio Abierto/Cerrado y el principio de sustitución, además eso complicaría
		el trabajo del programador teniendo que atrapar excepciones, y si el programador no hizo las pruebas necesarias, puede que nunca se dé cuenta
		que tenía que manejar la excepción y que nuestro pato explote inesperadamente cuando intente salir volando del corral cuando venga el Mykure.
		Tal vez haya que implementar fly para que el pato de hule explote cuando el Mykure se le acerque y por ahí el Mykure también explota, pero esto
		puede ser estúpido ya que seguramente el Mykure ni notará al pato de hule poruqe no es comida, pero esto es otra historia.
	*/
	public void fly(){
		throw new UnsupportedOperationException;
	}
}