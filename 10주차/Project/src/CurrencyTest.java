import static org.easymock.EasyMock.*;

import java.io.IOException;

import junit.framework.TestCase;

public class CurrencyTest extends TestCase{
	Currency currencyUSD;
	Currency currencyEUR;
	ExchangeRate mock;
	//mock°´Ã¼ »ý¼º
	protected void setUp() throws Exception{
		mock=createMock(ExchangeRate.class);
		currencyUSD=new Currency(10, "USD");
		currencyEUR=new Currency(10, "EUR");
	}
	public void testToEuros() throws IOException {
		//expectations		
		expect(mock.getRate("USD", "EUR")).andReturn(1.0);
		replay(mock);

		assertEquals(currencyEUR,currencyUSD.toEuros(mock));
		verify(mock);
	}
}
