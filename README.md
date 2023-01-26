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

    Los triángulos son misioneros y los cuadrados son caníbales.

    **Estado Inicial**

    ![State1](https://user-images.githubusercontent.com/115047831/214737743-a9cd1873-dcc1-45f4-a111-568d123fd860.png)

    **Estado Final**

    ![StateFinal](https://user-images.githubusercontent.com/115047831/214738650-7e974964-fd29-4b4a-a7cd-756e45e7383a.png)



### **Ejemplo de una solución válida**

**Estado** | **Imagen** | **Descripción**
--- | --- | ---
**Estado Inicial** | ![State1](https://user-images.githubusercontent.com/115047831/214737743-a9cd1873-dcc1-45f4-a111-568d123fd860.png) | <ul><li>3 caníbales y 3 misioneros del lado izquierdo del río.</li></ul>
Segundo Estado | ![State2](https://user-images.githubusercontent.com/115047831/214747447-64c7bb68-354c-4245-b040-672acfd3758a.png) | <ul><li>1 caníbal y 3 misioneros del lado izquierdo del río.</li><li>2 caníbales y 0 misioneros del lado derecho del río.</li></ul> 
Tercer Estado | ![State3](https://user-images.githubusercontent.com/115047831/214747906-29b33e66-aa29-4966-9d7d-997c62ca66e8.png) | <ul><li>2 caníbales y 3 misioneros del lado izquierdo del río.</li><li>1 caníbal y 0 misioneros del lado derecho del río.</li></ul>
Cuarto Estado | ![State4](https://user-images.githubusercontent.com/115047831/214748421-8621c1e6-7cf1-43f8-9632-ecc8d5f85446.png) | <ul><li>0 caníbales y 3 misioneros del lado izquierdo del río.</li><li>3 caníbales y 0 misioneros del lado derecho del río.</li></ul>
Quinto Estado | ![State5](https://user-images.githubusercontent.com/115047831/214748675-79334155-c531-4551-9df1-e45199ac4bd8.png) | <ul><li>1 caníbal y 3 misioneros del lado izquierdo del río.</li><li>2 caníbales y 0 misioneros del lado derecho del río.</li></ul>
Sexto Estado | ![State6](https://user-images.githubusercontent.com/115047831/214748843-ddbfa3eb-c615-4f39-835c-f296e2c50279.png) | <ul><li>1 caníbal y 1 misionero del lado izquierdo del río.</li><li>2 caníbales y 2 misioneros del lado derecho del río.</li></ul>
Séptimo Estado | ![State7](https://user-images.githubusercontent.com/115047831/214749048-32c0a526-2993-4513-a939-a394a2173e2c.png) | <ul><li>2 caníbales y 2 misioneros del lado izquierdo del río.</li><li>1 caníbal y 1 misionero del lado derecho del río.</li></ul>
Octavo Estado | ![State8](https://user-images.githubusercontent.com/115047831/214749339-37c5c8cc-ccc3-4aa5-8446-33478cf1a3fb.png) | <ul><li>2 caníbales y 0 misioneros del lado izquierdo del río.</li><li>1 caníbal y 3 misioneros del lado derecho del río.</li></ul>
Noveno Estado | ![State9](https://user-images.githubusercontent.com/115047831/214749658-bd97b976-d6c4-455a-8fae-4fa791d89d11.png) | <ul><li>3 caníbales y 0 misioneros del lado izquierdo del río.</li><li>0 caníbales y 3 misioneros del lado derecho del río.</li></ul>
Décimo Estado | ![State10](https://user-images.githubusercontent.com/115047831/214749776-e7b6f3d2-ff8a-4a8d-80be-9152a4bffa90.png) | <ul><li>1 caníbal y 0 misioneros del lado izquierdo del río.</li><li>2 caníbales y 3 misioneros del lado derecho del río.</li></ul>
Onceavo Estado | ![State11](https://user-images.githubusercontent.com/115047831/214749975-68934e24-fddd-4788-b506-0c5dc823e340.png) | <ul><li>2 caníbales y 0 misioneros del lado izquierdo del río.</li><li>1 caníbal y 3 misioneros del lado derecho del río.</li></ul>
**Estado Final** | ![StateFinal](https://user-images.githubusercontent.com/115047831/214738650-7e974964-fd29-4b4a-a7cd-756e45e7383a.png) | <ul><li>3 caníbales y 3 misioneros del lado derecho del río.</li></ul>
