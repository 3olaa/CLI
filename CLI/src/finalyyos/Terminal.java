/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyyos;

/**
 *
 * @author Eso Said
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author toqa khaled
 */
public class Terminal {

    Terminal() {
    }

    public String pwd() throws IOException { // print working directory
        File f = new File("");
        String current = f.getCanonicalPath();  //return current path ( new java.io.File("").getCanonicalPath();)
        System.out.println("Current Directory is-> " + current);

        return current;
    }

    public void ls() { // list

        try {
            String currentDirect = pwd();
            File f = new File(currentDirect);
            String[] files = f.list();  // take all files in directory 
            System.out.println("Files Are:");
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        } catch (Exception e) {
            System.out.println("Error The Exeption iS " + e);
        }
    }

    public void rm(String s[]) { //remove file
        for (int i = 0; i < s.length; i++) {
        try {
            File f = new File(s[i]);

            if (f.delete()) {
                System.out.println("File Deleted");
            } else {
                System.out.println("File Cant Deleted");
            }
        } catch (Exception e) {
            System.out.println("Error The Exeption iS " + e);
        }}
    }

    public void createfile(String s[]) {
        for (int i = 0; i < s.length; i++) {
        try {

            File f = new File(s[i]);

            if (f.createNewFile()) // if the file exist cant create if not its create
            {
                System.out.println("File Created");
            } else {
                System.out.println("File Already Exists");
            }
        } catch (Exception e) {
            System.out.println("Error The Exeption iS " + e);
        }}
    }

    public void createfolder(String s[]) {
        for (int i = 0; i < s.length; i++) {
            try {
                File f = new File(s[i]);

                if (f.mkdir()) // if the folder exist cant create if not its create
                {
                    System.out.println("Folder Created");
                } else {
                    System.out.println("Folder Already Exists");
                }
            } catch (Exception e) {
                System.out.println("Error The Exeption iS " + e);
            }

        }

    }

    public void rmdir(String s[]) {
        for (int i = 0; i < s.length; i++) {
            try {
                File f = new File(s[i]);
                if (f.delete()) // if the folder exist cant create if not its create
                {
                    System.out.println("Folder Deleted");
                } else {
                    System.out.println("Cant Delete This Folder ");
                }
            } catch (Exception e) {
                System.out.println("Error The Exeption iS " + e);
            }
        }
    }

    public void cat(String s[]) throws FileNotFoundException, IOException {

        File directory = new File("C:\\Users\\Eso Said\\Desktop\\OS\\OS\\data");

        PrintWriter write = new PrintWriter("catfile.txt");  // pbject to write in 

        String[] fileNames = directory.list(); //put files found in data in array

        for (int i = 0; i < fileNames.length; i++) {
            String fileName = fileNames[i];
            System.out.println("Reading from " + fileName);

            //b3ml object mn kol file fl array
            File f = new File(directory, fileName);   // create instance of file from Name of the file stored in string Array 

            BufferedReader read = new BufferedReader(new FileReader(f)); // object to read

            String line = read.readLine();   // Read from current file 
            while (line != null) {

                write.println(line);   // write to the output file 
                line = read.readLine();
            }
            write.flush();
        }
        System.out.println("Reading is Done");
    }

    public void write(String s) throws IOException {
        File f = new File(s);
        if (!f.exists()) {
            String arr[]=s.split(s);
            createfile(arr);
            FileWriter fw = new FileWriter(s);
            Scanner scan = new Scanner(System.in);
            String text;
            text = scan.nextLine();
            for (int i = 0; i < text.length(); i++) {
                fw.write(text.charAt(i));
            }
            fw.close();
        } else {
            FileWriter fw = new FileWriter(s);
            Scanner scan = new Scanner(System.in);
            String text;
            text = scan.nextLine();
            for (int i = 0; i < text.length(); i++) {
                fw.write(text.charAt(i));
            }
            fw.close();

        }
    }

    public void writeAppend(String s) throws IOException {
        File f = new File(s);
        if (f.exists()) {
            FileWriter fw = new FileWriter(s, true);
            BufferedWriter out = new BufferedWriter(fw);
            Scanner scan = new Scanner(System.in);
            String text;
            text = scan.nextLine();
            out.write(text);
            out.close();
        }
    }

    public void help() {
        System.out.println("args : List all command arguments\n"
                + "date : Current date/time\n"
                + "exit : Stop all\n" + "pwd: Print working directory\n"
                + "ls: List the files in current directory\n" + "more: Allow the user to scroll up and down if the file is large\n"
                + "cd: Change current working directory\n" + "cp: Copy a file\n" + "cat: View concatenate files\n"
                + "mkdir: Make directory (create a folder)\n" + "rmdir: Remove an empty directory\n"
                + "mv: Move one or more files or directories from one place to another\n" + "rm: Remove or delete files and directory\n"
                + "clear: Clear the terminal screen\n" + "args: List all parameters on the command line, numbers or strings for specific command\n");
    }

