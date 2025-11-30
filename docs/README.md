# LDTS_T04_G07 - Crossy Road

##Game Description

Crossy Road is a game where you control a chicken trying to cross busy roads, rivers, and bushes.
Each successful step brings the chicken closer to the final goal, testing your timing and reflexes at every turn.
The variety of levels will have increased difficulty, with faster vehicles, wider lakes, and trickier paths that require
strategy and precision.

This project was developed by Dário Amaral , David Ferreira and Gonçalo Pinto for LDTS 2025-26.

## Implemented Features

- Player Movement - Move the chicken up, down, left, and right across obstacles.
- Obstacle Avoidance - Avoid cars, trucks, bushes, and other hazards that can end the game.
- Water Hazards - Jump across lakes using safe spots or logs without falling in.
- Different Levels - Roads get busier, lakes get wider, and obstacles appear more frequently as the game progresses.
- Goal Achievement - Reach the final destination to complete a level.
- Collisions Detection - Detect collisions with cars, trucks and water hazards.
- Scoring System - Track progress based on distance traveled or obstacles avoided.
- Interactive Menu - A start menu with options to play, view instructions, or exit the game.


## Planned Features

-> TO DO

##Design

###General Structure
####Problem in Context:
The main concern was how to structure a game with multiple states
(menus (not implemented yet), gameplay, and pause (not implemented yet)).
The code needed to be organized, maintainable, and allow easy expansion for future features.

####The Pattern:
We applied the Model-View-Controller (MVC) architectural pattern to separate game data,
logic, and presentation. Additionally, the State Pattern was used to manage different game states,
allowing the chicken and menus to behave differently depending on the current state.

#### Implementation:
Model classes store game data, like chicken position and score (not implemented yet).
Controller classes (not implemented yet) handle game logic, movement, collision checks, and level progression.
View classes render the game visuals and menus on the screen.
->Colocar imagem do UML

####Consequences:
Code is well-organized and follows the ->QUAIS DOS PRINCIPIOS SOLID.
New features can be added with minimal impact on existing code.

### Observers and listeners
#### Problem in Context:                ->VERIFICAR
Our game is controlled by the keyboard, many are the ways to receive input from these device,
for example: a thread that is running and every time it catches a signal it sends to the game itself (polling),
the game being responsible for asking for input when needed, which is costly for our program since we may not send
any signal to the program and unnecessary calls are made or the way we decided to implement which consists of using
observers also known as listeners that are responsible for receiving the said input and redistributing it in a nicer
and more usefull way to us. This takes some "weight" of the program as it will no longer need to be polling for
input, as it will be properly warned when received.

#### The Pattern:
We have applied the **_Observer pattern_** which is a behavioral design pattern that lets you define a subscription
mechanism to notify multiple objects about any events that happen to the object they’re observing.
With this in mind the pattern allowed to solve the identified problems and apply a sustainable mechanism
to receive any program input.

#### Implementation:
Implementation wise we store the observers in the main class (game class) and change its state according to
the respective input processed by the available listener.
Though, it wasn't easy right from the start as our first attemp to implement this feature didn't act as expected.
All listeners were always active, since when creating a Menu Button the listener would be activated by the newly
created state, and it was far from being a structured and easy-to-read code.
                  ->IMAGEM UML

#### Consequences:
Some consequences of using the stated pattern:
- Promotes the single responsibility principle.
- Clean code.

### GUI
#### Problem in Context:
Aiming for a structured and unstable (easy to change) code, we tried to make it as general as possible.
The lanterna library contains various functions that aren't useful to our program, Interface Segregation
Principle violation, and lacks some other functions that our interface needs. Also, if using the raw library,
our game (high level module) would be directly depending on a low level module. This is a violation of the
Dependency Inversion Principle (DIP). A need to implement an interface that solves these problems was born.

#### The Pattern:
We have applied the **_Facade_** pattern. A facade provides a simple interface to a complex subsystem which
contains lots of moving parts, allowing us to only include the features that really matter.

#### Implementation:
           ->IMAGEM UML

These classes can be found in the following files:
- [Game](../src/main/java/com/g57/Game.java)
- [GUI](../src/main/java/com/g57/gui/GUI.java)
- [LanternaGUI](../src/main/java/com/g57/gui/LanternaGUI.java)

#### Consequences:
The use of the Facade Pattern in the current design allows the following benefits:
- Isolate code from the complexity of a subsystem.
- Promotes testability and replaceability.
- Expand lanterna functionalities as well as respecting the Interface Segregation Principle.


## Known-code smells
     ->REFERIR


## Testing

### Screenshot of coverage report
 -> Adicionar o screenshot da coverage


## Self-evaluation

The work was divided in a mutual way and we all contributed with our best. It helped us to enrich our
java and principle/pattern knwoledge, as well as our team work.

- Dário Amaral: 33.3%
- David Ferreira: 33.3%
- Gonçalo Pinto: 33.3%

