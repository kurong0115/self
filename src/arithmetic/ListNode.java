package arithmetic;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution1{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        ListNode tmp = null;
        int num = 0;
        while (l1 != null || l2 != null || num > 0){
            int a = (l1 == null)? 0: l1.val;
            int b = (l2 == null)? 0: l2.val;
            int sum = a + b + num;
            if (sum >= 10){
                sum -= 10;
                num = 1;
            } else{
                num = 0;
            }
            tmp = new ListNode(sum);
            root.next = tmp;
            root = root.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return cur.next;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || num > 0){
            int a1 = (i >= 0)? Integer.valueOf(a.substring(i, i + 1)): 0;  //1 1
            int b1 = (j >= 0)? Integer.valueOf(b.substring(j, j + 1)): 0;  //1 0
            int sum = a1 + b1 + num;
            if (sum >= 2){
                sum -= 2;
                num = 1;
            } else{
                num = 0;
            }
            i--;
            j--;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    public static int toNum(String a){
        int sum = 0;
        for (int i = a.length() - 1; i >= 0; i--){
            if (Integer.valueOf(a.substring(i)) > 0){
                sum += Math.pow(2.0, a.length() - 1 - i);
            }
        }
        return sum;
    }

    public static String toBinary(int num){
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num >= 1){
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    /**
     * 合并两个有序列表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                root.next = l2;
                l2 = l2.next;
            } else {
                root.next = l1;
                l1 = l1.next;
            }
            root = root.next;
        }
        while (l1 != null){
            root.next = l1;
            root = root.next;
            l1 = l1.next;
        }
        while (l2 != null){
            root.next = l2;
            root = root.next;
            l2 = l2.next;
        }
        return cur.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l1.next = l2;
//        l2.next = l3;
//        l4.next = l5;
//        l5.next = l6;
//        ListNode root = addTwoNumbers(l1, l4);
//        while (root != null){
//            System.out.println(root.val);
//            root = root.next;
//        }

//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);
//        ListNode root = addTwoNumbers(l1, l2);
//        while (root != null){
//            System.out.println(root.val);
//            root = root.next;
//        }
        System.out.println(toNum("1100"));
        System.out.println(toBinary(1));

        System.out.println(addBinary("11", "1"));

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode root = mergeTwoLists(l1, l4);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}