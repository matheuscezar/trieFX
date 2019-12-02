/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triefx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Suporte
 */
public class FileUtils {
        
    public void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
              triefx.TrieFX.PALAVRA = linha;
              goToTrie(linha);
              triefx.TrieFX.CURRENT_NODE = triefx.TrieFX.ROOT;
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    private void goToTrie(String linha) {
            char[] linhaChar = linha.toCharArray();
            for(int i = 0; i < linhaChar.length; i++){
                if(i==(linhaChar.length-1)){
                    triefx.TrieFX.CURRENT_NODE.inserirCaractere(String.valueOf(linhaChar[i]), true);
                }
                else{
                  triefx.TrieFX.CURRENT_NODE.inserirCaractere(String.valueOf(linhaChar[i]), false);  
                }
            }
    }
 
    
}
