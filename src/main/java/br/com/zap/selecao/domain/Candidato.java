/**
 * 
 */
package br.com.zap.selecao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author VVM1219
 *
 */

@Entity
@Data
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotNull(message = "O campo cpf é obrigatório")
	private String cpf;
	
	@NotNull(message = "O campo data de nascimento é obrigatório")
	private LocalDate dataNascimento;

	@NotNull(message = "O campo rua é obrigatório")
	private String rua;
g
	@NotNull(message = "O campo bairro é obrigatório")
	private String bairro;

	@NotNull(message = "O campo numero é obrigatório")
	private int numero;
}
