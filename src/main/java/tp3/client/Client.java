package tp3.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import tp3.store.IFastLane;
import tp3.store.IJustHaveALook;
import tp3.store.ILane;

@Component
public class Client implements IRun{
	@Autowired
	IFastLane fastlane;
	@Autowired
	ILane lane;
	@Autowired
	IJustHaveALook haveALook;
	
	@Value("${clientAccountNumber}")
	int clientAccountNumber;
	
	public Client() {}
	
	public void run() {
		fastlane.oneShotOrder("pain", 2, clientAccountNumber);
		
		lane.addItemToCart("pain");
		lane.addItemToCart("pain");
		lane.addItemToCart("pain");
		
		lane.pay(clientAccountNumber);
	}

}
