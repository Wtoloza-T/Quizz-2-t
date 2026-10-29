public class Main {
    public static void main(String[] args) {
        GestorUsuarios gestor = new GestorUsuarios();

        Usuario admin = new Usuario(1, "Carlos Pérez", "admin1", "1234", "Administrador");
        gestor.usuarios[gestor.total++] = admin; 

        Usuario user1 = new Usuario(2, "Ana Gómez", "anag", "abcd", "Estándar");
        gestor.crearUsuario(admin, user1);

        Usuario user2 = new Usuario(3, "Pedro Lopez", "pedrol", "9999", "Estándar");
        gestor.crearUsuario(admin, user2); 

        gestor.listar();

        // Prueba de permisos de modificación:
        gestor.actualizar(user1, "admin1", "1234", "Hack", "hack");
        
        // user1 modificando su PROPIO perfil
        gestor.actualizar(user1, "anag", "abcd", "Ana M. Gómez", "nuevaPass123");
        
        // user2 modificando su PROPIO perfil
        gestor.actualizar(user2, "pedrol", "9999", "Pedro R. Lopez", "2413");

        // Prueba de eliminación
        gestor.eliminar(user1, "admin1"); 
        gestor.eliminar(admin, "anag");   

        gestor.listar();
    }
}