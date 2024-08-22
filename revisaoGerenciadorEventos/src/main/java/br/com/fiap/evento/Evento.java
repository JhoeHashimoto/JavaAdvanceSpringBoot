package br.com.fiap.evento;
import br.com.fiap.evento.exceptions.ParticipanteJaExistenteException;
import br.com.fiap.evento.exceptions.ParticipanteNaoEncontradoException;

import java.util.Set;

public interface Evento {

    void adicionarParticipante(String participante) throws ParticipanteJaExistenteException;
    void removerParticipante(String participante) throws ParticipanteNaoEncontradoException;
    Set<String> listarParticipantes();

    // Novos métodos para funcionalidades avançadas
    long contarParticipantes();
    Set<String> listarParticipantesOrdenados();

}
