import java.util.Scanner;

class Publicacion {
    private int id;
    private String titulo;
    private String autor;
    private String materia;
    private int cantidadEjemplares;
    private String estado;

    public Publicacion(int id, String titulo, String autor, String materia, int cantidadEjemplares, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.materia = materia;
        this.cantidadEjemplares = cantidadEjemplares;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getMateria() {
        return materia;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public String getEstado() {
        return estado;
    }

    public static Publicacion ingresarNuevaPublicacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de la nueva publicación:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor/Editorial/Arbitro/: ");
        String autorEditorialArbitro = scanner.nextLine();
        System.out.print("Materia: ");
        String materia = scanner.nextLine();
        System.out.print("Cantidad de ejemplares: ");
        int cantidadEjemplares = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Estado (Disponible/Agotado): ");
        String estado = scanner.nextLine();

        if (autorEditorialArbitro.equalsIgnoreCase("No")) {
            return new Revista(id, titulo, materia, cantidadEjemplares, estado, 0, 0);
        } else if (estado.equalsIgnoreCase("No")) {
            return new Articulo(id, titulo, materia, cantidadEjemplares, autorEditorialArbitro, estado);
        } else {
            System.out.print("Editorial: ");
            String editorial = scanner.nextLine();
            return new Libro(id, titulo, autorEditorialArbitro, editorial, materia, cantidadEjemplares, estado);
        }
    }
}