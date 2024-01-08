import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 21 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: MainFrame
Funcao...: Classe que serve de 'janela' principal do programa
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class MainFrame extends JFrame {
  
  private Consumidor[] consumidores;    //arranjo de consumidores
  private Produtor[] produtores;        //arranjo de produtores
  private Controlador controlador;      //objeto de controlador
  private FrameAnimacao frameAnimacao;            //JPanel onde ocorre a simulacao
  private FrameSlider ladoEsquerdo, ladoDireito;  //JPanels laterais onde eh controlada as velocidades das abelhas

  /* *********************
  * Metodo: MainFrame
  * Funcao: Construtor 
  * Parametros: nenhum
  ********************* */
  public MainFrame(){
    inicializar();
    acoes();

    this.add(ladoEsquerdo, BorderLayout.WEST);
    this.add(frameAnimacao, BorderLayout.CENTER);
    this.add(ladoDireito, BorderLayout.EAST);

    this.setTitle("Produtor x Consumidor");
    this.setSize(new Dimension(1200, 640));
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setFocusable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    renderizar();
  }

  /* *********************
  * Metodo: inicializar
  * Funcao: incializa todos atributos
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void inicializar(){
    consumidores = new Consumidor[5];
    produtores = new Produtor[5];
    controlador = new Controlador(10);

    Sprite[] spritesAbelhas = {new Sprite("res/abelha_1.png"), new Sprite("res/abelha_2.png"), new Sprite("res/abelha_3.png")};

    produtores[0] = new Produtor(130, 50, spritesAbelhas, 60, 420, controlador);
    produtores[1] = new Produtor(130, 160, spritesAbelhas, 60, 420, controlador);
    produtores[2] = new Produtor(130, 270, spritesAbelhas, 60, 420, controlador);
    produtores[3] = new Produtor(130, 380, spritesAbelhas, 60, 420, controlador);
    produtores[4] = new Produtor(130, 490, spritesAbelhas, 60, 420, controlador);

    consumidores[0] = new Consumidor(730, 50, spritesAbelhas, 480, 760, controlador);
    consumidores[1] = new Consumidor(730, 160, spritesAbelhas, 480, 760, controlador);
    consumidores[2] = new Consumidor(730, 270, spritesAbelhas, 480, 760, controlador);
    consumidores[3] = new Consumidor(730, 380, spritesAbelhas, 480, 760, controlador);
    consumidores[4] = new Consumidor(730, 490, spritesAbelhas, 480, 760, controlador);

    frameAnimacao = new FrameAnimacao(consumidores, produtores, controlador);
    ladoEsquerdo = new FrameSlider();
    ladoDireito = new FrameSlider();
  }

  /* *********************
  * Metodo: renderizar
  * Funcao: chama o metodo renderizar de frameAnimacao
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void renderizar(){
    frameAnimacao.renderizar();
  }

  /* *********************
  * Metodo: acoes
  * Funcao: adiciona um listener de mudancas para os sliders
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void acoes(){
    ladoEsquerdo.getSliders()[0].addChangeListener(e -> {
      produtores[0].setVelocidade(ladoEsquerdo.getSliders()[0].getValue());
    });
    ladoEsquerdo.getSliders()[1].addChangeListener(e -> {
      produtores[1].setVelocidade(ladoEsquerdo.getSliders()[1].getValue());
    });
    ladoEsquerdo.getSliders()[2].addChangeListener(e -> {
      produtores[2].setVelocidade(ladoEsquerdo.getSliders()[2].getValue());
    });
    ladoEsquerdo.getSliders()[3].addChangeListener(e -> {
      produtores[3].setVelocidade(ladoEsquerdo.getSliders()[3].getValue());
    });
    ladoEsquerdo.getSliders()[4].addChangeListener(e -> {
      produtores[4].setVelocidade(ladoEsquerdo.getSliders()[4].getValue());
    });


    ladoDireito.getSliders()[0].addChangeListener(e -> {
      consumidores[0].setVelocidade(ladoDireito.getSliders()[0].getValue());
    });
    ladoDireito.getSliders()[1].addChangeListener(e -> {
      consumidores[1].setVelocidade(ladoDireito.getSliders()[1].getValue());
    });
    ladoDireito.getSliders()[2].addChangeListener(e -> {
      consumidores[2].setVelocidade(ladoDireito.getSliders()[2].getValue());
    });
    ladoDireito.getSliders()[3].addChangeListener(e -> {
      consumidores[3].setVelocidade(ladoDireito.getSliders()[3].getValue());
    });
    ladoDireito.getSliders()[4].addChangeListener(e -> {
      consumidores[4].setVelocidade(ladoDireito.getSliders()[4].getValue());
    });
  }
}
