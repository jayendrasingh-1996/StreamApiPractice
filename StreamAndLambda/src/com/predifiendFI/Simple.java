package com.predifiendFI;

import java.util.*;
import java.util.Map.Entry;
/*[14:54] Chandan Kumar - S

 Given a string s containing just the characters '(', ')', '{​​', '}​​', '[' and ']', determine if the input string is valid.
 
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{​​}​​"
Output: true
Example 3:
Input: s = "(]"
Output: false
(((()))
(((}​​)({​​)))



valid ->   ({)}  -> }{
 
 * */

class Node{
	int val;
	Node next;
	public Node(int val) {
		this.val=val;
		this.next=null;
	}
	
}
class LinkedlistImpl
{
	 Node curr=null;
	public void add(int val) {
		Node impl=new Node(val);
		if(curr==null)
			{
				curr=impl;
				return;
			}
		impl.next=curr;
		curr=impl;
	}
	
	public void print() {
		Node temp=curr;
		while(temp!=null) {
			System.out.print(temp.val+" ,");
		     temp=temp.next;
		}
	}
	public void reversePrint() {
		Stack<Node> s=new Stack<>();
		Node temp=curr;
		while(temp!=null) {
			s.add(temp);
		     temp=temp.next;
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop().val+" ,");
		}
	}

}

public class Simple {
	public static void main(String[] args) {
	     LinkedlistImpl obj=new LinkedlistImpl();
	     obj.add(1);
	     obj.add(2);
	     obj.add(3);
	     obj.add(4);
	     obj.add(5);
	     System.out.println("print in input order");
	      obj.print();
		   System.out.println("\nprint in reverse order");
		     obj.reversePrint();
	}

}









