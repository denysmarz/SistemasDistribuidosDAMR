
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleChat extends ReceiverAdapter {

    JChannel channel;
    //String user_name=System.getProperty("user.name", "n/a");
   // private int suma;
   // private int sumb;
    //private int sumc;
    //private String mesa;
    //private int resultado;
    votosMesa [] votacion = new votosMesa[100];
    
    public SimpleChat() {


    }
    final List<String> state = new LinkedList<>();

    public void viewAccepted(View new_view) {
        System.out.println("** vista: " + new_view);
    }

    public void receive(Message msg) {
        String line = msg.getSrc() + ": " + msg.getObject();
        String []cadena =line.split(",");
        String [] mesa = cadena[0].split(" ");
        String [] juan = cadena[1].split(" ");
        String [] maria = cadena[2].split(" ");
        String [] pedro = cadena[3].split(" ");
        
       int votojuan= Integer.valueOf(juan[2]);
        int votomaria= Integer.valueOf(maria[2]);
        int votopedro= Integer.valueOf(pedro[2]);
        int mes = Integer.valueOf(mesa[3]);
        
        //mesa 1, juan 5, maria 4, pedro 5       <-sintaxis para enviar los voto
        
        if(votacion[mes-1]==null){
            System.out.println("\nLos Votos has sido Registrados");
            votacion[mes-1]=new votosMesa(votomaria, votojuan, votopedro);
        }else{
            System.out.println("\nESA MESA YA FUE REGISTRADA!!!!!!!");
        }
        
        System.out.println(line+"\n");
        
        System.out.println("**********************************************");
        System.out.println(totalizador());
        System.out.println("**********************************************");
        
        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        /*añade todos los mensaje a la lista */
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("VotaconCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("> ");
                System.out.flush();
                String line = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }
                line = "[" + "denys" + "] " + line;
                Message msg = new Message(null, line);
                channel.send(msg);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new SimpleChat().start();
    }
    String totalizador(){
        int aux=0;
        int aux2=0;
        int aux3=0;
        for (votosMesa votacion1 : votacion) {
            if (votacion1 != null) {
                aux+=votacion1.votosJuan;
                aux2+=votacion1.votosMaria;
                aux3+=votacion1.votosPedro;
            }
        }
        return "* TOTAL DE VOTOS: JUAN = "+aux+" MARIA= "+aux2+" PEDRO= "+aux3+" *";
    }
}
