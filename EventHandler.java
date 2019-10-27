/*    */ package tehnut.launchgui.utils;
/*    */ 
/*    */ import net.minecraftforge.client.event.GuiOpenEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import tehnut.launchgui.ConfigHandler;
/*    */ import tehnut.launchgui.gui.GuiNotice;
/*    */ import tehnut.launchgui.gui.GuiStartup;
/*    */ import tehnut.launchgui.gui.GuiUpdate;
/*    */ 
/*    */ 
/*    */ public class EventHandler
/*    */ {
/*    */   private boolean shouldLoadGUI = true;
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void openMainMenu(GuiOpenEvent event) {
/* 20 */     if (this.shouldLoadGUI && 
/* 21 */       event.getGui() instanceof net.minecraft.client.gui.GuiMainMenu) {
/* 22 */       if (Utils.hasUpdate() && !ConfigHandler.checkUpdateEarly) {
/* 23 */         event.setGui(new GuiUpdate());
/* 24 */         this.shouldLoadGUI = false;
/*    */         
/*    */         return;
/*    */       } 
/* 28 */       if (Utils.hasNotice()) {
/* 29 */         event.setGui(new GuiNotice());
/* 30 */         this.shouldLoadGUI = false;
/*    */         
/*    */         return;
/*    */       } 
/* 34 */       if (ConfigHandler.showGuiOnStartup && Utils.shouldLoadFromModSearch()) {
/* 35 */         event.setGui(new GuiStartup());
/* 36 */         this.shouldLoadGUI = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgu\\utils\EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */