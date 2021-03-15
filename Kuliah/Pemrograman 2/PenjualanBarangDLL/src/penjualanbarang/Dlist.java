package penjualanbarang;
class Node {
    String nama;
    int cacah;
    Node next,prev;
}
public class Dlist {
  Node head;
  Node tail;
    boolean isEmpty(){
      return (head==null);
    }    
  void addFirst(Node input){
  		if (isEmpty()){	//Jika linked list masih kosong,
   			head = input;	//maka head dan tail sama dengan node input
   			tail = input;
  		}
  		else {
   			input.next = head;	//Jika linked list sudah berisi,
   			head.prev = input;
                        head = input;	//maka input akan di depan dan menjadi head
  		}
 	}
    void addLast(Node input){
		if (isEmpty()){	//Jika linked list masih kosong,
			head = input;	//maka head dan tail sama dengan node input
			tail = input;
		}
		else {
			tail.next = input;	//Jika linked list sudah berisi,
			input.prev = tail;
                        tail = input;	//maka input akan di belakang dan menjadi tail
		}
	}

     void insertSorted(Node input){
         if (isEmpty()){	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
	}
	else {
          if(input.nama.compareTo(head.nama)<0) 
              this.addFirst(input);
          else 
            if(input.nama.compareTo(tail.nama)>0) 
                 this.addLast(input);
            else{
              Node t=head;
              while(t.nama.compareTo(input.nama)<0) t=t.next;
              if(t.nama.compareTo(input.nama)==0){
                  t.cacah += input.cacah;
              } else {
                  input.next=t;
                  t.prev.next = input;
                  input.prev = t.prev;
                  t.prev=input;
              }
            }
	}
        }
      void printNode(){
  		Node temp;
  		temp = head;
  		while (temp != null){
   			System.out.println(temp.nama+" "+temp.cacah);
   			temp = temp.next;
  		}
                System.out.println();
 	}
    int getLength() {
		int c = 0;
		Node t = head;
		while (t != null) { c++; t=t.next;}
		return c;
        }
        
    void binarySearchR(int aw,int ak,String key){
      if (aw <= ak) {
        int mid = (aw+ak)/2;
        System.out.println(aw+" "+mid+" "+ak);
        Node t = head;int i=mid-1;
        while (i > 0) { t = t.next;i--;}        
        if (t.nama.equalsIgnoreCase(key)) {
          System.out.println("nama barang = "+t.nama);
          System.out.println("cacah barang = "+t.cacah);  
        }
        else 
          if (t.nama.compareTo(key)>0)
            binarySearchR(aw,mid-1,key);
          else
            binarySearchR(mid+1,ak,key);
      } else
      System.out.println("Barang tidak ada ");
    }	  
    void binarySearch(int aw,int ak,String key){
      while (aw <= ak) {
        int mid = (aw+ak)/2;
        System.out.println(aw+" "+mid+" "+ak);
        Node t = head;int i=mid-1;
        while (i > 0) { t = t.next;i--;}        
        if (t.nama.equalsIgnoreCase(key)) {
          System.out.println("nama barang = "+t.nama);
          System.out.println("cacah barang = "+t.cacah);
          break;
        }
        else 
          if (t.nama.compareTo(key)>0)
            ak=mid-1;
          else
            aw=mid+1;
      } 
      if(ak<aw) System.out.println("Barang tidak ada ");
    }	  
    void binarySearchC(String key){
      int aw,ak;
      aw=1;ak=this.getLength();
      int mid = (aw+ak)/2;
      Node t = head;int i=mid-1;
      while (i > 0) { t = t.next;i--;}        
      while (aw <= ak) {
        System.out.println(aw+" "+mid+" "+ak);
        if (t.nama.equalsIgnoreCase(key)) {
          System.out.println("nama barang = "+t.nama);
          System.out.println("cacah barang = "+t.cacah);
          break;
        }
        else 
          if (t.nama.compareTo(key)>0){
            ak=mid-1;
            mid = (aw+ak)/2;i=ak; 
            while (i > mid-1) { t = t.prev;i--;}        
          }   
          else {
            aw=mid+1;
            mid = (aw+ak)/2;i=aw; 
            while (i < mid+1) { t = t.next;i++;}        
          }   
      } 
      if(ak<aw) System.out.println("Barang tidak ada ");
    }
}