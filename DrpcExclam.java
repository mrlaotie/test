package bhz.drpc1;

import org.apache.storm.Config;
import org.apache.storm.utils.DRPCClient;

public class DrpcExclam {

	public static void main(String[] args) throws Exception {
		Config config = new Config();
		config.setDebug(true);
		config.put("storm.thrift.transport", "org.apache.storm.security.auth.SimpleTransportPlugin");
		config.put(Config.STORM_NIMBUS_RETRY_TIMES, 3);
		config.put(Config.STORM_NIMBUS_RETRY_INTERVAL, 10);
		config.put(Config.STORM_NIMBUS_RETRY_INTERVAL_CEILING, 20);
		config.put(Config.DRPC_MAX_BUFFER_SIZE, 5);

		DRPCClient client = new DRPCClient(config, "192.168.1.114:3772", 3772);
		for (String word : new String[] { "hello", "goodbye" }) {
			System.out.println(client.execute("exclamation", word));
		}
	}
}
