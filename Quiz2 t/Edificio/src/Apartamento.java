public class Apartamento {
    int numero;
    int habitaciones;

    public Apartamento(int numero, int habitaciones) {
        this.numero = numero;
        this.habitaciones = habitaciones;
    }

    public void mostrar() {
        System.out.println("  - Apto " + numero + " (" + habitaciones + " habs)");
    }
}