- Klasa Player ma za dużo odpowiedzialności
- klasa z logiką symulacji zależy od klasy odpowiedzialnej za wyświetlanie (Simulation -> Display) - uczulałem na zajęciach, żeby tak nie robić. Wyświetlanie może być, ale np w klasie Application. Klasy symulacji nie powinny nic wiedzieć na temat wyświetlania
- Zbyt dużo zahardkodowanych wartości
- proszę się zastanowić jak uczynić ten kod bardziej uniwersalnym, niezależnym od wpisanych na stałę liczb
Z Eportalu:
- Konstuktor Player ma w sobie za dużo i klasa Player generalnie ma za dużo odpowiedzialności. Warto by stworzyć klasę, której odpowiedzialnością będzie rozmieszczenie graczy na planszy.
- Zamiast klonowania można użyć konstruktora
- Innym podejściem, które być może uprości trochę w kodzie, będzie wprowadzenie obiektu Map<Player, PlayerPawns> pawnsByPlayer np. w klasie logiki symulacji. Dzięki temu Player nie będzie przechowywał pionków, ale logika symulacji już będzie wiedziała (równie dobrze może to być w Board)

Z Teams:
- Interfejs akcji mógłby przyjmować na wejściu stan planszy i po jej wykonaniu, zwracać nowy stan
- zahardcodowane liczby i generalnie klasa BasePosition cała do przeprojektowania
- konstruktory powinny byc jak najmniejsze, za stworzenie skomplikowane instancji danej klasy moze odpowiadac inna klasa, np BoardCreator