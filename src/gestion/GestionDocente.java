package gestion;

import dto.Docente;
import persistencia.AlmacenamArchivos;

import java.util.ArrayList;

public class GestionDocente {
    private ArrayList<Docente> docentes = new ArrayList<>();

    public GestionDocente() {
        this.recuperar();
        if (this.docentes == null){
            docentes = new ArrayList<>();
        }
    }

    private void recuperar (){
        AlmacenamArchivos almacenamiento = new AlmacenamArchivos("docentes.abc");
        this.docentes =  (ArrayList<Docente>)almacenamiento.recuperar();
    }

    public boolean adicionar(Docente d) {
        docentes.add(d);
        this.almacenar();
        return true;
    }

    public void listar(){
        System.out.println("Lista de docentes");
        System.out.println("\tCedula \tnombre\tApellido\tcorreo");
        for(Docente docente: this.docentes){
            System.out.println(docente);
        }
    }
    private boolean almacenar(){
        AlmacenamArchivos almacenaArchivos = new AlmacenamArchivos("docentes-data.abc");
        almacenaArchivos.almacenar(this.docentes);
        return true;
    }
}
