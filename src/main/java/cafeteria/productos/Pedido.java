package cafeteria.productos;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> productos;

    public Pedido(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        int contador = 1;
        double total = 0;
        StringBuilder listaProductos = new StringBuilder();
        for (Producto producto : productos) {
            listaProductos.append(contador).append(". ").append(producto).append("\n");
            total += producto.getPrecio();
            contador++;
        }
        listaProductos.append("Total: ").append(total).append("€");

        return listaProductos.toString();
    }
}
