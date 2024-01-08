/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 21 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: Consumidor
Funcao...: Classe que representa as abelhas consumidoras. Herda de Abelha
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Consumidor extends Abelha {

  private Controlador controlador; //referencia ao controlador

  /* *********************
  * Metodo: Consumidor
  * Funcao: Construtor
  * Parametros: int x, int y, Sprite[] imagem, int ini, int fin, Controlador controlador
  ********************* */
  public Consumidor(int x, int y, Sprite[] imagem, int ini, int fin, Controlador controlador){
    super(x, y, imagem);
    this.inicioPercurso = ini;
    this.finalPercurso = fin;
    this.controlador = controlador;
  }

  /* *********************
  * Metodo: run
  * Funcao: executa as acoes da thread
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  @Override 
  public void run(){
    ir();
  }

  /* *********************
  * Metodo: ir
  * Funcao: move o consumidor de sua posicao inicial ate a final
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void ir(){
    setImagemAtual(1);
    while (x>=inicioPercurso){
      dormir();
      moverEsquerda();
    }
    zonaCritica();
    voltar();
  }

  /* *********************
  * Metodo: voltar
  * Funcao: move o consumidor de dua posicao final ate a inicial
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void voltar(){
    setImagemAtual(2);
    while (x+64<=finalPercurso){
      dormir();
      moverDireita();
    }
    ir();
  }

  /* *********************
  * Metodo: zonaCritica
  * Funcao: executa a zona critica, a qual apenas uma thread pode acessar por vez
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void zonaCritica(){
    try {
      controlador.getFull().acquire();    //primeiro ele verifica se o full pode ser adquirido
      controlador.getMutex().acquire();   //solicita a vez pelo mutex

      controlador.esvaziar();             //chama o metodo esvaziar

      controlador.getEmpty().release();   //aumenta o espaco de vazios no empty
      controlador.getMutex().release();   //termina de usar sua vez no mutex
    } 
    catch (InterruptedException e) {}     
  }
}
