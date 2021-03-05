package com.sifissomuianga.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifissomuianga.cursomc.domain.Categoria;
import com.sifissomuianga.cursomc.domain.Cidade;
import com.sifissomuianga.cursomc.domain.Cliente;
import com.sifissomuianga.cursomc.domain.Endereco;
import com.sifissomuianga.cursomc.domain.Estado;
import com.sifissomuianga.cursomc.domain.ItemPedido;
import com.sifissomuianga.cursomc.domain.Pagamento;
import com.sifissomuianga.cursomc.domain.PagamentoComBoleto;
import com.sifissomuianga.cursomc.domain.PagamentoComCartao;
import com.sifissomuianga.cursomc.domain.Pedido;
import com.sifissomuianga.cursomc.domain.Produto;
import com.sifissomuianga.cursomc.domain.enums.EstadoPagamento;
import com.sifissomuianga.cursomc.domain.enums.TipoCliente;
import com.sifissomuianga.cursomc.domain.enums.TipoDocumento;
import com.sifissomuianga.cursomc.repositories.CategoriaRepository;
import com.sifissomuianga.cursomc.repositories.CidadeRepository;
import com.sifissomuianga.cursomc.repositories.ClienteRepository;
import com.sifissomuianga.cursomc.repositories.EnderecoRepository;
import com.sifissomuianga.cursomc.repositories.EstadoRepository;
import com.sifissomuianga.cursomc.repositories.ItemPedidoRepository;
import com.sifissomuianga.cursomc.repositories.PagamentoRepository;
import com.sifissomuianga.cursomc.repositories.PedidoRepository;
import com.sifissomuianga.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Electrodomésticos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 35000.00);
		Produto p2 = new Produto(null, "Mouse", 350.00);
		Produto p3 = new Produto(null, "Impressora", 3500.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 1590.00);
		Produto p5 = new Produto(null, "Tolha", 450.00);
		Produto p6 = new Produto(null, "Colchão", 1200.00);
		Produto p7 = new Produto(null, "TV true color", 12000.00);
		Produto p8 = new Produto(null, "Roçadeira", 2800.00);
		Produto p9 = new Produto(null, "Abajour", 700.00);
		Produto p10 = new Produto(null, "Pendente", 350.00);
		Produto p11 = new Produto(null, "Shampoo", 650.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat2, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4,cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		Estado distrito1 = new Estado(null, "Boane");
		Estado distrito2 = new Estado(null, "Matola");
		
		Cidade c1 = new Cidade(null, "Capoane", distrito1);
		Cidade c2 = new Cidade(null, "Belo Horizonte", distrito2);
		Cidade c3 = new Cidade(null, "Matola Rio", distrito2);
		
		distrito1.getCidades().addAll(Arrays.asList(c1));
		distrito2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(distrito1, distrito2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Sifisso Muianga", "abeleduardo943@gmail.com", "110101522148M", TipoCliente.PESSOAFISICA, TipoDocumento.BILHETEDEINDENTIDADE);
		cli1.getTelefones().addAll(Arrays.asList("847880867", "845868327"));
		Endereco e1 = new Endereco(null, "Machava Socimol", "9", "34", cli1, c1);
		Endereco e2 = new Endereco(null,"Tchumene 2" , "20", "64", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("11/01/2021 12:53"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("05/12/2020 10:43"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.LIQUIDADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("01/01/2021 13:16"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 3500.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 350.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 3400.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}
}
