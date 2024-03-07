# Proyecto Final Taller Objetos y Abstraccion de Datos.

# Grupo conformado por:

Juan Zambrano. C.I: 25.852.929.
David Rodriguez. C.I: 26.009.819.

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


