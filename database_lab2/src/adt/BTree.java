package adt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;  

public class BTree{  
    private BTNode root = null;  
    private int t;  
    private final int fullNum;  
  
    /**
     * @param t The index of middle element(start with 1).
     */
    public BTree(int t) {  
        this.t = t;  
        fullNum = 2 * t - 1;  
    }  
  
    private final BTNode NullBTNode = new BTNode();  
  
    private class BTNode {
        private int number = 0;  
        private List<Integer> keys = new ArrayList<Integer>();
        private List<String> values = new ArrayList<String>();
        private List<BTNode> children = new ArrayList<BTNode>();  
        private boolean isLeaf = false;  
  
        int getKey(int i) {  
            return keys.get(i);  
        }
        
        String getValue(int i) {  
            return values.get(i);  
        }
  
        BTNode getChildren(int i) {  
            return children.get(i);  
        }  
  
        void AddKey(int i, int key, String value) {  
            keys.add(i, key);
            values.add(i, value);
        }  
  
        void removeKey(int i) {  
            keys.remove(i);
            values.remove(i);
        }  
  
        void AddChildren(int i, BTNode c) {  
            children.add(i, c);  
        }  
  
        void removeChildren(int i) {  
            children.remove(i);  
        }  
  
        boolean isFull() {  
            if (number == fullNum)  
                return true;  
            return false;  
        }  
  
        int getSize() {  
            return keys.size();  
        }  
  
        boolean isNull() {  
            return (this == NullBTNode);  
        }  
  
        @Override  
        public String toString() {  
            if (number == 0)  
                return "NullNode";  
  
            StringBuilder sb = new StringBuilder();  
            sb.append("[N: " + number + "] [keys: ");  
            for (int e : keys) {  
                sb.append(e + ", ");  
            }
            sb.append(" ] [ values: ");
            for (String e : values) {  
                sb.append(e + ", ");  
            }
            sb.append(" ] [ children: ");  
            for (BTNode bNode : children) {  
                if (bNode == NullBTNode)  
                    sb.append(bNode + ", ");  
                else  
                    sb.append("NotNullNode" + ", ");  
            }  
            sb.append("] [childrenSize: " + children.size());  
            sb.append("] [ isLeaf: " + isLeaf);  
            sb.append("]");  
            return sb.toString();  
        }  
    }  
  
    // Generate the root node  
    private void constructRoot(int key, String value) {  
        root = new BTNode();  
        root.number = 1;  
        root.AddKey(0, key, value);  
        root.isLeaf = false;  
    }  
  
    private void addElemToNode(BTNode node, int key, String value, int i) {  
        node.AddKey(i, key, value);  
        node.number++;  
        node.AddChildren(i, NullBTNode);  
    }  
  
    public void insertElem(int key, String value) {
        if (root == null) {  
            // The first node  
            constructRoot(key, value);  
            root.isLeaf = true;  
            root.AddChildren(0, NullBTNode);  
            root.AddChildren(1, NullBTNode);  
            return;
        }  
  
        BTNode curNode = root;
  
        if (root.isFull()) {  
            // Extend the root  
            constructRoot(curNode.getKey(t - 1), curNode.getValue(t - 1));  
  
            // Get new node  
            BTNode newNode = getExtendedNode(curNode);  
  
            // Process old full node  
            processFullNode(curNode);  
  
            // Process root  
            root.AddChildren(0, curNode);  
            root.AddChildren(1, newNode);  
//            return;  
        }
        
        curNode = root;
        int i = 0;  
        BTNode childNode = null;  
        // Find the node to insert  
        while (true) {  
            while ((i < curNode.getSize())  
                    && (key > curNode.getKey(i))) {  
                i++;  
            }  
  
            childNode = curNode.getChildren(i);  
            if (childNode.isFull()) {  
                // Split the node  
  
                // Add the element to parent  
                curNode.number++;  
                curNode.AddKey(i, childNode.getKey(t - 1), childNode.getValue(t - 1));  
  
                // New node for extension  
                BTNode newNode = getExtendedNode(childNode);  
  
                // Process old full node  
                processFullNode(childNode);  
  
                // Add the new node for parent reference  
                curNode.AddChildren(i + 1, newNode);  
  
                // Down to low layer  
                if (key < curNode.getKey(i)) {  
                    curNode = childNode;  
                } else {  
                    curNode = newNode;  
                }  
                i = 0;  
                continue;  
            }  
  
            // Down to child node  
            if (!childNode.isNull()) {  
                curNode = childNode;  
                i = 0;  
                continue;  
            }  
  
            // Insert the element in current node  
            addElemToNode(curNode, key, value, i);  
            return;  
        }  
  
    }
    
