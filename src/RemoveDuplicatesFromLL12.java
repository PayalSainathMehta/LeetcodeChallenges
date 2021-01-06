
public class RemoveDuplicatesFromLL12 {

    //keep one duplicate
    public ListNode removeDuplicates1(ListNode head){
        //returns 1->2->3 for 1->1->2->3
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next; //keep doing till duplicate
            curr = curr.next;
        }
        return head;
    }

    //keep no duplicates
     public ListNode removeDuplicates2(ListNode head) {
        //returns 2->3 for 1->1->2->3
        if(head == null || head.next == null)
            return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode prev = phead;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val)
                curr = curr.next; //move till duplicate, now curr is at second 1 of 1->1->2->3
            if (prev.next == curr) //no duplicate found
                prev = prev.next; //hence just move forward
            else
                prev.next = curr.next; //when found, skip
            curr = curr.next;
        }
        return phead.next;
    }

    /*
        HELPER METHODS
    */

    public void createList(ListNode l1)
    {
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
    }

    public void printList(ListNode n)
    {
        while(n.next != null)
        {
            System.out.print(n.val + "->");
            n = n.next;
        }
        System.out.print(n.val);
    }

    public static void main(String[] args)
    {
        RemoveDuplicatesFromLL12 obj = new RemoveDuplicatesFromLL12();
        ListNode l1 = new ListNode(1);
        obj.createList(l1);
        obj.printList(obj.removeDuplicates1(l1));
        System.out.println();
        obj.createList(l1);
        obj.printList(obj.removeDuplicates2(l1));
    }
}
