package com.guru99;



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

        String algo = null;

        String oldprice = "120";
        String newprice = "500";

        int result=0;
        
        if(oldprice!=null && newprice!=null){
            System.out.println(oldprice.compareTo(newprice));
        }
        
        
        //System.out.println(Integer.parseInt(algo));


    }
}
