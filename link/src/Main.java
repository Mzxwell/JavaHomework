public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        linkList linkList = new linkList(new node());
        for (int i=1;i<4;i++){linkList.add(new node(i,null,null));}
        linkList.print();
        linkList.swap(linkList.head).print();
        linkList.swap(linkList.head.righ.righ).print();
        DLL dll =  new DLL(new node());
        for (int i=1;i<4;i++){dll.add(new node(i,null,null));}
        dll.print();
        dll.print(dll.tail);
        dll.swap(dll.head).print();
        dll.print(dll.tail);
        dll.swap(dll.head.righ.righ).print();
        dll.print(dll.tail);
    }
}