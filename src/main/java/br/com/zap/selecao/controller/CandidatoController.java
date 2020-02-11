/**
 *
 */
package br.com.zap.selecao.controller;

import java.util.List;
import java.util.Optional;

import br.com.zap.selecao.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zap.selecao.domain.Candidato;
import br.com.zap.selecao.repository.CandidatoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @author VVM1219
 *
 */

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Candidato> adicionar(@Valid @RequestBody Candidato candidato) {
        candidatoRepository.save(candidato);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(candidatoService.buscarPorId(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Candidato> atualizar(@Valid @RequestBody Candidato candidato) {
        return ResponseEntity.ok(candidatoService.atualizar(candidato));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        candidatoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
