# LDTS_T04_G07 - Crossy Road
***

## Game Description

Crossy Road is a game where you control a chicken trying to cross busy roads, rivers, and bushes.
Each successful step brings the chicken closer to the final goal, testing your timing and reflexes at every turn.
The variety of levels will have increased difficulty, with faster vehicles, wider lakes, and trickier paths that require
strategy and precision.

>This project was developed by **Dário Amaral** (up202405681) ,**David Ferreira** (up202406798) and **Gonçalo Pinto** (up202310411) for LDTS 2025-26.

## Implemented Features
***
- **States** - Although not fully implemented we already have the `GameState` that allows us to create our game for now.
- **Viewers** - All the elements in the game can already be drawn on the screen as characters for now; later, these will be rendered as sprites.
- **Models** - All the elements already have their models implemented. These will serve as a bridge between our future controllers and viewers.
- **Levels and Space creation** - The game space is automatically built based on the level the player is in. For now, we just have one level, but more will be added later.
- **Tests** - For the element viewers and models, we have already implemented tests that cover all the coded lines successfully. We also have tests for the `LanternaGUI` class, which we plan to upgrade soon.
- **Menu** - Although not full implemented yet we are already implementing the menu model and viewer.

## Planned Features
***
- **Player Movement** - Move the chicken up, down, left, and right across obstacles.
- **Obstacle Avoidance** - Avoid cars, trucks, bushes, and other hazards that can end the game.
- **Water Hazards** - Jump across lakes using safe spots or logs without falling in.
- **Different Levels** - Roads get busier, lakes get wider, and obstacles appear more frequently as the game progresses.
- **Goal Achievement** - Reach the final destination to complete a level.
- **Collisions Detection** - Detect collisions with cars, trucks and water hazards.
- **Scoring System** - Track progress based on distance traveled or obstacles avoided.
- **Interactive Menu** - A start menu with options to play, view instructions, or exit the game.

## Design

<p align="center" justify="center">
  <img src="/docs/images/fullUML.png"/>
</p>
<p align="center">
  <b><i>Fig 1. UML Classes</i></b>
</p>

### General Structure
#### Problem in Context:
The main concern was how to structure a game with multiple states
(menus (not implemented totally yet), gameplay, and pause (not implemented yet)).
The code needed to be organized, maintainable, and allow easy expansion for future features.

#### The Pattern:
We applied the Model-View-Controller (MVC) architectural pattern to separate game data,
logic, and presentation. Additionally, the State Pattern was used to manage different game states,
allowing the chicken and menus to behave differently depending on the current state.

#### Implementation:
Model classes store game data, like chicken position.
Controller classes (not implemented yet) handle game logic, movement, collision checks, and level progression.
View classes render the game visuals and menus on the screen.

<p align="center" justify="center">
  <img src="/docs/images/UML_Elem_View.jpeg"/>
</p>
<p align="center">
  <b><i>Fig 2. UML Classes View and Element</i></b>
</p>

#### Consequences:
Code is well-organized and follows the basics of the SOLID principles as none class ir responsible for more than one task like set position and drawing to the screen at the same time.
With this organization it's easy to spot errors and to find code for a spefic task (all the drawing code will be on the viewer directory and so on),
New features can be added with minimal impact on existing code.
*** 

### Input Handling

### Input Handling

#### Problem in Context
Our game receives input from the keyboard. A naive approach could involve continuous polling for key presses, which is inefficient because the program might repeatedly check for input even when the user is inactive. This would consume unnecessary resources and complicate the code structure.

#### The Pattern
Instead of using polling or a full Observer pattern, we adopted a **Command-inspired approach**. Each input from the keyboard is interpreted by the `LanternaGUI` and mapped to a corresponding **Action**. Controllers then handle these Actions and update the game state accordingly. This separation ensures that input processing is centralized while keeping game logic modular and maintainable.

#### Implementation
Implementation-wise, the `LanternaGUI` listens for keyboard events and translates them into Actions. These Actions are passed to the relevant controllers, which execute the appropriate game logic. This design avoids having the game constantly query input and keeps input handling separate from game logic, improving readability and maintainability.

#### Consequences
- **Separation of concerns:** GUI handles input, controllers handle actions, game state is updated independently.
- **Maintainability:** Adding new Actions or input mappings is straightforward.
- **Efficiency:** No unnecessary polling; the game only reacts when an input is received.
- **Scalability:** The system can be extended to handle more input types or alternative control schemes in the future.

***
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

<p align="center" justify="center">
  <img src="/docs/images/GUI_UML.jpeg"/>
</p>
<p align="center">
  <b><i>Fig 3. UML Class GUI</i></b>
</p>

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
- At the moment as we don't fully implement a menu we don't have also a menu state that should be the begging of our game. To solve that problem we made the initial state be the `GameState` which is already fully functional.
- Because of the missing controllers we don't have a way to change state which means that the game will not leave the `GameState` and that the while loop present in `Game.java` will never be broken so the game will run forever if we not end it in the terminal.
- With the missing element controllers our elements don't have movement so for now the game is static which is not good.
- Our test don't fully test all that we have already in the best way.

## Testing
***

### Test with Coverage 
<p align="center">
<img src="/docs/images/cover_1.jpeg">
<p align="center">
<b><i>Fig 4. Coverage Testing </i></b>
</p>

<p align="center" justify="center">
  <img src="/docs/images/Coverage_2.jpeg"/>
</p>
<p align="center">
  <b><i>Fig 5. Coverage Testing </i></b>
</p>


### Mutation testing
[Mutation test report](http://localhost:63342/GameProj/build/reports/pitest/index.html?_ijt=72blmlp9eiugqu0itqfvo9qvf&_ij_reload=RELOAD_ON_SAVE)

## Self-evaluation
***

The work was divided in a mutual way and we all contributed with our best. It helped us to enrich our
java and principle/pattern knowledge, as well as our team work.

- Dário Amaral: 33.3%
- David Ferreira: 33.3%
- Gonçalo Pinto: 33.3%

