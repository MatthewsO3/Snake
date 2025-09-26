# 🐍 Snake Game

A classic Snake game implementation in Java with modern features including a main menu, leaderboard system, and comprehensive testing suite.

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Architecture](#architecture)
- [Testing](#testing)
- [Controls](#controls)

## 🎯 About

This Snake game is a modern take on the classic arcade game, built entirely in Java using Swing for the graphical interface. The project demonstrates object-oriented programming principles, clean code architecture, and comprehensive testing practices. Players control a snake to eat fruits, grow longer, and achieve high scores while avoiding collisions with walls and the snake's own body.

### Key Highlights
- **Object-Oriented Design**: Well-structured codebase with clear separation of concerns
- **User Experience**: Intuitive main menu and leaderboard system  
- **Testing**: Comprehensive JUnit4 test suite ensuring code reliability
- **Documentation**: UML diagrams and clear code documentation
- **Modular Architecture**: Easily extensible and maintainable code structure

## ✨ Features

### 🎮 Game Features
- **Classic Snake Gameplay**: Traditional snake mechanics with modern polish
- **Progressive Difficulty**: Game speed and challenge increase as you progress
- **Score System**: Points awarded for eating fruits with bonus multipliers
- **Collision Detection**: Precise collision detection for walls and self-collision
- **Smooth Animation**: Fluid movement and responsive controls

### 🖥️ Interface Features
- **Main Menu**: Clean, intuitive navigation interface
- **Player Name Entry**: Personalized gaming experience with name registration
- **Leaderboard**: Track and display high scores from previous games
- **Game Window**: Dedicated game area with clear visual feedback
- **Responsive Design**: Optimized window management and scaling

### 🏆 Scoring & Progress
- **High Score Tracking**: Persistent leaderboard storage
- **Player Statistics**: Individual player performance tracking
- **Session Management**: Save and restore game progress


## 🔧 Requirements

### System Requirements
- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512MB RAM
- **Storage**: 50MB free disk space

### Development Requirements
- **Java SDK**: JDK 8+
- **Testing Framework**: JUnit 4
- **IDE**: Any Java-compatible IDE (IntelliJ IDEA, Eclipse, VS Code)

## 📦 Installation


### Option 1: Build from Source
1. **Clone the repository**
   ```bash
   git clone https://github.com/MatthewsO3/Snake.git
   cd Snake
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the game**
   ```bash
   java -cp bin Main
   ```

### Option 2: IDE Setup
1. Clone or download the repository
2. Import the project into your preferred Java IDE
3. Build and run the `Main` class

## 🎮 How to Play

### Objective
Control the snake to eat as many fruits as possible without hitting the walls or the snake's own body. Each fruit eaten increases your score and makes the snake longer.

### Game Flow
1. **Start**: Launch the game and enter your player name
2. **Navigate**: Use the main menu to start a new game or view the leaderboard
3. **Play**: Control the snake using arrow keys to collect fruits
4. **Score**: Try to achieve the highest score possible
5. **Leaderboard**: Your score is automatically saved to the leaderboard

### Scoring System
- **Fruit Collection**: +10 points per fruit
- **Speed Bonus**: Additional points based on current game speed
- **Survival Bonus**: Points for staying alive longer

## 🏗️ Architecture

The project follows a clean, object-oriented architecture with clear separation of concerns:

### Core Classes

#### `BaseFrame`
- **Purpose**: Window management and common UI functionality
- **Responsibilities**: Frame setup, common window operations
- **Features**: Centralized window management system

#### `Frame` (Main Menu)
- **Purpose**: Main menu interface and navigation
- **Responsibilities**: Game startup, settings, leaderboard access
- **Features**: User-friendly menu system with multiple options

#### `GameWindow`
- **Purpose**: Core game logic and rendering
- **Responsibilities**: Game loop, snake movement, collision detection, rendering
- **Features**: Real-time game mechanics and visual updates

### Design Patterns
- **MVC Pattern**: Separation of model, view, and controller logic
- **Observer Pattern**: Event-driven updates between components
- **Factory Pattern**: Object creation and initialization

### UML Documentation
The project includes UML diagrams that illustrate:
- Class relationships and dependencies
- Method interactions and data flow
- System architecture overview

## 🧪 Testing

The project includes comprehensive testing using JUnit 4 framework:

### Test Coverage
- **Unit Tests**: Individual method and class testing
- **Integration Tests**: Component interaction verification
- **Game Logic Tests**: Core game mechanics validation
- **UI Tests**: Interface functionality verification

### Running Tests
```bash
# Compile tests
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar test/*.java

# Run tests
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestSuite
```

### Test Categories
- **Movement Tests**: Snake movement and direction changes
- **Collision Tests**: Wall and self-collision detection
- **Scoring Tests**: Point calculation and leaderboard updates
- **UI Tests**: Menu navigation and window management

## 🎯 Controls

### Game Controls
- **↑ Arrow Key**: Move snake up
- **↓ Arrow Key**: Move snake down
- **← Arrow Key**: Move snake left  
- **→ Arrow Key**: Move snake right
- **Space**: Pause/Resume game
- **Esc**: Return to main menu

### Menu Navigation
- **Enter**: Select menu option
- **Tab**: Navigate between options
- **Esc**: Exit or go back

## 🛠️ Development

### Project Structure
```
Snake/
├── src/
│   ├── BaseFrame.java      # Base window management
│   ├── Frame.java          # Main menu implementation
│   ├── GameWindow.java     # Core game logic
│   └── Main.java           # Application entry point
├── test/
│   ├── GameLogicTest.java  # Game mechanics tests
│   └── UITest.java         # Interface tests
├── docs/
│   ├── UML_Diagram.png     # System architecture
│   └── ClassDiagram.png    # Class relationships
└── README.md
```

### Key Features Implementation
- **Game Loop**: Efficient game loop with consistent frame timing
- **Collision System**: Precise boundary and self-collision detection
- **Data Persistence**: Leaderboard storage and retrieval
- **Event Handling**: Responsive keyboard input processing� 
