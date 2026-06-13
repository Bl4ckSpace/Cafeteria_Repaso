package cafeteria.gestion;

import cafeteria.productos.Pedido;
import cafeteria.productos.Producto;
import cafeteria.vista.MenuOpciones;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionMenuOpciones {
    private final Scanner teclado;
    private final ArrayList<Pedido> pedidos;
    ArrayList<Producto> carta;

    public GestionMenuOpciones(ArrayList<Producto> carta) {
        this.teclado = new Scanner(System.in);
        this.pedidos = new ArrayList<>();
        this.carta = carta;
    }

    public void elegirOpcion(MenuOpciones menuOpciones) {
        int opcion;
        do {
            menuOpciones.mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> mostrarCarta();
                case 2 -> hacerPedido();
                case 3 -> mostrarPedidos();
                case 4 -> cancelarPedido();
                case 5 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción inexistente.");
            }
        } while (opcion != 5);
    }

    private void mostrarCarta() {
        for (Producto producto : carta) {
            System.out.println(producto);
        }
    }

    private void hacerPedido() {
        String nombreProducto = "";
        Pedido pedido = new Pedido(new ArrayList<>());

        while (!nombreProducto.equalsIgnoreCase("FIN")) {
            System.out.print("Elige (FIN para terminar): ");
            nombreProducto = teclado.nextLine();

            if (!nombreProducto.equalsIgnoreCase("FIN")) {
                boolean encontrado = false;
                for (Producto producto : carta) {
                    if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                        pedido.getProductos().add(producto);
                        System.out.println(nombreProducto + " ha sido añadido.");
                        encontrado = true;
                    }
                }
                if (!encontrado) System.out.println(nombreProducto + " no existe en la carta.");
            }
        }
        pedidos.add(pedido);
    }

    private void mostrarPedidos() {
        if (pedidos.isEmpty())
            System.out.println("Todavía no has pedido nada.");
        else {
           int numero = 1;
           for (Pedido pedido : pedidos) {
               System.out.println("--- Pedido " + numero + " ---");
               System.out.println(pedido);
               numero++;
           }
        }
    }

    private void cancelarPedido() {
        int posicionPedido;
        if (pedidos.isEmpty())
            System.out.println("Todavía no has pedido nada.");
        else {
            do {
                System.out.print("Elige el número del pedido que quieres borrar: ");
                posicionPedido = Integer.parseInt(teclado.nextLine());
                if (posicionPedido < 0 || posicionPedido > pedidos.size()) {
                    System.out.println("No existe ese número de pedido.");
                }
            } while (posicionPedido < 1 || posicionPedido > pedidos.size());
            pedidos.remove(posicionPedido-1);
            System.out.println("Pedido cancelado.");
        }
    }
}
