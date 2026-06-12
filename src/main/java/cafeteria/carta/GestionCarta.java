package cafeteria.carta;

import cafeteria.productos.*;

import java.io.*;
import java.util.ArrayList;

public class GestionCarta {
    public ArrayList<Producto> leerCartaTxt() {
        ArrayList<Producto> carta = new ArrayList<>();
        ArrayList<String> lineasErroneas = new ArrayList<>();
        String linea;
        Comida comida = null;
        Bebida bebida = null;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/carta.txt"))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                try {
                    switch (datos[0]) {
                        case "COMIDA" -> carta.add(new Comida(datos[1], Double.parseDouble(datos[2])));
                        case "BEBIDA" -> carta.add(new Bebida(datos[1], Double.parseDouble(datos[2])));
                        case "MENU" -> {
                            for (Producto producto : carta) {
                                if (producto instanceof Bebida && producto.getNombre().equals(datos[2])) {
                                    bebida = (Bebida) producto;
                                }
                                if (producto instanceof Comida && producto.getNombre().equals(datos[3])) {
                                    comida = (Comida) producto;
                                }
                            }
                            if (comida == null || bebida == null) throw new RuntimeException();
                            carta.add(new Menu(datos[1], comida, bebida, Double.parseDouble(datos[4])));
                        }
                        default -> throw new RuntimeException();
                    }
                } catch (RuntimeException re) {lineasErroneas.add(linea);}
            }
            escribirErrores(lineasErroneas);
        } catch (IOException e) {
            System.out.println("Error de lectura de la carta.");
        }
        return carta;
    }

    public void escribirCartaSer(ArrayList<Producto> carta) {
        try (ObjectOutputStream osw = new ObjectOutputStream(new FileOutputStream("src/main/resources/carta.ser"))) {
            osw.writeObject(carta);
        } catch (IOException e) {
            System.out.println("Error de serialización.");
        }
    }

    private void escribirErrores(ArrayList<String> lineasErroneas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/errores.txt"))) {
            for (String linea : lineasErroneas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error de escritura de los errores en la carta.");
        }
    }
}
