package cafeteria.controlador;

import cafeteria.gestion.GestionCarta;
import cafeteria.gestion.GestionMenuOpciones;
import cafeteria.productos.Producto;
import cafeteria.vista.MenuOpciones;

import java.util.ArrayList;

public class Controlador {
    public void ejecutar() {
        GestionCarta gestionCarta = new GestionCarta();
        ArrayList<Producto> carta = gestionCarta.leerCartaTxt();
        gestionCarta.escribirCartaSer(carta);

        GestionMenuOpciones gestionMenuOpciones = new GestionMenuOpciones(carta);
        gestionMenuOpciones.elegirOpcion(new MenuOpciones());
    }
}
