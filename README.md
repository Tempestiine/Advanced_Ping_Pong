# Pong Game

A customized Java implementation of the classic arcade game Pong, featuring single-player AI and two-player modes with progressive difficulty levels.

## Features

- **Single-player mode** with AI opponent
- **Two-player local multiplayer**
- **Progressive difficulty** - ball speed and paddle size change each round
- **Dynamic feedback system** - real-time advice based on your performance
- **Custom data structures** - implements a custom queue for level management
- **Smooth controls** - mouse control for Player 1, keyboard for Player 2

## How to Run for Dummies

1. Make sure you have Java installed on your system. If not, please look up a tutorial on how to install Java 17 or 21. The next steps will guide you towards downloading the file properly onto your machine. Notably, I'm using Windows.

2. On the page (https://github.com/Tempestiine/Advanced_Ping_Pong), look for a green button with the text, "<> Code". Click it and click "Download ZIP" anywhere.
3. Go into the ZIP file. Drag the folder "Advanced_Ping_Pong-main" and drop it onto your desktop to copy the contents onto your desktop. Right click the folder and click "Open in Terminal". I'm assuming that you're using Windows PowerShell. The next steps will guide you towards compiling and running the files.

4. Now, you're in Terminal (Windows PowerShell), in the right directory. Compile the Java files by typing the text below.

   ```bash
   javac *.java
   ```

What you will see on your computer should be similar to what I have:

   ```bash
   PS C:\Users\Khaid\OneDrive\Desktop\Advanced_Ping_Pong-main> javac *.java
   Note: MyQueue.java uses unchecked or unsafe operations.
   Note: Recompile with -Xlint:unchecked for details.
   PS C:\Users\Khaid\OneDrive\Desktop\Advanced_Ping_Pong-main>
   ```

6. Run the game with the `java` command:

   ```bash
   java software.Main
   ```

7. When you're done, hit the `X` button at the top to close it. Feel free to delete the game afterward.

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
