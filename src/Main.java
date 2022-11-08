import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Articulo> articulos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENÚ BIBLIOTECA");
            System.out.println("0. SALIR");
            System.out.println("1. Dar de alta pasatiempos, revistas y libros.");
            System.out.println("2. Mostrar artículos de la biblioteca.");
            System.out.println("3. Mostrar solo las revistas.");
            System.out.println("4. Mostrar solo los libros.");
            System.out.println("5. Mostrar solo los pasatiempos.");
            System.out.println("6. Reservar articulo");
            System.out.println("7. Finalizar reserva");
            System.out.println("8. Mostrar articulos reservados");
            System.out.println("9. Alquilar libro");
            System.out.println("10. Devolver libro");
            System.out.println("11. Mostrar libros alquilados");

            System.out.print("Seleccione opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                default -> System.out.println("Opción inválida, vuelva a intentarlo.");
                case 0 -> System.exit(0);
                case 1 -> darDeAlta();
                case 2 -> mostrarArticulos();
                case 3 -> mostrarSoloRevistas();
                case 4 -> mostrarSoloLibros();
                case 5 -> mostrarSoloPasatiempos();
                case 6 -> reservarArticulo();
                case 7 -> finalizarReserva();
                case 8 -> mostrarArticulosReservados();
                case 9 -> alquilarLibro();
                case 10 -> devolverLibro();
                case 11 -> mostrarLibrosAlquilados();
            }
        }
    }

    static void darDeAlta() {
        Articulo articulo = null;

        System.out.println("Seleccione producto:");
        System.out.println("1. Pasatiempo");
        System.out.println("2. Libro");
        System.out.println("3. Revista");

        System.out.print("Introduzca opción: ");
        int opcion = sc.nextInt();

        System.out.print("Introduzca el código: ");
        String codigo = sc.next();

        System.out.print("Introduzca el título: ");
        String titulo = sc.next();

        System.out.print("Introduzca el año de publicación: ");
        int year = sc.nextInt();

        switch (opcion) {
            default -> System.out.println("Opción incorrecta, vuelva a intentarlo.");
            case 1 -> articulo = new Pasatiempo(codigo, titulo, year);
            case 2 -> articulo = new Libro(codigo, titulo, year);
            case 3 -> {
                System.out.print("Introduzca el número de la revista: ");
                int num = sc.nextInt();

                articulo = new Revista(codigo, titulo, year, num);
            }
        }

        if (articulo != null) {
            articulos.add(articulo);
        }
    }

    static void mostrarArticulos() {
        articulos.forEach(System.out::println);
    }

    static void mostrarSoloRevistas() {
        for (Articulo articulo : articulos) {
            if (articulo instanceof Revista) {
                System.out.println(articulo);
            }
        }
    }

    static void mostrarSoloLibros() {
        for (Articulo articulo : articulos) {
            if (articulo instanceof Libro) {
                System.out.println(articulo);
            }
        }
    }

    static void mostrarSoloPasatiempos() {
        for (Articulo articulo : articulos) {
            if (articulo instanceof Pasatiempo) {
                System.out.println(articulo);
            }
        }
    }

    static void reservarArticulo() {
        System.out.print("Introduzca el código del artículo a reservar: ");
        String cod = sc.next();

        Articulo articulo = null;
        for (Articulo articulo1 : articulos) {
            if (cod.equalsIgnoreCase(articulo1.getCodigo())) {
                articulo = articulo1;
                break;
            }
        }

        if (articulo == null) {
            System.out.println("No se ha encontrado ningún artículo con ese código.");
            return;
        }

        if (articulo instanceof Revista || articulo instanceof Libro) {
            System.out.print("Introduce tu número de socio: ");
            String socio = sc.next();

            if (!articulo.isReservado()) {
                articulo.reservar(socio);
            } else {
                System.out.println("El artículo ya está reservado.");
                return;
            }
        } else {
            System.out.println("El artículo no es una revista o un libro.");
            return;
        }

        System.out.println("Se ha reservado el artículo.");
    }

    static void finalizarReserva() {
        System.out.print("Introduzca el código del artículo a quitar reserva: ");
        String cod = sc.next();

        Articulo articulo = null;
        for (Articulo articulo1 : articulos) {
            if (cod.equalsIgnoreCase(articulo1.getCodigo())) {
                articulo = articulo1;
                break;
            }
        }

        if (articulo == null) {
            System.out.println("No se ha encontrado ningún artículo con ese código.");
            return;
        }

        if (articulo instanceof Revista || articulo instanceof Libro) {
            if (articulo.isReservado()) {
                articulo.quitarReserva();
            } else {
                System.out.println("El artículo no está reservado.");
                return;
            }
        } else {
            System.out.println("El artículo no es una revista o un libro.");
            return;
        }

        System.out.println("Se ha quitado la reserva para el artículo:" + articulo);
    }

    static void mostrarArticulosReservados() {
        for (Articulo articulo : articulos) {
            if (articulo.isReservado()) {
                System.out.println(articulo);
            }
        }
    }

    static void alquilarLibro() {
        System.out.print("Introduzca el código del libro a alquilar: ");
        String cod = sc.next();

        Libro libro = null;
        for (Articulo articulo : articulos) {
            if (articulo instanceof Libro libro1 && cod.equalsIgnoreCase(libro1.getCodigo())) {
                libro = libro1;
            }
        }

        if (libro == null) {
            System.out.println("No se ha encontrado ningún libro con ese código.");
            return;
        }

        System.out.print("Introduce tu número de socio: ");
        String socio = sc.next();

        if (libro.isAlquilado()) {
            System.out.println("El libro ya está alquilado.");
            return;
        } else {
            libro.alquilar(socio);
        }

        System.out.println("Se ha alquilado el libro.");
    }

    static void devolverLibro() {
        System.out.print("Introduzca el código del libro a quitar el alquiler: ");
        String cod = sc.next();

        Libro libro = null;
        for (Articulo articulo : articulos) {
            if (articulo instanceof Libro libro1 && cod.equalsIgnoreCase(libro1.getCodigo())) {
                libro = libro1;
            }
        }

        if (libro == null) {
            System.out.println("No se ha encontrado ningún libro con ese código.");
            return;
        }

        if (libro.isAlquilado()) {
            libro.quitarAlquiler();
        } else {
            System.out.println("El libro no está alquilado.");
            return;
        }

        System.out.println("Se ha quitado el alquiler del libro.");
    }

    static void mostrarLibrosAlquilados() {
        for (Articulo articulo : articulos) {
            if (articulo instanceof Libro libro) {
                System.out.println(libro);
            }
        }
    }
}