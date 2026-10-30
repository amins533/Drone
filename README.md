# Drone Simulator

A Java-based desktop application that retrieves and displays real-time drone data from an external API. The application provides an interactive graphical user interface for exploring drone information, monitoring drone dynamics, and analyzing statistical data.

## Features

### Drone Catalogue
- Retrieve and display drone information from an external API.
- Search for specific drones.
- Filter and sort drone data based on different attributes.
- Navigate through results using pagination.
- Refresh data to retrieve the latest information.

### Drone Dashboard
- Calculate and display statistical information about drones.
- Analyze average speeds, total distances, battery consumption, and estimated ranges.
- Present calculated attributes in a structured table.

### Drone Dynamics
- Display dynamic drone information.
- Retrieve and update data from the external API.
- Present information in an organized table.

### Graphical User Interface
- Interactive desktop interface built with Java Swing.
- Multiple application pages managed through CardLayout.
- Custom-designed Swing components.
- Animated elements and a dedicated credits page.

## Technologies

- **Java** – Main programming language
- **Java Swing** – Graphical user interface
- **REST API** – External data retrieval
- **HTTP GET** – API communication
- **JSON** – Data processing and handling
- **Eclipse IDE** – Development environment
- **JDK 22** – Java development kit

## Project Structure

```text
src/
├── project/
│   └── Main.java
│
├── gui/
│   ├── MainWindow.java
│   ├── HomePage.java
│   ├── DronesDashboard.java
│   ├── Dynamics.java
│   ├── Catalogue2.java
│   └── Credits.java
│
└── components/
    ├── DroneSection.java
    ├── RoundedJButton.java
    ├── RoundedJPanel.java
    ├── RoundedJTextField.java
    ├── RoundedBorder.java
    ├── CustomRadioButtonUI.java
    └── PageChangerButton.java
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 22
- Eclipse IDE or another Java IDE
- Internet connection for accessing the external drone API

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/Drone-Simulator.git
   ```

2. Open Eclipse IDE.
3. Import the project into your workspace.
4. Make sure the required libraries are available in the project build path.
5. Run `Main.java` from the `project` package.

## Application Overview

The application consists of several pages that allow users to explore and analyze drone information:

- **Home:** Main navigation page.
- **Catalogue:** Browse, search, filter, and sort drone information.
- **Dynamics:** View dynamic drone data.
- **Dashboard:** Analyze calculated drone statistics.
- **Credits:** Project information and animated drone presentation.

## Authors

**Group 12**

Developed as part of a university project at Frankfurt University of Applied Sciences.

---

*Drone Simulator – Exploring real-time drone data through Java.*
<img width="1374" height="734" alt="grafik" src="https://github.com/user-attachments/assets/db03c052-f500-4216-a6da-38619960f873" />
<img width="1502" height="812" alt="grafik" src="https://github.com/user-attachments/assets/b5baef12-3dd2-4149-9c6b-4801386aac24" />
<img width="1508" height="808" alt="grafik" src="https://github.com/user-attachments/assets/6268a85d-fb43-4684-b8ca-7f1d835a4925" />
