# Sistema de Gestión de Ventas - Librería / Papelería (Java Consola)

Aplicación de consola desarrollada en **Java** bajo el paradigma de **Programación Orientada a Objetos (POO)** para la gestión, consulta y análisis de ventas de una papelería. El sistema utiliza persistencia de datos mediante archivos planos (`.csv`) y herramientas modernas de Java como **Streams** y **Expresiones Lambda** para el procesamiento de métricas y rankings.

---

## Funcionalidades Principales

El menú interactivo en consola cuenta con **9 módulos operativos**:

1. **Búsqueda por Producto:** Localiza transacciones filtrando por coincidencias en el nombre del artículo.
2. **Búsqueda por Cliente:** Permite consultar el historial de compras ingresando el nombre, apellido o número de DNI.
3. **Listado General:** Muestra el registro completo de todas las ventas cargadas en el sistema.
4. **Ventas por Vendedor:** Agrupa y contabiliza las unidades vendidas y el monto total generado por cada vendedor.
5. **Ventas por Método de Pago:** Desglosa las transacciones y montos recaudados según el medio de pago utilizado.
6. **Filtrado por Categoría:** Lista las ventas pertenecientes a una categoría específica de productos.
7. **Rankings (Top 5):**
   * Top 5 de productos con mayor cantidad de unidades vendidas.
   * Top 5 de ventas con mayor monto facturado (`S/`).
8. **Reportes Financieros:** Calcula automáticamente el total recaudado, total de **IGV (18%)**, unidades vendidas, número de transacciones y el ticket promedio por venta.
9. **Detalle Completo de Venta:** Muestra la boleta detallada de una transacción específica mediante su `ID de Venta`.

---

## Arquitectura y Estructura del Proyecto

El proyecto está gestionado con **Apache Maven** y sigue una separación modular de responsabilidades:

```text
sistemas-ventas-libreria/
├── src/main/java/com/mycompany/libreria
│   ├── Principal.java         # Punto de entrada de la aplicación (método main)
│   ├── Menu.java              # Controlador de la interfaz de consola e interacción con el usuario
│   ├── Venta.java             # Clase modelo (atributos, constructor y getters encapsulados)
│   ├── DatosVentas.java       # Capa de persistencia: lectura y parseo del archivo CSV
│   ├── Buscador.java          # Lógica de búsqueda específica por producto
│   ├── FiltroCategoria.java   # Lógica de filtrado por categoría
│   └── Ranking.java           # Ordenamiento con Java Streams y Comparators (Top 5)
├── BaseDeDatosPF.csv          # Base de datos en formato de valores separados por comas
└── pom.xml                    # Archivo de configuración y dependencias de Maven
```

---

## Tecnologías y Conceptos Aplicados

* **Lenguaje:** Java (JDK 8+)
* **Gestor de Proyecto:** Apache Maven
* **Paradigma:** Programación Orientada a Objetos (Abstracción, Encapsulamiento, Modularidad)
* **Manejo de Archivos:** `java.io.BufferedReader` y `java.io.FileReader` con manejo de excepciones (`NumberFormatException`, `IOException`)
* **Colecciones y Funcional:** `ArrayList<Venta>`, `Stream API`, `Comparator` y expresiones Lambda

---

## Cómo Ejecutar el Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/miguelcastilloalcarraz/sistemas-ventas-libreria.git
   ```
2. **Abrir en tu IDE favorito:**
   * Importa la carpeta como un **Proyecto Maven** en NetBeans, IntelliJ IDEA o Eclipse (con Extension Pack for Java en VS Code).
3. **Verificar el archivo de datos:**
   * Asegúrate de que el archivo `BaseDeDatosPF.csv` se encuentre en la **carpeta raíz** del proyecto (al mismo nivel que `pom.xml` y `src/`).
4. **Ejecutar:**
   * Corre la clase `Principal.java` para desplegar el menú en consola.

---

## Autor

* **Miguel Castillo** — [@miguelcastilloalcarraz](https://github.com/miguelcastilloalcarraz)
