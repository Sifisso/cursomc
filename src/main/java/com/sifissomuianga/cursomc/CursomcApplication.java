package com.sifissomuianga.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sifissomuianga.cursomc.domain.Categoria;
import com.sifissomuianga.cursomc.domain.Cidade;
import com.sifissomuianga.cursomc.domain.Cliente;
import com.sifissomuianga.cursomc.domain.Endereco;
import com.sifissomuianga.cursomc.domain.Estado;
import com.sifissomuianga.cursomc.domain.Produto;
import com.sifissomuianga.cursomc.domain.enums.TipoCliente;
import com.sifissomuianga.cursomc.domain.enums.TipoDocumento;
import com.sifissomuianga.cursomc.repositories.CategoriaRepository;
import com.sifissomuianga.cursomc.repositories.CidadeRepository;
import com.sifissomuianga.cursomc.repositories.ClienteRepository;
import com.sifissomuianga.cursomc.repositories.EnderecoRepository;
import com.sifissomuianga.cursomc.repositories.EstadoRepository;
import com.sifissomuianga.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 35000.00);
		Produto p2 = new Produto(null, "Impressora", 3500.00);
		Produto p3 = new Produto(null, "Mouse", 350.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado distrito1 = new Estado(null, "Boane");
		Estado distrito2 = new Estado(null, "Matola");
		
		Cidade c1 = new Cidade(null, "Capoane", distrito1);
		Cidade c2 = new Cidade(null, "Belo Horizonte", distrito2);
		Cidade c3 = new Cidade(null, "Matola Rio", distrito2);
		
		distrito1.getCidades().addAll(Arrays.asList(c1));
		distrito2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(distrito1, distrito2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Sifisso Muiaga", "sifissom@gmail.com", "110101522148M", TipoCliente.PESSOAFISICA, TipoDocumento.BILHETEDEINDENTIDADE);
		cli1.getTelefones().addAll(Arrays.asList("847880867", "845868327"));
		Endereco e1 = new Endereco(null, "Machava Socimol", "9", "34", cli1, c1);
		Endereco e2 = new Endereco(null,"Tchumene 2" , "20", "64", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		//Cliente cli2 = new Cliente(null, "Sifisso Muiaga", "sifissom@gmail.com", "110101522148M", TipoCliente.PESSOAFISICA, TipoDocumento.BILHETEDEINDENTIDADE);
		
		
	}

}
