import java.io.ByteArrayInputStream;

public class DuckTest {
    public static void main(String[] args){
        duck a =new duck();
        System.out.printf("%d",a.getDuck_count());
        duck c=new duck();
        System.out.printf("%d%d",c.getDuck_count(),a.getDuck_count());
        int[][] data = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        BadMatrix matrix = new BadMatrix(data);
        BadMatrix result0 = new BadMatrix(matrix.plus(matrix.getData()));
        BadMatrix result1 = new BadMatrix(matrix.times(matrix.getData()));
        result1.print();
        result0.print();
        MyMatrix myMatrix = new MyMatrix(data);
        myMatrix.plus(myMatrix.times(myMatrix.times(myMatrix.getData()[0][0]))).transpose().print();
        String input = "3 3" + String.format("%n") + "1 1 1" + String.format("%n") + "1 1 1" + String.format("%n") + "1 1 1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        myMatrix.plusFromConsole().print();
        ByteArrayInputStream inputStream0 = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream0);
        myMatrix.timesFromConsole().print();
        System.out.printf((new Game0().playGame("11","C5,D5,E6,D4,B6,E4,D6,C4",9)).name());
        dog0 dog0 = new dog0();
        dog0.size =5;
        dog0.bark();
        dog0.aVoid();
        dog0.bark();
    }
}
