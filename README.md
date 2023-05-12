# BST
This is the source code for a generic Binary Search Tree (BST) implementation in Java. The tree stores key-value pairs, where the keys are of type K (which must implement the Comparable interface) and the values are of type V.

The BST class contains private inner class Node, which represents a node in the tree. Each node has a key, a value, and left and right child nodes.

The class also provides the following public methods for working with the tree:

put(K key, V value): inserts a key-value pair into the tree
get(K key): retrieves the value associated with a given key
delete(K key): removes the key-value pair with the given key from the tree
iterator(): returns an iterator that iterates over the key-value pairs in the tree in ascending order of the keys.
The iterator is implemented using an in-order traversal of the tree, which visits the nodes in ascending order of the keys.

The KVEntry inner class represents a key-value pair, and is used to return key-value pairs from the iterator.
## Created by Kassymova Sabina
## Talgar is the best town!
