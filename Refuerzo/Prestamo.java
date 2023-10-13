import java.util.Date;

class Prestamo {
    private Usuario usuario;
    private Publicacion publicacion;
    private Date fechaSolicitud;
    private Date fechaDevolucion;

    public Prestamo(Usuario usuario, Publicacion publicacion, Date fechaSolicitud) {
        this.usuario = usuario;
        this.publicacion = publicacion;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}