package BusquedaHash;

/**
 *
 * @author EquipoALZ
 */

public class Hash {
    int dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    String info;

    static int funcion(int n, int m) {
        return ((n + 1) % m);
    }

    static void insertaHash(Hash[] h, int m, int n,String datos) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].estado = 2;
                h[j].info=datos;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Elemento insertado con éxito!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Tabla llena!");
        }
    }

    static String buscaHash(Hash[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) { 
                return "-1";
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return "-1";
                } else {
                    return h[j].info;
                }
            } else {
                j++;
            }
        }
        return "-1";
    }

    static int eliminaHash(Hash[] h, int m, int n) {
        String i = buscaHash(h, m, n);
        int j=funcion(n,m);
        if (i == "-1") {
            return -1;
        } else {
            while(h[j].dato!=n){
                j++;
            }
            h[j].estado = 1;
            return 1;
        }
    }
    static String mostrarLista(Hash[] h,int m){
        String cad="Matriculas\tNOMBRE\tPROMEDIO\n";
        for(int i=0;i<m;i++)
        {
            if(h[i].estado!=0 && h[i].estado!=1)
            cad=cad+h[i].dato+"\t"+h[i].info+"\n";
        }
        return cad;
    }
}
