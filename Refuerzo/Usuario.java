import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    private int numeroIdentidad;
    private String nombre;
    private String direccion;
    private List<Publicacion> prestamos;

    public Usuario(int numeroIdentidad, String nombre, String direccion) {
        this.numeroIdentidad = numeroIdentidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public int getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Publicacion> getPrestamos() {
        return prestamos;
    }

    public void agregarPrestamo(Publicacion publicacion) {
        prestamos.add(publicacion);
    }
    public static Usuario ingresarNuevoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del nuevo usuario:");
        System.out.print("Número de Identidad: ");
        int numeroIdentidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        return new Usuario(numeroIdentidad, nombre, direccion);
    }
}