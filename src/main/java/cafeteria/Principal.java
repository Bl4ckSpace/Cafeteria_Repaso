package cafeteria;

import cafeteria.carta.GestionCarta;
import cafeteria.productos.Producto;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        GestionCarta gestionCarta = new GestionCarta();

        ArrayList<Producto> carta = gestionCarta.leerCartaTxt();
        gestionCarta.escribirCartaSer(carta);
    }
}
