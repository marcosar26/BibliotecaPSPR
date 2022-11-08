public class Revista extends Articulo {
    private final int numero;
    private boolean reservado;
    private String numSocio;

    public Revista(String codigo, String titulo, int year, int numero) {
        super(codigo, titulo, year);
        this.numero = numero;
        this.reservado = false;
        this.numSocio = null;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "---Revista---" + System.lineSeparator() + "Código: " + this.getCodigo() + System.lineSeparator() + "Título: " + this.getTitulo() + System.lineSeparator() + "Año: " + this.getYear() + System.lineSeparator() + "Número: " + this.numero + System.lineSeparator() + "Está reservada: " + this.reservado + System.lineSeparator() + "Número de socio: " + this.numSocio + System.lineSeparator();
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar(String numSocio) {
        this.reservado = true;
        this.numSocio = numSocio;
    }

    public void quitarReserva() {
        this.reservado = false;
        this.numSocio = null;
    }
}
