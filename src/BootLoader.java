package src;


import java.util.*; 
import java.net.URL;
import org.eclipse.core.internal.boot.PlatformConfiguration;
import org.eclipse.core.internal.runtime.InternalPlatform;

public class BootLoader {
	
	public static boolean CONFIGURATION_DEBUG = false;
	public static final String PI_BOOT = "org.eclipse.core.boot"; //$NON-NLS-1$
	public static final String OS_WIN32 = "win32";//$NON-NLS-1$
	
	public static String[] getCommandLineArgs() {
        return InternalPlatform.getDefault().getApplicationArgs();
	}
	
	public static org.eclipse.core.boot.IPlatformConfiguration getCurrentPlatformConfiguration() {
        BundleContext context = InternalPlatform.getDefault().getBundleContext();
              // acquire factory service first
        ServiceReference configFactorySR = context.getServiceReference(IPlatformConfigurationFactory.class.getName());
        if (configFactorySR == null)
                   throw new IllegalStateException();
              IPlatformConfigurationFactory configFactory = (IPlatformConfigurationFactory) context.getService(configFactorySR);
             if (configFactory == null)
                  throw new IllegalStateException();
             // get the configuration using the factory
        IPlatformConfiguration currentConfig = configFactory.getCurrentPlatformConfiguration();
        context.ungetService(configFactorySR);
           return new PlatformConfiguration(currentConfig);
	}
	 public static URL getInstallURL() {
         return InternalPlatform.getDefault().getInstallURL();
	 }
	 public static String getNL() {
         return InternalPlatform.getDefault().getNL();
	 }
	 public static String getOS() {
         return InternalPlatform.getDefault().getOS();
	 }
	 public static String getOSArch() {
         return InternalPlatform.getDefault().getOSArch();
	 }
	 public static org.eclipse.core.boot.IPlatformConfiguration getPlatformConfiguration(URL url) throws IOException {
         BundleContext context = InternalPlatform.getDefault().getBundleContext();
       // acquire factory service first
        ServiceReference configFactorySR = context.getServiceReference(IPlatformConfigurationFactory.class.getName());
         if (configFactorySR == null)
            throw new IllegalStateException();
       IPlatformConfigurationFactory configFactory = (IPlatformConfigurationFactory) context.getService(configFactorySR);
      if (configFactory == null)
                   throw new IllegalStateException();
      // get the configuration using the factory
         IPlatformConfiguration config = configFactory.getPlatformConfiguration(url);
    context.ungetService(configFactorySR);
       return new PlatformConfiguration(config);
	 }
	 public static String getWS() {
         return InternalPlatform.getDefault().getWS();
	 }
	 public static String[] knownOSValues() {
         return Platform.knownOSValues();
	 }
	 public static String[] knownWSValues() {
         return Platform.knownWSValues();
	 }
	 public static boolean inDebugMode() {
         return Platform.inDebugMode();
     }
	 public static boolean isRunning() {
         return InternalPlatform.getDefault().isRunning();
	 }
	 public static URL[] getPluginPath(URL pluginPathLocation) {
         return InternalPlatform.getDefault().getPluginPath(pluginPathLocation);
     }
	 public static boolean containsSavedPlatform(String location) {
         return true;
	 }
	 public static IPlatformRunnable getRunnable(String applicationName) throws Exception {
         return null;
	 }
	 public static IPlatformRunnable getRunnable(String pluginId, String className, Object args) throws Exception {
         return null;
	 }
	 public static Object run(String applicationName, URL pluginPathLocation, String location, String[] args) throws Exception {
         return null;
	 }
	 public static void shutdown() throws Exception {
	 }
	 public static String[] startup(URL pluginPathLocation, String location, String[] args) throws Exception {
         return null;
	 }
	 public static String[] startup(URL pluginPathLocation, String location, String[] args, Runnable handler) throws Exception {
         return null;
	 }
}
