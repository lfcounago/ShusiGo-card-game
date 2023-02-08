# ShusiGo-card-game
Project of the ShusiGo card game

EL JUEGO: SHUSI GO!

-----Historia y Contexto-----

Sushi Go! es un juego de cartas creado por Phil Walker-Harding en el año 2013. En este juego, el jugador asume el rol de un comensal en un restaurante de sushi que intenta coger las mejores combinaciones de platos según pasan por delante, de modo que el jugador que coja los mejores platos será el ganador. Cada plato puntuará de forma distinta, e incluso algunos pueden ser combinados para dar más puntos.

En Sushi Go! cada carta representa a un plato distinto y en cada turno cada jugador escogerá una carta para quedarse con ella, representando que ha cogido un plato. Además, este juego se basa en la mecánica card-drafting que consiste en que, al final de cada turno, los jugadores le darán su mano de cartas a otro jugador (esto es, las cartas rotan de mano).


-----Bases del Juego-----

---Inicio del Juego---

Iniciar el juego es tan sencillo como barajar todas las cartas.


---Desarrollo del Juego---

El juego se divide en tres rondas, que se desarrollan de la misma manera.

Cada ronda comienza repartiendo cartas a los jugadores desde la baraja. Cada jugador solo podrá ver las cartas de su mano y no deberá mostrárselas a los oponentes. Dependiendo del número de jugadores, el número de cartas a repartir será el siguiente:

  • 2 jugadores: 10 cartas a cada jugador.
  • 3 jugadores: 9 cartas a cada jugador.
  • 4 jugadores: 8 cartas a cada jugador.
  • 5 jugadores: 7 cartas a cada jugador.

Una vez se han repartido las cartas, cada ronda se jugará en turnos simultáneos donde cada jugador seleccionará una carta con la que se quiere quedar de su mano actual.

Cuando todos los jugadores hayan seleccionado una carta la pondrán de forma simultánea sobre la mesa, de modo que todos los jugadores verán sus cartas y las seleccionadas por el resto de oponentes. Las cartas mostradas así permanecerán visibles toda la ronda.

Tras revelar las cartas seleccionadas, los jugadores pasarán las cartas de su mano al jugador que tengan a la izquierda y comenzará un nuevo turno.

Esto se repetirá hasta que no queden más cartas en las manos de los jugadores, momento en el cual se puntuará la ronda según indican las cartas. Una vez puntuada la ronda, se descartarán todas las cartas de la mesa (no participarán en las siguientes rondas), exceptuando las de Pudding, cuyo funcionamiento se explica más adelante.


---Cartas---

Las cartas que forman parte del juego son las siguientes:

  • Nigiri de calamar: Vale 3 puntos.
  • Nigiri de salmón: Vale 2 puntos.
  • Nigiri de tortilla: Vale 1 punto.
  • Wasabi: Si hay una carta de Wasabi sobre la mesa cuando se coge un Nigiri, la carta de Nigiri puede colocarse sobre el Wasabi triplicando su valor (p.ej. si se         coloca un Nigiri de Salmón sobre un Wasabi, valdrá 6 puntos en lugar de 2). Tan solo se puede colocar un Nigiri sobre un Wasabi y un Wasabi por sí solo no vale         ningún punto.
  • Maki: En cada carta de Maki puede aparecer 1, 2 o 3 rollitos. El jugador con más rollitos al final de la ronda ganará 6 puntos. Es necesario tener al menos un         rollito para puntuar. Si dos o más jugadores empatan en el mayor número de rollitos, los 6 puntos se dividen entre ellos, redondeando hacia abajo.
  • Tempura: Cada pareja de Tempuras vale 5 puntos. Una Tempura sola no vale ningún punto.
  • Sashimi: Cada trío de Sashimis vale 10 puntos. Uno o dos Sashimis solos no valen ningún punto.
  • Gyoza: Cuantas más Gyoza más puntos valdrán. El valor de las Gyoza, dependiendo del número de cartas de Gyoza que hayamos cogido, será el siguiente: Gyoza 1 2 3 4     5 o más Puntos 1 3 6 10 15
  • Palillos: Los Palillos no valen ningún punto, pero permiten coger más de una carta por turno. Un jugador que tenga una carta de palillos en mesa, tras haber cogido     la carta correspondiente del turno, podrá devolver una carta de palillos de la mesa a su mano para coger una segunda carta.
  • Pudding: Los Pudding se puntúan únicamente al final del juego (tras la tercera ronda) y permanecen en la mesa de los jugadores entre rondas. El jugador con más         cartas de Pudding ganará 6 puntos, mientras que el jugador con menos cartas de Pudding perderá 6 puntos. Si varios jugadores empatan en la primera o última             posición, dividirán los puntos ganados o perdidos, redondeando hacia abajo. Si todos los jugadores tienen el mismo número de Pudding, nadie ganará puntos por           ellos. En las partidas de 2 jugadores, ningún jugador pierde puntos por los Pudding.

La baraja se compone de un total de 108 cartas, distribuidas de la siguiente manera:

  • Nigiri de calamar: 5
  • Nigiri de salmón: 10
  • Nigiri de tortilla: 5
  • Wasabi: 6
  • Maki de 1 rollo: 6
  • Maki de 2 rollos: 12
  • Maki de 3 rollos: 8
  • Tempura: 14
  • Sashimi: 14
  • Gyoza: 14
  • Palillos: 4
  • Pudding: 10
  
  
---Final de la Partida---

La partida finaliza tras la tercera ronda. En este momento, se calculará la puntuación de cada jugador sumando los puntos de cada ronda y los puntos ganados o perdidos por los Puddings.

El jugador con más puntos será el ganador. Si hay empate, el jugador con más Puddings será el ganador. Si el empate persiste, todos los jugadores que han empatado serán los ganadores.
