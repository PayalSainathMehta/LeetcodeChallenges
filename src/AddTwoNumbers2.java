import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers2 {

    //7-2-4-3 + 5-6-4 = 7-0-8-7
    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0);
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty())
                sum += s1.pop();
            if(!s2.isEmpty())
                sum += s2.pop();
            l3.val = sum % 10;
            ListNode temp = new ListNode(sum / 10);
            temp.next = l3;
            l3 = temp;
            sum = sum / 10;
        }
        //remove leading zeroes
        return l3.val == 0 ? l3.next : l3;
    }

    public static void printList(ListNode l1, ListNode l2)
    {
        ListNode n = addTwoNumbers(l1, l2);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(l1, l2);
    }
}
