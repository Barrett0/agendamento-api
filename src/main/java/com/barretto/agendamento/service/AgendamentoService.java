package com.barretto.agendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barretto.agendamento.dto.AgendamentoDTO;
import com.barretto.agendamento.modelo.Agendamento;
import com.barretto.agendamento.modelo.Usuario;
import com.barretto.agendamento.repository.AgendamentoRepository;
import com.barretto.agendamento.repository.UsuarioRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public AgendamentoService(AgendamentoRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Agendamento criar(AgendamentoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setServico(dto.servico());
        agendamento.setData(dto.data());
        agendamento.setHorario(dto.horario());
        agendamento.setUsuario(usuario);
        return repository.save(agendamento);
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public Agendamento atualizar(Long id, AgendamentoDTO dto) {
        Agendamento agendamento = buscarPorId(id);
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        agendamento.setServico(dto.servico());
        agendamento.setData(dto.data());
        agendamento.setHorario(dto.horario());
        agendamento.setUsuario(usuario);
        return repository.save(agendamento);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        repository.deleteById(id);
    }
}
