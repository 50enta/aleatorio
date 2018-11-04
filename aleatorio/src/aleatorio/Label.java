/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 50enta
 */
public class Label extends JLabel {

    private int numero;
    private boolean estado = true;
    private String caminho = "not01.png";

    public Label(String caminho, int num) {
        this.setNumero(num);
        this.addImagem(caminho);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEstado()) {
                    addImagem("not01.png");
                } else {
                    addImagem("done01.png");
                }
            }

        });
    }

    public void addImagem(String caminho) {
        this.setCaminho(caminho);
        this.setIcon(new ImageIcon(this.getClass().getResource(caminho)));
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return !caminho.equalsIgnoreCase("not01.png");
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        if (caminho.equalsIgnoreCase("not01.png")) {
            this.setEstado(false);
        } else {
            this.setEstado(true);
        }
        this.caminho = caminho;

    }

}
