package dto;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Docente implements Serializable {
    private String nombre;
    private String apellido;
    private String correo;
    private long cedula;
    private List<Materia> materias;

    public Docente() {
        materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public long getCedula() {
        return cedula;
    }
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "\t"+this.cedula+" \t"+ this.nombre +" \t"+this.apellido+" \t"+this.correo;
    }

//    @Override
//    public String toString() {
//        return "\t" + getCedula() + " \t" + getNombre() + " \t" + getApellido() + " \t" + getCorreo();
//    }

}
