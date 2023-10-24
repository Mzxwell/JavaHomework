import org.jetbrains.annotations.NotNull;

public class linkList {
    public node head, tail;

    public linkList() {
    }

    public linkList(node head) {
        this.head = head;
        tail = head;
        while (tail.righ != null) {
            tail = tail.righ;
        }
    }

    public void add(node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.righ = node;
        tail = tail.righ;
    }

    public void print() {
        node cursor = head;
        while (cursor != null) {
            System.out.print(cursor.num + " ");
            cursor = cursor.righ;
        }
        System.out.println();
    }

    public linkList swap(node left) {
        node previous = head;
        if (head.equals(left)) {
            head = left.righ;
            previous.righ = head.righ;
            head.righ = previous;
        } else {
            while (!previous.righ.equals(left)) {
                previous = previous.righ;
            }
            previous.righ = left.righ;
            left.righ = left.righ.righ;
            previous.righ.righ = left;
        }
        return this;
    }

    public static @NotNull linkList intersect(@NotNull linkList L1, @NotNull linkList L2) {
        node L1C = L1.head, L2C = L2.head;
        linkList result = new linkList();
        while (L1C != null && L2C != null) {
            if (L1C.num == L2C.num) result.add(new node(L1C.num, null, null));
            if (L1C.num <= L2C.num) L1C = L1C.righ;
            else L2C = L2C.righ;
        }
        return result;
    }

    public static linkList union(@NotNull linkList L1, @NotNull linkList L2) {
        node L1C = L1.head, L2C = L2.head, cursor;
        linkList result;
        for (result = new linkList(new node()); L1C != null && L2C != null; )
            if (L1C.num < L2C.num) {
                result.add(new node(L1C.num, null, null));
                L1C = L1C.righ;
            } else {
                result.add(new node(L2C.num, null, null));
                L2C = L2C.righ;
            }
        for (cursor = L1C == null ? L2C : L1C; cursor != null; cursor = cursor.righ)
            result.add(new node(cursor.num, null, null));
        if (result.head != null) for (cursor = result.head; cursor.righ != null; cursor = cursor.righ)
            while (cursor.num == cursor.righ.num) cursor.righ = cursor.righ.righ;
        return result;
    }
    public linkList reverse(){
        if(head==null||head.righ==null)return this;
        node c1=head,c2 = c1.righ,c3=c2.righ;
        c1.righ=null;
        tail=c1;
        c2.righ=c1;
        while (c3!=null){
            c1=c2;
            c2=c3;
            c3=c3.righ;
            c2.righ=c1;
        }
        head=c2;
        return this;
    }
}