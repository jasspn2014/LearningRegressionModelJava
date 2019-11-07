import java.util.*;
import java.io.*;

class LinearRegression
{
  public static void main(String args[]) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String str = br.readLine();

    int i,j;

    String[] dataArray = str.split(" ");

    for(i=0;i<dataArray.length;i++)
      System.out.print(dataArray[i]+" ");

    System.out.println(dataArray.length);

    int expArr[] = new int[dataArray.length/2];
    int salArr[] = new int[dataArray.length/2];
    j=0;

    for(i=0;i<=dataArray.length-2;i=i+2,j++)
       {
         expArr[j]=Integer.parseInt(dataArray[i]);
       }

       j=0;
    for(i=1;i<dataArray.length;i=i+2,j++)
       {
         salArr[j]=Integer.parseInt(dataArray[i]);
       }
          System.out.println();

          for(i = 0;i<expArr.length;i++){
            System.out.print(expArr[i]+" ");
            System.out.print(salArr[i]);
            System.out.println();
          }

          double xbartot=0,ybartot=0;
          for(i=0;i<expArr.length;i++)
          {
            xbartot+=expArr[i];
            ybartot+=salArr[i];
          }

          double xbar = (double)(xbartot/expArr.length);
          double ybar = (double)(ybartot/salArr.length);

        System.out.println("expArr Mean: "+xbar);
        System.out.println("salArr Mean: "+ybar);

        double numo=0,deno=0;

        for(i=0;i<expArr.length;i++)
        {
            numo+=(expArr[i]-xbar)*(salArr[i]-ybar);
            deno+=Math.pow((expArr[i]-xbar),2);
        }

        double w1 = numo/deno;
        double w0 = ybar-(w1*xbar);
          System.out.println("w1: "+w1);
          System.out.println("w0: "+w0);

            System.out.println("Please Input the Value of Experience to Get Prediction of Salary: ");
            Scanner sc = new Scanner(System.in);
            int exp = sc.nextInt();

            System.out.println("Prediction is: "+ (int)(w0+w1*exp)*1000);



    }
}
