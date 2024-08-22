package br.com.fiap.evento;

import br.com.fiap.evento.exceptions.ParticipanteJaExistenteException;
import br.com.fiap.evento.exceptions.ParticipanteNaoEncontradoException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EventoImpl implements Evento {

    private String nome;
    private LocalDateTime dataHora;
    private Categoria categoria;
    private Set<String> participantes;

    public EventoImpl(String nome, LocalDateTime dataHora, Categoria categoria) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.categoria = categoria;
        this.participantes = new HashSet<>();
    }

    public EventoImpl() {
    }

    @Override
    public void adicionarParticipante(String participante) throws ParticipanteJaExistenteException {
        if (!participantes.add(participante)) {
            throw new ParticipanteJaExistenteException("Participante já existe: " + participante);
        }

    }

    @Override
    public void removerParticipante(String participante) throws ParticipanteNaoEncontradoException {
        if (!participantes.remove(participante)) {
            throw new ParticipanteNaoEncontradoException("Participante não encontrado: " + participante);
        }
    }

    @Override
    public Set<String> listarParticipantes() {
        return Collections.unmodifiableSet(participantes);
    }

    @Override
    public long contarParticipantes() {
        return participantes.size();
    }

    @Override
    public Set<String> listarParticipantesOrdenados() {
        return participantes.stream()
                .sorted()
                .collect(Collectors.toCollection(HashSet::new));

    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void setParticipantes(Set<String> participantes) {
    this.participantes = participantes;
  }
}
