package pe.edu.upeu.tresraya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pe.edu.upeu.modelo.Juego;
import pe.edu.upeu.modelo.Jugador;
import java.util.Random;

public class HelloController {
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Label lblTurno;
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnAnular;
    @FXML
    private TextField txtJugador1;
    @FXML
    private TextField txtJugador2;

    private Jugador[] jugadores = new Jugador[2];

    private int jugadorActual; // Para alternar turnos
    @FXML
    private TableColumn<Jugador, String> numeroPartida;
    @FXML
    private TableColumn<Jugador, String> nombreJugador1;
    @FXML
    private TableColumn<Jugador, String> nombreJugador2;
    @FXML
    private TableColumn<Jugador, String> nombreGanador;
    @FXML
    private TableColumn<Jugador, Integer> puntuacion;
    @FXML
    private TableColumn<Jugador, String> estado;
    @FXML
    private TableView<Juego> tableView;
    private ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();
    int contador = 0;
    private int numeroPartidas = 1;

    // Metodo Constructor
    public HelloController() {
        jugadorActual = jugadorRandom();
    }

    @FXML
    protected void change0() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn0.setText(jugadores[jugadorActual].getSimbolo());
        btn0.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change1() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn1.setText(jugadores[jugadorActual].getSimbolo());
        btn1.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change2() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn2.setText(jugadores[jugadorActual].getSimbolo());
        btn2.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change3() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn3.setText(jugadores[jugadorActual].getSimbolo());
        btn3.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change4() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn4.setText(jugadores[jugadorActual].getSimbolo());
        btn4.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change5() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn5.setText(jugadores[jugadorActual].getSimbolo());
        btn5.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change6() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn6.setText(jugadores[jugadorActual].getSimbolo());
        btn6.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void chang7() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn7.setText(jugadores[jugadorActual].getSimbolo());
        btn7.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    @FXML
    protected void change8() {
        // Aquí ya tienes inicializados los jugadores cuando se ejecuta el método
        btn8.setText(jugadores[jugadorActual].getSimbolo());
        btn8.setDisable(true);
        buscarGanador();
        cambiarTurno();
    }

    public void cambiarTurno() {
        //jugadorActual = (jugadorActual + 1) % 2; // tambien funciona

        if (jugadorActual == 0) {
            jugadorActual = 1;
        } else {
            jugadorActual = 0;
        }
        lblTurno.setText(jugadores[jugadorActual].getNombre() + " " + jugadores[jugadorActual].getSimbolo());

    }


    public void buscarGanador() {

        System.out.println(contador);
        if (contador == 8) {

            if (compararElementos()) {
                System.out.println(jugadores[jugadorActual].getNombre());
                editarUltimoElemento(jugadores[jugadorActual].getNombre(), "Terminado", 1);
                iniciar();
            } else {
                System.out.println("empare");
                editarUltimoElemento("Empate", "Terminado", 0);
                iniciar();
            }
            limpiarJuego();
        } else {
            // 0 1 2
            if (compararElementos()) {
                System.out.println(jugadores[jugadorActual].getNombre());
                limpiarJuego();
                editarUltimoElemento(jugadores[jugadorActual].getNombre(), "Terminado", 1);
                iniciar();
            }
            else{
                contador = contador + 1;

            }
        }


    }

    void limpiarJuego() {
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
    }

