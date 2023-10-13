class Libro extends Publicacion {
    private String editorial;

    public Libro(int id, String titulo, String autor, String editorial, String materia, int cantidadEjemplares,
            String estado) {
        super(id, titulo, autor, materia, cantidadEjemplares, estado);
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }
}