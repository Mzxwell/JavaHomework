public class linkList {
    public node head, tail;
    public linkList(){}

    public linkList(node head) {
        this.head = head;
        tail = head;
        while (tail.righ != null) {
            tail = tail.righ;
        }
    }

    public void add(node node) {
        tail.righ = node;
        tail = tail.righ;
    }

    public void print() {
        node cursor = head;
        while (cursor != null) {
            System.out.print(cursor.num);
            cursor = cursor.righ;
        }
        System.out.println();
    }

    public linkList swap(node left) {
        node previous = head;
        if (head.equals(left)){
            head=left.righ;
            previous.righ =head.righ;
            head.righ =previous;
        }else {
            while (!previous.righ.equals(left)){previous=previous.righ;}
            previous.righ =left.righ;
            left.righ =left.righ.righ;
            previous.righ.righ =left;
        }
        return this;
    }
}