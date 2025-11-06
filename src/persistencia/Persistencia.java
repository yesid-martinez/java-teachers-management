package persistencia;

public interface Persistencia {
    public boolean almacenar(Object objeto);
    public Object recuperar();
}
