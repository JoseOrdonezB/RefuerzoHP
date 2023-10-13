class Articulo extends Publicacion {
    private String arbitro;

    public Articulo(int id, String titulo, String materia, int cantidadEjemplares, String estado, String arbitro) {
        super(id, titulo, null, materia, cantidadEjemplares, estado);
        this.arbitro = arbitro;
    }

    public String getArbitro() {
        return arbitro;
    }
}