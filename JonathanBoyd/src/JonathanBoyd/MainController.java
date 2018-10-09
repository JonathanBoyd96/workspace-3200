package JonathanBoyd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController 
{
	@FXML Label lblName;
	@FXML TextField txtName;
	@FXML Button submitbtn;

	public void onSubmit()
	{
		System.out.println("Test");
		String name = txtName.getText();
		lblName.setText("Hello " + name);
	}
}
