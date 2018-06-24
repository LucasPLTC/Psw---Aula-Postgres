
package AcessoEscolar;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lucas Carvalho
 */
/**
 *  Esta é a Classe Aluno, onde são criados os atributos e construtores para criação de objetos "aluno".
 * Junto dela existem os métodos getters e Setters, que são métodos para acessar ou modificar os atributos de aluno.
 * 
 */
@Entity
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue
    private String nome;
    private double nota1;
    private double trabalho;
    private double projeto;
    private double frequencia;
    private double prova_final;
    private String situacao;

    
    
    
 /*
 * Construtor da Classe Aluno, com os seus devidos atributos 
 * 
 */
    public Aluno(String nome, double nota1, double trabalho, double projeto, double frequencia, double prova_final, String situacao) {
        this.nome = nome;
        this.nota1 = nota1;
        this.trabalho = trabalho;
        this.projeto = projeto;
        this.frequencia = frequencia;
        this.prova_final = prova_final;
        this.situacao = situacao;
    }

 /*
 * 
 * Métodos getters and Setters
 * 
 */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public double getProjeto() {
        return projeto;
    }

    public void setProjeto(double projeto) {
        this.projeto = projeto;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public double getProva_final() {
        return prova_final;
    }

    public void setProva_final(double prova_final) {
        this.prova_final = prova_final;
    }
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
