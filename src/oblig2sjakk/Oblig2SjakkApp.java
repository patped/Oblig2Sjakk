package oblig2sjakk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Oblig2SjakkApp extends Application {

  StackPane stakk = new StackPane();
  GridPane bakgrunn = new GridPane();
  GridPane forgrunn = new GridPane();
  BorderPane ramme = new BorderPane();
  BorderPane rammeramme = new BorderPane();
  Brett spillebrettet = new Brett(1);
  TextField flyttBrikkeTekst;
  TextField valgtBrikkeTekst;

  HBox bokstavRekke = new HBox();
  HBox bokstavRekke2 = new HBox();
  VBox tallRekke = new VBox();
  VBox tallRekke2 = new VBox();
  HBox brukerBehandling = new HBox();
  private final int STØRRELSEBRETT = 8;
  private final int RECTSTØRRELSE = 55;

  @Override
  public void start(Stage primaryStage) {

    bokstavRekke = lagBokstavRekke();
    bokstavRekke2 = lagBokstavRekke();
    tallRekke = lagTallRekke();
    tallRekke2 = lagTallRekke();
    rammeramme.setCenter(ramme);
    ramme.setLeft(tallRekke2);
    ramme.setRight(tallRekke);
    ramme.setTop(bokstavRekke);
    ramme.setBottom(bokstavRekke2);
    ramme.setCenter(stakk);

    stakk.getChildren().add(bakgrunn);
    stakk.getChildren().add(forgrunn);
    brukerBehandling.setPrefHeight(20);
    rammeramme.setBottom(brukerBehandling);

    lagBrukerBehandling();
    lagbrett(spillebrettet);

    Scene scene = new Scene(rammeramme,
        (STØRRELSEBRETT * RECTSTØRRELSE) + RECTSTØRRELSE * 2 - 10,
        (STØRRELSEBRETT * RECTSTØRRELSE) + RECTSTØRRELSE * 2 + 25 - 10);

    primaryStage.setTitle("Sjakk!");
    primaryStage.setScene(scene);
    primaryStage.setResizable(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private void lagBrukerBehandling() {
    int feltHøyde = 25;
    Label tekstValgBrikke = new Label("Valgt brikke:");
    tekstValgBrikke.setPrefHeight(feltHøyde);
    Label tekstFlyttBrikke = new Label("Flytt til felt:");
    tekstFlyttBrikke.setPrefHeight(feltHøyde);
    valgtBrikkeTekst = new TextField();
    valgtBrikkeTekst.setPrefWidth(RECTSTØRRELSE);
    valgtBrikkeTekst.setPrefHeight(feltHøyde);
    flyttBrikkeTekst = new TextField();
    flyttBrikkeTekst.setPrefHeight(feltHøyde);
    flyttBrikkeTekst.setPrefWidth(RECTSTØRRELSE);
    Button utførKnapp = new Button("Utfør trekk");
    brukerBehandling.getChildren().addAll(tekstValgBrikke, valgtBrikkeTekst,
        tekstFlyttBrikke, flyttBrikkeTekst, utførKnapp);
    brukerBehandling.setSpacing(10.0);
    utførKnapp.setOnAction(new knapplytter());
  }

  private void lagbrett(Brett spillebrettet) {
    for (int rad = 0; rad < STØRRELSEBRETT; rad++) {
      for (int kolonne = 0; kolonne < STØRRELSEBRETT; kolonne++) {

        if ((rad + kolonne) % 2 == 0) {
          Rectangle r = new Rectangle(RECTSTØRRELSE, RECTSTØRRELSE, Color.WHITE);
          bakgrunn.add(r, kolonne, rad);
        }
        if ((rad + kolonne) % 2 == 1) {
          Rectangle r = new Rectangle(RECTSTØRRELSE, RECTSTØRRELSE, Color.GRAY);
          bakgrunn.add(r, kolonne, rad);
        }
        if (spillebrettet.brikker[kolonne][rad] == null) {
          Rectangle r = new Rectangle();
          r.setHeight(RECTSTØRRELSE);
          r.setWidth(RECTSTØRRELSE);
          r.setFill(Color.TRANSPARENT);
          forgrunn.add(r, kolonne, rad);
        } else if (spillebrettet.brikker[kolonne][rad].isFarge() == false) {

          if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("t")) {//Legger til svart tårn
            addTårn(kolonne, rad, false);
          } else if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("k")) {
            addKonge(kolonne, rad, false);
          } else if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("b")) {
            addBonde(kolonne, rad, false);
          }
        } else if (spillebrettet.brikker[kolonne][rad].isFarge() == true) {

          if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("t")) {//Legger til svart tårn
            addTårn(kolonne, rad, true);
          } else if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("k")) {
            addKonge(kolonne, rad, true);
          } else if (spillebrettet.brikker[kolonne][rad].brikkenavn().equals("b")) {
            addBonde(kolonne, rad, true);
          }
        }

      }
    }
  }

  private void addTårn(int kolonne, int rad, boolean svartEllerHvit) {
    Brikke tårnBrikke = new Tårn("a1", svartEllerHvit, spillebrettet);
    forgrunn.add(tårnBrikke, kolonne, rad);
  }

  private void addKonge(int kolonne, int rad, boolean svartEllerHvit) {
    Brikke tårnBrikke = new Konge("a1", svartEllerHvit, spillebrettet);
    forgrunn.add(tårnBrikke, kolonne, rad);
  }

  private void addBonde(int kolonne, int rad, boolean svartEllerHvit) {
    Brikke tårnBrikke = new Bonde("a1", svartEllerHvit, spillebrettet);
    forgrunn.add(tårnBrikke, kolonne, rad);
  }

  private HBox lagBokstavRekke() {
    HBox box = new HBox();
    for (int i = 0; i < STØRRELSEBRETT + 2; i++) {
      if (i == 0 || i == 9) {
        Rectangle r = new Rectangle(RECTSTØRRELSE, RECTSTØRRELSE, Color.BLACK);
        box.getChildren().add(r);
      } else {
        StackPane s = new StackPane();
        Rectangle r = new Rectangle(RECTSTØRRELSE, RECTSTØRRELSE, Color.FIREBRICK);
        char c = (char) (i + 96);
        Text t = new Text("" + c);
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        s.getChildren().addAll(r, t);
        box.getChildren().add(s);
      }
    }
    return box;
  }

  private VBox lagTallRekke() {
    VBox box = new VBox();
    for (int i = 0; i < STØRRELSEBRETT; i++) {
      StackPane s = new StackPane();
      Rectangle r = new Rectangle(RECTSTØRRELSE, RECTSTØRRELSE, Color.FIREBRICK);
      char c = (char) (56 - i);
      Text t = new Text("" + c);
      t.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
      s.getChildren().addAll(r, t);
      box.getChildren().add(s);
    }
    return box;
  }

  private class knapplytter implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
      spillebrettet.flyttBrikke(valgtBrikkeTekst.getText(), flyttBrikkeTekst.getText());
    }

  }
}
