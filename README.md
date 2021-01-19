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

### 2. List all pending todos

Use the `ls` command to see all the todos that are not yet complete. The most recently added todo will be displayed first.

```
$ java Todo ls
[2] todo 2
[1] todo 1
```

### 3. Add a new todo

Use the `add` command. The text of the todo item should be enclosed within double quotes :).

```
$ java Todo add "the thing i need to do"
Added todo: "the thing i need to do"
