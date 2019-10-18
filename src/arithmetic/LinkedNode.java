package arithmetic;

import java.util.Stack;

public class LinkedNode {
      int val;
      LinkedNode next;
      LinkedNode(int x) { val = x; }
}

class Solution{
    public static LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        LinkedNode root = new LinkedNode(0);
        LinkedNode cur = root;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        putValue(l1, stack1);
        putValue(l2, stack2);
        int num = 0;
        LinkedNode temp = null;
        while (!stack1.empty() && !stack2.empty()){
            int a = stack1.pop();
            int b = stack2.pop();
            int sum = a + b + num;
            if (sum >= 10){
                sum -= 10;
                num = 1;
            } else{
                num = 0;
            }
            temp = new LinkedNode(sum);
            root.next = temp;
            root = root.next;
            if (stack1.empty() && stack2.empty() && num > 0){
                temp = new LinkedNode(num);
                root.next = temp;
                root = root.next;
                num = 0;
            }
        }
        while (!stack1.empty()){
            temp = new LinkedNode(stack1.pop() + num);
            root.next = temp;
            root = root.next;
        }
        while (!stack2.empty()){
            temp = new LinkedNode(stack2.pop() + num);
            root.next = temp;
            root = root.next;
        }
        return cur.next;
    }

    public static void putValue(LinkedNode l, Stack<Integer> stack){
        while (l != null){
            stack.push(l.val);
            l = l.next;
        }
    }

    public static void main(String[] args) {
        LinkedNode l1 = new LinkedNode(2);
        LinkedNode l2 = new LinkedNode(4);
        LinkedNode l3 = new LinkedNode(3);
        LinkedNode l4 = new LinkedNode(5);
        LinkedNode l5 = new LinkedNode(6);
        LinkedNode l6 = new LinkedNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        LinkedNode root = addTwoNumbers(l1, l4);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
//        LinkedNode l1 = new LinkedNode(5);
//        LinkedNode l2 = new LinkedNode(5);
//        LinkedNode root = addTwoNumbers(l1, l2);
//        while (root != null){
//            System.out.println(root.val);
//            root = root.next;
//        }
    }
}
