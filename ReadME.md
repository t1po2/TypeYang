# TypeYang (Monkeytype Clone) ⌨️ 🐒

> **Status: Work In Progress (WIP) 🚧**

TypeYang is a minimalist, lightweight typing speed test application built in Java. Inspired by the popular [Monkeytype](https://monkeytype.com/), this project aims to provide a clean, distraction-free environment to practice typing, track WPM (Words Per Minute), and improve overall accuracy.

## 🚀 Current Status (WIP)

The project is currently in its early stages of development. The core typing engine and foundational Model-View-Controller (MVC) architecture have been laid out. 

**What's working right now:**
- ⏱️ **Session Tracking:** A robust 30-second countdown timer that starts automatically exactly on the user's first keystroke.
- 🧠 **Typing Engine:** An evaluation system that checks user input against a loaded text file in real-time, categorizing inputs into standard, actionable states.
- 🏗️ **Clean Architecture:** Strict separation of UI (`Controller`), Business Logic (`TypeEngine2`), and State (`SessionTracker`).

## 🗺️ Roadmap / TODOs

Since the project is heavily under construction, the following features are actively being worked on:

- [ ] **JavaFX UI Integration:** Visualizing the text on screen, advancing the cursor, and coloring characters (e.g., Green for correct, Red for typos, Grey for untyped {partially done}).
- [ ] **Backspace / Correction Support:** Transitioning the engine's data structure (from a Queue to an Index-based system) to support correcting mistakes.
- [ ] **End Screen Analytics:** Calculating and displaying final WPM, raw WPM, and accuracy percentages once the time limit is reached.
- [ ] **Custom Game Modes:** Adding support for word-count limits (e.g., 10, 25, 50 words) and custom time limits (15s, 60s, 120s).
- [ ] **Dynamic Word Generation:** Replacing the static `text.txt` file with randomly pulled words from a larger dictionary array.

## 📁 Project Structure

The application follows a standard Java package structure emphasizing modularity:

```text
src/
└── typeyang/
    ├── engine/
    │   └── TypeEngine2.java       # Core business logic and input evaluation API
    ├── model/
    │   └── SessionTracker.java    # Tracks time elapsed, mistakes, and game state
    └── service/
        ├── Controller.java        # JavaFX UI controller routing key events
        └── LoadText.java          # Utility for reading target text from resources
```

## 🛠️ Tech Stack
* **Language:** Java
* **GUI Framework:** JavaFX
* **Design Pattern:** MVC (Model-View-Controller)

## 🎮 Getting Started (For Developers)

*(Note: These instructions will be expanded once the build process and UI are finalized)*

1. Clone the repository to your local machine.
2. Ensure you have a recent **Java JDK** and **JavaFX** configured in your environment.
3. Import the project into your preferred IDE (IntelliJ IDEA, Eclipse, VS Code).
4. Run the main Application class (to be added) to launch the UI.

---
*Built with ❤️ (and Java) — Work in Progress!*  
*Markdown file created with ai*
