//link for the code to compile:https://repl.it/@euclid086/bitMan1
// String str = "[[0,1],[1,2],[0,3],[3,3],[2,3]]"; ---->queery
// String str1 ="[1,3,4,8,9]";         ------ >ip arry
//[2,7,14,12]---->output of code


import java.util.*;
public class Main { 
    static int[] hash(int[]arr,int[] query)   // fun complexity of o(n)
    {
        int c=0;
        int [] h1 =new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
         if(i==0)                         //creating a xor array for storing continous xor values;
         {
             h1[i]=arr[i];
             c=arr[i];
         }
         else{c=c^arr[i];
             h1[i]=c;
         }
        }
        c=0;
        int [] h2=new int[query.length/2];c=0;
        for(int i=0;i<query.length;i=i+2 ) 
        {
          int t1=query[i];
         int t2=query[i+1];
          int  p=(h1[t2])^(h1[t1]);                 //Calucation of o/p by O(n)
          h2[c]= (h1[t1]^(h1[t2])^arr[query[i]]);
          c++;
        }
        return h2;
    }
    
    
    
  static int fun(int[] arr,int a,int b)      //fun for complexity O(n^2)
  {   int c=0;
      for(int i=a;i<b;i++)
    {
        if(c==0)
        {
           
           c=arr[i]^arr[i+1];
        }
        else{
            
            c=c^arr[i+1];
        }
    }
    if(c==0)
    return arr[a];
    else
      return c;
  }
    
    static int [] extractInt(String str)   //contverting string format i/p to array 
    { 
        
        str = str.replaceAll("[^\\d]", " "); 
         str = str.trim(); 
        str = str.replaceAll(" +", "");
        int[] num = new int[str.length()];

    for (int i = 0; i < str.length(); i++){
        num[i] = str.charAt(i) - '0';
    }
        return num;
    } 
    public static void main(String[] args)   //code block
    { int c=0;
     Scanner s= new Scanner(System.in);
     String str = "[[0,1],[1,2],[0,3],[3,3],[2,3]]";
      String str1 ="[1,3,4,8,9]";    
    // String str=s.nextLine();              //uncoment to give input from console
     //String str1=s.nextLine();             //uncoment to give input from console
       int query [] = extractInt(str);
       int arr[] =extractInt(str1);
       int [] h1=hash(arr,query);
       int [] n = new int[query.length/2];    
       for(int i=0;i<query.length;i=i+2 )  { 
           n[c]=fun(arr,query[i],query[i+1]); c++; 
         
       }
    System.out.println("output by complexty of O(n)");
     System.out.println(Arrays.toString(h1));
      System.out.println("output by complexty of O(n^2)");
     System.out.println(Arrays.toString(n));
    
    } 
} 

