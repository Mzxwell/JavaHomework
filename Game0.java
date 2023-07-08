public class Game0 {
    public Result0 playGame(String gameMode, String moveStr, int size){
		GameChessStrategy gameChessStrategy = new GameChessStrategy();
		GameWinStrategy_HVD gameWinStrategyHvd = new GameWinStrategy_HVD();
		GameWinStrategy_HV gameWinStrategyHv = new GameWinStrategy_HV();
		Board board = new Board(size,gameChessStrategy,gameWinStrategyHvd,gameWinStrategyHv);

		String[] moves = moveStr.split(",");
		Result0 res = Result0.GAMING;
		for(String move: moves){
			res = board.nextMove(move,gameMode);
			board.print();
			if( !res.equals(Result0.GAMING) )
				break;
		}
		return res;
    }
}