package tyt;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;






@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class CalculationService {

	
	
	
public CalculationService() {
		
	}



@Inject
private CalcDB DB;


	@GET
	@Path("calculations")
	public  List <Calculation> GetAll()
	{
        return  DB.SelectAll();
	}

	
	
	
	@POST
	@Path("calc")
	public Result saveoperation(Calculation calc)
	{
		int result = 0  ;
		if(calc.getOperation().equals("+"))
		{
			
			result=   calc.getNumber1()+calc.getNumber2();
		}
		else if(calc.getOperation().equals("-"))
		{
			
			result=  calc.getNumber1()-calc.getNumber2();
			
		}
		else if(calc.getOperation().equals("*"))
		{
			
			result=   calc.getNumber1()*calc.getNumber2();
			
		}
		else if(calc.getOperation().equals("/"))
		{
			if(calc.getNumber2()==0)
			{
				throw new IllegalArgumentException("second number is zero");
			}else {
				result=   calc.getNumber1()/calc.getNumber2();
			}
				
		}
		else
		{
			System.out.print("operation not found");
		}
		
		
		DB.insert(calc);
		
		return new Result(result);
		
		
	}
	
	
	
	
	
	
}