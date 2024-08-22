package br.com.fiap.evento.controller;

import br.com.fiap.evento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {


  private GerenciadorDeEventos gerenciadorDeEventos = new GerenciadoDeEventosImpl();

  @GetMapping("/hello")
  public ResponseEntity<String> helloWorld() {
    return ResponseEntity.ok("OK Spring!");
  }


  @GetMapping()
  public ResponseEntity<String> buscarEvento() {
    return ResponseEntity.ok("OK Spring!");
  }
      //saida retorno, é o que esta saindo
  @PostMapping()                                               //request o que esta chegando
  public ResponseEntity<EventoImpl> criarEvento(@RequestBody EventoImpl evento) {
    EventoImpl eventoGerado = gerenciadorDeEventos.adicionarEvento(evento);
    return ResponseEntity.ok(eventoGerado);
  }
  /// GET http://localhost:8080/evento/categoria/workshop

  @GetMapping("/categoria/{nomeDaCategoria}")
  public ResponseEntity<List<Evento>> buscarEventoPorCategoria(@PathVariable String nomeDaCategoria) {
    Categoria categoria = Categoria.valueOf(nomeDaCategoria);
    List<Evento> listaDeEventos =   gerenciadorDeEventos.listarEventosPorCategoria(categoria);
    return ResponseEntity.ok(listaDeEventos);
  }

}
