import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Biblioteca {
    private List<Publicacion> publicaciones = new ArrayList<>();

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public String obtenerTituloPorId(int id) {
        for (Publicacion publicacion : publicaciones) {
            if (publicacion.getId() == id) {
                return publicacion.getTitulo();
            }
        }
        return "Publicación no encontrada";
    }

    public int contarDocumentosPorMateria(String materia) {
        int count = 0;
        for (Publicacion publicacion : publicaciones) {
            if (publicacion.getMateria().equals(materia)) {
                count++;
            }
        }
        return count;
    }

    public int contarRevistasPorMateria(String materia) {
        int count = 0;
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Revista && publicacion.getMateria().equals(materia)) {
                count++;
            }
        }
        return count;
    }

    public void mostrarInformacionDeLibros() {
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Libro) {
                System.out.println("Título: " + publicacion.getTitulo());
                System.out.println("Autor: " + publicacion.getAutor());
                System.out.println("Materia: " + publicacion.getMateria());
                System.out.println();
            }
        }
    }

    public void prestarPublicacion(Usuario usuario, Publicacion publicacion, Date fechaSolicitud) {
        if (usuario.getPrestamos().size() < 5) {
            Prestamo prestamo = new Prestamo(usuario, publicacion, fechaSolicitud);
            usuario.agregarPrestamo(publicacion);
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("El usuario ha alcanzado el límite de préstamos (máximo 5).");
        }
    }
}