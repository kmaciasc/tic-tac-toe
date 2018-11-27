## Tic Tac Toe game

This is multiplayer game. It's for three players, one is AI.

### To build this application:
Run in your command prompt:
```
gradle build
```
*Make sure you have gradle installed*

### Ready to play?
Run in your command prompt:
```
gradle run
```

### This game is configurable:
In *applications.properties* file change the props following the examples given. **Player character/name** and **board size** are configurable.


### _application.properties_ content file

```
#Board Size. Only one number (It'll be a square)
game.board.size=3

#Player names (Just one character)
game.player.human.first=A
game.player.human.second=B
game.player.computer=C
```

### Design solution

## Main instance
_TicTacToeGame_ is the main entrance of the application and who starts it.
## Controller
Have functionalities non-related to the object itself acting as mediators.
## View
There´s only one class which displays the current board or an specific message. 
It also receives information, but it doesn't process data, it just print information to the user
## Model
All classes represent the needed objects to run the game holding the needed data. Each class has its own responsibility
