import co.edu.uniquindio.biblioteca.models.Biblioteca;
import co.edu.uniquindio.biblioteca.models.Cliente;
import co.edu.uniquindio.biblioteca.models.Libro;
import co.edu.uniquindio.biblioteca.models.Empleado;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = inicializarDatos();

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Ingrese la opción del menú");
            switch (opcion) {
                case 1:
                    String resultado = crearCliente(biblioteca);
                    System.out.println("Información del cliente: "+resultado);
                    break;
                case 2:
                    Cliente cliente = obtenerCliente(biblioteca);
                    int edad = leerEntero("Ingrese la edad del cliente a validar");
                    String resultadoValidacion = validarEdadCliente(cliente, edad);
                    System.out.println("Resultado de la operación: "+resultadoValidacion);
                    break;
                case 3:
                    String resultadoLibro = crearLibro(biblioteca);
                    System.out.println("Información del libro: "+resultadoLibro);
                    break;
                case 4:
                    Libro libro = obtenerLibro(biblioteca);
                    String nombreLibro = leerStringConsola("Ingrese el nombre del libro: ");
                    String resultadoValidacionLibro = validarNombreLibro(libro, nombreLibro);
                    System.out.println("Resultado de la validació libro: "+resultadoValidacionLibro);
                    break;
                case 5:
                    String resultadoEmpleado = crearEmpleado(biblioteca);
                    System.out.println("Información del empleado: "+resultadoEmpleado);
                default:
                    break;
            }
        } while (opcion != 6);
    }

    private static String validarEdadCliente(Cliente cliente, int edad) {
        if(cliente != null){
            if(cliente.getEdad() == edad) {
                return "La edad del cliente es valida";
            }else{
                return "La edad del cliente no es valida";
            }
        }else{
            return "No se puede validar, el cliente no existe";
        }
    }
    private static String validarNombreLibro(Libro libro, String nombreLibro) {
        if(libro != null){
            if(libro.getNombre().equals(nombreLibro)){
                return "El nombre del libro es válido";
            }else {
                return "El nombre del libro no es válido";
            }
        }
        return  "No se puede validar, el libro no existe";
    }

    private static Cliente obtenerCliente(Biblioteca biblioteca) {
        String idCliente = leerStringConsola("Ingrese el id del cliente a buscar");
        Cliente clienteEncontrado = null;
        for(int i=0; i<biblioteca.getListaClientes().size();i++) {
            if (biblioteca.getListaClientes().get(i).getId().equals(idCliente)) {
                clienteEncontrado = biblioteca.getListaClientes().get(i);
                break;
            }
        }

        return clienteEncontrado;
    }

    private static Libro obtenerLibro(Biblioteca biblioteca) {
        String nombreLibre = leerStringConsola("Ingrese el nombre del libro a buscar");
        Libro libroEncontrado = null;
        for (Libro libro : biblioteca.getListaLibros()){
            if (libro.getNombre().equals(nombreLibre)) {
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    private static Biblioteca inicializarDatos() {
        //Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("UQ");
        //Crear el cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setId("1094");
        cliente.setTelefono("87676768");
        cliente.setEdad(30);
        Empleado empleado = new Empleado("Pepe","Suarez","1094658970","Villa alejandra mz 2 cs 10", 27);
        Libro libro = new Libro("Fahrenheit","futuro distópico con énfasis en el control de información", "distópico","Geroge Orwell",126);
        biblioteca.getListaClientes().add(cliente);
        biblioteca.getListaEmpleados().add(empleado);
        biblioteca.getListaLibros().add(libro);

        return biblioteca;
    }


    public static String crearCliente(Biblioteca biblioteca) {
        //1.Capturar los datos del cliente
        String nombre = leerStringConsola("Ingrese el nombre del cliente");
        String id = leerStringConsola("Ingrese el Id de cliente");
        String telefono = leerStringConsola("Ingrese el telefono de cliente");
        //2. Crear la instancia del cliente
        Cliente cliente = new Cliente();
        //3. Agregar los datos capturados al cliente
        cliente.setNombre(nombre);
        cliente.setId(id);
        cliente.setTelefono(telefono);
        biblioteca.getListaClientes().add(cliente);
        //4. retornar respuesta
        return cliente.toString();
    }

    public static String crearLibro(Biblioteca biblioteca) {

        String nombre = leerStringConsola("Ingrese el nombre del libro");
        String descripcion = leerStringConsola("Ingrese la descripcion del libro");
        String genero = leerStringConsola("Ingrese el genero del libro");
        String autor = leerStringConsola("Ingrese el autor del libro");
        int numPaginas = leerEntero("Ingrese el numero de paginas del libro");

        Libro libro = new Libro(nombre,descripcion,genero,autor,numPaginas);

        biblioteca.getListaLibros().add(libro);
        //4. retornar respuesta
        return libro.toString();
    }

    public static String crearEmpleado(Biblioteca biblioteca) {

        String nombre = leerStringConsola("Ingrese el nombre del empleado");
        String apellido = leerStringConsola("Ingrese el apellido del empleado");
        String cedula = leerStringConsola("Ingrese la cédula del empleado");
        String direccion = leerStringConsola("Ingrese la direccion del empleado");
        int edad = leerEntero("Ingrese la edad del  empleado");

        Empleado empleado = new Empleado(nombre,apellido,cedula,direccion,edad);

        biblioteca.getListaEmpleados().add(empleado);
        //4. retornar respuesta
        return empleado.toString();
    }

    private static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }

    public static String leerStringConsola(String mensaje)
    {
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

    public static void mostrarMenu() {
        System.out.println("Opciones disponibles:");
        System.out.println("1 - Crear Cliente");
        System.out.println("2 - Validar edad del cliente");
        System.out.println("3 - Crear libro");
        System.out.println("4 - Validar nombre del libro");
        System.out.println("5 - Crear empleado");
        System.out.println("6 - Salir");
    }

}

