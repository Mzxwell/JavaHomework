public class DLL extends linkList {
    public DLL(node head) {
        this.head = head;
        tail = head;
        while (tail.righ != null) {
            tail = tail.righ;
        }
    }

    public void add(@org.jetbrains.annotations.NotNull node node) {
        tail.righ = node;
        node.left = tail;
        tail = tail.righ;
    }

    public linkList swap(node left) {
        if (head.equals(left)) {
            left.left = left.righ;
            left.righ = left.left.righ;
            left.left.left = null;
            left.left.righ = left;
            head = left.left;
        } else {
            left.left.righ = left.righ;
            left.righ = left.righ.righ;
            left.left.righ.righ = left;
            left.left.righ.left = left.left;
            left.left = left.left.righ;
        }
        if (left.righ != null) left.righ.left = left;
        else tail = left;
        return this;
    }

    public void print(node cursor) {
        while (cursor != null) {
            System.out.print(cursor.num);
            cursor = cursor.left;
        }
        System.out.println();
    }
}