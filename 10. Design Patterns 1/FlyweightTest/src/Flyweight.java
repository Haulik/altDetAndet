public class Flyweight {
    private static final String colors[] = { "Green", "Orange"};
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for(int i=0; i < 1000000; ++i) {
            Tree tree = (Tree)Factory.getTree(colors[(int)(Math.random()*colors.length)]); //(10m)60707 61920 (1m)6147 6337 (100k) 708
            //Tree tree = new Tree(colors[(int)(Math.random()*colors.length)]); //(10m)61454 64119 (1m)6185 6183 (100k) 705
            tree.setSize((int)(Math.random()*10));
            tree.draw();
        }

        long end = System.currentTimeMillis();

        System.out.println("Samlet tid: "+(end-start));
    }
}