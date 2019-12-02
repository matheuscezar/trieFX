/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triefx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;

/**
 *
 * @author Suporte
 */
public class TrieFX extends Application {
    
        @Override
    public void start(Stage primaryStage) {
        
        
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TrieFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       //Empregado.listarEmpregados(dao.conexao);
	Scene scene = new Scene(parent);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static final TrieNode ROOT = new TrieNode();
    public static TrieNode CURRENT_NODE;
    public static TrieNode CURRENT_NODE_AUX;
    public static String PALAVRA;
    public static ObservableList SUGESTOES = FXCollections.observableArrayList();
    public static void main(String[] args) {
        launch(args);
    }
    
}
