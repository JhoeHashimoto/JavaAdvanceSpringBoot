package br.com.fiap.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main {


  public static void main(String[] args) {
    SpringApplication.run(Main.class,args);
    /*GerenciadorDeEventos gerenciadorDeEventos = new GerenciadoDeEventosImpl();

    Scanner scanner = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    while(true) {
      System.out.println("Sistema de gerenciamento de eventos");
      System.out.println("1 adicionar Evento");
      System.out.println("2 remover evento");
      System.out.println("3 Listar eventos por categoria");

      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          System.out.println("Digite o nome do evento");
          String nomeDoEvento = scanner.nextLine();
          System.out.println("Digita a data e hora do evento dd/MM/yyyy HH:mm");
          String dataHoraEvento = scanner.nextLine();
          LocalDateTime dataHora = LocalDateTime.parse(dataHoraEvento,formatter);

          System.out.println("Escolha a categoria do evento.");
          for(Categoria categoria: Categoria.values()) {
            System.out.println(categoria.ordinal() + 1 + ". " + categoria);
          }
          int categoriaEscolhida = scanner.nextInt();
          scanner.nextLine();
          Categoria categoria = Categoria.values()[categoriaEscolhida];

          EventoImpl evento = new EventoImpl(nomeDoEvento,dataHora,categoria);
          gerenciadorDeEventos.adicionarEvento(evento);
          System.out.println("Evento adicioanr com sucesso");
          break;
        case 3:
          System.out.println("Escolha a categoria do evento para listar:");
          for(Categoria cat: Categoria.values()) {
            System.out.println(cat.ordinal() + 1 + ". " + cat);
          }
          int categoriaEscolhidaParalistar = scanner.nextInt();
          scanner.nextLine();
          Categoria categoriaEscolhidaParaListagem = Categoria.values()[categoriaEscolhidaParalistar];
          List<Evento> eventosPorCategoria = gerenciadorDeEventos.listarEventosPorCategoria(categoriaEscolhidaParaListagem);
          System.out.println("Lista de eventos por categoria :" + eventosPorCategoria);
          for(Evento e : eventosPorCategoria) {
            System.out.println("eventos" + e);
          }
          break;
      }

    }*/
  }
}
