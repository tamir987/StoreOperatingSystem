package Workers;

import org.json.JSONObject;
import Person.NotFoundException;

public class WorkerFactory{
	
	private WorkerFactory(){}
	
	public static Worker CreateWorker(JSONObject i_Worker) throws CreateWorkerException{
		Worker result;
		
		try{
			if(i_Worker.getString("type").equals("ShiftManager"))
				result = new ShiftManager(i_Worker);
			else if(i_Worker.getString("type").equals("Seller"))
				result = new Seller(i_Worker);
			else if(i_Worker.getString("type").equals("Cashier"))
				result = new Cashier(i_Worker);
			else
				throw new NotFoundException("Type wasnt found");
		}
		catch(Exception ex){
			throw new CreateWorkerException(ex.getMessage());
		}
		
		return result;
	}
}//end of WorkerFactory