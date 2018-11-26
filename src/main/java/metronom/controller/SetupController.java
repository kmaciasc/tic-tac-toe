package metronom.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import metronom.exception.TicTacToeException;
import metronom.model.Board;
import metronom.model.Player;
import metronom.util.Util;
import metronom.view.TicTacToeView;

public class SetupController {

	private static final String GAME_BOARD_SIZE = "game.board.size";
    private static final String GAME_PLAYER_FIRST = "game.player.human.first";
    private static final String GAME_PLAYER_SECOND = "game.player.human.second";
    private static final String GAME_PLAYER_COMPUTER = "game.player.computer";


	private TicTacToeView view;
	private Properties properties = new Properties();
	private FileInputStream fileInput = null;

	public SetupController() {
		view = new TicTacToeView();
		this.loadConfigFile();
	}

	private void loadConfigFile() {
		try {
			File file = new File("application.properties");
			fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);

		} catch (FileNotFoundException e) {
			throw new TicTacToeException("We're unable to find the file "+ e.getLocalizedMessage());
		} catch (IOException e) {
			throw new TicTacToeException(e.getLocalizedMessage());
		} finally{
        	if(fileInput!=null){
        		try {
        			fileInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
       }
	}

	public Board loadBoard () {
		String boardSize = properties.getProperty(GAME_BOARD_SIZE);
		int size;
		Board board = null;

		if (Util.isNumber(boardSize)) {
			size = Integer.parseInt(boardSize);
			if (Util.isValidBoardSize(size)) {
				board = new Board(size, size);
			} else {
				throw new TicTacToeException("TicTacToe cannot be initialized.\nThe size of the board must be between 3 and 10");
			}
		} else {
			throw new TicTacToeException("TicTacToe cannot be initialized.\nThe size of the board must be a number");
		}

		return board;
	}

	public List<Player>loadPlayers () {
		Set<Player> result = new HashSet<Player>();
		Player firstPlayer = new Player(getFirstHumanPlayerMarker(), true);
		result.add(firstPlayer);
		Player secondPlayer = new Player(getSecondHumanPlayerMarker(), true);

		if (firstPlayer.equals(secondPlayer))
			throw new TicTacToeException("First and second player have the same marker");

		result.add(secondPlayer);
		Player computerPlayer = new Player(getComputerPlayerMarker(), false);

		if (result.contains(computerPlayer))
            throw new TicTacToeException("Computer marker already exists");

		result.add(computerPlayer);

		return new ArrayList<Player>(result);
	}


	private Character getFirstHumanPlayerMarker() {
		String value = properties.getProperty(GAME_PLAYER_FIRST);

		if (value == null || value.trim().isEmpty()) {
			view.displayMessage("Unable to read first player, please review the config file");
        }
        return value.charAt(0);
	}

	private Character getSecondHumanPlayerMarker() {
		String value = properties.getProperty(GAME_PLAYER_SECOND);

		if (value == null || value.trim().isEmpty()) {
			view.displayMessage("Unable to read second player, please review the config file");
        }
        return value.charAt(0);
	}

	private Character getComputerPlayerMarker() {
		String value = properties.getProperty(GAME_PLAYER_COMPUTER);

		if (value == null || value.trim().isEmpty()) {
			view.displayMessage("Unable to read computer player, please review the config file");
        }
        return value.charAt(0);
	}

}
