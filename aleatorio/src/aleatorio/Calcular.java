package aleatorio;

import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

public class Calcular extends SwingWorker<Long, Object> {

    private final int n; // Número aleatorio a ser calculado
    private final JLabel lblResultado; // JLabel para exibir o resultado
    private final ArrayList<Integer> restricoes;

    public Calcular(int number, JLabel lblResultado, ArrayList<Integer> restricoes) {
        this.n = number;
        this.lblResultado = lblResultado;
        this.restricoes = restricoes;
    }

    @Override
    public Long doInBackground() {
        long nthFib = sorteiar(n);
        return nthFib;
    }

// código a executar na thread de despacho de eventos quando doInBackground retorna
    @Override
    protected void done() {
        this.demorar();
        try {
            lblResultado.setText((this.get() < 10) ? "0" + this.get() : String.valueOf(this.get()));
        } catch (InterruptedException | ExecutionException ex) {
            JOptionPane.showMessageDialog(null, "Interompido enquando aguardava resultado!");
        }
    }

    public void demorar() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao demorar");
        }
    }

    public int sorteiar(int max) {
        int val;
        do {
            val = (int) (1 + Math.random() * max);
            if (!this.restricoes.contains(val)) {
                return val;
            }
        } while (true);

    }
}
