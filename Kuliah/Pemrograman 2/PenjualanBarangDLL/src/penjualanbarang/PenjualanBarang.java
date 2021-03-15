package penjualanbarang;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PenjualanBarang {
    
   public static void main(String[] args) {
        File fileinput = new File("databarang.txt");//file yang dibaca
        Dlist L=new Dlist();L.head =null;L.tail = null;
        try
        {   Scanner scanfile = new Scanner(fileinput);
            int total=0;
            while (scanfile.hasNextLine()) //Check token berikutnya
            { Node data=new Node();
              data.nama = scanfile.nextLine();
              data.cacah = Integer.valueOf(scanfile.nextLine());
              total+=data.cacah;
              data.prev = null; 
              data.next = null;
              L.insertSorted(data);
            }
            System.out.println("Total jumlah barang = "+total);
        }
        catch (FileNotFoundException error) {
        System.out.println("File not found");
          }    
     L.printNode();
     int n=L.getLength();
     System.out.println("Macam barang = "+n);
     Scanner input=new Scanner(System.in);
     System.out.print("nama barang = ");
     String nm = input.nextLine();
     L.binarySearch(1,n,nm);
     //L.binarySearchC(nm);
    }    
}
