/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author ander
 */
public interface IControladorContabilidade {
    
    public void calcularLucroLiquido(/*valor da venda da venda, custo da venda*/);
    public void GerarRelatorio();
    public void AbrirRelatorio();
}
