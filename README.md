# race-strat-sim
This repository contains a Java Project focussed on building a Motorsports Race Strategy Tool

# Overview
The overall concept of the project

# Classes & Interfaces

Main: contains code that runs the entire program
Data_Processor: reads lap times, current tyre, laps, driver/team names from a text or csv file (perhaps go sheet by sheet on each lap) 
                and store the information (maybe overwrite previous lap in the collection), 3s time delay between each reading.
DriverTracker: determines track position, (interval) gap between drivers after each lap, calculates anticipated total race time.
Weather: this determines the nature of the weather system for the race
Tyres: all the information and dynamics surrounding the Tyres (warm up, compound, longevity, delta, offset)
Circuit: Track characteristics (layout, nature, length, altitude, asphalt)/temperature/evolution
Degradation lap-time degradation based on traffic (dirty air), tyre data, fuel and track specific information (impacts each compound non-linearly)
Considerations: Race Management (traffic/tyre management), safety car probability, opponent strength, 
                likelihood of being overtaken, average finishing position, pit lane time loss, rejoining position, laps remaining
Generate_Laps: generates lap times (3s delay) until pit stop without reading from file. These are either random or based off the variables.
Strategies: contains code (Algorithms) that determines the best strategy based on the variables in the system.
            These are selected from collections of strategic decisions with reasoning
GUI_HOME: home screen, plays F1 V10 sounds on start up while 'Race Strategy Simulator' words appear
          thick red banner on top, black main screen under, shows a graph and a clock
          'race variables' and 'simulation' buttons. If you don't go on variables, it will use default values.
GUI_Variables: same overall layout. shows many variables, their limits (range) and input text boxes/buttons/scroll buttons
               'set' button to save the variables, 'simulation' button.
GUI_Choice: same overall layout, 'generate laps' and 'read laps' buttons (this could link with track name scroll to read the correct file),
            'simulate' button under them.
GUI_Sim: 'pit stop' ("box, box" sound), 'safety car', 'pause', 'unpause' buttons
         Visualizes table of names, track position, interval, pit/out/lap times, current tyre, tyre stint
         current lap, rejoining position, target lap (with sound), recommended lap ("target plus " + num), track status (green, VSC, SC),
         Strategy reasoning (this is the main thing and should appear under recommended lap or in VSC/SC)


# Software Design Patterns

I will mention any design patterns used in this software project here. I expect to use:
Strategy Pattern when choosing the Strategy reasoning and recommended lap.
Observer Pattern to monitor the variables (particularly the weather)
Possibly Adapter Pattern if there's any interface incompatibility.
Singleton in case we need to use a single instance of classes/constructors when using the variables.
Factory to create objects, such as the lap times.
Facade to simplify the Algorithms being used to determine track position/interval/total race time


# Class Relationships

# Code Complexity

I intend to keep the complexity low but effective, and yet demonstrate some prowess. Possibly use some unique code implementations/tools
Can possibly use a system to measure time, memory and energy usage like for LLM Project.

# Code Maintainability, Readability and Reusability

Code should be loosely coupled. Should be able to demonstrate the addition of code/variables, reuse older code (such as reader),
The code should be well segmented, naming conventions. Minimize smells.

# Implementation

Talk about the code here once it is complete.

# Log of changes made

# Testing
