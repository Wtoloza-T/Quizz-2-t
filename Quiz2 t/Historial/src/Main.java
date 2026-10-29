public class Main {
    public static void main(String[] args) {
        GestorUsuarios gestor = new GestorUsuarios();

        // Crear usuarios
        Usuario admin = new Usuario(1, "Carlos Pérez", "admin1", "1234", "Administrador");
        gestor.usuarios[gestor.total++] = admin;
        admin.registrarAccion("Inició sesión en el sistema");

        Usuario user1 = new Usuario(2, "Ana Gómez", "anag", "abcd", "Estándar");
        gestor.crearUsuario(admin, user1);

        // Acciones del usuario Estándar
        user1.registrarAccion("Inició sesión");
        gestor.actualizar(user1, "anag", "abcd", "Ana M. Gómez", "nuevaPass");

        // Admin elimina usuario
        gestor.eliminar(admin, "anag");

        Usuario user2 = new Usuario(3, "William Toloza", "WTOO", "9876", "Administrador");
        gestor.crearUsuario(admin, user2);

        
        user2.registrarAccion("Inició sesión");
        gestor.actualizar(user2, "WTOO", "9876", "W Toloza Moreno", "54321");

        // Mostrar el historial de cada usuario
        admin.mostrarHistorial();
        user1.mostrarHistorial();
        user2.mostrarHistorial();
    }
}