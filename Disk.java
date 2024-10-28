import java.util.*;
public class Disk implements Comparable<Disk>
{
   private ArrayList<Integer> a;
   private int currentData;
   private int id;
   private int max;
   public Disk(int i)
   {
     a = new ArrayList<Integer>();
     currentData = 0;
     max = 1000000;
     id = i;
   }
   public Disk()
   {
     a = new ArrayList<Integer>();
     currentData = 0;
     max = 1000000;
   }
   public int getMax()
   {
     return max;
   }
   public int getCurrent()
   {
     return currentData;
   }
   
   public int getId()
   {
     return id;
   }
   
   public void add(int d)
   {    
      currentData+=d;
      a.add(d); 
   }
   public boolean comp(int d)
   {
     if(d <= max)
     {
       return true;
     }
     return false;
   }
   public int getSpaces()
   {
     return max - currentData;
   }
   public int compareTo(Disk o)
   {
     if(o.currentData == this.currentData)
     {
       return 0;
     }
     if(o.currentData > this.currentData)
     {
       return -1;
     }
     return 1;
   }
   public String toString()
   {
     String s = "";
     for(int i = 0; i < a.size(); i++)
     {
       if(a.get(i) != null)
       {
         s+= a.get(i) + " ";
       }
     }
     return s;
   }
}