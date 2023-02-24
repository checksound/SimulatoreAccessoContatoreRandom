# Simulatore Accesso Contatore Random

L'applicazione [SimulatoreAccessContatore1Lock](./src/SimulatorAccessContatore1Lock.java) simula due thread che fanno richieste concorrenti di accesso a una variabile condivisa
si tipo [Contatore](./src/Contatore.java) implementato con un lock solo dalla classe [Contatore1Lock](./src/Contatore1Lock.java): due thread non possono accedere 
contemporaneamente all'oggetto di tipo [Contatore](./src/Contatore.java) per invocare i metodi `decrement()` e `getValue()`.

Esempio di una esecuzione:

```

26:38:095 Thread_A Request{1} - TRY DECREMENT

26:38:100 Thread_B Request{1} - TRY GET_VALUE
26:38:117 Thread_A Request{1} -------------------> ENTRATO DECREMENT()
....................
26:40:250 Thread_A Request{1} <------------------- EXIT DECREMENT()

26:40:251 Thread_A Request{2} - TRY GET_VALUE
26:40:251 Thread_B Request{1} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
26:47:974 Thread_B Request{1} -------------------> EXIT GET_VALUE()
26:47:974 Thread_A Request{2} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++
26:50:196 Thread_A Request{2} -------------------> EXIT GET_VALUE()

26:51:985 Thread_B Request{2} - TRY GET_VALUE
26:51:987 Thread_B Request{2} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++
26:54:197 Thread_A Request{3} - TRY DECREMENT
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
27:00:708 Thread_B Request{2} -------------------> EXIT GET_VALUE()
27:00:708 Thread_A Request{3} -------------------> ENTRATO DECREMENT()
.........
27:01:710 Thread_B Request{3} - TRY DECREMENT
.......................................................................
27:09:546 Thread_A Request{3} <------------------- EXIT DECREMENT()

27:09:547 Thread_A Request{4} - TRY DECREMENT
27:09:547 Thread_B Request{3} -------------------> ENTRATO DECREMENT()

27:09:550 Thread_B Request{3} <------------------- EXIT DECREMENT()
27:09:552 Thread_A Request{4} -------------------> ENTRATO DECREMENT()
..........................
27:12:553 Thread_B Request{4} - TRY DECREMENT
..................................
27:16:186 Thread_A Request{4} <------------------- EXIT DECREMENT()
27:16:188 Thread_B Request{4} -------------------> ENTRATO DECREMENT()
....................................
27:20:193 Thread_A Request{5} - TRY DECREMENT
....
27:20:542 Thread_B Request{4} <------------------- EXIT DECREMENT()
27:20:544 Thread_A Request{5} -------------------> ENTRATO DECREMENT()
..................
27:22:552 Thread_B Request{5} - TRY GET_VALUE
............
27:23:850 Thread_A Request{5} <------------------- EXIT DECREMENT()
27:23:850 Thread_B Request{5} -------------------> ENTRATO GET_VALUE()

27:23:851 Thread_B Request{5} -------------------> EXIT GET_VALUE()

27:25:867 Thread_B Request{6} - TRY GET_VALUE
27:25:867 Thread_B Request{6} -------------------> ENTRATO GET_VALUE()
+++++++++
27:26:866 Thread_A Request{6} - TRY DECREMENT
+++++++++++++++++++++++++++++++++++++++

```

L'applicazione [SimulatoreAccessContatore2Lock](./src/SimulatorAccessContatore2Lock.java) simula due thread che fanno richieste concorrenti di accesso a una variabile condivisa 
si tipo [Contatore](./src/Contatore.java) implementato con due lock dalla classe [Contatore2Lock](./src/Contatore2Lock.java): due thread possono accedere
contemporaneamente all'oggetto di tipo [Contatore](./src/Contatore.java) se invocano uno il metodo `decrement()` e l'altro `getValue()`.

Esempio di una esecuzione:

