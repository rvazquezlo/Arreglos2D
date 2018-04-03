/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d_arrays;

/**
 *
 * @author edi
 */
public class Main {
    
    /**
     * 
     * @param arreglo
     * @param renglonSumado (empezando en el renglon 0)
     * @param numeroColumnas
     * @return -1 si el arreglo es null
     */
    public static int sumaRenglon(int[][] arreglo, int renglonSumado, int numeroColumnas){
        int suma;
        
        try{
            suma = 0;
            for(int i = 0; i < numeroColumnas; i++)
                suma = suma + arreglo[renglonSumado][i];
        }catch(NullPointerException e){ //evita que renglonSumado y el numeroColumnas excedan las del arreglo y que arreglo sea null 
            suma = -1;
        }        
        return suma;
    }
    
    public static int buscaPosionDeMaxEnColumna(int[][] arreglo, int totalRenglones, int columnaBuscada){
        int posicionDeMax, max, i, probando;
        
        try{
            posicionDeMax = 0;
            max = arreglo[posicionDeMax][columnaBuscada];
            for(i = 1; i < totalRenglones; i++)
                if(arreglo[i][columnaBuscada] > max)
                    posicionDeMax = i;  
        }catch(NullPointerException e){
            posicionDeMax = -1;
        }
        return posicionDeMax;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arreglo[][], i, rows, columns, j;
        
        rows = 3;
        columns = 2;
        arreglo = new int[rows][columns];
        for(i = 0; i < rows; i++){
            for(j = 0; j < columns; j++)
                if (j != columns - 1)
                    arreglo[i][j] = j + i + 2;
        System.out.println(sumaRenglon(arreglo, 1, columns));    
        }
        
    }
    
}