    public void date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss"); //day-month-year   hours-minutes-seconds
        Date d = new Date(); //Creates date object representing current date and time
        System.out.println(sdf.format(d));
        //System.out.println(d);
    }

//    public String cd(String path[]) throws IOException {      
//         File f = new File(path[0]);
//        String current = f.getCanonicalPath();
//        System.setProperty("user.dir", current);     
//        return current;  
//    }
    String temp = System.getProperty("user.dir");  // c

    public void CD(String path[]) throws IOException {
        
        System.out.println("temp is  " + temp);
        String myPath = System.getProperty("user.dir"); // d

        File f = new File(path[0]);
        String current = "";
        if (path[0].equals(".") ) {
            current = temp;
            temp = myPath;
        } 
        else if(path[0].equals ("/")){
                current = System.getenv("SystemDrive");
            }
        else {
            current = f.getCanonicalPath();
        }
        System.setProperty("user.dir", current);
        System.out.println(pwd());
    }

    public void Clear() {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("F:/esso/esraa.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void more(String src[]) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(src[0]));
        List<String> data = new ArrayList<>();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            data.add(s);
        }
        List<String> arrlist = data.subList(0, 10);
        for (int i = 0; i < arrlist.size(); i++) {
            // System.out.println(" "); 
            System.out.println(arrlist.get(i));
        }
        int first = 10;
        int last = 11;
        while (true) {

            String c = in.nextLine();
            if (c.equals(" ")) {

                List<String> arrlist1 = data.subList(first, last); // 10  10
                for (int i = 0; i < arrlist1.size(); i++) {
                    // System.out.println(" "); 
                    System.out.println(arrlist1.get(i));
                }

                first = last; //11
                last++; //12
                //11 11
                // shofy ellyhayetteb3now mafrod yeb2a kam law 7atelik space
            } else if (c.isEmpty()) {
                List<String> arrlist2 = data.subList(first, last + 9); // 10  20      print 10 to 20 
                for (int i = 0; i < arrlist2.size(); i++) {
                    // System.out.println(" "); 
                    System.out.println(arrlist2.get(i));
                }

                first = last + 1; // 21
                last += 10;   //31   print 21 to 30

// ya3ny da55al enter
                // shofy ellyhayetteb3now mafrod yeb2a kam law 7atelik enter
            }
            if (c.equals("f")) {
                break;
            }

        }
        System.out.println("ENDED");

    }
   public void  HelpArgs(String help []){
       if (help[0].equalsIgnoreCase("cp")){
           System.out.println("args1 : Source path");
           System.out.println("args2 : Destination path");
       
       }
      else if (help[0].equalsIgnoreCase("mv")){
           System.out.println("args1 : Source path");
           System.out.println("args2 : Destination path");
       
       }
      else if (help[0].equalsIgnoreCase("mkdir")){
           System.out.println("args : name of folder");
       }
      else if (help[0].equalsIgnoreCase("remdir")){
           System.out.println("args : name of folder");
       
       }
     else  if (help[0].equalsIgnoreCase("more")){
           System.out.println("args : Source path");
       }
     else  if (help[0].equalsIgnoreCase("rm")){
           System.out.println("args : name of file   ");
       }
      else if (help[0].equalsIgnoreCase("cd")){
           System.out.println("args : Destination path");
       }
      else {
      System.out.println("uncorrect command please try again ");}
   
           }

    public void copy (String path[]){
         File srcFolder = new File(path[0]);
   	File destFolder = new File(path[1]);
        
       
//  /*  File srcFolder = new File("F:\\esso");
//    	File destFolder = new File("F:\\eso\\esso");*/
   	
    	//make sure source exists
    	if(!srcFolder.exists()){

          System.out.println("Directory does not exist.");
          //just exit
          System.exit(0);

        }
       else{

           try{
                 String source=srcFolder.toString();
                  String destination =destFolder.toString();
                  String array[]={source,destination};
        	copyFolder(array);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    	
    	System.out.println("Done");
    }
    
    public void copyFolder(String path[])
    	throws IOException{
        File src = new File(path[0]);
    	File dest = new File(path[1]);
    	
    	if(src.isDirectory()){
    		
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
    		
    		//list all the directory contents
    		String files[] = src.list();
    		
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
                   
                 String source=srcFile.toString();
                  String destination =destFile.toString();
                  String array[]={source,destination};
    		   copyFolder(array);
    		}
    	   
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
    	                     
    	        byte[] buffer = new byte[1024];
    	    
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}}
    ///////////////////////////////////////////////////////
     public void move (String path[]){
         File srcFolder = new File(path[0]);
   	File destFolder = new File(path[1]);
        
       
//  /*  File srcFolder = new File("F:\\esso");
//    	File destFolder = new File("F:\\eso\\esso");*/
   	
    	//make sure source exists
    	if(!srcFolder.exists()){

          System.out.println("Directory does not exist.");
          //just exit
          System.exit(0);

        }
       else{

           try{
                 String source=srcFolder.toString();
                  String destination =destFolder.toString();
                  String array[]={source,destination};
        	moveFolder(array);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    	
    	System.out.println("Done");
    }
    
    public void moveFolder(String path[])
    	throws IOException{
        File src = new File(path[0]);
    	File dest = new File(path[1]);
    	
    	if(src.isDirectory()){
    		
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory moved from " 
                              + src + "  to " + dest);
                   src.delete();
    		}
    		
    		//list all the directory contents
    		String files[] = src.list();
    		
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
                   
                 String source=srcFile.toString();
                  String destination =destFile.toString();
                  String array[]={source,destination};
    		   moveFolder(array);
                   srcFile.delete();
                   
    		}
    	   
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
    	                     
    	        byte[] buffer = new byte[1024];
    	    
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        System.out.println("File moved from " + src + " to " + dest);
    	}}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//    public static void move(String srcPath ,String desPath){
