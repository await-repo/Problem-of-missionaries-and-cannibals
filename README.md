## **Problema de los misioneros y caníbales**

### **Resumen**

Se diseñó una estructura de datos **(grafo)** donde cada estado es un nodo y esta conectado con su estado anterior mediante una arista.

**El objetivo es construir un grafo** con todos los estados en orden desde el estado incial hasta el estado final, conectados por aristas únicamente por su estado anterior y su estado posterior.

### **Reglas**

1. El bote solo puede llevar máximo dos pasajeros, mínimo uno (el bote no puede cruzar vacío).
2. El número de caníbales siempre debe ser menor o igual que el número de misioneros, de lo contrario los caníbales se comerían a los misioneros.
3. Los caníbales y misioneros pueden cruzar a cualquiera de los dos lados cuantas veces quieran, siempre que no rompan la regla 2.
4. Para terminar el reto **todos los misioneros y caníbales deberán cruzar del otro lado del río**. Si todos empezaron del lado izquierdo la meta será cruzar al lado derecho, si todos empezaron del lado derecho entonces la meta será llegar al lado izquierdo.

    **Ejemplo**

    Los cuadrados son misioneros y los triángulos son caníbales.

    **Estado Inicial**

    ![State1](https://user-images.githubusercontent.com/115047831/214737743-a9cd1873-dcc1-45f4-a111-568d123fd860.png)

    **Estado Final**

    ![StateFinal](https://user-images.githubusercontent.com/115047831/214738650-7e974964-fd29-4b4a-a7cd-756e45e7383a.png)
