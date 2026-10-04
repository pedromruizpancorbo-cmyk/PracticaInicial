package practicaInicial;

import practicaInicial.excepciones.CarritoVacioException;
import practicaInicial.excepciones.ElementoNoEncontradoException;
import practicaInicial.excepciones.StockInsuficienteException;
import practicaInicial.modelo.carrito.GestorCarrito;
import practicaInicial.modelo.factura.Factura;
import practicaInicial.modelo.factura.GestorFactura;
import practicaInicial.modelo.producto.GestorProducto;
import practicaInicial.modelo.producto.Producto;
import practicaInicial.modelo.producto.ProductoDigital;
import practicaInicial.modelo.producto.ProductoFisico;
import practicaInicial.modelo.usuario.GestorUsuarios;
import practicaInicial.modelo.usuario.Usuario;

import java.util.Scanner;

public class Controlador {
    private GestorProducto gestorProducto;
    private GestorUsuarios gestorUsuarios;
    private GestorCarrito gestorCarrito;
    private GestorFactura gestorFactura;
    private Vista vista;

    public Controlador(GestorProducto gestorProducto, GestorUsuarios gestorUsuarios,
                       GestorCarrito gestorCarrito, GestorFactura gestorFactura, Vista vista) {
        this.gestorProducto = gestorProducto;
        this.gestorUsuarios = gestorUsuarios;
        this.gestorCarrito = gestorCarrito;
        this.gestorFactura = gestorFactura;
        this.vista = vista;
    }

