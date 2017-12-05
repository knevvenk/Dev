import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcachedExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static MemCachedClient getMemCachedClient(){
		String[] servers = {"127.0.0.1:11211"};
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMinConn( 5 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		//Get the Memcached Client from SockIOPool named Test1
		MemCachedClient mcc = new MemCachedClient("Test1");
		
		return mcc;
	}
	
	public static boolean addTxnStatusToCache(String txnProxyPAN, String status){
		MemCachedClient mcc = getMemCachedClient();
		if(!mcc.add(txnProxyPAN, status))
			mcc.set(txnProxyPAN, status);
		
		return true;
	}
	
	public static String getTxnStatusFromCache(String txnProxyPAN){
		MemCachedClient mcc = getMemCachedClient();		
		return mcc.get(txnProxyPAN).toString();
	}
	
	public static void deleteTxnStatusFromCache(String txnProxyPAN){
		MemCachedClient mcc = getMemCachedClient();		
		mcc.delete(txnProxyPAN);
	}
}
