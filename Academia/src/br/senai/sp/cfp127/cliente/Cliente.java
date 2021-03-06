package br.senai.sp.cfp127.cliente;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

public class Cliente {
	
	private String nome;
	private String dtNascimento;
	private int idade;
	private double peso;
	private double altura;
	private char sexo;
	private int nivelAtividade;
	private int codigoCliente;
	
	
	private String logradouro;
	private String bairro;
	private String cidade;
	private String telefone;
	private String email;
	
	//Atributos derivados
	private double imc;
	private double tmb;
	private double fcm;
	
	
	//** METODO CONSTRUTOR DA CLASSE 
	public Cliente(String nome) {
		this.nome = nome;
	}
	//** METODO CONSTRUTOR DA CLASSE 
	public Cliente(String nome, double peso, double altura) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}
	//** METODO CONSTRUTOR DA CLASSE 
	public Cliente() {
		
	}
	
	//** NOME
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//** C�digo da cliente
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	//** Data de nacimento
	public String getDtNascimento() {
	
		return dtNascimento;
	}
	
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	//** PESO
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	//** ALTURA
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	//**SEXO
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	//**Nivel atividade
	public int getNivelAtividade() {
		return nivelAtividade;
	}

	///***** IDADE	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setNivelAtividade(int nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}
	
	//** Logradouro
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	//*Bairo
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	//**CIDADE
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	//**TELEFONE
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//**EMAIL
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	//** IMC
	public  double getImc() {
		
		double imc = this.peso / Math.pow(this.altura, 2);
		
		if (imc < 16.6) {
			this.imc =  imc ;
		}else if (imc < 18.5) {
			this.imc = imc;
		}else if (imc < 25.0) {
			this.imc = imc;
		}else if (imc < 30.0) {
			this.imc =imc ;
		}else if (imc < 34.9) {
			this.imc =  imc ;
		}else if (imc < 40.0) {
			this.imc = imc ;
		}else {
			System.out.println("N�o foi possivel determinar o seu IMC");
		}
		return this.imc;
	}

	
	
	//**TMB
	public double getTmb() {
		
		if (this.sexo == 'H') {
			this.tmb = 66 + (13.7 * this.peso) + (5 * this.altura * 100) - (6.8 * this.idade) ;
		}else {
			this.tmb = 665 + (9.6 * this.peso) + (1.8 * this.altura * 100)-(4.7 * this.idade);
		}
		if(this.nivelAtividade == 0) {
			JOptionPane.showMessageDialog(null, "selecione seu nivel de atividade" );
		}
		else if (this.nivelAtividade == 1) {
			this.tmb = this.tmb * 1.2;
		}else if(this.nivelAtividade == 2) {
			this.tmb =  this.tmb * 1.37;
		}else if(this.nivelAtividade == 3) {
			this.tmb =  this.tmb * 1.55;
		}else if(this.nivelAtividade == 4) {
			this.tmb =  this.tmb * 1.72;
		}else {
			this.tmb =  this.tmb * 1.9;
		}
		
		return tmb;
	}

	//**FCM 
	public double getFcm() {
		
		if (this.sexo == 'H') {
			this.fcm = ((210 - (0.5 * this.idade)) - this.peso * 1 / 100) + 4;
		}else {
			this.fcm = ((210 - (0.5 * this.idade)) - this.peso * 1 / 100);
		}
		
		return fcm;
	}
	
	
}
