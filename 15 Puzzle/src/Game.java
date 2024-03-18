
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
}