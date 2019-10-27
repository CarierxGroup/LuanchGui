/*     */ package tehnut.launchgui;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import tehnut.launchgui.utils.LogHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigHandler
/*     */ {
/*     */   public static Configuration config;
/*     */   public static boolean showGuiOnStartup;
/*     */   public static boolean invertModFinder;
/*     */   public static String modToFind;
/*     */   public static boolean disableGuiAfterViewed;
/*     */   public static boolean enableLinkButton;
/*     */   public static String linkButtonText;
/*     */   public static String linkButtonUrl;
/*     */   public static String continueButtonText;
/*     */   public static String startupGuiTitle;
/*     */   public static String startupGuiLines;
/*     */   public static boolean enableUpdateChecker;
/*     */   public static boolean disableContinueButtonIfUpdate;
/*     */   public static boolean checkUpdateEarly;
/*     */   public static String updateGuiLines;
/*     */   public static String updateCheckerUrl;
/*     */   public static String updateInformationButtonText;
/*     */   public static String updateInformationUrl;
/*     */   public static String currentPackVersion;
/*     */   public static boolean enableNoticeGui;
/*     */   public static String infoButtonText;
/*     */   public static String infoButtonUrl;
/*     */   public static String infoTitle;
/*     */   public static String infoUrl;
/*     */   public static String modpackName;
/*     */   public static String modpackAcronym;
/*     */   public static String modpackVersion;
/*     */   public static boolean enableLogging;
/*     */   public static File cfg;
/*     */   
/*     */   public static void init(File file) {
/*  48 */     config = new Configuration(file);
/*  49 */     syncConfig();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void syncConfig() {
/*  55 */     category = "Startup Gui";
/*  56 */     config.addCustomCategoryComment(category, "Settings for the GUI shown on startup.");
/*  57 */     config.addCustomCategoryComment(category + ".button", "Settings related to the shown buttons.");
/*  58 */     config.addCustomCategoryComment(category + ".internal", "Settings for the internal checking that the GUI does.");
/*  59 */     config.addCustomCategoryComment(category + ".information", "Information to provide to players.");
/*  60 */     showGuiOnStartup = config.getBoolean("showGuiOnStartup", category + ".internal", true, "Whether or not to show the GUI on startup. Used internally, do not touch.");
/*  61 */     modToFind = config.getString("modToFind", category + ".internal", "", "Put a modid here to only load if that mod is installed. Leave blank to not check for a mod at all.");
/*  62 */     invertModFinder = config.getBoolean("invertModFinder", category + ".internal", false, "False- Displays Gui when the specified mod is found.\nTrue- Displays Gui when the specified mod is *not* found.");
/*  63 */     disableGuiAfterViewed = config.getBoolean("disableGuiAfterViewed", category + ".internal", true, "Whether to disable the GUI after it has been viewed before.\nSet to false to show GUI on every startup. Still requires showGuiOnStartup to be true.");
/*  64 */     enableLinkButton = config.getBoolean("enableLinkButton", category + ".button", true, "Add a second button that has a link attached to it. Clicking the button will open the link in the user's default browser.");
/*  65 */     linkButtonText = config.getString("linkButtonText", category + ".button", "My Website", "Text to display on the link button.");
/*  66 */     linkButtonUrl = config.getString("linkButtonUrl", category + ".button", "http://tehnut.info/", "Link to open when clicked.");
/*  67 */     continueButtonText = config.getString("continueButtonText", category + ".button", "Continue", "Text to display on the continue button.");
/*  68 */     startupGuiTitle = config.getString("startupGuiTitle", category + ".information", "TITLE", "Title of the startup GUI. Shows as yellow text.");
/*  69 */     startupGuiLines = config.getString("startupGuiLines", category + ".information", "", "These are your information info lines in the GUI\nUse \"\\n\" to define a new line. If the line is still too long, it will split for you.\nIf you do not use custom splits, it will just use the automated ones.\nValid text codes you can use are:\n%player% - Provides the player's username.\n%name% - Provides modpackName\n%version% - Provides modpackVersion\n%acro% - Provides modpackAcronym");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     category = "Update Checker";
/*  79 */     config.addCustomCategoryComment(category, "Settings for the GUI shown when an update is available.");
/*  80 */     config.addCustomCategoryComment(category + ".button", "Settings related to the shown buttons.");
/*  81 */     config.addCustomCategoryComment(category + ".internal", "Settings for the internal checking that the GUI does.");
/*  82 */     config.addCustomCategoryComment(category + ".information", "Information to provide to players.");
/*  83 */     checkUpdateEarly = config.getBoolean("checkUpdateEarly", category, true, "Checks for a pack update during the Pre-Initialization phase instead of when the main menu displays.\nThis will open a new window that always displays on top. It will pause loading until closed.");
/*  84 */     enableUpdateChecker = config.getBoolean("enableUpdateChecker", category + ".internal", false, "Enables the update checker.");
/*  85 */     disableContinueButtonIfUpdate = config.getBoolean("disableContinueButtonIfUpdate", category + ".internal", false, "Disable the Continue button if there is a pack update available.");
/*  86 */     updateGuiLines = config.getString("updateGuiLines", category + ".information", "Click the information button below to find out more!", "Information to display to your players whenever a new update is available.\nUse \"\\n\" to define a new line. If the line is still too long, it will split for you.\nIf you do not use custom splits, it will just use the automated ones.\nValid text codes you can use are:\n%player% - Provides the player's username.\n%name% - Provides modpackName\n%version% - Provides modpackVersion\n%acro% - Provides modpackAcronym");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     updateCheckerUrl = config.getString("updateCheckerUrl", category + ".information", "http://tehnut.info", "URL to check for a new version. Required a raw text file.\nSee here for an example: https://raw.githubusercontent.com/TehNut/LaunchGui/1.7.10/version.txt");
/*  95 */     updateInformationButtonText = config.getString("updateInformationButtonText", category + ".button", "Changelog", "Text to display on update information button");
/*  96 */     updateInformationUrl = config.getString("updateInformationUrl", category + ".information", "", "A URL to a forum page (or similar) with information about the pack/update.");
/*  97 */     currentPackVersion = config.getString("currentPackVersion", category + ".information", "", "The version of your pack currently being shipped.");
/*     */     
/*  99 */     category = "Notice";
/* 100 */     config.addCustomCategoryComment(category, "Gui that loads if a text file at a specified URL exists and is not empty.");
/* 101 */     config.addCustomCategoryComment(category + ".button", "Settings related to the shown buttons.");
/* 102 */     config.addCustomCategoryComment(category + ".internal", "Settings for the internal checking that the GUI does.");
/* 103 */     config.addCustomCategoryComment(category + ".information", "Information to provide to players.");
/* 104 */     enableNoticeGui = config.getBoolean("enableNoticeGui", category + ".internal", false, "Enables the notice GUI");
/* 105 */     infoButtonText = config.getString("infoButtonText", category + ".button", "Information", "Text to display on info button");
/* 106 */     infoButtonUrl = config.getString("infoButtonUrl", category + ".button", "", "URL that the info button sends you to");
/* 107 */     infoTitle = config.getString("infoTitle", category + ".information", "Important Notice", "Title to display at the top");
/* 108 */     infoUrl = config.getString("infoUrl", category + ".information", "http://tehnut.info", "URL to pull information from.\nUse \"\\n\" to define a new line. If the line is still too long, it will split for you.\nIf you do not use custom splits, it will just use the automated ones.\nValid text codes you can use are:\n%player% - Provides the player's username.\n%name% - Provides modpackName\n%version% - Provides modpackVersion\n%acro% - Provides modpackAcronym");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     category = "Global";
/* 118 */     config.addCustomCategoryComment(category, "Global settings that can be used in all GUI's");
/* 119 */     modpackName = config.getString("modpackName", category, "LaunchGui", "The name of your modpack.");
/* 120 */     modpackAcronym = config.getString("modpackAcronym", category, "LGUI", "The acronym of your modpack.");
/* 121 */     modpackVersion = config.getString("modpackVersion", category, "@VERSION@", "The current version of your modpack");
/*     */     
/* 123 */     category = "Miscellaneous";
/* 124 */     config.addCustomCategoryComment(category, "General settings that don't fall under other categories.");
/* 125 */     enableLogging = config.getBoolean("enableLogging", category, true, "Enables logging information to the console.");
/*     */     
/* 127 */     config.save();
/*     */   }
/*     */   
/*     */   public static boolean manuallyChangeConfigValue(String filePathFromConfigFolder, String prefix, String from, String to) {
/* 131 */     File config = (filePathFromConfigFolder == null) ? cfg : new File("config/LaunchGui.cfg");
/* 132 */     boolean found = false;
/*     */     
/*     */     try {
/* 135 */       FileReader fr1 = new FileReader(config);
/* 136 */       BufferedReader read = new BufferedReader(fr1);
/*     */       
/* 138 */       ArrayList<String> strings = new ArrayList<String>();
/*     */       
/* 140 */       while (read.ready()) {
/* 141 */         strings.add(read.readLine());
/*     */       }
/* 143 */       fr1.close();
/* 144 */       read.close();
/*     */       
/* 146 */       FileWriter fw = new FileWriter(config);
/* 147 */       BufferedWriter bw = new BufferedWriter(fw);
/*     */       
/* 149 */       for (String s : strings) {
/* 150 */         if (!found && s.contains(prefix + "=" + from) && !s.contains("=" + to)) {
/* 151 */           s = s.replace(prefix + "=" + from, prefix + "=" + to);
/* 152 */           LogHelper.info("Successfully changed config value " + prefix + " from " + from + " to " + to);
/* 153 */           found = true;
/*     */         } 
/*     */         
/* 156 */         fw.write(s + "\n");
/*     */       } 
/*     */       
/* 159 */       bw.flush();
/* 160 */       bw.close();
/* 161 */     } catch (Throwable t) {
/* 162 */       t.printStackTrace();
/*     */     } 
/*     */     
/* 165 */     return found;
/*     */   }
/*     */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgui\ConfigHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */