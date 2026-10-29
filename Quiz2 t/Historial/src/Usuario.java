public class Usuario {
    int id;
    String nombreCompleto;
    String username;
    String contrasena;
    String rol;
    
    
    Accion[] historial = new Accion[10];
    int totalAcciones = 0;

    public Usuario(int id, String nombreCompleto, String username, String contrasena, String rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    
    public void registrarAccion(String descripcion) {
        if (totalAcciones < historial.length) {
            historial[totalAcciones++] = new Accion(descripcion);
        }
    }

    
    public void mostrarHistorial() {
        System.out.println("\n--- Historial de " + username + " ---");
        if (totalAcciones == 0) {
            System.out.println("  Sin acciones registradas.");
            return;
        }
        for (int i = 0; i < totalAcciones; i++) {
            historial[i].mostrar();
        }
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | User: " + username + " | Nombre: " + nombreCompleto + " | Rol: " + rol);
    }
}