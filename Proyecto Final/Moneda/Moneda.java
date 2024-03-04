import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Clase base Moneda
class Moneda {
    BigDecimal cantidad;

    public Moneda(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    // Método para convertir a otras monedas
    public BigDecimal en(String monedaDestino) {
        // Implementa las conversiones aquí
        // Por defecto, no se realiza ninguna conversión
        return cantidad;
    }

    // Método para comparar con otra moneda
    public String comparar(Moneda otraMoneda) {
        int comparacion = cantidad.compareTo(otraMoneda.cantidad);
        if (comparacion < 0) {
            return ":menor";
        } else if (comparacion > 0) {
            return ":mayor";
        } else {
            return ":igual";
        }
    }
}

// Subclase Dolar
class Dolar extends Moneda {
    public Dolar(BigDecimal cantidad) {
        super(cantidad);
    }

    @Override
    public BigDecimal en(String monedaDestino) {
        // Implementa las conversiones a otras monedas aquí
        // Ejemplo: Dólar a Euro
        Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("euros", new BigDecimal("0.85"));
        tasasDeCambio.put("bolivares", new BigDecimal("4000"));
        tasasDeCambio.put("bitcoins", new BigDecimal("0.00002"));

        if (tasasDeCambio.containsKey(monedaDestino)) {
            BigDecimal tasa = tasasDeCambio.get(monedaDestino);
            return cantidad.multiply(tasa);
        } else {
            return super.en(monedaDestino);
        }
    }

    // Otras subclases (Yen, Euro, Bolivar, Bitcoin) seguirían un patrón similar

    public static void main(String[] args) {
        Dolar dolar = new Dolar(new BigDecimal("15"));
        BigDecimal euros = dolar.en("euros");
        System.out.println("15 dólares en euros: " + euros);

        Moneda bolivares = new Moneda(new BigDecimal("50"));
        Moneda dolares = new Dolar(new BigDecimal("2"));
        String comparacion = bolivares.comparar(dolares);
        System.out.println("Comparación: " + comparacion);
    }
}
