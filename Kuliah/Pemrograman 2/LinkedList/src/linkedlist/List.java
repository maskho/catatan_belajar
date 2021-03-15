package linkedlist;

class Node {
    int data;
    Node next; //LINK
}
class List {
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
	    tail = input;	//maka input akan di belakang dan menjadi tail
	}
    }

    void insertAfter(int key,Node input){
  	Node temp = head;
  	do {
   	    if (temp.data == key){	//Jika data sama dengan key, maka input
   		input.next = temp.next; //disambung diantara temp dan temp.next
   		temp.next = input;
   		System.out.println("Insert data is succeed.");
   		break;	//dari temp --> temp.next menjadi :
   		}			//temp --> input --> temp.next
   	    temp = temp.next;
  	}
  	while (temp!=null);
    }
    void insertBefore(int key,Node input){
 	Node temp = head;
 	while (temp != null){
 	    if ((temp.data == key)&&(temp == head)){
 	        addFirst(input);	/* jika insert pada awal linked list
 							maka call method addFirst */
 	        System.out.println("Insert data is succeed.");
 	        break;
 	    }
 	    else if (temp.next.data == key){
 		input.next = temp.next;	//dari temp --> temp.next menjadi
 		temp.next = input;			//temp --> input --> temp.next
 		System.out.println("Insert data is succeed.");
 		break;
 	    }
 	    temp = temp.next;
 	}
    }
    void insertSorted(Node input){
        if (isEmpty()){	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
	}
	else {
          if(input.data<head.data)
              addFirst(input);
          else 
            if(input.data>=tail.data) 
               addLast(input);
            else{
              Node temp=head;
              while(temp.next.data<=input.data) temp=temp.next;
              input.next=temp.next;
              temp.next=input;
            }
	}
    }
    void removeFirst(){
  	if (!isEmpty()){
   	    if (head == tail){		//jika element linked list hanya 1,
    		head = tail = null;		//maka head dan tail menjadi null
   	    }				//sehingga linked list kosong
   	    else {
	        head = head.next;		//kemudian head dipindah ke temp
	    }
  	}
  	else System.out.println("Data is empty!");
    }

    void removeLast(){
  	Node temp = head;
  	if (!isEmpty()){
   	    if (tail == head){		//jika element linked list hanya 1
    		head = tail = null;		//maka head dan tail menjadi null
   	    }				//sehingga linked list kosong
   	    else {
    	        while (temp.next != tail) temp = temp.next;	//memajukan temp hingga satu elemen
  						//sebelum tail.
    		temp.next = null; //temp.next di-null,dan jadi akhir LL
    		tail = temp;		//tail dipindah ke temp
   	    }
  	}
  	else System.out.println("Data is empty!");
    }

    void remove(int key){
 	Node temp = head;
 	if (!isEmpty()){
 	    while (temp != null){
 	        if (head.data==key){
 		   removeFirst();//jika key berada pada awal linked list,
 		   break;		//maka call method removeFirst
 		} else
                  if (temp.next!=null&&temp.next.data == key){	//mengganti temp.next dengan
 		    temp.next = temp.next.next; //temp.next.next
 		   // break;	//dari temp --> temp.next -->temp.next.next
 		  }			//menjadi temp --> temp.next.next
                 else
 		   temp = temp.next;
 	    }
 	} else System.out.println("Data is empty!");
    }
    boolean prime(int n){
      boolean prima;int p;
      if ((n==2)||(n==3)) prima=true;
      else if ((n%2==0)||(n<2)) prima=false;
       else
       { p=3;prima=true;
         do {
	   if ((n%p)==0) prima=false;
             else p=p+2;
	    }
	  while ( prima && p<=(Math.sqrt(n)+1));
       }
        return prima;
    }
 
    void removeAllPrime(){
 	Node temp = head;
 	if (!isEmpty()){
 	    while (temp != null){
 	        if (prime(head.data)){
                    head=head.next;
 		} else
                  if (temp.next!=null&&prime(temp.next.data)){	
 		    temp.next = temp.next.next; 
 		  }			
                 else
 		   temp = temp.next;
 	    }
 	} else System.out.println("Data is empty!");
    }

    void find(int key){
  	int i = 1;
  	boolean found = false;
  	Node temp = head;
  	while (temp != null){
   	    if (temp.data == key){
    	       found = true;
    		break;
   	    }
   	    i++;
   	    temp = temp.next;
  	}
  	if (found){
   	    System.out.println(key+" is found at node "+i);
  	}
  	else System.out.println("Data isn't found");
    }
   int findMax(){
  	Node temp = head;
        int max=head.data;
  	while (temp != null){
   	    if (temp.data>max)  max = temp.data;
   	    temp = temp.next;
  	}
        return max;
    }
    int findMin(){
  	Node temp = head;
        int min=head.data;
  	while (temp != null){
   	    if (temp.data<min)  min = temp.data;
   	    temp = temp.next;
  	}
        return min;
    }
    void removeMin(){
        remove(findMin());
    }
    
    void mergeList(List L1,List L2){  
        Node t; 
        do{
          if (L1.head.data<=L2.head.data) {
            t=L1.head;
            L1.removeFirst();
            addLast(t);
          } else {
            t=L2.head;
            L2.removeFirst();
            addLast(t);
          } 
        }
      while ((L1.head!=null) && (L2.head !=null));
      if (L1.head==null) 
          do {
             t=L2.head;
             this.addLast(t);
             L2.removeFirst();
          } while (L2.head!=null);
          else
          do {
             t=L1.head;
             this.addLast(t);
             L1.removeFirst();
          } while (L1.head!=null);
          
    }