//     File srcFolder = new File(srcPath);
//    	File destFolder = new File(desPath);
//   /*  File srcFolder = new File("F:\\esso");
//    	File destFolder = new File("F:\\eso\\esso");*/
//    	
//    	//make sure source exists
//    	if(!srcFolder.exists()){
//
//           System.out.println("Folder does not exist.");
//           //just exit
//           System.exit(0);
//
//        }else{
//
//           try{
//        	moveFolder(srcFolder,destFolder);
//           }catch(IOException e){
//        	e.printStackTrace();
//        	//error, just exit
//                System.exit(0);
//                
//           }
//        }
//    	
//    	System.out.println("Done");
//    }
//    
//    public static void moveFolder(File src, File dest)
//    	throws IOException{
//    	
//    	if(src.isDirectory()){
//    		
//    		//if directory not exists, create it
//    		if(!dest.exists()){
//    		   dest.mkdir();
//    		   System.out.println("file moved from " 
//                              + src + "  to " + dest);
//         
//    		}
//    		
//    		//list all the directory contents
//    		String files[] = src.list();
//    		
//    		for (String file : files) {
//    		   //construct the src and dest file structure
//    		   File srcFile = new File(src, file);
//    		   File destFile = new File(dest, file);
//    		   //recursive copy
//                   
//    		   moveFolder(srcFile,destFile);
//                   srcFile.delete();
//    		}
//    	   
//    	}else{
//    		//if file, then copy it
//    		//Use bytes stream to support all file types
//    		InputStream in = new FileInputStream(src);
//    	        OutputStream out = new FileOutputStream(dest); 
//    	                     
//    	        byte[] buffer = new byte[1024];
//    	    
//    	        int length;
//    	        //copy the file content in bytes 
//    	        while ((length = in.read(buffer)) > 0){
//    	    	   out.write(buffer, 0, length);
//    	        }
// 
//    	        in.close();
//    	        out.close();
//    	        System.out.println("File moved from " + src + " to " + dest);
//                src.delete();
//                
//                
//}}
   /* public void copy(String srcPath, String desPath) {
        File srcFolder = new File(srcPath);
        File destFolder = new File(desPath);
        /*  File srcFolder = new File("F:\\esso");
    	File destFolder = new File("F:\\eso\\esso");

        //make sure source exists
        if (!srcFolder.exists()) {

            System.out.println("Directory does not exist.");
            //just exit
            System.exit(0);

        } else {

            try {
                copyFolder(srcFolder, destFolder);
            } catch (IOException e) {
                e.printStackTrace();
                //error, just exit
                System.exit(0);
            }
        }

        System.out.println("Done");
    }

    public void copyFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {

            //if directory not exists, create it
            if (!dest.exists()) {
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }

    public void move(String srcPath, String desPath) {
        File srcFolder = new File(srcPath);
        File destFolder = new File(desPath);
        /*  File srcFolder = new File("F:\\esso");
    	File destFolder = new File("F:\\eso\\esso");

        //make sure source exists
        if (!srcFolder.exists()) {

            System.out.println("Folder does not exist.");
            //just exit
            System.exit(0);

        } else {

            try {
                moveFolder(srcFolder, destFolder);
            } catch (IOException e) {
                e.printStackTrace();
                //error, just exit
                System.exit(0);

            }
        }

        System.out.println("Done");
    }

    public void moveFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {

            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("file moved from "
                        + src + "  to " + dest);

            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy

                moveFolder(srcFile, destFile);
                srcFile.delete();
            }

        } else {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File moved from " + src + " to " + dest);
            src.delete();

        }
    }*/

  
}
