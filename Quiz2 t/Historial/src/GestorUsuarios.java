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
            ejecutor.registrarAccion("Creó al usuario: " + nuevo.username);
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
        if (objetivo == null) return;

        boolean esAdmin = ejecutor.rol.equalsIgnoreCase("Administrador");
        boolean esPropio = ejecutor.username.equalsIgnoreCase(targetUsername);

        if (!esAdmin && !esPropio) {
            System.out.println("Error: No tienes permisos.");
            return;
        }

        if (!objetivo.contrasena.equals(passActual)) {
            System.out.println("Error: Contraseña incorrecta.");
            return;
        }

        objetivo.nombreCompleto = nuevoNombre;
        objetivo.contrasena = nuevaPass;
        ejecutor.registrarAccion("Actualizó el perfil de: " + targetUsername);
        System.out.println("Éxito: Perfil actualizado.");
    }

    public void eliminar(Usuario ejecutor, String usernameAEliminar) {
        if (!ejecutor.rol.equalsIgnoreCase("Administrador")) {
            System.out.println("Error: No puedes eliminar usuarios.");
            return;
        }

        for (int i = 0; i < total; i++) {
            if (usuarios[i].username.equalsIgnoreCase(usernameAEliminar)) {
                for (int j = i; j < total - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[--total] = null;
                ejecutor.registrarAccion("Eliminó al usuario: " + usernameAEliminar);
                System.out.println("Éxito: Usuario eliminado.");
                return;
            }
        }
    }
}