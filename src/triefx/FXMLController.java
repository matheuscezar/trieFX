package triefx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAutocompletar;

    @FXML
    private TextField edtPrefixo;
    
    @FXML
    private TextField edtPath;

    @FXML
    private TextField edtQtd;

    @FXML
    private ListView<?> listResultados;


    @FXML
    void initialize() {
        assert btnAutocompletar != null : "fx:id=\"btnAutocompletar\" was not injected: check your FXML file 'FXML.fxml'.";
        assert edtPrefixo != null : "fx:id=\"edtPrefixo\" was not injected: check your FXML file 'FXML.fxml'.";
        assert edtQtd != null : "fx:id=\"edtQtd\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listResultados != null : "fx:id=\"listResultados\" was not injected: check your FXML file 'FXML.fxml'.";
                FileUtils file = new FileUtils();
        triefx.TrieFX.CURRENT_NODE = triefx.TrieFX.ROOT;
        try {
            file.leitor(edtPath.getText());

        } catch (IOException ex) {
            System.out.println("Erro na abertura do arquivo: " + ex.getMessage());
        }


    }
    
    @FXML
    public void autocompletar(){
        triefx.TrieFX.SUGESTOES =  FXCollections.observableArrayList();
        String prefix = edtPrefixo.getText();
        triefx.TrieFX.CURRENT_NODE = triefx.TrieFX.ROOT;
        char[] prefixChar = prefix.toCharArray();
        for (int i = 0; i < prefixChar.length; i++) {
            triefx.TrieFX.CURRENT_NODE.buscarCaractere(String.valueOf(prefixChar[i]));

        }
        if (triefx.TrieFX.CURRENT_NODE.IsWord()) {
            triefx.TrieFX.SUGESTOES.add(triefx.TrieFX.CURRENT_NODE.getPalavraFinal());
        }
        triefx.TrieFX.CURRENT_NODE.autocompletar(triefx.TrieFX.CURRENT_NODE);
        try {
                ObservableList tmp = FXCollections.observableArrayList();
                for (int i = 0; i < Integer.parseInt(edtQtd.getText()); i++) {
                tmp.add(triefx.TrieFX.SUGESTOES.get(i));
                
            }
                listResultados.setItems(tmp);
        
            
        } catch (Exception e) {
             listResultados.setItems(triefx.TrieFX.SUGESTOES);
        }

    }
    }


