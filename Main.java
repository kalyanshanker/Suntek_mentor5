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
  {   int c=0,k=0;
      for(int i=a;i<b;i++)
    {
        if((k==0))
        {
           k++;
           c=arr[i]^arr[i+1];
        }
        else{
            
            c=c^arr[i+1];
        }
    }
    if(k==0)
    return arr[a];
    else
      return c;
  }
    
    static int [] extractInt(String str)   //contverting string format i/p to array 
    { 
        
        str = str.replaceAll("[^\\d]", " "); 
         str = str.trim(); 
        str = str.replaceAll(" +", " ");
       
        //numbers.split(" ");
        
        String[] integerStrings = str.split(" "); 
// Splits each spaced integer into a String array.
int[] integers = new int[integerStrings.length]; 
// Creates the integer array.
for (int i = 0; i < integers.length; i++){
    integers[i] = Integer.parseInt(integerStrings[i]); 
//Parses the integer for each string.
}
        
        return integers;
    } 
    
    
    public static void main(String[] args)   //code block
    { int c=0;
     Scanner s= new Scanner(System.in);
     String str = "[[0,10],[1,2],[0,0],[3,3],[2,3]]"; String str1 ="[3,3,3,3,3,3,3,3,3,3,3,3,3,3]";  // o/p--->[3,0,3,3,0]
    // String str = "[[0,1],[1,2],[0,3],[3,3],[2,3]]"; String str1 ="[1,3,4,8,9]"; //uncomment to test it// o/p---->[2,7,14,12]
    // String str=s.nextLine();              //uncoment to give input from console
     //String str1=s.nextLine();             //uncoment to give input from console
       int query [] = extractInt(str); //System.out.println(Arrays.toString(query));
       int arr[] =extractInt(str1); //System.out.println(Arrays.toString(arr));
       int [] h1=hash(arr,query);
       int [] n = new int[query.length/2];    
       for(int i=0;i<query.length;i=i+2 )  {
           //System.out.println(""+query[i]+","+query[i+1]);
           n[c]=fun(arr,query[i],query[i+1]); c++; 
         
       }
    System.out.println("output by complexty of O(n)");
     System.out.println(Arrays.toString(h1));
      System.out.println("output by complexty of O(n^2)");
     System.out.println(Arrays.toString(n));
    
    } 
} 

