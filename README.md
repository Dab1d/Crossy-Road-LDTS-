# Crossy Road (LDTS Project)


## Game Description

Crossy Road is a game where you control a chicken trying to cross busy roads and dangerous rivers.  
Timing, precision, and quick reactions are key to surviving traffic, avoiding water hazards, and reaching the goal.

This project was developed by Dário Amaral (up202405681@edu.fe.up.pt), David Ferreira (up202406798@edu.fe.up.pt) and Gonçalo Pinto (up202310411@edu.fe.up.pt) for LDTS 2025-26.

For a more detailed version of this description click [here](./docs/README.md).


## Gameplay Highlights


- Simple and intuitive keyboard controls  
- Increasing difficulty with more obstacles  
- Clear win/lose conditions

## 🚀 How to Run

### 🐳 Running with Docker

To run the game safely inside a container without installing Java dependencies locally, follow these steps:

**1. Enable Display Access (Linux)**
Since the game requires a Graphical User Interface (GUI), you need to allow the Docker container to access your local screen:
```bash
xhost +
```
2. Build the Docker Image Create the game image from the source code:ash
```
docker build -t game .
```

3. Start the Game Run the container using Docker Compose:
```
docker compose up
```

4. Cleanup (After Playing) For security reasons, once you finish playing, disable the external access to your display:
```
xhost -
```

## Screenshots
<div align="center">
    <img src="src/main/resources/images/Menu.png" alt="Main Menu" width="500">
    <p>
        <i>Figure 1 - Main Menu</i>
    </p>
    <img src="src/main/resources/images/HelpMenu.png" alt="How To Play" width="500">
    <p>
        <i>Figure 2 - How To Play</i>
    </p>
    <img src="src/main/resources/images/PauseMenu.png" alt="Pause Menu" width="500">
    <p>
        <i>Figure 3 - Pause Menu</i>
    </p>
    <img src="src/main/resources/images/GameOverMenuScreenShot.png" alt="Game Over" width="500">
    <p>
        <i>Figure 4 - Game Over</i>
    </p>
    <img src="src/main/resources/images/WinMenu.png" alt="Win Menu" width="500">
    <p>
        <i>Figure 5 - Win Menu</i>
    </p>
</div>
    
## Gameplay

<div align="center">
  <img src="docs/gifs/WinGif.gif" alt="Gameplay demonstration" width="500">
  <p><i>Gif 1. Gameplay</i></p>
</div>
<div align="center">
  <img src="docs/gifs/LoseGif.gif" alt="Gameplay demonstration" width="500">
  <p><i>Gif 2. Gameplay</i></p>
</div>



