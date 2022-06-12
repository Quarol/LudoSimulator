Z Eportalu:
- Konstuktor Player ma w sobie za dużo i klasa Player generalnie ma za dużo odpowiedzialności. Warto by stworzyć klasę, której odpowiedzialnością będzie rozmieszczenie graczy na planszy.
- Innym podejściem, które być może uprości trochę w kodzie, będzie wprowadzenie obiektu Map<Player, PlayerPawns> pawnsByPlayer np. w klasie logiki symulacji. Dzięki temu Player nie będzie przechowywał pionków, ale logika symulacji już będzie wiedziała (równie dobrze może to być w Board)

Z Teams:
- Interfejs akcji mógłby przyjmować na wejściu stan planszy i po jej wykonaniu, zwracać nowy stan
- konstruktory powinny byc jak najmniejsze, za stworzenie skomplikowane instancji danej klasy moze odpowiadac inna klasa, np BoardCreator