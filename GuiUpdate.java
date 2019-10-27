/*    */ package tehnut.launchgui.gui;
/*    */ 
/*    */ import java.net.URI;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.text.TextFormatting;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import tehnut.launchgui.ConfigHandler;
/*    */ import tehnut.launchgui.utils.LogHelper;
/*    */ import tehnut.launchgui.utils.Utils;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiUpdate
/*    */   extends GuiScreen
/*    */ {
/*    */   public void func_73866_w_() {
/* 21 */     if (!ConfigHandler.disableContinueButtonIfUpdate) {
/* 22 */       this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 154, this.field_146295_m / 2 + 96, 144, 20, ConfigHandler.continueButtonText));
/* 23 */       this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 10, this.field_146295_m / 2 + 96, 144, 20, ConfigHandler.updateInformationButtonText));
/*    */     } else {
/* 25 */       this.field_146292_n.clear();
/* 26 */       this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 144, this.field_146295_m / 2 + 96, 288, 20, ConfigHandler.updateInformationButtonText));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 33 */     GlStateManager.func_179090_x();
/* 34 */     GlStateManager.func_179098_w();
/*    */     
/* 36 */     func_146276_q_();
/* 37 */     func_73732_a(this.field_146289_q, TextFormatting.GREEN + I18n.func_135052_a("gui.launchgui.update.avail", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2 - 100, 16777215);
/* 38 */     Utils.handleGuiText(ConfigHandler.updateGuiLines, this.field_146289_q, this, this.field_146294_l, this.field_146295_m);
/*    */     
/* 40 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton button) {
/* 45 */     switch (button.field_146127_k) {
/*    */       case 0:
/* 47 */         for (GuiButton b : this.field_146292_n) {
/* 48 */           b.field_146124_l = false;
/*    */         }
/* 50 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */       
/*    */       case 1:
/*    */         try {
/* 55 */           Utils.browse(new URI(ConfigHandler.updateInformationUrl));
/* 56 */         } catch (Exception exception) {
/* 57 */           LogHelper.error("Failed to load the page at " + ConfigHandler.updateInformationUrl + "!");
/* 58 */           exception.printStackTrace();
/*    */         } 
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void func_73869_a(char typedChar, int keycode) {}
/*    */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgui\gui\GuiUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */