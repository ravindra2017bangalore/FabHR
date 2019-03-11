package com.csipl.hrms.common.util;


/*
 *  Java Program to Implement Singly Linked List
 */
 
import java.util.Scanner;
 
/*  Class Node  */
class Node
{
    protected int data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
 
/* Class linkedList */
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
  
    /*  Function to insert an element at end  */
    public void append(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
  
    /*  Function to delete the greater value   */
	public void deleteGreaterValue( int value ) {

		Node ptr = start;

		for (int index = 1; index < size; index ++) {
			
			if (value < ptr.getData()) {

				Node previous = getPreviousNode( index );
				
				Node tmp = ptr.getLink() ;
				previous.setLink( tmp.getLink() );
				ptr.setLink( null );
				
				 size--;
			}
			ptr = ptr.getLink();

		}

	}   
    
	
	private Node getPreviousNode( int index ) {
		
		Node ptr = start;
		Node previous = null;
		 for (int i = 1 ; i < size; i++) 
	        {
			  if (i == (index - 1) ) 
	            {
				  previous = ptr;
				  break;
	            }
			  ptr = ptr.getLink();
	        }
		 return previous;
	}
	
    /*  Function to delete an element at position  */
    public void deleteAtLast( )
    {        
    	    Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
     
     
    }  
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
 
/*  Class SinglyLinkedList  */
public class SinglylinkedlistDemo
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
          
            System.out.println("1. Add the element");
            System.out.println("2. delete at Tail");
            System.out.println("3. Delete value greater than target");
                  
            int choice = scan.nextInt();            
            switch (choice)
            {
                                   
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.append( scan.nextInt() );                     
                break;                         
            case 2 : 
                    list.deleteAtLast(  );
                break;
            case 3 : 
            	 System.out.println("Enter intger target value  ");
                 int value = scan.nextInt() ;
            	 list.deleteGreaterValue( value );
                break;                   
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}

