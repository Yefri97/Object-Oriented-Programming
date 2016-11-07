# Solitario Batalla Naval
## Descripción
El puzzle de la batalla naval consiste de una cuadricula, una sumatoria de filas y columnas, y un conjunto de barcos de diferentes tamaños (el ancho de los barcos es 1). El objetivo del puzzle es mostrar que los barcos pueden ser posicionados en la cuadricula, de tal forma que cumpla las siguiente restricciones:
- Todos los barcos deben ser puestos en el campo.
- Dos barcos no ocupan casillas adyacentes.
- El numero de segmentos de barcos en la columna (fila) *i* es igual al *i*th valor de la columna (fila).

**Ejemplo:**

Usando barcos de tamaño -> {1, 1, 2, 3}
        . . . . . 1             . . . . # 1
        . . . . . 3             # # # . . 3
        . . . . . 0     -->     . . . . . 0
        . . . . . 2             . . # # . 2
        . . . . . 1             # . . . . 1
        2 1 2 1 1               2 1 2 1 1

**Solución:**

Modelandolo como un problema por restricciones y haciendo una busqueda exhaustiva (Backtracking) usando la libreria AIMA (Artificial Intelligence Modern Approach) en JAVA se puede decir si el problema dado tiene solucion o no.

## Entrada:

- Un entero n indicando el tamaño del tablero
- Un entero m indicando el numero de barcos para usar
- **m** enteros indicando la longitud de los barcos
- **n** enteros indicando la sumatoria de cada fila
- **n** enteros indicando la sumatoria de cada columna

## Salida:
- Un tablero de tamaño **n * n** con caracteres {*, .}, donde * indica que hay un segmento de barco y un **.** indica que es una casilla vacia.

## Ejemplo:
**Entrada:**

5 4
1 1 2 3
1 3 0 2 1
2 1 2 1 1

**Salida:**

....*
***..
.....
..**.
*....