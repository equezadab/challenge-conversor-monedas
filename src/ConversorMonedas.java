import java.io.IOException;
import java.util.Map;


public class ConversorMonedas {
    private final ApiService apiService;

    public ConversorMonedas() {
        this.apiService = new ApiService();
    }

    public String convertir(int opcion, double monto) {
        try {
            Map<String, Double> tasas = apiService.obtenerTasas();
            if (tasas == null) {
                throw new IllegalArgumentException("No se pudieron obtener las tasas de cambio.");
            }

            double resultado;
            String origen;
            String destino;

            switch (opcion) {
                case 1 -> { // Dólar a Peso Argentino
                    resultado = monto * tasas.getOrDefault("ARS", -1.0);
                    origen = "USD";
                    destino = "ARS";
                }
                case 2 -> { // Peso Argentino a Dólar
                    resultado = monto / tasas.getOrDefault("ARS", -1.0);
                    origen = "ARS";
                    destino = "USD";
                }
                case 3 -> { // Dólar a Real Brasileño
                    resultado = monto * tasas.getOrDefault("BRL", -1.0);
                    origen = "USD";
                    destino = "BRL";
                }
                case 4 -> { // Real Brasileño a Dólar
                    resultado = monto / tasas.getOrDefault("BRL", -1.0);
                    origen = "BRL";
                    destino = "USD";
                }
                case 5 -> { // Dólar a Peso Colombiano
                    resultado = monto * tasas.getOrDefault("COP", -1.0);
                    origen = "USD";
                    destino = "COP";
                }
                case 6 -> { // Peso Colombiano a Dólar
                    resultado = monto / tasas.getOrDefault("COP", -1.0);
                    origen = "COP";
                    destino = "USD";
                }
                default -> throw new IllegalArgumentException("Opción no válida.");
            }

            return String.format("El valor de %.2f [%s] corresponde al valor final de =>>> %.2f [%s]",
                    monto, origen, resultado, destino);

        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
