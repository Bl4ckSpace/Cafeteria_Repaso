package cafeteria.productos;

public class Comida extends Producto {
    public Comida(String nombre, double precio) {super(nombre, precio);}

    @Override
    public String toString() {
        return "COMIDA | " + super.toString();
    }
}
