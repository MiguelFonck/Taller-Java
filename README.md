# Taller de Java — Ejercicios de POO

## Descripción

Este repositorio reúne cinco ejercicios de práctica en Java. Cada ejercicio está organizado en su propia carpeta para separar los problemas, las clases y el punto de entrada (`Main`) de cada solución.

La práctica empieza con versiones base y continúa con extensiones que agregan funcionalidades y conceptos de programación orientada a objetos (POO).

## Organización del proyecto

```text
Taller-Java/
├── Ejercicio_1/
│   ├── Banco.java
│   ├── Cuenta.java
│   ├── CuentaAhorro.java
│   ├── CuentaBancaria.java
│   ├── CuentaCorriente.java
│   ├── GestionCajero.java
│   └── Main.java
│
├── Ejercicio_2/
│   ├── Asignatura.java
│   ├── Curso.java
│   ├── Estudiantes.java
│   ├── GestionEstudiantes.java
│   └── main.java
│
├── Ejercicio_3/
│   ├── Carrito.java
│   ├── Cliente.java
│   ├── Inventario.java
│   ├── Main.java
│   ├── Producto.java
│   ├── ProductoAlimenticio.java
│   └── ProductoElectronico.java
│
├── Ejercicio_4/
│   ├── Agenda.java
│   ├── Contacto.java
│   └── Main.java
│
└── Ejercicio_5/
    ├── Alumno.java
    └── Main.java
```

> **Nota:** el árbol anterior refleja los nombres de clases que aparecen en la estructura del proyecto compartida. Los nombres y las mayúsculas/minúsculas se conservan tal como se ven en el explorador. Las clases adicionales de una extensión pueden estar integradas en otras clases o tener nombres distintos según la implementación final.

## Ejercicios base

### Ejercicio 1 — Cajero automático

**Carpeta:** `Ejercicio_1`

Simula las operaciones básicas de un cajero automático: validar el PIN, consultar saldo, retirar dinero, depositar dinero y salir del menú.

Clases principales observadas:
- `CuentaBancaria`: representa una cuenta y sus operaciones.
- `Cuenta`: sirve como clase base para la jerarquía de cuentas.
- `CuentaAhorro` y `CuentaCorriente`: representan tipos de cuenta especializados.
- `Banco`: administra las cuentas y permite buscarlas o validar sus datos.
- `GestionCajero` y `Main`: apoyan la gestión y ejecución del ejercicio.

**Conceptos trabajados:** encapsulamiento, condicionales, ciclos, métodos, listas y herencia.

**Extensiones relacionadas (1–5):**
1. Transferencias entre cuentas.
2. Historial de las últimas cinco transacciones.
3. Gestión de múltiples cuentas.
4. Administración de cuentas mediante una clase `Banco`.
5. Jerarquía de cuentas con herencia.

### Ejercicio 2 — Registro académico

**Carpeta:** `Ejercicio_2`

Permite registrar estudiantes y sus notas, calcular promedios, determinar aprobados y reprobados, e identificar los promedios más alto y más bajo.

Clases principales observadas:
- `Estudiantes`: representa la información de los estudiantes.
- `Asignatura`: contiene información de una asignatura y su nota.
- `Curso`: agrupa estudiantes y centraliza estadísticas.
- `GestionEstudiantes` y `main`: apoyan la gestión y ejecución del registro.

**Conceptos trabajados:** clases, encapsulamiento, arreglos, `ArrayList`, cálculos y búsqueda de objetos.

**Extensiones relacionadas (6–10):**
6. Registrar múltiples asignaturas por estudiante.
7. Centralizar estadísticas en la clase `Curso`.
8. Tener en cuenta la asistencia para aprobar.
9. Guardar reportes del curso en un archivo de texto.
10. Buscar estudiantes y modificar sus notas.

### Ejercicio 3 — Tienda online

**Carpeta:** `Ejercicio_3`

Simula un catálogo de productos y un carrito de compras. El sistema debe validar el stock, calcular el total y mostrar el detalle de la compra.

