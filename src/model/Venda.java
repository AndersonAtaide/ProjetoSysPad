package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//pode ser o log de vendas tbm só adicionar a lista dos produtos vendidos caso queira mudar
public class Venda {
    private int codVenda;
    private double valor;   
    private Date data;
    
    public Venda(int codVenda, double valor, String data) {
        this.codVenda = codVenda;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/mm/aaaa").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCodVenda() {
        return codVenda;
    }    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }    
}