void mergeListC(List L1,List L2){  
        Node t; 
        do{
          if (L1.head.data<=L2.head.data) {
            t=L1.head;
            L1.removeFirst();
            addLast(t);
          } else {
            t=L2.head;
            L2.removeFirst();
            addLast(t);
          } 
        }
      while ((L1.head!=null) && (L2.head !=null));
      if (L1.head==null) 
          {
           tail.next=L2.head;
           tail=L2.tail;L2.head=L2.tail=null;
          } 
          else {
           tail.next=L1.head;
           tail=L1.tail;L1.head=L1.tail=null;
          }       
    }
    
    int getLength(Node a) {
		int c = 0;
		Node t = a;
		while (t != null) { c++; t=t.next;}
		return c;
        }
   int length() {
		int c = 0;
		Node t = head;
		while (t != null) { c++; t=t.next;}
		return c;
        }
         
    Node mergeR(Node a, Node b) {
		Node result;
		if (a == null) return b;
		if (b == null) return a;
		   if (a.data <= b.data) {
			result = a;
			result.next = mergeR(a.next,b);
		    } 
                            else {
			result = b;
			result.next = mergeR(a,b.next);
		    }
		return result;
        }

        
    Node merge(Node a, Node b) {
		Node result=null,temp,p=null;
                do {
		   if (a.data <= b.data) {
			temp = a;a=a.next;
		    } 
                    else {
			temp = b;b=b.next;
		    }
                   if(result==null&&p==null) {result=temp;p=temp;}else {p.next =temp;p=p.next;}
                }
                while((a!=null)&&(b!=null));   
                if (a == null) p.next = b;
		if (b == null) p.next = a;
		return result;
        }
    Node mergeSort(Node a){
            if (a.next == null) return a;
            else {
              int mid = getLength(a) / 2;
              Node L1 = a;
              Node t = a;
              while (mid - 1 > 0) { t = t.next;mid--;}
              Node L2 = t.next;
              t.next = null;
              Node l1 = mergeSort(L1);
              Node l2 = mergeSort(L2);
              return merge(l1, l2);
	    }
        }
 	
    void printNode(){
  		Node temp= head;
  		while (temp != null){
   			System.out.print(temp.data+" ");
   			temp = temp.next;
  		}
                System.out.println();
 	}
}


