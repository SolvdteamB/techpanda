package com.guru99;

import org.apache.commons.compress.archivers.zip.X0016_CertificateIdForCentralDirectory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println();
        String x = "Hello \nWorld!\nWelcome\nto\nthe\nJungle";
        
        //System.out.println(x);

         String [] splited;
         
         splited = x.split("\\n");

        System.out.println(splited[0]);



    }
}
