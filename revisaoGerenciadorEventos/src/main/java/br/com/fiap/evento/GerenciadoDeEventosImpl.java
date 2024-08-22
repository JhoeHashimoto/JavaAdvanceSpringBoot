package br.com.fiap.evento;

import br.com.fiap.evento.exceptions.EventoNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciadoDeEventosImpl implements GerenciadorDeEventos {

  private List<EventoImpl> eventos;


  public GerenciadoDeEventosImpl() {
    this.eventos = new ArrayList<>();
  }

  @Override
  public EventoImpl adicionarEvento(EventoImpl evento) {
      eventos.add(evento);
      return evento;
  }

  @Override
  public void removerEvento(String nomeEvento) throws EventoNaoEncontradoException {
    EventoImpl eventoParaSerRemovido = eventos
      .stream()
      .filter(evento -> evento.getNome().equalsIgnoreCase(nomeEvento))
      .findFirst()
      .orElseThrow(() ->  new EventoNaoEncontradoException("Evento não encontrado com o nome:" + nomeEvento));

    // igual ao de cima
/*    for(EventoImpl evento : eventos) {
      if(evento.getNome().equalsIgnoreCase(nomeEvento)) {
        eventoParaSerRemovido = evento;
      }
    }
    if(eventoParaSerRemovido == null) {
      throw new EventoNaoEncontradoException("Evento não encontrado com o nome:" + nomeEvento));
    }*/

    eventos.remove(eventoParaSerRemovido);
  }

  @Override
  public List<Evento> listarEventosPorCategoria(Categoria categoria) {
    //percorrer e find por categoria
    List<Evento> eventosDaCategoria = new ArrayList<>();
    for(EventoImpl evento: eventos) {
      if(evento.getCategoria() == categoria) {
        eventosDaCategoria.add(evento);
      }
    }
    //mesmo coisa que o de cima
/*    return eventos.stream()
      .filter(evento -> evento.getCategoria() == categoria)
      .collect(Collectors.toList());*/

    return eventosDaCategoria;
  }

  @Override
  public Map<Categoria, Long> contarEventosPorCategoria() {
    return Map.of();
  }

  @Override
  public long contarParticipantesTotal() {
    return eventos.stream()
      .flatMap(evento -> evento.listarParticipantes().stream())
      .count();
  }

  @Override
  public Map<String, Long> contarParticipantesPorEvento() {
    return Map.of();
  }

  @Override
  public Map<String, Long> contarParticipantesPorEventoOrdernado() {
    return Map.of();
  }

  @Override
  public Evento buscarEvento(String nomeEvento) {
    return null;
  }
}
