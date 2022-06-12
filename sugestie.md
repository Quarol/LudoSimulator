- Klasa Player ma za dużo odpowiedzialnośći
- To, że implementacje interfejsu Action ustawiają swój stan (this.... = ...) w metodach z interfejsu to złe podejście. Metody z interfejsu raczej nie powinny zmieniać stanu klas go implementujących. Może warto rozważyć takiej podejście:

```
public interface Action {
boolean isPossible(BoardState boardState, Player player);
BoardState execute(BoardState boardState, Player player); // akcja przyjmuje obecny stan planszy i zwraca nowy - po zmiane
}
```

- klasa z logiką symulacji zależy od klasy odpowiedzialnej za wyświetlanie (Simulation -> Display) - uczulałem na zajęciach, żeby tak nie robić. Wyświetlanie może być, ale np w klasie Application. Klasy symulacji nie powinny nic wiedzieć na temat wyświetlania
- Zbyt dużo zahardkodowanych wartości
``
- proszę się zastanowić jak uczynić ten kod bardziej uniwersalnym, niezależnym od wpisanych na stałę liczb

Z Eportalu:
- Konstuktor Player ma w sobie za dużo i klasa Player generalnie ma za dużo odpowiedzialności. Warto by stworzyć klasę, której odpowiedzialnością będzie rozmieszczenie graczy na planszy.
- Zamiast klonowania można użyć konstruktora
- Poszczególne implementacje interfejsu Pawn niewiele się różnią, w związku z czym są trochę bez sensu
- Innym podejściem, które być może uprości trochę w kodzie, będzie wprowadzenie obiektu Map<Player, PlayerPawns> pawnsByPlayer np. w klasie logiki symulacji. Dzięki temu Player nie będzie przechowywał pionków, ale logika symulacji już będzie wiedziała (równie dobrze może to być w Board)

- metoda start jest wielka - warto ją rozbić na kilka metod, np findPossibleActions(...), która zwracałaby listę akcji, killPawn() etc

Z Teams:
- spodziewałbym się, że wprowadzą Panowie interfejs Action, aby symulacja nie wiedziała nic o możliwych akcjach (a więc spełniała O w SOLID) i można byłoby je dowolnie dodawać. Interfejs akcji mógłby przyjmować na wejściu stan planszy i po jej wykonaniu, zwracać nowy stan

- zahardcodowane liczby i generalnie klasa BasePosition cała do przeprojektowania

- konstuktory powinny byc jak najmniejsze, za stworzenie skomplikowane instancji danej klasy moze odpowiadac inna klasa, np BoardCreator