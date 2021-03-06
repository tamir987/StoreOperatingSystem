package Customer;
import org.json.JSONObject;

public class CustomerFactory
{
	private CustomerFactory()
	{
	}
	
	public static Customer CreateCustomer(JSONObject i_Customer) throws CreateCustomerException
	{
		Customer result;
		
		try
		{
			if(i_Customer.getString("type").equals("NewCustomer"))
				result = new NewCustomer(i_Customer);
			else if(i_Customer.getString("type").equals("ReturnedCustomer"))
				result = new ReturnedCustomer(i_Customer);
			else if(i_Customer.getString("type").equals("VipCustomer"))
				result = new VipCustomer(i_Customer);
			else
				throw new CreateCustomerException(i_Customer);
		}
		catch(Exception ex)
		{
			throw new CreateCustomerException(ex.getMessage());
		}
		
		return result;
	}
}
