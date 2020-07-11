/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyyos;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 *
 * @author Eso Said
 */

public class FinalyyOS {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Terminal t = new Terminal();
        parser prs = new parser();
        Scanner s = new Scanner(System.in);

        String str;

        while (true) {
            System.out.print("=> ");
            String line = s.nextLine();

            String pipe[] = line.split(Pattern.quote("|"));
            
            for (int j = 0; j < pipe.length; j++) {
                prs.parse(pipe[j]);

                String argument[] = prs.getArgument();
                String cmd = prs.gedCmd();

                if ("cd".equals(cmd)) {
                    
                    if (prs.shortPath(argument) == true || prs.longPath(argument)==true) {
                        t.CD(argument);
                    } else {
                        System.out.println("wrong input");
                    }
                } else if ("ls".equals(cmd)) {
                    t.ls();
                } else if ("pwd".equals(cmd)) {
                    t.pwd();
                } else if ("rm".equals(cmd)) {
                    
                    t.rm(argument);
                } else if ("mkdir".equals(cmd)) {
                    t.createfolder(argument);
                } else if ("rmdir".equals(cmd)) {
                    t.rmdir(argument);
                } else if ("cat".equals(cmd)) {
                    if (argument[0].equals(">")) {
                        str = argument[1];
                        t.write(str);
                    } else if (argument[0].equals(">>")) {
                        str = argument[1];
                        t.writeAppend(str);
                    } else {
                        t.cat(argument);
                    }
                } else if ("cp".equals(cmd)) {
                    t.copy(argument);
                }             else if("mv".equals(cmd)){
                               t.move(argument);
                            }
                else if ("more".equals(cmd)) {   // more c://file//xx.txt
                    t.more(argument);
                } else if ("clear".equals(cmd)) {
                    t.Clear();
                }
                 
                else if("date".equals(cmd)){
                    t.date();
                }
                else if("help".equals(cmd)){
                    t.help();
                }
                else if ("touch".equals(cmd)){
                    t.createfile(argument);
                }
                else if ("args".equals(cmd)){
                t.HelpArgs(argument);}

            }

        }
    }

    
}
