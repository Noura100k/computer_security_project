/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer_security_project;

import java.util.Scanner;

/**
 *
 * @author msi9
 */

public class Computer_security_project {

    /**
     * @param args the command line arguments
     */
     static String encr="";
     
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in =  new Scanner(System.in);//object to take inputs from the user
        String plain_text="" ;//variable to store plain text
       
        int choice , a=0 ,b=0,x=0,y=0 ,i=0,j=0 , inverse=0,flag=0;//variables setting them with 0 for further use
        char alphapet[]= {'A','B','C','D','E','F','G','H',
                          'I','J','K','L','M','N','O','P','Q',
                          'R','S','T','U','V','W','X','Y','Z'};//array of alphapet for using it with encyption and dycrption
        
        
         System.out.println("the secret numbers");
         System.out.println("Enter first secret number:");
         a = in.nextInt();
         System.out.println("Enter second secret number:");
         b=  in.nextInt();
         System.out.println("Enter your choice\n 1-encryption 2-dycrption");
         choice=in.nextInt();
         
        switch(choice)
                {
                   
                    case 1:
         
                      System.out.println("Enter the plain text WITHOUT spaces and use ONLY CAPTIAL LETTERS");
                      in.nextLine();
                      plain_text=in.nextLine();//take input from user
                      for (  i=0 ;i< plain_text.length();i++ )
                      {
                          for(  j=0 ;j<alphapet.length;j++)
                          {
                               if ( alphapet[j]== plain_text.charAt(i)) 
                               {
                                   x=j;//store the index of a letter in variable x
                                   j=alphapet.length;//this working as break statemnt but not exite the outer loop
                               }
                               if(plain_text.charAt(i)==' ')
                               {
                                  
                                   x=' ';
                                   j=alphapet.length;
                                           
                                   
                               
                               }
                          
                          }
                          if(x!=' ')
                          {
                      
                         y=((a*x)+b)% 26;//this equation use it for encryption take the new indexes for each letter
                         encr=encr+alphapet[y];//reach the letter in the new index and store to encryption variable
                          }else
                          {
                          encr=encr+" ";
                          }
                      
                      }
                       System.out.println(encr);//the result
                     
                     break;
                     
                    case 2:
                     System.out.println("Enter the cipertext Without spaces and use ONLY CAPTIAL LETTERS");
                     in.nextLine();
                     encr = in.nextLine();

                    for (i = 0; i < 26; i++)
                    {
                    flag = (a * i) % 26;

                    //Check if (a*i)%26 == 1,
                    //then i will be the multiplicative inverse of a
                    if (flag == 1)
                    {
                    inverse = i;
                    }
                    } //this loop to find the invers
                     for( i=0 ; i<encr.length();i++)
                     {
                         
                         for( j=0 ;j<26;j++)//here try to find the letter in corsponding index
                         {
                             if(encr.charAt(i)==alphapet[j]) 
                             {
                                  x=(inverse*(j-b))%26;//this for deycrption
                                  if(x<0)
                                  {
                                      x=x+26; //here if the index < 0 , add 26 to make postive
                                  }
                                  
                                 
                                  
                                  plain_text=plain_text+alphapet[x];
                                 
                                  
                                     
                             }else if(encr.charAt(i)==' ')
                                  {
                                   plain_text=plain_text+" ";
                                   j=26;
                                  
                                  }
                             
                         
                         
                         }
                         x=0;
    
                     }
                     System.out.println("the plain text after dycrption: "+plain_text);
                     break;
                        
                    default:
                        System.out.println("wronge choice try again");
                        
                }
        
        
    }
    
}
