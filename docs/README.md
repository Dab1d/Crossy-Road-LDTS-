# LDTS_T04_G07 - Crossy Road
***

## Game Description

Crossy Road is a game where you control a chicken trying to cross busy roads, rivers, and bushes.
Each successful step brings the chicken closer to the final goal, testing your timing and reflexes at every turn.
The variety of levels will have increased difficulty, with faster vehicles, wider lakes, and trickier paths that require
strategy and precision.

>This project was developed by **Dário Amaral** (up202405681) ,**David Ferreira** (up202406798) and **Gonçalo Pinto** (up202310411) for LDTS 2025-26.

## Implemented Features

- **Character & Directional Movement**  
  Move the chicken in four directions (Up, Down, Left, and Right) with full control to navigate the game world.

- **Solid Boundaries**  
  Movement is constrained by the game window and static elements, preventing the player from leaving the playable area.

- **Dynamic Traffic**  
  Features two types of hazards: small, fast **Cars** for precise dodging, and longer, slower **Trucks** that act as persistent barriers.

- **Static Obstacles**  
  Fixed elements (**Bushes**) act as walls, creating strategic *bottlenecks* and limiting the player's path.

- **River Mechanics & Logs**  
  Rivers are lethal hazards unless the player jumps onto moving logs for safe passage.

- **Edge Lethality**  
  If the player remains on a log until it exits the map's boundaries, the game is lost.

- **Scoring System**  
  Collectible **Coins** are placed throughout the map, allowing players to increase their score as they progress.

- **Level Progression**  
  5 Levels with increasing difficulty, featuring faster vehicles and more frequent hazards as the player advances.

- **Collision Detection**  
  A precise system monitors overlaps with lethal elements (cars, trucks, or water), triggering a **Game Over** state.

- **State-Based Menus**  
  A complete UI system to navigate between **Main Menu**, **Help/Instructions**, **Pause**, **Victory**, and **Game Over** screens.

## Planned Features
***
All the planned features were successfully implemented.

## Design

<p align="center" justify="center">
  <img src="/docs/images/fullUML.png"/>
</p>
<p align="center">
  <b><i>Fig 1. UML Classes</i></b>
</p>

### General Structure
#### Problem in Context:
The main concern was how to structure a game with multiple states (menus, gameplay, and pause).
The code needed to be organized, maintainable, and allow easy expansion for future features.

#### The Pattern:
We applied the Model-View-Controller (MVC) architectural pattern to separate game data,
logic, and presentation. Additionally, the State Pattern was used to manage different game states,
allowing the chicken and menus to behave differently depending on the current state.
Also, Facade Pattern was used since it provides a simple interface to a complex subsystem.
Finally, we used the Command Pattern to decouple user input handling from game logic, 
making the system cleaner, more extensible, and easier to maintain.

#### Implementation:
Model classes store game data, like chicken position.
Controller classes handle game logic, movement, collision checks, and level progression.
View classes render the game visuals and menus on the screen.

<p align="center" justify="center">
  <img src="/docs/images/UML_Elem_View.jpeg"/>
</p>
<p align="center">
  <b><i>Fig 2. UML Classes View and Element</i></b>
</p>

#### Consequences:
Code is well-organized and follows the basics of the SOLID principles as none class ir responsible for more than one task like set position and drawing to the screen at the same time.
With this organization it's easy to spot errors and to find code for a specif task (all the drawing code will be on the viewer directory and so on),
New features can be added with minimal impact on existing code.
*** 

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

Overuse of Inheritance:

    Smell: Deep inheritance hierarchies for game elements (e.g., Element → Obstacle → Car → Truck). 
    Why it’s a smell: Inheritance can reduce flexibility.
    Consequence: Harder to change behavior dynamically.
    Possible improvement: Prefer composition where possible (e.g., movement or collision components).

Duplicate Collision Logic:

    Smell: Similar collision checks repeated for cars, trucks, water, and logs.
    Why it’s a smell: Repeating everything.
    Consequence: Bug fixes must be applied in multiple places.
    Possible improvement: Centralize collision logic using a common interface or utility class.

Primitive Obsession: 

    Smell: Positions, dimensions, and speeds are represented using raw primitives (int x, int y).
    Why it’s a smell: Related data lacks semantic meaning and behavior.
    Consequence: Higher chance of bugs and duplicated logic.
    Possible improvement: Introduce small value objects like Position, Velocity, Bounds.


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
<p align="center">
<img src="images/pitest.png">
</p>
## Self-evaluation
***

The work was divided in a mutual way, and we all contributed with our best. It helped us to enrich our
java and principle/pattern knowledge, as well as our team work.

- Dário Amaral: 33.3%
- David Ferreira: 33.3%
- Gonçalo Pinto: 33.3%

