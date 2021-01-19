import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

class Todo{
        private static final String USAGE = "Usage :-\n" + "$ java Todo add \"todo item\"  # Add a new todo\n"
				+ "$ java Todo ls               # Show remaining todos\n" + "$ java Todo del NUMBER       # Delete a todo\n"
				+ "$ java Todo done NUMBER      # Complete a todo\n" + "$ java Todo help             # Show usage\n"
				+ "$ java Todo report           # Statistics";
    
        static void add(String str,String file,boolean bol){
			try{
				FileWriter  writer = new FileWriter(file,bol);
				PrintWriter printWriter = new PrintWriter(writer);
				
				if (file.equals("done.txt")){
					Date date = new Date();  
    				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
					String strDate= formatter.format(date);
					printWriter.println("x "+strDate+" "+str);
				}
				else
					printWriter.println(str);
				printWriter.close();
			}
			catch(Exception e){
				System.out.println("Please enter input");
			}
		}
        
        public static void del(int index){
			try{
				File f = new File("todo.txt");
				if (!f.exists())
				f.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader("todo.txt"));
				String temp;
				int i = 0;
				ArrayList<String> ans = new ArrayList<String>();
				while((temp = br.readLine())!=null){
					if (i == index-1)
					{	i++;
						continue;
					}
					else 
                    {
						ans.add(temp);
					    i++;
                    }
				}
                if (i<index|| index<1){

					System.out.println("Error: todo #" + index + " does not exist. Nothing deleted.");
					//return;
				}
				else{
					System.out.println("Deleted todo #"+index);
				}
				if(ans.size()!=0)
                {
                    System.out.println("olefefe");
                    add(ans.get(0),"todo.txt",false);
                    for(i = 1 ; i<ans.size() ; i++){
                        add(ans.get(i),"todo.txt",true);
                    }
                }
                else
                {
                    //System.out.println("letseee");
                    PrintWriter writer = new PrintWriter(f);
                    writer.print("");
                    // other operations
                    writer.close();
//                    if (f.delete()) {
//                            System.out.println("hogyi"); //you might want to check if delete was successfull
//                    }
//                    else
//                    {
//                         System.out.println("nope");
//                    }
                }
			}
			catch( Exception e){
				System.out.println("todo does not exist.");
			}
		}
        static void done(int index){
			try{
				File f = new File("todo.txt");
				if (!f.exists())
					f.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader("todo.txt"));
				String temp;
				int i = 0;
				ArrayList<String> ans = new ArrayList<String>();
				while((temp = br.readLine())!=null){
					if (i == index-1){
						add(temp,"done.txt",true);
					}
					else 
						ans.add(temp);
					i++;
				}
				if (i<index || index<1){
					System.out.println("Error: todo #"+index+" does not exist.");
				}
				else
					System.out.println("Marked todo #"+ index + " as done.");
                if(ans.size()!=0)
                {
                    add(ans.get(0),"todo.txt",false);
                    for(i = 1 ; i<ans.size() ; i++){
                        add(ans.get(1),"todo.txt",true);
                    }
                }
			}
			catch(Exception e){
				System.out.println("todo doesn't exist.");
			}
		}
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
		static void report(){
			try{
				int todo =0;
				int done = 0;
				File f = new File("todo.txt");
				File f1 = new File("done.txt");
				if (!f.exists())
					f.createNewFile();
				if (!f1.exists())
					f1.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader("todo.txt"));
				BufferedReader br1 = new BufferedReader(new FileReader("done.txt"));
				while ( br.readLine()!=null)
					todo+=1;
				while(br1.readLine()!=null)
					done+=1;
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
			
					System.out.printf("%s Pending : %d Completed : %d", formatter.format(date), todo, done);
			}
			catch( Exception e ){
				System.out.println("File not found");
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
            else if(args[0].equals("add"))
            {
				if (args.length == 2){
					add(args[1],"todo.txt",true);
					System.out.println("Added todo: "+"\""+args[1]+"\"");
				}else{
					System.out.println("Error: Missing todo string. Nothing added!");
                }
            }
            else if(args[0].equals("del")){
				if (args.length == 2){
						del(Integer.parseInt(args[1]));
                }else{
						System.out.println("Error: Missing NUMBER for deleting todo.");
                }
            }
            else if(args[0].equals("done")){
				if (args.length ==2){
                    done(Integer.parseInt(args[1]));
				}else{
                    System.out.println("Error: Missing NUMBER for marking todo as done.");	
				}
            }
            else if(args[0].equals("report")){
					report();
            }
            
        }
}