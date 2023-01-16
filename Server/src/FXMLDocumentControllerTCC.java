
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FXMLDocumentControllerTCC implements Initializable {
    String site=null, url_App=null;
    private int[] iVetor = null;
    private int[] cVetor = null;
    RealizaConexao rConexao = new RealizaConexao();
    //private Atalho atalho = new Atalho(KeyCode.UNDEFINED);
    
    @FXML
    private Pane pnCapturaTeclado;

    @FXML
    private TextField campoAtalho;
    
    @FXML
    private Pane principal;
    
    @FXML
    private Pane pnSelecionaSite;

    @FXML
    private TextField campoURL;

    @FXML
    private GridPane grade;

    @FXML
    private Button bt12;

    @FXML
    private Button bt7;

    @FXML
    private Button bt3;

    @FXML
    private Button bt14;

    @FXML
    private Button bt11;

    @FXML
    private Button bt6;

    @FXML
    private Button bt8;

    @FXML
    private Button bt2;

    @FXML
    private Button bt4;

    @FXML
    private Button bt9;

    @FXML
    private Button bt5;

    @FXML
    private Button bt10;

    @FXML
    private Button bt13;

    @FXML
    private Button bt1;
    
    
    
    @FXML
    void funcBTs(String btIP){
        
    }
    
    @FXML
    void funcBT1(ActionEvent event) {
        
    }

    @FXML
    void funcBT10(ActionEvent event) {

    }

    @FXML
    void funcBT11(ActionEvent event) {

    }

    @FXML
    void funcBT12(ActionEvent event) {

    }

    @FXML
    void funcBT13(ActionEvent event) {

    }

    @FXML
    void funcBT14(ActionEvent event) {

    }

    @FXML
    void funcBT15(ActionEvent event) {

    }

    @FXML
    void funcBT2(ActionEvent event) {

    }

    @FXML
    void funcBT3(ActionEvent event) {

    }

    @FXML
    void funcBT4(ActionEvent event) {

    }

    @FXML
    void funcBT5(ActionEvent event) {

    }

    @FXML
    void funcBT6(ActionEvent event) {

    }

    @FXML
    void funcBT7(ActionEvent event) {

    }

    @FXML
    void funcBT8(ActionEvent event) {

    }

    @FXML
    void funcBT9(ActionEvent event) {

    }
       
    @FXML
    void selecionaApp() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FXMLDocumentControllerTCC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFileChooser sA = new JFileChooser();

        File archivo = sA.getSelectedFile();

        sA.setDialogTitle("Escolher Arquivo");

        int a = sA.showOpenDialog(null);

        if (a == JFileChooser.APPROVE_OPTION) {
            url_App = sA.getSelectedFile().getAbsolutePath();

//          System.out.println(url_App);
//          btOpenApp.setVisible(true);
//          lbCaminhoApp.setText(url_App);
        }
    }
    @FXML
    void abreApp(int btIP){
        try {
            java.awt.Desktop.getDesktop().open(new File(url_App));
          } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerTCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void fecharTelaSite(ActionEvent event) {
        campoURL.setText("");
        pnSelecionaSite.setVisible(false);
        principal.setVisible(true);
    }
    
    @FXML
    void setSite(){
        site = campoURL.getText();
        bt1.getText();
//      lbCaminhoSite.setText(site);
        principal.setVisible(true);
        pnSelecionaSite.setVisible(false);
    }
    
    @FXML
    void selectSite() {
        campoURL.setText("");
        pnSelecionaSite.setVisible(true);
        principal.setVisible(false);
    }
    
    @FXML
    void fecharTelaAtalho(ActionEvent event) {
        campoAtalho.setText("");
        pnCapturaTeclado.setVisible(false);
        principal.setVisible(true);
    }
        
    @FXML
    void abreLink(int btIP){         
        try {
            Desktop.getDesktop().browse(new java.net.URI(site));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FXMLDocumentControllerTCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @FXML
    void definirAtalho(ActionEvent event) {
        pnCapturaTeclado.setVisible(true);
        principal.setVisible(false);
        String txtCampoAtalho = null;        
        int contWhile = 0;
        
        this.campoAtalho.setOnKeyPressed((javafx.scene.input.KeyEvent evento) -> {
            if (evento.getCode().equals(KeyCode.ENTER)) {
                //Comunicador.getConfiguracoes_teclas_de_atalho().delegar_foco(this);
            } else {
//                atalho = new Atalho(evento);
//                entrada_de_texto.setText(atalho.toString());
            }   
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                
    }
}
