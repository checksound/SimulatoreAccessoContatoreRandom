# Simulatore Accesso Contatore Random

L'applicazione [SimulatoreAccessContatore1Lock](./src/SimulatorAccessContatore1Lock.java) simula due thread che fanno richieste concorrenti di accesso a una variabile condivisa
si tipo [Contatore](./src/Contatore.java) implementato con un lock solo dalla classe [Contatore1Lock](./src/Contatore1Lock.java): due thread non possono accedere 
contemporaneamente all'oggetto di tipo [Contatore](./src/Contatore.java) per invocare i metodi `decrement()` e `getValue()`.

L'applicazione [SimulatoreAccessContatore2Lock](./src/SimulatorAccessContatore2Lock.java) simula due thread che fanno richieste concorrenti di accesso a una variabile condivisa 
si tipo [Contatore](./src/Contatore.java) implementato con due lock dalla classe [Contatore2Lock](./src/Contatore2Lock.java): due thread possono accedere
contemporaneamente all'oggetto di tipo [Contatore](./src/Contatore.java) se invocano uno il metodo `decrement()` e l'altro `getValue()`.
