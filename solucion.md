### Escuela Colombiana de Ingeniería - Arquitecturas de Software - ARSW
## Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch
#### Sebastian Julian Villarraga Guerrero

### **Parte I**

2.4. ¿Cómo cambia la salida con '.start()' y '.run()'? 

- Al ejecutar el método start() los números aparecen de forma aleatoria esto debido a que los hilos estan funcionando como "condición de carrera" o lo que es competir por el procesador. Por otro lado, con el método run() los números salen en orden y esto es porque los hilos se ejecutan de forma secuencial, se ejecuta un proceso a la vez.

### **Parte II.I**

¿Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos? ¿qué elemento nuevo traería esto al problema?

- En subprocesos múltiples, la entidad compartida, en este caso el contador, conduce principalmente a un problema cuando se incorpora la concurrencia pues es data no actualizada. Para ello una posible solución es una variable atómica.

### **Parte III**

1. Un solo hilo.
<img width="953" height="531" alt="image" src="https://github.com/user-attachments/assets/20196a49-10c4-42cc-bf36-21b0cc6bfc65" />
2. Tantos hilos como núcleos de procesamiento: el número de núcleos es 8 en este caso.
<img width="954" height="530" alt="image" src="https://github.com/user-attachments/assets/eb2111d9-23e2-477d-bf73-adf23b70c312" />
3. Tantos hilos como el doble de núcleos de procesamiento: 16 núcleos.
<img width="954" height="525" alt="image" src="https://github.com/user-attachments/assets/f07abc38-cd45-4e6a-b1d4-8c57f6d9887c" />
4. 50 hilos.
<img width="954" height="537" alt="image" src="https://github.com/user-attachments/assets/0c134639-8fcc-41fc-ae19-4751c8561ce1" />
5. 100 hilos.
<img width="953" height="536" alt="image" src="https://github.com/user-attachments/assets/24134cb4-4503-45ba-bcf0-6ce2dcac2bb7" />

    Con lo anterior, y con los tiempos de ejecución dados, se hace una gráfica de tiempo de solución vs. número de hilos.

<img width="572" height="455" alt="image" src="https://github.com/user-attachments/assets/06d3775c-ab37-45ff-b774-b0726f8aeaef" />

    - Con 1 hilo el tiempo es muy alto → ejecución secuencial.
    - Al aumentar a 8 y 16 hilos, el tiempo cae drásticamente → se aprovechan los núcleos del procesador.
    - A partir de 50–100 hilos, la mejora es marginal → aparece el overhead de creación y gestión de hilos.
    - Se observa claramente una zona óptima alrededor del número de núcleos (8–16).
    
### **Parte IV - Ejercicio Black List Search**

1. Según la [ley de Amdahls](https://www.pugetsystems.com/labs/articles/Estimating-CPU-Performance-using-Amdahls-Law-619/#WhatisAmdahlsLaw?):

	![ley de Amdahls](img/ahmdahls.png), 
  
    Donde _S(n)_ es el mejoramiento teórico del desempeño, _P_ la fracción paralelizable del algoritmo, y _n_ el número de hilos, a mayor _n_, mayor debería ser dicha mejora. 
    
    ¿Por qué el mejor desempeño no se logra con los 500 hilos? ¿Cómo se compara este desempeño cuando se usan 200?

    Suponiendo que la fracción paralelizable es del 60%, se tiene que _S(200) = 2.4813_ y  _S(500) = 2.4925 _ y cada vez que _n_ es más grande, la mejora del desempeño teorica tiende a _2.5_. Con lo anterior, se puede concluir que entre más hilos, menor es el rendimiento teórico.

2. ¿Cómo se comporta la solución usando tantos hilos de procesamiento como núcleos comparado con el resultado de usar el doble de éste?.

    Al usar tantos hilos como el doble de núcleos es mejor que usar la misma cantidad de hilos como núcleos, pues se reduce a la mitad el tiempo de ejecución cuando los hilos son el doble de núcleos.

3. De acuerdo con lo anterior, si para este problema en lugar de 100 hilos en una sola CPU se pudiera usar 1 hilo en cada una de 100 máquinas hipotéticas, la ley de Amdahls se aplicaría mejor?. Si en lugar de esto se usaran c hilos en 100/c máquinas distribuidas (siendo c es el número de núcleos de dichas máquinas), se mejoraría?. Explique su respuesta.
    - **100 Máquinas 1 hilo en cada una**: Puede que haya una mejoría, pues se está aprovechando al máximo los recursos en cada una de las máquinas hipóteticas.
    - **c hilos en 100/c máquinas**: Cada hilo tiene los recursos suficientes para aprovechar al máximo el rendimiento en las 100 máquinas. Se mejoraría el rendimiento ya que muchas partes se pueden hacer al mismo tiempo.
