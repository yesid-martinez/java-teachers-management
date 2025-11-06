package interaccion;

import dto.Docente;
import gestion.GestionDocente;

import java.util.Scanner;

public class Gestion {
    GestionDocente gestionDocente = new GestionDocente();

    public int leerNumero(){
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Por favor, ingrese un número.");
            sc.next();
        }
        return sc.nextInt();
    }

    public String leer(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje+" : ");
        return sc.nextLine();

    }

    private Docente crearDocente() {
        Docente docente = new Docente();
        String nombre = leer("Digite nombre ");
        docente.setNombre (nombre);

        docente.setApellido(leer("Digite apellido "));

        docente.setCedula(Long.parseLong(leer("Digite cedula ")));

        docente.setCorreo(leer("Digite correo "));
        return docente;
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear docente.");
            System.out.println("2. Crear materia");
            System.out.println("3. Listar los docentes.");
            System.out.println("4. Listar las materias.");
            System.out.println("9. Salir");
            System.out.println("\n ");
            System.out.print("Selecciona una opcion: ");
            opcion = this.leerNumero();

            switch (opcion) {
                case 1:
                    Docente docente = this.crearDocente();
                    gestionDocente.adicionar(docente);
                    break;
                case 2:
                    System.out.println("Pendiente materias");
                    break;
                case 3:
                    gestionDocente.listar();
                    break;
                case 4:
                    System.out.println("Pendiente Listado materias");
                    break;
                case 9:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);

    }
}
