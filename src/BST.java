import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.KVEntry>{
    private Node root;

    private class Node {
        private K key;
        private V value;


        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

        }
        @Override
        public String toString() {
            return '(' +
                    "key=" + key +
                    ", value=" + value +
                    ')';
        }
    }

    public void put(K key, V value) {
        root = putHidden(root, key, value);
    }

    private Node putHidden(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            node.left=putHidden(node.left, key, value);
        }
        else if(cmp>0){
            node.right=putHidden(node.right, key, value);
        }
        else{
            node.value=value;
        }
        return node;
    }



    public V get(K key) {
        Node node=getHidden(root,key);
        return node==null?null:node.value;
    }

    private Node getHidden(Node node, K key) {
        Node currNode=node;
        while(currNode!=null){
            int cmp = key.compareTo(currNode.key);
            if(cmp<0){
                currNode=currNode.left;
            }
            else if(cmp>0){
                currNode=currNode.right;
            }
            else{
                return currNode;
            }
        }
        return null;
    }

    public void delete( K key){
        root=deleteHidden(root, key);
    }

    private Node deleteHidden(Node node, K key) {
        if(node==null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            node.left=deleteHidden(node.left, key);
        }
        else if(cmp>0){
            node.right=deleteHidden(node.right, key);
        }
        else{
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = deleteMin(node.right);
            }
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            return node;
        }
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

public Iterator<BST.KVEntry> iterator(){
        return new InOrderTraversal();
}

    private class InOrderTraversal implements Iterator<BST.KVEntry> {
        private Stack<Node> nodes = new Stack<>();

        public InOrderTraversal() {
            pushAll(root);
        }

        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        @Override
        public KVEntry next() {
            Node node = nodes.pop();
            pushAll(node.right);
            return new KVEntry(node.key, node.value);
        }

        private void pushAll(Node node) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
        }


    }
    public class KVEntry{
        private K key;
        private V val;
        public KVEntry(K k, V v){
            this.key=k;
            this.val=v;
        }
        @Override
        public String toString() {
            return '(' +
                    "key=" + key +
                    ", value=" + val +
                    ')';
        }
    }

}
