package br.gov.cursoSelenium.core;

import static br.gov.cursoSelenium.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	private WebElement element;
	
	
	public void escreve(String idCampo, String texto) {
		escreve(By.id(idCampo), texto);
	}

	public void escreve(By by, String texto) {		 
		apagarCampo(by);
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public Boolean isRadioMarcado(By by) {		 
		return getDriver().findElement(by).isSelected();
	}
	
	public Boolean isSelecionado(By by,String opcao) {		 
		return getDriver().findElement(by).getText().equals(opcao);
	}
	
	public String obterValorCampo(String idCampo) {
		return(getDriver().findElement(By.id(idCampo)).getAttribute("value"));

	}

	public String obterTextoCampo(String idCampo) {
		return(getDriver().findElement(By.id(idCampo)).getText());

	}

	public String obterTextoCampo(By by) {
		return(getDriver().findElement(by).getText());

	}

	public void clicar(String idCampo) {
		getDriver().findElement(By.id(idCampo)).click();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarLink(String texto) {
		getDriver().findElement(By.linkText(texto)).click();
	}

	public boolean checar(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void selectCombo (String id, String valor) {
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);

	}

	public void desSelectCombo (String id, String valor) {
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);

	}

	public String primeiroValorCombo(String id) {
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public void selecionaItem(String id, String item) {
		new Select(getDriver().findElement(By.id(id)))
		.selectByVisibleText(item);
	}
	
	public void clicarBotaoPorTexto(String texto){
		clicar(By.xpath("//button[contains(.,'"+texto+"')]"));
		
	}

	public int qtdElementos(String id) {
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean hasItem(String id, String item) {
		boolean encontrou = false;
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();		

		for(WebElement option: options) {
			if(option.getText().equals(item)){
				encontrou = true;
				break;
			}

		}
		return encontrou;
	}


	public int qtdSelecionados(String id) {
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		return allSelectedOptions.size();
	}

	public Alert getAlert() {
		return getDriver().switchTo().alert();
	}

	public void trocaFrame(String frame) {
		if (frame.isEmpty()) {
			getDriver().switchTo().defaultContent();
		}else {
			getDriver().switchTo().frame(frame);
		}
	}
	public void trocaJanela(String win) {
		getDriver().switchTo().window(win);
	}	

	public void apagarCampo(By by) {
		getDriver().findElement(by).clear();
	}

	/**************JS********************************************/	
	public Object executarJS(String texto, Object... param) {		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(texto, param);
	}
	/************** Tabelas ********************************************/	

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTag) {
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTag);       
        celula.findElement(By.xpath(".//input")).click();
		

	}
	
	public void clicarAcao(String colunaBusca, String valor, String colunaBotao, String idTag) {
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTag);       
        celula.findElement(By.xpath(".//span")).click();
		

	}
	
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTag) {
		WebElement tabela = getDriver().findElement(By.xpath("//table[@id='"+idTag+"']"));
		//procurar coluna do registro
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		//descobrir a coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		return celula;
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));   
		int idLinha = -1;
		for (int i=0;i<linhas.size();i++){
			if (linhas.get(i).getText().equals(valor)){
				idLinha=i+1;
				break;
			}
		}
		return idLinha;
	}
	
	
	

	private int obterIndiceColuna(String colunaBusca, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i=0;i<colunas.size();i++){
			if (colunas.get(i).getText().equals(colunaBusca)){
				idColuna=i+1;
				break;
			}
		}
		return idColuna;
	}

	public String obterMensagemSucesso() {
		return obterTextoCampo(By.xpath("//div[@class='alert alert-success']"));
		
	}

	public String obterMensagemErro() {
		return obterTextoCampo(By.xpath("//div[@class='alert alert-danger']"));
		
	}
	
	public List<String> retornaErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> textErros = new ArrayList<String>();
		for (WebElement error:erros){
			textErros.add(error.getText());
		}
		return textErros;		
	}
	
}
