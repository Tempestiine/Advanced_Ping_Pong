# Pong Game

A customized Java implementation of the classic arcade game Pong, featuring single-player AI and two-player modes with progressive difficulty levels.

## Features

- **Single-player mode** with AI opponent
- **Two-player local multiplayer**
- **Progressive difficulty** - ball speed and paddle size change each round
- **Dynamic feedback system** - real-time advice based on your performance
- **Custom data structures** - implements a custom queue for level management
- **Smooth controls** - mouse control for Player 1, keyboard for Player 2

## How to Run

1. Make sure you have Java installed on your system
2. Clone or download this repository.

OR

- You can just download the overall file "Advanced Ping Pong" to get a zip file. Pro tip, I'm assuming the contents of "Advanced Ping Pong" are together locally on your computer
5. Compile the Java files:
   ```bash
   javac software/*.java software/objects/*.java
   ```
6. Run the game:
   ```bash
   java software.Main
   ```

## How to Play

**Objective:** Use your paddle to bounce the ball back to your opponent. Score points when the ball passes their paddle. First to build a lead wins!

### Controls

**Single Player:**
- **Player 1:** Move mouse up/down to control your paddle
- **Computer:** Automatically controlled (with intentional imperfections for balance)

**Two Player:**
- **Player 1:** Move mouse up/down
- **Player 2:** Use up and down arrow keys

### Game Modes

At startup, choose your mode:
- Press **1** for Single Player
- Press **2** for Two Player

## Gameplay Features

- **Adaptive difficulty:** Ball speed increases every 5 paddle hits
- **Level progression:** Paddles get smaller and faster as you advance
- **Performance feedback:** On-screen tips based on current score

## Technical Implementation

This project demonstrates:
- Object-oriented design with inheritance (Paddle > PlayerPaddle/ComputerPaddle)
- Custom data structures (MyQueue class for level management)
- Event-driven programming (mouse and keyboard listeners)
- Game loop architecture with collision detection
- Exception handling and error management

## What I Learned

Building this project taught me about game development fundamentals, managing game state, creating smooth user interactions, and balancing AI difficulty to create an engaging experience.
