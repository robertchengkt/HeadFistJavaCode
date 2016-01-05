import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom> ();
	private int numOfGusses = 0;

	private void setUpGame(){
		DotCom one = new DotCom();
		one.setName = ("xVideo.com");
		DotCom two = new DotCom();
		two.setName = ("Pornhub.com");
		DotCom three = new DotCom();
		three.setName = ("ponr.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("xVedio.com, Pornhub.com, ponr.com");
		System.out.println("Try to sink them all with the fewest number of gusses");

		for (DotCom dotComToSet: dotComsList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}

	private void startPlaying(){
		while (!dotComsList.isEmpty()){
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess){
		numOfGusses++;
		String result = "miss";

		for (DotCom dotComtoTest : dotComsList){
			result = dotComtoTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}

			if (result.equals("kill")) {
				dotComsList.remove(dotComtoTest);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame(){
		System.out.println("All Dot Coms are Dead! Your stock is now worthless.");
		if (numOfGusses <= 18) {
			System.out.println("It only took you " + numOfGusses + " guesses.");
			System.out.println("Good job!");
		} else {
			System.out.println("Took you long enough. " + numOfGusses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

	public static void main (String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}