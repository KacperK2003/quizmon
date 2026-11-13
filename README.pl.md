# QuizMon

> 🇵🇱 Wersja polska | 🇬🇧 [See the English version](README.md)

## Autor
- Kacper Kozłowski ([@KacperK2003](https://github.com/KacperK2003))

## Opis projektu

**QuizMon** to aplikacja stworzona jako zaliczenie przedmiotu *Event-Driven Programming* na Wojskowej Akademii Technicznej. Projekt umożliwia:

- rozwiązywanie quizów w stylu „Co to za Pokémon?”,
- przeglądanie pokedexu,
- dodawanie Pokémonów do listy ulubionych.

Projekt korzysta z publicznego API: [PokeAPI](https://pokeapi.co/)  
Ma on charakter wyłącznie edukacyjny i nie jest przeznaczony do komercyjnego wykorzystania.

## Funkcjonalności

- Quiz z rozpoznawaniem Pokémonów
- Pokedex z wyszukiwarką
- System ulubionych Pokémonów
- Lokalna baza danych SQLite do przechowywania danych

## Technologie

- **Język programowania:** Java
- **Framework:** JavaFX
- **Baza danych:** SQLite
- **Zarządzanie zależnościami:** Maven
- **JDK:** Oracle JDK 24
- **IDE:** JetBrains IntelliJ IDEA 2025

## Uruchomienie projektu

1. Upewnij się, że masz zainstalowane:
   - Java JDK 24
   - Maven
   - IntelliJ IDEA

2. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/KacperK2003/quizmon.git
   cd quizmon
   ```
3. Uruchom projekt za pomocą Mavena:
   ```bash
   mvn clean javafx:run
   ```

## Licencje

Kod źródłowy: Objęty licencją MIT License

Czcionki: używana czcionka Audiowide objęta jest licencją SIL Open Font License ([Zobacz plik OFL.txt](src/main/resources/pl/kk/quizmon/fonts/Audiowide/OFL.txt))

Zależności zewnętrzne:

| Biblioteka | Licencja |
|------------|----------|
| JavaFX (OpenJFX) | [GPL v2 + Classpath Exception](https://openjdk.org/legal/gplv2+ce.html) |
| JUnit | [EPL 2.0](https://www.eclipse.org/legal/epl-2.0/) / [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) |
| Gson / Guava / SQLite JDBC | [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) |

Informacje prawne

    Pokémon to zastrzeżony znak towarowy należący do Nintendo, Game Freak i The Pokémon Company.

    Ten projekt ma charakter wyłącznie edukacyjny i nie jest powiązany, sponsorowany ani zatwierdzony przez wyżej wymienione podmioty.
