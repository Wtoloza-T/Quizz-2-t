public class Main {
    public static void main(String[] args) {
        GestorUsuarios gestor = new GestorUsuarios();

        //  un admin y un usuario base
        Usuario adminBase = new Usuario(1, "Carlos Perez", "admin1", "1234", "Administrador");
        gestor.usuarios[gestor.total++] = adminBase;

        Usuario userBase = new Usuario(2, "Ana Gomez", "anag", "abcd", "Estándar");
        gestor.usuarios[gestor.total++] = userBase;

        System.out.println("--- PRUEBA DE INICIO DE SESIÓN ---");

        //  Intento fallido
        gestor.iniciarSesion("anag", "claveErronea");

        // Intento exitoso 
        Usuario sesionIniciada = gestor.iniciarSesion("anag", "abcd");

        //  Usar el usuario logueado para realizar acciones
        if (sesionIniciada != null) {
            gestor.actualizar(sesionIniciada, "anag", "abcd", "Ana M. Gomez", "nuevaPass123");
            sesionIniciada.mostrarHistorial();
        }

        System.out.println("------");
        
        gestor.iniciarSesion("admin1", "1234");

        if (sesionIniciada != null) {
            gestor.actualizar(sesionIniciada, "admin1", "1234", "William Toloza", "0987");
            sesionIniciada.mostrarHistorial();
        }


    }
}