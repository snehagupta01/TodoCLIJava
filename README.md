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
```

### 4. Delete a todo item

Use the `del` command to remove a todo item by its number (^^).

```
$ java Todo del 3
Deleted todo #3
```

Attempting to delete a non-existent todo item will display an error message :/.

```
$ java Todo del 5
Error: todo #5 does not exist. Nothing deleted.
```

### 5. Mark a todo item as completed

Use the `done` command to mark a todo item as completed by its number.

```
$ java Todo done 1
Marked todo #1 as done.
```

Attempting to mark a non-existent todo item as completed will display an error message.

```
$ java Todo done 5
Error: todo #5 does not exist.