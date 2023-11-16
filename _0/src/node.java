public class node {
    public String element;
    public node left, right;

    public node(String element) {
        this.element = element;
    }

    public node(String element, node right, node left) {
        this.element = element;
        this.right = right;
        this.left = left;
    }
    public String tostring(){return (left!=null?"("+left.tostring()+")":"")+element+(right!=null?"("+right.tostring()+")":"");}
}
