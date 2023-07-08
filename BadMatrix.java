public class BadMatrix {
    private int[][] data;
    public BadMatrix(int[][] a) {this.data = a;}

    public int[][] getData() {return data;}
    public int[][] plus(int[][] b) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this.data[i][j] += b[i][j];
        return this.data;
    }
    public int[][] times(int[][] b) {
        int[][] a = new int[this.data.length][b[0].length];
        for (int i = 0; i < this.data.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                a[i][j] = 0;
                for (int k = 0; k < b.length; k++)
                    a[i][j] += this.data[i][k] * b[k][j];
            }
        this.data=a;
        return this.data;
    }
    public void print() {System.out.print(this);}
    public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(String.format("%n"));
		for (int[] row:this.data){
			for (int a:row)
				str.append(a).append(" ");
			str.deleteCharAt(str.length()-1).append(String.format("%n"));
		}
        return str.toString();
    }
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {return false;}
        return this.toString().equals(o.toString());
    }
}