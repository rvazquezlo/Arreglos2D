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
     * Dado un reglon, suma los valores de cada columna dentro de rengloSumado
     * @param arreglo: del que se quieren sumar las columnas de renglonSumado
     * @param renglonSumado: empezando en el renglon 0, el renglon del cual se quieren sumar las 
     * columnas
     * @param numeroColumnas: numero de columnas que tiene renglonSumado
     * @return:<ul>
     * <li> -1: si el arreglo es null o numeroColumnas y/o renglonSumado
     * exceden el numero de columnas y/o renglones del arreglo.</li>
     * <li> 0: si la suma es 0 o si el renglon tiene 0 columnas.</li>
     * <li> De otra forma, regresa la suma como numero entero (int).</li>
     * </ul>
     */
    public static int sumaRenglon(int[][] arreglo, int renglonSumado, int numeroColumnas){
        int suma;
        
        try{
            suma = 0;
            for(int i = 0; i < numeroColumnas; i++)
                suma = suma + arreglo[renglonSumado][i];
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){ //evita que renglonSumado y el numeroColumnas excedan las del arreglo y que arreglo sea null 
            suma = -1;
        }        
        return suma;
    }
    
    /**
     * Suma todos los elementos del un arreglo de 2D renglon por renglon
     * @param arreglo: arreglo en 2D
     * @param numeroRenglones: renglones llenos
     * @param numeroColumnas: columnas llenas
     * @return <ul>
     * <li> null: si el arreglo es null, si tiene 0 columnas y/o 0 renglones, o 
     * si el usuario da un numeroRenglones o numeroColumnas negativos o mas grandes
     * que los que el arreglo tenga.</li>
     * <li> De otra forma, regresa un numero entero </li>
     */
    public static int sumaPorRenglonRecursiva(int[][] arreglo, int numeroRenglones, int numeroColumnas){
        Integer suma;
        
        if(arreglo != null && numeroRenglones > 0 && numeroColumnas > 0)
            suma = sumaPorRenglonRecursiva(0, 0, arreglo, numeroRenglones, numeroColumnas);
        else
            suma = null;
        return suma;
    }
    
    /**
     * Metodo auxiliar recursivo de public static int 
     * sumaPorRenglonRecursiva(int[][] arreglo, int numeroRenglones, int 
     * numeroColumnas)
     * @param row: el renglon que se esta sumando, empezando en 0
     * @param column: la columna que se esta sumando, empezando en 0
     * @param arreglo: arreglo en 2D
     * @param numeroRenglones: renglones llenos
     * @param numeroColumnas: columnas llenas
     * @return <ul>
     * <li> null: si el usuario da un numeroRenglones o numeroColumnas negativos 
     * o mas grandes que los que el arreglo tenga.</li>
     * <li> De otra forma, regresa un numero entero </li>
     */
    private static Integer sumaPorRenglonRecursiva(int row, int column, int[][] arreglo, int numeroRenglones, int numeroColumnas){
        try{
            if(column == numeroColumnas - 1)
                if(row == numeroRenglones - 1)
                    return arreglo[row][column];
                else
                    return arreglo[row][column] + sumaPorRenglonRecursiva(row + 1, 0, arreglo, numeroRenglones, numeroColumnas);
            else 
                return arreglo[row][column] + sumaPorRenglonRecursiva(row, column + 1, arreglo, numeroRenglones, numeroColumnas);
            
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static int sumaPorColumnaRecursiva(int[][] arreglo, int numeroRenglones, int numeroColumnas){
        if(arreglo != null && numeroRenglones > 0 && numeroColumnas > 0)
    }
    
    ///////suma pr columna, toString, suma diagonal ppl y regresa elementos de diagonal, sumaMAtrices, multiplica matriz 
    
    /**
     * Busca las posicion del elemento mas grande de cada renglon en la columna 
     * columnaBuscada de arreglo
     * @param arreglo: en el que se quiere buscar
     * @param totalRenglones: total de renglones que tiene el arreglo
     * @param columnaBuscada: empezando en la columna 0, la columna para la cual 
     * se quiere encontrar la posicion del renglon con el elemento mas grande de 
     * columnaBuscada
     * @return <ul>
     * <li> -1: si el arreglo es null o columnaBuscada y/o totalRenglones
     * exceden el numero de columnas y/o renglones del arreglo.</li>
     * <li> De otra forma, regresa una posicion entre 0 a (totalRenglones - 1)</li>
     * </ul>
     */
    public static int buscaPosionDeMaxEnColumna(int[][] arreglo, int totalRenglones, int columnaBuscada){
        int posicionDeMax, max, i, probando;
        
        try{
            posicionDeMax = 0;
            max = arreglo[posicionDeMax][columnaBuscada];
            for(i = 1; i < totalRenglones; i++){
                probando = arreglo[i][columnaBuscada];
                if(probando > max){
                    max = probando;
                    posicionDeMax = i;
                }
            }
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            posicionDeMax = -1;
        }
        return posicionDeMax;
    }
    
    /**
     * Froma una cadena con todos los elementos de arreglo en orden
     * @param arreglo: del que se quiere formar la cadena
     * @return <ul>
     * <li> null: si arreglo es null o si tiene 0 columnas y/o renglones </li>
     * <li> De otra forma, regresa la cadena en forma de matriz, poniendo 
     * horizontalmente las columnas y verticalmente los renglones </li>
     * </ul>
     */
    public static String imprimeMatriz(int[][] arreglo){
        StringBuilder sb;
        String contenido;
        int rows, columns, i, j;
        
        try{
            sb = new StringBuilder();
            rows = arreglo.length;
            columns = arreglo[0].length;
            for(i = 0; i < rows; i++){
                for(j = 0; j < columns; j++)
                    sb.append(arreglo[i][j] + " ");
                if(i < rows - 1)
                    sb.append("\n");
            }
            contenido = sb.toString();
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            contenido = null;
        }
        return contenido;
    }
    
    /**
     * Suma dos matrices, entrada por entrada
     * @param matriz1
     * @param matriz2
     * @return:<ul>
     * <li> null: las dos matrices no tinen mismo numero de renglones y/o 
     * columnas, o por lo menos alguna de las dos es null, o alguna de las
     * dos tiene 0 renglones y/o columnas. </li>
     * <li> De otra forma, regresa una matriz con la suma de las entradas de
     * matriz1 y matriz2 </li>
     * </ul>
     */
    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2){
        int rows1, columns1, i, j, suma[][];
        
        suma = null;
        try{
            rows1 = matriz1.length;
            columns1 = matriz1[0].length;
            if(rows1 == matriz2.length && columns1 == matriz2[0].length){
                suma = new int[rows1][columns1];
                for(i = 0; i < rows1; i++)
                    for(j = 0; j < columns1; j++)
                        suma[i][j] = matriz1[i][j] + matriz2[i][j];
            } 
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            
        }
        return suma;
    }
    
    /**
     * Multiplica dos matrices, entrada por entrada
     * @param matriz1
     * @param matriz2
     * @return:<ul>
     * <li> null: el numero de columnas de matriz1 no es igual al numero de
     * renglones de la matriz2, o por lo menos alguna de las dos es null, o alguna de las
     * dos tiene 0 renglones y/o columnas. </li>
     * <li> De otra forma, regresa una matriz con con el producto de
     * matriz1 y matriz2 </li>
     * </ul>
     */
    public static int[][] multiplicaMatrices(int[][] matriz1, int[][] matriz2){
        int rows1, comun, columns2, i, j, k, producto[][];
        
        producto = null;
        try{
            comun = matriz1[0].length;
            if(comun == matriz2.length){
                rows1 = matriz1.length;
                columns2 = matriz2[0].length;
                producto = new int[rows1][columns2];
                for(i = 0; i < rows1; i++)
                    for(j = 0; j < columns2; j++){
                        producto[i][j] = 0;
                        for(k = 0; k < comun; k++)
                            producto[i][j] = producto[i][j] + (matriz1[i][k] * matriz2[k][j]);   
                    }
            }
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            
        }
        return producto;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arreglo[][], i, rows, columns, j, arreglo2[][];
        
        rows = 2;
        columns = 2;
        arreglo = new int[rows][columns];
        
        for(i = 0; i < rows; i++)
            for(j = 0; j < columns; j++){
                arreglo[i][j] = j + i;
            }
        
        System.out.println(" matriz\n" + imprimeMatriz(arreglo));           
        System.out.println("Suma " + sumaRenglon(null, 3, 7));    
        System.out.println("Posicion max " + buscaPosionDeMaxEnColumna(arreglo, rows, 0));
        
        arreglo2 = new int [columns][columns + 1];
        for(i = 0; i < columns; i++)
            for(j = 0; j < columns + 1; j++){
                arreglo2[i][j] = j + i + 2;
            } 
     
        System.out.println("matriz 2\n" + imprimeMatriz(arreglo2));
        System.out.println("\nSuma de matrices:\n" + imprimeMatriz(sumaMatrices(arreglo, arreglo2)));
        
        System.out.println("\nPRoducto de matrices:\n" + imprimeMatriz(multiplicaMatrices(arreglo, arreglo2)));
    }
    
}
