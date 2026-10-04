package practicaInicial;

public class Vista {
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "\u001B[34m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String NARANJA = "\u001B[38;5;208m";

    public Vista(){}

    public void mostrarMenuPrincipal() {
        System.out.println(AZUL + "\n========== SISTEMA DE GESTIÓN DE INVENTARIO ==========" + RESET);
        System.out.println("1. Gestionar productos");
        System.out.println("2. Gestionar usuarios");
        System.out.println("3. Gestionar carrito");
        System.out.println("4. Cerrar pedido / Generar factura");
        System.out.println("5. Consultar historial de pedidos");
        System.out.println("0. Salir");
        System.out.println(AMARILLO + "Selecciona una opción: " + RESET);
    }

    public void mostrarSubmenuProductos() {
        System.out.println(CYAN + "\n--- GESTIÓN DE PRODUCTOS ---" + RESET);
        System.out.println("1. Alta de producto físico");
        System.out.println("2. Alta de producto digital");
        System.out.println("3. Dar de baja producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Buscar producto por ID");
        System.out.println("6. Buscar producto por precio");
        System.out.println("0. Volver");
        System.out.println(AMARILLO + "Opción: " + RESET);
    }
    public void mostrarSubmenuUsuarios() {
        System.out.println(CYAN + "\n--- GESTIÓN DE USUARIOS ---" + RESET);
        System.out.println("1. Dar de alta usuario");
        System.out.println("2. Dar de baja usuario");
        System.out.println("3. Listar usuarios");
        System.out.println("0. Volver al menú principal");
        System.out.println(AMARILLO + "Opción: " + RESET);
    }

    public void mostrarSubmenuCarrito() {
        System.out.println(CYAN + "\n--- GESTIÓN DE CARRITO ---" + RESET);
        System.out.println("1. Añadir producto al carrito");
        System.out.println("2. Quitar producto del carrito");
        System.out.println("3. Ver total del carrito");
        System.out.println("0. Volver");
        System.out.println(AMARILLO + "Opción: " + RESET);
    }

    public void mostrarSubmenuFacturas() {
        System.out.println(CYAN + "\n--- GESTIÓN DE FACTURAS Y PEDIDOS ---" + RESET);
        System.out.println("1. Cerrar pedido");
        System.out.println("2. Consultar historial de pedidos");
        System.out.println("3. Exportar historial a fichero CSV (Excel)");
        System.out.println("0. Volver al menú principal");
        System.out.println(AMARILLO + "Selecciona una opción: " + RESET);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