    boolean compararElementos() {
        if (btn0.getText().equals(btn1.getText()) && btn0.getText().equals(btn2.getText()) && !btn0.getText().isEmpty()) {

            return true;

        }
        // 3 4 5
        if (btn3.getText().equals(btn4.getText()) && btn3.getText().equals(btn5.getText()) && !btn3.getText().isEmpty()) {
            return true;
        }
        // 6 7 8
        if (btn6.getText().equals(btn7.getText()) && btn6.getText().equals(btn8.getText()) && !btn6.getText().isEmpty()) {
            return true;
        }
        // 0 3 6
        if (btn0.getText().equals(btn3.getText()) && btn0.getText().equals(btn6.getText()) && !btn0.getText().isEmpty()) {
            return true;
        }
        // 1 4 7
        if (btn1.getText().equals(btn4.getText()) && btn1.getText().equals(btn7.getText()) && !btn1.getText().isEmpty()) {
            return true;
        }
        // 2 5 8
        if (btn2.getText().equals(btn5.getText()) && btn2.getText().equals(btn8.getText()) && !btn2.getText().isEmpty()) {
            return true;
        }
        // 0 4 8
        if (btn0.getText().equals(btn4.getText()) && btn0.getText().equals(btn8.getText()) && !btn0.getText().isEmpty()) {
            return true;
        }
        // 6 4 2
        if (btn6.getText().equals(btn4.getText()) && btn6.getText().equals(btn2.getText()) && !btn6.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    @FXML
    public void initialize() {
        // Vincular las columnas a las propiedades de la clase Operacion
        numeroPartida.setCellValueFactory(new PropertyValueFactory<>("numeroPartida"));
        nombreJugador1.setCellValueFactory(new PropertyValueFactory<>("nombreJugador1"));
        nombreJugador2.setCellValueFactory(new PropertyValueFactory<>("nombreJugador2"));
        nombreGanador.setCellValueFactory(new PropertyValueFactory<>("nombreGanador"));
        puntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        desactivarJuego();
        txtJugador1.setText("Jugador 1");
        txtJugador2.setText("Jugador 2");
        btnIniciar.getStyleClass().addAll("btn", "btn-primary");
        btnAnular.getStyleClass().addAll("btn", "btn-danger");





        // Asignar la lista observable al TableView
        tableView.setItems(listaJuegos);
    }

    public void activarJuego() {
        btn0.setDisable(false);
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btnIniciar.setDisable(true);
        btnAnular.setDisable(false);
        txtJugador1.setDisable(true);
        txtJugador2.setDisable(true);

    }

    public void desactivarJuego() {
        btn0.setDisable(true);
        btn1.setDisable(true);
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn4.setDisable(true);
        btn5.setDisable(true);
        btn6.setDisable(true);
        btn7.setDisable(true);
        btn8.setDisable(true);
        btnAnular.setDisable(true);
        btnIniciar.setDisable(false);
        txtJugador1.setDisable(false);
        txtJugador2.setDisable(false);



    }

    public int jugadorRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    @FXML
    public void iniciar() {
        activarJuego();
        contador=0;
        Jugador j1=new Jugador();
        j1.setNombre(txtJugador1.getText());
        j1.setSimbolo("X");

        jugadores[0] = j1;
        jugadores[1] = new Jugador(txtJugador2.getText(), "O");
        agregar("", "Jugando", 0);
        limpiarJuego();
        numeroPartidas = numeroPartidas + 1;
        lblTurno.setText(jugadores[jugadorActual].getNombre() + " " + jugadores[jugadorActual].getSimbolo());

    }

    @FXML
    public void anular() {
        desactivarJuego();
        editarUltimoElemento("Anulado", "Anulado", 0);
    }

    @FXML
    public void agregar(String ganador, String estado, Integer puntuacion) {

        Juego juego = new Juego();
        juego.setNumeroPartida("Partida " + numeroPartidas);
        juego.setNombreJugador1(jugadores[0].getNombre());
        juego.setNombreJugador2(jugadores[1].getNombre());
        juego.setNombreGanador(ganador);
        juego.setPuntuacion(puntuacion);
        juego.setEstado(estado);

        listaJuegos.add(juego);

    }

    public void editarUltimoElemento(String nombreGanador, String estado, int nuevoPuntaje) {
        if (!listaJuegos.isEmpty()) {
            Juego ultimoJuego = listaJuegos.get(listaJuegos.size() - 1);  // Obtener el último elemento
            ultimoJuego.setNombreGanador(nombreGanador);  // Editar el nombre (suponiendo que la clase Juego tiene este método)
            ultimoJuego.setPuntuacion(nuevoPuntaje);  // Editar el puntaje (si existe este método)
            ultimoJuego.setEstado(estado);
            tableView.refresh();

        } else {
            System.out.println("La lista está vacía, no hay elementos para editar.");
        }
    }
}