import static org.easymock.EasyMock.*;

import java.io.IOException;

import junit.framework.TestCase;

public class CurrencyTest extends TestCase{
	Currency currencyUSD;
	Currency currencyEUR;
	ExchangeRate mock;
	//mock객체 생성
	protected void setUp() throws Exception{
		mock=createMock(ExchangeRate.class);
		currencyUSD=new Currency(10, "USD");
		currencyEUR=new Currency(10, "EUR");
	}
	public void testToEuros() throws IOException {
		//expectations		
		expect(mock.getRate("USD", "EUR")).andReturn(1.0);//1.0을 return할 것이다.
		replay(mock);//replay mode

		assertEquals(currencyEUR,currencyUSD.toEuros(mock));//결과가 예상대로인지 확인한다.
	}
}
