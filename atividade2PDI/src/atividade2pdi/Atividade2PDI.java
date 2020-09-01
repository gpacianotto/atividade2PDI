/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade2pdi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SAMSUNG
 */
public class Atividade2PDI {

    /**
     * @param args the command line arguments
     */
    public static int lim;
    public static int linha;
    public static int coluna;
    public static int[][][] criaMatriz(Scanner i){
        
        String lixo = i.nextLine();
        //System.out.println(lixo);
        lixo = i.nextLine();
        //System.out.println(lixo);
        
        linha = i.nextInt();
        coluna = i.nextInt();
        
        
        int[][][] Matriz = new int[linha + 1][coluna + 1][3];
        
        
        lim = i.nextInt();
        
        for(int x = 0; x<linha; x++){
            for(int y = 0; y<coluna; y++)
            {
                Matriz[x][y][0] = i.nextInt();
                Matriz[x][y][1] = i.nextInt();
                Matriz[x][y][2] = i.nextInt();
            }
            
        }
        System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        return Matriz;
    }
    public static void salvarImagem(int[][][] imagem, String nameFile){
        
        
        
        try {
        FileWriter fw = new FileWriter(nameFile);
        fw.write("P3");
        fw.write("\n");
        fw.write(Integer.toString(linha));
        fw.write(" ");
        fw.write(Integer.toString(coluna));
        fw.write("\n");
        fw.write(Integer.toString(lim));
        fw.write("\n");
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                    fw.write(imagem[i][j][0] + " ");
                    fw.write(imagem[i][j][1] + " ");
                    fw.write(imagem[i][j][2] + " ");
            }
            //fw.write("\n");
        }
        fw.flush();
        } catch (IOException e) {}
    }
    public static int[][][] filtroVermelho(int[][][] imagem)
    {
        int[][][] vermelha = new int[linha][coluna][3];
        
        for(int i = 0; i<linha; i++)
        {
            for(int j = 0; j < coluna; j++)
            {
                vermelha[i][j][1] = 0;
                vermelha[i][j][2] = 0;
                vermelha[i][j][0] = imagem[i][j][0];
                
            }
        }
        
        return vermelha;
    }
    public static int[][][] filtroVerde(int[][][] imagem)
    {
        int[][][] vermelha = new int[linha][coluna][3];
        
        for(int i = 0; i<linha; i++)
        {
            for(int j = 0; j < coluna; j++)
            {
                vermelha[i][j][0] = 0;
                vermelha[i][j][2] = 0;
                vermelha[i][j][1] = imagem[i][j][1];
                
            }
        }
        
        return vermelha;
    }
    
    public static int[][][] filtroAzul(int[][][] imagem)
    {
        int[][][] vermelha = new int[linha][coluna][3];
        
        for(int i = 0; i<linha; i++)
        {
            for(int j = 0; j < coluna; j++)
            {
                vermelha[i][j][0] = 0;
                vermelha[i][j][1] = 0;
                vermelha[i][j][2] = imagem[i][j][2];
                
            }
        }
        
        return vermelha;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        Scanner in = new Scanner(new FileReader("imagem colorida.ppm"));
        
        int[][][] imagem;
        int[][][] vermelho;
        int[][][] verde;
        int[][][] azul;
        
        imagem = criaMatriz(in);
        vermelho = filtroVermelho(imagem);
        verde = filtroVerde(imagem);
        azul = filtroAzul(imagem);
        salvarImagem(azul,"azul.ppm");
        salvarImagem(verde, "verde.ppm");
        salvarImagem(imagem, "copia.ppm");
        salvarImagem(vermelho, "vermelho.ppm");
        
    }
    
}