```

32:16:369 Thread_A Request{1} - TRY GET_VALUE

32:16:369 Thread_B Request{1} - TRY GET_VALUE
32:16:386 Thread_A Request{1} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
32:23:016 Thread_A Request{1} -------------------> EXIT GET_VALUE()
32:23:019 Thread_B Request{1} -------------------> ENTRATO GET_VALUE()
+++++++++++++++++++++++++++++++++++++
32:27:032 Thread_A Request{2} - TRY DECREMENT
32:27:033 Thread_A Request{2} -------------------> ENTRATO DECREMENT()
+.+.+.+.+.+..+.+.++.+.+.+.+..++..++.+.+.
32:29:239 Thread_A Request{2} <------------------- EXIT DECREMENT()
+++
32:29:569 Thread_B Request{1} -------------------> EXIT GET_VALUE()

32:32:264 Thread_A Request{3} - TRY DECREMENT
32:32:265 Thread_A Request{3} -------------------> ENTRATO DECREMENT()

32:32:266 Thread_A Request{3} <------------------- EXIT DECREMENT()

32:32:266 Thread_A Request{4} - TRY DECREMENT
32:32:266 Thread_A Request{4} -------------------> ENTRATO DECREMENT()
............
32:33:580 Thread_B Request{2} - TRY DECREMENT
................................................
32:38:872 Thread_A Request{4} <------------------- EXIT DECREMENT()
32:38:873 Thread_B Request{2} -------------------> ENTRATO DECREMENT()
.........
32:39:879 Thread_A Request{5} - TRY GET_VALUE
32:39:881 Thread_A Request{5} -------------------> ENTRATO GET_VALUE()
.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.+.
32:42:167 Thread_B Request{2} <------------------- EXIT DECREMENT()
++++++++++++++++++++
32:44:311 Thread_A Request{5} -------------------> EXIT GET_VALUE()

32:45:174 Thread_B Request{3} - TRY DECREMENT
32:45:176 Thread_B Request{3} -------------------> ENTRATO DECREMENT()

32:45:177 Thread_B Request{3} <------------------- EXIT DECREMENT()

32:45:178 Thread_B Request{4} - TRY DECREMENT
32:45:180 Thread_B Request{4} -------------------> ENTRATO DECREMENT()
...................
32:47:325 Thread_A Request{6} - TRY GET_VALUE
32:47:326 Thread_A Request{6} -------------------> ENTRATO GET_VALUE()

32:47:327 Thread_A Request{6} -------------------> EXIT GET_VALUE()
...........
32:48:495 Thread_B Request{4} <------------------- EXIT DECREMENT()

32:49:511 Thread_B Request{5} - TRY GET_VALUE
32:49:511 Thread_B Request{5} -------------------> ENTRATO GET_VALUE()
+++++++
32:50:333 Thread_A Request{7} - TRY GET_VALUE
+++++++++++++
32:51:672 Thread_B Request{5} -------------------> EXIT GET_VALUE()
32:51:673 Thread_A Request{7} -------------------> ENTRATO GET_VALUE()
+++++++++++++++++++++++++++
32:54:694 Thread_B Request{6} - TRY GET_VALUE
+++++++++++++
32:56:050 Thread_A Request{7} -------------------> EXIT GET_VALUE()
32:56:050 Thread_B Request{6} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++++++++++++++++++
33:00:060 Thread_A Request{8} - TRY GET_VALUE
++++++++++++++++++++++++
33:02:582 Thread_B Request{6} -------------------> EXIT GET_VALUE()
33:02:583 Thread_A Request{8} -------------------> ENTRATO GET_VALUE()
++++++++++++++++++++++++++
33:05:590 Thread_B Request{7} - TRY GET_VALUE
++++++++++++++++++++++++++++++++++++++++++++
33:10:287 Thread_A Request{8} -------------------> EXIT GET_VALUE()
33:10:288 Thread_B Request{7} -------------------> ENTRATO GET_VALUE()
+++++++++++++++++++++++++++
33:13:289 Thread_A Request{9} - TRY DECREMENT
33:13:291 Thread_A Request{9} -------------------> ENTRATO DECREMENT()
+.+.+.+.+.+.+.+.+.+.+.+.+.+..+.+.++..+.+
33:15:452 Thread_A Request{9} <------------------- EXIT DECREMENT()
+++++++++++++++++++++++
33:17:991 Thread_B Request{7} -------------------> EXIT GET_VALUE()

33:18:480 Thread_A Request{10} - TRY GET_VALUE
33:18:481 Thread_A Request{10} -------------------> ENTRATO GET_VALUE()
++++++++++
33:19:584 Thread_A Request{10} -------------------> EXIT GET_VALUE()

33:20:596 Thread_A Request{11} - TRY DECREMENT
33:20:596 Thread_A Request{11} -------------------> ENTRATO DECREMENT()
............
33:22:005 Thread_B Request{8} - TRY GET_VALUE
33:22:005 Thread_B Request{8} -------------------> ENTRATO GET_VALUE()
.+.+.+.+..++..+.+.+.+.++..++.+..++.+.+.+..++.

```

Per rendere la simulazione più evidente il thread 
[ThreadAccessContatore](./src/ThreadAccessContatore.java) che fa l'accesso a contatore
sceglie in modo random quale dei due metodi invocare e l'esecuzione dei metodi `decrement()` e
`getValue()` viene simulata una lunghezza arbitraria.


