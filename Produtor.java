/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 21 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: Produtor
Funcao...: Classe que representa as abaelhas produtoras. Herda de Abelha
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Produtor extends Abelha {

  private Controlador controlador;  //referencia a controlador

  /* *********************
  * Metodo: Produtor
  * Funcao: Construtor 
  * Parametros: int x, int y, Sprite[] imagem, int ini, int fin, Controlador controlador
  ********************* */
  public Produtor(int x, int y, Sprite[] imagem, int ini, int fin, Controlador controlador){
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
  * Funcao: move o produtor de sua posicao inicial ate a final
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void ir(){
    setImagemAtual(0);
    while (x+64<=finalPercurso){
      dormir();
      moverDireita();
    }
    zonaCritica();
    voltar();
  }

  /* *********************
  * Metodo: voltar
  * Funcao: move o produtor de sua posicao final ate a inicial
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void voltar(){
    setImagemAtual(1);;
    while (x>=inicioPercurso){
      dormir();
      moverEsquerda();
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
      controlador.getEmpty().acquire();  //verifica se o tem espaco vazio
      controlador.getMutex().acquire();  //solicita a vez pelo mutex

      controlador.encher();              //chama o metodo encher

      controlador.getFull().release();   //aumenta um espaco para o full
      controlador.getMutex().release();  //termina sua vez no mutex
    } 
    catch (InterruptedException e) {}     
  }
}
