## Getting started

1. Install Java: You should setup java environment.

2. The app can be run in the console with :

```
javac Todo.java
java Todo
```

## Usage

### 1. Help

Executing the command without any arguments, or with a single argument `help` prints the CLI usage.

```
$ java Todo help
Usage :-
$ java Todo add "todo item"  # Add a new todo
$ java Todo ls               # Show remaining todos
$ java Todo del NUMBER       # Delete a todo
$ java Todo done NUMBER      # Complete a todo
$ java Todo help             # Show usage
$ java Todo report           # Statistics
```