// Move To Last
// Send Feedback
// Given a linked list and a key in it, the task is to move all occurrences of given key to end of linked list, keeping order of all other elements same.
// Return the updated head of LL.
// Input Format :
// Line 1 : Elements of the linked list ending with -1 (-1 not included)
// Line 2 : Key n, Element which has to shifted
// Output Format :
// Updated linked list
// Constraints :
// 1 <= size of list <= 100
// Sample Input 1:
// 1 2 2 3 4 5 -1
// 2
// Sample Output 1:
// 1 3 4 5 2 2 
// Sample Input 2:
// 1 1 2 3 4 -1
// 1
// Sample Output 2:
// 2 3 4 1 1

/***********
 
Following is the Linked list node structure already written 
 
class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
		 this.data=data;
	 }
}

************/


/*public class Solution {


	public static Node<Integer> func(Node<Integer> head,int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        
       		
	/*public class Solution {
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
	if(head == null || head.next == null)
            return head;
 
        LinkedListNode<Integer> prev = head;    
        LinkedListNode<Integer> p = head.next;
 
        while(p != null){
            if(p.data.compareTo(prev.data) == 0)//compare non primitive dataType like this not using == (VERY IMPORTANT THING TO NOTE)
            {
                prev.next = p.next;
                p = p.next;
            }
            else{
                prev = p;
                p = p.next; 
            }
        }
       return head;
    }
    }*/
/***********
 
Following is the Linked list node structure already written 
 
class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
		 this.data=data;
	 }
}

************/


public class Solution {


	public static Node<Integer> func(Node<Integer> head,int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Node<Integer>temp=head,prev=null,last=null;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        last=temp;
        temp=head;
        // int flag=0
        for(int i=0;i<len;i++){
            // flag=0
            if(temp.data==n){
                if(prev==null){
                    Node<Integer>temp2=new Node<Integer>(temp.data);
                    head=head.next;
                    last.next=temp2;
                    prev=null;
                    temp=head;
                }else{
                    Node<Integer>temp2=new Node<Integer>(temp.data);
                    prev.next=temp.next;
                    last.next=temp2;
                    temp=temp.next;
                }
                last=last.next;
            }else{
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
       		
	}

}

