# Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch
- Integrantes :  Sebastian-villarraga / Allan-Contreras
# Primera parte - Introducción a Hilos en Java
-  ¿Cómo cambia la salida con '.start()' y '.run()'?
  ``` txt
Cuando se usa .start(), los números se muestran en un orden aleatorio,
ya que los hilos se ejecutan en paralelo y compiten por el uso del procesador, generando una condición de carrera.
En cambio, al utilizar .run(), los números se imprimen de manera ordenada
 porque los hilos no se ejecutan realmente en paralelo,
 sino de forma secuencial, uno después del otro.
```

# segunda parte - 1 Para discutir la próxima clase
- La estrategia de paralelismo antes implementada es ineficiente en ciertos casos,
  pues la búsqueda se sigue realizando aún cuando los N hilos (en su conjunto)
  ya hayan encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso.
   Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos?, qué elemento nuevo traería esto al problema?
``` txt
Para reducir el número de consultas en este tipo de casos,
la implementación puede modificarse utilizando mecanismos que aseguren
el acceso correcto a la variable compartida, como el uso de variables atómicas.
Esto introduce un nuevo elemento en el problema: la sincronización, necesaria
para garantizar que los hilos accedan a datos actualizados y evitar inconsistencias producidas por la concurrencia.
```

# tercera parte  - Evaluación de Desempeño
-
# cuarta parte - Ejercicio Black List Search
-Según la ley de Amdahls:

- <img width="190" height="66" alt="image" src="https://github.com/user-attachments/assets/1fa9f9b4-3172-4e4c-97d2-4caf19cafb96" />
- Donde S(n) es el mejoramiento teórico del desempeño, P la fracción paralelizable del algoritmo, y n el número de hilos, a mayor n,
   mayor debería ser dicha mejora.
- ¿Por qué el mejor desempeño no se logra con los 500 hilos? ¿Cómo se compara este desempeño cuando se usan 200?
``` txt
El mejor desempeño no se alcanza con 500 hilos porque, según la Ley de Amdahl,
existe un límite en la aceleración teórica cuando solo una parte del programa es paralelizable.
Si la fracción paralelizable es del 60%, los resultados muestran que con 200 hilos se
obtiene una aceleración de S(200) = 2.4813, mientras que con 500 hilos es apenas mayor (S(500) = 2.4925).
Esto significa que, a medida que se incrementa el número de hilos,
la ganancia en rendimiento se va reduciendo y tiende a estabilizarse alrededor de 2.5,
por lo que usar más hilos no implica necesariamente un mejor desempeño.
```
- ¿Cómo se comporta la solución usando tantos hilos de procesamiento como núcleos comparado con el resultado de usar el doble de éste?.
``` txt
Cuando se utilizan tantos hilos como núcleos, el desempeño es bueno porque cada núcleo puede
 ejecutar un hilo de forma directa.
Sin embargo, al usar el doble de hilos que núcleos, 
el tiempo de ejecución se reduce aproximadamente a la mitad,
ya que se logra un mayor aprovechamiento de los recursos del procesador mediante la conmutación entre hilos.
```
- De acuerdo con lo anterior, si para este problema en lugar de 100 hilos en una sola CPU se pudiera usar 1 hilo en cada una de 100 máquinas hipotéticas,
   la ley de Amdahls se aplicaría mejor?.
  Si en lugar de esto se usaran c hilos en 100/c máquinas distribuidas (siendo c es el número de núcleos de dichas máquinas),
   se mejoraría?. Explique su respuesta.
``` txt
- 100 máquinas con 1 hilo en cada una: Podría haber una mejora en el rendimiento,
 ya que cada máquina hipotética estaría dedicando todos sus recursos a un único hilo,
 evitando la competencia interna por el procesador.

- c hilos en 100/c máquinas: En este caso, cada máquina dispone de los recursos suficientes
 para ejecutar varios hilos de forma eficiente.
El rendimiento se vería beneficiado porque se aprovecharía la capacidad de cómputo distribuida,
 permitiendo que más tareas se ejecuten en paralelo al mismo tiempo.

```
  



