class Revista extends Publicacion {
    private int anio;
    private int numero;

    public Revista(int id, String titulo, String materia, int cantidadEjemplares, String estado, int anio, int numero) {
        super(id, titulo, null, materia, cantidadEjemplares, estado);
        this.anio = anio;
        this.numero = numero;
    }

    public int getAnio() {
        return anio;
    }

    public int getNumero() {
        return numero;
    }
}