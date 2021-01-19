import java.util.*;
import java.io.*;

class Todo{
    private static final String USAGE = "Usage :-\n" + "$ java Todo add \"todo item\"  # Add a new todo\n"
				+ "$ java Todo ls               # Show remaining todos\n" + "$ java Todo del NUMBER       # Delete a todo\n"
				+ "$ java Todo done NUMBER      # Complete a todo\n" + "$ java Todo help             # Show usage\n"
				+ "$ java Todo report           # Statistics";
    
		public static void listing(){
			try{
				File f = new File("todo.txt");
				if (!f.exists())
				f.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader("todo.txt"));
				String temp;
				ArrayList<String> ans = new ArrayList<String>();
				while((temp = br.readLine())!=null){
						ans.add(temp);
					
				}
				if(ans.size()==0){
					System.out.println("There are no pending todos!");
				}
				for(int i = ans.size()-1;i>=0 ; i--){
					System.out.printf("[%d] %s\n", i + 1, ans.get(i));
				}
			
			}
			catch( Exception e){
				System.out.println("todo does not exist.");
			}
		}
		
	public static void main(String args[])
	{
		if (args.length==0 || args[0].equals("help"))
        {
            System.out.println(USAGE);
        }
        else if(args[0].equals("ls"))
        {
            listing();
        }
	}
}