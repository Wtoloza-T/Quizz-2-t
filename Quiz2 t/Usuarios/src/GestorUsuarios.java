public class GestorUsuarios {
    Usuario[] usuarios = new Usuario[10];
    int total = 0;

    public void crearUsuario(Usuario ejecutor, Usuario nuevo) {
        if (!ejecutor.rol.equalsIgnoreCase("Administrador")) {
            System.out.println("Error: Solo el Administrador puede crear usuarios.");
            return;
        }
        if (total < usuarios.length) {
            usuarios[total++] = nuevo;
            System.out.println("Éxito: Usuario '" + nuevo.username + "' creado.");
        }
    }

    public Usuario buscar(String criterio) {
        for (int i = 0; i < total; i++) {
            if (String.valueOf(usuarios[i].id).equals(criterio) || usuarios[i].username.equalsIgnoreCase(criterio)) {
                return usuarios[i];
            }
        }
        return null;
    }


    public void actualizar(Usuario ejecutor, String targetUsername, String passActual, String nuevoNombre, String nuevaPass) {
        Usuario objetivo = buscar(targetUsername);
        if (objetivo == null) {
            System.out.println("Error: Usuario no encontrado.");
            return;
        }

        boolean esAdmin = ejecutor.rol.equalsIgnoreCase("Administrador");
        boolean esPropioPerfil = ejecutor.username.equalsIgnoreCase(targetUsername);

        if (!esAdmin && !esPropioPerfil) {
            System.out.println("Error: Los usuarios Estándar solo pueden actualizar su propio perfil.");
            return;
        }

        if (!objetivo.contrasena.equals(passActual)) {
            System.out.println("Error: Contraseña actual incorrecta.");
            return;
        }

        objetivo.nombreCompleto = nuevoNombre;
        objetivo.contrasena = nuevaPass;
        System.out.println("Éxito: Perfil de '" + targetUsername + "' actualizado.");
    }

    
    public void eliminar(Usuario ejecutor, String usernameAEliminar) {
        if (!ejecutor.rol.equalsIgnoreCase("Administrador")) {
            System.out.println("Error: Los usuarios Estándar no pueden eliminar a otros usuarios.");
            return;
        }

        for (int i = 0; i < total; i++) {
            if (usuarios[i].username.equalsIgnoreCase(usernameAEliminar)) {
                for (int j = i; j < total - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[--total] = null;
                System.out.println("Éxito: Usuario '" + usernameAEliminar + "' eliminado.");
                return;
            }
        }
    }

    public void listar() {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (int i = 0; i < total; i++) {
            usuarios[i].mostrar();
        }
    }
}