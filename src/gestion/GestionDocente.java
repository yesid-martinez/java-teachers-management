package gestion;

import dto.Docente;
import persistencia.AlmacenamArchivos;

import java.util.ArrayList;

public class GestionDocente {
    private ArrayList<Docente> docentes = new ArrayList<>();

    public GestionDocente() {
        this.recuperar();
    }

    @SuppressWarnings("unchecked")
    private void recuperar (){
        AlmacenamArchivos almacenamiento = new AlmacenamArchivos("docentes-data.abc");
        Object list = almacenamiento.recuperar();
        if (list instanceof ArrayList<?>) {
            this.docentes = (ArrayList<Docente>) list;
        } else {
            this.docentes = new ArrayList<>();
            System.err.println("El archivo no contiene una lista válida de docentes");
        }
    }

    public void adicionar(Docente d) {
        docentes.add(d);
        this.almacenar();
    }

    public void listar(){
        System.out.println("Lista de docentes");
        System.out.println("\tCedula \tnombre\tApellido\tcorreo");
        for(Docente docente: this.docentes){
            System.out.println(docente);
        }
    }
    private void almacenar(){
        AlmacenamArchivos almacenamiento = new AlmacenamArchivos("docentes-data.abc");
        almacenamiento.almacenar(this.docentes);
    }
}
