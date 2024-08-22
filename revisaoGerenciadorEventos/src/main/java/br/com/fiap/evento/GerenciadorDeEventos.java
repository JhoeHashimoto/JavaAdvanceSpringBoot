package br.com.fiap.evento;

import br.com.fiap.evento.exceptions.EventoNaoEncontradoException;

import java.util.List;
import java.util.Map;

public interface GerenciadorDeEventos {

  EventoImpl adicionarEvento(EventoImpl evento);

  void removerEvento(String nomeEvento) throws EventoNaoEncontradoException;

  List<Evento> listarEventosPorCategoria(Categoria categoria);

  Map<Categoria,Long> contarEventosPorCategoria();

  long contarParticipantesTotal();

  Map<String,Long> contarParticipantesPorEvento();

  Map<String, Long> contarParticipantesPorEventoOrdernado();

  Evento buscarEvento(String nomeEvento);

}
