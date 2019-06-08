public class Tree implements Shape {
    private String color;
    private int Size;

    public Tree(String color){
        this.color = color;
    }

    public void setSize(int size) {
        this.Size = size;
    }

    @Override
    public void draw() {
        System.out.println("Tree Draw: [Color : " + color + ", Size : " + Size + " Meter Tall" );
    }
}