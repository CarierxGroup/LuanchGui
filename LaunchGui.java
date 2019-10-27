/*    */ package tehnut.launchgui;
/*    */ 
/*    */ import java.io.File;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import tehnut.launchgui.gui.javafx.UpdateWindow;
/*    */ import tehnut.launchgui.utils.EventHandler;
/*    */ import tehnut.launchgui.utils.Utils;
/*    */ 
/*    */ 
/*    */ @Mod(modid = "launchgui", name = "LaunchGui", version = "@VERSION@", clientSideOnly = true, acceptedMinecraftVersions = "[1.9,)")
/*    */ public class LaunchGui
/*    */ {
/*    */   public static final String NAME = "LaunchGui";
/*    */   public static final String ID = "launchgui";
/*    */   public static final String VERSION = "@VERSION@";
/*    */   @Instance
/*    */   public static LaunchGui instance;
/*    */   public static String remoteVersion;
/*    */   public static String remoteText;
/*    */   
/*    */   @EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event) {
/* 27 */     ConfigHandler.init(new File(event.getModConfigurationDirectory(), "LaunchGui.cfg"));
/*    */     
/* 29 */     if (ConfigHandler.enableUpdateChecker) {
/* 30 */       remoteVersion = Utils.getRemoteVersion();
/*    */       
/* 32 */       if (ConfigHandler.checkUpdateEarly && Utils.hasUpdate()) {
/* 33 */         UpdateWindow.initWindow();
/*    */       }
/*    */     } 
/* 36 */     if (ConfigHandler.enableNoticeGui) {
/* 37 */       remoteText = Utils.getRemoteText();
/*    */     }
/* 39 */     MinecraftForge.EVENT_BUS.register(new EventHandler());
/*    */   }
/*    */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgui\LaunchGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */