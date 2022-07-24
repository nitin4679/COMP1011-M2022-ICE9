package ca.georgiancollege.comp1011m2022ice9;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/* Singleton*/
public class SceneManager
{
    /********************** SINGLETON SECTION **************************/
    //step 1- private static instance member variable
    private static SceneManager m_instance = null;
    //step2 - make the default constructor private
    private SceneManager(){}
    //step3 - create a public static entry point / instance method
    public static SceneManager Instance()
    {
        //step4 - check if the private instance member variable is null
        if(m_instance == null)
        {
            //step5 - Instantiate a new DBManager instance
            m_instance = new SceneManager();
        }
        return m_instance;
    }
    /********************************************************************* */

    /**
     * This method will change new scene passes into it as an argument
     * @param event
     * @param FXMLFileName
     */
    public void changeScene(ActionEvent event, String FXMLFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(FXMLFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //derive the stage (window) from the action event (button press)
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
