package br.com.wesleycastilho.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wesleycastilho.fullstackweek.domain.Pessoa;
import br.com.wesleycastilho.fullstackweek.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository  pessoaRepository;
	
	@GetMapping
	public List<Pessoa> ListarTodos(){
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@PatchMapping("/{codigo}")
	public Pessoa atualizar(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa){
		return pessoaRepository.findById(codigo).map(
				record ->{
					record.setCpf(pessoa.getCpf());
					record.setDataNascimento(pessoa.getDataNascimento());
					record.setEmail(pessoa.getEmail());
					record.setIdade(pessoa.getIdade());
					record.setTelefone(pessoa.getTelefone());
					return pessoaRepository.save(record);
				}).orElse(null);
	}
	
	@GetMapping("/{codigo}")
	public Pessoa buscaPeloCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo).orElse(null);
	}
	
	
}