    public boolean deleteElem(int key) {
    	BTNode curNode = root;
    	BTNode fatherNode = null;
    	BTNode brotherNode = null;
    	int i = 0;
        // Find the node
        while (true) {
            while ((i < curNode.getSize())  
                    && (key >= curNode.getKey(i))) {
            	if(key == curNode.getKey(i)) {
            		curNode.number--;
            		curNode.removeKey(i);
            		if(curNode.getSize() > (t-1)) {
            			return true;
            		}
            		if(!curNode.isLeaf) {
            			BTNode childNode = curNode.getChildren(i+1);;
            			fatherNode = curNode;
            			brotherNode = curNode.getChildren(i);
            			while(!childNode.isLeaf) {
            				fatherNode = childNode;
            				brotherNode = childNode.getChildren(1);
            				childNode = childNode.getChildren(0);
            			}
            			int moveKey = childNode.getKey(0);
            			String moveValue = childNode.getValue(0);
            			childNode.number--;
            			childNode.removeKey(0);
            			curNode.number++;
            			curNode.AddKey(i, moveKey, moveValue);
            			if(childNode.getSize() > (t-1)) {
                			return true;
                		} else {
                			if(brotherNode.getSize() > (t-1)) {
                				i = childNode.getSize();
                				moveKey = fatherNode.getKey(0);
                				moveValue = fatherNode.getValue(0);
                				childNode.number++;
                				childNode.AddKey(i, moveKey, moveValue);
                				moveKey = brotherNode.getKey(0);
                				moveValue = brotherNode.getValue(0);
                				fatherNode.number++;
                				fatherNode.AddKey(0, moveKey, moveValue);
                				brotherNode.number--;
                				brotherNode.removeKey(0);
                				return true;
                			} else {
                				i = childNode.getSize();
                				moveKey = fatherNode.getKey(0);
                				moveValue = fatherNode.getValue(0);
                				childNode.number++;
                				childNode.AddKey(i, moveKey, moveValue);
                				for(int j = 0; j < brotherNode.getSize(); j++) {
                					i = childNode.getSize();
                					moveKey = brotherNode.getKey(j);
                    				moveValue = brotherNode.getValue(j);
                    				childNode.number++;
                    				childNode.AddKey(i, moveKey, moveValue);
                				}
                				fatherNode.number--;
                				fatherNode.removeKey(0);
                				fatherNode.removeChildren(1);
                				return true;
                			}
                		}
            		} else {
            			if(fatherNode.getChildren(0).equals(curNode)) {
            				if(brotherNode.getSize() > (t-1)) {
            					i = curNode.getSize();
            					int moveKey = fatherNode.getKey(0);
            					String moveValue = fatherNode.getValue(0);
            					curNode.number++;
            					curNode.AddKey(i, moveKey, moveValue);
            					moveKey = brotherNode.getKey(0);
            					moveValue = brotherNode.getValue(0);
            					fatherNode.removeKey(0);
            					fatherNode.AddKey(0, moveKey, moveValue);
            					brotherNode.number--;
            					brotherNode.removeKey(0);
            				} else {
            					i = curNode.getSize();
            					int moveKey = fatherNode.getKey(0);
            					String moveValue = fatherNode.getValue(0);
            					curNode.number++;
            					curNode.AddKey(i, moveKey, moveValue);
            					for(int j = 0; j < brotherNode.getSize(); j++) {
                					i = curNode.getSize();
                					moveKey = brotherNode.getKey(j);
                    				moveValue = brotherNode.getValue(j);
                    				curNode.number++;
                    				curNode.AddKey(i, moveKey, moveValue);
                				}
            					fatherNode.number--;
            					fatherNode.removeKey(0);
            					fatherNode.removeChildren(1);
            				}
            			} else {
            				if(brotherNode.getSize() > (t-1)) {
            					int fatherIndex = 0;
            					while(fatherIndex < fatherNode.getSize()) {
            						if(fatherNode.getChildren(fatherIndex).equals(brotherNode)
            								|| fatherNode.getChildren(fatherIndex).equals(curNode)) {
            							break;
            						} else {
            							fatherIndex++;
            						}
            					}
            					int brotherIndex = brotherNode.getSize();
            					int moveKey = fatherNode.getKey(fatherIndex);
            					String moveValue = fatherNode.getValue(fatherIndex);
            					curNode.number++;
            					curNode.AddKey(0, moveKey, moveValue);
            					moveKey = brotherNode.getKey(brotherIndex-1);
            					moveValue = brotherNode.getValue(brotherIndex-1);
            					fatherNode.number--;
            					fatherNode.removeKey(fatherIndex);
            					fatherNode.number++;
            					fatherNode.AddKey(fatherIndex, moveKey, moveValue);
            					brotherNode.number--;
            					brotherNode.removeKey(brotherIndex-1);
            					return true;
            				} else {
            					int fatherIndex = 0;
            					while(fatherIndex < fatherNode.getSize()) {
            						if(fatherNode.getChildren(fatherIndex).equals(brotherNode)
            								|| fatherNode.getChildren(fatherIndex).equals(curNode)) {
            							break;
            						} else {
            							fatherIndex++;
            						}
            					}
            					int moveKey = fatherNode.getKey(fatherIndex);
            					String moveValue = fatherNode.getValue(fatherIndex);
            					curNode.number++;
            					curNode.AddKey(0, moveKey, moveValue);
            					for(int j = brotherNode.getSize()-1; j >= 0; j--) {
            						moveKey = brotherNode.getKey(j);
                					moveValue = brotherNode.getValue(j);
                					curNode.number++;
                					curNode.AddKey(0, moveKey, moveValue);
            					}
            					fatherNode.number--;
            					fatherNode.removeKey(fatherIndex);
            					fatherNode.removeChildren(fatherIndex);
            					return true;
            				}
            			}
            		}
            	} else {
            		i++;
            	}
            }
            if(curNode.isLeaf == false) {
            	fatherNode = curNode;
            	if(i == 0) {
            		brotherNode = curNode.getChildren(1);
            	} else {
            		brotherNode = curNode.getChildren(i-1);
            	}
            	curNode = curNode.getChildren(i);
                i = 0;
                continue;
            } else {
            	return false;
            }
        }
    }
    
