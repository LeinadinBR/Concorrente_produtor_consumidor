import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 22 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: FrameAnimacao
Funcao...: Classe que contem o canvas onde a simulacao ocorre. Herda de JPanel
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class FrameAnimacao extends JPanel {
  
  private Display display;                 //objeto de display
  private BufferedImage imagem = new BufferedImage(900, 600, BufferedImage.TYPE_INT_BGR);  //imagem na qual um objeto 'Graphic' pode 'desenhar'
  private Consumidor[] consumidores;       //arranjo com os consumidores
  private Produtor[] produtores;           //arranjo com os produtores
  private Sprite background, flor, favo;   //Sprites do fundo, das flores e dos favos
  private boolean iniciado=false;          //variavel para verificar se as threads foram iniciadas
  private Controlador controlador;         //referencia de controlador

  /* *********************
  * Metodo: FrameAnimacao
  * Funcao: Construtor
  * Parametros: Consumidor[] consumidores, Produtor[] produtores, Controlador controlador
  ********************* */
  public FrameAnimacao(Consumidor[] consumidores, Produtor[] produtores, Controlador controlador){
    display = new Display();

    this.consumidores = consumidores;
    this.produtores = produtores;
    this.controlador = controlador;

    background = new Sprite("res/background.png");
    flor = new Sprite("res/flor.png");
    favo = new Sprite("res/favo.png");

    this.add(display.getTela(), BorderLayout.CENTER);
  }
  
  /* *********************
  * Metodo: renderizar
  * Funcao: renderizar os graficos da simulacao
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void renderizar(){
    if (!iniciado) { //inicializa as threads
      produtores[0].start();
      produtores[1].start();
      produtores[2].start();
      produtores[3].start();
      produtores[4].start(); 

      consumidores[0].start();
      consumidores[1].start();
      consumidores[2].start();
      consumidores[3].start();
      consumidores[4].start();

      iniciado=true;
    }

    while (true) {  //while infinito que desenha os graficos

      //criacao do objeto de desenho "Graphics 'g'"------------
      display.criarBufferStrategy();
      BufferStrategy bs = display.getTela().getBufferStrategy();
      if (bs == null) {
        display.criarBufferStrategy();
        bs = display.getTela().getBufferStrategy();
      }
      Graphics g = this.getGraphics();
      g = bs.getDrawGraphics();

      //Desenho dos graficos em si-----------------------------
      g.drawImage(background.getSprite(), 0, 0, null);

      g.drawImage(flor.getSprite(), 60, 50, 64, 64, null);
      g.drawImage(flor.getSprite(), 60, 160, 64, 64, null);
      g.drawImage(flor.getSprite(), 60, 270, 64, 64, null);
      g.drawImage(flor.getSprite(), 60, 380, 64, 64, null);
      g.drawImage(flor.getSprite(), 60, 490, 64, 64, null);

      g.drawImage(produtores[0].getImagemAtual().getSprite(), produtores[0].getX(), produtores[0].getY(), 64, 64, null);
      g.drawImage(produtores[1].getImagemAtual().getSprite(), produtores[1].getX(), produtores[1].getY(), 64, 64, null);
      g.drawImage(produtores[2].getImagemAtual().getSprite(), produtores[2].getX(), produtores[2].getY(), 64, 64, null);
      g.drawImage(produtores[3].getImagemAtual().getSprite(), produtores[3].getX(), produtores[3].getY(), 64, 64, null);
      g.drawImage(produtores[4].getImagemAtual().getSprite(), produtores[4].getX(), produtores[4].getY(), 64, 64, null);

      g.drawImage(consumidores[0].getImagemAtual().getSprite(), consumidores[0].getX(), consumidores[0].getY(), 64, 64, null);
      g.drawImage(consumidores[1].getImagemAtual().getSprite(), consumidores[1].getX(), consumidores[1].getY(), 64, 64, null);
      g.drawImage(consumidores[2].getImagemAtual().getSprite(), consumidores[2].getX(), consumidores[2].getY(), 64, 64, null);
      g.drawImage(consumidores[3].getImagemAtual().getSprite(), consumidores[3].getX(), consumidores[3].getY(), 64, 64, null);
      g.drawImage(consumidores[4].getImagemAtual().getSprite(), consumidores[4].getX(), consumidores[4].getY(), 64, 64, null);

      //desenha o numero de favos no buffer de acordo com a quantidade total que existe em controlador
      for (int i=0; i<controlador.getBufferCount(); i++){
        g.drawImage(favo.getSprite(), controlador.getPosicoesBuffer()[i].getNum1(), controlador.getPosicoesBuffer()[i].getNum2(), 64, 64, null);
      }
      //--------------------------------------------------------

      g.dispose(); //acaba com o objeto 'g' tirando sua referencia
      bs.show();   //torna o buffer, onde eh desenhado, visivel
    }
  }
}
