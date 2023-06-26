package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

    int Kokis_Number = 0, id = 0, hide = 0;
Image backgroundImage;
BackgroundImage backgroundImg;
    AnimationTimer timer;
    Pane root = new Pane();
    StackPane spane = new StackPane();
    List drop = new ArrayList<>(30);
    Timeline timeline;
    double speed;
    double falling;
    Label lblScore, Remaining;
    int score, remain;
    FXMLLoader loader;
    Parent mainpage;
    public static Stage STage;
    Scene scene;
    public Stage st;
    public static int top1 = 0, top2 = 0, top3 = 0, top4 = 0, top5 = 0, Counter_tops = 1;
    boolean KokiSize = true;
    public static int flag;
    @Override
    public void start(Stage stage) throws Exception {
        st = stage;
        STage = stage;
        switch (flag) {
            case 0:
                   stage.setTitle("Start-Exit App");

        Button startButton = new Button("Start");
        Button exitButton = new Button("Exit");
                 backgroundImage = new Image("file:E:\\GD\\game\\game\\src\\game\\Background4.png");
                 backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        ); 
                  Image start = new Image("file:E:\\GD\\game\\game\\src\\game\\start-game.png");

        // Create an ImageView to display the image
        ImageView Start = new ImageView(start);
            Start.setLayoutX(259);
            Start.setLayoutY(233);
            Start.setFitHeight(127);
            Start.setFitWidth(204);
                  Image quit = new Image("file:E:\\GD\\game\\game\\src\\game\\quit-game.png");

        // Create an ImageView to display the image
        ImageView Quit = new ImageView(quit);
            Quit.setLayoutX(467);
            Quit.setLayoutY(234);
            Quit.setFitHeight(127);
            Quit.setFitWidth(204);
                
                
        Start.setOnMouseClicked(event -> {
            // Perform start button action here
            flag = 1;
        Game g = new game.Game();
            try {
                g.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Start button clicked!");
        });

        Quit.setOnMouseClicked(event -> {
            // Perform exit button action here
            stage.close();
        });

        AnchorPane pane1 = new AnchorPane();
        pane1.setBackground(new Background(backgroundImg));
        pane1.getChildren().addAll(Start, Quit);

        Scene scene = new Scene(pane1, 900, 500);
        stage.setScene(scene);
        stage.show();
                break;
            case 1:
                AnchorPane pane = new AnchorPane();
                Label l1 = new Label("1. 30 Kokis will fall from the ceiling , hunt them all to win");
                l1.setLayoutX(21);
                l1.setLayoutY(80);
                l1.setStyle("-fx-font-size: 24px;"); 
                l1.setTextFill(Color.WHITE);
                Label l2 = new Label("2. Each Kokis will Have Specific Score...");
                l2.setLayoutX(23);
                l2.setLayoutY(128);
                l2.setStyle("-fx-font-size: 24px;"); 
                l2.setTextFill(Color.WHITE);
                Label l3 = new Label("The 1 Score Kokis:");
                l3.setLayoutX(23);
                l3.setLayoutY(175);
                l3.setStyle("-fx-font-size: 24px;"); 
                l3.setTextFill(Color.WHITE);
                Label l4 = new Label("The 2 Score Kokis:");
                l4.setLayoutX(23);
                l4.setLayoutY(253);
                l4.setStyle("-fx-font-size: 24px;"); 
                l4.setTextFill(Color.WHITE);
                Label l5 = new Label("The 3 Score Kokis:");
                l5.setLayoutX(27);
                l5.setLayoutY(321);
                l5.setStyle("-fx-font-size: 24px;"); 
                l5.setTextFill(Color.WHITE);
                Label l6 = new Label("The 4 Score Kokis:");
                l6.setLayoutX(31);
                l6.setLayoutY(372);
                l6.setStyle("-fx-font-size: 24px;"); 
                l6.setTextFill(Color.WHITE);
                Label l7 = new Label("Each Kokis will have a ");
                l7.setLayoutX(403);
                l7.setLayoutY(152);
                l7.setStyle("-fx-font-size: 24px;"); 
                l7.setTextFill(Color.WHITE);
                Label l8 = new Label("different speed and size");
                l8.setLayoutX(433);
                l8.setLayoutY(183);
                l8.setStyle("-fx-font-size: 24px;"); 
                l8.setTextFill(Color.WHITE);
                Label l9 = new Label(" depending on its difficulty");
                l9.setLayoutX(424);
                l9.setLayoutY(251);
                l9.setStyle("-fx-font-size: 24px;"); 
                l9.setTextFill(Color.WHITE);
                Label l10 = new Label("Click anywhere to start...");
                l10.setLayoutX(302);
                l10.setLayoutY(450);
                l10.setStyle("-fx-font-size: 24px;"); 
                l10.setTextFill(Color.WHITE);
                Image image1 = new Image("file:E:\\GD\\game\\game\\src\\game\\kokeis.png");

        // Create an ImageView to display the image
        ImageView imageView1 = new ImageView(image1);
            imageView1.setLayoutX(298);
            imageView1.setLayoutY(164);
            imageView1.setFitWidth(90);
            imageView1.setFitHeight(78);
                Image image2 = new Image("file:E:\\GD\\game\\game\\src\\game\\kokeis.png");

        // Create an ImageView to display the image
        ImageView imageView2 = new ImageView(image2);
            imageView2.setLayoutX(308);
            imageView2.setLayoutY(247);
            imageView2.setFitHeight(60);
            imageView2.setFitWidth(77);
                Image image3 = new Image("file:E:\\GD\\game\\game\\src\\game\\kokeis.png");

        // Create an ImageView to display the image
        ImageView imageView3 = new ImageView(image3);
            imageView3.setLayoutX(316);
            imageView3.setLayoutY(318);
            imageView3.setFitHeight(47);
            imageView3.setFitWidth(51);
                Image image4 = new Image("file:E:\\GD\\game\\game\\src\\game\\kokeis.png");

        // Create an ImageView to display the image
        ImageView imageView4 = new ImageView(image4);
            imageView4.setLayoutX(320);
            imageView4.setLayoutY(370);
            imageView4.setFitHeight(38);
            imageView4.setFitWidth(47);
              backgroundImage = new Image("file:E:\\GD\\game\\game\\src\\game\\Background4.png");
                 backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        ); 
                 pane.setOnMouseClicked(event -> {
               flag = 2;
        Game g = new game.Game();
            try {
                g.start(STage);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                pane.setBackground(new Background(backgroundImg));
            pane.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,imageView1,imageView2,imageView3,imageView4);
                scene = new Scene(pane,900,500);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                break;
            case 2:
                root.setId("root");
                 backgroundImage = new Image("file:E:\\GD\\game\\game\\src\\game\\Background.png");
                 backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        ); 
                root.setBackground(new Background(backgroundImg));
                scene = new Scene(root, 900, 500);
                stage.setResizable(false);
                stage.show();
                lblScore = new Label("Score: 0");
                lblScore.setFont(Font.font(25));
                lblScore.setTextFill(Color.WHITE);
                lblScore.setLayoutX(10);
                lblScore.setLayoutY(10);
                Remaining = new Label("Remaining: 30");
                Remaining.setFont(Font.font(25));
                Remaining.setTextFill(Color.WHITE);
                Remaining.setLayoutX(700);
                Remaining.setLayoutY(10);
                score = 0;
                remain = 30;
                speed = 1;
                falling = 500;
                timeline = new Timeline(new KeyFrame(Duration.millis(falling), (ActionEvent event) -> {
                    if (Kokis_Number < 30) {
                        speed += falling / 10000;
                        speed += 0.05;
                        if (Kokis_Number % 2 == 0) {
                            if (KokiSize) {
                                drop.add(Kokis_Number, big_kokis());
                                KokiSize=false;
                            } else {
                                drop.add(Kokis_Number,middle_kokis() );
                                
                            }
                            
                        } else {
                            if (KokiSize) {
                                
                                drop.add(Kokis_Number, small_kokis());
                            } else {
                                KokiSize=true;
                                drop.add(Kokis_Number, very_small_kokis());
                                
                            }
                            
                        }

                        root.getChildren().add(((Node) drop.get(Kokis_Number)));
                        
                        Kokis_Number++;
                        
                    }
                }));timeline.setCycleCount(1000);
                timeline.play();
                timer = new AnimationTimer() {
                    
                    @Override
                    public void handle(long arg0) {
                        try {
                            gameUpdate();
                        } catch (IOException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                };  timer.start();
                root.getChildren().addAll(lblScore, Remaining);
                root.setId("pane");
                stage.setScene(scene);
                stage.show();
                break;
            default:
                break;
        }

    }

    public Label big_kokis() {
        Label Big_kokis = new Label();
        Image image = new Image(getClass().getResourceAsStream("kokeis.png"));
        Big_kokis.setGraphic(new ImageView(image));
        Big_kokis.setId(String.valueOf("b" + id));
        Big_kokis.setLayoutX(rand(0, 500));
        Big_kokis.setLayoutY(0);
        id++;
        return Big_kokis;
    }

    public Label small_kokis() {
        Label Small_Kokis = new Label();
        Image image = new Image(getClass().getResourceAsStream("kokeis2.png"));
        Small_Kokis.setGraphic(new ImageView(image));
        Small_Kokis.setId(String.valueOf("s" + id));
        Small_Kokis.setLayoutX(rand(0, 500));

        Small_Kokis.setLayoutY(0);
        id++;
        return Small_Kokis;
    }
    public Label middle_kokis() {
        Label Middle_Kokis = new Label();
        Image image = new Image(getClass().getResourceAsStream("kokies3.png"));
        Middle_Kokis.setGraphic(new ImageView(image));
        Middle_Kokis.setId(String.valueOf("m" + id));
        Middle_Kokis.setLayoutX(rand(0, 500));

        Middle_Kokis.setLayoutY(0);
        id++;
        return Middle_Kokis;
    }
    public Label very_small_kokis() {
        Label Very_small_kokos = new Label();
        Image image = new Image(getClass().getResourceAsStream("kokeis4.png"));
        Very_small_kokos.setGraphic(new ImageView(image));
        Very_small_kokos.setId(String.valueOf("v" + id));
        Very_small_kokos.setLayoutX(rand(0, 500));

        Very_small_kokos.setLayoutY(0);
        id++;
        return Very_small_kokos;
    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }
    int index = 0;

    public void gameUpdate() throws IOException {

        for (int kokis_position = 0; kokis_position < drop.size(); kokis_position++) {

            ((Label) drop.get(kokis_position)).setLayoutY(((Label) drop.get(kokis_position)).getLayoutY() + speed + ((Label) drop.get(kokis_position)).getLayoutY() / 150);

            if (((Label) drop.get(index)).getLayoutY() >= 700) {
                
                  st.setTitle("Restart-Exit Game");

                  Image tryagain = new Image("file:E:\\GD\\game\\game\\src\\game\\tryagain.png");

        // Create an ImageView to display the image
        ImageView Tryagain = new ImageView(tryagain);
           
            Tryagain.setFitHeight(93);
            Tryagain.setFitWidth(174);
                  
                  Image quit = new Image("file:E:\\GD\\game\\game\\src\\game\\quit.png");

        // Create an ImageView to display the image
        ImageView Quit = new ImageView(quit);
           
            Quit.setFitHeight(93);
            Quit.setFitWidth(174);
                  
                  

        Tryagain.setOnMouseClicked(event -> {
            Counter_tops++;
        flag = 2;
        Game game = new game.Game();
                      try {
                          game.start(STage);
                      } catch (Exception ex) {
                          Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                      }
        });

        Quit.setOnMouseClicked(event -> {
            // Perform exit button action here
            st.close();
        });
        int score1 [] = {0,0,0,0,0};
        score1[0]=top1;
            score1[1]=top2;
            score1[2]=top3;
            score1[3]=top4;
            score1[4]=top5;
             Arrays.sort(score1, 0, score1.length);
        Label top5Label = new Label("First 5 scores in the game:");
        Label score1Label = new Label("Score 1: "+score1[4]);
        Label score2Label = new Label("Score 2: "+score1[3]);
        Label score3Label = new Label("Score 3: "+score1[2]);
        Label score4Label = new Label("Score 4: "+score1[1]);
        Label score5Label = new Label("Score 5: "+score1[0]);
        top5Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        top5Label.setTextFill(Color.WHITE);
        score1Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        score1Label.setTextFill(Color.WHITE);
        score2Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        score2Label.setTextFill(Color.WHITE);
        score3Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        score3Label.setTextFill(Color.WHITE);
        score4Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        score4Label.setTextFill(Color.WHITE);
        score5Label.setStyle("-fx-font-size: 27px;"); // Set the font size
        score5Label.setTextFill(Color.WHITE);

        VBox root = new VBox(5);
            backgroundImage = new Image("file:E:\\GD\\game\\game\\src\\game\\Background4.png");
                 backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );
                                 root.setBackground(new Background(backgroundImg));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(top5Label, score1Label, score2Label, score3Label, score4Label, score5Label, Tryagain, Quit);

        Scene scene = new Scene(root, 900, 500);
        st.setScene(scene);
        st.show();
                timeline.stop();
                timer.stop();
            }
            ((Label) drop.get(kokis_position)).setOnMousePressed((MouseEvent event) -> {
                if (hide < 10) {
                    hide++;
                    int kokis_id = Integer.parseInt((String) event.getSource().toString().substring(10, 11));
                    if (kokis_id > 0 && kokis_id < 10 && ((Label) drop.get(kokis_id - 1)).getLayoutY() > ((Label) drop.get(kokis_id)).getLayoutY()) {
                        if (kokis_id > 1) {
                            
                            ((Label) drop.get(kokis_id)).setLayoutY(0);
                        }
                        
                        ((Label) drop.get(kokis_id)).setLayoutY(0);
                        ((Label) drop.get(kokis_id)).setDisable(true);
                        
                        index = kokis_id - 1;
                    } else {
                        
                        ((Label) drop.get(kokis_id)).setLayoutY(0);
                        ((Label) drop.get(kokis_id)).setDisable(true);
                        
                        index = kokis_id;
                    }
                    root.getChildren().remove(((Label) drop.get(kokis_id)));
                    
                    switch (event.getSource().toString().substring(9, 10)) {
                        case "b":
                            score += 1;
                            remain--;
                            break;
                        case "m":
                            score += 2;
                            remain--;
                            break;
                        case "s":
                            score += 3;
                            remain--;
                            break;
                        case "v":
                            score += 4;
                            remain--;
                            break;
                        default:
                            break; 
                    }
                    switch (Counter_tops) {
                        case 1:
                            top1 = score;
                            break;
                        case 2:
                            top2 = score;
                            break;
                        case 3:
                            top3 = score;
                            break;
                        case 4:
                            top4 = score;
                            break;
                        case 5:
                            top5 = score;
                            Counter_tops = 1;
                            break;
                        default:
                            break;
                    }
                    Remaining.setText("Remaining: " + String.valueOf(remain));
                    lblScore.setText("Score: " + String.valueOf(score));
                } else {
                    
                    int kokis_id = Integer.parseInt((String) event.getSource().toString().subSequence(10, 12));
                    if (kokis_id >= 10 && ((Label) drop.get(kokis_id - 1)).getLayoutY() > ((Label) drop.get(kokis_id)).getLayoutY()) {
                        ((Label) drop.get(kokis_id)).setLayoutY(0);
                        ((Label) drop.get(kokis_id)).setDisable(true);
                        
                        index = kokis_id - 1;
                        root.getChildren().remove(((Label) drop.get(kokis_id)));
                    } else {
                        
                        ((Label) drop.get(kokis_id)).setLayoutY(0);
                        ((Label) drop.get(kokis_id)).setDisable(true);
                        
                        index = kokis_id;
                        ((Label) drop.get(kokis_id)).setLayoutY(0);
                        ((Label) drop.get(kokis_id)).setDisable(true);
                    }
                    index = kokis_id;
                    root.getChildren().remove(((Label) drop.get(kokis_id)));
                   switch (event.getSource().toString().substring(9, 10)) {
                        case "b":
                            score += 1;
                            remain--;
                            break;
                        case "m":
                            score += 2;
                            remain--;
                            break;
                        case "s":
                            score += 3;
                            remain--;
                            break;
                        case "v":
                            score += 4;
                            remain--;
                            break;
                        default:
                            break; 
                    }
                    Remaining.setText("Remaining: " + String.valueOf(remain));
                    switch (Counter_tops) {
                        case 1:
                            top1 = score;
                            break;
                        case 2:
                            top2 = score;
                            break;
                        case 3:
                            top3 = score;
                            break;
                        case 4:
                            top4 = score;
                            break;
                        case 5:
                            top5 = score;
                            Counter_tops = 1;
                            break;
                        default:
                            break;
                    }
                    lblScore.setText("Score: " + String.valueOf(score));
                }
            });
        }
    }
    public static void main (String []args){
        launch(args);
    }
}
