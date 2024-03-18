
public class Game extends Main {
	
	Main main;
    public Game(Main main) {
        this.main = main;
    }
	public boolean gameRules() {
		for(Node p = dummy; p!=null;) {
			for(int i = 1; i<16 ;i++) {
				if(p.next.data==i) {
					p=p.next;
				}
				else return false;
			}
			return true;
		}
		return true;
	}
	public String checkGameRules() {
		if(!gameRules())
			return "Failed, Try Again!";
		
			return "You Won";
	}
}