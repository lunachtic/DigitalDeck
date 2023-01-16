package Grade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jSON {

    JSONArray jsonA;
    FileWriter writeFile = null;
    FileReader arq;
    BufferedReader lerArq;
    JSONObject objJSON;
    File file;
    
    
    public void setJSONButton(JSONObject button, int btPosicao) {
        try {
            this.jsonA.put(btPosicao, button);
        } catch (JSONException ex) {
            System.out.println("A variavel 'btPosicao' não possui elemento válido");
        }
    }
    
    public JSONObject getJSONButton(int btPosicao) {
        try {
            arq = new FileReader(file);
            lerArq = new BufferedReader(arq);
            try {
                JSONObject button = this.jsonA.getJSONObject(btPosicao);
                System.out.println(button);
                return button;
            } catch (JSONException ex) {
                setJSONArrayFile();
                JSONObject button;
                try {
                    button = jsonA.getJSONObject(btPosicao);
                    System.out.println(button);
                    return button;
                } catch (JSONException ex1) {
                    return null;
                }
            }
        } catch (FileNotFoundException ex) {
            criarJSON();
        }
        return null;
    }

    public void setJSONArrayFile() {
        try {
            arq = new FileReader(file);
            lerArq = new BufferedReader(arq);
            try {
                String linha = lerArq.readLine();
                this.jsonA = new JSONArray(linha);
                System.out.println(jsonA);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(jSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            criarJSON();
        }
    }

    public void verificarJSON() {
        this.file = new File("C:\\Users\\Dell-Lucas\\Documents\\NetBeansProjects\\TCC\\grade.json");
        if (file.exists()) {
            setJSONArrayFile();
        } else {
            criarJSON();
        }
    }

    private void criarJSON() {
        JSONObject jsonF = new JSONObject();
        jsonA = new JSONArray();
        for (int i = 0; i < 15; i++) {
            try {
                jsonF.put("funcTipo", "0");
                jsonF.put("funcDetalhes", "null");
                jsonA.put(jsonF);
                try {
                    writeFile = new FileWriter("grade.json");
                    //Escreve no arquivo conteudo do Objeto JSON
                    writeFile.write(jsonA.toString());
                    writeFile.close();
                } catch (IOException e) {
                    System.out.println("ERRO para criar arquivo");
                }
            } catch (JSONException ex) {
                Logger.getLogger(jSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(jsonA);
    }
}
