import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        new MergeSort().setVisible(true);
    }

    static class MergeSort extends JFrame {
        private int[] array;
        private final JTextField quantity;
        private final JTextArea result;

        private final JButton generate;
        private final JButton sort;
        private final JButton clear;


        public MergeSort() {
            setTitle("Merge Sort");
            setSize(500, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 1));
            panel.add(new JLabel("Cantidad de elementos"));
            quantity = new JTextField();
            panel.add(quantity);
            generate = new JButton("Generar");
            panel.add(generate);
            sort = new JButton("Ordenar");
            panel.add(sort);
            clear = new JButton("Limpiar");
            panel.add(clear);
            result = new JTextArea();
            result.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(result);
            panel.add(scrollPane);
            setEvents();
            add(panel);

        }

        private void setEvents() {
            generate.addActionListener(e -> {
                generateArray();
            });
            sort.addActionListener(e -> {
                sort(array, 0, array.length - 1);
                String text = "";
                for (int i = 0; i < array.length; i++) {
                    if (i == array.length - 1) text += array[i];
                    else text += array[i] + ", ";
                }

                result.setText(text);
            });
            clear.addActionListener(e -> {
                quantity.setText("");
                result.setText("");
            });
        }

        private void generateArray() {
            try {

                int size = Integer.parseInt(quantity.getText());
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = new Random().nextInt(1, 101);
                }
                String text = "";
                for (int i = 0; i < size; i++) {
                    if (i == size - 1) text += array[i];
                    else text += array[i] + ", ";
                }

                result.setText(text);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar el arreglo");
            }
        }

        void merge(int[] arreglo, int l, int m, int r)//l es left , m es medio y r right
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
    }

}