package linkedlist;
import java.util.Scanner;
import java.util.Random;

public class LinkedList {
  
    public static void main(String[] args) {
        //List L=new List();
        List L=new List();
        List L1=new List();
        Clist C=new Clist();
        Scanner input =new Scanner(System.in);
        System.out.print("banyak data = ");
        int n = input.nextInt();
        Random r=new Random();
        for(int i=1;i<=n;i++){
          int rd=r.nextInt(100)+1;
          System.out.print(rd+" ");
          Node p=new Node();p.data=rd;p.next=null;
          // C.insertAfterFirst(p);
          L.insertSorted(p);
          //L.addFirst(p);
         //L.addLast(p);
        }
       System.out.println();
       L.printNode();
     //  int max1=L.findMax();
      // L.remove(max1);
  //     int max2=L.findMax();
  //     L.remove(max2);
        L.removeAllPrime();
        L.printNode();
      //  C.printNode1();
     //   System.out.println();
      //  System.out.print("n = ");
      //  int m = input.nextInt();
       // C.printNodeUts(m);
       // System.out.print("Key = ");
       // int key = input.nextInt();
       // L.removeMin();
       //System.out.println(L.findMax());
       // L.printNode();
      

//     Node inputs=new Node();inputs.data=100;inputs.next=null;
  //    C.insertBefore(key, inputs);
      //  C.findReplace(key,200);
      //C.remove(key);
       //System.out.println();
        //C.printNode();
 //       System.out.println();
  /* 
       System.out.print("banyak data = ");
        int m = input.nextInt();
        for(int i=1;i<=m;i++){
          int rd=r.nextInt(100)+1;
          //System.out.print(rd+" ");
          Node p=new Node();p.data=rd;p.next=null;
          L1.insertSorted(p);
       }
        // System.out.println(L.findMax());
        System.out.println();
        L1.printNode();
        System.out.println();
        List L2=new List();
        System.out.print(" List hasil gabungan : ");
        L2.mergeListC(L, L1);        
        System.out.println();
        L2.printNode();
        L.printNode();
        L1.printNode();

    
     */   
      //int k = input.nextInt();
       //Node q=new Node();q.data=1001;q.next=null;
       //L.insertAfter(k,q);
       //L.insertBefore(k,q);
        //L.removeLast();
        // L.remove(k);
        //L.find(k);
        //System.out.println();
        //double start=System.nanoTime();
        //L.head=L.mergeSort(L.head);
        //double finish=System.nanoTime();
        //System.out.println("waktu proses = "+(finish-start)/1.0E9+" detik");
     //  System.out.println(L.length());
     //  L.printNode();
     }
    
}
