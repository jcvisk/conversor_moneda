import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();
        Map<Integer, String[]> opciones = new HashMap<>();
        opciones.put(1, new String[]{"USD", "ARS"});
        opciones.put(2, new String[]{"ARS", "USD"});
        opciones.put(3, new String[]{"USD", "BRL"});
        opciones.put(4, new String[]{"BRL", "USD"});
        opciones.put(5, new String[]{"USD", "MXN"});
        opciones.put(6, new String[]{"MXN", "USD"});

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            opciones.forEach((key, value) -> System.out.println(key + ") " + value[0] + " ==> " + value[1]));
            System.out.println("7) Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(entrada.nextLine());
                if (opcion == 7) break;

                System.out.println("Ingrese el valor que desea convertir:");
                var cantidad = Double.parseDouble(entrada.nextLine());

                if (opciones.containsKey(opcion)) {
                    String[] monedas = opciones.get(opcion);
                    System.out.println(conversor.convert(monedas[0], monedas[1], cantidad));
                } else {
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                opcion = 0;
            }
        } while (true);

        entrada.close();
    }
}
