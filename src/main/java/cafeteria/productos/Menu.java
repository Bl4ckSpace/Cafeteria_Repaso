package cafeteria.productos;

public class Menu extends Producto {
    private Comida comida;
    private Bebida bebida;

    public Menu(String nombre, Comida comida, Bebida bebida, double precio) {
        super(nombre, precio);
        this.comida = comida;
        this.bebida = bebida;
    }

    public Comida getComida() {
        return comida;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public double aplicarDescuento() {
        double suma = comida.getPrecio() + bebida.getPrecio();
        return suma - (suma * 0.1);
    }

    @Override
    public String toString() {
        return "MENU   | " + super.toString() +
            " (" + bebida.getNombre() + " + " + comida.getNombre() + ")";
    }

}
