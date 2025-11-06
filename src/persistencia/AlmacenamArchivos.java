package persistencia;

import java.io.*;

public class AlmacenamArchivos implements Persistencia{
    private final String rutaArchivo;

    public AlmacenamArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public boolean almacenar(Object objeto) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto guardado en archivo binario: " + rutaArchivo);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar en binario: " + e.getMessage());
            return false;
        }

    }

    @Override
    public Object recuperar() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            while (true) {
                try {
                    return ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;

    }
}
