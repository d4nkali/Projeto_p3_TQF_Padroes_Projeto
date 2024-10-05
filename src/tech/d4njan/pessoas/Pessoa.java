package tech.d4njan.pessoas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Pessoa {

    protected String nome;
    protected Date dataNascimento;
    protected int idade;

    protected String dataTemporaria;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    // Gets e Sets

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

    public void cadastrar() {

        System.out.print("Informe o nome: ");
        this.nome = sc.nextLine();

        System.out.print("Informe a data de Nascimento: ");
        this.dataTemporaria = sc.nextLine();

        try {
            this.dataNascimento = formatoData.parse(dataTemporaria);
        } catch (ParseException e) {
            System.out.println("Erro ao cadastrar data.");
        }

    }

    public String obterIdade() {

		LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimentoLocalDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        idade = Period.between(dataNascimentoLocalDate, dataAtual).getYears();
        return "Idade: " + idade + " anos.";

	}

}
