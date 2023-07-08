public class Board {
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameWinStrategy_HVD winStrategy;
	protected GameWinStrategy_HV winStrategyHv;
	protected Player player = Player.X;
	int size;
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy,GameWinStrategy_HV winStrategyHv0) {
		size=boardSize;
		cells = new char[boardSize][boardSize];
		winStrategyHv=winStrategyHv0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				cells[i][j] = '_';
			}
		}

		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;
	}
	public Result0 nextMove(String move, String game_mode) {
		chessStrategy.putChess(cells, nextPlay(), move, game_mode);
		return game_mode.charAt(1)=='0'?winStrategy.check(cells,size):winStrategyHv.check(cells,size);
	}
	protected Player nextPlay() {
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	public void print() {
		System.out.print(" ");
		for (int i = 0; i < size; i++) System.out.printf(" %c",(char) (i+65));
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < size; j++) {
				System.out.print(" " + cells[i][j]);
			}
			System.out.println();
		}
	}
}