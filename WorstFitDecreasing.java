import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class WorstFitDecreasing
{
   public static void main(String[] args) 
   {
      Queue<Disk> a = new PriorityQueue<Disk>();
      Queue<Integer> rQ = new PriorityQueue<Integer>(Collections.reverseOrder());

      try
      {
         int id = 0;
         double sFile = 0;
         int disktot = 0;
         Scanner i = new Scanner(new File("input20.txt"));
         while(i.hasNextLine())
         {
           rQ.offer(Integer.parseInt(i.nextLine()));
         }

          Disk d = new Disk(id);
          a.offer(d);
         while(rQ.isEmpty() == false)
         {
          int cSum = rQ.poll();
          sFile+= cSum;
          if(a.peek().getSpaces() >= cSum)
          {
            Disk bestDisk = a.poll();
            bestDisk.add(cSum);
            a.offer(bestDisk);
          }
          else
          {
            id+=1;
            Disk newD = new Disk(id);
            newD.add(cSum);
            a.offer(newD);
          }         
        }
        sFile/=1000000;
        System.out.println("Total size = " + sFile + " GB");
        disktot = id + 1;
        System.out.println("Disks req'd = " + disktot);

        while(a.isEmpty() == false)
        {
          Disk Dnew = new Disk();
          Dnew = a.poll();
          int space = Dnew.getMax() - Dnew.getCurrent();
          System.out.println(Dnew.getId() + " " + space + ": " + Dnew.toString());
        }

       }           
      catch(FileNotFoundException E)
      {
        System.out.println("Error");
      }
      
         
   }  
}