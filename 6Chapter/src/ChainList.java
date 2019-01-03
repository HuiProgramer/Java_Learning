public class ChainList {
    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        System.out.println("--------------add--------------");
        nm.add(5);
        nm.add(4);
        nm.add(3);
        nm.add(2);
        nm.add(1);
        nm.print();
        System.out.println("--------------del--------------");
        nm.del(5);
        nm.print();
        System.out.println("-------------find--------------");
        System.out.println(nm.find(5));
        System.out.println("-------------update------------");
        nm.update(4, 10);
        nm.print();
        System.out.println("-------------insert------------");
        nm.insert(3, 0);
        nm.print();
    }
}

class NodeManager {
    private Node root;//根节点
    private int currentIndex = 0;//每次操作都从0开始

    //添加
    public void add(int data) {
        if (null == root) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    //删除
    public void del(int data) {
        if (null == root) return;
        if (data == root.getData()) {
            root = root.next;
        } else {
            root.delNode(data);
        }
    }

    //更新数据
    public boolean update(int oldData, int newData) {
        if (null == root) {
            return false;
        }
        if (oldData == root.getData()) {
            root.data = newData;
            return true;
        } else {
            return root.updateNode(oldData, newData);
        }

    }

    //查找节点
    public boolean find(int data) {
        if (null == root) {
            return false;
        }
        if (data == root.getData()) {
            return true;
        } else {
            return root.findNode(data);
        }
    }

    //插入数据(往后插)
    public void insert(int index, int data) {
        if (index < 0) return;
        currentIndex = 0;
        if (index == currentIndex) {
            Node newNode = new Node(data);
            newNode.next = root.next;
            root.next = newNode;
        } else {
            root.insertNode(index, data);
        }
    }

    //打印所有数据
    public void print() {
        if (null != root) {
            System.out.print(root.getData() + "->");
            root.printNode();
            System.out.println("结束");
        }
    }


    private class Node {
        private int data;
        private Node next;//下一个节点

        public Node(int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        //增加节点
        public void addNode(int data) {
            if (null == this.next) {
                this.next = new Node(data);
            } else {
                this.next.addNode(data);
            }

        }

        //删除节点
        public void delNode(int data) {
            if (null != this.next) {
                if (data == this.next.data) {
                    this.next = this.next.next;
                } else {
                    this.next.delNode(data);
                }
            }
        }

        //输出节点
        public void printNode() {
            if (null != this.next) {
                System.out.print(this.next.data + "->");
                this.next.printNode();
            }
        }

        //查找节点是否存在
        public boolean findNode(int data) {
            if (null != this.next) {
                if (data == this.next.getData()) {
                    return true;
                } else {
                    return this.next.findNode(data);
                }
            }
            return false;
        }

        //更新数据
        public boolean updateNode(int oldData, int newData) {
            if (null != this.next) {
                if (oldData == this.next.getData()) {
                    this.next.data = newData;
                    return true;
                } else {
                    return this.next.updateNode(oldData, newData);
                }
            }
            return false;
        }

        //插入节点
        public void insertNode(int index, int data) {
            currentIndex++;
            if (index == currentIndex) {
                Node newNode = new Node(data);
                newNode.next = this.next.next;
                this.next.next = newNode;
            } else {
                this.next.insertNode(index, data);
            }
        }
    }
}
