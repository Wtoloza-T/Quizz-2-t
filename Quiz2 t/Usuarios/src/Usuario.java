public class Usuario {
    int id;
    String nombreCompleto;
    String username;
    String contrasena;
    String rol;

    public Usuario(int id, String nombreCompleto, String username, String contrasena, String rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | User: " + username + " | Nombre: " + nombreCompleto + " | Rol: " + rol);
    }
}