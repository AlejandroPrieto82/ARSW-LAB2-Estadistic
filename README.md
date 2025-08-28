# ARSW Programa Stadistic
## Hecho por: Alejandro Prieto Reyes
---
Proyecto para calcular estadísticas básicas (media y desviación estándar) de conjuntos de datos leídos desde archivos de texto. Este proyecto utiliza una implementación propia de LinkedList y procesamiento multihilo para los cálculos.

## Descripción del diseño

El proyecto está organizado en varios paquetes:

- `eci.edu.arsw.linkedList`  
  Implementa una **LinkedList personalizada** para almacenar los datos numéricos. Contiene:
  - `LinkedList.java`: la lista enlazada con métodos `add`, `remove`, `size`, `isEmpty` y un iterador para recorrerla.
  - `Node.java`: nodo de la lista que contiene un valor `double` y referencia al siguiente nodo.

- `eci.edu.arsw.calculator`  
  Contiene los hilos que realizan los cálculos estadísticos:
  - `Mean.java`: calcula la media de los valores de la lista.
  - `StandardDeviation.java`: calcula la desviación estándar a partir de la media.

- `eci.edu.arsw.util`  
  - `DataReader.java`: lee archivos de texto y convierte cada línea en un número `double`, almacenándolos en un `LinkedList`.

- `eci.edu.arsw.Main`  
  Clase principal que:
  1. Lee los datos desde los archivos de `resources`.
  2. Crea hilos para calcular media y desviación estándar.
  3. Imprime los resultados.

## Getting Started

Sigue estas instrucciones para ejecutar el proyecto en tu máquina local.

### Prerequisites

- Java 11 o superior
- IDE recomendado: VSCode
- Maven **(opcional)**

### Installing

1. Clona el repositorio:
```bash
git clone https://github.com/AlejandroPrieto82/ARSW-Programa-Stadistic.git
````

2. Compila el proyecto:
```bash
cd ARSW-Programa-Stadistic
javac -d bin src/main/java/eci/edu/arsw/**/*.java
```

3. Ejecuta el proyecto:
```bash
java -cp bin eci.edu.arsw.Main
```

### Expected Results
Dependiendo del archivo de entrada (`Table1.1.txt`, `Table1.2.txt`, `Table3.txt`), se obtendrán resultados como:

```
Mean: 550.6
Standard deviation: 572.03

Mean: 60.32
Standard deviation: 62.26

Mean: 638.9
Standard deviation: 625.63
```

## Built With
* Java - Lenguaje de programación
* Threads - Para cálculos concurrentes
* LinkedList personalizada - Estructura de datos
* Javadoc - Para documentación del código

## Contributing

Puedes contribuir mediante pull requests. Sigue las normas de estilo y agrega comentarios/documentación donde sea necesario.

## License

Este proyecto está bajo la licencia MIT. Consulta [LICENSE.md](LICENSE.md) para más detalles.

## Authors

* **Alejandro Prieto Reyes** - *Desarrollador principal* - [GitHub](https://github.com/AlejandroPrieto82)

## Acknowledgments

* Inspiración en la enseñanza de ARSW
* Ejemplos de manejo de archivos y multithreading
* Materiales de cursos de estructuras de datos y programación concurrente

```