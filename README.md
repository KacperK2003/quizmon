# QuizMon

>  🇬🇧 English version | 🇵🇱 [Zobacz polska wersję](README.pl.md)

## Author
- Kacper Kozłowski ([@KacperK2003](https://github.com/KacperK2003))

## Project Description

**QuizMon** is an application developed as a final project for the *Event-Driven Programming* course at the Military University of Technology (WAT) in Poland. The project allows users to:

- solve “Who's that Pokémon?” style quizzes,
- browse a Pokédex,
- add Pokémon to a favorites list.

It uses the public [PokeAPI](https://pokeapi.co/)  
This project is strictly educational and not intended for commercial use.

## Features

- Pokémon recognition quiz
- Pokédex with search functionality
- Favorite Pokémon list system
- Local SQLite database for storing data

## Technologies

- **Programming Language:** Java  
- **Framework:** JavaFX  
- **Database:** SQLite  
- **Dependency Management:** Maven  
- **JDK:** Oracle JDK 24  
- **IDE:** JetBrains IntelliJ IDEA 2025  

## Running the Project

1. Make sure you have installed:
   - Java JDK 24  
   - Maven  
   - IntelliJ IDEA  

2. Clone the repository:
   ```bash
   git clone https://github.com/KacperK2003/quizmon.git
   cd quizmon
   ```

3. Run the project using Maven:
   ```bash
   mvn clean javafx:run
   ```

## Licenses

Source code: Licensed under the MIT License

Fonts: Uses Audiowide font licensed under the SIL Open Font License ([See the OFL.txt file](src/main/resources/pl/kk/quizmon/fonts/Audiowide/OFL.txt))

External dependencies:

| Library | License |
|------------|----------|
| JavaFX (OpenJFX) | [GPL v2 + Classpath Exception](https://openjdk.org/legal/gplv2+ce.html) |
| JUnit | [EPL 2.0](https://www.eclipse.org/legal/epl-2.0/) / [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) |
| Gson / Guava / SQLite JDBC | [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) |

Legal Notice

    Pokémon is a registered trademark of Nintendo, Game Freak, and The Pokémon Company.

    This project is for educational purposes only and is not affiliated with, sponsored by, or endorsed by the aforementioned entities.
