import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        Historial historial = new Historial("historial.json");
        boolean continuar = true;

        System.out.println("¡Bienvenido al Conversor de Monedas!");
        while (continuar) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Dólar (USD) a Peso Argentino (ARS)");
            System.out.println("2. Peso Argentino (ARS) a Dólar (USD)");
            System.out.println("3. Dólar (USD) a Real Brasileño (BRL)");
            System.out.println("4. Real Brasileño (BRL) a Dólar (USD)");
            System.out.println("5. Dólar (USD) a Peso Colombiano (COP)");
            System.out.println("6. Peso Colombiano (COP) a Dólar (USD)");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            try {
                int opcion = scanner.nextInt();
                if (opcion == 7) {
                    continuar = false;
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    break;
                }

                System.out.print("Ingresa el monto a convertir: ");
                double monto = scanner.nextDouble();

                try {
                    String resultado = conversor.convertir(opcion, monto);
                    System.out.println(resultado);
                    historial.guardarHistorial(resultado);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Ocurrió un error inesperado: " + e.getMessage());
                }
            } catch (Exception e) {
                System.err.println("Entrada no válida. Por favor, ingresa una opción válida.");
                scanner.nextLine();
            }
        }
    }
}
