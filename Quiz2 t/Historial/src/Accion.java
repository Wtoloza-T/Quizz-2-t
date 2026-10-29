public class Accion {
    String descripcion;
    long timestamp; 

    public Accion(String descripcion) {
        this.descripcion = descripcion;
        this.timestamp = System.currentTimeMillis();
    }

    public void mostrar() {
        System.out.println("  - [" + timestamp + "] " + descripcion);
    }
}