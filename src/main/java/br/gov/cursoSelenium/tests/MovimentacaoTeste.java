package br.gov.cursoSelenium.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.gov.cursoSelenium.core.BaseTest;
import br.gov.cursoSelenium.core.Propriedades;
import br.gov.cursoSelenium.pages.ContasPage;
import br.gov.cursoSelenium.pages.MenuPage;
import br.gov.cursoSelenium.pages.MovimentacaoPage;
import br.gov.cursoSelenium.utils.DataUtils;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTest{
    private MenuPage pageMenu = new MenuPage();
    private MovimentacaoPage movPage = new  MovimentacaoPage();
    private ContasPage contasPage = new ContasPage();
			
	@Test
	public void test1_inserirMovimentacaoTest (){
		pageMenu.acessarTelaInserirMovimentacao();
		movPage.setDataMovimentacao("01/04/2019");
		movPage.setDataPagamento("02/04/2019");
		movPage.setDescricao("Movimentacao da conta alterada 2");
		movPage.setInteressado("Maurício Paiva");
		movPage.setValor("45");
		movPage.selConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacao("pago");
		movPage.salvar();
		
		Assert.assertEquals(movPage.obterMensagemSucesso(), "Movimentação adicionada com sucesso!");
		
		
		
	}
	
	@Test
	public void test2_inserirMovimentacaoDataFuturaTest (){
		pageMenu.acessarTelaInserirMovimentacao();
		Date dataFutura = DataUtils.obterDatasComDiferencaDias(5);		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentacao da conta alterada");
		movPage.setInteressado("Maurício Paiva");
		movPage.setValor("45");
		movPage.selConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacao("pago");
		movPage.salvar();
		List<String> erros = movPage.retornaErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual",contasPage.obterMensagemErro());
		Assert.assertEquals(1, erros.size());		
		
	}
	
	@Test
	public void test3_camposObrigatoriosTest (){
		pageMenu.acessarTelaInserirMovimentacao();
		movPage.salvar();
		
		List<String> erros = movPage.retornaErros();		
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório","Data do pagamento é obrigatório","Descrição é obrigatório","Interessado é obrigatório","Valor é obrigatório","Valor deve ser um número")));
		Assert.assertTrue(erros.size()==6);
	}
	
	
	
	
	
	
	
	

}
