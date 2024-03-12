package org.example;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de e-commerce con recomendaciones inteligentes");


        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        ClienteECommerce cliente = new ClienteECommerce(nombre, (int) (Math.random() * 10000));


        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ver obras disponibles");
            System.out.println("2. Comprar obra");
            System.out.println("3. Ver recomendaciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    BaseDeDatosObras.mostrarObrasDisponibles();
                    break;
                case 2:

                    comprarObra(scanner, cliente);
                    break;
                case 3:

                    cliente.mostrarRecomendaciones();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void comprarObra(Scanner scanner, ClienteECommerce cliente) {
        System.out.println("Ingrese el título de la obra que desea comprar:");
        String titulo = scanner.nextLine();
        Obra obraSeleccionada = BaseDeDatosObras.obrasDisponibles.stream()
                .filter(obra -> obra.titulo.equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (obraSeleccionada != null) {
            Pedido pedido = new Pedido(cliente);
            pedido.agregarObra(obraSeleccionada);
            System.out.println("Compra realizada con éxito.");
            pedido.mostrarPedido();
        } else {
            System.out.println("Obra no encontrada. Asegúrese de escribir el título correctamente.");
        }
    }
}

