# Proyecto Final Taller Objetos y Abstraccion de Datos.

# Grupo conformado por:

Juan Zambrano. C.I: 25.852.929.
David Rodriguez. C.I: 26.009.819.

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

# Resumen del proyecto pregunta 2.

 Para calcular el producto cartesiano de dos colecciones en Java,puedes usar el siguiente enfoque. Primero, crea un método que tome dos colecciones como entrada y genere todas las combinaciones de pares usando dos bucles anidados. Luego, agrega cada par a una nueva colección (por ejemplo, un ArrayList) y devuélvela. En el archivo CartesianProduct se encontrara el codigo del programa.

Esta sera la salida:
[a, 4]
[a, 5]
[b, 4]
[b, 5]
[c, 4]
[c, 5]

# Explicacion del codigo con cada metodo pregunta 2.

El codigo proporcionado está escrito en Java y define una clase "CartesianProduct" con dos métodos estáticos: cartesianProduct() y cartesianProductWithStreams(). Ambos métodos calculan el producto cartesiano de dos colecciones dadas.

El producto cartesiano es un concepto matemático que describe todas las combinaciones posibles de elementos de dos conjuntos. En este caso, el código calcula el producto cartesiano de dos colecciones: colección1 y colección2.

Aquí hay una breve explicación de los dos métodos:

# cartesianProduct():
Este método toma dos listas como entrada (colección1 y colección2) y devuelve una lista de listas, donde cada lista interna es un par de elementos: uno de la colección1 y otro de la colección2. Utiliza Java 8 Streams para procesar las colecciones.

# cartesianProductWithStreams():
Este metodo es similar al primero, pero introduce un paso adicional para crear un Stream a partir de una lista (usando Stream.of()) antes de recopilarlo en una lista. Este método demuestra el uso de Streams anidados, pero es menos eficiente que el primer método debido a la creación de objetos Stream intermedios.

El codigo también incluye un método main() que demuestra el uso de los dos métodos con dos colecciones de muestra (colección1 y colección2). El resultado del programa será una representación del producto cartesiano de estas colecciones.

# Resumen del proyecto pregunta 3.


# Explicacion del codigo con cada metodo.
