/**
 * 
 */
package br.com.zap.selecao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zap.selecao.domain.Candidato;

/**
 * @author VVM1219
 *
 */
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

}
