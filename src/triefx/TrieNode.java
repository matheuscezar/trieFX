/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triefx;

import java.util.ArrayList;

/**
 *
 * @author Suporte
 */
class TrieNode {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

import java.util.ArrayList;
import trie.Trie;


/**
 *
 * @author Suporte
 */

    boolean isWord;
    ArrayList<TrieNode> children;
    String text;
    String palavraFinal;

    public boolean IsWord() {
        return isWord;
    }

    public String getPalavraFinal() {
        return palavraFinal;
    }
    
    
    
    public TrieNode(String text){
        this.text = text;
        children = new ArrayList();
    }

    public TrieNode() {
        children = new ArrayList();
    }

    public String getText() {
        return text;
    }
   
    public void inserirCaractere(String caractere, boolean isWord){
        if(triefx.TrieFX.CURRENT_NODE.buscarCaractere(caractere)){
            //System.out.println("Caractere já cadastrado");
        } else {
            triefx.TrieFX.CURRENT_NODE.children.add(new TrieNode(caractere));
            triefx.TrieFX.CURRENT_NODE = triefx.TrieFX.CURRENT_NODE.children.
                    get(triefx.TrieFX.CURRENT_NODE.children.size()-1);      
        }
        if(isWord){
                triefx.TrieFX.CURRENT_NODE.isWord = true;
                triefx.TrieFX.CURRENT_NODE.palavraFinal = triefx.TrieFX.PALAVRA;
            }
    }

    public boolean buscarCaractere(String caractere) {
        for (int i = 0; i < triefx.TrieFX.CURRENT_NODE.children.size(); i++) {
            String aux = triefx.TrieFX.CURRENT_NODE.children.get(i).text;
            if(caractere.equals(aux)) {
               triefx.TrieFX.CURRENT_NODE = triefx.TrieFX.CURRENT_NODE.children.get(i);
                return true;
            }
        }
        return false;
    }

    public void autocompletar(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.size(); i++) {
            if(currentNode.children.get(i).isWord) triefx.TrieFX.SUGESTOES.add(currentNode.children.get(i).palavraFinal);
            TrieNode newCurrentNode = currentNode.children.get(i);
            currentNode.children.get(i).autocompletar(newCurrentNode);
        }
    }

}
    




