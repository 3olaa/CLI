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
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;


public class parser {

    String[] args ;    //new String[2]
    String cmd;

    String arrgument[];

    parser() {
    }

    public boolean parse(String input) {
        File f = new File(input);
        String[] split = input.split("\\s(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        cmd = split[0];
        args = Arrays.copyOfRange(split, 1, split.length);

//        arrgument=input.split(" ");
//        cmd=arrgument[0];
//        args = Arrays.copyOfRange(arrgument, 1, arrgument.length);    
        return true;

    }

    public boolean shortPath(String s[]) {
        File f = new File(System.getProperty("user.dir") + "/" + s[0]);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean longPath(String s[]){
         File f = new File(s[0]);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
        
    }

    public String[] getArgument() {
        
        return args;
    }

    public String gedCmd() {

        return cmd;
    }

}

