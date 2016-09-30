
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Helper {

    public static int mensaje(Component ventana, String info, String titulo, int tipo) {
        int retorno = -1;
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                retorno = JOptionPane.showConfirmDialog(ventana, info, titulo, JOptionPane.YES_NO_OPTION);
                break;
        }
        return retorno;
    }

    public static String recibirDatos(Component ventana, String info) {
        String aux;
        aux = JOptionPane.showInputDialog(ventana, info);
        return aux;
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }

    public static void limpiarTabla(JTable tabla) {
        int nf, nc;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                tabla.setValueAt("", i, j);
            }
        }
    }

    public static void tablaPorDefecto(JTable tabla) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);

    }

    public static int cantidadNumerosPares(JTable tabla) {
        int nf, nc, aux, cont = 0;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla.getValueAt(i, j);
                if (aux % 2 == 0) {
                    cont++;
                }

            }

        }

        return cont;
    }

    public static void numerosPares(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }
        }
    }

    public static void diagonalPrincipal(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (i == j) {
                    tabla2.setValueAt(aux, i, j);
                }
            }
        }
    }

    public static void letraC(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (i == 0 || j == 0 || i == nf - 1) {
                    tabla2.setValueAt(aux, i, j);
                }

            }

        }

    }

    public static void letraH(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (j == 0 || j == nc - 1 || i == (nf - 1) / 2) {
                    tabla2.setValueAt(aux, i, j);
                }

            }

        }
    }

    public static String recorrido1(JTable tabla1) {
        int nf, nc, ne, cont =0, i,j;
        String aux="";
        int[][] m = pasarDatosMatriz(tabla1);
        nf = m.length;
        nc = m[0].length;
        ne = nf * nc;
        i = nf-1;
        j = 0;
        
        while(cont < ne){
           aux=aux+m[i][j];
            if(j==0 || j%2 == 0){
                i --;
            }else{
                
                i++;
            }
            
             
             if(i ==0 || i == nf-1){
                j++;
            }
            
            cont ++;
        }
        
        return aux;
    }

    public static int[][] pasarDatosMatriz(JTable tabla1) {
        int nf, nc;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        int m[][] = new int[nf][nc];

        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)tabla1.getValueAt(i, j);
            }
        }
        return m;
    }
    
    public static String recorridoHaciaArriba (int m[][], int j){
        String aux="";
        int nf = m.length;
        
        for (int i = (nf-1); i >= 0; i--){
            int[] is = m[i];
            aux = aux + m[i][j]+" ";
        } 
        return aux;
    }
    
    public static String recorridoHaciaArriba (int m[][], int j, int in, int f){
        String aux="";
        int nf = m.length;
        
        for (int i = in; i < f; i++){
            aux = aux + m[i][j]+" ";
        } 
        return aux;
    }
    
    public static String recorridoHaciaAbajo (int m[][], int j){
        String aux="";
        int nf = m.length;
        
        for (int i = 0; i < nf; i++){
            aux = aux + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoHaciaAbajo (int m[][], int j, int in, int f){
        String aux="";
        int nf = m.length;
        
        for (int i = in; i < f; i++){
            aux = aux + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoUno (JTable tabla1){
        int m[][] = pasarDatosMatriz(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        
        for (int j = 0; j < nc; j++){
            if(j%2 == 0){
                aux = aux + Helper.recorridoHaciaArriba(m, j);
            }else{
                aux = aux + Helper.recorridoHaciaAbajo(m, j);
            }
        }
        aux = aux.substring(0, aux.length()-2);
        return aux;
    }
    
    public static String recorridoDerecha (int m[][], int i){
        String aux = "";
        int nc = m.length;
        
        for (int j = 0; j < nc; j++){
            aux = + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoDerecha (int m[][], int i, int in, int f){
        String aux = "";
        int nc = m.length;
        
        for (int j = in; j < f; j++){
            aux = + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoIzquierda (int m[][], int i){
        String aux = "";
        int nc = m[0].length;
        
        for (int j = (nc-1); j >= 0; j--){
            aux = aux + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoIzquierda (int m[][], int i, int in, int f){
        String aux = "";
        int nc = m[0].length;
        
        for (int j = in; j < f; j--){
            aux = aux + m[i][j]+" ";
        }
        return aux;
    }
    
    public static String recorridoDos (JTable tabla1){
        int m[][] = pasarDatosMatriz(tabla1);
        int nf = m.length;
        int nc = m.length;
        String aux = "";
        
        for (int i = 0; i < nf; i++){
            if(i%2 == 0){
                aux = aux + Helper.recorridoIzquierda(m, i);
            }else{
                aux = aux + Helper.recorridoDerecha(m, i);
            }
        }
        aux = aux.substring(0, aux.length()-2);
        return aux;
    }

}
