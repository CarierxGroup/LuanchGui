/*     */ package tehnut.launchgui.utils;
/*     */ 
/*     */ import java.awt.Desktop;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import java.util.Scanner;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraftforge.fml.common.Loader;
/*     */ import tehnut.launchgui.ConfigHandler;
/*     */ import tehnut.launchgui.LaunchGui;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Utils
/*     */ {
/*     */   private static boolean checkUpdate = true;
/*     */   private static boolean checkText = true;
/*     */   
/*  23 */   public static boolean hasNotice() { return (ConfigHandler.enableNoticeGui && !LaunchGui.remoteText.equals("") && !ConfigHandler.infoUrl.equals("")); }
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static boolean hasUpdate() { return (ConfigHandler.enableUpdateChecker && !LaunchGui.remoteVersion.equals(ConfigHandler.currentPackVersion) && !LaunchGui.remoteVersion.equals("") && !ConfigHandler.updateCheckerUrl.equals("")); }
/*     */ 
/*     */   
/*     */   public static String getRemoteText() {
/*  31 */     if (checkText) {
/*     */       try {
/*  33 */         url = new URL(ConfigHandler.infoUrl);
/*  34 */         Scanner scanner = new Scanner(url.openStream());
/*  35 */         checkText = false;
/*  36 */         return scanner.nextLine();
/*  37 */       } catch (IOException e) {
/*  38 */         LogHelper.error("Error returned while obtaining the notice information.");
/*     */       } 
/*     */     }
/*     */     
/*  42 */     checkText = false;
/*     */     
/*  44 */     return "";
/*     */   }
/*     */   
/*     */   public static String getRemoteVersion() {
/*  48 */     if (checkUpdate) {
/*     */       try {
/*  50 */         url = new URL(ConfigHandler.updateCheckerUrl);
/*  51 */         Scanner scanner = new Scanner(url.openStream());
/*  52 */         checkUpdate = false;
/*  53 */         return scanner.nextLine();
/*  54 */       } catch (IOException e) {
/*  55 */         LogHelper.error("Error returned while attempting to check for an update.");
/*     */       } 
/*     */     }
/*     */     
/*  59 */     checkUpdate = false;
/*     */     
/*  61 */     return "";
/*     */   }
/*     */   
/*     */   public static boolean shouldLoadFromModSearch() {
/*  65 */     if (ConfigHandler.invertModFinder) {
/*  66 */       return !Loader.isModLoaded(ConfigHandler.modToFind);
/*     */     }
/*  68 */     return (Loader.isModLoaded(ConfigHandler.modToFind) || ConfigHandler.modToFind.equals(""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void handleGuiText(String text, FontRenderer fontRenderer, Gui gui, int width, int height) {
/*  75 */     int heightLoc = 85;
/*     */     
/*  77 */     String[] lines = replaceTextCodes(text).split("\n");
/*  78 */     for (String s : lines) {
/*     */       
/*  80 */       List<String> info = fontRenderer.func_78271_c(s, width - 40);
/*  81 */       for (String infoCut : info) {
/*  82 */         gui.func_73732_a(fontRenderer, infoCut, width / 2, height / 2 - heightLoc, 16777215);
/*  83 */         heightLoc -= 12;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String replaceTextCodes(String toReplace) {
/*  89 */     return toReplace
/*  90 */       .replace("\\n", "\n")
/*  91 */       .replace("%name%", ConfigHandler.modpackName)
/*  92 */       .replace("%acro%", ConfigHandler.modpackAcronym)
/*  93 */       .replace("%version%", ConfigHandler.modpackVersion)
/*  94 */       .replace("%player%", Minecraft.func_71410_x().func_110432_I().func_111285_a())
/*  95 */       .replace("&", "§");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public static boolean browse(URI uri) { return browseDESKTOP(uri); }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean browseDESKTOP(URI uri) {
/* 108 */     LogHelper.info("Attempting to open the page at " + uri);
/*     */     try {
/* 110 */       if (!Desktop.isDesktopSupported()) {
/* 111 */         LogHelper.error("Sorry, it appears that your platform is not supported.");
/* 112 */         return false;
/*     */       } 
/*     */       
/* 115 */       if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
/* 116 */         LogHelper.error("Sorry, it appears that the BROWSE action is not supported.");
/* 117 */         return false;
/*     */       } 
/*     */       
/* 120 */       Desktop.getDesktop().browse(uri);
/* 121 */       LogHelper.info("Attempt successful!");
/* 122 */       return true;
/*     */     }
/* 124 */     catch (Throwable throwable) {
/* 125 */       LogHelper.error("Error using desktop browse.", throwable);
/* 126 */       throwable.printStackTrace();
/* 127 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgu\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */