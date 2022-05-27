/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleciones;

/**
 *
 * @author DENYS XD
 */
public class VotosMesa {
    private String pedro;
    private String juan;
    private String maria;
    public int suma;
    public int sumb;
    public int sumc;

    public VotosMesa(int suma, int sumb, int sumc) {
        this.suma = suma;
        this.sumb = sumb;
        this.sumc = sumc;
    }

    
    
    public VotosMesa(String pedro, String juan, String maria) {
        this.pedro = pedro;
        this.juan = juan;
        this.maria = maria;
    }

    public String getPedro() {
        return pedro;
    }

    public void setPedro(String pedro) {
        this.pedro = pedro;
    }

    public String getJuan() {
        return juan;
    }

    public void setJuan(String juan) {
        this.juan = juan;
    }

    public String getMaria() {
        return maria;
    }

    public void setMaria(String maria) {
        this.maria = maria;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getSumb() {
        return sumb;
    }

    public void setSumb(int sumb) {
        this.sumb = sumb;
    }

    public int getSumc() {
        return sumc;
    }

    public void setSumc(int sumc) {
        this.sumc = sumc;
    }
    
    
    
    
    public String votos(int a,int b,int c){
        this.suma+=a;
        this.sumb+=b;
        this.sumc+=c;
        return String.valueOf(this.suma+" "+this.sumb+" "+this.sumc);
    }
}
