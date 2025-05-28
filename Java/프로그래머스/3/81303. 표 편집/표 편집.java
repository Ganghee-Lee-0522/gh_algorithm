import java.util.*;

class Solution {
    class Node {
        int idx;
        Node prev, next;
        Node(int idx) {
            this.idx = idx;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deleted = new Stack<>();
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for(int i = 1; i < n; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }
        Node cur = nodes[k];
        
        for(String c : cmd) {
            char ch = c.charAt(0);
            if(ch == 'U') {
                int x = Integer.parseInt(c.substring(2));
                while(x > 0) {
                    x--;
                    cur = cur.prev;
                }
            }
            else if(ch == 'D') {
                int x = Integer.parseInt(c.substring(2));
                while(x > 0) {
                    x--;
                    cur = cur.next;
                }
            }
            else if(ch == 'C') {
                deleted.push(cur);
                if(cur.prev != null) {
                    cur.prev.next = cur.next;
                }
                if(cur.next != null) {
                    cur.next.prev = cur.prev;
                }
                if(cur.next != null) {
                    cur = cur.next;
                }
                else {
                    cur = cur.prev;
                }
            }
            else if(ch == 'Z') {
                Node node = deleted.pop();
                if(node.prev != null) {
                    node.prev.next = node;
                }
                if(node.next != null) {
                    node.next.prev = node;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] result = new boolean[n];
        for(Node node : deleted) {
            result[node.idx] = true;
        }
        for(boolean b : result) {
            if(b) {
                sb.append('X');
            }
            else {
                sb.append('O');
            }
        }
        
        return sb.toString();
    }
}