public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        linkList list = new linkList(new node());
        for (int i=1;i<4;i++){list.add(new node(i,null,null));}
        list.print();
        list.swap(list.head).print();
        list.swap(list.head.righ.righ).print();
        DLL dll =  new DLL(new node());
        for (int i=1;i<4;i++){dll.add(new node(i,null,null));}
        dll.print();
        dll.print(dll.tail);
        dll.swap(dll.head).print();
        dll.print(dll.tail);
        dll.swap(dll.head.righ.righ).print();
        dll.print(dll.tail);
        linkList linkList2 = new linkList(new node());
        for (int i=2;i<30;i+=2)linkList2.add(new node(i,null,null));
        linkList linkList3 = new linkList(new node());
        for (int i=3;i<30;i+=3)linkList3.add(new node(i,null,null));
        linkList2.print();
        linkList3.print();
        linkList.intersect(linkList2,linkList3).print();
        linkList2.print();
        linkList3.print();
        linkList u=linkList.union(linkList2,linkList3);
        u.print();
        linkList2.print();
        linkList3.print();
        u.reverse().print();
        linkList3.reverse().print();
    }
}