/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 21 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: Abelha
Funcao...: Classe para servir de base o produtor e consumidor. Herda de Thread
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public abstract class Abelha extends Thread {
  protected int x;
  protected int y;
  protected Sprite[] imagem;
  protected int inicioPercurso;   //marca o pixel do inicio do percurso
  protected int finalPercurso;    //marca o pixel do final do percurso
  protected int velocidade=0;
  protected int imagemAtual=0;

  /* *********************
  * Metodo: Abelha
  * Funcao: Construtor
  * Parametros: int x, int y, Sprite[] imagem
  ********************* */
  public Abelha(int x, int y, Sprite[] imagem){
    this.x = x;
    this.y = y;
    this.imagem = imagem;
  }

  /* *********************
  * Metodo: dormir
  * Funcao: esperar um determinado tempo com base na velocidade
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void dormir(){
    try {
      if (velocidade!=0) {
        sleep(100/velocidade);
        return;
      }
      while (velocidade == 0)
        sleep(1000);
    } 
    catch (InterruptedException e) {}
  }

  /* *********************
  * Metodo: moverDireita
  * Funcao: move o objeto de Abelha para a direita
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void moverDireita(){
    x++;
  }

  /* *********************
  * Metodo: moverEsquerda
  * Funcao: move o obejeto de Abelha para a esquerda
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void moverEsquerda(){
    x--;
  }

  //metodos getters e setters
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Sprite getImagemAtual() {
    return imagem[imagemAtual];
  }

  public Sprite[] getImagem(){
    return this.imagem;
  }

  public void setImagem(Sprite[] imagem) {
    this.imagem = imagem;
  }

  public int getInicioPercurso() {
    return inicioPercurso;
  }

  public void setInicioPercurso(int inicioPercurso) {
    this.inicioPercurso = inicioPercurso;
  }

  public int getFinalPercurso() {
    return finalPercurso;
  }

  public void setFinalPercurso(int finalPercurso) {
    this.finalPercurso = finalPercurso;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  public void setImagemAtual(int imagemAtual) {
    this.imagemAtual = imagemAtual;
  }
}
