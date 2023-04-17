import java.util.Random;
import javax.swing.*;

//control espacio para autocompletar
public class Mergesort extends JFrame {

    //mis objetos se dejan aqui para que agarre la clase de limpiar y las demas funciones 
    int[] arreglo;
    JLabel titulo = new JLabel();//es mi titulo principal
    JButton boton1 = new JButton();//boton de limpiar
    JButton boton2 = new JButton();//boton de ordenar
    JButton boton3 = new JButton();//boton de mostrar
    JLabel re = new JLabel();//label de mensaje
    JTextArea res = new JTextArea();//text area donde se ingresan los datos
    JTextArea res2 = new JTextArea();//text area donde se muestran los datos

    public Mergesort() {

        this.setSize(500, 500);
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//ver pantalla principal

        setTitle("merge");
        panel.setLayout(null);

        titulo.setBounds(100, 75, 200, 10);//para poner posiscion y tamanio (coordenadas)
        titulo.setText("Resultados:");
        panel.add(titulo);//este es mi para principal para agregarlo

        //boton ordenar
        boton2.setBounds(50, 400, 100, 30);
        boton2.setText("Ordenar");
        panel.add(boton2);

        //boton limpiar
        boton1.setBounds(230, 400, 100, 30);
        boton1.setText("Limpiar");
        panel.add(boton1);

        //boton mostrar
        boton3.setBounds(375, 400, 100, 30);
        boton3.setText("Mostrar");
        panel.add(boton3);

        re.setBounds(100, 20, 200, 50);//para poner posiscion y tamanio (coordenadas)
        re.setText("Dame los digitos: ");
        panel.add(re);

        //textarea de dame los digitos
        res.setBounds(200, 40, 240, 20);
        res.setText(" ");
        panel.add(res);

        //textarea de resultados
        res2.setBounds(100, 100, 200, 100);
        res2.setText(" ");
        panel.add(res2);

        boton3.addActionListener(e -> gen());
        boton1.addActionListener(e -> limpiar());
        boton2.addActionListener(e -> {
            sort(arreglo, 0, arreglo.length - 1);
            imparreglo(arreglo);

        });

    }


    void merge(int arreglo[], int l, int m, int r)//l es left , m es medio y r right
    {
        //busco el tamanio de los dos subarrays del marge

        int n1 = m - l + 1;
        int n2 = r - m;

        //creamos los arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //copiamos la informacion temporal de los arrays

        for (int i = 0; i < n1; ++i) {
            L[i] = arreglo[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arreglo[m + 1 + j];
        }


        //iniciamos el index primero y despues los subarrays
        int i = 0, j = 0;

        //iniciamos inde del subarray del marge

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        //copiamos los elementos de L[] en cualquiera

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        //copiamos los elementos de R[] en cualquiera
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }


    // merge()
    void sort(int arreglo[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arreglo, l, m);
            sort(arreglo, m + 1, r);

            // Merge the sorted halves
            merge(arreglo, l, m, r);
        }
    }

    public void imparreglo(int arreglo[]) {
        int n = arreglo.length;
        String respuesta = "";
        for (int i = 0; i < n; i++) {
            respuesta += arreglo[i] + " ";
        }
        res2.setText(respuesta);
    }

    public void limpiar() {

        res.setText("");
        res2.setText("");

    }

    public void gen() {//clase generar arrreglo
        int tam = Integer.parseInt(res.getText().trim());
        arreglo = new int[tam];
        Random random = new Random();
        String respuesta = "";

        for (int i = 0; 1 < arreglo.length; i++) {
            arreglo[i] = random.nextInt(100);
        }
        for (int i = 0; 1 < arreglo.length; i++) {
            respuesta += arreglo[i] + " ";
        }
        res2.setText(respuesta);

    }

    public static void main(String[] args) {
        Mergesort ventana = new Mergesort();
        ventana.setVisible(true);
    }

}