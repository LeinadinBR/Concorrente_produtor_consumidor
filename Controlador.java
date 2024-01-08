import java.util.concurrent.Semaphore;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 21 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: Controlador
Funcao...: Classe que manipula os semaforos e buffer
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Controlador {

  private int bufferCount=0;               //contador para indicar quantos espacos do buffer estao ocupados
  private Semaphore empty, full, mutex;    //semaforos para a execucao da zona critica
  private int bufferTamanho;               //tamanho total do buffer
  private Vetor[] posicoesBuffer = {new Vetor(420, 50), new Vetor(420, 98), new Vetor(420, 146), new Vetor(420, 194),
    new Vetor(420, 242), new Vetor(420, 290), new Vetor(420, 338), new Vetor(420, 386), new Vetor(420, 434),
    new Vetor(420, 482)};                  //arranjo com todas as posicoes que os favos podem aparecer

  /* *********************
  * Metodo: Controlador
  * Funcao: Construtor
  * Parametros: int tamanho
  ********************* */
  public Controlador(int tamanho){
    bufferTamanho = tamanho;
    inicializar();
  }

  /* *********************
  * Metodo: inicializar
  * Funcao: inicializa os semaforos
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void inicializar(){
    empty = new Semaphore(bufferTamanho, true);
    full = new Semaphore(0, true);
    mutex = new Semaphore(1, true);
  }

  /* *********************
  * Metodo: encher
  * Funcao: verifica se pode encher o estoque de favos, e caso possa o faz
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void encher(){
    if (bufferCount<10)
      bufferCount++;
  }

  /* *********************
  * Metodo: esvaziar
  * Funcao: verifica se pode esvaziar o estoque de favos, e caso possa o faz
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void esvaziar(){
    if (bufferCount>0)
      bufferCount--;
  }

  //metodos getters e setters
  public Semaphore getEmpty() {
    return empty;
  }

  public void setEmpty(Semaphore empty) {
    this.empty = empty;
  }

  public Semaphore getFull() {
    return full;
  }

  public void setFull(Semaphore full) {
    this.full = full;
  }

  public Semaphore getMutex() {
    return mutex;
  }

  public void setMutex(Semaphore mutex) {
    this.mutex = mutex;
  }

  public int getBufferCount() {
    return bufferCount;
  }

  public void setBufferCount(int bufferCount) {
    this.bufferCount = bufferCount;
  }

  public Vetor[] getPosicoesBuffer() {
    return posicoesBuffer;
  }

  public void setPosicoesBuffer(Vetor[] posicoesBuffer) {
    this.posicoesBuffer = posicoesBuffer;
  } 
}
