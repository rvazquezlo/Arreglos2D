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
        Integer suma;
        
        if(arreglo != null && numeroRenglones > 0 && numeroColumnas > 0)
            suma = sumaPorColumnaRecursiva(0, 0, arreglo, numeroRenglones, numeroColumnas);
        else
            suma = null;
        return suma;
    }
    
    private static Integer sumaPorColumnaRecursiva(int row, int column, int[][] arreglo, int numeroRenglones, int numeroColumnas){
        try{
            if(row == numeroRenglones - 1)
                if(column == numeroColumnas - 1)
                    return arreglo[row][column];
                else
                    return arreglo[row][column] + sumaPorColumnaRecursiva(0, column + 1, arreglo, numeroRenglones, numeroColumnas);
            else
                return arreglo[row][column] + sumaPorColumnaRecursiva(row + 1, column, arreglo, numeroRenglones, numeroColumnas);
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static String toStringRecursivo(int [][] arreglo, int numeroRenglones, int numeroColumnas){
        StringBuilder sb;
        
        sb = new StringBuilder();
        if(arreglo != null && numeroRenglones > 0 && numeroColumnas > 0)
                toStringRecursivo(0, 0, arreglo, numeroRenglones, numeroColumnas, sb); 
        else
            sb.append("arreglo es nulo o está vacío");
        return sb.toString();          
    }
    
    private static void toStringRecursivo(int row, int column, int[][] arreglo, int numeroRenglones, int numeroColumnas, StringBuilder sb){
        try{
            sb.append(arreglo[row][column] + "    ");
            if(column == numeroColumnas - 1){
                if(row < numeroRenglones - 1){
                    sb.append("\n");
                    toStringRecursivo(row + 1, 0, arreglo, numeroRenglones, numeroColumnas, sb);
                }
            }
            else
                toStringRecursivo(row, column + 1, arreglo, numeroRenglones, numeroColumnas, sb);
        }catch(ArrayIndexOutOfBoundsException e){
           sb.delete(0, sb.length());
           sb.append("El numeroRenglones o numeroColumnas dadas excede al numero de renglones o columnas maximos de arreglo");
        }
    }
    
    public static String sumaYRegresaElementosDiagonalPrincipal(int[][] arreglo, int numeroRenglones, int numeroColumnas){
        StringBuilder sb;
        Integer suma;
        
        sb = new StringBuilder();
        if(arreglo != null && numeroRenglones > 0){
            if(numeroRenglones == numeroColumnas){
                suma = 0;
                suma = sumaYRegresaElementosDiagonalPrincipal(0, arreglo, numeroRenglones, sb);
                if(suma != null)
                    sb.append("\n" + suma);
            }
            else
                sb.append("arreglo no es una matriz cuadrada");  
        }
        else 
            sb.append("arreglo es nulo o está vacío");
        return sb.toString();
    } 
    
    private static Integer sumaYRegresaElementosDiagonalPrincipal(int row, int[][] arreglo, int numeroRenglones, StringBuilder sb){
        int sumita;
        
        try{
            sumita = arreglo[row][row];
            sb.append(sumita + "     ");
            if(row == numeroRenglones - 1)
                return sumita;
            else
                return sumita + sumaYRegresaElementosDiagonalPrincipal(row + 1, arreglo, numeroRenglones, sb);
        }catch(ArrayIndexOutOfBoundsException e){
            sb.delete(0, sb.length());
            sb.append("El numeroRenglones o numeroColumnas dadas excede al numero de renglones o columnas maximos de arreglo");
            return null;
        }
    }
    
    public static int[][] sumaMatricesRecursiva(int[][] matriz1, int[][] matriz2, int numeroRenglones, int numeroColumnas){
        int[][] suma;
        
        if(numeroRenglones > 0 && numeroColumnas > 0){
            suma = new int[numeroRenglones][numeroColumnas];
            sumaMatricesRecursiva(0, 0, suma, matriz1, matriz2, numeroRenglones, numeroColumnas);
        }
        else    
            suma = null;
        return suma;
    }
    
    private static void sumaMatricesRecursiva(int row, int column, int [][] suma, int[][] matriz1, int[][] matriz2, int numeroRenglones, int numeroColumnas){
        try{
            suma[row][column] = matriz1[row][column] + matriz2[row][column];
            if(column == numeroColumnas - 1){
                if(row < numeroRenglones - 1)
                    sumaMatricesRecursiva(row + 1, 0, suma, matriz1, matriz2, numeroRenglones, numeroColumnas);
            }
            else 
                sumaMatricesRecursiva(row, column + 1, suma, matriz1, matriz2, numeroRenglones, numeroColumnas);
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            suma = null;
        }
    }
    
    public static int[][] multiplicaMatricesRecursiva(int numeroRenglones1, int numeroColumnas1, int[][] matriz1, int numeroRenglones2, int numeroColumnas2, int[][] matriz2){
        int suma[][];
        
        if(matriz1 != null && matriz2 != null && numeroRenglones1 > 0 && numeroColumnas1 > 0 && numeroColumnas2 > 0 && numeroColumnas1 == numeroRenglones2){
            suma = new int[numeroRenglones1][numeroColumnas2];
            multiplicaMatricesRecursiva(0, 0, 0, numeroRenglones1, numeroColumnas2, numeroRenglones2, suma, matriz1, matriz2);
        }
        else
            suma = null;
        return suma;
    }
    
    private static void multiplicaMatricesRecursiva(int row, int column, int comun, int numeroRenglones, int numeroColumnas, int numeroComun, int[][] suma, int[][] matriz1, int[][] matriz2){
        try{
            if(comun == 0){
                suma[row][column] = matriz1[row][comun] * matriz2[comun][column];
                multiplicaMatricesRecursiva(row, column, comun + 1, numeroRenglones, numeroColumnas, numeroComun, suma, matriz1, matriz2);
            }
            else{
                suma[row][column] = suma[row][column] + matriz1[row][comun] * matriz2[comun][column];
                if(comun == numeroComun - 1){
                    if(column == numeroColumnas - 1){
                        if(row < numeroRenglones - 1)
                            multiplicaMatricesRecursiva(row + 1, 0, 0, numeroRenglones, numeroColumnas, numeroComun, suma, matriz1, matriz2);
                    }
                    else
                        multiplicaMatricesRecursiva(row, column + 1, 0, numeroRenglones, numeroColumnas, numeroComun, suma, matriz1, matriz2);   
                }
                else
                    multiplicaMatricesRecursiva(row, column, comun + 1, numeroRenglones, numeroColumnas, numeroComun, suma, matriz1, matriz2);
            }
        }catch(ArrayIndexOutOfBoundsException e){//Por si el usuario da mal el numero de renglones o columnas de cualquier matriz
            suma = null;
        }
    }
    
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
     * 
     * @param arre1
     * @param ren1: numero total de renglones, empezando desde 1
     * @param col1
     * @param arre2
     * @param ren2
     * @param col2
     * @return 
     */
    public static boolean sonIguales(int arre1[][], int ren1, int col1, int 
            arre2[][], int ren2, int col2){
        if(arre1 != null && arre2 != null && ren2 == ren1 && col1 == col2)
            return sonIguales(arre1, arre2, 0, 0, ren1, col1);
        return false;   
    }
    
    private static boolean sonIguales(int arre1[][], int arre2[][], int row, int column, int rows, int columns){
        if(arre1[row][column] == arre2[row][column]){
            if(column == columns - 1){
                if(row == rows - 1){
                    return true;
                }
                else
                    return sonIguales(arre1, arre2, row + 1, 0, rows, columns);
            }
            else{
                return sonIguales(arre1, arre2, row, column + 1, rows, columns);
            }   
        }
            else
                return false; 
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
        System.out.println("Suma " + sumaRenglon(arreglo, rows, columns));    
        System.out.println("Posicion max " + buscaPosionDeMaxEnColumna(arreglo, rows, 0));
        
//        arreglo2 = new int [columns][columns + 1];
        arreglo2 = new int[columns][rows];
        for(i = 0; i < columns; i++)
            for(j = 0; j < rows; j++){
                arreglo2[i][j] = j + i + 2;
            } 
     
        System.out.println("matriz 2\n" + imprimeMatriz(arreglo2));
        System.out.println("\nSuma de matrices:\n" + imprimeMatriz(sumaMatrices(arreglo, arreglo2)));
        
        System.out.println("\nPRoducto de matrices:\n" + imprimeMatriz(multiplicaMatrices(arreglo, arreglo2)));
     
        System.out.println("Recursivos---------------------------------------------------------------------");
    //sumaPorRenglón: suma por renglón todos los elementos del arreglo bidimensional,
    System.out.println("Suma por renglon de todos elementos" + sumaPorRenglonRecursiva(arreglo, rows, columns)); 
    //regresando la suma obtenida.
    //2) sumaPorColumna: suma por columna todos los elementos del arreglo
    //bidimensional, regresando la suma obtenida.
    System.out.println("Suma por columna de todos los elementos" + sumaPorColumnaRecursiva(arreglo, rows, columns)); 
    System.out.println(" matriz \n" + imprimeMatriz(arreglo)); 
    //3) toString(): regresa el contenido del arreglo en forma de cadena.
    System.out.println(" matriz Recursivamente\n" + toStringRecursivo(arreglo, rows, columns));
    //4) sumaDiagonalPrincipal: suma y regresa los elementos de la diagonal principal.
    System.out.println("Suma y elementos de diag ppl\n" + sumaYRegresaElementosDiagonalPrincipal(arreglo, rows, columns));
    //5) sumaMatrices: suma dos matrices y regresa la matriz resultado.
    System.out.println("\nSuma de matrices:\n" + imprimeMatriz(sumaMatrices(arreglo, arreglo2)));
    System.out.println("\nSuma de matrices Recursiva:\n" + imprimeMatriz(sumaMatricesRecursiva(arreglo, arreglo2, rows, columns)));
    System.out.println("\nSuma de matrices Recursiva Con Imprime Recursivo:\n" + toStringRecursivo(sumaMatricesRecursiva(arreglo, arreglo2, rows, columns), rows, columns));
    //6) multiplicaMatrices: multiplica dos matrices y regresa la matriz resultado
    System.out.println("\nPRoducto de matrices:\n" + imprimeMatriz(multiplicaMatrices(arreglo, arreglo2)));
    System.out.println("\nPRoducto de matrices Recursiva:\n" + imprimeMatriz(multiplicaMatricesRecursiva(rows, columns, arreglo, columns, rows, arreglo2)));
    System.out.println("\nPRoducto de matrices Recursiva con imprime recursivo:\n" + toStringRecursivo(multiplicaMatricesRecursiva(rows, columns, arreglo, columns, rows, arreglo2), rows, columns));
    
    //Prueba sonIguales
    int arreglo3[][], arreglo4[][];
        
        rows = 8;
        columns = 2;
        arreglo3 = new int[rows][columns];
        arreglo4 = new int[rows][columns + 4];
        
        for(i = 0; i < rows; i++)
            for(j = 0; j < columns; j++){
                arreglo3[i][j] = j + i;
                arreglo4[i][j] = j + i;
            }
    System.out.println("\nSon iguales dos matrices: " + sonIguales(arreglo3, rows, columns, arreglo4, rows, columns + 4));
    
    }
    
}
