# Memory Card Game

This repository contains a Java program for a simple memory card game. The game allows two players to take turns flipping over cards and trying to find matching pairs.

## Files

### `Card.java`

This file defines the `Card` class, which represents a card in the memory game. It has properties for the card's figure and whether it is opened or closed.

### `Player.java`

The `Player` class is defined in this file. It includes properties for the player's points and name, along with methods to manipulate these values.

### `Game.java`

The `Game` class is the main class that implements the memory card game logic. It allows two players to take turns choosing cards and tracks their points. The game continues until all cards are matched.

## How to Run

1. Ensure you have Java installed on your system.
2. Compile the code files using the following command:

   ```shell
   javac cardgame/*.java
   ```

3. Run the game using the following command:

   ```shell
   java cardgame.Game
   ```

Follow the on-screen instructions to play the game. Players take turns choosing cards by entering the card's position.

## Contributing

Feel free to contribute to this repository by adding new features, improving the code, or fixing any issues. You can submit pull requests to the `main` branch.

## License

This project is licensed under the [MIT License](LICENSE).

---
