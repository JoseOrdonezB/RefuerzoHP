import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar nueva publicación");
            System.out.println("2. Consultar título por ID");
            System.out.println("3. Contar documentos por materia");
            System.out.println("4. Contar revistas por materia");
            System.out.println("5. Mostrar información de libros");
            System.out.println("6. Agregar nuevo usuario");
            System.out.println("7. Realizar préstamo");
            System.out.println("8. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    Publicacion nuevaPublicacion = Publicacion.ingresarNuevaPublicacion();
                    biblioteca.agregarPublicacion(nuevaPublicacion);
                    System.out.println("Nueva publicación agregada con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el ID de la publicación: ");
                    int idConsulta = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    String titulo = biblioteca.obtenerTituloPorId(idConsulta);
                    System.out.println("Título: " + titulo);
                    break;
                case 3:
                    System.out.print("Ingrese la materia: ");
                    String materiaConsulta = scanner.nextLine();
                    int cantidadDocumentos = biblioteca.contarDocumentosPorMateria(materiaConsulta);
                    System.out.println(
                            "Cantidad de documentos de la materia '" + materiaConsulta + "': " + cantidadDocumentos);
                    break;
                case 4:
                    System.out.print("Ingrese la materia: ");
                    String materiaRevistaConsulta = scanner.nextLine();
                    int cantidadRevistas = biblioteca.contarRevistasPorMateria(materiaRevistaConsulta);
                    System.out.println(
                            "Cantidad de revistas de la materia '" + materiaRevistaConsulta + "': " + cantidadRevistas);
                    break;
                case 5:
                    System.out.println("Información de los libros:");
                    biblioteca.mostrarInformacionDeLibros();
                    break;
                case 6:
                    Usuario nuevoUsuario = Usuario.ingresarNuevoUsuario();
                    usuarios.add(nuevoUsuario);
                    System.out.println("Nuevo usuario agregado con éxito.");
                    break;
                case 7:
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados. Agregue un usuario primero.");
                    } else {
                        System.out.print("Ingrese el número de identidad del usuario: ");
                        int numeroIdentidad = scanner.nextInt();
                        Usuario usuario = null;
                        for (Usuario u : usuarios) {
                            if (u.getNumeroIdentidad() == numeroIdentidad) {
                                usuario = u;
                                break;
                            }
                        }
                        if (usuario == null) {
                            System.out.println("Usuario no encontrado.");
                        } else {
                            System.out.print("Ingrese el ID de la publicación a prestar: ");
                            int idPrestamo = scanner.nextInt();
                            Publicacion publicacionPrestamo = null;
                            for (Publicacion p : biblioteca.getPublicaciones()) {
                                if (p.getId() == idPrestamo) {
                                    publicacionPrestamo = p;
                                    break;
                                }
                            }
                            if (publicacionPrestamo == null) {
                                System.out.println("Publicación no encontrada.");
                            } else {
                                biblioteca.prestarPublicacion(usuario, publicacionPrestamo, new Date());
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
