
public class Game extends Main {
	
	Main main;
    public Game(Main main) {
        this.main = main;
    }
	public boolean gameRules() {
		for(int i = 0; i<15; i++) {
			if(main.getData(i)!=i+1) return false;
		}
		return true;
	}
	public String checkGameRules() {
		if(!gameRules())
			return "Failed, Try Again!";
		
			return "You Won";
	}
	
	public boolean isValidMove(int zeroIndex, int nodeIndex) {
		
		if (zeroIndex == 0) {
            if(nodeIndex == 1 || nodeIndex == 4) return true;
        }
		if (zeroIndex == 1) {
            if(nodeIndex == 0 || nodeIndex == 5 || nodeIndex == 2) return true;
        }
        if (zeroIndex == 2) {
            if(nodeIndex == 1 || nodeIndex == 6 || nodeIndex == 3) return true;
        }
        if (zeroIndex == 3) {
            if(nodeIndex == 2 || nodeIndex == 7) return true;
        }
        if (zeroIndex == 4) {
            if(nodeIndex == 0 || nodeIndex == 5 || nodeIndex == 8) return true;
        }
        if (zeroIndex == 5) {
            if(nodeIndex == 4 || nodeIndex == 1 || nodeIndex == 6 || nodeIndex == 9) return true;
        }
        if (zeroIndex == 6) {
            if(nodeIndex == 5 || nodeIndex == 2 || nodeIndex == 7 || nodeIndex == 10) return true;
        }
        if (zeroIndex == 7) {
            if(nodeIndex == 3 || nodeIndex == 6 || nodeIndex == 11) return true;
        }
        if (zeroIndex == 8) {
            if(nodeIndex == 4 || nodeIndex == 9 || nodeIndex == 12) return true;
        }
        if (zeroIndex == 9) {
            if(nodeIndex == 8 || nodeIndex == 5 || nodeIndex == 10 || nodeIndex == 13) return true;
        }
        if (zeroIndex == 10) {
            if(nodeIndex == 9 || nodeIndex == 6 || nodeIndex == 11 || nodeIndex == 14) return true;
        }
        if (zeroIndex == 11) {
            if(nodeIndex == 7 || nodeIndex == 10 || nodeIndex == 15) return true;
        }
        if (zeroIndex == 12) {
            if(nodeIndex == 8 || nodeIndex == 13) return true;
        }
        if (zeroIndex == 13) {
            if(nodeIndex == 12 || nodeIndex == 9 || nodeIndex == 14) return true;
        }
        if (zeroIndex == 14) {
            if(nodeIndex == 13 || nodeIndex == 10 || nodeIndex == 15) return true;
        }
        if (zeroIndex == 15) {
            if(nodeIndex == 11 || nodeIndex == 14) return true;
        }
		return false;
	}
}