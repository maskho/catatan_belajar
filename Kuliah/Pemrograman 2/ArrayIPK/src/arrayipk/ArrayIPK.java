package arrayipk;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class ArrayIPK {
   public static int n; 
   public static void cetak(float[] a,int n){
      for(int i=0;i<n;i++){
         System.out.print(a[i]+" ");
         if ((i+1)%10==0) System.out.println();
       }
       System.out.println();
   }
    
public static void buangDuplikasi(int[] A){
    int[] T=new int[1000];int i,j,m=0;
    for (i=0;i<A.length-1;i++)
      for (j=i+1;j<A.length;j++)
	  if (A[i]==A[j]) A[j]=0;
    for (i=0;i<A.length;i++)
     if (A[i]!=0) {
	   T[m]=A[i];
	   m++;
      } 
    for (i=0;i<m;i++) {
        A[i]=T[i];
        System.out.print(A[i]+" ");
    }
    System.out.println();
   }
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Banyak data  : ");
       n = input.nextInt();
       int[] A=new int[n];
       Random random=new Random();
       for(int i=0;i<n;i++){
          A[i]= random.nextInt(100)+1;
          System.out.print(A[i]+" ");
       }
      System.out.println();
      buangDuplikasi(A);
       System.out.println();
       System.out.print("Banyak data IPK : ");
       n = input.nextInt();
       float[] x=new float[n];
       for(int i=0;i<n;i++)
          x[i]= random.nextInt(401)/100f;
       cetak(x,n);
       Arrays.sort(x);
       cetak(x,n);
       System.out.print("data IPK yang dicari : ");
       float ip=input.nextFloat();
       System.out.println(Arrays.binarySearch(x,ip));
 }
}
