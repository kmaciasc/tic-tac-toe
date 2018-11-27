package metronom.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import metronom.model.Player;

public class SetupControllerTest {
	
	SetupController setUpController = new SetupController();
	Properties props = new Properties();

	
	@Before
	public void init () throws FileNotFoundException, IOException {
		props.load(new FileReader(new File("testing.properties")));
		setUpController.setProperties(props);
	}
	
	@Test
	public void shouldLoadBoard() throws FileNotFoundException, IOException {
		
		Assert.assertTrue(setUpController.loadBoard().getCols() == 10);
	}
	
	@Test
	public void shouldLoadPlayers() {
		List<Player> players =  setUpController.loadPlayers();
		
		Assert.assertTrue(players.size() == 3);
	}
}
