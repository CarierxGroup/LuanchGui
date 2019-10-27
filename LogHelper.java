/*    */ package tehnut.launchgui.utils;
/*    */ 
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import tehnut.launchgui.ConfigHandler;
/*    */ 
/*    */ 
/*    */ public class LogHelper
/*    */ {
/* 10 */   private static Logger logger = LogManager.getLogger("LaunchGui");
/*    */   
/*    */   public static void info(Object info) {
/* 13 */     if (ConfigHandler.enableLogging)
/* 14 */       logger.info(info); 
/*    */   }
/*    */   
/*    */   public static void error(Object error) {
/* 18 */     if (ConfigHandler.enableLogging)
/* 19 */       logger.error(error); 
/*    */   }
/*    */   
/*    */   public static void error(Object error, Throwable throwable) {
/* 23 */     if (ConfigHandler.enableLogging)
/* 24 */       logger.error(error, throwable); 
/*    */   }
/*    */   
/*    */   public static void debug(Object debug) {
/* 28 */     if (ConfigHandler.enableLogging)
/* 29 */       logger.debug(debug); 
/*    */   }
/*    */ }


/* Location:              D:\工程开发\Cracked\LaunchGui-1.9.4-2.0.3-24-client.jar!\tehnut\launchgu\\utils\LogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */