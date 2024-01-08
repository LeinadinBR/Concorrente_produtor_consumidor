import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.GridLayout;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matricula: 201911910
Inicio...: 23 de Maio de 2021
Alteracao: 23 de Maio de 2021
Nome.....: FrameSlider
Funcao...: Classe que contem os sliders que controlam a velocidade das abelhas. Herda de JPanel 
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class FrameSlider extends JPanel {
  private JSlider[] sliders;
  private JLabel[] labels;

  /* *********************
  * Metodo: FrameSlider
  * Funcao: Construtor
  * Parametros: nenhum
  ********************* */
  public FrameSlider(){
    inicializar();
    this.setSize(new Dimension(150, 600));
  }

  /* *********************
  * Metodo: inicializar
  * Funcao: incializa todos atributos e melhora o design  
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void inicializar(){
    sliders = new JSlider[5];
    labels = new JLabel[5];
    this.setBackground(new Color(215, 230, 140));
    this.setLayout(new GridLayout(10,1,20,25));

    for (int i=0; i<5; i++){
      sliders[i] = new JSlider(0,10,0);
      sliders[i].setBackground(new Color(190, 205, 125));

      labels[i] = new JLabel("            Abelha " + (i+1));
      labels[i].setFont(new Font("Times New Roman", Font.BOLD, 20));

      this.add(labels[i]);
      this.add(sliders[i]);
    }
  }

  //metodos getters e setters
  public JSlider[] getSliders() {
    return sliders;
  }

  public void setSliders(JSlider[] sliders) {
    this.sliders = sliders;
  }

  public JLabel[] getLabels() {
    return labels;
  }

  public void setLabels(JLabel[] labels) {
    this.labels = labels;
  }
}
