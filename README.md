# Sistema de Gestión de Inventario y Ventas (MVC)

Este programa es una aplicación de consola desarrollada en Java aplicando la arquitectura Modelo-Vista-Controlador (MVC), conceptos avanzados de Programación Orientada a Objetos (POO) y un tratamiento de errores mediante excepciones personalizadas.

## Arquitectura del Proyecto

El sistema está organizado por paquetes para garantizar el orden y la separación de funcionalidades:

```text
src/
└── practicaInicial/
    ├── excepciones/
    │   ├── CarritoVacioException.java
    │   ├── ElementoNoEncontradoException.java
    │   └── StockInsuficienteException.java
    ├── modelo/
    │   ├── carrito/
    │   │   ├── Carrito.java
    │   │   └── GestorCarrito.java
    │   ├── factura/
    │   │   ├── Factura.java
    │   │   └── GestorFactura.java
    │   ├── producto/
    │   │   ├── Producto.java 
    │   │   ├── ProductoFisico.java
    │   │   ├── ProductoDigital.java
    │   │   └── GestorProducto.java
    │   └── usuario/
    │       ├── Usuario.java
    │       └── GestorUsuarios.java
    ├── Controlador.java
    ├── Vista.java
    └── Main.java
```

## Funcionalidad Extra Implementada: Persistencia Alternativa (CSV)

Se ha integrado la opción de Persistencia alternativa (Exportación a archivo CSV) para mejorar la persistencia del sistema, con opción a ampliar las funcionalidades en un futuro.

El archivo .csv se encuentra en el directorio archivos bajo el nombre 'historialpedidos.csv'. Cada vez que se ejecuta el programa añade los nuevos historiales.

## Ejecución de la aplicación
- Opción 1: Desde tu editor de código (IntelliJ, Eclipse, etc.)
    1. Comprueba que tienes Java instalado en el ordenador.

    2. Abre el proyecto con tu editor de código preferido.

    3. Busca el archivo Main.java y dale a Ejecutar (Run).

- Opción 2: Usando el archivo ejecutable (.jar)
    1. Abre la consola o terminal de comandos de tu ordenador.

    2. Entra en la carpeta donde está el archivo ejecutable con este comando:
        cd .\PracticaInicial\out\artifacts\PracticaInicial.jar
    
    3. Arranca el programa escribiendo:
        java -jar PracticaInicial.jar
