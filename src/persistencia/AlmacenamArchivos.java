package persistencia;

import java.io.*;

public class AlmacenamArchivos implements Persistencia{
    private final String rutaArchivo;

    public AlmacenamArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public boolean almacenar(Object listaObjetos) {
        // ObjectOutputStream -> Converts an object to bytes and writes it to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(listaObjetos);
            // oos.close(); X Not necessary
            // Java automatically ensures that the resource (oos) is closed when the try block ends.
            System.out.println("Objeto guardado en archivo binario: " + rutaArchivo);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar en binario: " + e.getMessage());
            return false;
        }

    }

    @Override
    public Object recuperar() {
        //ObjectInputStream → reads those bytes and reconstructs the original object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) { // Rebuild the object in memory (deserialization)
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
