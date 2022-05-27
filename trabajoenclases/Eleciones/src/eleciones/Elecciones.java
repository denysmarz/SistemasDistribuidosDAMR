package eleciones;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Elecciones extends ReceiverAdapter {
    JChannel channel;
    //String user_name=System.getProperty("user.name", "n/a");
    
    private int suma;
    private int sumb;
    private int sumc;
    VotosMesa [] listavotosmesa = new VotosMesa[100];
    final List<String> state=new LinkedList<>();

    public void viewAccepted(View new_view) {
        System.out.println("** vista: " + new_view);
    }

    public void receive(Message msg) {
        String line=msg.getSrc() + ": " + msg.getObject();
        String [] cadena = line.split(",");
        String [] mesa = line.split(" ");
        //int nromesa = Integer.parseInt(mesa[2]);
        String nums= mesa[5];
        int numa = Integer.parseInt(nums);
        this.suma+=numa;
        
        String numsb= mesa[8];
        int numb = Integer.parseInt(numsb);
        this.sumb+=numb;
        
        String numsc= mesa[11];
        int numc = Integer.parseInt(numsc);
        this.sumc+=numc;
        //VotosMesa op = new VotosMesa(5,5,5);
        
       // System.out.println(line+"----***"+"VOTOS JUAN = "+this.suma+" VOTOS PEDRO = "+this.sumb+" VOTOS MARIA = "+this.sumc);
        synchronized(state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized(state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list=(List<String>)Util.objectFromStream(new DataInputStream(input));
        synchronized(state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for(String str: list) {
            System.out.println(str);
        }
    }


    private void start() throws Exception {
        channel=new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                System.out.print("> "); System.out.flush();
                String line=in.readLine().toLowerCase();
                if(line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }
                //line="[] " + line;
                Message msg=new Message(null,line);
                channel.send(msg);
            }
            catch(Exception e) {
            }
        }
    }


   public static void main(String[] args) throws Exception {
        //Scanner sc=new Scanner(System.in);
        //System.out.print("Introduzca su nombre");
       // String nombre;
        //nombre=sc.next();
        new Elecciones().start();
    }
}

