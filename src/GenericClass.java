
public class GenericClass {
	
	public Object createInstance(Object[] obj, String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class objClass = Class.forName(className);
		Object object = objClass.newInstance();
		
		return objClass;
	}
}

interface EmpSuperClass{
	
}
