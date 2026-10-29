public class Edificio {
    String direccion;
    Apartamento[] apartamentos;
    int contador = 0;

    public Edificio(String direccion, int totalApartamentos) {
        this.direccion = direccion;
        this.apartamentos = new Apartamento[totalApartamentos]; 
    }

    public void agregarApartamento(int numero, int habitaciones) {
        if (contador < apartamentos.length) {
            
            apartamentos[contador++] = new Apartamento(numero, habitaciones);
        } else {
            System.out.println("Edificio lleno. No se puede añadir el apto " + numero);
        }
    }

    public void mostrarDetalles() {
        System.out.println("Edificio en: " + direccion);
        System.out.println("Apartamentos:");
        for (int i = 0; i < contador; i++) {
            apartamentos[i].mostrar();
        }
    }
}