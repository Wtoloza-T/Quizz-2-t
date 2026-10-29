public class Main {
    public static void main(String[] args) {
       
        Edificio miEdificio = new Edificio("Av. Principal 123", 3);

        
        miEdificio.agregarApartamento(101, 2);
        miEdificio.agregarApartamento(102, 3);
        miEdificio.agregarApartamento(201, 1);

        
        miEdificio.mostrarDetalles();
    }
}