/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 23 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: Vetor
Funcao...: Classe que serve como vetor de inteiros
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Vetor {
  private int num1;
  private int num2;
  
  /* *********************
  * Metodo: Vetor
  * Funcao: Construtor
  * Parametros: int num1, int num2
  ********************* */
  public Vetor(int num1, int num2){
    this.num1 = num1;
    this.num2 = num2;
  }

  //metodos getters e setters
  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }
}
