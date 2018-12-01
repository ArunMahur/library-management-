import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class GetValue 
{
	public static Vector<String>  colNames;
	public static Vector<Vector<String>> records;
	
   public static Vector<String>  getValue(String value)
   {
	   Vector<String> vector=new Vector<>();
	   Connection con=DBInfo.con;
	   String query="select name from "+value+" order by name";
	   try
	   {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			  vector.add(res.getString(1));
		  }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   return vector;
	   
   }
	
   public static void searchAllValues()
   {
	   colNames=new Vector<>();
	   records=new Vector<>();
	   
	   Connection con=DBInfo.con;
	   String query="select * from book";
	   try
	   {
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  ResultSet res=ps.executeQuery();
		  
		  //fetching metadata
		  ResultSetMetaData rsmd=res.getMetaData();
		  int count=rsmd.getColumnCount();
		  for(int i=1;i<=count;i++)
		  {
		       colNames.add(rsmd.getColumnName(i));	  
		  }
		  
		  //fetching records
		  while(res.next())
		  {
			Vector<String> inner=new Vector<>();
			for(int i=1;i<=count;i++)
			{
				inner.add(res.getString(i));
				
			}
			  records.add(inner);
		  }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
    
   public static void searchValuesBy(String col,String value)
   {
	   colNames=new Vector<>();
	   records=new Vector<>();
	   
	   Connection con=DBInfo.con;
	   String query="select * from book where "+col+"=?";
	   System.out.println(query);
	   try
	   {
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1, value);
		  ResultSet res=ps.executeQuery();
		  
		  //fetching metadata
		  ResultSetMetaData rsmd=res.getMetaData();
		  int count=rsmd.getColumnCount();
		  for(int i=1;i<=count;i++)
		  {
		       colNames.add(rsmd.getColumnName(i));	  
		  }
		  
		  //fetching records
		  while(res.next())
		  {
			Vector<String> inner=new Vector<>();
			for(int i=1;i<=count;i++)
			{
				inner.add(res.getString(i));
				
			}
			  records.add(inner);
		  }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }


}