    public void iniciar() {
        Scanner s = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            vista.mostrarMenuPrincipal();
            int opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1:
                    menuGestionProductos();
                    break;
                case 2:
                    menuGestionUsuarios();
                    break;
                case 3:
                    menuGestionCarrito();
                    break;
                case 4:
                    menuGestionFacturas();
                    break;
                case 5:
                    gestorFactura.consultarHistorial();
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo...");
                    seguir = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void menuGestionProductos() {
        Scanner s = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            vista.mostrarSubmenuProductos();
            int opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = s.nextLine();
                    System.out.println("Precio base: ");
                    double precio = Double.parseDouble(s.nextLine());
                    System.out.println("Stock: ");
                    int stock = Integer.parseInt(s.nextLine());
                    System.out.println("Gastos de envío: ");
                    float envio = Float.parseFloat(s.nextLine());
                    System.out.println("Peso (kg): ");
                    double peso = Double.parseDouble(s.nextLine());

                    ProductoFisico productoFisico = new ProductoFisico(nombre, precio, stock, envio, peso);
                    gestorProducto.altaProducto(productoFisico);
                    vista.mostrarMensaje("Producto físico añadido con ID: " + productoFisico.getId());
                    break;

                case 2:
                    System.out.println("Nombre: ");
                    String nombreDigi = s.nextLine();
                    System.out.println("Precio: ");
                    double precioDigi = Double.parseDouble(s.nextLine());
                    System.out.println("Stock: ");
                    int stockDigi = Integer.parseInt(s.nextLine());
                    System.out.println("Tamaño (MB): ");
                    int tamanio = Integer.parseInt(s.nextLine());
                    System.out.println("Licencia: ");
                    String licencia = s.nextLine();

                    ProductoDigital productoDigital = new ProductoDigital(nombreDigi, precioDigi, stockDigi, tamanio, licencia);
                    gestorProducto.altaProducto(productoDigital);
                    vista.mostrarMensaje("Producto digital añadido con ID: " + productoDigital.getId());
                    break;

                case 3:
                    System.out.print("Introduce el ID del producto para darlo de baja: ");
                    int idBaja = Integer.parseInt(s.nextLine());

                    try {
                        gestorProducto.bajaProducto(idBaja);
                        vista.mostrarMensaje("Producto eliminado correctamente");

                    } catch (ElementoNoEncontradoException e) {
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    gestorProducto.listadoProductos();
                    break;

                case 5:
                    System.out.println("Introduce el ID a buscar: ");
                    int id = Integer.parseInt(s.nextLine());

                    try{
                        Producto producto = gestorProducto.buscarProductoPorID(id);
                        vista.mostrarMensaje(producto.toString());
                    } catch (ElementoNoEncontradoException e){
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Introduce el precio: ");
                    double precioBuscar = Double.parseDouble(s.nextLine().trim());

                    Producto productoEncontrado = gestorProducto.buscarProductoPorPrecio(precioBuscar);
                    if (productoEncontrado == null) {
                        vista.mostrarMensaje("No se encontraron productos con ese precio");
                    } else {
                        vista.mostrarMensaje(productoEncontrado.toString());
                    }
                    break;

                case 0:
                    seguir = false;
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void menuGestionUsuarios() {
        Scanner s = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            vista.mostrarSubmenuUsuarios();
            int opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = s.nextLine();
                    System.out.println("Email: ");
                    String email = s.nextLine();

                    Usuario usuario = new Usuario(nombre, email);
                    gestorUsuarios.altaUsuario(usuario);
                    vista.mostrarMensaje("Usuario registrado con ID: " + usuario.getId());
                    break;
                case 2:
                    System.out.print("Introduce el ID del usuario a dar de baja: ");
                    int idBaja = Integer.parseInt(s.nextLine());

                    try {
                        gestorUsuarios.bajaUsuario(idBaja);
                        vista.mostrarMensaje("Usuario eliminado correctamente.");
                    } catch (ElementoNoEncontradoException e) {
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    gestorUsuarios.listadoUsuariosActivos();
                    break;

                case 0:
                    seguir = false;
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }


    private void menuGestionCarrito() {
        Scanner s = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            vista.mostrarSubmenuCarrito();
            int opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("ID del producto a añadir: ");
                    int idProducto = Integer.parseInt(s.nextLine());
                    System.out.println("Cantidad: ");
                    int cantidad = Integer.parseInt(s.nextLine());

                    try {
                        Producto productoAniadir = gestorProducto.buscarProductoPorID(idProducto);
                        gestorCarrito.agregarProducto(productoAniadir, cantidad, gestorProducto);
                        vista.mostrarMensaje("Producto añadido al carrito");

                    } catch (ElementoNoEncontradoException e) {
                        vista.mostrarMensaje(e.getMessage());

                    } catch (StockInsuficienteException e) {
                        vista.mostrarMensaje("Error de stock: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("ID del producto a quitar: ");
                    int idEliminar = Integer.parseInt(s.nextLine());

                    try {
                        boolean quitado = gestorCarrito.quitarProducto(idEliminar, gestorProducto);
                        if (quitado) {
                            vista.mostrarMensaje("Producto eliminado del carrito");
                        } else {
                            vista.mostrarMensaje("El producto no estaba en el carrito");
                        }
                    } catch (ElementoNoEncontradoException e) {
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    vista.mostrarMensaje("Total del carrito actual: " + gestorCarrito.obtenerTotal() + "€");
                    break;

                case 0:
                    seguir = false;
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        }
    }

    private void menuGestionFacturas() {
        Scanner s = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            vista.mostrarSubmenuFacturas();
            int opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1:
                    cerrarPedido();
                    break;
                case 2:
                    gestorFactura.consultarHistorial();
                    break;

                case 3:
                    boolean exportado = gestorFactura.exportarHistorialCSV();
                    if (exportado) {
                        vista.mostrarMensaje("Historial exportado con éxito a historialpedidos.csv");
                    } else {
                        vista.mostrarMensaje("No se pudo exportar");
                    }
                    break;

                case 0:
                    seguir = false;
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void cerrarPedido() {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce el ID del usuario cliente: ");
        int idUsuario = Integer.parseInt(s.nextLine());

        try {
            Usuario usuario = gestorUsuarios.buscarPorId(idUsuario);

            Factura factura = gestorFactura.crearFactura(usuario, gestorCarrito.getCarrito());
            if (factura != null) {
                factura.imprimirFactura();
                vista.mostrarMensaje("Pedido cerrado y guardado en el historial con éxito");
            }
        } catch(ElementoNoEncontradoException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        } catch (CarritoVacioException e) {
            vista.mostrarMensaje("Error en el carrito: " + e.getMessage());
        }
    }



}
