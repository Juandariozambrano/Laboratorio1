# Proyecto Taller Objetos y Abstraccion de Datos.

# Grupo conformado por:

Juan Zambrano. C.I: 25.852.929
David Rodriguez. C.I: 26.009.819

# Pregunta 1 Teorica con justificacion.

En Java, cuando se trata de herencia y clases parametrizadas (como las listas genéricas), la relación entre Lista<A> y Lista<B> depende de cómo se defina la jerarquía de clases y la relación entre A y B.

# Herencia y Clases Parametrizadas:
La herencia en Java permite que una clase (subclase o hija) herede atributos y métodos de otra clase (superclase o padre).
Las clases parametrizadas, también conocidas como genéricos, permiten crear clases, interfaces o métodos que operan en tipos de datos específicos sin especificar el tipo concreto hasta el momento de su uso.

# Relación entre Lista<A> y Lista<B>:
Si B es una subclase de A, entonces Lista<B> no hereda directamente de Lista<A>.
Sin embargo, debido a la herencia, B hereda todos los miembros (atributos y métodos) de A.
Por lo tanto, si Lista<A> tiene una estructura genérica que acepta elementos de tipo A, Lista<B> también puede contener elementos de tipo B (y, por lo tanto, también de tipo A).

# Decisión en Java:
Java no permite la herencia directa entre clases parametrizadas.
Esto significa que no podemos declarar Lista<B> como una subclase de Lista<A>.
Sin embargo, debido a la herencia de B desde A, podemos usar Lista<A> para almacenar elementos de tipo B.
La decisión de Java se basa en la seguridad de tipos y la integridad del sistema. Permitir la herencia directa entre clases parametrizadas podría llevar a problemas de tipo y comportamiento inesperado.
Ejemplo:
Supongamos que tenemos una clase Animal y una subclase Perro:

class Animal { /* ... */ }
class Perro extends Animal { /* ... */ }


También tenemos una clase parametrizada Lista<T>:

class Lista<T> { /* ... */ }

Podemos usar Lista<Animal> para almacenar elementos de tipo Perro:

Lista<Animal> listaAnimales = new Lista<>();
listaAnimales.agregar(new Perro());

En resumen, aunque no hay una relación directa de herencia entre Lista<A> y Lista<B>, la herencia de B desde A permite que Lista<A> sea utilizada para almacenar elementos de tipo B. Java prioriza la seguridad de tipos y la coherencia del sistema al tomar esta decisión

