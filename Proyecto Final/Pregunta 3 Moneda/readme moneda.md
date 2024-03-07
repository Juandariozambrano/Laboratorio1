# Proyecto Final Taller Objetos y Abstraccion de Datos.

# Grupo conformado por:

Juan Zambrano. C.I: 25.852.929.
David Rodriguez. C.I: 26.009.819.

# Explicacion del Programa con cada metodo pregunta 3

Este programa Java es una aplicación sencilla para la conversión y comparación de divisas. Incluye una clase base Moneda (Currency en inglés) y varias subclases para diferentes monedas como dólar, euro, yen, bolívares y Bitcoin.

La clase Moneda tiene un atributo cantidad de tipo BigDecimal, que se utiliza para almacenar la cantidad de dinero. Tiene dos métodos:

    es(String monedaDestino): Este método convierte la moneda a otra especificada por el parámetro monedaDestino (destinationCurrency).
    comparar(Moneda otraMoneda): Este método compara la moneda actual con otra pasada como parámetro y devuelve una cadena que indica si la moneda actual es menor, igual o mayor que la otra moneda.

Las subclases de cada moneda anulan el método en(String monedaDestino) para proporcionar sus propias tasas de conversión.

El método principal de la clase Mon solicita al usuario que seleccione una opción para convertir o comparar monedas. Si el usuario selecciona convertir, el programa muestra un menú para elegir la moneda a convertir y la moneda de destino. Luego solicita al usuario que ingrese el monto a convertir y muestra el monto convertido.

Si el usuario selecciona comparar, el programa le solicita que ingrese la cantidad y la moneda a comparar, y luego la moneda con la que comparar. Luego llama al método comparar para comparar las dos monedas y muestra el resultado.

El programa utiliza un objeto Scanner para leer la entrada del usuario y objetos BigDecimal para realizar cálculos decimales precisos. También utiliza un HashMap para almacenar las tasas de conversión de cada moneda.

En general, este programa proporciona una interfaz sencilla y fácil de usar para la conversión y comparación de divisas. Sin embargo, tiene algunas limitaciones, como las tasas de conversión codificadas, que pueden no estar actualizadas. Para mejorar el programa, puede agregar una funcionalidad para actualizar las tasas de conversión automáticamente desde una API o un archivo.