package br.com.zap.selecao.service;

import br.com.zap.selecao.domain.Candidato;
import br.com.zap.selecao.exception.ResourceNotFoundException;
import br.com.zap.selecao.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato buscarPorId(Long id) {
        verificarSeCandidatoExiste(id);
        return candidatoRepository.findById(id).get();
    }

    public Candidato atualizar(Candidato candidato) {
        verificarSeCandidatoExiste(candidato.getId());
        return candidatoRepository.save(candidato);
    }

    public void deletar(Long id) {
        verificarSeCandidatoExiste(id);
        candidatoRepository.deleteById(id);
    }

    private void verificarSeCandidatoExiste(Long id) {
        if (!candidatoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não existe candidato com o ID: " + id);
        }
    }
}