    public String searchValue(int key) {
    	BTNode curNode = root;
        int i = 0;
        // Find the node
        while (true) {  
            while ((i < curNode.getSize())  
                    && (key >= curNode.getKey(i))) {
            	if(key == curNode.getKey(i)) {
            		return curNode.getValue(i);
            	} else {
            		i++;
            	}
            }
            if(curNode.isLeaf == false) {
            	curNode = curNode.getChildren(i);
                i = 0;
                continue;
            } else {
            	return null;
            }
        }
    }
  
    private BTNode getExtendedNode(BTNode fullNode) {  
        BTNode newNode = new BTNode();  
        newNode.number = t - 1;  
        newNode.isLeaf = fullNode.isLeaf;  
        for (int i = 0; i < t; i++) {  
            if (i != t - 1) {  
                newNode.AddKey(i, fullNode.getKey(t + i), fullNode.getValue(t + i));  
            }  
            newNode.AddChildren(i, fullNode.getChildren(t + i));  
        }  
        return newNode;  
    }  
  
    // Should be called after calling getExtendedNode()  
    private void processFullNode(BTNode fullNode) {  
        fullNode.number = t - 1;  
        for (int i = t - 1; i >= 0; i--) {  
            fullNode.removeKey(t + i - 1);  
            fullNode.removeChildren(t + i);  
        }  
    }  
  
    @Override  
    public String toString() {  
        if (root == null)  
            return "NULL";  
  
        StringBuilder sb = new StringBuilder();  
  
        LinkedList<BTNode> queue = new LinkedList<BTNode>();  
        queue.push(root);  
  
        BTNode tem = null;  
        while ((tem = queue.poll()) != null) {  
            for (BTNode node : tem.children) {  
                if (!node.isNull())  
                    queue.offer(node);  
            }  
            sb.append(tem.toString() + "\n");  
        }  
        return sb.toString();  
    }  

    // test
    public static void main(String[] args) {  
        BTree tree = new BTree(3);  
        System.out.println(tree);  
        int[] kL = {5, 6, 7, 8, 9, 3, 4, 10, 11, 12, 13, 2, 1};
        String[] vL = {"e", "f", "g", "h", "i", "c", "d", "j", "k", "l", "m", "b", "a"};  
        for (int i = 0; i < kL.length; i++) {  
            tree.insertElem(kL[i], vL[i]);  
            System.out.println("After insert the: <" + kL[i] + ", " + vL[i] + ">");  
            System.out.println(tree);  
        }
        System.out.println(tree.searchValue(1));
        System.out.println(tree.searchValue(5));
        System.out.println(tree.searchValue(15));
        
        int deleteKey = 9;
        tree.deleteElem(deleteKey);
        System.out.println("After delete the key: <" + deleteKey + ">");  
        System.out.println(tree);
        
        deleteKey = 11;
        tree.deleteElem(deleteKey);
        System.out.println("After delete the key: <" + deleteKey + ">");  
        System.out.println(tree);
    }
}