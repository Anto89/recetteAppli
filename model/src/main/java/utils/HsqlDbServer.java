package utils;

import java.io.IOException;
import java.util.Properties;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.context.SmartLifecycle;

public class HsqlDbServer implements SmartLifecycle {
	private HsqlProperties properties;
	private Server server;
	private boolean running = false;

	public HsqlDbServer(Properties props) {
		properties = new HsqlProperties(props);
	}

	@Override
	public boolean isRunning() {
		if (server != null)
			server.checkRunning(running);
		return running;
	}

	@Override
	public void start() {
		if (server == null) {
			System.out.println("Starting HSQL server...");
			server = new Server();
			try {
				server.setProperties(properties);
				server.start();
				running = true;
			} catch (AclFormatException afe) {
				System.out.println("Error starting HSQL server." + afe);
			} catch (IOException e) {
				System.out.println("Error starting HSQL server." + e);
			}
		}
	}

	@Override
	public void stop() {
		System.out.println("Stopping HSQL server...");
		if (server != null) {
			server.stop();
			running = false;
		}
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable runnable) {
		stop();
		runnable.run();
	}
}
