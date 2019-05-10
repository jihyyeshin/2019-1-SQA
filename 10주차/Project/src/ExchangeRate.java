import java.io.IOException;

public interface ExchangeRate{
	public double getRate(String units, String test) throws IOException;
}
