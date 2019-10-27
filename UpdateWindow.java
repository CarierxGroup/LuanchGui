/*     */ package tehnut.launchgui.gui.javafx;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javafx.application.Application;
/*     */ import javafx.event.ActionEvent;
/*     */ import javafx.event.Event;
/*     */ import javafx.event.EventHandler;
/*     */ import javafx.geometry.Insets;
/*     */ import javafx.scene.Node;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Button;
/*     */ import javafx.scene.control.Label;
/*     */ import javafx.scene.control.Separator;
/*     */ import javafx.scene.layout.BorderPane;
/*     */ import javafx.scene.layout.HBox;
/*     */ import javafx.scene.layout.VBox;
/*     */ import javafx.scene.text.Font;
/*     */ import javafx.scene.text.FontWeight;
/*     */ import javafx.stage.Stage;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import tehnut.launchgui.ConfigHandler;
/*     */ import tehnut.launchgui.utils.LogHelper;
/*     */ import tehnut.launchgui.utils.Utils;
/*     */ 
/*     */ public class UpdateWindow
/*     */   extends Application
/*     */ {
/*     */   private Stage window;
/*     */   
/*  32 */   public static void initWindow() { launch(new String[0]); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(Stage primaryStage) {
/*  37 */     this.window = primaryStage;
/*     */     
/*  39 */     primaryStage.setTitle(I18n.func_135052_a("gui.launchgui.update.title", new Object[] { ConfigHandler.modpackName }));
/*  40 */     primaryStage.setWidth(700.0D);
/*  41 */     primaryStage.setHeight(500.0D);
/*  42 */     primaryStage.setAlwaysOnTop(true);
/*  43 */     primaryStage.setResizable(false);
/*     */     
/*  45 */     BorderPane border = new BorderPane();
/*  46 */     border.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
/*     */     
/*  48 */     VBox titleBox = new VBox(new Node[] { getTitle(), new Separator() });
/*  49 */     titleBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
/*  50 */     titleBox.setSpacing(10.0D);
/*  51 */     border.setTop(titleBox);
/*     */     
/*  53 */     VBox bodyBox = new VBox(new Node[] { new VBox(getBodyText()) });
/*  54 */     bodyBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
/*  55 */     bodyBox.setSpacing(10.0D);
/*  56 */     border.setCenter(bodyBox);
/*     */     
/*  58 */     HBox buttonBox = new HBox(getButtons());
/*  59 */     buttonBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
/*  60 */     buttonBox.setSpacing(10.0D);
/*  61 */     border.setBottom(new VBox(new Node[] { new Separator(), buttonBox }));
/*     */     
/*  63 */     primaryStage.setScene(new Scene(border));
/*  64 */     primaryStage.show();
/*     */   }
/*     */   
/*     */   private Node[] getBodyText() {
/*  68 */     List<Node> nodes = new ArrayList<Node>();
/*     */     
/*  70 */     String[] toDraw = Utils.replaceTextCodes(ConfigHandler.updateGuiLines).split("\n");
/*  71 */     for (String draw : toDraw) {
/*  72 */       String wrapped = draw.replaceAll("(.{55})", "$1\n");
/*  73 */       String[] cutWrapped = wrapped.split("\n");
/*     */       
/*  75 */       for (String cut : cutWrapped) {
/*  76 */         Label label = new Label(cut);
/*  77 */         label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20.0D));
/*  78 */         nodes.add(label);
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     return (Node[])nodes.toArray(new Node[nodes.size()]);
/*     */   }
/*     */   
/*     */   private Node[] getButtons() {
/*  86 */     Button acknowledgeButton = new Button(ConfigHandler.continueButtonText);
/*  87 */     acknowledgeButton.setOnAction(new EventHandler<ActionEvent>()
/*     */         {
/*     */           public void handle(ActionEvent event) {
/*  90 */             UpdateWindow.this.window.close();
/*     */           }
/*     */         });
/*  93 */     acknowledgeButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20.0D));
/*     */     
/*  95 */     Button informationButton = new Button(ConfigHandler.updateInformationButtonText);
/*  96 */     informationButton.setOnAction(new EventHandler<ActionEvent>()
/*     */         {
/*     */           public void handle(ActionEvent event) {
/*     */             try {
/* 100 */               Utils.browse(new URI(ConfigHandler.updateInformationUrl));
/* 101 */             } catch (Exception e) {
/* 102 */               LogHelper.error("Failed to load the page at " + ConfigHandler.updateInformationUrl + "!");
/* 103 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/* 107 */     informationButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20.0D));
/*     */     
/* 109 */     return new Node[] { acknowledgeButton, informationButton };
/*     */   }
/*     */   
/*     */   private Node getTitle() {
/* 113 */     Label title = new Label(I18n.func_135052_a("gui.launchgui.update.avail", new Object[0]));
/* 114 */     title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25.0D));
/* 115 */     return title;
/*     */   }
/*     */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgui\gui\javafx\UpdateWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */