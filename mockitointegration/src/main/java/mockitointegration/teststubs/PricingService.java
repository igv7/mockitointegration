package mockitointegration.teststubs;

import java.util.Collection;

public interface PricingService {

	// [... other methods ...]
	
	Price getHighestPricedTrade(Collection<Trade> trades);

}
