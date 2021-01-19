import java.util.*;
import java.io.*;

class Todo{
    private static final String USAGE = "Usage :-\n" + "$ java Todo add \"todo item\"  # Add a new todo\n"
				+ "$ java Todo ls               # Show remaining todos\n" + "$ java Todo del NUMBER       # Delete a todo\n"
				+ "$ java Todo done NUMBER      # Complete a todo\n" + "$ java Todo help             # Show usage\n"
				+ "$ java Todo report           # Statistics";
	public static void main(String args[])
	{
		if (args.length==0 || args[0].equals("help"))
        {
					System.out.println(USAGE);
        }
	}
}