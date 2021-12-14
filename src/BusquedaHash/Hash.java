/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lesli
 */
public class Hash {
    int dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    String info;

    static int funcion(int n, int m) {
        return ((n + 1) % m);
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
    static String mostrarMatriculas(Hash[] h,int m){
        String cad="Matriculas en las lista\n";
        for(int i=0;i<m;i++)
        {
            if(h[i].dato!=0)
            cad=cad+h[i].dato+"\n";
        }
        return cad;
    }
    
}
