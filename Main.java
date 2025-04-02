package cuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var opcion = "";
        do {
            System.out.println("""
                1. Crear nueva cuenta
                2. Iniciar sesión
                3. Salir
                Seleccione una opción:""");
            
            opcion = sc.nextLine().trim();
            
            switch (opcion) {
                case "1" -> crearNuevaCuenta();
                case "2" -> iniciarSesion();
                case "3" -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente de nuevo");
            }
        } while (!opcion.equals("3"));
    }

    private static void menuCuenta(Cuenta cuenta) {
        var opcion = "";
        do {
            System.out.println("""
                1. Consultar saldo
                2. Ingresar dinero
                3. Retirar dinero
                4. Actualizar saldo
                5. Transferir dinero
                6. Cerrar sesión
                Seleccione una opción:""");
            
            opcion = sc.nextLine().trim();
            
            try {
                switch (opcion) {
                    case "1" -> System.out.printf("Saldo actual: %.2f €%n", cuenta.getSaldo());
                    case "2" -> ingresarDinero(cuenta);
                    case "3" -> retirarDinero(cuenta);
                    case "4" -> {
                        cuenta.actualizarSaldo();
                        System.out.println("Saldo actualizado con éxito");
                    }
                    case "5" -> transferirDinero(cuenta);
                    case "6" -> System.out.println("Sesión cerrada");
                    default -> System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Cantidad no válida");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!opcion.equals("6"));
    }

    private static void ingresarDinero(Cuenta cuenta) {
        System.out.print("Ingrese la cantidad a ingresar: ");
        var cantidadStr = sc.nextLine().trim();
        if (cantidadStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            var cantidad = Double.parseDouble(cantidadStr);
            cuenta.ingresar(cantidad);
            System.out.println("Dinero ingresado con éxito");
        } else {
            System.out.println("Cantidad no válida");
        }
    }

    private static void retirarDinero(Cuenta cuenta) {
        System.out.print("Ingrese la cantidad a retirar: ");
        var cantidadStr = sc.nextLine().trim();
        if (cantidadStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            var cantidad = Double.parseDouble(cantidadStr);
            cuenta.retirar(cantidad);
        } else {
            System.out.println("Cantidad no válida");
        }
    }

    private static void transferirDinero(Cuenta cuentaOrigen) {
        try {
            System.out.print("Ingrese el número de cuenta destino: ");
            var numeroCuentaStr = sc.nextLine().trim();
            if (!numeroCuentaStr.matches("^\\d{4}$")) {
                System.out.println("Número de cuenta no válido");
                return;
            }
            var numeroCuentaDestino = Integer.parseInt(numeroCuentaStr);

            System.out.print("Ingrese la cantidad a transferir: ");
            var cantidadStr = sc.nextLine().trim();
            if (!cantidadStr.matches("^\\d+(\\.\\d{1,2})?$")) {
                System.out.println("Cantidad no válida");
                return;
            }
            var cantidadTransferencia = Double.parseDouble(cantidadStr);

            var cuentaDestino = cuentas.stream()
                .filter(cuenta -> cuenta.getNumerocuenta() == numeroCuentaDestino)
                .findFirst()
                .orElse(null);

            if (cuentaDestino == null) {
                System.out.println("La cuenta destino no existe");
                return;
            }

            if (cuentaOrigen.getSaldo() >= cantidadTransferencia) {
                cuentaOrigen.retirar(cantidadTransferencia);
                cuentaDestino.ingresar(cantidadTransferencia);
                System.out.println("Transferencia realizada con éxito");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato de número no válido");
        } catch (Exception e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        }
    }
}
