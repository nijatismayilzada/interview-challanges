package com.thepot;

import java.util.List;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int smallest = smallestListIndex(lists);
        if(smallest == -1){
            return null;
        }

        ListNode l1 = lists[smallest];
        ListNode lp1 = lists[smallest];
        lists[smallest] = lp1.next;

        while (true) {
            int next = smallestListIndex(lists);
            if (next == -1) {
                break;
            }
            ListNode l2 = lists[next];
            lists[next] = l2.next;

            lp1.next = l2;
            lp1 = lp1.next;
        }

        return l1;
    }


    private int smallestListIndex(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }

        return minIndex;


    }


}