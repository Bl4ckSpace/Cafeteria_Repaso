package cafeteria.productos;

public class Bebida extends Producto {
    public Bebida(String nombre, double precio) {super(nombre, precio);}

    @Override
    public String toString() {
        return "BEBIDA | " + super.toString();
    }
}