Clases principales observadas:
- `Producto`: representa un producto del catálogo.
- `ProductoAlimenticio` y `ProductoElectronico`: especializan el producto mediante herencia.
- `Inventario`: centraliza el catálogo y el stock.
- `Cliente`: representa al cliente asociado a la compra.
- `Carrito`: administra los productos seleccionados.
- `Main`: ejecuta la interacción del usuario.

**Conceptos trabajados:** composición entre objetos, colecciones, validación de stock, cálculos y herencia.

**Extensiones relacionadas (11–15):**
11. Filtrar productos por categoría.
12. Aplicar descuentos según el subtotal.
13. Crear tipos de productos mediante herencia.
14. Asociar el carrito a un cliente.
15. Centralizar el stock en la clase `Inventario`.

### Ejercicio 4 — Agenda de contactos

**Carpeta:** `Ejercicio_4`

Permite registrar, buscar, listar y eliminar contactos mediante un menú.

Clases principales observadas:
- `Contacto`: almacena nombre, teléfono y correo electrónico.
- `Agenda`: administra la colección de contactos.
- `Main`: ejecuta el menú de la aplicación.

**Conceptos trabajados:** encapsulamiento, getters, colecciones, búsquedas, validación y persistencia de datos.

**Extensiones relacionadas (16–20):**
16. Sustituir el arreglo de tamaño fijo por un `ArrayList`.
17. Validar el teléfono y el correo electrónico.
18. Buscar contactos por coincidencia parcial del nombre.
19. Organizar contactos por grupos.
20. Guardar y cargar contactos desde archivos.

### Ejercicio 5 — Sistema de notas con curva

**Carpeta:** `Ejercicio_5`

Registra alumnos y sus notas, calcula el promedio del curso y aplica una curva cuando el promedio general es menor que el mínimo establecido. Finalmente, muestra las notas y el estado de aprobación.

Clases principales observadas:
- `Alumno`: representa al alumno y gestiona sus notas.
- `Main`: coordina el registro, los cálculos y los resultados.

**Conceptos trabajados:** métodos, condicionales, ciclos, cálculos estadísticos y manejo de errores.

**Extensiones relacionadas (21–25):**
21. Aplicar una curva porcentual.
22. Calcular la curva a partir de la nota más alta.
23. Calcular la nota mediante ponderaciones.
24. Manejar entradas no numéricas con `try-catch`.
25. Calcular estadísticas avanzadas, como la media, la desviación estándar y los alumnos que aprobaron gracias a la curva.

## Conceptos generales del taller

A lo largo de los ejercicios se practican los siguientes temas:

- **POO:** clases, objetos, atributos, métodos y encapsulamiento.
- **Control de flujo:** condicionales y ciclos.
- **Colecciones:** arreglos y `ArrayList`.
- **Relaciones entre clases:** composición y asociación.
- **Herencia:** clases base y clases especializadas.
- **Validación:** control de datos, stock, notas y credenciales.
- **Archivos:** generación de reportes y persistencia de información.
- **Excepciones:** manejo de entradas incorrectas.
- **Estadísticas:** promedios, máximos, mínimos y desviación estándar.

## Cómo ejecutar los ejercicios

1. Abre el proyecto en tu IDE de Java.
2. En el explorador, abre la carpeta del ejercicio que quieras probar.
3. Localiza su clase principal (`Main` o `main`, según el ejercicio).
4. Ejecuta esa clase y sigue las instrucciones que aparezcan en la consola.
5. Prueba las extensiones del ejercicio para comprobar las funcionalidades adicionales.

**Importante:** Java distingue entre mayúsculas y minúsculas. Ejecuta la clase principal con el nombre exacto que tenga en el proyecto. Si el IDE no reconoce una clase, revisa también el nombre del archivo, la declaración `package` y las dependencias entre clases.

## Propósito

El objetivo del taller es construir soluciones pequeñas y separadas para aprender progresivamente a modelar problemas cotidianos con Java, organizar responsabilidades en clases y ampliar una solución inicial sin mezclar los cinco ejercicios en una sola aplicación.
